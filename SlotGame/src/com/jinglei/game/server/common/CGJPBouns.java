package com.jinglei.game.server.common;

public class CGJPBouns {
	
	private static CGJPBouns  instance = null;
	
	public static synchronized  CGJPBouns getInstance() {
		if ( instance == null ) {
			instance = new CGJPBouns();
		}
		
		return instance;
	}
	
	public static int JP_1 = 10000;
	public static int JP_2 = 10000;
	public static int JP_3 = 10000;
	public static int JP_4 = 10000;
	
}
