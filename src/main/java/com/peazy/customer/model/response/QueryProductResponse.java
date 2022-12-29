package com.peazy.customer.model.response;

import java.util.List;

import com.peazy.customer.model.bean.QueryProductBean;

import lombok.Data;

@Data
public class QueryProductResponse {
    List<QueryProductBean> queryProductList;
}
