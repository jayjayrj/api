package com.jonas.api.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class MovieProducerId implements Serializable {
	
    private static final long serialVersionUID = -3603957296086293138L;

    private Long idMovie;
	
	private Long idProducer;
	
	public MovieProducerId() {}
	
	public MovieProducerId(Long pIdMovie, Long pIdProducer) {
		this.idMovie = pIdMovie;
		this.idProducer = pIdProducer;
	}

	public Long getIdMovie() {
		return idMovie;
	}

	public Long getIdProducer() {
		return idProducer;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		
		MovieProducerId other = (MovieProducerId) obj;
		return Objects.equals(idMovie, other.getIdMovie()) &&
				Objects.equals(idProducer, other.getIdProducer());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idMovie, idProducer);
	}

}
