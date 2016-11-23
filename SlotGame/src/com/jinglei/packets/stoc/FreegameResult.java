package com.jinglei.packets.stoc;

import com.jinglei.server.logic.JSONBean;

/**
 * <pre>
 * 	Class Name  : 			FreegameResult
 * 	Description :           S->C Freegame每一次的結果(有進入的話)
 * 	Modification Information
 * 						LastTime			int  	剩餘次數
 *						UserPoint			int  	現有金額
 *						LineWinPoints		int  	贏得連線金額
 *						FreeTotalWinPoint	int  	累積贏得金額(含一般遊戲贏得的金額 不含freegame中 中的JP)
 *						Wheel[15]			int[]  	15格資料(1:9, 2:10, 3:11, 4:Q, 
 *														   5:K, 6:A, 7:銅板, 8:元寶, 
 *														   9:鳳凰, 10:帆船, 11:烏龜, 12:元寶-金, 
 *														   13:鳳凰-金, 14:帆船-金, 15:烏龜-金, 
 *														   16:Scatter(免費遊戲), 17:wild鬼牌)
 *													Grid[15] 跟 Wheel[15]  要傳直式  15輪的資料  要從左邊 1~3,4~6
 *															1,4,7,10,13
 *															2,5,8,11,14
 *															3,6,9,12,15
 *															
 *						Line				int		有中的線
 *						Farme				int     該線中幾格
 *						TableJpBonus1		int     小彩金,顯示用
 *						TableJpBonus2		int     中彩金,顯示用
 *						GameJpBonus			int		遊戲彩金,累積彩金金額,顯示用
 *						PlatformJpBouns		int		平台彩金,累積彩金金額,顯示用
 *						GetJPPoint			int		贏得JP彩金的金額
 *						AwardKind1			int     獎項(0:無,1:普通開獎, 2:FreeSpin, 3:小遊戲)
 *						AwardKind2			int     指定彩金種類 0:無,1:活動彩金,2:福氣彩金小彩金,3:魚躍彩金中彩金,4:長壽彩金該遊戲彩金,5:發財彩金平台總彩金.
 *					
 * </pre>
 *
 * @author Bear Wu
 * @since 2016. 11. 11.
 * @version 
 *
 */
public class FreegameResult implements JSONBean {

	/*
	 * JSON Name
	 */
	//public String Name = new String("FreegameResult");
	
	/*
	 * (non-Javadoc)
	 * @see com.jinglei.server.logic.JSONBean#getName()
	 */
	@Override
	public String getName() {
		//return new String(this.getClass().getName());
		return new String("FreegameResult");
	}
	
	/*
	 * LastTime	int  	剩餘次數
	 */
	public Integer LastTime = 0;
	
	public Integer getLastTime() {
		return this.LastTime;
	}
	
	public void setLastTime(Integer times) {
		this.LastTime = times;
	}
	
	/*
	 * UserPoint			int  	現有金額
	 */
	public Integer UserPoint = 0;
	
	public Integer getUserPoint() {
		return this.UserPoint;
	}
	
	public void setUserPoint(Integer point) {
		this.UserPoint = point;
	}
	
	/*
	 * LineWinPoints		int  	贏得連線金額
	 */
	public Integer LineWinPoints = 0;
	
	public Integer getLineWinPoints() {
		return this.LineWinPoints;
	}
	
	public void setLineWinPoints(Integer point) {
		this.LineWinPoints = point;
	}
	
	/*
	 * FreeTotalWinPoint		int  	累積贏得金額(含一般遊戲贏得的金額 不含freegame中 中的JP)
	 */
	public Integer FreeTotalWinPoint = 0;
	
	public Integer getFreeTotalWinPoint() {
		return this.FreeTotalWinPoint;
	}
	
	public void setFreeTotalWinPoint(Integer point) {
		this.FreeTotalWinPoint = point;
	}
	
	/*
	 * Wheel[15]			int[]  	15格資料(1:9, 2:10, 3:11, 4:Q, 
	 *									   5:K, 6:A, 7:銅板, 8:元寶, 
	 *									   9:鳳凰, 10:帆船, 11:烏龜, 12:元寶-金, 
	 *									   13:鳳凰-金, 14:帆船-金, 15:烏龜-金, 
	 *									   16:Scatter(免費遊戲), 17:wild鬼牌)
	 */
	public Integer[] Wheel = { 1,2,3,4,5,
							   6,7,8,9,10,
							   11,12,13,14,15};
	
	public Integer[] getWheel() {
		return this.Wheel;
	}
	
	public void setWheel(Integer[] whell) {
		this.Wheel = null;
		this.Wheel = new Integer[whell.length];
		// array copy
		System.arraycopy( whell, 0, this.Wheel, 0, whell.length );
	}
	
	/*
	 * Line				int		有中的線
	 */
	public Integer Line = 0;
	
	public Integer getLine() {
		return this.Line;
	}
	
	public void setLine(Integer line) {
		this.Line = line;
	}
	
	/*
	 * Farme				int     該線中幾格
	 */
	public Integer Farme = 0;
	
	public Integer getFarme() {
		return this.Farme;
	}
	
	public void setFarme(Integer farme) {
		this.Farme = farme;
	}
	
	/*
	 * TableJpBonus1		int     小彩金,顯示用
	 */
	public Integer TableJpBonus1 = 0;
	
	public Integer getTableJpBonus1() {
		return this.TableJpBonus1;
	}
	
	public void setTableJpBonus1(Integer point) {
		this.TableJpBonus1 = point;
	}
	
	/*
	 * TableJpBonus2		int     中彩金,顯示用
	 */
	public Integer TableJpBonus2 = 0;
	
	public Integer getTableJpBonus2() {
		return this.TableJpBonus2;
	}
	
	public void setTableJpBonus2(Integer point) {
		this.TableJpBonus2 = point;
	}
	
	/*
	 * GameJpBonus			int		遊戲彩金,累積彩金金額,顯示用
	 */
	public Integer GameJpBonus = 0;
	
	public Integer getGameJpBonus() {
		return this.TableJpBonus2;
	}
	
	public void setGameJpBonus(Integer point) {
		this.GameJpBonus = point;
	}
	
	/*
	 * PlatformJpBouns		int		平台彩金,累積彩金金額,顯示用
	 */
	public Integer PlatformJpBouns = 0;
	
	public Integer getPlatformJpBouns() {
		return this.PlatformJpBouns;
	}
	
	public void setPlatformJpBouns(Integer point) {
		this.PlatformJpBouns = point;
	}
	
	/*
	 * GetJPPoint			int		贏得JP彩金的金額
	 */
	public Integer GetJPPoint = 0;
	
	public Integer getGetJPPoint() {
		return this.GetJPPoint;
	}
	
	public void setGetJPPoint(Integer point) {
		this.GetJPPoint = point;
	}
		
	/*
	 * AwardKind1			int     獎項(0:無,1:普通開獎, 2:FreeSpin, 3:小遊戲)
	 */
	public Integer AwardKind1 = 0;
	
	public Integer getAwardKind1() {
		return this.AwardKind1;
	}
	
	public void setAwardKind1(Integer kind) {
		this.AwardKind1 = kind;
	}	

	/*
	 * AwardKind2			int     指定彩金種類 0:無,1:活動彩金,2:福氣彩金小彩金,3:魚躍彩金中彩金,4:長壽彩金該遊戲彩金,5:發財彩金平台總彩金.
	 */
	public Integer AwardKind2 = 0;
	
	public Integer getAwardKind2() {
		return this.AwardKind2;
	}
	
	public void setAwardKind2(Integer kind) {
		this.AwardKind2 = kind;
	}
	
	
	/*
	 * FreegameResult construct
	 */
	public FreegameResult() {
		//super();
	}
	
	/*
	 * FreegameResult construct
	 *  		LastTime				int  	押注狀態( 0: 押注成功 1: 非押注時間押注 2:押注超過本金 3:押注值不符)
	 *			UserPoint			int  	現有金額
	 *			LineWinPoints		int  	贏得連線金額
	 *			TotalWinPoint		int  	總贏得金額 (0:輸了 大於0:贏了 含JP)
	 *			Wheel[15]			int[]  	15格資料(1:9, 2:10, 3:11, 4:Q, 
	 *											   5:K, 6:A, 7:銅板, 8:元寶, 
	 *											   9:鳳凰, 10:帆船, 11:烏龜, 12:元寶-金, 
	 *											   13:鳳凰-金, 14:帆船-金, 15:烏龜-金, 
	 *											   16:Scatter(免費遊戲), 17:wild鬼牌)
	 *			Line				int		有中的線
	 *			Farme				int     該線中幾格
	 *			AwardKind1			int     獎項(0:無,1:普通開獎, 2:FreeSpin, 3:小遊戲)
	 *			AwardKind2			int     指定彩金種類 0:無,1:活動彩金,2:福氣彩金小彩金,3:魚躍彩金中彩金,4:長壽彩金該遊戲彩金,5:發財彩金平台總彩金.
	 *			GetJPPoint			int		贏得JP彩金的金額
	 *			TableJpBonus1		int     小彩金,顯示用
	 *			TableJpBonus2		int     中彩金,顯示用
	 *			GameJpBonus			int		遊戲彩金,累積彩金金額,顯示用
	 *			PlatformJpBouns		int		平台彩金,累積彩金金額,顯示用
	 */
	public FreegameResult(Integer times,Integer user_point,Integer line_win_points,
					 Integer free_total_win_point,Integer[] whell,Integer line,
					 Integer farme,Integer award_kind_1,Integer award_kind_2,
					 Integer gat_jp_point,Integer table_jp_bonus_1,Integer table_jp_bonus_2,
					 Integer game_jp_bonus,Integer platform_jp_bouns) {		
		this.LastTime			=	times;
		this.UserPoint			=	user_point;
		this.LineWinPoints		=	line_win_points;
		this.FreeTotalWinPoint	=	free_total_win_point;
		this.setWheel(whell);
			
		this.Line				=	line;
		this.Farme				=	farme;
		this.AwardKind1			=	award_kind_1;
		this.AwardKind2			=	award_kind_2;
		this.GetJPPoint			=	gat_jp_point;
		this.TableJpBonus1		=	table_jp_bonus_1;
		this.TableJpBonus2		=	table_jp_bonus_2;
		this.GameJpBonus		=	game_jp_bonus;
		this.PlatformJpBouns	=	platform_jp_bouns;		
	}	

}
