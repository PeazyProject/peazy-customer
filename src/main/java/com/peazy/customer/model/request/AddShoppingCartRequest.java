package com.peazy.customer.model.request;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class AddShoppingCartRequest {
    private String productSeqNo;
    private String colorSeqNo;
    private String sizeSeqNo;
    private BigDecimal productQty;
    private String userUUID;
    private String userId;
}
