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
	
	public long RunGrpBeginTime_ = 0 ;
	public long RunGrpEndTime_ = 0;
	public String ThisGrpNo_ = null;
	public int GrpType_ = 0;
	public int CoinType_ = 0;
	public int GameType_ = 0;
	public int[] BetRange_ = new int[5];
	public int MaxBetLimit_ = 0;
	public String GrpUniID_ = null;
	public int[] JPBonusList_ = new int[4];
	public int[] BounsHistoryRecord_ = new int[8];
	public int[] SampleHistoryRecord_ = new int[8];
	public int[] BounsTotalBet_ = new int[3];
	public int[] SampleTotalBet_ = new int[12];	
	public int[] RandomPay_ = new int[12];
	public int NationCoinType_ = 0;
	public int NationPointRatio_ = 0;
	public int MaxBetValue_ = 0;
	public int MinBetValue_ = 0;
	
}
