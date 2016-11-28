package com.jinglei.game.server.common;


public enum CGCoinTypes {
	COIN_TYPE_V_COIN(0),		///< 有價幣
	COIN_TYPE_F_COIN(1),		///< 免費幣
	COIN_TYPE_MAX(2);
	
    private int value_;

    private CGCoinTypes(int value) {
        this.value_ = value;
    }

    public int GetValue() {
    	return value_;
    }
}
