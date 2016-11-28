package com.jinglei.packets.stoc;

import com.jinglei.server.logic.JSONBean;

public class CGGCliRandomTimesResult implements JSONBean {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return new String("CGGCliRandomTimesResult");
	}
	
	public CGGCliRandomTimesResult() {
		
	}
	
//	struct CGGCliRandomTimesResult
//	{
//		int	iRandomTimes[12];				//12格隨機倍率
//	};

	public  int[] iRandomTimes_ = new int[12];
	
	
}
