package com.jonas.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.jonas.api.dto.StudioDTO;
import com.jonas.api.entity.Movie;
import com.jonas.api.entity.MovieStudio;
import com.jonas.api.entity.Studio;
import com.jonas.api.repository.MovieStudioRepository;
import com.jonas.api.repository.StudioRepository;

@Service
public class StudioService {

    Logger logger = LoggerFactory.getLogger(StudioService.class);

    @Autowired
    private StudioRepository studioRepository;

    @Autowired
    private MovieStudioRepository movieStudioRepository;

    public void saveStudios(Movie pMovie, String pStudios) {
        for (String stringStudio : pStudios.split(",|\\ and ")) {
            Studio studio = new Studio(stringStudio.trim());

            Example<Studio> example = Example.of(studio);

            if (studioRepository.exists(example)) {
                studio = studioRepository.findByName(stringStudio.trim());
            }
            else {
                studio = studioRepository.save(studio);
            }

            movieStudioRepository.save(new MovieStudio(pMovie, studio));
        }
    }

    public StudioDTO getGreatestWinners() {
        return new StudioDTO(studioRepository.findByWinners());
    }

}
