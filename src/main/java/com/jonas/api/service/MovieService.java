package com.jonas.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonas.api.dto.MovieDTO;
import com.jonas.api.dto.YearWinnerDTO;
import com.jonas.api.dto.YearWinnerMovieDTO;
import com.jonas.api.entity.Movie;
import com.jonas.api.exceptions.BadRequestException;
import com.jonas.api.exceptions.ResourceNotFoundException;
import com.jonas.api.repository.MovieRepository;

@Service
public class MovieService {

    Logger logger = LoggerFactory.getLogger(MovieService.class);

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getMoviesFromAYear(Integer pYear) {
        return movieRepository.findByYear(pYear);
    }

    public List<MovieDTO> getMoviesByYear(Integer pYear) {
        List<Movie> moviesList = movieRepository.findByYear(pYear);

        if (moviesList == null || moviesList.isEmpty()) {
            return new ArrayList<>();
        }

        List<MovieDTO> moviesDtoList = new ArrayList<>();
        for (Movie movie : moviesList) {
            moviesDtoList.add(new MovieDTO(movie));
        }

        return moviesDtoList;
    }

    public YearWinnerDTO getYearsWithMoreThanOneWinners() {
        List<YearWinnerMovieDTO> years = movieRepository.findYearsWithModeThanOneWinner();
        if (years == null || years.isEmpty()) {
            return new YearWinnerDTO();
        }
        return new YearWinnerDTO(years);
    }

    public void remove(Long pId) {
        Optional<Movie> optional = movieRepository.findById(pId);

        if (!optional.isPresent()) {
            throw new ResourceNotFoundException();
        }

        Movie movie = optional.get();
        if (movie.getWinner()) {
            throw new BadRequestException();
        }

        movieRepository.delete(movie);
    }

}
