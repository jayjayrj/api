package com.jonas.api;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.jonas.api.entity.Movie;
import com.jonas.api.repository.MovieRepository;
import com.jonas.api.service.ProducerService;
import com.jonas.api.service.StudioService;

@SpringBootApplication(scanBasePackages = { "com.jonas.api" })
public class Application {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private StudioService studioService;

    @Autowired
    private ProducerService producerService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    /**
     * Utiliza o CommandLineRunner do Spring Boot para carregar os dados do arquivo CSV localizado em resources antes da
     * aplicação ser executada
     * 
     * @param appContext
     * @return
     */
    public CommandLineRunner carregaDadosCsv(ApplicationContext pApplicationContext) {
        return args -> {

            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("movielist.csv");
            Reader reader = new InputStreamReader(inputStream);
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withDelimiter(',')
                    .withHeader("year", "title", "studios", "producers", "winner").parse(reader);

            for (CSVRecord record : records) {
                if (record.getRecordNumber() == 1) {
                    continue;
                }

                String winner = record.get("winner");
                Movie movie = movieRepository
                        .save(new Movie(Integer.valueOf(record.get("year")), record.get("title"), winner));

                String studios = record.get("studios");
                studioService.saveStudios(movie, studios);

                String producers = record.get("producers");
                producerService.saveProducers(movie, producers);
            }

        };
    }

}
