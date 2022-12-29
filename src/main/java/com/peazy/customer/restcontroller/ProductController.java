package com.peazy.customer.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.peazy.customer.model.request.QueryProductRequest;
import com.peazy.customer.model.response.QueryProductResponse;
import com.peazy.customer.service.interfaces.ProductService;

@CrossOrigin
@RestController
@RequestMapping(path = "/product",produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProductService productService;

	@PostMapping(value = "/queryCustomerProduct")
	public ResponseEntity<QueryProductResponse> queryCustomerProduct(@RequestBody QueryProductRequest queryProductRequest)
			throws JsonProcessingException {
		logger.info("queryCustomerProductRequest = {}", queryProductRequest);
		QueryProductResponse queryProductResponse = productService.queryCustomerProduct(queryProductRequest);
		logger.info("queryCustomerProductResponse = {}", queryProductResponse);
		return ResponseEntity.ok(queryProductResponse);
	}

}
