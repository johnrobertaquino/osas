package org.pup.system.osas.core.manager;

import java.sql.Connection;
import java.util.List;

import org.pup.system.osas.core.dao.ConnectionUtil;
import org.pup.system.osas.core.dao.ScholarDAO;
import org.pup.system.osas.core.domain.Scholar;
import org.pup.system.osas.core.domain.ScholarScholarshipQualification;
import org.pup.system.osas.core.domain.ScholarshipProgram;

public class ScholarManager 
{
	public Scholar getValidateScholar(String studentNumber, String firstName, String lastName, int scholarshipProgramId) throws Exception {
		ScholarDAO scholarDAO = null;
		ScholarshipProgramManager scholarshipProgramManager = null;
		Scholar scholar = null;
		
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			scholarDAO = new ScholarDAO(connection);
			
			scholar = scholarDAO.getScholarByScholarFullNameAndStudentNumber(studentNumber, firstName, lastName, scholarshipProgramId);
			
			if (scholar != null) {
				scholarshipProgramManager = new ScholarshipProgramManager();
				
				ScholarshipProgram scholarshipProgram = scholarshipProgramManager.getScholarshipProgram(scholar.getScholarshipProgram().getScholarshipProgramId());
				scholar.setScholarshipProgram(scholarshipProgram);
			}
			
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return scholar;
	}
	
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
		ScholarshipProgramManager scholarshipProgramManager = null;
		Scholar scholar = null;
		
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			scholarDAO = new ScholarDAO(connection);
			
			scholar = scholarDAO.getScholarByScholarId(scholarId);
			
			if (scholar != null) {
				scholarshipProgramManager = new ScholarshipProgramManager();
				
				ScholarshipProgram scholarshipProgram = scholarshipProgramManager.getScholarshipProgram(scholar.getScholarshipProgram().getScholarshipProgramId());
				scholar.setScholarshipProgram(scholarshipProgram);
			}
			
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
		ScholarshipProgramManager scholarshipProgramManager = null;
		ScholarScholarshipQualificationManager scholarScholarshipQualificationManager = null;
		List<Scholar> scholarList = null;
		
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			scholarDAO = new ScholarDAO(connection);
			
			scholarList = scholarDAO.getScholarList(semTermId);
			
			if (scholarList != null) {
				scholarshipProgramManager = new ScholarshipProgramManager();
				scholarScholarshipQualificationManager = new ScholarScholarshipQualificationManager();
				
				for (Scholar scholar : scholarList) {
					ScholarshipProgram scholarshipProgram = scholarshipProgramManager.getScholarshipProgram(scholar.getScholarshipProgram().getScholarshipProgramId());
					scholar.setScholarshipProgram(scholarshipProgram);
					
					List<ScholarScholarshipQualification> scholarScholarshipQualificationList = scholarScholarshipQualificationManager.getScholarScholarshipQualificationList(scholar.getScholarId(), semTermId);
					
					if (scholarScholarshipQualificationList != null) {
						scholar.setScholarScholarshipQualificationList(scholarScholarshipQualificationList);
					}
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
		ScholarshipProgramManager scholarshipProgramManager = null;
		ScholarScholarshipQualificationManager scholarScholarshipQualificationManager = null;
		List<Scholar> scholarList = null;
		
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			scholarDAO = new ScholarDAO(connection);
			
			scholarList = scholarDAO.getScholarListByScholarSearchText(scholarSearchText, semTermId);
			
			if (scholarList != null) {
				scholarshipProgramManager = new ScholarshipProgramManager();
				scholarScholarshipQualificationManager = new ScholarScholarshipQualificationManager();
				
				for (Scholar scholar : scholarList) {
					ScholarshipProgram scholarshipProgram = scholarshipProgramManager.getScholarshipProgram(scholar.getScholarshipProgram().getScholarshipProgramId());
					scholar.setScholarshipProgram(scholarshipProgram);
					
					List<ScholarScholarshipQualification> scholarScholarshipQualificationList = scholarScholarshipQualificationManager.getScholarScholarshipQualificationList(scholar.getScholarId(), semTermId);
					
					if (scholarScholarshipQualificationList != null) {
						scholar.setScholarScholarshipQualificationList(scholarScholarshipQualificationList);
					}
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
