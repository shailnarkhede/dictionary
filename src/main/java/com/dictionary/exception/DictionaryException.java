package com.dictionary.exception;

public class DictionaryException extends RuntimeException {

	private static final long serialVersionUID = -764740675786238006L;
	
	private String errorMessage;
	
	public DictionaryException(){
		super();
	}
	
	public DictionaryException(String desc){
		errorMessage = desc;
	}
	
	public DictionaryException(String desc, Exception e){
		super(e);
		errorMessage = desc;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
