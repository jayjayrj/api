package com.jonas.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jonas.api.dto.ProducerMinMaxPrizesDTO;
import com.jonas.api.service.ProducerService;

@RestController
@RequestMapping("producer")
public class ProducerController {
	
	Logger logger = LoggerFactory.getLogger(ProducerController.class);
	
	@Autowired
	private ProducerService producerService;
	
	@GetMapping("prizes-interval")
	public ResponseEntity<ProducerMinMaxPrizesDTO> getMaxAndMinPrizes() {
		ProducerMinMaxPrizesDTO producerMinMaxPrizesDto = producerService.getMaxAndMinPrizes();
		
		HttpStatus httpStatus = HttpStatus.OK;
		if ( producerMinMaxPrizesDto.getMax().isEmpty() && producerMinMaxPrizesDto.getMin().isEmpty() ) {
			httpStatus = HttpStatus.NO_CONTENT;
		}
		
		return new ResponseEntity<ProducerMinMaxPrizesDTO>(producerMinMaxPrizesDto, httpStatus);
	}

}
