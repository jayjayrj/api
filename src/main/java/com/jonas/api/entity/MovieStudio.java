package com.jonas.api.entity;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="MOVIE_STUDIO")
public class MovieStudio {

	@EmbeddedId
	private MovieStudioId id;
	
	@ManyToOne
	@MapsId("idMovie")
	private Movie movie;
	
	@ManyToOne
	@MapsId("idStudio")
	private Studio studio;
	
	public MovieStudio() {}
	
	public MovieStudio(Movie pMovie, Studio pStudio) {
		this.movie = pMovie;
		this.studio = pStudio;
		this.id = new MovieStudioId(pMovie.getId(), pStudio.getId());
	}

	public MovieStudioId getId() {
		return id;
	}

	public void setId(MovieStudioId pId) {
		this.id = pId;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie pMovie) {
		this.movie = pMovie;
	}

	public Studio getStudio() {
		return studio;
	}

	public void setStudio(Studio pStudio) {
		this.studio = pStudio;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		
		MovieStudio other = (MovieStudio) obj;
		return Objects.equals(movie, other.getMovie()) &&
				Objects.equals(studio, other.getStudio());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(movie, studio);
	}
	
}
