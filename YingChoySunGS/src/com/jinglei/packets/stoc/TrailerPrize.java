package com.jinglei.packets.stoc;

import com.jinglei.server.logic.JSONBean;

/**
 * <pre>
 * 	Class Name  : 			TrailerPrize
 * 	Description :           S->C 預告
 * 	Modification Information
 * 						Prize			int  	預告送大獎(0:無 1:初級大獎 2:中級大獎 3:高級大獎)
 *					
 * </pre>
 *
 * @author Bear Wu
 * @since 2016. 11. 11.
 * @version 
 *
 */
public class TrailerPrize implements JSONBean {

	/*
	 * JSON Name
	 */
	//public String Name = new String("TrailerPrize");
	
	/*
	 * (non-Javadoc)
	 * @see com.jinglei.server.logic.JSONBean#getName()
	 */
	@Override
	public String getName() {
		//return new String(this.getClass().getName());
		return new String("TrailerPrize");
	}
	
	/*
	 * Prize			int		預告送大獎(0:無 1:初級大獎 2:中級大獎 3:高級大獎)
	 */
	public Integer Prize = 0;
	
	public Integer getPrize() {
		return this.Prize;
	}
	
	public void setPrize(Integer prize) {
		this.Prize = prize;
	}
	
	/*
	 * 		TrailerPrize construct
	 *			Prize   		int  預告送大獎(0:無 1:初級大獎 2:中級大獎 3:高級大獎)
	 */	
	public TrailerPrize(Integer prize) {
		this.Prize 	=   prize;
	}
	
	/*
	 * 		TrailerPrize construct
	 */	
	public TrailerPrize() {
		
	}
}
