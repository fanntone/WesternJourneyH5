package com.jinglei.game.server.common;

public class CGGroupInfoReport {
	
//	typedef struct
//	{
//		int iTurnStopRecord[6];					//當局開出停止的燈號位置
//		int iBankPlayerTieStopRecord;	    	//當局開出莊閒和停止的燈號位置
//		int iBetSumRecord[JOURNEYBAR_BET_MAX];	//各格押注量(0:黃-孫悟空 1:黃-紅孩兒 2:黃-牛魔王 3:黃-沙悟淨 4:綠-孫悟空 5:綠-紅孩兒 6:綠-牛魔王 7:綠-沙悟淨
//												//			8:紅-孫悟空 9:紅-紅孩兒 10:紅-牛魔王 11:紅-沙悟淨)
//		int iBetBankPlayerTieRecord[3];			//押注莊閒和3區(第0格:莊2倍,第1格:閒2倍,第2格:和9倍.)
//		DInt WinLose;							//當局輸嬴
//		Char date[16];
//		Char hour[16];
//
//	} GRP_INFO_REPORT, *LPGRP_INFO_REPORT;
	
	public CGGroupInfoReport() {
		
	}

	public int[] iTurnStopRecord = new int[6];
	public int iBankPlayerTieStopRecord = 0;
	public int[] iBetSumRecord = new int[12];
	public int[] iBetBankPlayerTieRecord = new int[3];
	public int WinLose = 0;
	public String date = null;
	public String hour = null;
}
