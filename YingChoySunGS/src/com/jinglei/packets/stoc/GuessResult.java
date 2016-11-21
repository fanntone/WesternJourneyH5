package com.jinglei.packets.stoc;

import com.jinglei.server.logic.JSONBean;

/**
 * <pre>
 * 	Class Name  : 			GuessRessResult
 * 	Description :           S->C 比倍的結果,並且可以到下一局
 * 	Modification Information
 * 						GuessWinLoss		int  	比倍結果 (0:輸了 1:贏了)
 *						GuessResult			int  	比倍的答案(0:無 1:大,2:小,3:黑桃,4:紅心,5:方塊,6:梅花)
 *						GuessWinPoint		int  	贏得金額
 *						UserPoint			int  	玩家現有金額
 *					
 * </pre>
 *
 * @author Bear Wu
 * @since 2016. 11. 11.
 * @version 
 *
 */
public class GuessResult implements JSONBean {

	/*
	 * JSON Name
	 */
	//public String Name = new String("GuessResult");
	
	/*
	 * (non-Javadoc)
	 * @see com.jinglei.server.logic.JSONBean#getName()
	 */
	@Override
	public String getName() {
		//return new String(this.getClass().getName());
		return new String("GuessResult");
	}
	
	/*
	 * GuessWinLoss	int  	比倍結果 (0:輸了 1:贏了)
	 */
	public Integer GuessWinLoss = 0;
	
	public Integer getGuessWinLoss() {
		return this.GuessWinLoss;
	}
	
	public void setGuessWinLoss(Integer state) {
		this.GuessWinLoss = state;
	}
	
	/*
	 * GuessResult	int  	比倍的答案(0:無 1:大,2:小,3:黑桃,4:紅心,5:方塊,6:梅花)
	 */
	public Integer GuessResult = 0;
	
	public Integer getGuessResulte() {
		return this.GuessResult;
	}
	
	public void setGuessResult(Integer state) {
		this.GuessResult = state;
	}
	
	/*
	 * GuessWinPoint	int  	贏得金額
	 */
	public Integer GuessWinPoint = 0;
	
	public Integer getGuessWinPoint() {
		return this.GuessWinPoint;
	}
	
	public void setGuessWinPoint(Integer point) {
		this.GuessWinPoint = point;
	}
	
	/*
	 * UserPoint	int  	玩家現有金額
	 */
	public Integer UserPoint = 0;
	
	public Integer getUserPoint() {
		return this.UserPoint;
	}
	
	public void setUserPoint(Integer point) {
		this.UserPoint = point;
	}
	
	/*
	 * GuessResult construct
	 */
	public GuessResult() {
		//super();
	}
	
	/*
	 * GuessResult construct
	 * 			GuessWinLoss		int  	比倍結果 (0:輸了 1:贏了)
	 *			GuessResult			int  	比倍的答案(0:無 1:大,2:小,3:黑桃,4:紅心,5:方塊,6:梅花)
	 *			GuessWinPoint		int  	贏得金額
	 *			UserPoint			int  	玩家現有金額	 * 
	 */
	public GuessResult(Integer win_loss,Integer result,
					   Integer win_point,Integer user_point) {
		this.GuessWinLoss		= 	win_loss;
		this.GuessResult		=	result;
		this.GuessWinPoint		=	win_point;
		this.UserPoint			=	user_point;
	}
	
	
}
