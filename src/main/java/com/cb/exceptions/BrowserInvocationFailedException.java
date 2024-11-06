package com.cb.exceptions;

public class BrowserInvocationFailedException extends FrameworkExceptions {

	public BrowserInvocationFailedException(String message) {
		super(message);

	}

	public BrowserInvocationFailedException(String message, Throwable e) {
		super(message, e);

	}

}
