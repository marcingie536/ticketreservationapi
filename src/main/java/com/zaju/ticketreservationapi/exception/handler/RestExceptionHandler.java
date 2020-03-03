package com.zaju.ticketreservationapi.exception.handler;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.zaju.ticketreservationapi.dto.ErrorResponseEntity;
import com.zaju.ticketreservationapi.exception.EntityNotFoundException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<String> errors = ex.getBindingResult().getFieldErrors().stream()
				.map(error -> getFieldErrorAsString(error)).collect(Collectors.toList());
		
		ErrorResponseEntity errorResponseEntity = buildResponseEntity(HttpStatus.BAD_REQUEST, errors);
		
		return new ResponseEntity<>(errorResponseEntity, HttpStatus.BAD_REQUEST);
	}

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
	
	private String getFieldErrorAsString(FieldError errorField) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		sb.append(errorField.getField());
		sb.append("]");
		sb.append(" ");
		sb.append(errorField.getDefaultMessage());

		return sb.toString();
	}
	
	private ErrorResponseEntity buildResponseEntity(HttpStatus status, String error) {
		return buildResponseEntity(status, Arrays.asList(error));
	}

	private ErrorResponseEntity buildResponseEntity(HttpStatus status, List<String> errors) {
		ErrorResponseEntity errorResponseEntity = new ErrorResponseEntity();
		
		errorResponseEntity.setTimestamp(new Date());
		errorResponseEntity.setStatus(status.value());
		errorResponseEntity.setDetails(status.name());
		errorResponseEntity.setErrors(errors);
		
		return errorResponseEntity;
	}
}
