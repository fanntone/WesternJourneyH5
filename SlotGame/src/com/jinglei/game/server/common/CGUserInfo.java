package com.jinglei.game.server.common;


public class CGUserInfo {
	
//	struct PLAYER
//	{
//		/**
//		 * 建構式
//		 */
//		PLAYER(GAME_GRP* pGrp, PL_IN_GRP_INFO* pPLInfo);
//
//		/**
//		 * 解構式
//		 */
//		~PLAYER();
//
//		PL_STATE		State;					///< 目前的狀態
//		CARD_TYPE		CardType;				///< 參考CARD_TYPE
//		PL_DB			UserDB;					///< 玩家的基本資料
//		GAME_GRP*		pGameGrp;				///< 玩家在Group Vector的GAME_GRP指標
//		Short			SeatNo;					///< 玩家在遊戲中座位的序號[0, GAME_GRP::CurMenInGrp - 1]
//		Dword			tmLastAccess;			///< 玩家最近一次的網路存取的時間(以timeGetTime()紀錄)
//		Byte			OnLineState;			///< 線上的狀態. 1:在大廳中, 2:忙碌中, 3:馬上回來, 4:離開, 5:電話中, 6:外出用餐, 7:在等待中, 8:在遊戲中, 9:不在線上
//		Byte            IsCSOnLine;				///< 玩家是否在CS線上
//		Byte          	IsGSOnLine;				///< 玩家是否在GS線上
//		Dword			SpecFlags;				///< 參考PL_FLAG
//		Int				BankFameLevel;			///< 評價等級
//		Int				AutoNetDisconn;			///< 自動斷線機制
//		Int				AutoNetDisconnRun;		///< 自動斷線機制啟動
//		Dword			IPAdr;					///< IP Address
//		DInt			MACAdr;					///< MAC Address
//		GAActor*		pActor;					///< Actor
//		Dword			tmLastCriticalMsg;		///< 上一次接受維持遊戲正常進行訊息的時間
//		Dword			tmLastTick;				///< 最近一次Tick的時間點
//		Int				LastCmd2Send;			///< 最近一個傳送的訊息ID(不含GS_GA_TICK)
//		Int				LastCmd2Recv;			///< 最近一個接受的訊息ID(不含GS_GA_TICK)
//		BL				IsOffLineKeepTable;		///< 是否為離線留座
//		Dword			OffLineGSGrpUniID;		///< 離線留座的GSGrpUniID
//		Dword			tmOffLineKeepTable;		///< 離線留座的開始時間
//		BL				ExitGame2MySelf;		///< 玩家自己確認要離開遊戲
//		Int				TransID;				///< 交易識別碼
//		Int				nGameBetCounters;		///< 玩家入局的遊戲局數
//		DInt			nWinLoseTotalPoints;	///< 玩家從登入遊戲到目前為止的總輸贏點數
//		Int				BackFeePercentageParam1;///< 退水的比例參數一
//		Int				BackFeePercentageParam2;///< 退水的比例參數二
//		BL				RaceTicket;				///< 是否有寶箱的門票. 實際是否顯示在CLIENT有寶箱圖示需參考OpenBonusBoxState是否為1 or 2
//		Int				OpenBonusBoxState;		///< 是否擁有寶箱的資格. 0: 沒擁有寶箱資格, 1: 擁有寶箱資格, 2: 正在開寶箱等待結果中
//		Int				OpenBonusBoxCounter;	///< 目前寶箱擁有的次數
//		Int				OpenBonusBoxCountLimit;	///< 開寶箱的次數限制。當OpenBonusBoxCounter == OpenBonusBoxCountLimit時，可開寶箱
//		STR32			GameIP;					///< 連線IP
//	};
	
	
	public CGUserInfo(CGGameGrp pGrp, CGPlayerInGrpInfo pPLInfo) {
		
	}
	
	public CGPlayerState State = CGPlayerState.PL_STATE_READY_GAME;
	public CGCardTypes CardType = CGCardTypes.CARD_TYPE_MEMBER;
	public CGPlayerDB UserDB = null;
	public CGGameGrp pGameGrp = null;
	public int SeatNo = 0;
	public int tmLastAccess = 0;
	public int OnLineState = 0;
	public int IsCSOnLine = 0;
	public int IsGSOnLine = 0;
	public int SpecFlags = 0;
	public int BankFameLevel = 0;
	public int AutoNetDisconn = 0;
	public int AutoNetDisconnRun = 0;
	public int IPAdr = 0;
	public int MACAdr = 0;
	public CGGAActor pActor = CGGAActor.GRP_TYPE_STC_PLAYERS;
	public int tmLastCriticalMsg = 0;
	public int tmLastTick = 0;
	public int LastCmd2Send = 0;
	public int LastCmd2Recv = 0;
	public boolean IsOffLineKeepTable = false;
	public int OffLineGSGrpUniID = 0;
	public int tmOffLineKeepTable = 0;
	public boolean ExitGame2MySelf = false;
	public int TransID = 0;
	public int nGameBetCounters = 0;
	public int nWinLoseTotalPoints = 0;
	public int BackFeePercentageParam1 = 0;
	public int BackFeePercentageParam2 = 0;
	public boolean RaceTicket = false;
	public int OpenBonusBoxState = 0;
	public int OpenBonusBoxCounter = 0;
	public int OpenBonusBoxCountLimit =0;
	public String GameIP = null;
	
}
