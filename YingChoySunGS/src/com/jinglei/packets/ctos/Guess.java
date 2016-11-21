package com.jinglei.packets.ctos;

import com.jinglei.server.logic.JSONBean;

/**
 * <pre>
 * 	Class Name  : 			Guess
 * 	Description :           C->S 玩家要比倍
 *  Request 	:			Guess
 *  Responses	:			GuessResult
 * 	Modification Information
 *						GuessBet   		int  玩家選的比倍答案(0:無 1:大,2:小,3:黑桃,4:紅心,5:方塊,6:梅花)
 *						GuessBetPoint	int	 比倍的金額,不可押比上次嬴的大,比倍點數不可以超過100萬,比倍點數不可超過玩家現有的點數
 * 
 *
 * </pre>
 *
 * @author Bear Wu
 * @since 2016. 11. 11.
 * @version 
 *
 */
public class Guess implements JSONBean {
	
	/*
	 * JSON Name
	 */
	//public String Name = new String("Guess");

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return new String("Guess");
	}
	
	/*
	 * 	GuessBet   		int  玩家選的比倍答案(0:無 1:大,2:小,3:黑桃,4:紅心,5:方塊,6:梅花)
	 */
	public  Integer GuessBet		= 0;
	
	public  Integer getGuessBet() {
		return this.GuessBet;
	}
	
	public void setGuessBet(Integer point) {
		this.GuessBet = point;
	}
	
	/*
	 * 	GuessBetPoint	int	 比倍的金額,不可押比上次嬴的大,比倍點數不可以超過100萬,比倍點數不可超過玩家現有的點數
	 */
	public  Integer GuessBetPoint		= 0;
	
	public  Integer getGuessBetPoint() {
		return this.GuessBetPoint;
	}
	
	public void setGuessBetPoint(Integer point) {
		this.GuessBetPoint = point;
	}
	
	/*
	 * 		Guess construct
	 *			GuessBet   		int  玩家選的比倍答案(0:無 1:大,2:小,3:黑桃,4:紅心,5:方塊,6:梅花)
	 *			GuessBetPoint	int	 比倍的金額,不可押比上次嬴的大,比倍點數不可以超過100萬,比倍點數不可超過玩家現有的點數
	 */	
	public Guess(Integer guess_bet,Integer guess_bet_point) {
		this.GuessBet 			=   guess_bet;
		this.GuessBetPoint		=	guess_bet_point;
	}
	
	/*
	 * 		Guess construct
	 */	
	public Guess() {

	}
}
