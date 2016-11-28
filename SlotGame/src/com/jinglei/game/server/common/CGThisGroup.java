package com.jinglei.game.server.common;

import java.security.SecureRandom;

import com.jinglei.game.SysLog;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CGThisGroup {
	
//	struct GAME_GRP
//	{
//		Dword				tmRunGrp;                       ///< 局啟動的時間
//		Dword				tmFmGrp;						///< 局的每回合的開始時間
//		Int					CSGrpNo;						///< 局號(CS GrpNo)
//		Int					GSGrpNo;						///< 局號(GS GrpNo)
//		Dword				CSGrpUniID;						///< 局的唯一識別碼(動態, 隨CS的啟動而重置為0)
//		Dword				GSGrpUniID;						///< 局的唯一識別碼(動態, 隨GS的啟動而重置為0)
//		DInt         		GrpLogDBUniID;					///< 局在資料庫中的唯一識別碼
//		GRP_TYPE			GrpType;              			///< 局的型態
//		COIN_TYPE			CoinType;						///< 點數型態
//		GAME_TYPE			GameType;		          		///< 遊戲型態
//		GAME_GRP_MODE		GameMode;             			///< 遊戲模式
//		Int					CurMenInGrp;		        	///< 目前玩家的人數
//		Int					MaxMenInGrp;        			///< 玩家的人數上限
//		Int					State;							///< 局目前所處的狀態。0:尚未使用, 1:等待成局, 2:遊戲啟動中, 3:遊戲執行中, 4:遊戲關閉初始化中, 5:遊戲關閉
//		Dword				DiTai;                			///< 遊戲的底台
//		Int					FreeGame;						///< 試玩
//		Int					Second;               			///< 思考的時間
//		Int					BasePoints;	        			///< 遊戲基本扣點
//		Int					ParamLst[GAME_DB_PARAM_NUM];	///< 附加的檢查資料
//		Int					wParam;							///< GAME DLL專用的參數一
//		Int					lParam;							///< GAME DLL專用的參數二
//		PLAYER**			pPLVec;							///< 玩家資訊清單
//		PLAYER**			pGMVec;							///< GM資訊清單
//		Short*				pPLState;						///< 玩家登入階段。0:尚未使用, 1:GA已和GS已連線, 2:已取得DBSrv傳回的玩家資訊, 3:玩家已離開此局(For 相容遊戲)
//		Dword*				pPLLastAccess;					///< Player access time
//		Dword				Handle;		                    ///< 局在GAMEDLL的控制ID
//		Int					ReadyShutDownSrv;				///< 是否準備關掉伺服器
//		Int					BankRatio;						///< 牌組使用率
//		Int					PointRatioL;					///< 押注倍率的左側數值
//		Int					PointRatioR;					///< 押注倍率的右側數值
//		Int					LogoSceneLog;					///< 是否已經輸出了Logo幕斷線的訊息到DBSrv了
//		Int					Probability;					///< 吐錢機率
//		CGServerLogic*		pServerLogic;	                ///< 邏輯處理物件
//		CG_MSG_SENDER		MsgSender;		                ///< 訊息傳送器
//		CARD_TYPE			CardType;						///< 參考CARD_TYPE
//		STR16				GrpUniID;						///< 將號
//		STR32				GSName;							///< GS Name
//		Dword				RandomCode;						///< 隨機分配的亂數唯一碼
//		Int					Hold;
//		wchar_t				HoldPassword[PASSWORD_LENGTH];
//		DInt*				pJPBonusList;					///< JP彩金
//		DInt*				pJPBonusParamList;				///< 設定彩金的參數(例如彩金上，下限…)
//		BL					Finish8ThisRound;				///< 該回合結果後，不得繼續遊戲
//	};
	
	public CGThisGroup() {
		// TODO: get redis data to set default member value.
	}

	public long tmRunGrp_ = GetSystemTime();
	public long tmFmGrp_ = GetSystemTime();
	public int CSGrpNo_ = InitThisGroupId();
	public int GSGrpNo_ = 0;
	public int CSGrpUniID_ = 0;
	public int GSGrpUniID_ = 0;
	public int GrpLogDBUniID = 0;
	public int GrpType = CGGrpTypes.GRP_TYPE_STC_PLAYERS.GetValue();
	public int CoinType = CGCoinTypes.COIN_TYPE_V_COIN.GetValue();
	public int GameType = CGGameTypes.GAME_TYPE_LOBBY.GetValue();
	public int GameMode = CGGameGrpModes.GAME_GRP_MODE_AUTO_LV1.GetValue();
	public int CurMenInGrp = 0;
	public int MaxMenInGrp = 0;
	public int State = 0;
	public int DiTai = 0;
	public int FreeGame = 0;
	public int Second = 0;
	public int BasePoints = 0;
	public int[] ParamLst = {0};
	public int wParam;
	public int lParam;
	public CGUserInfo pPLVec = null;
	public CGUserInfo pGMVec = null;
	public int pPLState = 0;
	public int pPLLastAccess = 0;
	public int Handle = 0;
	public int ReadyShutDownSrv = 0;
	public int BankRatio = 0;
	public int PointRatioL = 0;
	public int PointRatioR = 0;
	public int LogoSceneLog = 0;
	public int Probability = 0;
	public CGServerLogic pServerLogic = null;
	public CGMsgSender MsgSender = null;
	public int CardType = CGCardTypes.CARD_TYPE_MEMBER.GetValue();
	public String GrpUniID = "";
	public String GSName = "";
	public int RandomCode = 0;
	public String HoldPassword = "";
	public int[] pJPBonusList = new int[4];
	public int[] pJPBonusParamList = new int[4];
	public boolean Finish8ThisRound = false;
	
	public void GetThisGroupDataFromRedis() {
		
	}
	
	public void SetThisGroupDataToRadiw() {
		
	}
	
	static private String hexEncode(byte[] aInput) {
		StringBuilder result = new StringBuilder();
	    char[] digits = {'0', '1', '2', '3', '4','5','6','7','8','9','a','b','c','d','e','f'};
	    for (int idx = 0; idx < aInput.length; ++idx) {
	      byte b = aInput[idx];
	      result.append(digits[ (b&0xf0) >> 4 ]);
	      result.append(digits[ b&0x0f]);
	    }
	    return result.toString();
	}
	
	private int InitThisGroupId() {
		// example: c8fff94ba996411079d7114e698b53bac8f7b037
	    try {
	    	SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");
	    	String randomNum = new Integer(prng.nextInt()).toString();
	    	MessageDigest sha = MessageDigest.getInstance("SHA-1");
	    	byte[] result =  sha.digest(randomNum.getBytes());
	    	return Integer.parseInt(hexEncode(result), 10); 
	    }
	    catch (NoSuchAlgorithmException ex) {
	    	SysLog.PrintInfo("Logic_CGGSLTableInfo Run finally!!");
	    	return 0;
	    }
	}
	
	private long GetSystemTime() {
		return System.currentTimeMillis();
	}
}
