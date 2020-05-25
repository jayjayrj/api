package com.jonas.api.dto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProducerMinMaxPrizesDTO {
	
	private List<ProducerPrizesDTO> min = new ArrayList<>();
	
	private List<ProducerPrizesDTO> max = new ArrayList<>();
	
	public ProducerMinMaxPrizesDTO () {}
	
	public ProducerMinMaxPrizesDTO (LinkedList<ProducerPrizesDTO> pProducerPrizesDTOList) {
		this.min.add(pProducerPrizesDTOList.getFirst());
		this.max.add(pProducerPrizesDTOList.getLast());
	}

	public List<ProducerPrizesDTO> getMin() {
		return min;
	}

	public void setMin(List<ProducerPrizesDTO> pMinProducerPrizesDTO) {
		this.min = pMinProducerPrizesDTO;
	}

	public List<ProducerPrizesDTO> getMax() {
		return max;
	}

	public void setMax(List<ProducerPrizesDTO> pMaxProducerPrizesDTO) {
		this.max = pMaxProducerPrizesDTO;
	}
	
	public void addMin(ProducerPrizesDTO pMinProducerPrizesDTO) {
		this.getMin().add(pMinProducerPrizesDTO);
	}
	
	public void addMax(ProducerPrizesDTO pMaxProducerPrizesDTO) {
		this.getMax().add(pMaxProducerPrizesDTO);
	}

}
