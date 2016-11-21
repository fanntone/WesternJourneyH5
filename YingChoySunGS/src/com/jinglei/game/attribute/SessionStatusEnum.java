package com.jinglei.game.attribute;

/*
 *  SSE_UNKNOW 			 未連線
 *  SSE_ACCEPT			 初連線
 *  SSE_CONNECTION		 連線中
 *  SSE_RECV			 接收
 *  SSE_SEND			 傳送
 *  SSE_TIMEOUT			逾時
 *  SSE_CLOSE           斷線
 *  SSE_STOP			停止
 *  SSE_ERROR			錯誤
 *  
 */
public enum SessionStatusEnum {
	SSE_UNKNOW("Unknow",-1), 
	SSE_CONNECTION("Connection",2),		
	SSE_RECV("Receive",4),
	SSE_SEND("Send",8),
	SSE_STOP("Stop",16),
	SSE_CLOSE("Close",32),
	SSE_TIMEOUT("TimeOut",64),	
	SSE_LOGIN("Login",128),
	SSE_LOGOUT("Logout",256),
	SSE_ERROR("Error",512);
	
	/*
	 * 位置 名稱
	 */
	private String strName;
	
	public String getName() {
		return strName;
	}

	public void setName(String strName) {
		this.strName = strName;
	}
	
	/*
	 * Index
	 */
	private int iIndex;
	
	public int getIndex() {
		return iIndex;
	}

	public void setIndex(int iIndex) {
		this.iIndex = iIndex;
	}
	
	/*
	 *  construction
	 */
	private SessionStatusEnum(String name,int idx) {
		this.setName(name);
		this.setIndex(idx);
	}
}
