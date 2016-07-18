package com.egen.problem.ws.factory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.springframework.stereotype.Component;

import com.egen.problem.db.DAO.AlertsDao;
import com.egen.problem.db.DAO.IncomingDataDAO;

@Singleton
@Component
public class DAOFactory {
	
	@Inject
	@Named("alertDao")
	private AlertsDao	alertDao;
	public AlertsDao getAlertsDao()
	{
			return alertDao;
	}
	
	
	@Inject
	@Named("incomingDataDAO")
	private IncomingDataDAO	incomingDataDAO;
	public IncomingDataDAO getIncomingDataDao()
	{
			return incomingDataDAO;
	}
	
}
