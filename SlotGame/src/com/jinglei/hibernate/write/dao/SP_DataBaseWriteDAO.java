package com.jinglei.hibernate.write.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.jinglei.hibernate.HibernateManagement;
import com.jinglei.hibernate.write.SP_Result;

import com.jinglei.game.SysLog;

public class SP_DataBaseWriteDAO {
	
	/*
	 *  SP_DataBaseWriteDAO Instance
	 */
	private static SP_DataBaseWriteDAO   instance = null;
	
	/*
	 *   SP_DataBaseWriteDAO construct
	 */
	
	private SP_DataBaseWriteDAO() {		

	}
	
	/*
	 *  取得 SP_DataBaseWriteDAO  Instance
	 */
	public static synchronized SP_DataBaseWriteDAO getInstance()  {
        if (instance == null) {
        	instance = new SP_DataBaseWriteDAO();
        }

        return instance;
    }
	
	/*
	 *   Server 改變玩家在線狀態   
	 *   @param  	arg1	Integer nember_id ->Account memberID
	 *   			arg2	Integer game_id   ->Account 玩家在線狀態（不在線為0）
	 *   @return    SP_online_type_change	Result  資料
	 */
	public static SP_Result SP_OnlineTypeChange(Integer nember_id,Integer game_id) {
        Session session = null;
        try {        		
	        session = HibernateManagement.getInstance().getSession("write_db");
	        if ( session != null ) {	
	        	session.beginTransaction();
	        	
	        	String hql = String.format("call msp_online_type_change(%d,%d)", nember_id,game_id);
	        	
	        	/*
	        	 *call msp_online_type_change(1,2);
	        	 */
	        		SQLQuery query = session.createSQLQuery(hql);
	        		
	        		List<?>  query_data = query.list();
	        		
	        		SysLog.PrintError(String.format("[SP_OnlineTypeChange]  query Data:%s....Succes!!",query_data.toString()));
	        		
	        		if ( query_data != null && !query_data.isEmpty()) {
	        			SysLog.PrintError(String.format("[SP_OnlineTypeChange]  List Size:%d....Succes!!",query_data.size()));
	        			
	        			//Object[] object = (Object[])query_data.get(0);	        			

	        			/*
	        			 * account_data Construction
	        			 * @param arg1  Integer 		result    Stored Procedure(SP) 回傳結果

	        			 *
		        		 *	public public SP_Result(Integer res) {
						 *		this.result = res;
						 *	}
		        		 *
		        		 */	        			
	        			//SP_Result   rtndata = new SP_Result(Integer.valueOf(object[0].toString()));  
	        			SP_Result   rtndata = new SP_Result(1);    
	        		

	        			if ( rtndata != null ) {
	        				return rtndata;
	        			}
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
	
	/*
	 *  Server 玩家密碼錯誤次數增加   
	 *   @param  		Integer nember_id ->Account memberID
	 *   @return    SP_online_type_change	Result  資料
	 */
	public static SP_Result SP_PasswordError(Integer nember_id) {
        Session session = null;
        try {        		
	        session = HibernateManagement.getInstance().getSession("write_db");
	        if ( session != null ) {	
	        	session.beginTransaction();
	        	
	        	String hql = String.format("call msp_passworderror_add(%d)", nember_id);
	        	
	        	/*
	        	 *call msp_passworderror_add(%d);
	        	 */
	        		SQLQuery query = session.createSQLQuery(hql);
	        		
	        		List<?>  query_data = query.list();
	        		
	        		SysLog.PrintError(String.format("[SP_PasswordError]  query Data:%s....Succes!!",query_data.toString()));
	        		
	        		if ( query_data != null && !query_data.isEmpty()) {
	        			SysLog.PrintError(String.format("[SP_PasswordError]  List Size:%d....Succes!!",query_data.size()));
	        			
	        			Object[] object = (Object[])query_data.get(0);	        			

	        			/*
	        			 * account_data Construction
	        			 * @param arg1  Integer 		result    Stored Procedure(SP) 回傳結果

	        			 *
		        		 *	public public SP_Result(Integer res) {
						 *		this.result = res;
						 *	}
		        		 *
		        		 */	        			
	        			SP_Result   rtndata = new SP_Result(Integer.valueOf(object[0].toString()));        			
	        		

	        			if ( rtndata != null ) {
	        				return rtndata;
	        			}
	        		}
	        	session.beginTransaction().commit();
	        }
	        	
	        return null;
        } 
        catch (Exception e) {
            e.printStackTrace();
			SysLog.PrintError("unknow exception in [SP_PasswordError(Integer nember_id)]: "+ e.getMessage() +" ");
            return null;
        } 
        finally {
        	if ( session != null ) {
        		session.close();
        	}
        }
    }	
	
	/*
	 *  Server 玩家密碼錯誤次數歸零  
	 *   @param  		Integer nember_id ->Account memberID
	 *   @return    SP_online_type_change	Result  資料
	 */
	public static SP_Result SP_PasswordErrorReset(Integer nember_id) {
        Session session = null;
        try {        		
	        session = HibernateManagement.getInstance().getSession("write_db");
	        if ( session != null ) {	
	        	session.beginTransaction();
	        	
	        	String hql = String.format("call msp_passworderror_reset(%d)", nember_id);
	        	
	        	/*
	        	 *call msp_passworderror_reset(%d);
	        	 */
		        	SQLQuery query = session.createSQLQuery(hql);
	        		
	        		List<?>  query_data = query.list();
	        		
	        		SysLog.PrintError(String.format("[SP_PasswordErrorReset]  query Data:%s....Succes!!",query_data.toString()));
	        		
	        		if ( query_data != null && !query_data.isEmpty()) {
	        			SysLog.PrintError(String.format("[SP_PasswordErrorReset]  List Size:%d....Succes!!",query_data.size()));
	        			
	        			Object[] object = (Object[])query_data.get(0);	        			
	
	        			/*
	        			 * account_data Construction
	        			 * @param arg1  Integer 		result    Stored Procedure(SP) 回傳結果
	
	        			 *
		        		 *	public public SP_Result(Integer res) {
						 *		this.result = res;
						 *	}
		        		 *
		        		 */	        			
	        			SP_Result   rtndata = new SP_Result(Integer.valueOf(object[0].toString()));        			
	        		
	
	        			if ( rtndata != null ) {
	        				return rtndata;
	        			}
	        		}    
	        	session.beginTransaction().commit();
	        }
	        	
	        return null;
        } 
        catch (Exception e) {
            e.printStackTrace();
			SysLog.PrintError("unknow exception in [SP_PasswordErrorReset(Integer nember_id)]: "+ e.getMessage() +" ");
            return null;
        } 
        finally {
        	if ( session != null ) {
        		session.close();
        	}
        }
    }
	
	/*
	 *  Server 寫入玩家賽果
	 *   @param  	arg1	Integer nember_id 	-> 玩家唯一碼
	 *   			arg2	Integer game_id 	-> 遊戲編號
	 *   			arg3	String  table_no	-> 桌號 VARCHAR(20)
	 *   			arg4	Integer bet_point 	-> 下注點數
	 *   			arg5	Integer win_point	-> 輸贏點數
	 *   			arg6	Integer earm_point	-> 淨賺點數
	 *   			arg7	Integer lottery_mode 	-> 彩金模式 沒有中彩金即為0
	 *   			arg8	Integer lotter_point ->彩金點數
	 *   			arg9	Integer before_point ->此賽果前玩家點數
	 *   			arg10	Integer after_point  ->此賽果後玩家點數
	 *   			arg11	Integer round_number ->局號
	 *   			arg12	String json_data 	 ->詳細下注紀錄  VARCHAR(400)  JSON
	 *   
	 *   @return    SP_online_type_change	Result  資料
	 */
	public static SP_Result SP_RecordTempAdd(Integer nember_id,
										     Integer game_id,
										     String table_no,
											 Integer bet_point,
											 Integer win_point,
											 Integer earm_point,
											 Integer lottery_mode,
											 Integer lotter_point,
											 Integer before_point,
											 Integer after_point,
											 Integer round_number,
											 String json_data) {
        Session session = null;
        try {        		
	        session = HibernateManagement.getInstance().getSession("write_db");
	        if ( session != null ) {	
	        	session.beginTransaction();
	        	
	        	String hql = String.format("call msp_record_temp_add(%d,%d,%s,%d,%d,%d,%d,%d,%d,%d,%d,%s)", 
	        								nember_id,
	        								game_id,
	        								table_no,
	        								bet_point,
	        								win_point,
	        								earm_point,
	        								lottery_mode,
	        								lotter_point,
	        								before_point,
	        								after_point,
	        								round_number,
	        								json_data);
	        																								
	        	
	        	/*
	        	 *call msp_passworderror_reset(%d);
	        	 */
		        	SQLQuery query = session.createSQLQuery(hql);
	        		
	        		List<?>  query_data = query.list();
	        		
	        		SysLog.PrintError(String.format("[SP_RecordTempAdd]  query Data:%s....Succes!!",query_data.toString()));
	        		
	        		if ( query_data != null && !query_data.isEmpty()) {
	        			SysLog.PrintError(String.format("[SP_RecordTempAdd]  List Size:%d....Succes!!",query_data.size()));
	        			
	        			Object[] object = (Object[])query_data.get(0);	        			
	
	        			/*
	        			 * account_data Construction
	        			 * @param arg1  Integer 		result    Stored Procedure(SP) 回傳結果
	
	        			 *
		        		 *	public public SP_Result(Integer res) {
						 *		this.result = res;
						 *	}
		        		 *
		        		 */	        			
	        			SP_Result   rtndata = new SP_Result(Integer.valueOf(object[0].toString()));        			
	        		
	
	        			if ( rtndata != null ) {
	        				return rtndata;
	        			}
	        		}    
	        	session.beginTransaction().commit();
	        }
	        	
	        return null;
        } 
        catch (Exception e) {
            e.printStackTrace();
			SysLog.PrintError("unknow exception in [SP_RecordTempAdd(...)]: "+ e.getMessage() +" ");
            return null;
        } 
        finally {
        	if ( session != null ) {
        		session.close();
        	}
        }
    }

}
