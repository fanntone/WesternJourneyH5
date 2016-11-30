package com.jinglei.packets.ctos;

import com.jinglei.server.logic.JSONBean;

public class CGGSLRandomOddsInfo implements JSONBean {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return new String("CGGSLRandomTimesInfo");
	}
	
	public CGGSLRandomOddsInfo() {
		
	}
	
//	struct CGGSLRandomTimesInfo
//	{
//		int			    Auto;								// 0:不要  1:要  (填入1即可)
//	};
	
	public int Auto_ = 1;

}
