package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.npgeek.model.park.Park;
import com.techelevator.npgeek.model.park.ParkJdbcDAO;
import com.techelevator.npgeek.model.weather.Weather;
import com.techelevator.npgeek.model.weather.WeatherJdbcDAO;

public class weatherDaoTest extends DAOIntegrationTest {

	private WeatherJdbcDAO sutWeather;
	private Integer newFiveDay;
	
	@Before
	public void setUp() throws Exception {
		sutWeather = new WeatherJdbcDAO(getDataSource());
	    JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
	    
	    
	    String newWeather = "INSERT INTO weather (parkcode, " + 
				"fivedayforecastvalue, " + 
				"low, " + 
				"high, " + 
				"forecast) VALUES (?, ?, ?, ?, ?) RETURNING fivedayforecastvalue";
		newFiveDay = jdbcTemplate.queryForObject(newWeather, Integer.class, "GNP", 6, 32, 64, "rain");

	}
	
//	Weather Test
	@Test
	public void testGetAllWeatherDays(){
		List<Weather> weatherInfo = sutWeather.getAllWeatherDays("GNP");
		for(Weather w : weatherInfo) {
	        if(w.getFiveDayForecastValue().equals(6)){
	        	assertEquals("GNP", w.getParkCode());
	        	assertEquals(new Integer(6), w.getFiveDayForecastValue());
	        	assertEquals(new Integer(32), w.getLow());
	        	assertEquals(new Integer(64), w.getHigh());
	        	assertEquals("rain", w.getForecast());
	        	assertEquals("17.78 C", w.getHighCelcius());
	        	assertEquals("64 F", w.getHighFahrenheit());
	        	assertEquals("32 F", w.getLowFahrenheit());
	        	assertEquals("0.00 C", w.getLowCelcius());
	        	return;
	        }
		}
	}
	
	@Test
	public void testGetCelHigh(){
		List<Weather> weatherInfo = sutWeather.getAllWeatherDays("GNP");
		for(Weather w : weatherInfo) {
	        if(w.getFiveDayForecastValue().equals(6)){
	        	assertEquals("17.78 C", w.getHighCelcius());

	        	return;
	        }
		}
	}
	
	@Test
	public void testGetCelLow(){
		List<Weather> weatherInfo = sutWeather.getAllWeatherDays("GNP");
		for(Weather w : weatherInfo) {
	        if(w.getFiveDayForecastValue().equals(6)){
	        	assertEquals("0.00 C", w.getLowCelcius());

	        	return;
	        }
		}
	}
	
	@Test
	public void testGetFLow(){
		List<Weather> weatherInfo = sutWeather.getAllWeatherDays("GNP");
		for(Weather w : weatherInfo) {
	        if(w.getFiveDayForecastValue().equals(6)){
	        	assertEquals("32 F", w.getLowFahrenheit());

	        	return;
	        }
		}
	}
	
	@Test
	public void testGetFHigh(){
		List<Weather> weatherInfo = sutWeather.getAllWeatherDays("GNP");
		for(Weather w : weatherInfo) {
	        if(w.getFiveDayForecastValue().equals(6)){
	        	assertEquals("64 F", w.getHighFahrenheit());
	        	return;
	        }
		}
	}

		

}
