package com.techelevator;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.npgeek.model.park.Park;
import com.techelevator.npgeek.model.park.ParkJdbcDAO;
import com.techelevator.npgeek.model.survey.SurveyJdbcDAO;
import com.techelevator.npgeek.model.weather.WeatherJdbcDAO;

public abstract class DAOIntegrationTest {
	

	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	private static SingleConnectionDataSource dataSource;
	private ParkJdbcDAO sutPark;
	private String newParkCode;
	
	private SurveyJdbcDAO sutSurvey;
	private Long newSurveyId;
	
	private WeatherJdbcDAO sutWeather;
	private Integer newFiveDay;
	
	/* Before any tests are run, this method initializes the datasource for testing. */
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/npgeek");
		dataSource.setUsername("postgres");
		/* The following line disables autocommit for connections 
		 * returned by this DataSource. This allows us to rollback
		 * any changes after each test */
		dataSource.setAutoCommit(false);
	}
	
	/* After all tests have finished running, this method will close the DataSource */
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}
	/* This method provides access to the DataSource for subclasses so that 
	 * they can instantiate a DAO for testing */
	public DataSource getDataSource() {
		return dataSource;
	}

	@Before
	public void setUp() throws Exception {
		sutPark = new ParkJdbcDAO(dataSource);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//		String newPark = "INSERT INTO park (parkcode, " + 
//				"parkname, " + 
//				"state, " + 
//				"acreage, " + 
//				"elevationinfeet, " + 
//				"milesoftrail, " + 
//				"numberofcampsites, " + 
//				"climate, " + 
//				"yearfounded, " + 
//				"annualvisitorcount, " + 
//				"inspirationalquote, " + 
//				"inspirationalquotesource, " + 
//				"parkdescription, " + 
//				"entryfee, " + 
//				"numberofanimalspecies) "+
//				"VALUES ((default), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING parkcode";
//		newParkCode = jdbcTemplate.queryForObject(newPark, String.class, "Nat. TestGround", "testState", 
//			100, 200, 10, 2000, "meditest", "2000", 200, "We are GOING, to BUILD, A WALL", "TESTY TRUMP", "pretty self-explanatory", 10.00, 20);
//		
//		
//		String newSurvey = "INSERT INTO campground (surveyid, " + 
//				"parkcode, " + 
//				"emailaddress, " + 
//				"state, " + 
//				"activitylevel) VALUES ((default), ?, ?, ?, ?) RETURNING campground_id";
//		newSurveyId = jdbcTemplate.queryForObject(newSurvey, Long.class, newParkCode, "test@email.com", "ohio", "inactive" );
//		
		
//		String newWeather = "INSERT INTO campground (parkcode " + 
//				"fivedayforecastvalue " + 
//				"low " + 
//				"high " + 
//				"forecast) VALUES (?, ?, ?, ?, ?) RETURNING campground_id";
//		newFiveDay = jdbcTemplate.queryForObject(newWeather, Integer.class, newParkCode, 5, 32, 64, "rain");
//
	}
	
	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	

	
	
}
