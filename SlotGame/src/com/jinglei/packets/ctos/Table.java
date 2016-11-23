package com.jinglei.packets.ctos;

import com.jinglei.server.logic.JSONBean;


/**
 * <pre>
 * 	Class Name  : 			Table
 * 	Description :           C->S 入桌，需要取得本桌的資訊
 *  Request 	:			Table
 *  Responses	:			TabbleInfo
 * 	Modification Information
 *						BetRange   int  選擇押注區(目前填入1即可)
 * 
 *
 * </pre>
 *
 * @author Bear Wu
 * @since 2016. 11. 10.
 * @version 
 *
 */
public class Table implements JSONBean {
	
	/*
	 * JSON Name
	 */
	//public String Name = new String("Table");
	
	/*
	 * (non-Javadoc)
	 * @see com.jinglei.server.logic.JSONBean#getName()
	 */
	@Override
	public String getName() {
		//return new String(this.getClass().getName());
		return new String("Table");
	}
	
	Integer   BetRange = 1;
	
	public Integer getBetRange() {
		return BetRange;
	}
	
	public void  setBetRange(Integer range) {
		this.BetRange = range;
	}	
	
	/*
	 * 		Table construct
	 * 			BetRange   int  選擇押注區(目前填入1即可)
	 */	
	public Table(Integer bet_range) {
		this.BetRange = bet_range;
	}
	
	/*
	 * 		Table construct
	 */	
	public Table() {
	}
}
