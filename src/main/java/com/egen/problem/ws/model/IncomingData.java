package com.egen.problem.ws.model;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
* Incoming Data
* @author  Rajala Mourya
* @version 1.0
*/

@Entity("metrics")
public class IncomingData {
	@Id
    private ObjectId id;
	Date timestamp;
	String value;
	public Date getTimeStamp() {
		return timestamp;
	}
	public void setTimeStamp(String timeStamp) {
		DateFormat format = new SimpleDateFormat("MMddyyHHmmss");
		Date date = null;
		try {
			date = format.parse(timeStamp);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.timestamp = date;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
