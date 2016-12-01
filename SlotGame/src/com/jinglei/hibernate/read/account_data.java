package com.jinglei.hibernate.read;

import java.io.Serializable;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;



/*
 * systemgame.account_db  對應結構
 * 
 * Description :
 * 			call msp_server_login('這邊塞帳號');
 * 			Query query = session.createQuery("call msp_server_login(':account_id')").;
 * 			query.setParameter("account_id", account);
 * 			query.setCacheable(true);
 * 			List<account_db> results = query.list();
 * 
 * @author Bear Wu
 *
 * 緩存的方式 有四種，分別為：
 * 		CacheConcurrencyStrategy.NONE
 *	　　    CacheConcurrencyStrategy.READ_ONLY ，只讀模式，在此模式下，如果對數據進行更新操作，會有異常；
 *	　　    CacheConcurrencyStrategy.READ_WRITE ，讀寫模式在更新緩存的時候會把緩存裡面的數據換成一個鎖，其它事務如果去取相應的緩存數據，發現被鎖了，直接就去數據庫查詢；
 *      CacheConcurrencyStrategy.NONSTRICT_READ_WRITE ，不嚴格的讀寫模式則不會的緩存數據加鎖；
 *      CacheConcurrencyStrategy.TRANSACTIONAL ，事務模式指緩存支持事務，當事務回滾時，緩存也能回滾，只支持 JTA 環境。
 *
 * SQL data type 			Java data type
 *						Simply mappable 	Object mappable
 *	CHARACTER 	  									String
 *	VARCHAR 	  									String
 *	LONGVARCHAR 	  								String
 *	NUMERIC 	  								java.math.BigDecimal
 *	DECIMAL 	  								java.math.BigDecimal
 *	BIT 					boolean 				Boolean
 *	TINYINT 				byte 					Integer
 *	SMALLINT 				short 					Integer
 *	INTEGER 				int 					Integer
 *	BIGINT 					long 					Long
 *	REAL 					float 					Float
 *	FLOAT 					double 					Double
 *	DOUBLE PRECISION 		double 					Double
 *	BINARY 	  										byte[]
 *	VARBINARY 	  									byte[]
 *	LONGVARBINARY 	  								byte[]
 *	DATE 	  									java.sql.Date
 *	TIME 	  									java.sql.Time
 *	TIMESTAMP 	  								java.sql.Timestamp
 *
 *
 *			幣別代碼	幣別縮寫	幣別名稱
 *			 -1		 NON	沒有幣值
 *			 116	 KHR	高棉
 *      	 156	 CNY	中華人民共和國
 * 			 360	 IDR	印尼
 *			 458	 MYR	馬來西亞
 *			 702	 SGD	新加坡
 *			 704	 VND	越南
 *			 764	 THB	泰國
 *			 840	 USD	美國
 *			 999	 DEM	展示
 */
@Entity
@Table(name = "account_data")
@Cacheable(true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="com.jinglei.hibernate.read.account_data")
public class account_data implements Serializable {
	
	 private static final long serialVersionUID = 1L;

	/*
	 *   gamesystem.memberID  對應結構
	 */	
	//@brief 帳戶流水號  參照 gamesystem.memberID
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "memberID", unique=true, nullable=false)
		private volatile Integer   memberID = 0;
		
	//@brief 玩家幣別      參照 gamesystem.currencyID
		@Column(name = "currencyID" , nullable=false)
		private volatile Integer	currencyID = 0;		
	
	//@brief 玩家帳號      參照 gamesystem.account
		@Column(name = "account" , length = 30)
		private volatile String		account = "";
		
	//@brief 玩家暱稱（UTF-8）帳號      參照 	gamesystem.nickname
		@Column(name = "nickname" , length = 30)
		private volatile String		nickname = "";		
	
	//@brief 玩家密碼      參照 gamesystem.pass
		@Column(name = "pass", length = 50)
		private volatile String		pass = "";		
		
		
	//@brief 密碼錯誤次數（預設連續錯誤6次不得登入）
		@Column(name = "errorcount")
		private volatile Integer	errorcount = 0;
		
	//@brief 玩家現有點數（已乘100的正整數）
		@Column(name = "points")
		private volatile Integer	points = 0;
		
	//@brief 玩家在線狀態（不在線為0）
		@Column(name = "gameID")
		private volatile Integer	gameID = 0;
		
	//@brief 帳號是否可用（0：不可用、1：可用）
		@Column(name = "useinfo")
		private volatile Boolean	useinfo = false;
		
	//@brief 玩家在線玩家所使用的語言
		@Column(name = "languageID")
		private volatile Integer	languageID = 0;
		
	//@brief 玩家所使用的裝置
		@Column(name = "equipmentID")
		private volatile Integer	equipmentID = 0;
		
	//@brief 玩家的IP位置
		@Column(name = "ip", length = 20,nullable=false)
		private volatile String 	ip	= "";		

		
	/*
	 * account_data Construction
	 */
	public account_data() {
		//@brief 初始 UionPrimaryKeyIdentity
	}
	
	/*
	 * account_data Construction
	 * @param arg1  Integer 		memberID    玩家唯一碼
	 * @param arg2  Integer     	currencyID  玩家幣別
	 * @param arg3  String 			account		varchar(30) 玩家帳號
	 * @param arg4  String 			nickname	varchar(30) 玩家暱稱（UTF-8）
	 * @param arg5  String 			pass		varchar(50) 玩家密碼
	 * @param arg6  Integer     	errorcount  密碼錯誤次數（預設連續錯誤6次不得登入）
	 * @param arg7  Integer 		points		玩家現有點數（已乘100的正整數）
	 * @param arg8  Integer 		gameID		玩家在線狀態（不在線為0）
	 * @param arg9  Boolean 		useinfo		帳號是否可用（0：不可用、1：可用）
	 * @param arg10 Integer 		languageID	玩家所使用的語言
	 * @param arg11 Integer 		equipmentID	玩家所使用的裝置
	 * @param arg12 String 			ip			varchar(20) 玩家的IP位置
	 */
	public account_data(Integer member_id,Integer currency_id,
						String  account_name,String nick_name,String pass_word,
						Integer error_count,Integer point,
						Integer game_id,Boolean use_info,
						Integer language_id,Integer equipment_id,
						String  ip_address)	 {
		

		//@brief 帳戶流水號  參照 gamesystem.memberID
			this.memberID = member_id;
				
		//@brief 玩家幣別      參照 gamesystem.currencyID
			this.currencyID = currency_id;		
			
		//@brief 玩家帳號      參照 gamesystem.account
			this.account = account_name;
				
		//@brief 玩家暱稱（UTF-8）帳號      參照 	gamesystem.nickname
			this.nickname = nick_name;		
			
		//@brief 玩家密碼      參照 gamesystem.pass
			this.pass = pass_word;				
				
		//@brief 密碼錯誤次數（預設連續錯誤6次不得登入）
			this.errorcount = error_count;
				
		//@brief 玩家現有點數（已乘100的正整數）
			this.points = point;
				
		//@brief 玩家在線狀態（不在線為0）
			this.gameID = game_id;
				
		//@brief 玩家在線狀態（不在線為0）
			this.useinfo = use_info;
				
		//@brief 玩家在線玩家所使用的語言
			this.languageID = language_id;
				
		//@brief 玩家在線玩家所使用的語言
			this.equipmentID = equipment_id;
				
		//@brief 玩家的IP位置
			this.ip	= ip_address;		
	}	
	
	//@brief Table 主鍵設定	
	//@brief 帳號流水編號
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "memberID", unique=true, nullable=false)
	    public Integer getMemberID() {
	        return this.memberID;
	    }
		
		public void setMemberID(Integer id) {
			this.memberID = id;
	    }	
	
	//@brief 玩家幣別      參照 gamesystem.currencyID
		@Column(name = "currencyID" , nullable=false)
	    public Integer getCurrencyID() {
	        return this.currencyID;
	    }
	 
	    public void setCurrencyID(Integer id) {
	        this.currencyID = id;
	    }
    
	//@brief 玩家帳號      參照 gamesystem.account
	  	@Column(name = "account" , length = 30)
	    public String getAccount() {
	         return this.account;
	    }
   
	    public void setAccount(String account) {
	        this.account = account;
	    }
    
	//@brief 玩家暱稱（UTF-8）帳號      參照 	gamesystem.nickname
		@Column(name = "nickname" , length = 30)
	    public String getNickName() {
	         return this.nickname;
	    }
	   
	    public void setNickName(String name) {
	        this.nickname = name;
	    }
    
	//@brief 玩家密碼      參照 gamesystem.pass
		@Column(name = "pass", length = 50)
	    public String getPassWord() {
	         return this.pass;
	    }
   
	    public void setPassWord(String pass_word) {
	        this.pass = pass_word;
	    }
    
	    //@brief 密碼錯誤次數（預設連續錯誤6次不得登入）
 		@Column(name = "errorcount")
	    public Integer getErrorCount() {
	         return this.errorcount;
	    }
	   
	    public void setErrorCount(Integer err_count) {
	    	this.errorcount = err_count;
	    }
    
	//@brief 玩家現有點數（已乘100的正整數）
	  	@Column(name = "points")
	    public Integer getPoints() {
	         return this.points;
	    }
	   
	    public void setPoints(Integer point) {
	    	this.points = point;
	    }    
    
	//@brief 玩家在線狀態（不在線為0）
	  	@Column(name = "gameID")
	    public Integer getGameID() {
	         return this.gameID;
	    }
   
	    public void setGameID(Integer id) {
	    	this.gameID = id;
	    }
    
	 //@brief 帳號是否可用（0：不可用、1：可用）
		@Column(name = "useinfo")
	    public Boolean getUseInfo() {
	         return this.useinfo;
	    }
   
	    public void setUseInfo(Boolean use) {
	    	this.useinfo = use;
	    }
    
	//@brief 玩家在線玩家所使用的語言
	    @Column(name = "languageID")
	    public Integer getLanguageID() {
	         return this.languageID;
	    }
	   
	    public void setLanguageID(Integer id) {
	    	this.languageID = id;
	    }
    
    
	//@brief 玩家所使用的裝置
		@Column(name = "equipmentID")
	    public Integer getEquipmentID() {
	         return this.equipmentID;
	    }
	   
	    public void setEquipmentID(Integer id) {
	    	this.equipmentID = id;
	    }
    
    
	 //@brief 玩家的IP位置
	  	@Column(name = "ip", length = 20,nullable=false)
	    public String getIP() {
	         return this.ip;
	    }
	   
	    public void setIP(String ip_add) {
	        this.ip = ip_add;
	    }
    
	/*
	 *	Account Data Clone Function 
	 */
    public account_data Clone() {
    	return new account_data(this.memberID,this.currencyID,
    							this.account,this.nickname,this.pass,
    							this.errorcount,this.points,
    							this.gameID,this.useinfo,
    							this.languageID,this.equipmentID,
    							this.ip);
    }
}
