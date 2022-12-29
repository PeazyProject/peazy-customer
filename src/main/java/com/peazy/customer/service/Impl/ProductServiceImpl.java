package com.peazy.customer.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.peazy.customer.model.request.QueryProductRequest;
import com.peazy.customer.model.response.QueryProductResponse;
import com.peazy.customer.service.interfaces.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Override
	public QueryProductResponse queryCustomerProduct(QueryProductRequest queryProductRequest) throws JsonProcessingException {
		// TODO 下次來做這邊
		QueryProductResponse queryProductResponse = new QueryProductResponse();
		return null;
	}

}
