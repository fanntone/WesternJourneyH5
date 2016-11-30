package com.jinglei.packets.ctos;

import com.jinglei.server.logic.JSONBean;

public class CGGSLBet implements JSONBean {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return new String("CGGSLBet");
	}
	
	public CGGSLBet() {
		
	}

//	struct CGGSLBet
//	{
//		int				iBetSum[JOURNEYBAR_BET_MAX];		//各格押注量: 共12格(
//															//0:孫悟空-紅,  1:孫悟空-綠,  2:孫悟空-黃
//															//3:沙悟淨-紅,  4:沙悟淨-綠,  5:沙悟淨-黃 
//															//6:牛魔王-紅,  7:牛魔王-綠,  8:牛魔王-黃
//															//9:紅孩兒-紅, 10:紅孩兒-綠, 11:紅孩兒-黃 )
//		int             iBetBankPlayerTie[3];				//押注莊閒和3區(第0格:莊2倍, 第1格:閒2倍,第 2格:和8倍.)
//		int				iTotalBetPoint;						//押注總金額
//	};
	
	public int[] iBetSum_ = new int[12];
	public int[] iBetBankPlayerTie_ = new int[3];
	public int iTotalBetPoint_ = 0;
	
}
