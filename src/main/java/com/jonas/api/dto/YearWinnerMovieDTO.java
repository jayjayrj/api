package com.jonas.api.dto;

public class YearWinnerMovieDTO {
	
	private Integer year;
	
	private Long winnerCount;
	
	public YearWinnerMovieDTO(Integer pYear, Long pWinnerCount) {
		this.year = pYear;
		this.winnerCount = pWinnerCount;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer pYear) {
		this.year = pYear;
	}

	public Long getWinnerCount() {
		return winnerCount;
	}

	public void setWinnerCount(Long pWinnerCount) {
		this.winnerCount = pWinnerCount;
	}
	
}
