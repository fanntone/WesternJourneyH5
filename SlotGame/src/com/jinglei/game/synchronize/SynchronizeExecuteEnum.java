package com.jinglei.game.synchronize;

public enum SynchronizeExecuteEnum {
	
	/*
	 *  Check Offline Staging Area
	 */
	SEE_CheckOfflineStagingArea(101,"com.auer.game.attribute.impl.Service_CheckOfflineStagingArea"),
	/*
	 * Synchronize 同步
	 */
	SEE_LoginDate(1001,"com.auer.game.synchronize.impl.Synchronize_LoginDate"),									//玩家登入
	SEE_LogoutDate(1002,"com.auer.game.synchronize.impl.Synchronize_LogoutDate"); 								//玩家登出

	
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
	
	private SynchronizeExecuteEnum(int type,String classpath) {
		this.iType = type;
		this.strClassPath = classpath;
	}
}
