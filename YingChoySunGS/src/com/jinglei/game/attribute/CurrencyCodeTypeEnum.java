package com.jinglei.game.attribute;

public enum CurrencyCodeTypeEnum {
	CCTE_NON(-1,"NON"),				//沒有幣值
	CCTE_KHMER(116,"KHR"),			//高棉
	CCTE_CHINA(156,"CNY"),			//中華人民共和國
	CCTE_INDONESIA(360,"IDR"),		//印尼
	CCTE_MALAYSIA(458,"MYR"),		//馬來西亞
	CCTE_SINGAPORE(702,"SGD"),		//新加坡
	CCTE_VIETNAM(704,"VND"),		//越南
	CCTE_THAILAND(764,"THB"),		//泰國
	CCTE_DEMO(999,"DEM");			//展示
	
	/*
	 * 狀態
	 */
	private int iType;
	public int  getType() {
		return iType;
	}
	
	public void setType(int type) {
		this.iType = type;
	}
	
	/*
	 * 國家名稱
	 */
	private String strCountry;
	
	public String getCountry() {
		return strCountry;
	}
	
	public void setCountry(String country) {
		this.strCountry = country;
	}
	
	private CurrencyCodeTypeEnum(int type,String country){
		this.iType = type;
		this.strCountry = country;
	}
}
