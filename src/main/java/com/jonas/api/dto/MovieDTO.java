package com.jonas.api.dto;

import java.util.ArrayList;
import java.util.List;

import com.jonas.api.entity.Movie;
import com.jonas.api.entity.MovieProducer;
import com.jonas.api.entity.MovieStudio;

public class MovieDTO {
	
	private Long id;
	
	private Integer year;
	
	private String title;
	
	private List<String> studios = new ArrayList<>();
	
	private List<String> producers = new ArrayList<>();
	
	private Boolean winner;
	
	public MovieDTO(Movie pMovie) {
		this.id = pMovie.getId();
		this.year = pMovie.getYear();
		this.title = pMovie.getTitle();
		this.winner = pMovie.getWinner();
		
		for (MovieStudio movieStudio : pMovie.getStudios()) {
			this.studios.add(movieStudio.getStudio().getName());
		}
		
		for (MovieProducer movieProducer : pMovie.getProducers()) {
			this.producers.add(movieProducer.getProducer().getName());
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long pId) {
		this.id = pId;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer pYear) {
		this.year = pYear;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String pTitle) {
		this.title = pTitle;
	}

	public List<String> getStudios() {
		return studios;
	}

	public void setStudios(List<String> pStudios) {
		this.studios = pStudios;
	}

	public List<String> getProducers() {
		return producers;
	}

	public void setProducers(List<String> pProducers) {
		this.producers = pProducers;
	}

	public Boolean getWinner() {
		return winner;
	}

	public void setWinner(Boolean pWinner) {
		this.winner = pWinner;
	}
	
}
