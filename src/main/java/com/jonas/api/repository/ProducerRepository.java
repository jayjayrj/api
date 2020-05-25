package com.jonas.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jonas.api.entity.Producer;

public interface ProducerRepository extends JpaRepository<Producer, Long> {
	
	Producer findByName(String pName);
	
}
