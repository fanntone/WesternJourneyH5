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
 * systemgame.member_points  對應結構
 * 
 * Description :
 * 			call msp_server_login('這邊塞帳號');
 * 			Query query = session.createQuery("call msp_server_points(這邊塞玩家唯一碼)");
 * 			query.setParameter("member_id", member_id);
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
 * SQL data type 		Java data type
 *						Simply mappable 		Object mappable
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
 *	幣別代碼	幣別縮寫	幣別名稱
 *	-1		NON		沒有幣值
 *	116	 	KHR		高棉
 *  156	 	CNY		中華人民共和國
 * 	360	 	IDR		印尼
 *	458	 	MYR		馬來西亞
 *	702	 	SGD		新加坡
 *	704	 	VND		越南
 *	764	 	THB		泰國
 *	840	 	USD		美國
 *	999	 	DEM		展示
 */
@Entity
@Table(name = "member_points")
@Cacheable(true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="com.jinglei.hibernate.read.member_points")
public class member_points implements Serializable {
	
	 private static final long serialVersionUID = 1L;
	 
	 /*
	  *   gamesystem.memberID  對應結構
	  */	
	  //@brief 帳戶流水號  參照 gamesystem.memberID
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "memberID", unique=true, nullable=false)
		private volatile Integer   memberID = 0;
			
	 //@brief 玩家幣別      參照 gamesystem.points
	 	@Column(name = "points" , nullable=false)
		private volatile Integer	points = 0;	
			
		/*
		 * member_points Construction
		 */
		public member_points() {
			//@brief 初始 UionPrimaryKeyIdentity
		}
		
		/*
		 * member_points Construction
		 */
		public member_points(Integer member_id,Integer point) {
			this.memberID   = member_id;
			this.points     = point;
		}
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "memberID", unique=true, nullable=false)
		public Integer getMemberID() {
	        return this.memberID;
	    }
		
		public void setMemberID(Integer id) {
			this.memberID = id;
	    }
			
	 //@brief 玩家幣別      參照 gamesystem.points
	 	@Column(name = "points" , nullable=false)
	 	public Integer getPoints() {
	        return this.points;
	    }
		
		public void setPoints(Integer point) {
			this.points = point;
	    }

}
