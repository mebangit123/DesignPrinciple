package com.day29.census;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CensusAnalyzer {
	public int loadIndiaCensusData(String csvFilePath) throws CensusAnalyZerException {
		try(Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));)  {
			CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(IndiaCensusCSV.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<IndiaCensusCSV> csvToBean = csvToBeanBuilder.build();
			Iterator<IndiaCensusCSV> censusCSVIterator = csvToBean.iterator();
			Iterable<IndiaCensusCSV> csvIterable = () -> censusCSVIterator;
			int numOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
			return numOfEntries;
		} catch(IOException e) {
			throw new CensusAnalyZerException(e.getMessage(),
						CensusAnalyZerException.ExceptionType.CSV_FILE_PROBLEM);
		} catch(IllegalStateException e) {
			throw new CensusAnalyZerException(e.getMessage(),
					CensusAnalyZerException.ExceptionType.UNABLE_TO_PARSE);
		}
	}
	
	public int loadIndianStateCode(String csvFilePath) throws IOException, CensusAnalyZerException {
		try(Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));)  {
			CsvToBeanBuilder<IndiaStateCodeCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(IndiaStateCodeCSV.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<IndiaStateCodeCSV> csvToBean = csvToBeanBuilder.build();
			Iterator<IndiaStateCodeCSV> stateCodeIterator = csvToBean.iterator();
			Iterable<IndiaStateCodeCSV> csvIterable = () -> stateCodeIterator;
			int numOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
			return numOfEntries;
		}catch(IOException e) {
			throw new CensusAnalyZerException(e.getMessage(),
					CensusAnalyZerException.ExceptionType.CSV_FILE_PROBLEM);
		} catch(IllegalStateException e) {
			throw new CensusAnalyZerException(e.getMessage(),
					CensusAnalyZerException.ExceptionType.UNABLE_TO_PARSE);
		}
	}
}
