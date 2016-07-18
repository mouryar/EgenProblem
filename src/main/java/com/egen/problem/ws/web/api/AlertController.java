package com.egen.problem.ws.web.api;

import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.egen.problem.ws.factory.DAOFactory;
import com.egen.problem.ws.model.Alert;

/**
* AlertController provides API for inserting and reading Alert messages
* @author  Rajala Mourya
* @version 1.0
*/

@RestController
public class AlertController {
	@Autowired
	private DAOFactory daoFactory;
	
	@RequestMapping(value = "/api/alerts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Alert>> getAlerts() throws UnknownHostException , Exception{
		
		List<Alert> resposeData = null;
		resposeData = daoFactory.getAlertsDao().getAllAlerts();
		return new ResponseEntity<Collection<Alert>>(resposeData, HttpStatus.OK);
	}

	@RequestMapping(value = "/api/alerts/{start}/{end}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Alert>> getAlertsInPeriod(@PathVariable String start, @PathVariable String end) throws ParseException, UnknownHostException, Exception {

		if( start == null || end == null || start.trim().equals("") || end.trim().equals(""))
		{
			throw new IllegalArgumentException();
		}
		
		DateFormat format = new SimpleDateFormat("MMddyy");
		Date startTime = null;
		Date endTime = null;
		
		startTime = format.parse(start);
		endTime = format.parse(end);
		
		List<Alert> resposeData = null;
		resposeData = daoFactory.getAlertsDao().getAlertsInSpecifiedTime(startTime, endTime);
		return new ResponseEntity<Collection<Alert>>(resposeData, HttpStatus.OK);
	}
}
