package com.jonas.api.entity;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="MOVIE_PRODUCER")
public class MovieProducer {
	
	@EmbeddedId
	private MovieProducerId id;
	
	@ManyToOne
	@MapsId("idMovie")
	private Movie movie;
	
	@ManyToOne
	@MapsId("idProducer")
	private Producer producer;
	
	public MovieProducer() {}
	
	public MovieProducer(Movie pMovie, Producer pProducer) {
		this.movie = pMovie;
		this.producer = pProducer;
		this.id = new MovieProducerId(pMovie.getId(), pProducer.getId());
	}

	public MovieProducerId getId() {
		return id;
	}

	public void setId(MovieProducerId pId) {
		this.id = pId;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie pMovie) {
		this.movie = pMovie;
	}

	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer pProducer) {
		this.producer = pProducer;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		
		MovieProducer other = (MovieProducer) obj;
		return Objects.equals(movie, other.getMovie()) &&
				Objects.equals(producer, other.getProducer());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(movie, producer);
	}

}
