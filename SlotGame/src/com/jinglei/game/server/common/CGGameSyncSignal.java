package com.jinglei.game.server.common;

//同步訊號
public enum CGGameSyncSignal {
	GSSIGNAL_MAX(0);
	
    private int value_;

    private CGGameSyncSignal(int value) {
        this.value_ = value;
    }

    public int GetValue() {
    	return value_;
    }
	
}
