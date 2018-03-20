package com.techelevator.npgeek.model.survey;

public interface SurveyDAO {
	public void save(Survey survey);

	public String[] getStates();

}
