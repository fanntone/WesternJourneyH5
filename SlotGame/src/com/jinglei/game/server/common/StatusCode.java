package com.jinglei.game.server.common;

/**
 * StatusCode 系統狀態碼
 * @author Bear Wu on 2016.11.15
 */
public enum StatusCode {
	Success(1, "Success"),												// 成功，邏輯無誤 封包正常收送
	Failure(0, "Failure"),												// 失敗，通用預設
	Unknown_Error(-1, "Unknown error"),									// 未知的錯誤
	Server_Maintenance(-2, "Server maintenance"),						// 伺服器維護中
	Server_Full(-3, "The number of players in the server is full"),		// 伺服器人數已滿
	Database_Error(-4, "Database error"),								// 資料庫錯誤
	Database_Syntax_Incorrect(-5, "Database syntax incorrect"),			// 資料庫語法錯誤
	Database_Unable_Connect(-6, "Unable to connect Database"),			// 資料庫無法連結
	Account_Not_Exist(-7, "The player's account does not exist"),		// 玩家帳號不存在
	Account_Disabled(-8, "Player's account has been disabled"),			// 玩家帳號已停用
	Authentication_Exception(-9, "Player's authentication exception"),	// 驗證異常
	Authentication_Expired(-10, "Player's authentication expired"),		// 驗證過期
	Registration_Failed(-11, "Registration failed"),					// 註冊失敗
	System_Maintenance_Shutdow(-20,"System Maintenance Shutdow"),		// 系統停機維修
	System_Account_Blocked(-21,"Account Blocked");		   				// 帳號封鎖
	
	
	private int statusCode;
	private String msg;

	private StatusCode(int errorCode, String msg)
	{
		this.statusCode = errorCode;
		this.msg = msg;
	}

	public int getCode()
	{
		return this.statusCode;
	}

	public String getMessage()
	{
		return this.msg;
	}

	public String printInfo()
	{
		return String.format("StatusCode(%d) Message: %s", this.statusCode,this.msg);
	}
}
