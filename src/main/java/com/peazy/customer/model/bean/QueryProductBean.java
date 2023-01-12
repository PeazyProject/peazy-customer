package com.peazy.customer.model.bean;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class QueryProductBean {
    private String productSeqNo;
    private String productName;
    private String snCode;
    private int price;
    private String category;
    private String sku;
    private Date createDt;
    private String productStatus;
    private List<DropDownBean> colorList;
    private List<DropDownBean> sizeList;
}
