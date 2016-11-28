package com.jinglei.game.server.common;

public enum CGCardTypes {
    CARD_TYPE_MEMBER(0),
    CARD_TYPE_MAX(1);
    
    private int value_;

    private CGCardTypes(int value) {
        this.value_ = value;
    }

    public int GetValue() {
    	return value_;
    }
}
