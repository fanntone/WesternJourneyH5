package com.jinglei.packets.stoc;

import com.jinglei.hibernate.read.account_data;
import com.jinglei.game.server.common.StatusCode;
import com.jinglei.server.logic.JSONBean;


/**
 * <pre>
 * 	Class Name  : 			JoinGameResult
 * 	Description :           S->C 玩家登入後基本資料
 * 	Modification Information
 * 						StateCode		int  	狀態碼
 *						MemberID		int  	玩家唯一碼
 *						CurrencyID		int  	玩家幣別
 *						Account			String 	玩家帳號
 * 						NickName		String 	玩家暱稱
 * 						PassWord		String 	玩家密碼
 * 						ErrorCount		int  	密碼錯誤次數
 * 						Points			int  	玩家現有點數
 * 						GameID			int  	玩家在線狀態
 * 						UseInfo			int  	帳號是否可用
 * 						LanguageID		int		玩家所使用的語言
 * 						EquipmentID		int		玩家所使用的裝置
 *					
 * </pre>
 *
 * @author Bear Wu
 * @since 2016. 11. 18.
 * @version 
 *
 */
public class JoinGameResult implements JSONBean {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return new String("JoinGameResult");
	}
	
	/*
	 *  結果狀態碼
	 *  <=0  錯誤 失敗   
	 *  >= 1 正值->正常
	 */
	public Integer StateCode = -1; 
	
	public Integer getStateCode() {
		return this.StateCode;
	}
	
	public void setStateCode(Integer code) {
		this.StateCode = code;
	}
	
	/*
	 * 玩家唯一碼
	 * MemberID(MySQL 唯一值)
	 */
	public Integer MemberID = 0;
	
	public Integer getMemberID() {
		return this.MemberID;
	}
	
	public void setMemberID(Integer id) {
		this.MemberID = id;
	}
	
	/*
	 *  玩家幣別
	 *  CurrencyID 
	 */
	public Integer CurrencyID = 0;
	
	public Integer getCurrencyID() {
		return this.CurrencyID;
	}
	
	public void setCurrencyID(Integer id) {
		this.CurrencyID = id;
	}
	
	/*
	 *  Account
	 *  玩家帳號
	 */
	public String Account = new String("");
	
	public String getAccount() {
		return this.Account;
	}
	
	public void setAccount(String account) {
		this.Account = account;
	}
	
	/*
	 * NickName
	 * 玩家暱稱
	 */
	public String NickName = new String("");
	
	public String getNickName() {
		return this.NickName;
	}
	
	public void setNickName(String name) {
		this.NickName = name;
	}
	
	/*
	 * PassWord
	 * 玩家密碼
	 */
	public String PassWord = new String("");
	
	public String getPassWord() {
		return this.NickName;
	}
	
	public void setPassWord(String pass) {
		this.PassWord = pass;
	}
	
	/*
	 *  玩家密碼錯誤次數
	 *  ErrorCount 
	 */
	public Integer ErrorCount = 0;
	
	public Integer getErrorCount() {
		return this.ErrorCount;
	}
	
	public void setErrorCount(Integer count) {
		this.ErrorCount = count;
	}	
	
	/*
	 *  玩家現有點數（已乘100的正整數）
	 *  Points
	 */
	public Integer Points = 0;
	
	public Integer getPoints() {
		return this.Points;
	}
	
	public void setPoints(Integer point) {
		this.Points = point;
	}	
	
	/*
	 *  玩家在線狀態（不在線為0）
	 *  GameID
	 */
	public Integer GameID = 0;
	
	public Integer getGameID() {
		return this.GameID;
	}
	
	public void setGameID(Integer id) {
		this.GameID = id;
	}
	
	/*
	 *  帳號是否可用（0：不可用、1：可用）
	 *  UseInfo
	 */
	public Integer UseInfo = 0;
	
	public Integer getUseInfo() {
		return this.UseInfo;
	}
	
	public void setUseInfo(Integer id) {
		this.UseInfo = id;
	}	
	
	/*
	 *  玩家所使用的語言
	 *  LanguageID
	 */
	public Integer LanguageID = 0;
	
	public Integer getLanguageID() {
		return this.LanguageID;
	}
	
	public void setLanguageID(Integer id) {
		this.LanguageID = id;
	}
	
	/*
	 *  玩家所使用的裝置
	 *  EquipmentID
	 */
	public Integer EquipmentID = 0;
	
	public Integer getEquipmentID() {
		return this.EquipmentID;
	}
	
	public void setEquipmentID(Integer id) {
		this.EquipmentID = id;
	}
	
	/*
	 * JoinGameResult construct
	 */
	public JoinGameResult() {
		//super();
	}
	
	/*
	 * JoinGameResult construct
	 * 						StateCode		int  	狀態碼
	 *						MemberID		int  	玩家唯一碼
	 *						CurrencyID		int  	玩家幣別
	 *						Account			String 	玩家帳號
	 * 						NickName		String 	玩家暱稱
	 * 						PassWord		String 	玩家密碼
	 * 						ErrorCount		int  	密碼錯誤次數
	 * 						Points			int  	玩家現有點數
	 * 						GameID			int  	玩家在線狀態
	 * 						UseInfo			int  	帳號是否可用
	 * 						LanguageID		int		玩家所使用的語言
	 * 						EquipmentID		int		玩家所使用的裝置 
	 */
	public JoinGameResult(Integer state_code,Integer member_id,Integer currency_id,
						  String account,String nick_name,String pass_word,
						  Integer err_count,Integer points,Integer game_id,
						  Integer use_info,Integer lang_id,Integer eqi_id) {
		this.StateCode		=	state_code;
		this.MemberID		=	member_id;
		this.CurrencyID		=	currency_id;
		this.Account		=	account;
		this.NickName		=	nick_name;
		this.PassWord		=	pass_word;
		this.ErrorCount		=	err_count;
		this.Points			=	points;
		this.GameID			=	game_id;
		this.UseInfo		=	use_info;
		this.LanguageID		=	lang_id;
		this.EquipmentID	=	eqi_id;
	}
	
	/*
	 * JoinGameResult construct
	 * 						StateCode		int  	狀態碼
	 *						MemberID		int  	玩家唯一碼
	 *						CurrencyID		int  	玩家幣別
	 *						Account			String 	玩家帳號
	 * 						NickName		String 	玩家暱稱
	 * 						PassWord		String 	玩家密碼
	 * 						ErrorCount		int  	密碼錯誤次數
	 * 						Points			int  	玩家現有點數
	 * 						GameID			int  	玩家在線狀態
	 * 						UseInfo			int  	帳號是否可用
	 * 						LanguageID		int		玩家所使用的語言
	 * 						EquipmentID		int		玩家所使用的裝置 
	 */
	public JoinGameResult(account_data data) {
		if ( data != null ) {
			this.StateCode		=	StatusCode.Success.getCode();
			this.MemberID		=	data.getMemberID();
			this.CurrencyID		=	data.getCurrencyID();
			this.Account		=	data.getAccount();
			this.NickName		=	data.getNickName();
			this.PassWord		=	data.getPassWord();
			this.ErrorCount		=	data.getErrorCount();
			this.Points			=	data.getPoints();
			this.GameID			=	data.getGameID();
			this.UseInfo		=	data.getUseInfo() == true ? 1:0;
			this.LanguageID		=	data.getLanguageID();
			this.EquipmentID	=	data.getEquipmentID();
		}
		else {
			this.StateCode		=	StatusCode.Failure.getCode();
		}
	}

}
