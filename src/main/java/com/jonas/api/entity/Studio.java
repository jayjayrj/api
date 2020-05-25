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
@Table(name="STUDIO")
public class Studio {
	
	@Id
	@Column(name="ID_STUDIO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NAME", length=50, unique=true)
	private String name;
	
	@OneToMany(mappedBy="studio", cascade=CascadeType.ALL, orphanRemoval = true)
	private List<MovieStudio> movies = new ArrayList<>();
	
	public Studio() {}
	
	public Studio(String pName) {
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

	public List<MovieStudio> getMovies() {
		return movies;
	}

	public void setMovies(List<MovieStudio> pMovies) {
		this.movies = pMovies;
	}
	
	@Override
	public String toString() {
		return "Studio: "+ getName();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		
		Studio other = (Studio) obj;
		return Objects.equals(id, other.getId());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
	
}
