package com.jinglei.data.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.jinglei.game.SysLog;



/** Hibernate 基本配置
 * Create HibernateAdapter.java,from which we are getting Hibernate session and doing basic configurations.
 *
 * @author Bear wu
 */
public class HibernateAdapter {
	private volatile Configuration 	configuration			= null;
    private volatile SessionFactory sessionFactory 			= null;
    private volatile String confPath ="hibernate.cfg.xml";
    private volatile StandardServiceRegistryBuilder builder = null;

    /*
     * @note ConcurrentHashMap 是一個執行緒安全的 Hash Table ，它的主要功能是提供了一組和HashTable功能相同
	 *   	        但是執行緒安全的方法。
	 *         ConcurrentHashMap 可以做到讀取資料不加鎖，並且其內部的結構可以其在進行寫入操作的時候能夠將鎖的粒度保持盡量最小，
	 *         不用對整個ConcurrentHashMap加鎖
     */
    public HibernateAdapter(String config) throws HibernateException {
    	try {
	    	confPath = config;
	
	        // build the config
	    	configuration = new Configuration().configure(confPath);
	        
	        if ( configuration != null ) {	   
	        	builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
	        	this.sessionFactory = configuration.buildSessionFactory();
	        }
	        else {
	        	SysLog.PrintInfo("[Failure] cfg is null...Failure!!!");
	        }
    	}
        catch (Throwable ex) {
        	SysLog.PrintError("Initial SessionFactory creation failed." + ex);
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }	        
    }
    
	private SessionFactory buildSessionFactory() {
		try {
			if ( confPath != null && !confPath.equals("")) {	
		        // build the config
		    	configuration = new Configuration().configure(confPath);
		        
		        if ( configuration != null ) {	   
		        	builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		        	this.sessionFactory = configuration.buildSessionFactory();
		        }
		        else {
		        	SysLog.PrintInfo("[Failure] cfg is null...Failure!!!");
		        }
		        
		        return this.sessionFactory;
			}
			
			return null;
    	}
        catch (Throwable ex) {
        	SysLog.PrintError("Initial SessionFactory creation failed." + ex);
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }	     
    }

    //@brief synchronized 同步鎖
    public synchronized Session getSession() throws HibernateException {
    	if ( this.sessionFactory == null ) {
    		buildSessionFactory();
    		
    		if (this.sessionFactory == null ) {
    			return null;
    		}
    	}
    	
        Session session = this.sessionFactory.openSession();
        if (!session.isConnected()) {
            this.reconnect();
        }
        return session;
    }
    
    public  synchronized SessionFactory getSessionFactory() {
    	
    	if (this.sessionFactory == null ) {
			return null;
		}
    	
        return this.sessionFactory;
    }

    //@brief synchronized 同步鎖
    public synchronized void reconnect() throws HibernateException {
    	this.configuration 	= null;
    	this.builder 		= null;
    	this.sessionFactory = null;
    	
    	this.configuration = new Configuration().configure(confPath);
    	
        if ( this.configuration != null ) {	   
        	this.builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        	this.sessionFactory = configuration.buildSessionFactory();
        }
        else {
        	SysLog.PrintInfo("[Failure] cfg is null...Failure!!!");
        }
    }
    
    public synchronized void shutdown() {    	
    	if ( this.sessionFactory != null) {
    		this.sessionFactory.close();    		
    	}    	
    }
}
