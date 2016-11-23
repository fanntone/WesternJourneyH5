package com.jinglei.packets.ctos;

import com.jinglei.server.logic.JSONBean;

/**
 * <pre>
 * 	Class Name  : 			Guess
 * 	Description :           C->S 玩家點小遊戲
 *  Request 	:			Bonus
 *  Responses	:			BonusResult
 * 	Modification Information
 *						BonusBet   		int  玩家點了第幾格
 * 
 *
 * </pre>
 *
 * @author Bear Wu
 * @since 2016. 11. 11.
 * @version 
 *
 */
public class Bonus implements JSONBean {

	/*
	 * JSON Name
	 */
	//public String Name = new String("Bonus");
	
	/*
	 * (non-Javadoc)
	 * @see com.jinglei.server.logic.JSONBean#getName()
	 */
	@Override
	public String getName() {
		//return new String(this.getClass().getName());
		//return this.Name;
		return new String("Bonus");
	}
	
	/*
	 * 	BonusBet   		int  玩家點了第幾格
	 */
	public  Integer BonusBet		= 0;
	
	public  Integer getBonusBet() {
		return this.BonusBet;
	}
	
	public void setBonusBet(Integer bet) {
		this.BonusBet = bet;
	}
	
	/*
	 * 		Bonus construct
	 *			BonusBet   		int  玩家點了第幾格
	 */	
	public Bonus(Integer bonus_bet) {
		this.BonusBet 			=   bonus_bet;
	}
	
	/*
	 * 		Bonus construct
	 */	
	public Bonus() {

	}

}
