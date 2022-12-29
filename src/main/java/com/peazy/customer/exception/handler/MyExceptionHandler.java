 package com.peazy.customer.exception.handler;

 import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.peazy.customer.exception.ErrorCodeException;
import com.peazy.customer.model.entity.ErrorCodeEntity;
import com.peazy.customer.model.resp.ErrorResponse;
import com.peazy.customer.repository.ErrorCodeRepository;

 @ControllerAdvice
 public class MyExceptionHandler {

 	@Autowired
 	private ErrorCodeRepository errorCodeRepository;

 	@ResponseBody
 	@ExceptionHandler(ErrorCodeException.class)
 	@ResponseStatus(HttpStatus.BAD_REQUEST)
 	ErrorResponse dispalyErrorMessage(ErrorCodeException ex) {
 		ErrorResponse resp = new ErrorResponse();
 		Optional<ErrorCodeEntity> entity = errorCodeRepository.findByCategoryAndErrorCode(ex.getErrorCode().getCategory(),
 				ex.getErrorCode().getCode());
 		resp.setCategory(ex.getErrorCode().getCategory());
 		resp.setErrorCode(ex.getErrorCode().getCode());
 		if(entity.isPresent()) {
 			resp.setErrorMsg(entity.get().getErrorMsg());
 		}else {
 			resp.setErrorMsg("");
 		}
 		return resp;
 	}
 	
 	@ResponseStatus(HttpStatus.BAD_REQUEST)
 	@ExceptionHandler(MethodArgumentNotValidException.class)
 	public Map<String, String> handleValidationExceptions(
 	  MethodArgumentNotValidException ex) {
 	    Map<String, String> errors = new HashMap<>();
 	    ex.getBindingResult().getAllErrors().forEach((error) -> {
 	        String fieldName = ((FieldError) error).getField();
 	        String errorMessage = error.getDefaultMessage();
 	        errors.put(fieldName, errorMessage);
 	    });
 	    return errors;
 	}
 }
