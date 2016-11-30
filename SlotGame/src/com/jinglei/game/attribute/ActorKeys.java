package com.jinglei.game.attribute;

/*
 *   遊戲中  相關  Key 值定義
 */
public class ActorKeys {
	// Redis 使用   分隔符號
	public static final String  DELIMITER = "_";
	// 玩家唯一碼
	public static final String  MEMBER_ID  ="MEMBER_ID";
	// GClonePlayer 玩家所擁有 骰子 記錄
	public static final String CLONE_PLAYER = "CLONE_PLAYER";	
	// User NettyClientChannel
	public static final String USER_CHANNEL = "USER_CHANNEL";		
	// Account Data
	public static final String ACCOUNT_DATA = "ACCOUNT_DATA";
	// 玩家國家
	public static final String USER_COUNTRY = "USER_COUNTRY";	
	// 玩家 緯度 DOUBLE
	public static final String USER_LATITUDE = "USER_LATITUDE";	
	// 玩家 經度 DOUBLE
	public static final String USER_LONGITUDE = "USER_LONGITUD";		
	// 玩家現在在遊戲桌裡的流程狀態
	public static final String PLAYER_STATES = "PLAYER_STATES";

}
