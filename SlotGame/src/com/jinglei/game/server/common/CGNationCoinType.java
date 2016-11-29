package com.jinglei.game.server.common;

public enum CGNationCoinType {
	CNY(0),
	THB(1),
	MYR(2),
	IDR(3),
	USD(4),
	VNS(5);
	
    private int value_;

    private CGNationCoinType(int value) {
        this.value_ = value;
    }

    public int GetValue() {
    	return value_;
    }
}
