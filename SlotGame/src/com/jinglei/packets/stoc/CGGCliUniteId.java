package com.jinglei.packets.stoc;

import com.jinglei.server.logic.JSONBean;

public class CGGCliUniteId implements JSONBean {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public CGGCliUniteId() {
		
	}

//	struct CGGCliUniteId
//	{
//		char			group_unique_id_[32];				//將號
//	};
	
	private int[] GroupUniqueId_ = new int[32];
	
	public int getGroupUniqueId(int index) {
		return this.GroupUniqueId_[index];
	}
	
	public void setGroupUniqueId(int index, int value) {
		this.GroupUniqueId_ [index] = value;
	}
	
}
