package com.jinglei.packets.stoc;

import com.jinglei.server.logic.JSONBean;

public class CGGCliRandomOddsResult implements JSONBean {
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return new String("CGGCliRandomOddsResult");
	}
	
	public CGGCliRandomOddsResult() {
		
	}
	
//	struct CGGCliRandomTimesResult
//	{
//		int	iRandomTimes[12];				//12格隨機倍率
//	};
	
	public int[] RandomOdds_ = new int[12];
}
