package com.day29.census;

import com.opencsv.bean.CsvBindByName;

public class IndiaCensusCSV {
	@CsvBindByName(column = "State", required = true)
	public String state;
	@CsvBindByName(column = "Population", required = true)
	public double population;
	@CsvBindByName(column = "AreaInSqKm", required = true)
	public double areaInsqKm;
	@CsvBindByName(column = "DensityPerSqKm", required = true)
	public double densityPerSqKm;
	
	public IndiaCensusCSV() {
		// TODO Auto-generated constructor stub
	}

	public IndiaCensusCSV(String state, int population, double areaInsqKm, double densityPerSqKm) {
		super();
		this.state = state;
		this.population = population;
		this.areaInsqKm = areaInsqKm;
		this.densityPerSqKm = densityPerSqKm;
	}

	@Override
	public String toString() {
		return "IndiaCensusCSV [state=" + state + ", population=" + population + ", areaInsqKm=" + areaInsqKm
				+ ", densityPerSqKm=" + densityPerSqKm + "]";
	}
	
	
}
