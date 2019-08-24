package org.pup.system.osas.core.manager;

import java.sql.Connection;
import java.util.List;

import org.pup.system.osas.core.dao.ConnectionUtil;
import org.pup.system.osas.core.dao.YearlyTermDAO;
import org.pup.system.osas.core.domain.YearlyTerm;

public class YearlyTermManager {
	
	public void insertYearlyTerm(YearlyTerm yearlyTerm) throws Exception {
		YearlyTermDAO yearlyTermDAO = null;
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			yearlyTermDAO = new YearlyTermDAO(connection);
			
			yearlyTermDAO.insertYearlyTerm(yearlyTerm);
			
			connection.commit();
			
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
	}
	
	public YearlyTerm getYearlyTerm(int yearlyTermId) throws Exception {
		YearlyTermDAO yearlyTermDAO = null;
		YearlyTerm yearlyTerm = null;
		
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			yearlyTermDAO = new YearlyTermDAO(connection);
			
			yearlyTerm = yearlyTermDAO.getYearlyTermByYearlyTermId(yearlyTermId);
			
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return yearlyTerm;
	}
	
	public List<YearlyTerm> getYearlyTermList() throws Exception {
		YearlyTermDAO yearlyTermDAO = null;
		List<YearlyTerm> yearlyTermList = null;

		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			yearlyTermDAO = new YearlyTermDAO(connection);
			
			yearlyTermList = yearlyTermDAO.getYearlyTermList();
			
		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return yearlyTermList;
	}
}
