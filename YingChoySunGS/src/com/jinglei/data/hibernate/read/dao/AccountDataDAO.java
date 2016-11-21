package com.jinglei.data.hibernate.read.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.jinglei.data.hibernate.HibernateManagement;
import com.jinglei.data.hibernate.read.account_data;
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
	        session = HibernateManagement.getInstance().getSession("read_db");
	        if ( session != null ) {	
	        	session.beginTransaction();
	        	
	        	String hql = String.format("call msp_server_login('%s')", account);
	        	
	        	/*
	        	 *call msp_server_login('這邊塞帳號');
	        	 * 			Query query = session.createQuery("call msp_server_login(':account_id')").addEntity(account_db.class);
	        	 * 			query.setParameter("account_id", account);
	        	 * 			query.setCacheable(true);
	        	 * 			List<account_db> results = query.list();
	        	 */
	        		Query query = session.createSQLQuery(hql).addEntity(account_data.class);
	        		
	        		account_data   finddata = (account_data) query.uniqueResult();
	        		
	        		if ( finddata != null) {
	        			return finddata;
	        		}
	        	session.beginTransaction().commit();
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
        }
    }	    
}
