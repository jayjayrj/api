package com.jonas.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonas.api.dto.MovieDTO;
import com.jonas.api.dto.YearWinnerDTO;
import com.jonas.api.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {
	
	Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping("/{year}")
    public ResponseEntity<List<MovieDTO>> getMovies(@PathVariable(name="year") Integer pYear) {
		List<MovieDTO> moviesList = movieService.getMoviesByYear(pYear);
		
		HttpStatus httpStatus = HttpStatus.OK;
		if ( moviesList.isEmpty() ) {
			httpStatus = HttpStatus.NO_CONTENT;
		}
		
        return new ResponseEntity<List<MovieDTO>>( moviesList, httpStatus ) ;
    }
	
	/**
	 * @return {@link YearWinnerDTO}
	 */
	@GetMapping("/years")
	public ResponseEntity<YearWinnerDTO> getYearsWithMoreThanOneWinners() {
		YearWinnerDTO yearWinnerDto = movieService.getYearsWithMoreThanOneWinners();
		
		HttpStatus httpStatus = HttpStatus.OK;
		if ( yearWinnerDto.getYears().isEmpty() ) {
			httpStatus = HttpStatus.NO_CONTENT;
		}
		
		return new ResponseEntity<YearWinnerDTO>( yearWinnerDto, httpStatus ) ;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> removeMovie(@PathVariable(name="id") Long pId) {
		movieService.remove(pId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
