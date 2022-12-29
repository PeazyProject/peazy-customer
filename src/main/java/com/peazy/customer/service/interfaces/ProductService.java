package com.peazy.customer.service.interfaces;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.peazy.customer.model.request.QueryProductRequest;
import com.peazy.customer.model.response.QueryProductResponse;

public interface ProductService {
	public QueryProductResponse queryCustomerProduct(QueryProductRequest queryProductRequest) throws JsonProcessingException;
}
