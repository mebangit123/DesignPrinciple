package com.day29.census;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class CensusAnalyzerTest {
	private static final String INDIA_CENSUS_CSV_FILE_PATH = "./indiaCensus.csv";

	@Test
	public void givenIndianCensusCSVFileReturnsCorrectRecords() throws IOException {
		CensusAnalyzer censusAnalyZer = new CensusAnalyzer();
		int numOfRecords = censusAnalyZer.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
		Assert.assertEquals(1, numOfRecords);
	}
}
