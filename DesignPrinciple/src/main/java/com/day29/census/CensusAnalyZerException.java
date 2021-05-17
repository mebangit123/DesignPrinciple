package com.day29.census;

public class CensusAnalyZerException extends Exception{
	enum ExceptionType {
		CENSUS_FILE_PROBLEM, UNABLE_TO_PARSE, CSV_FILE_PROBLEM
	}
	ExceptionType type;
	
	public CensusAnalyZerException(String message, ExceptionType type) {
		super(message);
		this.type = type;
	}
	public CensusAnalyZerException(String message, ExceptionType type, Throwable cause) {
		super(message, cause);
		this.type = type;
	}
}