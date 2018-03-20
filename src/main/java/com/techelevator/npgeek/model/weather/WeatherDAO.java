package com.techelevator.npgeek.model.weather;

import java.util.List;

public interface WeatherDAO {

	public List<Weather> getAllWeatherDays(String parkcode);

}
