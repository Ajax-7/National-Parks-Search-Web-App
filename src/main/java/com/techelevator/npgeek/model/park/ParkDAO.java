package com.techelevator.npgeek.model.park;

import java.util.List;

public interface ParkDAO {

	public List<Park> getAllParks();

	public Park getParkByParkCode(String parkcode);

	public List<Park> getTopParks();

}
