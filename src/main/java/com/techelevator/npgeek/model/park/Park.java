package com.techelevator.npgeek.model.park;

import java.math.BigDecimal;

public class Park {
	private String parkCode;
	private String parkImg;
	private String parkName;
	private String state;
	private Long acreage;
	private Integer elevationInFeet;
	private Double milesOfTrail;
	private Integer numberOfCampsites;
	private String climate;
	private Integer yearFounded;
	private Long annualVisitorCount;
	private String inspirationalQuote;
	private String inspirationalQuoteSource;
	private String parkDescription;
	private BigDecimal entryFee;
	private Integer numberOfAnimalSpecies;
	private Integer favParkCount = 0;
	
	
	
	//Getters and Setters
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public String getParkImg() {
		return parkImg;
	}
	public void setParkImg(String parkImg) {
		this.parkImg = parkImg;
	}
	public String getParkName() {
		return parkName;
	}
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Long getAcreage() {
		return acreage;
	}
	public void setAcreage(Long acreage) {
		this.acreage = acreage;
	}
	public Integer getElevationInFeet() {
		return elevationInFeet;
	}
	public void setElevationInFeet(Integer elevationInFeet) {
		this.elevationInFeet = elevationInFeet;
	}
	public Double getMilesOfTrail() {
		return milesOfTrail;
	}
	public void setMilesOfTrail(Double milesOfTrail) {
		this.milesOfTrail = milesOfTrail;
	}
	public Integer getNumberOfCampsites() {
		return numberOfCampsites;
	}
	public void setNumberOfCampsites(Integer numberOfCampsites) {
		this.numberOfCampsites = numberOfCampsites;
	}
	public String getClimate() {
		return climate;
	}
	public void setClimate(String climate) {
		this.climate = climate;
	}
	public Integer getYearFounded() {
		return yearFounded;
	}
	public void setYearFounded(Integer yearFounded) {
		this.yearFounded = yearFounded;
	}
	public Long getAnnualVisitorCount() {
		return annualVisitorCount;
	}
	public void setAnnualVisitorCount(Long annualVisitorCount) {
		this.annualVisitorCount = annualVisitorCount;
	}
	public String getInspirationalQuote() {
		return inspirationalQuote;
	}
	public void setInspirationalQuote(String inspirationalQuote) {
		this.inspirationalQuote = inspirationalQuote;
	}
	public String getInspirationalQuoteSource() {
		return inspirationalQuoteSource;
	}
	public void setInspirationalQuoteSource(String inspirationalQuoteSource) {
		this.inspirationalQuoteSource = inspirationalQuoteSource;
	}
	public String getParkDescription() {
		return parkDescription;
	}
	public void setParkDescription(String parkDescription) {
		this.parkDescription = parkDescription;
	}
	public BigDecimal getEntryFee() {
		return entryFee;
	}
	public void setEntryFee(BigDecimal entryFee) {
		this.entryFee = entryFee;
	}
	public Integer getNumberOfAnimalSpecies() {
		return numberOfAnimalSpecies;
	}
	public void setNumberOfAnimalSpecies(Integer numberOfAnimalSpecies) {
		this.numberOfAnimalSpecies = numberOfAnimalSpecies;
	}
	public Integer getFavParkCount() {
		return favParkCount;
	}
	public void setFavParkCount(Integer favParkCount) {
		this.favParkCount = favParkCount;
	}
	
	
	

}
