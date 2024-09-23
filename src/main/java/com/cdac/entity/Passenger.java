package com.cdac.entity;

public class Passenger {
	
	
	private String name;
	private Gender gender;
	private Status status;
	
	public static enum Gender{
		MALE,FEMALE,OTHER;
	}
	public static enum Status{
		CONFIRMED,RAC,WAITING;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Passenger [name=" + name + ", gender=" + gender + ", status=" + status + ", getName()=" + getName()
				+ ", getGender()=" + getGender() + ", getStatus()=" + getStatus() + "]";
	}
	

}
