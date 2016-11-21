package com.jinglei.packets.stoc;

import com.jinglei.server.logic.JSONBean;


/**
 * <pre>
 * 	Class Name  : 			TabbleInfo
 * 	Description :           S->C 回傳本桌的資訊
 * 	Modification Information
 *						BetMin   			int 	最小押注20
 *						BetMax   			int		最大押注6250
 *						Grid[15]    		int[]	15格的資料 顯示用
 *						UserPoint   		int		玩家現有金額
 *						TableJpBonus1		int     小彩金,顯示用
 *						TableJpBonus2		int     中彩金,顯示用
 * 						GameJpBonus         int		遊戲彩金,累積彩金金額,顯示用
 * 						PlatformJpBouns		int     平台彩金,累積彩金金額,顯示用
 *					
 * </pre>
 *
 * @author Bear Wu
 * @since 2016. 11. 10.
 * @version 
 *
 */
public class TabbleInfo implements JSONBean {
	
	/*
	 * JSON Name
	 */
	//public String Name = new String("TabbleInfo");
	
	/*
	 * (non-Javadoc)
	 * @see com.jinglei.server.logic.JSONBean#getName()
	 */
	@Override
	public String getName() {
		//return new String(this.getClass().getName());
		return new String("TabbleInfo");
	}
	
	/*
	 * BetMin   			int 	最小押注20
	 */
	public Integer BetMin = 20; 
	
	public void setBetMin(Integer min) {
		this.BetMin = min;
	}
	
	public Integer getBetMin() {
		return this.BetMin;
	}
	
	/*
	 * BetMax   			int		最大押注6250
	 */
	public Integer BetMax = 6250; 
	
	public Integer getBetMax() {
		return this.BetMax;
	}
	
	public void setBetMax(Integer max) {
		this.BetMax = max;
	}
	
	/*
	 * Grid[15]    		int[]	15格的資料 顯示用
	 */
	
	public Integer[]  Grid = { 	0,0,0,0,0,
								0,0,0,0,0,
								0,0,0,0,0 };
	
	public Integer[] getGrid() {
		return this.Grid;
	}
	
	public void    setGrid(Integer[] grid) {
		this.Grid = null;
		this.Grid = new Integer[grid.length];
		// array copy
		System.arraycopy( grid, 0, this.Grid, 0, grid.length );
	}
	
	/*
	 * UserPoint   		int		玩家現有金額
	 */
	public Integer UserPoint = 99999; 
	
	public Integer getUserPoint() {
		return this.UserPoint;
	}
	
	public void setUserPoint(Integer point) {
		this.UserPoint = point;
	}
	
	/*
	 * TableJpBonus1		int     小彩金,顯示用
	 */
	public Integer TableJpBonus1 = 88888; 
	
	public Integer getTableJpBonus1() {
		return this.TableJpBonus1;
	}
	
	public void setTableJpBonus1(Integer point) {
		this.TableJpBonus1 = point;
	}
	
	/*
	 * TableJpBonus2		int     中彩金,顯示用
	 */
	public Integer TableJpBonus2 = 1111111; 
	
	public Integer getTableJpBonus2() {
		return this.TableJpBonus2;
	}
	
	public void setTableJpBonus2(Integer point) {
		this.TableJpBonus1 = point;
	}
	
	/*
	 * GameJpBonus         int		遊戲彩金,累積彩金金額,顯示用
	 */
	public Integer GameJpBonus = 77777; 
	
	public Integer getGameJpBonus() {
		return this.GameJpBonus;
	}
	
	public void setGameJpBonus(Integer point) {
		this.GameJpBonus = point;
	}
	
	/*
	 * PlatformJpBouns		int     平台彩金,累積彩金金額,顯示用
	 */
	public Integer PlatformJpBouns = 666666; 
	
	public Integer getPlatformJpBouns() {
		return this.PlatformJpBouns;
	}
	
	public void setPlatformJpBouns(Integer point) {
		this.PlatformJpBouns = point;
	}
	
	/*
	 * TabbleInfo construct
	 */
	public TabbleInfo() {
		//super();
	}
	
	/*
	 * TabbleInfo construct
	 *						BetMin   			int 	最小押注20
	 *						BetMax   			int		最大押注6250
	 *						Grid[15]    		int[]	15格的資料 顯示用
	 *						UserPoint   		int		玩家現有金額
	 *						TableJpBonus1		int     小彩金,顯示用
	 *						TableJpBonus2		int     中彩金,顯示用
	 * 						GameJpBonus         int		遊戲彩金,累積彩金金額,顯示用
	 * 						PlatformJpBouns		int     平台彩金,累積彩金金額,顯示用
	 * 
	 */	
	public TabbleInfo(Integer min,Integer max,Integer[] grid,
					  Integer point,Integer jpb1,Integer jpb2,
					  Integer gjpb,Integer pfjb) {
		
		this.BetMin 		= min;
		this.BetMax 		= max;
		this.setGrid(grid);
		this.UserPoint		= point;
		this.TableJpBonus1	= jpb1;
		this.TableJpBonus2	= jpb2;
		this.GameJpBonus    = gjpb;
		this.PlatformJpBouns =pfjb;		
	}

}
