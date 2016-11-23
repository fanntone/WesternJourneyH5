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
		return null;
	}
	
	public CGCliGameReLogin() {
		
	}
	
	private int State_;
	
	public int getState() {
		return this.State_;
	}
	
	public void setState(int state) {
		this.State_ = state;
	}

}
