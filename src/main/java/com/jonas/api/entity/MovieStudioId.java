package com.jonas.api.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class MovieStudioId implements Serializable {
	
    private static final long serialVersionUID = 4527186191650164371L;

    private Long idMovie;
	
	private Long idStudio;
	
	public MovieStudioId() {}
	
	public MovieStudioId(Long pIdMovie, Long pIdStudio) {
		this.idMovie = pIdMovie;
		this.idStudio = pIdStudio;
	}

	public Long getIdMovie() {
		return idMovie;
	}

	public Long getIdStudio() {
		return idStudio;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		
		MovieStudioId other = (MovieStudioId) obj;
		return Objects.equals(idMovie, other.getIdMovie()) &&
				Objects.equals(idStudio, other.getIdStudio());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idMovie, idStudio);
	}

}
