package com.jinglei.hibernate.read.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import com.jinglei.hibernate.HibernateManagement;
import com.jinglei.hibernate.read.account_data;
import com.jinglei.hibernate.read.member_points;
import com.jinglei.game.SysLog;


/*
 *  Create Data Access Object
 *  建立 資料 執行 物件   account_db.account_data
 *  新增/刪除/修改/更新
 *  @author Bear wu
 */
/*
 * 處理產生 玩家基本資料
 * Create Data Access Object
 * @title   				AccountDataDAO
 * @						建立 資料 執行 物件 account_db.account_data
 * @						新增/刪除/修改/更新
 * @
 * @mapping					com.auer.hibernate.game.user_data.java
 * @
 * @description 			Hibermate OR-M 處理產生 玩家推圖記錄
 * @
 * @Table					1. account_sid[Key]				BIGINT			玩家帳號編號 參照 account_db.account_data.account_sid
 * @						2. account_id	            	varchar[64]     玩家帳號      參照 account_db.account_data.account_id
 * @						3. password						varchar[64] 	玩家密碼      參照 account_db.account_data.password
 * @						4. bind_type					int	                                    綁定方式 0:未綁定 1:FB 2:Google 3:其它     
 * @						5. bind_access_id				varchar[64]   	綁定時 FB:ID....Google+:ID....
 * @						6. bind_access_token			varchar[256]    綁定 SNS access_token
 * @						7. bind_info					varchar[64]     綁定資訊
 * @						8. email						varchar[64]		電子信箱
 * @						9. create_game_sid				int				註冊的遊戲編號  參照 game_info.game_sid
 * @					   10. create_device_sid			int				註冊時的裝置碼
 * @					   11. create_date					DateTime        玩家創立時間
 * @
 * @author Bear Wu 2015.12.09
 */
public class AccountDataDAO {
	
	/*
	 *  AccountDataDAO Instance
	 */
	private static AccountDataDAO   instance = null;
	
	/*
	 *   玩家基本資料
	 */
	
	private AccountDataDAO() {		

	}
	
	/*
	 *  取得 UserDataDAO  Instance
	 */
	public static synchronized AccountDataDAO getInstance()  {
        if (instance == null) {
        	instance = new AccountDataDAO();
        }

        return instance;
    }

	
	/*
	 *   找尋單一玩家   
	 *   @param		String 			account ->帳號 登入 Account
	 *   @return    account_data	帳號資料
	 */
	public static account_data findAccountData(String account) {
        Session session = null;
        try {    
        	SysLog.PrintError(String.format("[AccountDataDAO] findAccountData....Begin!!"));
	        session = HibernateManagement.getInstance().getSession("read_db");
	        if ( session != null ) {	
	        	session.beginTransaction();
	        	
	        	String hql = String.format("call msp_server_login('%s')", account);
	        	
	        	SysLog.PrintError(String.format("[AccountDataDAO] Check Query:【%s】....!!",hql));
	        	
	        	/*
	        	 *call msp_server_login('這邊塞帳號');
	        	 * 			Query query = session.createQuery("call msp_server_login(':account_id')").addEntity(account_db.class);
	        	 * 			query.setParameter("account_id", account);
	        	 * 			query.setCacheable(true);
	        	 * 			List<account_db> results = query.list();
	        	 */
	        		SQLQuery query = session.createSQLQuery(hql);
	        		
	        		//Query query = session.createSQLQuery(hql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP); 
	        		
	        		List<?>  query_data = query.list();
	        		
	        		SysLog.PrintError(String.format("[AccountDataDAO]  query Data:%s....Succes!!",query_data.toString()));
	        		
	        		if ( query_data != null && !query_data.isEmpty()) {
	        			SysLog.PrintError(String.format("[AccountDataDAO]  List Size:%d....Succes!!",query_data.size()));
	        			
	        			Object[] object = (Object[])query_data.get(0);	        			

	        			/*
	        			 * account_data Construction
	        			 * @param arg1  Integer 		memberID    玩家唯一碼
	        			 * @param arg2  Integer     	currencyID  玩家幣別
	        			 * @param arg3  String 			account		varchar(30) 玩家帳號
	        			 * @param arg4  String 			nickname	varchar(30) 玩家暱稱（UTF-8）
	        			 * @param arg5  String 			pass		varchar(50) 玩家密碼
	        			 * @param arg6  Integer     	errorcount  密碼錯誤次數（預設連續錯誤6次不得登入）
	        			 * @param arg7  Integer 		points		玩家現有點數（已乘100的正整數）
	        			 * @param arg8  Integer 		gameID		玩家在線狀態（不在線為0）
	        			 * @param arg9  Boolean 		useinfo		帳號是否可用（0：不可用、1：可用）
	        			 * @param arg10 Integer 		languageID	玩家所使用的語言
	        			 * @param arg11 Integer 		equipmentID	玩家所使用的裝置
	        			 * @param arg12 String 			ip			varchar(20) 玩家的IP位置
	        			 *
		        		 *	public account_data(Integer member_id,Integer currency_id,
		        		 *						String  account_name,String nick_name,String pass_word,
		        		 *						Integer error_count,Integer point,
		        		 *						Integer game_id,Boolean use_info,
		        		 *						Integer language_id,Integer equipment_id,
		        		 *						String  ip_address)
		        		 *
		        		 *  String -> Integer  	Integer.valueOf(String);
		        		 *  String -> Boolean   Boolean.valueOf(String);
		        		 */	        			
	        			account_data   rtndata = new account_data(Integer.valueOf(object[0].toString()),Integer.valueOf(object[1].toString()),
																  object[2].toString(),object[3].toString(),object[4].toString(),
																  Integer.valueOf(object[5].toString()),Integer.valueOf(object[6].toString()),
																  Integer.valueOf(object[7].toString()),Boolean.valueOf(object[8].toString()),
																  Integer.valueOf(object[9].toString()),Integer.valueOf(object[10].toString()),
																  object[11].toString());        			
	        		

	        			if ( rtndata != null ) {
	        				return rtndata;
	        			}
	        		}
	        	session.beginTransaction().commit();
	        }
	        else {
	        	SysLog.PrintError(String.format("[AccountDataDAO]  Error session is NULL....Failure!!"));
	        }
	        	
	        return null;
        } 
        catch (Exception e) {
            e.printStackTrace();
			SysLog.PrintError("unknow exception in [findAccountData(String account)]: "+ e.getMessage() +" ");
            return null;
        } 
        finally {
        	if ( session != null ) {
        		session.close();
        	}
        	SysLog.PrintError(String.format("[AccountDataDAO] findAccountData....Endded!!"));
        }
    }	    
	
	/*
	 *   找尋單一玩家   
	 *   @param		String 			account ->帳號 登入 Account
	 *   @return    account_data	帳號資料
	 */
	public static member_points findMemberHavePoints(Integer member_id) {
        Session session = null;
        try {    
        	SysLog.PrintError(String.format("[AccountDataDAO] findMemberHavePoints....Begin!!"));
	        session = HibernateManagement.getInstance().getSession("read_db");
	        if ( session != null ) {	
	        	session.beginTransaction();
	        	
	        	String hql = String.format("call msp_server_points('%d')", member_id);
	        	
	        	SysLog.PrintError(String.format("[AccountDataDAO] Check Query:【%s】....!!",hql));
	        	
	        	/*
	        	 *call msp_server_points(這邊塞玩家唯一碼);
	        	 * 			Query query = session.createQuery("call msp_server_login(':member_id')");
	        	 * 			query.setParameter("member_id", memberid);
	        	 * 			query.setCacheable(true);
	        	 * 			List<member_points> results = query.list();
	        	 */
	        		SQLQuery query = session.createSQLQuery(hql);        		
	        		List<?>  query_data = query.list();
	        		
	        		SysLog.PrintError(String.format("[AccountDataDAO]  query Data:%s....Succes!!",query_data.toString()));
	        		
	        		if ( query_data != null && !query_data.isEmpty()) {
	        			SysLog.PrintError(String.format("[AccountDataDAO]  List Size:%d....Succes!!",query_data.size()));
	        			
	        			Object[] object = (Object[])query_data.get(0);	        			

	        			/*
	        			 * account_data Construction
	        			 * @param arg1  Integer 		memberID    玩家唯一碼
	        			 * @param arg2  Integer     	point 		玩家現有點數
	        			 *
		        		 *	public member_points(Integer member_id,Integer currency_id)
		        		 *
		        		 *  String -> Integer  	Integer.valueOf(String);
		        		 *  String -> Boolean   Boolean.valueOf(String);
		        		 */	        			
	        			member_points   rtnData = new member_points(Integer.valueOf(object[0].toString()),
	        														Integer.valueOf(object[1].toString()));        			
	        		

	        			if ( rtnData != null ) {
	        				return rtnData;
	        			}
	        		}
	        	session.beginTransaction().commit();
	        }
	        else {
	        	SysLog.PrintError(String.format("[AccountDataDAO]  Error session is NULL....Failure!!"));
	        }
	        	
	        return null;
        } 
        catch (Exception e) {
            e.printStackTrace();
			SysLog.PrintError("unknow exception in [findAccountData(String account)]: "+ e.getMessage() +" ");
            return null;
        } 
        finally {
        	if ( session != null ) {
        		session.close();
        	}
        	SysLog.PrintError(String.format("[AccountDataDAO] findAccountData....Endded!!"));
        }
    }	    
}
