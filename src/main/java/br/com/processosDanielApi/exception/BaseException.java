package br.com.processosDanielApi.exception;

import java.io.Serializable;

public class BaseException extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7367322165575410819L;
	
	private Exception exception;
	
	
	
	public BaseException() {
		super();
	}
	
	public BaseException(String texto) {
		super(texto);
	}
	
	public BaseException(Exception e) {
		super(e);
		this.exception=e;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}
	

	
	
	
}
