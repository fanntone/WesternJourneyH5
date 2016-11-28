package com.jinglei.game.server.common;


public enum CGGrpTypes {
    GRP_TYPE_STC_PLAYERS(0),		///< 固定人數
    GRP_TYPE_DYN_PLAYERS(1);		///< 動態人數
    
    private int value_;

    private CGGrpTypes(int value) {
        this.value_ = value;
    }

    public int GetValue() {
    	return value_;
    }
}
