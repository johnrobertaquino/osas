package org.pup.system.osas.core.manager;

import java.sql.Connection;
import java.util.List;

import org.pup.system.osas.core.dao.AgencyDAO;
import org.pup.system.osas.core.dao.ConnectionUtil;
import org.pup.system.osas.core.dao.ScholarDAO;
import org.pup.system.osas.core.dao.ScholarshipProgramDAO;
import org.pup.system.osas.core.domain.Agency;
import org.pup.system.osas.core.domain.Scholar;
import org.pup.system.osas.core.domain.ScholarshipProgram;

public class ScholarManager 
{
	public void insertScholar(Scholar scholar) throws Exception {
		ScholarDAO scholarDAO = null;
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			scholarDAO = new ScholarDAO(connection);
			
			scholarDAO.insertScholar(scholar);
			
			connection.commit();
			
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
	}
	
	public Scholar getScholar(int scholarId) throws Exception {
		ScholarDAO scholarDAO = null;
		Scholar scholar = null;
		
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			scholarDAO = new ScholarDAO(connection);
			
			scholar = scholarDAO.getScholarByScholarId(scholarId);
			
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return scholar;
	}
	
	public List<Scholar> getScholarList(int semTermId) throws Exception {
		ScholarDAO scholarDAO = null;
		ScholarshipProgramDAO scholarshipProgramDAO = null;
		List<Scholar> scholarList = null;
		
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			scholarDAO = new ScholarDAO(connection);
			
			scholarList = scholarDAO.getScholarList(semTermId);
			
			if (scholarList != null) {
				scholarshipProgramDAO = new ScholarshipProgramDAO(connection);

				for (Scholar scholar : scholarList) {
					ScholarshipProgram scholarshipProgram = scholarshipProgramDAO.getScholarshipProgramByScholarshipProgramId(scholar.getScholarshipProgram().getScholarshipProgramId());
					scholar.setScholarshipProgram(scholarshipProgram);
				}
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return scholarList;
	}
	
	public List<Scholar> getScholarListByScholarSearchText(String scholarSearchText, int semTermId) throws Exception {
		ScholarDAO scholarDAO = null;
		ScholarshipProgramDAO scholarshipProgramDAO = null;
		List<Scholar> scholarList = null;
		
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			scholarDAO = new ScholarDAO(connection);
			
			scholarList = scholarDAO.getScholarListByScholarSearchText(scholarSearchText, semTermId);
			
			if (scholarList != null) {
				scholarshipProgramDAO = new ScholarshipProgramDAO(connection);

				for (Scholar scholar : scholarList) {
					ScholarshipProgram scholarshipProgram = scholarshipProgramDAO.getScholarshipProgramByScholarshipProgramId(scholar.getScholarshipProgram().getScholarshipProgramId());
					scholar.setScholarshipProgram(scholarshipProgram);
				}
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return scholarList;
	}

	public void saveScholar(Scholar scholar) throws Exception {
		ScholarDAO scholarDAO = null;
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			scholarDAO = new ScholarDAO(connection);
			
			scholarDAO.saveScholar(scholar);
			
			connection.commit();
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
	}

	public void deleteScholar(Scholar scholar) throws Exception {
		ScholarDAO scholarDAO = null;
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			scholarDAO = new ScholarDAO(connection);
			
			scholarDAO.deleteScholarByScholarId(scholar.getScholarId());
			
			connection.commit();
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
	}
}
