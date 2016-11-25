package com.jinglei.packets.stoc;

import com.jinglei.server.logic.JSONBean;

public class CGGCliGameReLogin implements JSONBean {

//	struct CGCliGameReLogin
//	{
//		Int				State;								// 0:失敗, 1:成功
//	};
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return new String("CGGCliGameReLogin");
	}
	
	public CGGCliGameReLogin() {
		
	}
	
	public int State_ = 1;
	

}
