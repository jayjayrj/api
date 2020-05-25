package com.jonas.api.dto;

public class ProducerPrizesDTO {
	
	private String producer;
	
	private Integer interval;
	
	private Integer previousWin;
	
	private Integer followingWin;
	
	public ProducerPrizesDTO() {}
	
	public ProducerPrizesDTO(String pProducer, Integer pInterval, Integer pPreviousWin, Integer pFollowingWin) {
		this.producer = pProducer;
		this.interval = pInterval;
		this.previousWin = pPreviousWin;
		this.followingWin = pFollowingWin;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String pProducer) {
		this.producer = pProducer;
	}

	public Integer getInterval() {
		return interval;
	}

	public void setInterval(Integer pInterval) {
		this.interval = pInterval;
	}

	public Integer getPreviousWin() {
		return previousWin;
	}

	public void setPreviousWin(Integer pPreviousWin) {
		this.previousWin = pPreviousWin;
	}

	public Integer getFollowingWin() {
		return followingWin;
	}

	public void setFollowingWin(Integer pFollowingWin) {
		this.followingWin = pFollowingWin;
	}
	
}
