package com.jonas.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jonas.api.dto.YearWinnerMovieDTO;
import com.jonas.api.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	List<Movie> findByYear(Integer pYear);
	
	@Query(value="select new com.jonas.api.dto.YearWinnerMovieDTO(movie.year, count(movie.winner)) "
			+ "from Movie as movie where movie.winner=true group by movie.year having count(movie.winner) > 1")
	List<YearWinnerMovieDTO> findYearsWithModeThanOneWinner();
	
}
