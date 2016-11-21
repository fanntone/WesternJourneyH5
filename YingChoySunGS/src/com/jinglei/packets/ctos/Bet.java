package com.jinglei.packets.ctos;

import com.jinglei.server.logic.JSONBean;


/**
 * <pre>
 * 	Class Name  : 			Bet
 * 	Description :           C->S 押注的資訊
 *  Request 	:			Bet
 *  Responses	:			BetResult
 * 	Modification Information
 *						TotalBetPoint   int  總押注多少
 *						BetLine			int  押注幾條線 (25)
 *						BetAddition		押加成倍數.0:無,1:通寶,2:女童元寶,3:男童鳳凰,4:老婆婆寶船,5:老公公烏龜.
 *
 * 
 *
 * </pre>
 *
 * @author Bear Wu
 * @since 2016. 11. 10.
 * @version 
 *
 */
public class Bet implements JSONBean {
	
	/*
	 * JSON Name
	 */
	//public String Name = new String("Bet");
	
	/*
	 * (non-Javadoc)
	 * @see com.jinglei.server.logic.JSONBean#getName()
	 */
	@Override
	public String getName() {
		//return new String(this.getClass().getName());
		//return this.Name;
		return new String("Bet");
	}
	
	/*
	 * 	TotalBetPoint   int  總押注多少
	 */
	public  Integer TotalBetPoint		= 25;
	
	public  Integer getTotalBetPoint() {
		return this.TotalBetPoint;
	}
	
	public void setTotalBetPoint(Integer tbp) {
		this.TotalBetPoint = tbp;
	}
	
	/*
	 * 	BetLine			int  押注幾條線 (25)
	 */
	public  Integer BetLine		= 25;
	
	public  Integer getBetLine() {
		return this.BetLine;
	}
	
	public void setBetLine(Integer line) {
		this.BetLine= line;
	}
	
	/*
	 * 	BetAddition		押加成倍數.0:無,1:通寶,2:女童元寶,3:男童鳳凰,4:老婆婆寶船,5:老公公烏龜.
	 */
	public  Integer BetAddition		= 0;
	
	public  Integer getBetAddition() {
		return this.BetAddition;
	}
	
	public void setBetAddition(Integer tbp) {
		this.BetAddition = tbp;
	}
	
	/*
	 *			TotalBetPoint   int  總押注多少
	 *			BetLine			int  押注幾條線 (25)
	 *			BetAddition		押加成倍數.0:無,1:通寶,2:女童元寶,3:男童鳳凰,4:老婆婆寶船,5:老公公烏龜.
	 */	
	public Bet(Integer tbp,Integer line,Integer badd) {
		this.TotalBetPoint 	=   tbp;
		this.BetLine		=	line;
		this.BetAddition	=	badd;
	}
	
	/*
	 * 		Bet construct
	 */	
	public Bet() {
		
	}
}
