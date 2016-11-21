package com.jinglei.data.hibernate.write;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/*
 * systemgame.account_db  對應結構
 * 
 * Description :
 * 			call msp_server_login('這邊塞帳號');
 * 			Query query = session.createQuery("call msp_server_login(':account_id')").addEntity(account_db.class);
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
@Table(name = "SP_Result")
@Cacheable(true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="com.jinglei.data.hibernate.write.SP_Result")
public class SP_Result  implements Serializable {	
	 private static final long serialVersionUID = 1L;
	 
	//@brief Stored Procedure(SP) 回傳結果
	  @Column(name = "result" , nullable=false)
		private volatile Integer	result = 0;
	  
	/*
	 * SP_online_type_change Construction
	 */
	public SP_Result() {
		//@brief 初始 UionPrimaryKeyIdentity
		this.result = 0;
	}
	
	/*
	 * SP_online_type_change Construction
	 */
	public SP_Result(Integer res) {
		this.result = res;
	}
	
	@Column(name = "result" , nullable=false)
	public Integer getResult() {
        return this.result;
    }
	
	public void setResult(Integer res) {
		this.result = res;
    }		

}
