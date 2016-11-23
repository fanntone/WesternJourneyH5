package com.jinglei.game;

import java.util.List;

import com.jinglei.game.attribute.impl.GClonePlayer;
import com.jinglei.channel.NettyClientChannel;

/*
* 處理 相關邏輯  基礎繼承 class
* @title   				ExecuteClassBase
* @
* @description 			
* @
* @author Bear Wu 2016.11.03
*/
public abstract class ExecuteClassBase {
	
	
	public ExecuteClassBase() {
		
	}	
	
	protected int executeType = 0;
	
	public int getExecuteType() {
		return this.executeType;
	}
	
	public void setExecuteType(int type ) {
		this.executeType = type;	
	}
	
	private String  executeClassName = "";
	
	public String getExecuteClassName() {
		return this.executeClassName;
	}
	
	public void	setExecuteClassName(String className) {
		this.executeClassName = className;
	}
	
	public ExecuteClassBase  getExecute()  {
		if ( this.executeClassName != null && !this.executeClassName.equals("")) {
			try {
				return (ExecuteClassBase)Class.forName(this.executeClassName).newInstance();
			} 
			catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		return null;
	}
	
	public abstract ExecuteClassBase newInstance();
	
	public abstract String getExecuteName();
	
	public abstract void Execute();
}