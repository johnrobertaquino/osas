package org.pup.system.osas.core.manager;

import java.sql.Connection;
import java.util.List;

import org.pup.system.osas.core.dao.ConnectionUtil;
import org.pup.system.osas.core.dao.SemTermDAO;
import org.pup.system.osas.core.domain.SemTerm;

public class SemTermManager {
	
	public void insertSemTerm(SemTerm semTerm) throws Exception {
		SemTermDAO semTermDAO = null;
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			semTermDAO = new SemTermDAO(connection);
			
			semTermDAO.insertSemTerm(semTerm);
			
			connection.commit();
			
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
	}
	
	public SemTerm getSemTerm(int semTermId) throws Exception {
		SemTermDAO semTermDAO = null;
		SemTerm semTerm = null;
		
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			semTermDAO = new SemTermDAO(connection);
			
			semTerm = semTermDAO.getSemTermBySemTermId(semTermId);
			
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return semTerm;
	}
	
	public List<SemTerm> getSemTermList() throws Exception {
		SemTermDAO semTermDAO = null;
		List<SemTerm> semTermList = null;

		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			semTermDAO = new SemTermDAO(connection);
			
			semTermList = semTermDAO.getSemTermList();
			
		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return semTermList;
	}
}
