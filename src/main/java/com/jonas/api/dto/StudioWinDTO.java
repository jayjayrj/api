package com.jonas.api.dto;

public class StudioWinDTO {
	
	private String name;
	
	private Long winCount;
	
	public StudioWinDTO () {}
	
	public StudioWinDTO (String pName, Long pWinCount) {
		this.name = pName;
		this.winCount = pWinCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String pName) {
		this.name = pName;
	}

	public Long getWinCount() {
		return winCount;
	}

	public void setWinCount(Long pWinCount) {
		this.winCount = pWinCount;
	}
	
}
