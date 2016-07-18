package com.egen.problem.db.DAO;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

import com.egen.problem.ws.model.IncomingData;

/**
* AlertsDao provides API for inserting and reading Alert messages
* @author  Rajala Mourya
* @version 1.0
*/
public interface IncomingDataDAO {

	/**
	   * Adds metric to metrics collection
	   * @param {@link IncomingData} 
	   * @return code
	   * @throws {@link UnknownHostException}
	   * @throws {@link Exception}
	   */
	public int saveIncomingData(IncomingData data) throws UnknownHostException;
	/**
	   * Get all metrics messages
	   * @return List<IncomingData> list of alerts
	   * @throws {@link UnknownHostException}
	   * @throws {@link Exception}
	   */
	public List<IncomingData> getAllMetrics() throws UnknownHostException;
	/**
	   * Get all metrics between start and end dates
	   * @param {@code Date}
	   * @param {@code Date}
	   * @return List<IncomingData> list of alerts
	   * @throws {@link UnknownHostException}
	   * @throws {@link Exception}
	   */
	public List<IncomingData> getMetricsInSpecifiedTime(Date start, Date end) throws UnknownHostException;
	
}
