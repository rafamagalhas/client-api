package com.rafamagalhas.clientApi.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rafamagalhas.clientApi.exceptions.type.DataIntegrationException;

@ControllerAdvice
public class ResourceExceptionHandler {
	@ExceptionHandler(DataIntegrationException.class)
	public ResponseEntity<StandartError> dataError(DataIntegrationException e, HttpServletRequest request) {
		StandartError error = new StandartError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
