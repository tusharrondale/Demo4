package com.cdac.entity;

import java.time.LocalDateTime;
import java.util.List;

public class Pnr {
	
	private int pnrNo;
	private int trainNo;
	private LocalDateTime travelDate;
	private List<Passenger> passenger;
	public int getPnrNo() {
		return pnrNo;
	}
	public void setPnrNo(int pnrNo) {
		this.pnrNo = pnrNo;
	}
	public int getTrainNo() {
		return trainNo;
	}
	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}
	public LocalDateTime getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(LocalDateTime travelDate) {
		this.travelDate = travelDate;
	}
	public List<Passenger> getPassenger() {
		return passenger;
	}
	public void setPassenger(List<Passenger> passenger) {
		this.passenger = passenger;
	}
	
	
	

}
