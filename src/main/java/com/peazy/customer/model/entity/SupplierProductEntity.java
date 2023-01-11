package com.peazy.customer.model.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Supplier_Product", schema = "alanlee")
@Data
public class SupplierProductEntity {

	@Id	
	@Column(name = "SeqNo", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long seqNo;
	private String mainPicSnCode;
	private String productName;
	private BigDecimal cost;
	private BigDecimal price;
	private String productStatus;
	private String productCategorySeqNo;
	private String productDesc;
	private String mainSkuSeqNo;
	private String mainMpnSeqNo;
	private String vendorSeqNo;
	private String createUser;
	private Date createDt;
	private String updateUser;
	private Date updateDt;
	
}
