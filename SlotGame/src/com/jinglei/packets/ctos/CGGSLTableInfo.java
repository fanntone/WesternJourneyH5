package com.jinglei.packets.ctos;

import com.jinglei.server.logic.JSONBean;

public class CGGSLTableInfo implements JSONBean {

//	struct CGGSLTableInfo
//	{
//		Int				Auto;								// 填入1即可
//	};
	
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return new String("CGGSLTableInfo");
	}
	
	public CGGSLTableInfo() {
		
	}
	
	public int Auto_ = 1;
	
	
}
