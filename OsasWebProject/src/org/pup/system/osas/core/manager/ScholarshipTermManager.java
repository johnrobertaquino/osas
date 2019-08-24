package org.pup.system.osas.core.manager;

import java.sql.Connection;
import java.util.List;

import org.pup.system.osas.core.dao.ConnectionUtil;
import org.pup.system.osas.core.dao.ScholarshipTermDAO;
import org.pup.system.osas.core.domain.ScholarshipTerm;

public class ScholarshipTermManager {
	
	public void insertScholarshipTerm(ScholarshipTerm scholarshipTerm) throws Exception {
		ScholarshipTermDAO scholarshipTermDAO = null;
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			scholarshipTermDAO = new ScholarshipTermDAO(connection);
			
			scholarshipTermDAO.insertScholarshipTerm(scholarshipTerm);
			
			connection.commit();
			
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
	}
	
	public ScholarshipTerm getScholarshipTerm(int scholarshipTermId) throws Exception {
		ScholarshipTermDAO scholarshipTermDAO = null;
		ScholarshipTerm scholarshipTerm = null;
		
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			scholarshipTermDAO = new ScholarshipTermDAO(connection);
			
			scholarshipTerm = scholarshipTermDAO.getScholarshipTermByScholarshipTermId(scholarshipTermId);
			
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return scholarshipTerm;
	}
	
	public List<ScholarshipTerm> getScholarshipTermList() throws Exception {
		ScholarshipTermDAO scholarshipTermDAO = null;
		List<ScholarshipTerm> scholarshipTermList = null;

		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			scholarshipTermDAO = new ScholarshipTermDAO(connection);
			
			scholarshipTermList = scholarshipTermDAO.getScholarshipTermList();
			
		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return scholarshipTermList;
	}
	
	public List<ScholarshipTerm> getScholarshipTermListByScholarshipTermSearchText(String scholarshipTermSearchText) throws Exception {
		ScholarshipTermDAO scholarshipTermDAO = null;
		List<ScholarshipTerm> scholarshipTermList = null;
		
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			scholarshipTermDAO = new ScholarshipTermDAO(connection);
			
			scholarshipTermList = scholarshipTermDAO.getScholarshipTermList();
			
			scholarshipTermList = scholarshipTermDAO.getScholarshipTermListByScholarshipTermSearchText(scholarshipTermSearchText);
			
		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return scholarshipTermList;
	}

	public void saveScholarshipTerm(ScholarshipTerm scholarshipTerm) throws Exception {
		ScholarshipTermDAO scholarshipTermDAO = null;
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			scholarshipTermDAO = new ScholarshipTermDAO(connection);
			
			scholarshipTermDAO.saveScholarshipTerm(scholarshipTerm);
			
			connection.commit();
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
	}
}

