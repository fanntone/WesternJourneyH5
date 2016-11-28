package com.jinglei.game.server.common;

public enum CGGAActor {
    GRP_TYPE_STC_PLAYERS(0),		///< 固定人數
    GRP_TYPE_DYN_PLAYERS(1);
	
    private int value_;

    private CGGAActor(int value) {
        this.value_ = value;
    }

    public int GetValue() {
    	return value_;
    }
}
