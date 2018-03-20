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

	

	public class ParkDaoTest extends DAOIntegrationTest {

	private ParkJdbcDAO testJDBCdaoObjectPark;
	private String newParkCode;

	

	@Before
	public void setUp() throws Exception {
		testJDBCdaoObjectPark = new ParkJdbcDAO(getDataSource());
	    JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
	    
	    String sqlParkIns = ("INSERT INTO park (parkcode, parkname, state, acreage, elevationinfeet, milesoftrail, numberofcampsites, climate, yearfounded, annualvisitorcount, inspirationalquote, inspirationalquotesource, parkdescription, entryfee, numberofanimalspecies) "
	            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING parkcode");
	    newParkCode = jdbcTemplate.queryForObject(sqlParkIns, String.class, "AAA", "ParkName", "AA", 20, 21, 22.0, 23, "hot",  2000, 12, "cool", "coolio", "neat", 15, 2);
	    
	}
	@Test
	public void testAllParks() {
	    List<Park> parkInfo = testJDBCdaoObjectPark.getAllParks();
	    for(Park p : parkInfo) {
	        if(p.getParkCode().contentEquals(newParkCode)){
	            assertEquals(newParkCode, p.getParkCode());
	            assertEquals("ParkName", p.getParkName());
	            assertEquals("AA", p.getState());
	            assertEquals(new Long(20), p.getAcreage());
	            assertEquals(new Integer(21), p.getElevationInFeet());
	            assertEquals(new Double(22.0), p.getMilesOfTrail());
	            assertEquals(new Integer(23), p.getNumberOfCampsites());
	            assertEquals("hot", p.getClimate());
	            assertEquals(new Integer(2000), p.getYearFounded());
	            assertEquals(new Long(12), p.getAnnualVisitorCount());
	            assertEquals("cool", p.getInspirationalQuote()); 
	            assertEquals("coolio", p.getInspirationalQuoteSource());
	            assertEquals("neat", p.getParkDescription());
	            assertEquals(new BigDecimal(15), p.getEntryFee());
	            assertEquals(new Integer(2), p.getNumberOfAnimalSpecies());
	            return;
	        }
	    }
	    fail("Test Park was not found");
	}
	
	@Test
	public void testGetParkByParkCode() {
		Park park = testJDBCdaoObjectPark.getParkByParkCode("AAA");
		assertEquals("ParkName", park.getParkName());
	}
	
	
}

