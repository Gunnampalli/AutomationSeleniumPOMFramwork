package com.cb.exceptions;

public class InvalidFilePathForExcelException extends FrameworkExceptions {

	public InvalidFilePathForExcelException(String message) {
		super(message);
	}

	public InvalidFilePathForExcelException(String message,Throwable e) {
		super(message,e);
	}

}
