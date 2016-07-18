package com.egen.problem.ws.factory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.springframework.stereotype.Component;

import com.egen.problem.db.DAO.AlertsDao;
import com.egen.problem.db.DAO.IncomingDataDAO;

/**
* Gives instances of DAO's
* @author  Rajala Mourya
* @version 1.0
*/
@Singleton
@Component
public class DAOFactory {
	
	@Inject
	@Named("alertDao")
	private AlertsDao	alertDao;
	
	/**
	* @return {@link AlertDao}
	*/
	public AlertsDao getAlertsDao()
	{
			return alertDao;
	}
	
	
	@Inject
	@Named("incomingDataDAO")
	private IncomingDataDAO	incomingDataDAO;
	
	/**
	* @return {@link IncomingDataDAO}
	*/
	public IncomingDataDAO getIncomingDataDao()
	{
			return incomingDataDAO;
	}
	
}
