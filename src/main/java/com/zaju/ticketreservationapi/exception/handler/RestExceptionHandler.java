package com.zaju.ticketreservationapi.exception.handler;

import java.sql.SQLException;
import java.util.Date;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
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
		
		ErrorResponseEntity errorResponseEntity = buildResponseEntity(HttpStatus.NOT_FOUND, ex.getMessage());
		
		return new ResponseEntity<>(errorResponseEntity, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	protected ResponseEntity<Object> handleDataIntegrityViolation(DataIntegrityViolationException ex, WebRequest request) {
		
		RuntimeException cause = (RuntimeException) ex.getCause();
		
		if(cause instanceof ConstraintViolationException) {
			SQLException sqlException = ((ConstraintViolationException) cause).getSQLException();
			
			String message = ex.getMessage() + ". " + sqlException.getMessage();
			
			ErrorResponseEntity errorResponseEntity = buildResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, message);
			
			return new ResponseEntity<>(errorResponseEntity, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return handleUnexpectedException(ex, request);
	}
	
	
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleUnexpectedException(Exception ex, WebRequest request) {
		
		ErrorResponseEntity errorResponseEntity = buildResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		
		return new ResponseEntity<>(errorResponseEntity, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	private ErrorResponseEntity buildResponseEntity(HttpStatus status, String message) {
		ErrorResponseEntity errorResponseEntity = new ErrorResponseEntity();
		
		errorResponseEntity.setTimestamp(new Date());
		errorResponseEntity.setStatus(status.value());
		errorResponseEntity.setError(status.name());
		errorResponseEntity.setMessage(message);
		
		return errorResponseEntity;
	}
}
