package com.egen.problem.ws.web.api;

import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.easyrules.api.RulesEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.egen.problem.rules.GainedWeightRule;
import com.egen.problem.rules.ReducedWaitRule;
import com.egen.problem.ws.factory.DAOFactory;
import com.egen.problem.ws.model.IncomingData;

/**
* AlertController provides API for inserting and reading Alert messages
* @author  Rajala Mourya
* @version 1.0
*/

@RestController
public class IncomingDataController {

	@Autowired
	RulesEngine rulesEngine;
	@Autowired
	ReducedWaitRule reducedWeigthRule;
	@Autowired
	GainedWeightRule gainedWeightRule;
	@Autowired
	private DAOFactory daoFactory;

	
	@RequestMapping(value = "/api/metrics", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<IncomingData>> getAllMetrics() throws UnknownHostException, Exception {
		
		List<IncomingData> resposeData = null;
		resposeData = daoFactory.getIncomingDataDao().getAllMetrics();
		return new ResponseEntity<Collection<IncomingData>>(resposeData, HttpStatus.OK);
		
	}

	@RequestMapping(value = "/api/metrics", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IncomingData> saveIncomingData(@RequestBody IncomingData data) throws UnknownHostException, IllegalArgumentException, Exception {

		if(data ==null || data.getTimeStamp() == null || data.getValue() == null)
		{
			throw new IllegalArgumentException();
		}
		reducedWeigthRule.setData(data);
		gainedWeightRule.setData(data);
		rulesEngine.registerRule(reducedWeigthRule);
		rulesEngine.registerRule(gainedWeightRule);
		rulesEngine.fireRules();

		daoFactory.getIncomingDataDao().saveIncomingData(data);
		return new ResponseEntity<IncomingData>(data, HttpStatus.OK);
		
	}

	@RequestMapping(value = "/api/metrics/{start}/{end}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<IncomingData>> getMetricsInPeriod(@PathVariable String start,
			@PathVariable String end) throws ParseException, UnknownHostException, IllegalArgumentException, Exception{

		if( start == null || end == null || start.trim().equals("") || end.trim().equals(""))
		{
			throw new IllegalArgumentException();
		}

		DateFormat format = new SimpleDateFormat("MMddyy");
		Date startTime = null;
		Date endTime = null;

		startTime = format.parse(start);
		endTime = format.parse(end);

		List<IncomingData> resposeData = null;

		resposeData = daoFactory.getIncomingDataDao().getMetricsInSpecifiedTime(startTime, endTime);
		return new ResponseEntity<Collection<IncomingData>>(resposeData, HttpStatus.OK);
	}

}
