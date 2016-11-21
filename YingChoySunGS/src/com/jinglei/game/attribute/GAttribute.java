package com.jinglei.game.attribute;

/*
 *  玩家基本資料 介面
 */
public interface GAttribute extends GameCore {
	
	/*
	 *  取得玩家 MySQL 編號  玩家唯一碼
	 */
	public abstract Integer getMemberID();
	
	/*
	 *  設定玩家 編號 唯一編號
	 */	
	public abstract void setMemberID(Integer iUniqueid);
	
	/*
	 *  取得 玩家幣別
	 */
	public abstract Integer getCurrencyID();
	
	/*
	 *  設定 玩家幣別
	 */	
	public abstract void setCurrencyID(Integer iUniqueid);
	
	
	/*
	 *  取得玩家帳號
	 */
	public abstract String getAccount();
	
	/*
	 *  設定 玩家帳號
	 */
	public abstract void setAccount(String strUniqueAccount);
	
	/*
	 *  取得玩家 密碼
	 */
	public abstract String getPassword();
	
	/*
	 * 設定玩家密碼
	 */
	public abstract void setPassword(String strPassword);
	
	/*
	 * 取得玩家 暱稱
	 */
	public abstract String getNickName();
	
	/*
	 * 設定玩家暱稱
	 */	
	public abstract void setNickName(String strNickName);	
	
	/*
	 *  取得 密碼錯誤次數（預設連續錯誤6次不得登入）
	 */
	public abstract Integer getErrorCount();
	
	/*
	 *  設定 密碼錯誤次數（預設連續錯誤6次不得登入）
	 */	
	public abstract void setErrorCount(Integer iUniqueid);	
	
	/*
	 *  取得 玩家現有點數（已乘100的正整數）
	 */
	public abstract Integer getPoints();
	
	/*
	 *  設定 玩家現有點數（已乘100的正整數）
	 */	
	public abstract void setPoints(Integer iUniqueid);	
	
	
	/*
	 *  取得 玩家在線狀態（不在線為0）
	 */
	public abstract Integer getGameID();
	
	/*
	 *  設定 玩家在線狀態（不在線為0）
	 */	
	public abstract void setGameID(Integer iUniqueid);	
	
	/*
	 *  取得 帳號是否可用（0：不可用、1：可用）
	 */
	public abstract Boolean getUseInfo();
	
	/*
	 *  設定帳號是否可用（0：不可用、1：可用）
	 */	
	public abstract void setUseInfo(Boolean bUniqueid);	
	
	
	/*
	 *  設定 玩家所使用的語言
	 */	
	public abstract void setLanguageID(Integer iUniqueid);
	
	/*
	 *  取得 玩家所使用的語言
	 */
	public abstract Integer getLanguageID();
	
	/*
	 *  設定 玩家所使用的裝置
	 */	
	public abstract void setEquipmentID(Integer iUniqueid);	
	
	/*
	 *  取得 玩家所使用的裝置
	 */
	public abstract Integer getEquipmentID();	
	
	
	/*
	 *  取得 玩家的IP位置
	 */
	public abstract String getIP();
	
	/*
	 *  設定 玩家的IP位置
	 */	
	public abstract void setIP(String strUniqueid);	

	
	/*
	 *  設定 基本資料
	 */	
	public void setAttribute(Integer member_id,Integer currency_id,
							 String  account_id,String nick_name,String pass_word,
							 Integer error_count,Integer point,
							 Integer game_id,Boolean use_info,
							 Integer language_id,Integer equipment_id,String ip_add);	
		
}
