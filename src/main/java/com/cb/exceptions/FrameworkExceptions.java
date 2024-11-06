package com.cb.exceptions;

import org.openqa.selenium.ElementNotInteractableException;

public class FrameworkExceptions extends RuntimeException {

	public FrameworkExceptions(String message) {
		super(message);
	}

	public FrameworkExceptions(String message, Throwable e) {
		super(message, e);
	}

}
