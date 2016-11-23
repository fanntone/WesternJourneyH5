package com.jinglei.jedis;

/*
 * Redis 相關 Key 值定義
 */
public class RedisKeys {
	
    public static final String DEFAULT_PASSWORD = null;
    
    public static final String DIRECT_POOL_PREFIX = "direct:";
    public static final String SENTINEL_POOL_PREFIX = "direct:";
    
    public static final String NO_ADDRESS_YET = "I dont know because no sentinel up";
    
    public static final String OK_CODE = "OK";
    public static final String OK_MULTI_CODE = "+OK";
    
    
    /*
	 *  Redis 使用   分隔符號
	 */
	public  static  final String  DELIMITER = "_";
	
	/*
	 *  逗號
	 */
	public static final String COMMA = ",";
	
	/*
	 *  分號
	 */
	public static final String SEMICOLON = ";";
	
	/*
	 *  冒號
	 */
	public static final String COLON = ":";
	
	/*
	 *  井號
	 */
	public static final String POUND = "#";
	
	/*
	 *  波浪符
	 */
	public static final String TILDE = "~";
	
	/*
	 *  問號
	 */
	public static final String QUESTION_MARK = "?";
	
	/*
	 *  連字號
	 */
	public static final String HYPHEN = "-";
	
	/*
	 *  AND 
	 */
	public static final String AMPERSAND = "&";
	
	/*
	 *  account_data 資料
	 */
	public static  final String ACCOUNT_DATA = "ACCOUNT_DATA_";
	
   /*
    *  user_data 資料
    */
	public static  final String USER_DATA = "USER_DATA_";
	
	/*
	 *  user_role 玩家所擁有 主角
	 */
	public static  final String USER_ROLE = "USER_ROLE_";
	
	/*
	 *  user_pet 玩家所擁有  寵物
	 */
	public static  final String USER_PET = "USER_PET_";
	
	/*
	 *  user_team 玩家所擁有  可戰鬥 隊伍
	 */
	public static  final String USER_TEAM = "USER_TEAM_";	
	
	/*
	 *  user_item 玩家所擁有  道具
	 */
	public static  final String USER_ITEM = "USER_ITEM_";	
	
	/*
	 *  user_map 玩家所擁有 推圖 記錄
	 */
	public static  final String USER_MAP = "USER_MAP_";	
	
	/*
	 *  user_standing 玩家所擁有 戰績 記錄
	 */
	public static  final String USER_STANDING = "USER_STANDING_";	
	
	/*
	 *  user_bead 玩家所擁有 珠子 記錄
	 */
	public static  final String USER_BEAD = "USER_BEAD_";	
	
	/*
	 *  user_dice 玩家所擁有 骰子 記錄
	 */
	public static  final String USER_DICE = "USER_DICE_";	
	
	/*
	 *  GClonePlayer 玩家所擁有 骰子 記錄
	 */
	public static  final String CLONE_PLAYER = "CLONE_PLAYER_";	
	
	/*
	 * User NettyClientChannel
	 */
	public static  final String USER_CHANNEL = "USER_CHANNEL_";	
	
	
	//////////////////////////-[Battle]-/////////////////////////
	/*
	 *  GameRoom 戰鬥時房間
	 */
	public static  final String BATTLE_ROOM = "BATTLE_ROOM_";	
	
	//////////////////////////-[Battle]-/////////////////////////
	/*
	 *  玩家資料
	 */
	public static  final String ACTOR = ":ACTOR";	
}
