package com.day29.census;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyzerTest {
	private static final String INDIA_CENSUS_CSV_FILE_PATH = "./indiaCensus.csv";
	private static final String WRONG_CSV_FILE_PATH = "./Census.csv";
	private static final String INDIAN_STATE_CODE_CSV_FILE_PATH = "./Census.csv";

	@Test
	public void givenIndianCensusCSVFileReturnsCorrectRecords() throws IOException {
		try {
			CensusAnalyzer censusAnalyZer = new CensusAnalyzer();
			int numOfRecords = numOfRecords = censusAnalyZer.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
			Assert.assertEquals(1, numOfRecords);
			} catch (CensusAnalyZerException e) {}
	}
	@Test
	public void givenIndianStateCodeCSVFileReturnsCorrectRecords() throws IOException {
		try {
			CensusAnalyzer censusAnalyZer = new CensusAnalyzer();
			int numOfRecords = numOfRecords = censusAnalyZer.loadIndianStateCode(INDIAN_STATE_CODE_CSV_FILE_PATH);
			Assert.assertEquals(1, numOfRecords);
			} catch (CensusAnalyZerException e) {}
	}
	@Test
	public void givenIndiaCensusData_WithWrongFile_ShoulThrewException() {
		try {
			CensusAnalyzer censusAnalyZer = new CensusAnalyzer();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyZerException.class);
			censusAnalyZer.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
		} catch(CensusAnalyZerException e) {
			Assert.assertEquals(CensusAnalyZerException.ExceptionType.CSV_FILE_PROBLEM, e.type);
		}
	}
	@Test
	public void givenIndiaCensusData_WithIncorrectCSVHeader_ShoulThrewException() {
		try {
			CensusAnalyzer censusAnalyZer = new CensusAnalyzer();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyZerException.class);
			censusAnalyZer.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
		} catch(CensusAnalyZerException e) {
			Assert.assertEquals(CensusAnalyZerException.ExceptionType.UNABLE_TO_PARSE, e.type);
		}
	}
}
