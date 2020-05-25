package com.jonas.api.dto;

import java.util.ArrayList;
import java.util.List;

public class StudioDTO {
	
	private List<StudioWinDTO> studios;
	
	public StudioDTO(List<StudioWinDTO> pWinners) {
		this.studios = new ArrayList<>();
		this.studios.addAll(pWinners);
	}

	public List<StudioWinDTO> getStudios() {
		return studios;
	}

	public void setStudios(List<StudioWinDTO> pStudios) {
		this.studios = pStudios;
	}
	
}
