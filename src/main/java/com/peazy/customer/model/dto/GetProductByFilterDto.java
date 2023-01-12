package com.peazy.customer.model.dto;

import java.util.Date;

public interface GetProductByFilterDto  {
	String getProductSeqNo();
	String getProductName();
	String getSnCode();
	int getPrice();
	String getCategory();
	String getSku();
	Date getCreateDt();
	String getProductStatus();
	String getVendorSeqNo();
}
