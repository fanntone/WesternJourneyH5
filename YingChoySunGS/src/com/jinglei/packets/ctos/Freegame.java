package com.jinglei.packets.ctos;

import com.jinglei.server.logic.JSONBean;

/**
 * <pre>
 * 	Class Name  : 			Freegame
 * 	Description :           C->S 可以回傳freegame結果了
 *  Request 	:			Freegame
 *  Responses	:			FreegameResult
 * 	Modification Information
 *						FreeTime   int  還有幾次Free Game
 *
 * 
 *
 * </pre>
 *
 * @author Bear Wu
 * @since 2016. 11. 11.
 * @version 
 *
 */
public class Freegame implements JSONBean {

	/*
	 * JSON Name
	 */
	//public String Name = new String("Freegame");
	
	/*
	 * (non-Javadoc)
	 * @see com.jinglei.server.logic.JSONBean#getName()
	 */
	@Override
	public String getName() {
		//return new String(this.getClass().getName());
		return new String("Freegame");
	}
	
	/*
	 * 	FreeTime   int  還有幾次Free Game
	 */
	public  Integer FreeTime		= 0;
	
	public  Integer getFreeTime() {
		return this.FreeTime;
	}
	
	public void setFreeTime(Integer tbp) {
		this.FreeTime = tbp;
	}
	
	/*
	 * 		Freegame construct
	 */	
	public Freegame() {
		
	}
	
	/*
	 * 		Freegame construct
	 * 			FreeTime   int  還有幾次Free Game
	 */	
	public Freegame(Integer free_times) {
		this.FreeTime = free_times;		
	}
	

}
