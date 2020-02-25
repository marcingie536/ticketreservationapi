package com.zaju.ticketreservationapi.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.zaju.ticketreservationapi.dto.ErrorResponseEntity;
import com.zaju.ticketreservationapi.exception.EntityNotFoundException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex, WebRequest request) {
		
		ErrorResponseEntity errorResponseEntity = new ErrorResponseEntity();
		errorResponseEntity.setTimestamp(new Date());
		errorResponseEntity.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponseEntity.setError(HttpStatus.NOT_FOUND.name());
		errorResponseEntity.setMessage(ex.getMessage());
		
		return new ResponseEntity<>(errorResponseEntity, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleEntityNotFound(Exception ex, WebRequest request) {
		
		ErrorResponseEntity errorResponseEntity = new ErrorResponseEntity();
		errorResponseEntity.setTimestamp(new Date());
		errorResponseEntity.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorResponseEntity.setError(HttpStatus.INTERNAL_SERVER_ERROR.name());
		errorResponseEntity.setMessage(ex.getMessage());
		
		return new ResponseEntity<>(errorResponseEntity, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
