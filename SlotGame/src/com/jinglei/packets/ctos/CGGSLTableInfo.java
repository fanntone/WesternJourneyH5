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
	
	private int Auto_ = 1;
	
	public int getAuto()
	{
		return this.Auto_;
	}

	public void setAuto(int value) {
		this.Auto_ = value;
	}
	
}
