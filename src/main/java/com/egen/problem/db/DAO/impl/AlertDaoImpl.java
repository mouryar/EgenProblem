package com.egen.problem.db.DAO.impl;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

import javax.inject.Named;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import com.egen.problem.db.DAO.AlertsDao;
import com.egen.problem.db.DAO.MongoDBClient;
import com.egen.problem.ws.model.Alert;

@Named("alertDao")
public class AlertDaoImpl implements AlertsDao{

	@Override
	public List<Alert> getAllAlerts() throws UnknownHostException {
		Datastore dataStore = MongoDBClient.createDataStore();
		final Query<Alert> query = dataStore.createQuery(Alert.class);
		return query.asList();
	}

	@Override
	public List<Alert> getAlertsInSpecifiedTime(Date start, Date end) throws UnknownHostException {
		Datastore dataStore = MongoDBClient.createDataStore();
		final Query<Alert> query = dataStore.createQuery(Alert.class)
				.field("timestamp").greaterThanOrEq(start).field("timestamp").lessThanOrEq(end);
		return query.asList();
	}

	@Override
	public int addAlert(Alert alert) throws UnknownHostException, Exception {
		Datastore dataStore = MongoDBClient.createDataStore();
		dataStore.save(alert);
		return 1;
	}

}
