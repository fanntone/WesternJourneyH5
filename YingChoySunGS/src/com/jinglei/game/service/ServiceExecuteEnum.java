package com.jinglei.game.service;

public enum ServiceExecuteEnum {
	/*
	 * Service
	 */
	/*
	 * Game Memory Catch Data
	 */
	SEE_PlayerGameCatchMemory(201,"com.auer.game.service.impl.Service_PlayerGameCatchMemory"),
	/*
	 * 玩家 帳號  封鎖
	 */
	SEE_AccountBlocked(900,"com.auer.game.service.impl.Service_AccountBlocked");


	
	/*
	 * 執行 Type
	 */
	private int iType;
	public int  getType() {
		return iType;
	}
	
	public void setType(int type) {
		this.iType = type;
	}
	
	/*
	 * Class Path
	 */
	private String strClassPath;
	
	public String getClassPath() {
		return strClassPath;
	}
	
	public void setClassPath(String classpath) {
		this.strClassPath = classpath;
	}
	
	private ServiceExecuteEnum(int type,String classpath) {
		this.iType = type;
		this.strClassPath = classpath;
	}
}
