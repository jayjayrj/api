package com.jonas.api.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCER")
public class Producer {
	
	@Id
	@Column(name="ID_PRODUCER")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NAME", length=50, nullable=false)
	private String name;
	
	@OneToMany(mappedBy="producer", cascade=CascadeType.ALL, orphanRemoval = true)
	private List<MovieProducer> movies = new ArrayList<>();
	
	public Producer() {}
	
	public Producer(String pName) {
		this.name = pName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long pId) {
		this.id = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String pName) {
		this.name = pName;
	}

	public List<MovieProducer> getMovies() {
		return movies;
	}

	public void setMovies(List<MovieProducer> pMovies) {
		this.movies = pMovies;
	}

	@Override
	public String toString() {
		return "Producer: "+ getName();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		
		Producer other = (Producer) obj;
		return Objects.equals(id, other.getId());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
	
}
