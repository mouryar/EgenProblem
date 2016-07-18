package com.egen.problem.ws.web.api.mock;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.egen.problem.db.DAO.AlertsDao;
import com.egen.problem.ws.model.Alert;

public class AlertDaoMock implements AlertsDao{

	@Override
	public int addAlert(Alert alert) throws UnknownHostException, Exception {
		return 1;
	}

	@Override
	public List<Alert> getAllAlerts() throws UnknownHostException, Exception {
		return new ArrayList<Alert>();
	}

	@Override
	public List<Alert> getAlertsInSpecifiedTime(Date start, Date end) throws UnknownHostException, Exception {
		return new ArrayList<Alert>();
	}

}
