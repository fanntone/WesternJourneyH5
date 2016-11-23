package com.jinglei.packets.stoc;

import com.jinglei.server.logic.JSONBean;


/**
 * <pre>
 * 	Class Name  : 			BonusResult
 * 	Description :           S->C 小遊戲的結果
 * 	Modification Information
 * 						BonusResult			int  	給玩家的圖(0: 女童,1:男童,2:奶奶,3:公公)
 *						GetJPPoint			int  	贏得JP彩金的金額
 *						UserPoint			int  	玩家現有金額
 *						TableJpBonus1		int  	小彩金,顯示用
 *						TableJpBonus2		int  	中彩金,顯示用
 **						GameJpBonus			int  	遊戲彩金,累積彩金金額,顯示用
 **						PlatformJpBouns		int  	平台彩金,累積彩金金額,顯示用
 *					
 * </pre>
 *
 * @author Bear Wu
 * @since 2016. 11. 11.
 * @version 
 *
 */
public class BonusResult implements JSONBean {

	/*
	 * JSON Name
	 */
	//public String Name = new String("BonusResult");
	
	/*
	 * (non-Javadoc)
	 * @see com.jinglei.server.logic.JSONBean#getName()
	 */
	@Override
	public String getName() {
		//return new String(this.getClass().getName());
		return new String("BonusResult");
	}
	
	/*
	 * BonusResult			int		給玩家的圖(0: 女童,1:男童,2:奶奶,3:公公)
	 */
	public Integer BonusResult = 0;
	
	public Integer getBonusResult() {
		return this.BonusResult;
	}
	
	public void setBonusResult(Integer result) {
		this.BonusResult = result;
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
	 * UserPoint			int		玩家現有金額
	 */
	public Integer UserPoint = 0;
	
	public Integer getUserPoint() {
		return this.UserPoint;
	}
	
	public void setUserPoint(Integer point) {
		this.UserPoint = point;
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
	 * BonusResult construct
	 */
	public BonusResult() {
		//super();
	}
	
	/*
	 * BonusResult construct
	 * 			BonusResult			int  	給玩家的圖(0: 女童,1:男童,2:奶奶,3:公公)
	 *			GetJPPoint			int  	贏得JP彩金的金額
	 *			UserPoint			int  	玩家現有金額
	 *			TableJpBonus1		int  	小彩金,顯示用
	 *			TableJpBonus2		int 	中彩金,顯示用
	 *			GameJpBonus			int		遊戲彩金,累積彩金金額,顯示用
	 *			PlatformJpBouns		int		平台彩金,累積彩金金額,顯示用
	 */
	public BonusResult( Integer bonus_result,Integer jp_point,
						Integer user_point,Integer jp_bonus1,
					    Integer jp_bonus2,Integer game_jp_bonus,
					    Integer platform_jp_bonus) {
		
		this.BonusResult		= 	bonus_result;
		this.GetJPPoint			=	jp_point;
		this.UserPoint			=	user_point;
		this.TableJpBonus1		=	jp_bonus1;
		this.TableJpBonus2		=	jp_bonus2;
		this.GameJpBonus		=	game_jp_bonus;
		this.PlatformJpBouns	=	platform_jp_bonus;
	}

}
