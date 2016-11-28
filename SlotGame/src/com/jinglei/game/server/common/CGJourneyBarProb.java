package com.jinglei.game.server.common;

import com.jinglei.packets.stoc.CGGCliRandomTimesResult;
import java.util.Random;

public class CGJourneyBarProb {

	public CGJourneyBarProb() {
		
	}
	
	public CGGCliRandomTimesResult CliRandomTimesResult_;
	
	
	//換算成遊戲中的點數
	public int GetRatioPoint(int point) {
		
		return 123456789;
	}
	
	public void RandomPai() {
		//亂數分配孫悟空3區的賠率
		SetOdds(0, 25, 22);
		//亂數分配沙悟淨3區的賠率
		SetOdds(3, 12, 12);
		//亂數分配牛魔王3區的賠率
		SetOdds(6, 7, 7);
		//亂數分配紅孩兒3區的賠率
		SetOdds(9, 4, 5);
	}
	
	private void SetOdds(int begin_index, int base_odds, int add_odds) {
		int j, k;
		for(j = begin_index; j < begin_index+3; j++)
		{
			Random ran = new Random();
			k = ran.nextInt(add_odds);	// 取亂數: 0~odds-1
			k = k + base_odds; 			// 賠率: base_odds~(base_odds+add_odds) 

			if(CliRandomTimesResult_.iRandomTimes_[0] == k 
			   || CliRandomTimesResult_.iRandomTimes_[1] == k 
			   || CliRandomTimesResult_.iRandomTimes_[2] == k)
				continue;

			CliRandomTimesResult_.iRandomTimes_[j] = k;
		}
	}
}
