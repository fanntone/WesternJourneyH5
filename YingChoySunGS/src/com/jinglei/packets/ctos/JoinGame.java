package com.jinglei.packets.ctos;

import com.jinglei.server.logic.JSONBean;

/**
 * <pre>
 * 	Class Name  : 			JoinGame
 * 	Description :           C->S 登入遊戲 Server 封包
 *  Request 	:			JoinGame
 *  Responses	:			JoinGameResult
 * 	Modification Information
 * 						Account    		String  	玩家帳號
 * 						PassWord   		String  	玩家密碼
 *
 * 
 *
 * </pre>
 *
 * @author Bear Wu
 * @since 2016. 11. 18.
 * @version 
 *
 */
public class JoinGame implements JSONBean {

	/*
	 * JSON Name
	 */
	//public String Name = new String("JoinGame");
	
	/*
	 * (non-Javadoc)
	 * @see com.jinglei.server.logic.JSONBean#getName()
	 */
	@Override
	public String getName() {
		//return new String(this.getClass().getName());
		return new String("JoinGame");
	}
	
	/*
	 * 玩家  登入帳號
	 */
	String    Account = new String("");
	
	public String getAccount() {
		return this.Account;
	}
	
	public void setAccount(String account) {
		 this.Account = account;
	}	
	
	/*
	 * 玩家  登入密碼
	 */
	String    PassWord = new String("");
	
	public String getPassWord() {
		return this.PassWord;
	}
	
	public void setPassWord(String password) {
		 this.PassWord = password;
	}
	
	/*
	 * 		JoinGame construct
	 * 			Account    String 玩家帳號
	 * 			PassWord   String 玩家密碼
	 * 			BetRange   int  選擇押注區(目前填入1即可)
	 */	
	public JoinGame(String account,String password) {
		this.Account  = account;
		this.PassWord = password;
	}
	
	/*
	 * 		JoinGame construct
	 */	
	public JoinGame() {
	}

}
