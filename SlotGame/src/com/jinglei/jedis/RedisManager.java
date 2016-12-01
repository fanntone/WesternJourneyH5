package com.jinglei.jedis;

import com.alibaba.fastjson.JSON;
import com.jinglei.game.DevelopmentVersion;
import com.jinglei.game.GameServerStarter;
import com.jinglei.game.SysLog;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * <pre>
 * 	Class Name  : 		RedisManager
 * 	Description : 		Redis NoSQL
 * 	Modification Information
 *
 * </pre>
 * 
 * <Example>
 * 	  1.	Redis Java String Example
 * 			基本Key-value 儲存
 * 				//Connecting to Redis server on localhost
 * 				Jedis jedis = new Jedis("localhost");
 * 			Set
 * 				jedis.set("tutorial-name", "Redis tutorial");
 * 					or
 * 				已有 tutorial-name Key 則會取代 Value
 * 				如果未 tutorial-name 則會新增
 * 				jedis.append("tutorial-name", "Redis tutorial");
 *			Get 
 *				jedis.get("tutorial-name")
 *
 *	 2.		Redis Java List Example
 *				//Connecting to Redis server on localhost
 *				Jedis jedis = new Jedis("localhost");
 *			Set
 *				jedis.lpush("tutorial-list", "Redis");
 *     			jedis.lpush("tutorial-list", "Mongodb");
 *     			jedis.lpush("tutorial-list", "Mysql");
 *     		Get
 *     			List<String> list = jedis.lrange("tutorial-list", 0 ,5);
 *              for(int i=0; i<list.size(); i++) {
 *              	list.get(i);
 *              }
 *              
 *   3.     Redis Java Keys Example  取得 Redis 所有鍵值
 *   			//Connecting to Redis server on localhost
 *   			Jedis jedis = new Jedis("localhost");
 *   			List<String> list = jedis.keys("*");
 *   			for(int i=0; i<list.size(); i++) {
 *   				list.get(i);
 *   			}
 *   4. mset 設置多個Key-Value值  
 *   		Set
 *   			jedis.mset("key1","value1","key2","value2" ....)
 *          Get
 *          	jedis.mget("key1","key2","key3"...)
 *          
 *   5. Map hmset("map_key",map<key,value> obj);
 *   		Map<String,String> UserMap =  new HashMap<String,String>();
 *   		UserMap.put("name", "cd");
 *   		UserMap.put("password","123456");
 *   		UserMap 存入 Redis
 *   		Set
 *  			 //Connecting to Redis server on localhost
 *   			 Jedis jedis = new Jedis("localhost");
 *   			 jedis.hmset("map_key",UserMap);
 *   
 *   			 // 增加一筆單一資料  
 *   			 jedis.hset("map_key", key, value);
 *   		Get
 *   			取出  整個 Map
 *   			Map<String,String> getMap =  new HashMap<String,String>();
 *   				jedis.hmget("map_key",getMap);
 *    
 *     			取出單一value
 *   				jedis.hget("map_key",key);
 *   			取出 UserMap 裏所有 Key值
 *   				jedis.hkeys("map_key");
 *   			取出 UserMap 裏所有 Value值
 *   				jedis.hvalue("map_key");
 *   			取出 UserMap 裏資料數量
 *   				jedis.hlen("map_key");
 *   
 *   		
 *   		
 * @author Bear Wu
 * @since 2016. 08. 25.
 * @version 
 *
 */
public class RedisManager {
	  private static RedisManager instance 			= 	null;
	  
	  private static JedisPool    jedisPool			=	null;
	  
	  private static JedisPoolConfig config 		= 	null;
	  
	  private static String   redis_service_ip   = "localhost";
	  private static int	  redis_service_port = 6379;
	  private static int	  redis_service_timeout = 2000;
	  
	  private RedisManager() {		  
		  if ( initJedisPoolConfig()) {
			  if ( initJedisPools()) {	

			  }			  
		  }  
	  }
	  
	  public final static boolean initJedisPoolConfig() {
		  try {
			  // Create and set a JedisPoolConfig
			  config = new JedisPoolConfig();
			  config.setMaxTotal(Integer.parseInt(GameServerStarter.getResourceBundle().getString("REDIS_SET_MAX_TOTAL")));
			  config.setMaxIdle(Integer.parseInt(GameServerStarter.getResourceBundle().getString("REDIS_SET_MAX_IDLE")));
			  config.setMaxWaitMillis(Integer.parseInt(GameServerStarter.getResourceBundle().getString("REDIS_SET_WAIT_MILLIS")));			  
			  config.setTestOnBorrow(Boolean.parseBoolean(GameServerStarter.getResourceBundle().getString("REDIS_TEST_ON_BORROW")));
			  config.setTestOnReturn(Boolean.parseBoolean(GameServerStarter.getResourceBundle().getString("REDIS_TEST_ON_RETURN")));
		  }		  
		  catch(Exception e) {
				e.printStackTrace();
				
				SysLog.PrintException("[" + getManageName() + "].[InitJedisPoolConfig] Exception error : " + e.getMessage());
				return false;
		  }
		  finally {

		  }	  

		  
		  return ( config != null) ? true:false;
	  }
	  
	  public final static boolean initJedisPools() {
		  try {			  
			  	if (DevelopmentVersion.VERSION_PRESSURE_TEST) {
			  		redis_service_ip   		= GameServerStarter.getResourceBundle().getString("Game_Redis_IP");	
			  		redis_service_port 		= Integer.parseInt(GameServerStarter.getResourceBundle().getString("Game_Redis_Port"));
			  		redis_service_timeout   = Integer.parseInt(GameServerStarter.getResourceBundle().getString("Game_Redis_TimeOut"));
				}				
				else {
			  		redis_service_ip   		= GameServerStarter.getResourceBundle().getString("Game_Redis_IP");	
			  		redis_service_port 		= Integer.parseInt(GameServerStarter.getResourceBundle().getString("Game_Redis_Port"));
			  		redis_service_timeout   = Integer.parseInt(GameServerStarter.getResourceBundle().getString("Game_Redis_TimeOut"));
				}
			  	
			  	SysLog.PrintError("[Checking].[" + getManageName() + "] redis_service_ip:"+redis_service_ip+" ,redis_service_port:"+redis_service_port+" ,redis_service_timeout:"+redis_service_timeout);
			  	
			  	if ( config != null ) {
			  		jedisPool = new JedisPool(config,redis_service_ip,redis_service_port,redis_service_timeout);
			  		
			  		if ( jedisPool != null ) {
			  			
			  			Jedis pingResponse = jedisPool.getResource();
			  			
			  			if ( pingResponse != null ) {
			  				String serverReturn = pingResponse.ping();
			  				if (!serverReturn.equals("PONG")) {
								throw new Exception("init Jedis connection 初始失敗....Failure!!!");
			  				}
			  				else {
			  					SysLog.PrintError("[" + getManageName() + "].[initJedisPools] Jedis 初始成功...Success!!!");
			  				}				  				
			  			}
			  			
		  				if ( pingResponse != null ) {
		  					pingResponse.close();
						}
			  		}
			  	}
			  	
			  	return (jedisPool != null) ? true:false;
			  	
		  }		  
		  catch(Exception e) {
				e.printStackTrace();
				
				SysLog.PrintException("[" + getManageName() + "].[initJedisPools] Exception error : " + e.getMessage());
				
				jedisPool = null;
				return false;
		  }
		  finally {

		  }	  

	  }
	  
	  public final static Jedis getJedis() {
		  if ( jedisPool != null ) {
			  return jedisPool.getResource();
		  }
		  
		  return null;
	  }
	  
	  
	  public final static RedisManager getInstance() {
		  if ( instance == null ) {
			  instance = new RedisManager();
		  }
		  
		  return instance;
	  }	    
	    
	  public void release() {
		  jedisPool.destroy();
	  }
	  
	  /**
	   *  判斷 Key 值是否存在
	   * @param arg1 key key
	   * @param arg1 value value
	   * @return
	   * @throws Exception
	  */
	  public static boolean  exists(String key) {
			Jedis jedis = null;
			try {
				jedis = jedisPool.getResource();
				jedis.exists(key);
				return jedis.exists(key);
			}
			catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			finally{
				if ( jedis != null ) {
					//pool.returnResource(jedis);
					jedis.close();
				}
			}
		}
	  
		/**
		 * 依key 取得 Class 資料
		 * @param 	arg1  key
		 * @param 	arg2  Class<T> clazz  ->取資料結構
		 * @return  null / Class 
		 */
		public static <T> T  exists(String key,Class<T> clazz){
			Jedis jedis = null;
			try {
				jedis = jedisPool.getResource();
				String value = jedis.get(key);
				return JSON.parseObject(value, clazz);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			finally{
				if ( jedis != null ) {
					//pool.returnResource(jedis);
					jedis.close();
				}
			}
		}

	  
	  /**
	   *  向暫存 存入 資料
	   * @param arg1 key key
	   * @param arg1 value value
	   * @return
	  */
		public static boolean  insert(String key,String value) {
			Jedis jedis = null;
			try {
				jedis = jedisPool.getResource();				
				jedis.set(key, value);
				return true;
			}
			catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			finally{
				if ( jedis != null ) {
					//pool.returnResource(jedis);
					jedis.close();
				}
			}
		}
		
		/**
		 * 向暫存 存入 物件
		 * @param arg1 key 
		 * @param arg2 value
		 * @return
		 */
		public static boolean  insert(String key,Object value) {
			Jedis jedis = null;
			try {
				String objectJson = JSON.toJSONString(value);
				jedis = jedisPool.getResource();
				jedis.set(key, objectJson);
				return true;
			}
			catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			finally{
				if ( jedis != null ) {
					//pool.returnResource(jedis);
					jedis.close();
				}
			}
		}
		
		/**
		 * 刪除緩存資料 依Key 值
		 * @param 		arg1		key
		 * @return
		 */
		public static boolean delete(String key) {
			Jedis jedis = null;
			try {
				jedis = jedisPool.getResource();
				jedis.del(key);
				return true;
			} 
			catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			finally{
				if ( jedis != null ) {
					//pool.returnResource(jedis);					
					jedis.close();
				}
			}
		}
		
		/**
		 * 依 Key 值  取得資料
		 * @param 	arg1 	key
		 * @return  Object
		 */
		public static Object get(String key) {
			Jedis jedis = null;
			try {
				jedis = jedisPool.getResource();
				Object value = jedis.get(key);
				return value;
			} 
			catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			finally {
				if ( jedis != null ) {
					//pool.returnResource(jedis);
					jedis.close();
				}
			}
		}
		

		/**
		 * 根據 key 獲取對象
		 * @param 	arg1  key
		 * @param 	arg2  Class<T> clazz  ->取資料結構
		 * @return
		 */
		public static <T> T  get(String key,Class<T> clazz){
			Jedis jedis = null;
			try {
				jedis = jedisPool.getResource();
				String value = jedis.get(key);
				return JSON.parseObject(value, clazz);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			finally{
				if ( jedis != null ) {
					//pool.returnResource(jedis);
					jedis.close();
				}
			}
		}
		
		/**
		  * <pre>
		  * 	Function Name  : 		getManageName()	 
		  *  @return		   :		String  Manage 名稱
		  *  Description    : 			Manage 名稱
		  *  Modification Information
		   *
		  * </pre>
		  *
		  * @author Bear Wu
		  * @since 2016.05.16
		  * @version 
		  *
		 */
		public static String  getManageName() {
			return "RedisManage()";
		}
}
