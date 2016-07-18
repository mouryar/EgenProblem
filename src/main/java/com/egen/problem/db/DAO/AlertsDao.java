package com.egen.problem.db.DAO;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

import com.egen.problem.ws.model.Alert;

/**
* AlertsDao provides API for inserting and reading Alert messages
* @author  Rajala Mourya
* @version 1.0
*/
public interface AlertsDao {
	/**
	   * Adds Alert message to alerts collection
	   * @param Alert alert 
	   * @return code
	   * @throws {@link UnknownHostException}
	   * @throws {@link Exception}
	   */
	public int addAlert(Alert alert) throws UnknownHostException, Exception;
	/**
	   * Get all Alert messages
	   * @return List<Alert> list of alerts
	   * @throws {@link UnknownHostException}
	   * @throws {@link Exception}
	   */
	public List<Alert> getAllAlerts() throws UnknownHostException, Exception;
	/**
	   * Get all Alert messages between start and end dates
	   * @param {@code Date}
	   * @param {@code Date}
	   * @return List<Alert> list of alerts
	   * @throws {@link UnknownHostException}
	   * @throws {@link Exception}
	   */
	public List<Alert> getAlertsInSpecifiedTime(Date start, Date end) throws UnknownHostException, Exception;
}
