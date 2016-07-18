package com.egen.problem.ws.model;

public class ExceptionData {

	private boolean exception;
	private String message;
	
	public boolean isException() {
		return exception;
	}
	public void setException(boolean exception) {
		this.exception = exception;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
