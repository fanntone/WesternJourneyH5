package com.jinglei.data.hibernate.write.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.jinglei.data.hibernate.HibernateManagement;
import com.jinglei.data.hibernate.write.SP_PlayerPointsUpdate;
import com.jinglei.game.SysLog;

public class SP_PlayerPointUpdateDAO {
	
	/*
	 *  SP_PlayerPointUpdateDAO Instance
	 */
	private static SP_PlayerPointUpdateDAO   instance = null;
	
	/*
	 *   玩家基本資料
	 */
	
	private SP_PlayerPointUpdateDAO() {		

	}
	
	/*
	 *  取得 SP_PlayerPointUpdateDAO  Instance
	 */
	public static synchronized SP_PlayerPointUpdateDAO getInstance()  {
        if (instance == null) {
        	instance = new SP_PlayerPointUpdateDAO();
        }

        return instance;
    }
	
	/*
	 *   Server 改變玩家在線狀態   
	 *   Stored Procedure : call msp_points_change(1,2)
	 *   @param  	arg1	Integer nember_id ->Account memberID
	 *   			arg2	Integer points    ->要更改的點數  正：增加點數、減：扣除點數
	 *   @return   SP_PlayerPointsUpdate	Result  資料
	 */
	public static SP_PlayerPointsUpdate SP_PointsChange(Integer nember_id,Integer points) {
        Session session = null;
        try {        		
	        session = HibernateManagement.getInstance().getSession("write_db");
	        if ( session != null ) {	
	        	session.beginTransaction();
	        	
	        	String hql = String.format("call msp_points_change(%d,%d)", nember_id,points);
	        	
	        	/*
	        	 *call call msp_points_change(1,2);
	        	 */
	        		Query query = session.createSQLQuery(hql).addEntity(SP_PlayerPointsUpdate.class);
	        		
	        		SP_PlayerPointsUpdate   finddata = (SP_PlayerPointsUpdate) query.uniqueResult();
	        		
	        		if ( finddata != null) {
	        			return finddata;
	        		}
	        	session.beginTransaction().commit();
	        }
	        	
	        return null;
        } 
        catch (Exception e) {
            e.printStackTrace();
			SysLog.PrintError("unknow exception in [SP_OnlineTypeChange(Integer nember_id,Integer game_id)]: "+ e.getMessage() +" ");
            return null;
        } 
        finally {
        	if ( session != null ) {
        		session.close();
        	}
        }
    }	   

}
