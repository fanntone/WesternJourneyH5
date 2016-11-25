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
//		DInt			iUserPoint;							//現有金額
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
	
	public int SeatNo_ = 0;
	public int PairerMinBet_ = 0;
	public int PairerMaxBet_ = 0;
	public int iTurnStop_ = 0;
	public int[] iRandomTimes_ = new int[12]; 
	public int[][] iHistoryRecord_ = new int[8][2];
	public int NationPointRatio_ = 0;
	public int iUserPoint_ = 0;
	public int iJPBonus_= 0;
	public int iPlatformJpBouns_ = 0;

}
