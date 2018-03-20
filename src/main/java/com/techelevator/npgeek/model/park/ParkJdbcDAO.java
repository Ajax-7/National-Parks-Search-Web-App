package com.techelevator.npgeek.model.park;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class ParkJdbcDAO implements ParkDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public ParkJdbcDAO(DataSource dataSource) {
	this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Park> getAllParks() {
		List<Park> allParks = new ArrayList<>();
		String sqlSelectAllParks = "SELECT * FROM park ORDER BY parkname ASC";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks);
		while (results.next()) {
			allParks.add(MapRowToPark(results));
		}
		return allParks;
	}
	
	@Override
	public Park getParkByParkCode(String parkcode) {
		Park park = new Park();
		String sqlSelectPark = "SELECT * FROM park WHERE parkcode=?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectPark, parkcode);
		if(results.next()) {
		park = MapRowToPark(results);
		}
		return park;
	}
	
	@Override
	public List<Park> getTopParks() {
		List<Park> topParks = new ArrayList<>();
		String sqlSelectTopParks = "SELECT parkname, park.parkcode, count(survey_result.surveyid)  "+
						"FROM park join survey_result on survey_result.parkcode = park.parkcode "+
						"GROUP BY survey_result.parkcode, parkname, park.parkcode "+
						"ORDER BY count DESC, parkname ASC";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectTopParks);
		while (results.next()) {
			topParks.add(MapRowToFavPark(results));
		}
		return topParks;
	}

	private Park MapRowToFavPark(SqlRowSet row) {
		Park park = new Park();
		park.setParkCode(row.getString("parkcode"));
		park.setParkImg("/img/parks/" + (row.getString("parkcode")).toLowerCase() + ".jpg");
		park.setParkName(row.getString("parkname"));
		park.setFavParkCount(row.getInt("count"));
		return park;
	}

	private Park MapRowToPark(SqlRowSet row) {
		Park park = new Park();
		park.setParkCode(row.getString("parkcode"));
		park.setParkImg("/img/parks/" + (row.getString("parkcode")).toLowerCase() + ".jpg");
		park.setParkName(row.getString("parkname"));
		park.setState(row.getString("state"));
		park.setAcreage(row.getLong("acreage"));
		park.setElevationInFeet(row.getInt("elevationinfeet"));
		park.setMilesOfTrail(row.getDouble("milesoftrail"));
		park.setNumberOfCampsites(row.getInt("numberofcampsites"));
		park.setClimate(row.getString("climate"));
		park.setYearFounded(row.getInt("yearfounded"));
		park.setAnnualVisitorCount(row.getLong("annualvisitorcount"));
		park.setInspirationalQuote(row.getString("inspirationalquote"));
		park.setInspirationalQuoteSource(row.getString("inspirationalquotesource"));
		park.setParkDescription(row.getString("parkdescription"));
		park.setEntryFee(row.getBigDecimal("entryfee"));
		park.setNumberOfAnimalSpecies(row.getInt("numberofanimalspecies"));
		

		

		return park;
	}

}
