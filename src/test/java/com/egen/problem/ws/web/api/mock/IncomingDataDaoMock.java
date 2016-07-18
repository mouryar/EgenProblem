package com.egen.problem.ws.web.api.mock;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.egen.problem.db.DAO.IncomingDataDAO;
import com.egen.problem.ws.model.IncomingData;

public class IncomingDataDaoMock implements IncomingDataDAO{

	@Override
	public int saveIncomingData(IncomingData data) throws UnknownHostException {
		return 1;
	}

	@Override
	public List<IncomingData> getAllMetrics() throws UnknownHostException {
		return new ArrayList<IncomingData>();
	}

	@Override
	public List<IncomingData> getMetricsInSpecifiedTime(Date start, Date end) throws UnknownHostException {
		return new ArrayList<IncomingData>();
	}

}
