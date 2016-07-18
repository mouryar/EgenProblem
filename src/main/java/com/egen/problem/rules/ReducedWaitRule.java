package com.egen.problem.rules;

import java.util.Date;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

import com.egen.problem.constants.Constants;
import com.egen.problem.db.DAO.AlertsDao;
import com.egen.problem.db.DAO.impl.AlertDaoImpl;
import com.egen.problem.ws.model.Alert;
import com.egen.problem.ws.model.IncomingData;

/**
* Rule for Reduced Weight
* @author  Rajala Mourya
* @version 1.0
*/
@Rule(name = "ReducedWaitRule")
public class ReducedWaitRule {
	
	private IncomingData data;
	
	public ReducedWaitRule()
	{
		
	}
	
	
	@Condition
    public boolean evaluate() {
		double change = ((Constants.baseWeight - Double.parseDouble(data.getValue()))/Constants.baseWeight)*100;
        if(change > 10)
        	return true;
        else
        	return false;
    }
	
	@Action
    public void execute() {
		Alert alert = new Alert();
        alert.setComment("Weight is reduced by more than 10%");
        alert.setTimestamp(new Date());
        AlertsDao dao = new AlertDaoImpl();
        try {
			dao.addAlert(alert);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void setData(IncomingData data)
	{
		this.data = data;
	}
	
}



