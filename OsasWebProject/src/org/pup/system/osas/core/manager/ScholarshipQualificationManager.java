package org.pup.system.osas.core.manager;

import java.sql.Connection;
import java.util.List;

import org.pup.system.osas.core.dao.AgencyDAO;
import org.pup.system.osas.core.dao.ConnectionUtil;
import org.pup.system.osas.core.dao.ScholarshipProgramDAO;
import org.pup.system.osas.core.dao.ScholarshipQualificationDAO;
import org.pup.system.osas.core.domain.Agency;
import org.pup.system.osas.core.domain.ScholarshipProgram;
import org.pup.system.osas.core.domain.ScholarshipQualification;

public class ScholarshipQualificationManager {

	public void insertScholarshipQualification(ScholarshipQualification scholarshipQualification) throws Exception {
		ScholarshipQualificationDAO scholarshipQualificationDAO = null;
		Connection connection = null;

		try {
			connection = ConnectionUtil.createConnection();

			scholarshipQualificationDAO = new ScholarshipQualificationDAO(connection);

			scholarshipQualificationDAO.insertScholarshipQualification(scholarshipQualification);

			connection.commit();

		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
	}
	public ScholarshipQualification getScholarshipQualification(int scholarshipQualificationId) throws Exception {
		ScholarshipQualificationDAO scholarshipQualificationDAO = null;
		ScholarshipQualification scholarshipQualification = null;

		Connection connection = null;

		try {
			connection = ConnectionUtil.createConnection();

			scholarshipQualificationDAO = new ScholarshipQualificationDAO(connection);

			scholarshipQualification = scholarshipQualificationDAO.getScholarshipQualificationByScholarshipQualificationId(scholarshipQualificationId);

		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}

		return scholarshipQualification;
	}

	public List<ScholarshipQualification> getScholarshipQualificationList(int scholasrshipProgramId, int semTermId) throws Exception {
		ScholarshipQualificationDAO scholarshipQualificationDAO = null;
		ScholarshipProgramDAO scholarshipProgramDAO = null;
		List<ScholarshipQualification> scholarshipQualificationList = null;

		Connection connection = null;

		try {
			connection = ConnectionUtil.createConnection();

			scholarshipQualificationDAO = new ScholarshipQualificationDAO(connection);

			scholarshipQualificationList = scholarshipQualificationDAO.getScholarshipQualificationList(scholasrshipProgramId, semTermId);

			if (scholarshipQualificationList != null) {
				scholarshipProgramDAO = new ScholarshipProgramDAO(connection);

				for (ScholarshipQualification scholarshipQualification : scholarshipQualificationList) {
					ScholarshipProgram scholarshipProgram = scholarshipProgramDAO.getScholarshipProgramByScholarshipProgramId(scholarshipQualification.getScholarshipProgram().getScholarshipProgramId());
					scholarshipQualification.setScholarshipProgram(scholarshipProgram);
				}
			}

		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}

		return scholarshipQualificationList;
	}

	public List<ScholarshipQualification> getScholarshipQualificationListByScholarshipQualificationSearchText(
			String scholarshipQualificationSearchText) throws Exception {
		ScholarshipQualificationDAO scholarshipQualificationDAO = null;
		ScholarshipProgramDAO scholarshipProgramDAO = null;
		List<ScholarshipQualification> scholarshipQualificationList = null;

		Connection connection = null;

		try {
			connection = ConnectionUtil.createConnection();

			scholarshipQualificationDAO = new ScholarshipQualificationDAO(connection);

			scholarshipQualificationList = scholarshipQualificationDAO.getScholarshipQualificationListByScholarshipQualificationSearchText(scholarshipQualificationSearchText);
			
			if (scholarshipQualificationList != null) {
				scholarshipProgramDAO = new ScholarshipProgramDAO(connection);

				for (ScholarshipQualification scholarshipQualification : scholarshipQualificationList) {
					ScholarshipProgram scholarshipProgram = scholarshipProgramDAO.getScholarshipProgramByScholarshipProgramId(scholarshipQualification.getScholarshipProgram().getScholarshipProgramId());
					scholarshipQualification.setScholarshipProgram(scholarshipProgram);
				}
			}

		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}

		return scholarshipQualificationList;
	}

	public void saveScholarshipQualification(ScholarshipQualification scholarshipQualification) throws Exception {
		ScholarshipQualificationDAO scholarshipQualificationDAO = null;
		Connection connection = null;

		try {
			connection = ConnectionUtil.createConnection();

			scholarshipQualificationDAO = new ScholarshipQualificationDAO(connection);

			scholarshipQualificationDAO.saveScholarshipQualification(scholarshipQualification);

			connection.commit();
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
	}

	public void deleteScholarshipQualification(ScholarshipQualification scholarshipQualification) throws Exception {
		ScholarshipQualificationDAO scholarshipQualificationDAO = null;
		Connection connection = null;

		try {
			connection = ConnectionUtil.createConnection();

			scholarshipQualificationDAO = new ScholarshipQualificationDAO(connection);

			scholarshipQualificationDAO.deleteScholarshipQualificationByScholarshipQualificationId(scholarshipQualification.getScholarshipQualificationId());

			connection.commit();
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
	}
}
