package com.jinglei.packets.stoc;

import com.jinglei.server.logic.JSONBean;

public class CGCliGameReLogin implements JSONBean {

//	struct CGCliGameReLogin
//	{
//		Int				State;								// 0:失敗, 1:成功
//	};
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return new String("CGCliGameReLogin");
	}
	
	public CGCliGameReLogin() {
		
	}
	
	private int State_ = 0;
	
	public int getState() {
		return this.State_;
	}
	
	public void setState(int value) {
		this.State_ = value;
	}

}
