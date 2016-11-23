package com.jinglei.game.util;

import java.util.Iterator;
import java.util.Vector;

public class UtilString {
	
	/**
	 * @function: split string set into vector
	 * 
	 * @param string
	 * @return
	 */
	public static Vector StringToVecot(String s){
		Vector v = new Vector();
		if(s!=null){
			String[] array = s.split(",");
			if(array.length!=0){
				for(int i=0;i<=array.length-1;i++)
					v.add(array[i]);
			}
		}
		
		return v;
	}
	
	public static String VectorToString(Vector v){
		StringBuffer result = null;
		if(v!=null){
			result = new StringBuffer();
			Iterator iterator = v.iterator();
			while(iterator.hasNext()){
				String temp = iterator.next().toString()+",";
				result.append(temp);
			}
		}
		return result.toString();
	}
	
	public static String GetProjectRealPath(){
		String rawpath = UtilString.class.getClassLoader().getResource("").getPath().replace('/', '\\').substring(1);
		//String realPath = rawpath.substring(0, rawpath.indexOf("bin"));
		return rawpath;

	}
	
	public static String GetProjectRealPath(String sub){
		String rawpath = UtilString.class.getClassLoader().getResource("").getPath().replace('/', '\\').substring(1);
		String realPath = rawpath.substring(0, rawpath.indexOf(sub));
		return realPath;
	}

}
