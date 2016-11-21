package com.jinglei.packets.stoc;

import com.jinglei.server.logic.JSONBean;


/**
 * <pre>
 * 	Class Name  : 			GroupID
 * 	Description :           S->C 通知遊戲下一局將號
 * 	Modification Information
 * 						GroupID			int  	將號
 *					
 * </pre>
 *
 * @author Bear Wu
 * @since 2016. 11. 11.
 * @version 
 *
 */
public class GroupID implements JSONBean {

	/*
	 * JSON Name
	 */
	//public String Name = new String("GroupID");
	
	/*
	 * (non-Javadoc)
	 * @see com.jinglei.server.logic.JSONBean#getName()
	 */
	@Override
	public String getName() {
		//return new String(this.getClass().getName());
		return new String("GroupID");
	}
	
	/*
	 * GroupID			int		將號
	 */
	public Integer GroupID = 0;
	
	public Integer getGroupID() {
		return this.GroupID;
	}
	
	public void setGroupID(Integer id) {
		this.GroupID = id;
	}
	
	/*
	 * 		GroupID construct
	 *			GroupID   		int  將號
	 */	
	public GroupID(Integer id) {
		this.GroupID 	=   id;
	}
	
	/*
	 * 		GroupID construct
	 */	
	public GroupID() {
		
	}
	

}
