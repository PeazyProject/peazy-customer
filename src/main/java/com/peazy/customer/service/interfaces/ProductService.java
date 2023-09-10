package com.peazy.customer.service.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.peazy.customer.model.request.AddShoppingCartRequest;
import com.peazy.customer.model.request.QueryProductRequest;
import com.peazy.customer.model.response.QueryProductResponse;

public interface ProductService {
	public QueryProductResponse queryCustomerProduct(QueryProductRequest queryProductRequest) throws JsonProcessingException;

	public void addShoppingCart(AddShoppingCartRequest qddShoppingCartRequest) throws JsonProcessingException;
}
