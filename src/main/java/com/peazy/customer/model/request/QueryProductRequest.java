package com.peazy.customer.model.request;

import java.util.List;

import lombok.Data;

@Data
public class QueryProductRequest {
    private String productName;
    private List<String> skuList;
    private String isAvailable;
}
