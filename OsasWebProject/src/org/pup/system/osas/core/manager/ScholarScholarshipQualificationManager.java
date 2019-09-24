package org.pup.system.osas.core.manager;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.pup.system.osas.core.dao.ConnectionUtil;
import org.pup.system.osas.core.dao.ScholarQualificationDAO;
import org.pup.system.osas.core.domain.Scholar;
import org.pup.system.osas.core.domain.ScholarQualification;
import org.pup.system.osas.core.domain.ScholarScholarshipQualification;
import org.pup.system.osas.core.domain.ScholarshipQualification;

public class ScholarScholarshipQualificationManager {
	
	public List<ScholarScholarshipQualification> getScholarScholarshipQualificationList(int scholarId, int semTermId) throws Exception {
		ScholarQualificationDAO scholarQualificationDAO = null;
		ScholarshipQualificationManager scholarshipQualificationManager = null;
		ScholarManager scholarManager = null;
		List<ScholarshipQualification> scholarshipQualificationList = null;
		List<ScholarScholarshipQualification> scholarScholarshipQualificationList = null;

		Connection connection = null;

		try {
			connection = ConnectionUtil.createConnection();
			
			scholarManager = new ScholarManager();
			Scholar scholar = scholarManager.getScholar(scholarId);
			scholarshipQualificationManager = new ScholarshipQualificationManager();
			scholarshipQualificationList = scholarshipQualificationManager.getScholarshipQualificationList(scholar.getScholarshipProgram().getScholarshipProgramId(), semTermId);

			if (scholarshipQualificationList != null) {
				scholarQualificationDAO = new ScholarQualificationDAO(connection);

				for (ScholarshipQualification scholarshipQualification : scholarshipQualificationList) {
					if (scholarScholarshipQualificationList == null) {
						scholarScholarshipQualificationList = new ArrayList<ScholarScholarshipQualification>();
					}
					
					ScholarScholarshipQualification scholarScholarshipQualification = new ScholarScholarshipQualification();
					scholarScholarshipQualification.setScholarshipQualification(scholarshipQualification);
					
					ScholarQualification scholarQualification = scholarQualificationDAO.getScholarQualificationByScholarshipQualificationIdAndScholarId(scholarshipQualification.getScholarshipQualificationId(), scholarId);
					if	(scholarQualification != null) {
						scholarScholarshipQualification.setScholarQualification(scholarQualification);
					}
					
					scholarScholarshipQualificationList.add(scholarScholarshipQualification);
				}
			}

		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}

		return scholarScholarshipQualificationList;
	}
	
	
	public void insertScholarQualification(ScholarQualification scholarQualification) throws Exception {
		ScholarQualificationDAO scholarQualificationDAO = null;
		Connection connection = null;

		try {
			connection = ConnectionUtil.createConnection();

			scholarQualificationDAO = new ScholarQualificationDAO(connection);

			scholarQualificationDAO.insertScholarQualification(scholarQualification);

			connection.commit();

		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
	}
	public ScholarQualification getScholarQualification(int scholarQualificationId) throws Exception {
		ScholarQualificationDAO scholarQualificationDAO = null;
		ScholarQualification scholarQualification = null;
		
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			scholarQualificationDAO = new ScholarQualificationDAO(connection);
			
			scholarQualification = scholarQualificationDAO.getScholarQualificationByScholarQualificationId(scholarQualificationId);
			
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
		
		return scholarQualification;
	}
	
	public void saveScholarQualification(ScholarQualification scholarQualification) throws Exception {
		ScholarQualificationDAO scholarQualificationDAO = null;
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			scholarQualificationDAO = new ScholarQualificationDAO(connection);
			
			scholarQualificationDAO.saveScholarQualification(scholarQualification);
			
			connection.commit();
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
	}
	
	
}
