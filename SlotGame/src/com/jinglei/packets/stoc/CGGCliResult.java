package com.jinglei.packets.stoc;

import java.math.BigInteger;

import com.jinglei.server.logic.JSONBean;

public class CGGCliResult implements JSONBean {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return new String("CGGCliResult");
	}
	
	public CGGCliResult() {
		
	}

//	struct CGGCliResult
//	{
//		int  iState;						//0: 押注失敗  1: 押注成功
//		int  iTurnStop[6];	    			//轉動燈號停在哪一格 (0~26)1:南天門 14:水濂洞
//		int  iBankPlayerTieStop;	    	//莊閒和燈號停在哪一格 (0~2)
//		int  iBossTurnStop[2];	    		//頭目燈 (0~3) 0:白骨精 1:鐵扇公主 2:海龍王 3:二郎神
//		int  iOpenStyle;					//開獎模式: (0:一般 1:七十二變 2:封神 3:二連 4:三連 5:仙女散花 6:四連 7:縱橫四海 8:四大天王-紅 9:四大天王-綠 10:四大天王-黃 11:角色全中-孫 12:角色全中-沙 13:角色全中-牛 14:角色全中-紅 15:顏色全中-紅 16:顏色全中-綠 17:顏色全中-黃 18:四海歸一 19:JP彩金) 
//		int	 iOpenStyleWinlose;				//開獎模式輸贏: (0:輸 1:贏)
//		DInt iWinPoint;	    				//贏得金額
//		DInt iBankPlayerTiePoint;			//莊閒和3區的嬴點(0:無.大於0才有嬴) 
//		DInt iPlayerWinPoint;   			//總贏得金額 (0:輸了 大於0:贏了 含莊閒和嬴的錢)
//		DInt iUserPoint;					//現有金額
//		DInt iGetJPBoint;	    			//贏得JP彩金的金額
//		DInt iJPBonus;		    			//遊戲彩金,累積彩金金額,顯示用 
//		DInt iPlatformJpBouns;				//平台彩金,累積彩金金額,顯示用
//		int iAwardKind1;					//指定開獎種類0~10(依遊戲)
//		int iAwardKind2;					//指定彩金種類 0:無,1:活動彩金,2:該遊戲彩金.3:總平台彩金.
//	};
	
	private int iState_ = 0;
	private int[] iTurnStop_ = new int[6];
	private int iBankPlayerTieStop_ = 0;
	private int[] iBossTurnStop_ = new int[2];
	private int iOpenStyle_ = 0;
	private int iOpenStyleWinlose_ = 0;
	private double iWinPoint_ = 0;
	private double iBankPlayerTiePoint_ = 0;
	private double iPlayerWinPoint_ = 0;
	private double iUserPoint_ = 0;
	private double iGetJPBoint_ = 0;
	private double iJPBonus_ = 0;
	private double iPlatformJpBouns_ = 0;
	private int iAwardKind1_ = 0;
	private int iAwardKind2_ = 0;
	
	public int getState() {
		return this.iState_ ;
	}
	
	public void setState(int value) {
		this.iState_ = value;
	}
	
	public int getiTurnStop(int index) {
		return this.iTurnStop_[index] ;
	}
	
	public void setiTurnStop(int index, int value) {
		this.iTurnStop_[index] = value;
	}
	
	public int getiBankPlayerTieStop() {
		return this.iBankPlayerTieStop_ ;
	}
	
	public void setiBankPlayerTieStop(int value) {
		this.iBankPlayerTieStop_ = value;
	}
	
	public int getiBossTurnStop(int index) {
		return this.iBossTurnStop_[index] ;
	}
	
	public void setiBossTurnStop(int index, int value) {
		this.iBossTurnStop_[index] = value;
	}
	
	public int getiOpenStyle() {
		return this.iOpenStyle_ ;
	}
	
	public void setiOpenStyle(int value) {
		this.iOpenStyle_ = value;
	}
	
	public int getiOpenStyleWinlose() {
		return this.iOpenStyleWinlose_ ;
	}
	
	public void setiOpenStyleWinlose(int value) {
		this.iOpenStyleWinlose_ = value;
	}
	
	public double getiWinPoint() {
		return this.iWinPoint_ ;
	}
	
	public void setiWinPoint(double value) {
		this.iWinPoint_ = value;
	}
	
	public double getiBankPlayerTiePoint() {
		return this.iBankPlayerTiePoint_ ;
	}
	
	public void setiBankPlayerTiePoint(double value) {
		this.iBankPlayerTiePoint_ = value;
	}
	
	public double getiPlayerWinPoint() {
		return this.iPlayerWinPoint_ ;
	}
	
	public void setiPlayerWinPoint(double value) {
		this.iPlayerWinPoint_ = value;
	}
	
	public double getiUserPoint() {
		return this.iUserPoint_ ;
	}
	
	public void setiUserPoint(double value) {
		this.iUserPoint_ = value;
	}
	
	public double getiGetJPBoint() {
		return this.iGetJPBoint_ ;
	}
	
	public void setiGetJPBoint(double value) {
		this.iGetJPBoint_ = value;
	}
	
	public double getiJPBonus() {
		return this.iJPBonus_ ;
	}
	
	public void setiJPBonus(double value) {
		this.iJPBonus_ = value;
	}
	
	public double getiPlatformJpBouns_() {
		return this.iPlatformJpBouns_ ;
	}
	
	public void setiPlatformJpBouns_(double value) {
		this.iPlatformJpBouns_ = value;
	}
	
	public int getiAwardKind1() {
		return this.iAwardKind1_ ;
	}
	
	public void setiAwardKind1(int value) {
		this.iAwardKind1_ = value;
	}
	
	public int getiAwardKind2() {
		return this.iAwardKind2_ ;
	}
	
	public void setiAwardKind2(int value) {
		this.iAwardKind2_ = value;
	}
}
