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
	
	// CGThisGroup 每個局的資料必須記錄, 玩家在進入各階段都必須讀取, 斷線後重登後也須要讀取此資料才能恢復當時的狀態
	public static final String CGThisGroup_tmRunGrp 		= "CGThisGroup_tmRunGrp";
	public static final String CGThisGroup_tmFmGrp 			= "CGThisGroup_tmFmGrp";
	public static final String CGThisGroup_CSGrpNo 			= "CGThisGroup_CSGrpNo";
	public static final String CGThisGroup_GSGrpNo 			= "CGThisGroup_GSGrpNo";
	public static final String CGThisGroup_CSGrpUniID 		= "CGThisGroup_CSGrpUniID";
	public static final String CGThisGroup_GSGrpUniID 		= "CGThisGroup_GSGrpUniID";
	public static final String CGThisGroup_GrpLogDBUniID 	= "CGThisGroup_GrpLogDBUniID";
	public static final String CGThisGroup_GrpType 			= "CGThisGroup_GrpType";
	public static final String CGThisGroup_CoinType 		= "CGThisGroup_CoinType";
	public static final String CGThisGroup_GameType 		= "CGThisGroup_GameType";
	public static final String CGThisGroup_GameMode 		= "CGThisGroup_GameMode";
	public static final String CGThisGroup_CurMenInGrp 		= "CGThisGroup_CurMenInGrp";
	public static final String CGThisGroup_MaxMenInGrp 		= "CGThisGroup_MaxMenInGrp";
	public static final String CGThisGroup_State 			= "CGThisGroup_State";
	public static final String CGThisGroup_DiTai 			= "CGThisGroup_DiTai";
	public static final String CGThisGroup_FreeGame 		= "CGThisGroup_FreeGame";
	public static final String CGThisGroup_Second 			= "CGThisGroup_Second";
	public static final String CGThisGroup_BasePoints 		= "CGThisGroup_BasePoints";
	public static final String CGThisGroup_ParamLst 		= "CGThisGroup_ParamLst";
	public static final String CGThisGroup_wParam 			= "CGThisGroup_wParam";	
	public static final String CGThisGroup_lParam 			= "CGThisGroup_lParam";
	public static final String CGThisGroup_pPLVec 			= "CGThisGroup_pPLVec";
	public static final String CGThisGroup_pGMVec 			= "CGThisGroup_pGMVec";
	public static final String CGThisGroup_pPLState 		= "CGThisGroup_pPLState";
	public static final String CGThisGroup_pPLLastAccess 	= "CGThisGroup_pPLLastAccess";
	public static final String CGThisGroup_Handle 			= "CGThisGroup_Handle";
	public static final String CGThisGroup_ReadyShutDownSrv = "CGThisGroup_ReadyShutDownSrv";
	public static final String CGThisGroup_BankRatio 		= "CGThisGroup_BankRatio";
	public static final String CGThisGroup_PointRatioL 		= "CGThisGroup_PointRatioL";
	public static final String CGThisGroup_PointRatioR 		= "CGThisGroup_PointRatioR";
	public static final String CGThisGroup_LogoSceneLog 	= "CGThisGroup_LogoSceneLog";
	public static final String CGThisGroup_Probability 		= "CGThisGroup_Probability";
	public static final String CGThisGroup_pServerLogic 	= "CGThisGroup_pServerLogic";
	public static final String CGThisGroup_CardType 		= "CGThisGroup_CardType";
	public static final String CGThisGroup_GrpUniID 		= "CGThisGroup_GrpUniID";
	public static final String CGThisGroup_GSName 			= "CGThisGroup_GSName";
	public static final String CGThisGroup_RandomCode 		= "CGThisGroup_RandomCode";
	public static final String CGThisGroup_HoldPassword 	= "CGThisGroup_HoldPassword";
	public static final String CGThisGroup_pJPBonusList 	= "CGThisGroup_pJPBonusList";	
	public static final String CGThisGroup_pJPBonusParamList= "CGThisGroup_pJPBonusParamList";
	public static final String CGThisGroup_Finish8ThisRound = "CGThisGroup_Finish8ThisRound";
}
