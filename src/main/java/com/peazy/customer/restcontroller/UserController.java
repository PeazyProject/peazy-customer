package com.peazy.customer.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.peazy.customer.model.entity.SupplierUserEntity;
import com.peazy.customer.service.interfaces.SupplierUserService;

@CrossOrigin
@RestController
@RequestMapping(path = "/user",produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SupplierUserService supplierUserService;

	@PostMapping(value = "/getSupplierUsers")
	public ResponseEntity<List<SupplierUserEntity>> getSupplierUsers() throws JsonProcessingException {
		List<SupplierUserEntity> result = supplierUserService.getUsers();
		logger.info("getSupplierUsers = {}", result);
		return ResponseEntity.ok(result);
	}

}
