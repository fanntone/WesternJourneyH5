package com.jinglei.game.server.common;

import java.security.SecureRandom;
import java.util.Random;
import com.jinglei.game.SysLog;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CGThisGroup {
	
	private static CGThisGroup  instance = null;
	
	public static synchronized  CGThisGroup getInstance() {
		if ( instance == null ) {
			instance = new CGThisGroup();
		}
		
		return instance;
	}
	
	public CGThisGroup() {
		GetGroupHistoryFromRedis();
		ReGetBounsAndSampleTotalBetValue();
		RandomPai();
		ThisGrpNo_ = InitThisGroupId();
	}

	// 開局時間
	public static long RunGrpBeginTime_ = System.currentTimeMillis();
	// 完局時間
	public static long RunGrpEndTime_ = System.currentTimeMillis() + 2 * (1000);
	// 局編號(SHA-1)
	public static int ThisGrpNo_ = 0;
	// 遊戲型態為動態人數
	public static int GrpType_ = CGGrpTypes.GRP_TYPE_DYN_PLAYERS.GetValue();
	// 遊戲幣別(真錢/假錢)
	public static int CoinType_ = CGCoinTypes.COIN_TYPE_V_COIN.GetValue();
	// 遊戲類型 西遊爭霸H5
	public static int GameType_ = CGGameTypes.GAME_TYPE_JOURNEYBAR_H5.GetValue();
	// 個人押注基礎區間
	public static int[] BetRange_ = {1, 10, 30, 50, 100};
	// 壓注單格上限值
	public static int MaxBetLimit_ = 800;
	// P01-1顯示用
	public static String GrpUniID_ = "95-XXXXXX-YYYY";
	// 各彩金金額 
	public static int[] JPBonusList_ = {CGJPBouns.JP_1, CGJPBouns.JP_2, CGJPBouns.JP_3, CGJPBouns.JP_4};
	// 莊閒和登前八局開獎紀錄
	public static int[] BounsHistoryRecord_ = new int[8];
	// 一般燈前八局開獎紀錄
	public static int[] SampleHistoryRecord_ = new int[8];
	// 莊閒和各格總押注金額
	public static int[] BounsTotalBet_ = new int[3];
	// 一般區各格總押注金額
	public static int[] SampleTotalBet_ = new int[12];
	// 幣國別
	public static int NationCoinType_ = CGNationCoinType.CNY.GetValue();
	// 幣值比
	public static int NationPointRatio_ = CGNationPointRatio.CNY.GetValue();
	// 區間最大押注額
	public static int MaxBetValue_ = 100;
	// 區間最小押注額
	public static int MinBetValue_ = 1;
	// 各格子隨機賠率
	public static int[] RandomPay_ = new int [12];
	
	
	public void GetGroupHistoryFromRedis() {
		// set HistoryRecord
		// 這邊先給假資料
		Random ran = new Random();
		for(int i = 0; i < 7; i++) {
			BounsHistoryRecord_[i] = ran.nextInt(3);
			SampleHistoryRecord_[i] = ran.nextInt(12);
		}
	}
	
	public void ReGetBounsAndSampleTotalBetValue() {
		// Re get total value
		// 這邊些先給假資料
		Random ran = new Random();
		for(int i = 0; i < 3; i++) {
			BounsTotalBet_[i] = ran.nextInt(1000);
		}
		for(int j = 0; j < 12; j++) {
			SampleTotalBet_[j] = ran.nextInt(1000);
		}		
	}
	
	private static String hexEncode(byte[] aInput) {
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
	
	public void RandomPai() {
		//亂數分配孫悟空3區的賠率  25~(25+21)
		SetOdds(0, 25, 22); 
		//亂數分配沙悟淨3區的賠率  12~(12+11)
		SetOdds(3, 12, 12);
		//亂數分配牛魔王3區的賠率 7~(7+6)
		SetOdds(6, 7, 7);
		//亂數分配紅孩兒3區的賠率 4~(4+4)
		SetOdds(9, 4, 5);
	}
	
	private void SetOdds(int begin_index, int base_odds, int add_odds) {
		int j, k;
		for(j = begin_index; j < begin_index + 3; j++)
		{
			Random ran = new Random();
			k = ran.nextInt(add_odds);	// 取亂數: 0~odds-1
			k = k + base_odds; 			// 賠率: base_odds~(base_odds+add_odds) 

			if(RandomPay_[0] == k 
			   || RandomPay_[1] == k 
			   || RandomPay_[2] == k)
				continue;

			RandomPay_[j] = k;
		}
	}
}
