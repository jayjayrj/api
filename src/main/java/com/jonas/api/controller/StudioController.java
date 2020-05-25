package com.jonas.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonas.api.dto.StudioDTO;
import com.jonas.api.service.StudioService;

@RestController
@RequestMapping("/studio")
public class StudioController {

    Logger logger = LoggerFactory.getLogger(StudioController.class);

    @Autowired
    private StudioService studioService;

    @GetMapping("/winners")
    public ResponseEntity<StudioDTO> getGreatestWinners() {
        StudioDTO studioDto = studioService.getGreatestWinners();

        HttpStatus httpStatus = HttpStatus.OK;
        if (studioDto.getStudios() == null || studioDto.getStudios().isEmpty()) {
            httpStatus = HttpStatus.NO_CONTENT;
        }

        return new ResponseEntity<StudioDTO>(studioDto, httpStatus);
    }

}
