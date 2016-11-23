package com.jinglei.game.server.log;

import org.apache.log4j.MDC;

public class LogWriter {
	public static void setName(String name){
		if(name == null)	
			name = "";
		
		MDC.put("logWriter", name);
	}
	
	public static void clean(){
		MDC.remove("logWriter");
	}
}
