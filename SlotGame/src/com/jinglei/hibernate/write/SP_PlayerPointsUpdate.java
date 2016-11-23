package com.jinglei.hibernate.write;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/*
 * systemgame.account_db  Server 更改玩家點數
 * 
 * Description :
 * 			call msp_points_change(1,2)
 * 			Query query = session.createQuery("call msp_server_login(':account_id',':point')").addEntity(account_db.class);
 * 			query.setParameter("account_id", account);
 * 			query.setParameter("point", update);
 * 			query.setCacheable(true);
 * 			SP_PlayerPointsUpdate results = query.list();
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
@Table(name = "SP_PlayerPointsUpdate")
@Cacheable(true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="com.jinglei.hibernate.write.SP_PlayerPointsUpdate")
public class SP_PlayerPointsUpdate implements Serializable {	
	 private static final long serialVersionUID = 1L;
	 
	//@brief Stored Procedure(SP) 回傳結果  1：成功、0：失敗
	  @Column(name = "result" , nullable=false)
		private volatile Integer	result = 0;
	  
	//@brief Stored Procedure(SP) 回傳結果 玩家唯一碼
	  @Column(name = "memberID" , nullable=false)
		private volatile Integer	memberID = 0;	 
	  
	//@brief Stored Procedure(SP) 回傳結果 玩家現有點數
	  @Column(name = "points" , nullable=false)
		private volatile Integer	points = 0;		  
	  
	/*
	 * SP_PlayerPointsUpdate Construction
	 */
	public SP_PlayerPointsUpdate() {
		//@brief 初始 UionPrimaryKeyIdentity
		this.result   = 0;
		this.memberID = 0;
		this.points   = 0;
	}
	
	/*
	 * SP_PlayerPointsUpdate Construction
	 */
	public SP_PlayerPointsUpdate(Integer res,Integer member_id,Integer point) {
		this.result 	= res;
		this.memberID 	= member_id;
		this.points   	= point;
	}
	
	@Column(name = "result" , nullable=false)
	public Integer getResult() {
       return this.result;
	}
		
	public void setResult(Integer res) {
		this.result = res;
	}	
	
	
	//@brief Stored Procedure(SP) 回傳結果 玩家唯一碼
	 @Column(name = "memberID" , nullable=false)
	 public Integer getMemberID() {
	     return this.memberID;
	 }
			
	 public void setMemberID(Integer id) {
	 	this.memberID = id;
	 }

	  
	//@brief Stored Procedure(SP) 回傳結果 玩家現有點數
	  @Column(name = "points" , nullable=false)
	  
	  public Integer getPoints() {
	     return this.points;
	  }
				
	  public void setpoints(Integer point) {
	  	this.points = point;
	  }	  
}
