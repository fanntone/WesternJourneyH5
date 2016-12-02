package com.jinglei.hibernate;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

import org.hibernate.Session;

import com.jinglei.game.SysLog;
//import com.jinglei.game.util.UtilString;


/** Hibernate 基本配置
 * Create HibernateConnector.java,from which we are getting Hibernate session and doing basic configurations.
 *
 * @author Bear wu
 */
public class HibernateManagement {
	
	/*
	 * Hibernate Mangement Instance
	 */
	private static HibernateManagement   instance = null;
	
	/*
	 *   HashMap<String, HibernateAdapter>    key->資料庫名稱    HibernateAdapter->OR-M 
	 *   @note ConcurrentHashMap 是一個執行緒安全的 Hash Table ，它的主要功能是提供了一組和HashTable功能相同
	 *   	        但是執行緒安全的方法。
	 *         ConcurrentHashMap 可以做到讀取資料不加鎖，並且其內部的結構可以其在進行寫入操作的時候能夠將鎖的粒度保持盡量最小，
	 *         不用對整個ConcurrentHashMap加鎖
	 */
	private static  ConcurrentHashMap<String, HibernateAdapter>   mapAdapter = new ConcurrentHashMap<String, HibernateAdapter>();
	
	/*
	 *   Hibernate 設定檔
	 */
	private static final String HIBERNATE_ORM_CONFIG = "hibernate/hibernate";  //"resources/hibernate/hibernate.properties"
	
	/*
	 *    取得設定檔
	 */
	private static  ResourceBundle  rbHibernate = null;
	
	/*
	 * HibernateManagement Construction
	 */
	private HibernateManagement() {
		
		if ( initHibernateConfig() ) {	
			// 初始 DAO 資料
			initDataAccessObject();
			SysLog.PrintError("[Success] HibernateManagement 初始化成功....Success!!!");
		}
		else {
			SysLog.PrintError("[Failure] HibernateManagement 初始化失敗....Failure!!!");				
		}		
	}
	
	/*
	 *  取得 Hibernate Management Instance
	 */
	public static synchronized HibernateManagement getInstance()  {
        if (instance == null) {
        	instance = new HibernateManagement();
        }

        return instance;
    }
	
	/**
	 * Initial hibernate.properties  ResourceBundle OR-M 設定值會用到
	 * 
	 */
	private static boolean initHibernateConfig() {
		try
	    {
			rbHibernate = ResourceBundle.getBundle(HibernateManagement.HIBERNATE_ORM_CONFIG);
			if ( rbHibernate != null ) {
				Enumeration<String> enumeration = rbHibernate.getKeys();
				
			   while (enumeration.hasMoreElements()) {
				   String key = enumeration.nextElement();
				   String value = rbHibernate.getString(key);
				   SysLog.PrintError(String.format("[initHibernateConfig] While-Loop Key:〔%s〕 ,Value:【%s】....Checking!!!",key,value));
				   HibernateAdapter  adapter = new HibernateAdapter(value);
				   if ( adapter != null ) {
					   mapAdapter.put(key, adapter);
				   }
			   }
			}
			else {
				SysLog.PrintError("[Failure] 讀取  hibernate.properties 檔失敗...Failure!!!");
			}
	    }
	    catch (MissingResourceException e)
	    {
	    	SysLog.PrintError("[Failure] HibernateManagement.initHibernateConfig() error!! Message = "+e.getMessage());
		    return false;
	    }			
		
		return true;
	}
	
	/*
	 *  初始  Data Access Object
	 */
	public void initDataAccessObject() {
	
	}
	
	/*
	 *  取得 資料庫連線器
	 *  @param		String   			db_name -> 資料庫名稱
	 *  @return     HibernateAdapter	連線器
	 */
	public static HibernateAdapter getHibernateAdapter(String db_name) {
		if ( HibernateManagement.mapAdapter.size() >= 1 ) {
			if ( HibernateManagement.mapAdapter.containsKey(db_name)) {
				return HibernateManagement.mapAdapter.get(db_name);
			}			
		}
		
		return null;		
	}
	
	/*
	 *  取得 資料庫連線
	 *  @param		String   			db_name -> 資料庫名稱
	 *  @return     Session				連線
	 */
	public synchronized Session getSession(String db_name) {
		if ( HibernateManagement.mapAdapter.size() >= 1 ) {
			if ( HibernateManagement.mapAdapter.containsKey(db_name)) {
				/*
				 * 先判斷連線是右存在
				 * isConnected == true 連線中  就將 Session 
				 */
//				if (HibernateManagement.mapAdapter.get(db_name).getSession().isConnected() ) {
//					return HibernateManagement.mapAdapter.get(db_name).getSession();
//				}

				/*
				 * 未連線 中 重新連線
				 * 每次都重連 重取
				 */
				if (HibernateManagement.reConnect(db_name)) {
					return HibernateManagement.mapAdapter.get(db_name).getSession();				
				}
			}			
		}
		
		return null;		
	}
	
	/*
	 *  重新 資料庫連線
	 *  @param		String   			db_name -> 資料庫名稱
	 *  @return     boolean				重新連線是否成功
	 */
	public synchronized static boolean reConnect(String db_name) {
		if ( HibernateManagement.mapAdapter.size() >= 1 ) {
			if ( HibernateManagement.mapAdapter.containsKey(db_name)) {
				HibernateManagement.mapAdapter.get(db_name).reconnect();
				return HibernateManagement.mapAdapter.get(db_name).getSession().isConnected();				
			}			
		}	
		
		return false;		
	}
	
	/*
	 *  重新 資料庫連線
	 *  @param		String   			db_name -> 資料庫名稱
	 *  @return     Session				重新連線是否成功
	 */
	public synchronized Session reSession(String db_name) {
		if ( HibernateManagement.mapAdapter.size() >= 1 ) {
			if ( HibernateManagement.mapAdapter.containsKey(db_name)) {
				HibernateManagement.mapAdapter.get(db_name).reconnect();
				if ( HibernateManagement.mapAdapter.get(db_name).getSession().isConnected()) {
					return HibernateManagement.mapAdapter.get(db_name).getSession();					
				}		
			}			
		}	
		
		return null;		
	}	
	
	/*
	 *  斷掉連線 
	 */
	public synchronized void ShutDown() {  		
		if ( !HibernateManagement.mapAdapter.isEmpty()) {
			Iterator<Entry<String, HibernateAdapter>> entries = HibernateManagement.mapAdapter.entrySet().iterator();
			while (entries.hasNext()) {
				Entry<String, HibernateAdapter> entry = (Entry<String, HibernateAdapter>) entries.next();
				if ( entry != null ) {
				    HibernateAdapter value = entry.getValue();
				    if ( value != null ) {
				    	value.shutdown();
				    }
				}
			}			
		}   	
    }
}