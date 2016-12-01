package com.jinglei.game.util;

/**
 * <pre>
 * 	Class Name  :   UtilCoordinates 
 * 	Description :   記算經緯距離
 * 	Modification Information
 *
 * </pre>
 *
 * @author Bear Wu
 * @since 2016. 01. 21.
 * @version 
 *
 */
public class UtilCoordinates {
    private static final double PI = 3.14159265;  
    private static final double EARTH_RADIUS = 6378137;  
    private static final double RAD = Math.PI / 180.0;  
    
     
    
    //The circumference of the earth is 24,901 miles.  
    //地球的周長是24901英里。
    //24,901/360 = 69.17 miles(英里) / degree (度) 
    
    /** 
     * @param raidus 單位為 米 
     * return minLat,minLng,maxLat,maxLng 
     */  
    
    /**
     * <pre>
     * 	Function Name  :   getAround 
     * 	Description   :   取得範圍
     * 	Modification Information
     * 
     *  @param arg1     double lat 		 (latitude)  緯度
     *  @param arg2     double lon		 (longitude) 經度
     *  @param arg3     int raidus       範圍大小 單位(米)
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
