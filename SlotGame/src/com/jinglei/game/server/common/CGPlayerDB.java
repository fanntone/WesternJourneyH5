package com.jinglei.game.server.common;


public class CGPlayerDB {
	
//	struct PL_DB
//	{
//		Dword									PLUniID;													///< 玩家開卡後的唯一識別碼
//		Int										MemberID;													///< 1: 一般會員, 2: Maji會員
//		DInt									nVPoints;													///< 玩家的有價點數
//		DInt									nFPoints;													///< 玩家的免費點數
//		Int										PointRatio;													///< 點數比值
//		Int										SiteID;														///< 站台ID. 7：1, 新濠：2, 全家：3, 白金：9
//		Int										Gender;														///< 0: 尚未設定, 1: 男性, 2: 女性
//		Int										IsVIP;														///< 是否為VIP
//		Int										nGrpPoints;													///< 遊戲局中的輸贏點數(扣掉有使用到nDetainPoints的部分)
//		Int										nWarPoints;													///< 遊戲局中的戰績
//		Int										nOKLogouts;													///< 正常離線次數
//		Int										nFailLogouts;												///< 不正常離線次數
//		Int										nWins;														///< 勝場數
//		Int										nLoses;														///< 敗場數
//		Int										nDraws;														///< 平手場數
//		Int										Level;														///< 段位
//		Int             						nBuyInPointNo;              								///< 增加買入欄位
//		CARDNAME    							CardName;													///< 玩家名稱
//		NICKNAME								NickName;													///< 玩家暱稱
//		GAME_SCORE								GameScore;													///< 遊戲戰績
//		STR256									PicURL;														///< 照片連結網址
//	};
	
	public CGPlayerDB() {
		
	}
	
	public int PLUniID = 0;
	public int MemberID = 0;
	public int nVPoints = 0;
	public int nFPoints = 0;
	public int PointRatio = 0;
	public int SiteID = 0;
	public int Gender = 0;
	public int IsVIP = 0;
	public int nGrpPoints = 0;
	public int nWarPoints = 0;
	public int nOKLogouts = 0;
	public int nFailLogouts = 0;
	public int nWins = 0;
	public int nLoses = 0;
	public int nDraws = 0;
	public int Level = 0;
	public String CardName = null;
	public String NickName = null;
	public CGGameScore GameScore = null;
	public String PicURL = null;
	
}
