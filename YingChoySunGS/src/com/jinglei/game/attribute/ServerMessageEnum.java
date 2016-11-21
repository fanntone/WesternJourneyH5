package com.jinglei.game.attribute;

public enum ServerMessageEnum {
	SME_DISCONNECT(101, "斷線通知"), 
	SME_FAIL_PARSE_PACKET( 102, "封包轉換錯誤"), 
	SME_UNKNOWN_ERROR(103, "伺服器未知錯誤"),
	SME_SYSTEM_CLOSED( 104, "系統關閉中"),
	SME_MAX(999,"Server Message Enum Max");

	private int errorCode;
	private String msg;
	private ServerMessageEnum(int errorCode, String msg)
	{
		this.errorCode = errorCode;
		this.msg = msg;
	}
	
	public int getErrorCode()
	{
		return errorCode;
	}
	
	public String getMessage()
	{
		return msg;
	}
}
