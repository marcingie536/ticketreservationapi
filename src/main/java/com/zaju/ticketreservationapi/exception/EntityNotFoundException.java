package com.zaju.ticketreservationapi.exception;

public class EntityNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = -2175884425993060236L;
			
	public EntityNotFoundException(String entityName, String param) {
		super(generateMessage(entityName, param));
	}

	private static String generateMessage(String entityName, String param) {
		return entityName + " was not found for id = " + param;
	}
}
