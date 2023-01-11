package com.peazy.customer.model.dto;

import java.math.BigDecimal;
import java.util.Date;

public interface GetProductBySeqNoDto  {
	String getProductSeqNo();
	String getProductName();
	String getSnCode();
	BigDecimal getCost();
	BigDecimal getPrice();
	String getCategorySeqNo();
	String getMpn();
	String getSku();
	String getProductDesc();
	Date getCreateDt();
	String getProductStatus();
	String getVendorSeqNo();
	String getColorSeqNo();
	String getColor();
	String getSizeSeqNO();
	String getSize();
}
