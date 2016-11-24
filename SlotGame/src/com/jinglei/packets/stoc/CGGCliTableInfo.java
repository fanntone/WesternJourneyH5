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
	
	private int SeatNo_ = 0;
	private int PairerMinBet_ = 0;
	private int PairerMaxBet_ = 0;
	private int iTurnStop_ = 0;
	private int[] iRandomTimes_ = new int[12]; 
	private int[][] iHistoryRecord_ = new int[8][2];
	private int NationPointRatio_ = 0;
	private int iUserPoint_ = 0;
	private int iJPBonus_= 0;
	private int iPlatformJpBouns_ = 0;
	
	public int getSeatNo() {
		return this.SeatNo_;
	}
	
	public void setSeatNo(int seat_no) {
		this.SeatNo_ = seat_no;
	}
	
	public int getPairerMinBet() {
		return this.PairerMinBet_;
	}
	
	public void setPairerMinBet(int pairer_min_bet) {
		this.PairerMinBet_ = pairer_min_bet;
	}
	
	public int getPairerMaxBet() {
		return this.PairerMaxBet_;
	}
	
	public void setPairerMaxBet(int pairer_max_bet) {
		this.PairerMaxBet_ = pairer_max_bet;
	}
	
	public int getiTurnStop_() {
		return this.iTurnStop_;
	}
	
	public void setiTurnStop(int iturn_stop) {
		this.iTurnStop_ = iturn_stop;
	}
	
	public int getiRandomTimes(int index) {
		return this.iRandomTimes_[index];
	}
	
	public void setiRandomTimes(int index, int value) {
		this.iRandomTimes_[index] = value;
	}
	
	public int getiHistoryRecord(int index_x, int index_y) {
		return this.iHistoryRecord_[index_x][index_y];
	}
	
	public void setiRandomTimes(int index_x, int index_y, int value) {
		this.iHistoryRecord_[index_x][index_y] = value;
	}
	
	public int getNationPointRatio() {
		return this.NationPointRatio_;
	}
	
	public void setNationPointRatio(int nation_point_ratio_) {
		this.NationPointRatio_ = nation_point_ratio_;
	}
	
	public int getiUserPoint() {
		return this.iUserPoint_;
	}
	
	public void setiUserPoint(int iuser_point) {
		this.iUserPoint_ = iuser_point;
	}
	
	public int getiJPBonus() {
		return this.iJPBonus_;
	}
	
	public void setiJPBonus(int ijp_bonus) {
		this.iJPBonus_ = ijp_bonus;
	}
	
	public int getiPlatformJpBouns() {
		return this.iPlatformJpBouns_;
	}
	
	public void setiPlatformJpBouns(int iplatform_jp_bouns_) {
		this.iPlatformJpBouns_ = iplatform_jp_bouns_;
	}
}
