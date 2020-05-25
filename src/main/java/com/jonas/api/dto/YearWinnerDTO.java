package com.jonas.api.dto;

import java.util.ArrayList;
import java.util.List;

public class YearWinnerDTO {
	
	private List<YearWinnerMovieDTO> years;
	
	public YearWinnerDTO(List<YearWinnerMovieDTO> pYears) {
		this.years = new ArrayList<>();
		this.years.addAll(pYears);
	}
	
	public YearWinnerDTO() {
		this.years = new ArrayList<>();
	}

	public List<YearWinnerMovieDTO> getYears() {
		return years;
	}

	public void setYears(List<YearWinnerMovieDTO> pYears) {
		this.years = pYears;
	}

}
