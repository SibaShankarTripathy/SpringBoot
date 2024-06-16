package com.sst.entity;


import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="COMPUTERS_PRODUCT_DETAILS")
@Data
@DynamicInsert(true)//Used to avoid null value exception
@DynamicUpdate(true)//Used to avoid null value exception
public class ProductDetailsEntity implements Serializable {

	@Id
	@Column(name="PRD_ID")
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pId;

	@NonNull
	@Column(name="PRD_NAME", length=15)
	private String pName;
	
	@NonNull
	@Column(name="PRD_DESC", length=25)
	private String pDesc;
	
	@NonNull
	@Column(name="PRD_PRICE")
	private Float pPrice;
	
	@NonNull
	@Column(name="PRD_EXP_DATE")
	private Date pExpDate;
	
}
