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
@Table(name = "Customer_ShoppingCart", schema = "alanlee")
@Data
public class CustomerShoppingCartEntity {

	@Id	
	@Column(name = "SeqNo", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long seqNo;
	private long productSeqNo;
	private long colorSeqNo;
	private long sizeSeqNo;
	private BigDecimal qty;
	private String userUUID;
	private String createUser;
	private Date createDt;
	private String updateUser;
	private Date updateDt;
	
}
