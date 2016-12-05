package com.jinglei.packets.stoc;

import com.jinglei.server.logic.JSONBean;

public class CGGCliTableInfo implements JSONBean {

//	struct CGGCliTableInfo
//	{
//		int				SeatNo;								//機台號碼
//		int				PairerMinBet;						//最低押注
//		int				PairerMaxBet;						//最高押注
//		int				iTurnStop;							//目前燈號停止的格子
//		int				iRandomTimes[12];					//12格隨機倍率
//		int				iHistoryRecord[8][2];				//歷史記錄 共8局 (1.獎項)(2.莊閒和)
//		int				NationPointRatio;					//國別比值:1:(馬來1:1),2:(未知:10:1除以10或左移1位小數點顯示)3:泰國:(100:1除以100或左移2位小數點顯示)
//		DInt			iUserPoint;							//金額
//		DInt			iJPBonus;							//JP彩金金額
//		DInt            iPlatformJpBouns;	                //平台彩金,累積彩金金額,顯示用
//	};
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return new String("CGGCliTableInfo");
	}
	
	public CGGCliTableInfo() {

	}
	
	public long RunGrpBeginTime = 0 ;				// 局開始時間
	public long RunGrpEndTime = 0;					// 局結束時間
	public String ThisGrpNo = null;					// 局編號(唯一碼, DB用)
	public int GrpType = 0;							// 局類型
	public int CoinType = 0;
	public int GameType = 0;
	public int[] BetRange = new int[5];
	public int MaxBetLimit = 0;
	public String GrpUniID = null;
	public int[] JPBonusList = new int[4];
	public int[] BounsHistoryRecord = new int[8];
	public int[] SampleHistoryRecord = new int[8];
	public int[] BounsTotalBet = new int[3];
	public int[] SampleTotalBet = new int[12];	
	public int[] RandomPay = new int[12];
	public int NationCoinType = 0;
	public int NationPointRatio = 0;
	public int MaxBetValue = 0;
	public int MinBetValue = 0;
	
}
