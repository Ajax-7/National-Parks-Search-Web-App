package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.npgeek.model.park.Park;
import com.techelevator.npgeek.model.survey.Survey;
import com.techelevator.npgeek.model.survey.SurveyJdbcDAO;
import com.techelevator.npgeek.model.weather.WeatherJdbcDAO;

public class SurveyDaoTest extends DAOIntegrationTest {

	private SurveyJdbcDAO testSurveyJdbcDAO;
	private Long testSurvey;
	
	@Before
	public void setUp() throws Exception {
		testSurveyJdbcDAO = new SurveyJdbcDAO(getDataSource());
	    JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
	    
	    String newSurvey = "INSERT INTO survey_result (surveyid, " + 
				"parkcode, " + 
				"emailaddress, " + 
				"state, " + 
				"activitylevel) VALUES ((default), ?, ?, ?, ?) RETURNING surveyid";
	    testSurvey = jdbcTemplate.queryForObject(newSurvey, Long.class, "GNP", "test@email.com", "ohio", "inactive" );	
	    
	}
	
	@Test
	public void testSave() {
	
		fail("Test not found");
	}
		

}
