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

	private int[] iRandomTimes_ = new int[12];
	
	public int getiRandomTimes(int index) {
		return this.iRandomTimes_[index];
	}
	
	public void setiRandomTimes(int index, int value) {
		this.iRandomTimes_[index] = value;
	}
}
