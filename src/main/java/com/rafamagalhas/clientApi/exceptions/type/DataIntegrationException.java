package com.rafamagalhas.clientApi.exceptions.type;

public class DataIntegrationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DataIntegrationException(String exception) {
		super(exception);
	}
}
