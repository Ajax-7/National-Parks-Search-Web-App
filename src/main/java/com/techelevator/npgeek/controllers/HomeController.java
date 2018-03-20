package com.techelevator.npgeek.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.model.park.ParkDAO;
import com.techelevator.npgeek.model.survey.Survey;
import com.techelevator.npgeek.model.survey.SurveyDAO;
import com.techelevator.npgeek.model.weather.WeatherDAO;

@Controller
public class HomeController {
	@Autowired
	ParkDAO parksDAO;
	@Autowired
	WeatherDAO weatherDAO;
	@Autowired
	SurveyDAO surveyDAO;
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String displayHomePage(ModelMap modelMap) {
		
		modelMap.put("allParks", parksDAO.getAllParks());
		return "homePage";
	}	
	
	@RequestMapping(path="/{parkCode}", method=RequestMethod.GET)
	public String displayCurrentPark(ModelMap mh, HttpSession session, @PathVariable String parkCode) {
		
		mh.put("park", parksDAO.getParkByParkCode(parkCode));
		mh.put("weatherRange",weatherDAO.getAllWeatherDays(parkCode));
		mh.put("parkCode", parkCode);
		
	
		return "detail";
	}
	
	@RequestMapping(path="/{parkCode}", method=RequestMethod.POST)
	public String displayNewTemp(ModelMap mh, HttpSession session, @PathVariable String parkCode, @RequestParam Boolean celcius) {
		
		Boolean isCelcius; 
		if(session.getAttribute("celcius") != null) {
			isCelcius = (Boolean) session.getAttribute("celcius");
			
		} else {
			 isCelcius = false;
			 session.setAttribute("celcius", isCelcius);
		}
		isCelcius = celcius;
		session.setAttribute("celcius", isCelcius);
		
		
		mh.put("park", parksDAO.getParkByParkCode(parkCode));
		mh.put("weatherRange",weatherDAO.getAllWeatherDays(parkCode));
		
		return "redirect:/{parkCode}";
	}
	
	@RequestMapping(path = "/surveyPage", method = RequestMethod.GET)
	public String displaySurveyPage(ModelMap modelMap) {
		
		modelMap.put("allParks", parksDAO.getAllParks());
		modelMap.put("allStates", surveyDAO.getStates());
		return "surveyPage";
	}
	
	@RequestMapping(path = "/surveyPage", method = RequestMethod.POST)
	public String showSpaceForumPost(@RequestParam String favNatPark, @RequestParam String yourEmail,
			@RequestParam String state, @RequestParam String activityLevel ) {
		String parkCode = favNatPark;
		Survey survey = new Survey();
		System.out.println("start of surveyPost");	
			survey.setParkCode(parkCode);
			survey.setEmailAddress(yourEmail);
			survey.setState(state);
			survey.setActivityLevel(activityLevel);
			System.out.println("before save in surveyPost");
			surveyDAO.save(survey);
			System.out.println("after surveyPost");
			
		return "redirect:/favParksPage";
	}

	@RequestMapping(path = "/favParksPage", method = RequestMethod.GET)
	public String displayFavParksPage(ModelMap modelMap) {
		
		modelMap.put("allParks", parksDAO.getTopParks());
		return "favParksPage";
	}

	
	}