package com.techelevator.npgeek.model.weather;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class WeatherJdbcDAO implements WeatherDAO{
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public WeatherJdbcDAO(DataSource dataSource) {
	this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Weather> getAllWeatherDays(String parkcode){
	List<Weather> weatherDays = new ArrayList<>();
	String sqlSelectAllDays = "SELECT * FROM weather WHERE parkcode = ? ";
	SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllDays, parkcode);
	while (results.next()) {
		weatherDays.add(MapRowToWeather(results));
	}
	return weatherDays;
	}
	
	private Weather MapRowToWeather(SqlRowSet row) {
		Weather weather = new Weather();
		String forecast = row.getString("forecast");
		String imageLink= "/img/weather/" + forecast.replaceAll("\\s", "") + ".png";
		weather.setParkCode(row.getString("parkcode"));
		weather.setFiveDayForecastValue(row.getInt("fivedayforecastvalue"));
		weather.setLow(row.getInt("low"));
		weather.setHigh(row.getInt("high"));
		weather.setForecast(forecast);
		weather.setImage(imageLink);
		return weather;
	}
	
}
