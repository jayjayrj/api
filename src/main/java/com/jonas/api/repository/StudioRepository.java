package com.jonas.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jonas.api.dto.StudioWinDTO;
import com.jonas.api.entity.Studio;

public interface StudioRepository extends JpaRepository<Studio, Long>{
	
	Studio findByName(String pName);
	
	@Query(value="select new com.jonas.api.dto.StudioWinDTO(studio.name, count(movie.winner)) "
			+ "from MovieStudio as ms join ms.movie as movie join ms.studio as studio "
			+ "where movie.winner=true group by studio.name order by 2 desc")
	List<StudioWinDTO> findByWinners();

}
