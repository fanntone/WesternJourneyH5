package com.jinglei.game.manage;

import java.io.IOException;
import java.net.InetAddress;

import com.jinglei.game.DevelopmentVersion;
import com.jinglei.game.SysLog;
import com.jinglei.game.util.UtilString;
import com.maxmind.geoip.LookupService;

/**
 * <pre>
 * 	Class Name  :   GeoipManage 
 * 	Description :   依玩家IP 取得連線國家
 * 	Modification Information
 *  Referenced Libraries : geoip-api-1.2.15.jar
 *
 * </pre>
 *
 * @author Bear Wu
 * @since 2016. 11. 03.
 * @version 
 *
 */
public class GeoipManage {
	
	/*
	 *  GeoipManage Instance
	 */
	private static GeoipManage  instance = null;
	
	private static LookupService lookupService = null;	
	
	private static String   sep = null;
	
	private static String   dir = null;
	
	private static String   filePatch = null;
	
	private GeoipManage() {		
		try {
			if (DevelopmentVersion.VERSION_PRESSURE_TEST) {
				/*
				 * CenOS
				 */
				filePatch = "/opt/resources/GeoIP.dat";
				
			}		
			else {
				/*
				 * Windows
				 */
				sep = System.getProperty("file.separator");			
				dir = UtilString.GetProjectRealPath("bin")+"resources";			
				filePatch = dir + sep + "GeoIP.dat";
			}
			
			lookupService = new LookupService(filePatch,LookupService.GEOIP_MEMORY_CACHE);
		} 
		catch (IOException e) {
			SysLog.PrintError("[Failure]	GeoipManage() Error:" + e.getMessage() +" ....Failure!!!");
		}
		
	}
	
	/*
	 *  取得 GeoipManage Management Instance
	 */
	public static synchronized GeoipManage getInstance()  {
        if (instance == null) {
        	instance = new GeoipManage();
        }

        return instance;
    }
	
	/*
	 *    取得  ip 所屬國家 Code
	 * @param   String ipAddress     ip address
	 * @return  String   國家
	 */
	public synchronized String getCountryCode(String ipAddress) {
		if ( lookupService != null ) {
			return lookupService.getCountry(ipAddress).getCode();
		}
		
		//Not available
		return "N/A";
	}
	
	
	/*
	 *    取得  ip 所屬國家 Code
	 * @param   String ipAddress     ip address
	 * @return  String   國家
	 */
	public static synchronized String getCountryCode(Long ipAddress) {
		if ( lookupService != null ) {
			return lookupService.getCountry(ipAddress).getCode();
		}
		
		//Not available
		return "N/A";
	}
	
	/*
	 *    取得  ip 所屬國家 Code
	 * @param   String ipAddress     ip address
	 * @return  String   國家
	 */
	public static synchronized String getCountryCode(InetAddress ipAddress) {
		if ( lookupService != null ) {
			return lookupService.getCountry(ipAddress).getCode();
		}
		
		//Not available
		return "N/A";
	}
	
	/*
	 *    取得  ip 所屬國家 完整名稱
	 * @param   String ipAddress     ip address
	 * @return  String   國家
	 */
	public static synchronized String getCountryName(String ipAddress) {
		if ( lookupService != null ) {
			return lookupService.getCountry(ipAddress).getName();
		}
		
		//Not available
		return "N/A";
	}
	
	/*
	 *    取得  ip 所屬國家 完整名稱
	 * @param   String ipAddress     ip address
	 * @return  String   國家
	 */
	public static synchronized String getCountryName(Long ipAddress) {
		if ( lookupService != null ) {
			return lookupService.getCountry(ipAddress).getName();
		}
		
		//Not available
		return "N/A";
	}
	
	/*
	 *    取得  ip 所屬國家 完整名稱
	 * @param   String ipAddress     ip address
	 * @return  String   國家
	 */
	public static synchronized String getCountryName(InetAddress ipAddress) {
		if ( lookupService != null ) {
			return lookupService.getCountry(ipAddress).getName();
		}
		
		//Not available
		return "N/A";
	}
	
	
	/*
	 *    取得  ip 所屬國家 完整名稱
	 * @param   String ipAddress     ip address
	 * @return  String   國家
	 */
	public static synchronized String getLocationName(String ipAddress) {
		if ( lookupService != null ) {
			return lookupService.getLocation(ipAddress).city;
		}
		
		//Not available
		return "N/A";
	}
	
	/*
	 *    取得  ip 所屬國家 完整名稱
	 * @param   String ipAddress     ip address
	 * @return  String   國家
	 */
	public static synchronized String getLocationName(Long ipAddress) {
		if ( lookupService != null ) {
			return lookupService.getLocation(ipAddress).city;
		}
		
		//Not available
		return "N/A";
	}
	
	/*
	 *    取得  ip 所屬國家 完整名稱
	 * @param   String ipAddress     ip address
	 * @return  String   國家
	 */
	public static synchronized String getLocationName(InetAddress ipAddress) {
		if ( lookupService != null ) {
			return lookupService.getLocation(ipAddress).city;
		}
		
		//Not available
		return "N/A";
	}	
	
	
	private static final double PI = 3.14159265;  
	private static final double EARTH_RADIUS = 6378137;  
	private static final double RAD = Math.PI / 180.0;  
	    
	private static final double Perimeter = 24901; 
	    
	//The circumference of the earth is 24,901 miles.  
	//地球的周長是24901英里。
	//24,901/360 = 69.17 miles(英里) / degree (度) 
	    
	    
	 /**
	  * <pre>
	  * 	Function Name  :   getAround 
	  * 	Description   :   取得範圍
	  * 	Modification Information
	  * 
	  *  @param arg1     double lat 		 (latitude)  緯度
	  *  @param arg2     double lon		 (longitude) 經度
	  *  @param arg3     int raidus       範圍大小 單位(米)
	  *  @return 		minLat,minLng,maxLat,maxLng 
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 01. 21.
	  * @version 
	  *
	  */
	 public static double[] getAround(double lat,double lon,int raidus)
	 {  
	    Double latitude = lat;  
	    Double longitude = lon;  
	          
	    Double degree = (24901*1609)/360.0;  
	    double raidusMile = raidus;  
	          
	    Double dpmLat = 1/degree;  
	    Double radiusLat = dpmLat*raidusMile;  
	    Double minLat = latitude - radiusLat;  
	    Double maxLat = latitude + radiusLat;  
	          
	    Double mpdLng = degree*Math.cos(latitude * (PI/180));  
	    Double dpmLng = 1 / mpdLng;  
	    Double radiusLng = dpmLng*raidusMile;  
	    Double minLng = longitude - radiusLng;  
	    Double maxLng = longitude + radiusLng;  

	    return new double[]{minLat,minLng,maxLat,maxLng};  
	} 
	    
	 /**
	  * <pre>
	  * 	Function Name  :   getDistance 
	  * 	Description   :    根據兩點間經緯度坐標（double值），計算兩點間距離，單位為米
	  * 	Modification Information
	  * 
	  *  @param arg1     double lat1 	 (latitude)  緯度
	  *  @param arg2     double lon1		 (longitude) 經度
	  *  @param arg3     double lat2 	 (latitude)  緯度
	  *  @param arg4     double lon2		 (longitude) 經度
	  * </pre>
	  *
	  * @author Bear Wu
	  * @since 2016. 01. 21.
	  * @version 
	  *
	 */  
	    public static double getDistance(double lng1, double lat1, double lng2, double lat2)  
	    {  
	       double radLat1 = lat1*RAD;  
	       double radLat2 = lat2*RAD;  
	       double a = radLat1 - radLat2;  
	       double b = (lng1 - lng2)*RAD;  
	       double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) +  
	        Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));  
	       s = s * EARTH_RADIUS;  
	       s = Math.round(s * 10000) / 10000; 	       
	       return s;  
	    }  
	    
	    /**
	     * <pre>
	     * 	Function Name  :   CalculateDistance 
	     * 	Description   :    根據兩點間經緯度坐標（double值），計算兩點間距離，單位為米
	     * 	Modification Information
	     * 
	     *  @param arg1     double lat1 	 (latitude)  緯度
	     *  @param arg2     double lon1		 (longitude) 經度
	     *  @param arg3     double lat2 	 (latitude)  緯度
	     *  @param arg4     double lon2		 (longitude) 經度
	     *  @param arg5     int raidus		 計算兩點間距離，單位為米    距離內
	     *  @return boolean true(範圍內) / false (範圍外)
	     * </pre>
	     *
	     * @author Bear Wu
	     * @since 2016. 01. 21.
	     * @version 
	     *
	     */  
	    public static boolean CalculateDistance(double lng1, double lat1, double lng2, double lat2,int raidus)  
	    {  
	       double radLat1 = lat1*RAD;  
	       double radLat2 = lat2*RAD;  
	       double a = radLat1 - radLat2;  
	       double b = (lng1 - lng2)*RAD;
	       
	       double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) +  
	    		   	  Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));  
	       s = s * EARTH_RADIUS;  
	       s = Math.round(s * 10000) / 10000; 
	       
	       if ( s <= raidus ) {    	   
	    	   return true;
	       }

	       return false;  
	    }  
}

