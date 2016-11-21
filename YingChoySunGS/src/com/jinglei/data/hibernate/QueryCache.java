package com.jinglei.data.hibernate;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;

@Entity(name="queryCache")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class QueryCache {
		
	@Id
	private int seq_region_id;
		
	private String sequence;

	public int getSeq_region_id() {
		return seq_region_id;
	}

	public void setSeq_region_id(int seq_region_id) {
		this.seq_region_id = seq_region_id;
	}

	@Column
	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}		

}
