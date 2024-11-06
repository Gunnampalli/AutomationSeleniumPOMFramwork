package com.cb.exceptions;

public class PropertyFileValueException extends FrameworkExceptions {

	public PropertyFileValueException(String message) {
		super(message);
		
	}
	
	public PropertyFileValueException(String message,Throwable e) {
		super(message,e);
	}

}
