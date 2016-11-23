package com.jinglei.game.attribute.impl;

import com.jinglei.game.attribute.GAttribute;

public class GBaseAttribute implements GAttribute {

	/*
	 * Construct GBaseAttribute
	 */
	public GBaseAttribute(Integer member_id, Integer currency_id, 
						  String account_id, String nick_name,
						  String pass_word, Integer error_count, 
						  Integer point, Integer game_id, 
						  Boolean use_info,Integer language_id, 
						  Integer equipment_id, String ip_add) {
		setAttribute(member_id, currency_id, 
					 account_id, nick_name,
					 pass_word, error_count, 
					 point, game_id, 
					 use_info,language_id, 
					 equipment_id, ip_add);		
	}
	
	/*
	 *  設定玩家 編號 唯一編號
	 */
	private volatile Integer m_viMemberID = 0;

	@Override
	public Integer getMemberID() {
		// TODO Auto-generated method stub
		return this.m_viMemberID;
	}

	@Override
	public void setMemberID(Integer iUniqueid) {
		this.m_viMemberID = iUniqueid;		
	}
	
	/*
	 *  取得 玩家幣別
	 */	
	private volatile Integer m_viCurrencyID = 0;
	
	@Override
	public Integer getCurrencyID() {
		return this.m_viCurrencyID;
	}

	@Override
	public void setCurrencyID(Integer iUniqueid) {
		this.m_viCurrencyID = iUniqueid;
		
	}

	/*
	 *   玩家帳號
	 */
	private volatile String m_strAccount ="";

	@Override
	public String getAccount() {
		return this.m_strAccount;
	}

	@Override
	public void setAccount(String strUniqueAccount) {
		this.m_strAccount = strUniqueAccount;		
	}
	
	
	/*
	 * 玩家密碼
	 */
	private volatile String m_strPassWord ="";

	@Override
	public String getPassword() {
		return this.m_strPassWord;
	}

	@Override
	public void setPassword(String strPassword) {
		this.m_strPassWord = strPassword;		
	}

	
	/*
	 * 玩家 暱稱
	 */
	private volatile String m_strNickName ="";
	
	@Override
	public String getNickName() {
		return m_strNickName;
	}

	@Override
	public void setNickName(String strNickName) {
		this.m_strNickName = strNickName;		
	}
	
	
	/*
	 *   密碼錯誤次數（預設連續錯誤6次不得登入）
	 */
	private volatile Integer m_viErrorCount = 0;
	
	@Override
	public Integer getErrorCount() {
		return this.m_viErrorCount;
	}

	@Override
	public void setErrorCount(Integer iUniqueid) {
		this.m_viErrorCount = iUniqueid;		
	}
	
	/*
	 *  玩家現有點數（已乘100的正整數）
	 */
	private volatile Integer m_viPoint = 0;
	@Override
	public Integer getPoints() {
		return this.m_viPoint;
	}

	@Override
	public void setPoints(Integer iUniqueid) {
		this.m_viPoint = iUniqueid;
		
	}
	
	/*
	 * (non-Javadoc)  玩家在線狀態（不在線為0）
	 * @see com.jinglei.game.attribute.GAttribute#getGameID()
	 */
	private volatile Integer m_viGameID = 0;
	
	@Override
	public Integer getGameID() {
		return this.m_viGameID;
	}

	@Override
	public void setGameID(Integer iUniqueid) {
		this.m_viGameID = iUniqueid;		
	}
	
	/*
	 * (non-Javadoc) 帳號是否可用（0：不可用、1：可用）
	 * @see com.jinglei.game.attribute.GAttribute#getUseInfo()
	 */
	
	private volatile Boolean m_vbInfo = false;
	@Override
	public Boolean getUseInfo() {
		return this.m_vbInfo;
	}

	@Override
	public void setUseInfo(Boolean bUniqueid) {
		this.m_vbInfo = bUniqueid;
		
	}
	
	/*
	 * (non-Javadoc)  玩家所使用的語言
	 * @see com.jinglei.game.attribute.GAttribute#getLanguageID()
	 */
	private volatile Integer m_viLanguage = 0;
	@Override
	public Integer getLanguageID() {
		return this.m_viLanguage;
	}
	
	@Override
	public void setLanguageID(Integer iUniqueid) {
		this.m_viLanguage = iUniqueid;
	}
	
	/*
	 * (non-Javadoc) 玩家所使用的裝置
	 * @see com.jinglei.game.attribute.GAttribute#setEquipmentID(java.lang.Integer)
	 */
	private volatile Integer m_viEquipment = 0;
	@Override
	public void setEquipmentID(Integer iUniqueid) {
		this.m_viEquipment = iUniqueid;		
	}

	@Override
	public Integer getEquipmentID() {
		return this.m_viEquipment;
	}
	
	/*
	 * (non-Javadoc)  玩家的IP位置
	 * @see com.jinglei.game.attribute.GAttribute#getIP()
	 */
	private volatile String m_strIP = "127.0.0.1";
	@Override
	public String getIP() {
		return this.m_strIP;
	}

	@Override
	public void setIP(String strUniqueid) {
		this.m_strIP = strUniqueid;		
	}
	

	@Override
	public String getClassName() {
		//return "GBaseAttribute";
		return new String(this.getClass().getName());
	}
	

	

	@Override
	public void setAttribute(Integer member_id, Integer currency_id, String account_id, String nick_name,
							 String pass_word, Integer error_count, Integer point, Integer game_id, Boolean use_info,
							 Integer language_id, Integer equipment_id, String ip_add) {
		/*
		 *  設定玩家 編號 唯一編號
		 */
		setMemberID(member_id);
		
		/*
		 *  取得 玩家幣別
		 */			
		setCurrencyID(currency_id);

		/*
		 *   玩家帳號
		 */
		setAccount(account_id);
		
		
		/*
		 * 玩家密碼
		 */
		setPassword(pass_word);
		
		/*
		 * 玩家 暱稱
		 */
		setNickName(nick_name);
		
		
		/*
		 *   密碼錯誤次數（預設連續錯誤6次不得登入）
		 */
		setErrorCount(error_count);
		
		/*
		 *  玩家現有點數（已乘100的正整數）
		 */
		setPoints(point);
		
		/*
		 * (non-Javadoc)  玩家在線狀態（不在線為0）
		 * @see com.jinglei.game.attribute.GAttribute#getGameID()
		 */
		setGameID(game_id);
		
		/*
		 * (non-Javadoc) 帳號是否可用（0：不可用、1：可用）
		 * @see com.jinglei.game.attribute.GAttribute#getUseInfo()
		 */
		setUseInfo(use_info);
		
		/*
		 * (non-Javadoc)  玩家所使用的語言
		 * @see com.jinglei.game.attribute.GAttribute#getLanguageID()
		 */
		setLanguageID(language_id);
		
		/*
		 * (non-Javadoc) 玩家所使用的裝置
		 * @see com.jinglei.game.attribute.GAttribute#setEquipmentID(java.lang.Integer)
		 */
		setEquipmentID(equipment_id);
		/*
		 * (non-Javadoc)  玩家的IP位置
		 * @see com.jinglei.game.attribute.GAttribute#getIP()
		 */
		setIP(ip_add);		
	}
}