package com.jinglei.packets.ctos;

import com.jinglei.server.logic.JSONBean;

public class CGGSLRandomTimesInfo implements JSONBean {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return new String("CGGSLRandomTimesInfo");
	}
	
	public CGGSLRandomTimesInfo() {
		
	}
	
//	struct CGGSLRandomTimesInfo
//	{
//		int			    Auto;								// 0:不要  1:要  (填入1即可)
//	};
	
	private int Auto_ = 1;
	
	public int getAuto() {
		return this.Auto_;
	}
	
	public void setAuto(int value) {
		this.Auto_ = value;
	}

}
