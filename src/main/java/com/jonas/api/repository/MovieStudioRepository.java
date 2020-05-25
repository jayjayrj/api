package com.jonas.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jonas.api.entity.MovieStudio;
import com.jonas.api.entity.MovieStudioId;

public interface MovieStudioRepository extends JpaRepository<MovieStudio, MovieStudioId>{

}
