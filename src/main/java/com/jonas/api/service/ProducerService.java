package com.jonas.api.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.jonas.api.dto.ProducerMinMaxPrizesDTO;
import com.jonas.api.dto.ProducerPrizesDTO;
import com.jonas.api.entity.Movie;
import com.jonas.api.entity.MovieProducer;
import com.jonas.api.entity.Producer;
import com.jonas.api.repository.MovieProducerRepository;
import com.jonas.api.repository.ProducerRepository;

@Service
public class ProducerService {

    Logger logger = LoggerFactory.getLogger(ProducerService.class);

    @Autowired
    private ProducerRepository producerRepository;

    @Autowired
    private MovieProducerRepository movieProducerRepository;

    public void saveProducers(Movie pMovie, String pProducers) {
        for (String stringProducer : pProducers.split(",|\\ and ")) {
            Producer producer = new Producer(stringProducer.trim());

            Example<Producer> example = Example.of(producer);

            if (producerRepository.exists(example)) {
                producer = producerRepository.findByName(stringProducer.trim());
            }
            else {
                producer = producerRepository.save(producer);
            }

            movieProducerRepository.save(new MovieProducer(pMovie, producer));
        }
    }

    public ProducerMinMaxPrizesDTO getMaxAndMinPrizes() {
        List<MovieProducer> movieProducerList = movieProducerRepository.findByMovieWinnerOrderByProducerId(true);

        ProducerPrizesDTO minProducerPrizesDTO = findMinInterval(movieProducerList);
        ProducerPrizesDTO maxProducerPrizesDTO = findMaxInterval(movieProducerList);

        ProducerMinMaxPrizesDTO producerMinMaxPrizesDTO = new ProducerMinMaxPrizesDTO();
        producerMinMaxPrizesDTO.addMin(minProducerPrizesDTO);
        producerMinMaxPrizesDTO.addMax(maxProducerPrizesDTO);

        return producerMinMaxPrizesDTO;
    }

    private ProducerPrizesDTO findMinInterval(List<MovieProducer> pMovieProducerList) {
        ProducerPrizesDTO minProducerPrizesDTO = new ProducerPrizesDTO(null, Integer.MAX_VALUE, null, null);

        for (int i = 0; i < pMovieProducerList.size() - 1; i++) {

            for (int j = i + 1; j < pMovieProducerList.size(); j++) {

                MovieProducer movieProducerI = pMovieProducerList.get(i);
                MovieProducer movieProducerJ = pMovieProducerList.get(j);

                if (movieProducerI.getProducer().equals(movieProducerJ.getProducer())) {
                    Integer minInterval = Math
                            .abs(movieProducerI.getMovie().getYear() - movieProducerJ.getMovie().getYear());

                    if (minInterval < minProducerPrizesDTO.getInterval()) {
                        minProducerPrizesDTO.setInterval(minInterval);
                        minProducerPrizesDTO.setProducer(movieProducerI.getProducer().getName());
                        minProducerPrizesDTO.setPreviousWin(movieProducerI.getMovie().getYear());
                        minProducerPrizesDTO.setFollowingWin(movieProducerJ.getMovie().getYear());

                        break;
                    }
                }
            }
        }

        return minProducerPrizesDTO;
    }

    private ProducerPrizesDTO findMaxInterval(List<MovieProducer> pMovieProducerList) {
        ProducerPrizesDTO maxProducerPrizesDTO = new ProducerPrizesDTO(null, Integer.MIN_VALUE, null, null);

        for (int i = 0; i < pMovieProducerList.size() - 1; i++) {

            for (int j = i + 1; j < pMovieProducerList.size(); j++) {

                MovieProducer movieProducerI = pMovieProducerList.get(i);
                MovieProducer movieProducerJ = pMovieProducerList.get(j);

                if (movieProducerI.getProducer().equals(movieProducerJ.getProducer())) {
                    Integer maxInterval = Math
                            .abs(movieProducerI.getMovie().getYear() - movieProducerJ.getMovie().getYear());

                    if (maxInterval > maxProducerPrizesDTO.getInterval()) {
                        maxProducerPrizesDTO.setInterval(maxInterval);
                        maxProducerPrizesDTO.setProducer(movieProducerI.getProducer().getName());
                        maxProducerPrizesDTO.setPreviousWin(movieProducerI.getMovie().getYear());
                        maxProducerPrizesDTO.setFollowingWin(movieProducerJ.getMovie().getYear());

                        break;
                    }
                }
            }
        }

        return maxProducerPrizesDTO;
    }

}
