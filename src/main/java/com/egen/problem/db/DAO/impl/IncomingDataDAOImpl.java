package com.egen.problem.db.DAO.impl;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

import javax.inject.Named;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import com.egen.problem.db.DAO.IncomingDataDAO;
import com.egen.problem.db.DAO.MongoDBClient;
import com.egen.problem.ws.model.IncomingData;

@Named("incomingDataDAO")
public class IncomingDataDAOImpl implements IncomingDataDAO{

	
	@Override
	public int saveIncomingData(IncomingData data) throws UnknownHostException {
		Datastore dataStore = MongoDBClient.createDataStore();
		dataStore.save(data);
		return 1;
	}

	@Override
	public List<IncomingData> getAllMetrics() throws UnknownHostException {
		Datastore dataStore = MongoDBClient.createDataStore();
		final Query<IncomingData> query = dataStore.createQuery(IncomingData.class);
		return query.asList();
	}

	@Override
	public List<IncomingData> getMetricsInSpecifiedTime(Date start, Date end) throws UnknownHostException {
		System.out.println("Start:"+ start.toString() +"End:"+end.toString());
		Datastore dataStore = MongoDBClient.createDataStore();
		final Query<IncomingData> query = dataStore.createQuery(IncomingData.class)
				.field("timestamp").greaterThanOrEq(start).field("timestamp").lessThanOrEq(end);
		return query.asList();
	}

	
	
	

}
