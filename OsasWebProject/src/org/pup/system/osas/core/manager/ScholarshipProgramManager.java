package org.pup.system.osas.core.manager;

import java.sql.Connection;
import java.util.List;

import org.pup.system.osas.core.dao.AgencyDAO;
import org.pup.system.osas.core.dao.ConnectionUtil;
import org.pup.system.osas.core.dao.ScholarshipProgramDAO;
import org.pup.system.osas.core.domain.Agency;
import org.pup.system.osas.core.domain.ScholarshipProgram;

public class ScholarshipProgramManager {

	public void insertScholarshipProgram(ScholarshipProgram scholarshipProgram) throws Exception {
		ScholarshipProgramDAO scholarshipProgramDAO = null;
		Connection connection = null;

		try {
			connection = ConnectionUtil.createConnection();

			scholarshipProgramDAO = new ScholarshipProgramDAO(connection);

			scholarshipProgramDAO.insertScholarshipProgram(scholarshipProgram);
			
			List<ScholarshipProgram> scholarshipProgramList = scholarshipProgramDAO.getScholarshipProgramList();

			if (scholarshipProgramList != null) {
				AgencyDAO agencyDAO = new AgencyDAO(connection);

				for (ScholarshipProgram scholarshipProgram1 : scholarshipProgramList) {
					Agency agency = agencyDAO.getAgencyByAgencyId(scholarshipProgram1.getAgency().getAgencyId());
					scholarshipProgram1.setAgency(agency);
				}
			}

			connection.commit();

		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
	}

	public ScholarshipProgram getScholarshipProgram(int scholarshipProgramId) throws Exception {
		ScholarshipProgramDAO scholarshipProgramDAO = null;
		ScholarshipProgram scholarshipProgram = null;

		Connection connection = null;

		try {
			connection = ConnectionUtil.createConnection();

			scholarshipProgramDAO = new ScholarshipProgramDAO(connection);

			scholarshipProgram = scholarshipProgramDAO.getScholarshipProgramByScholarshipProgramId(scholarshipProgramId);

		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}

		return scholarshipProgram;
	}

	public List<ScholarshipProgram> getScholarshipProgramList() throws Exception {
		ScholarshipProgramDAO scholarshipProgramDAO = null;
		AgencyDAO agencyDAO = null;
		List<ScholarshipProgram> scholarshipProgramList = null;

		Connection connection = null;

		try {
			connection = ConnectionUtil.createConnection();

			scholarshipProgramDAO = new ScholarshipProgramDAO(connection);

			scholarshipProgramList = scholarshipProgramDAO.getScholarshipProgramList();

			if (scholarshipProgramList != null) {
				agencyDAO = new AgencyDAO(connection);

				for (ScholarshipProgram scholarshipProgram : scholarshipProgramList) {
					Agency agency = agencyDAO.getAgencyByAgencyId(scholarshipProgram.getAgency().getAgencyId());
					scholarshipProgram.setAgency(agency);
				}
			}

		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}

		return scholarshipProgramList;
	}

	public List<ScholarshipProgram> getScholarshipProgramListByScholarshipProgramSearchText(
			String scholarshipProgramSearchText) throws Exception {
		ScholarshipProgramDAO scholarshipProgramDAO = null;
		AgencyDAO agencyDAO = null;
		List<ScholarshipProgram> scholarshipProgramList = null;

		Connection connection = null;

		try {
			connection = ConnectionUtil.createConnection();

			scholarshipProgramDAO = new ScholarshipProgramDAO(connection);

			scholarshipProgramList = scholarshipProgramDAO.getScholarshipProgramListByScholarshipProgramSearchText(scholarshipProgramSearchText);
			
			if (scholarshipProgramList != null) {
				agencyDAO = new AgencyDAO(connection);

				for (ScholarshipProgram scholarshipProgram : scholarshipProgramList) {
					Agency agency = agencyDAO.getAgencyByAgencyId(scholarshipProgram.getAgency().getAgencyId());
					scholarshipProgram.setAgency(agency);
				}
			}

		} catch (Exception e) {
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}

		return scholarshipProgramList;
	}

	public void saveScholarshipProgram(ScholarshipProgram scholarshipProgram) throws Exception {
		ScholarshipProgramDAO scholarshipProgramDAO = null;
		Connection connection = null;

		try {
			connection = ConnectionUtil.createConnection();

			scholarshipProgramDAO = new ScholarshipProgramDAO(connection);

			scholarshipProgramDAO.saveScholarshipProgram(scholarshipProgram);

			connection.commit();
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
	}

	public void deleteScholarshipProgram(ScholarshipProgram scholarshipProgram) throws Exception {
		ScholarshipProgramDAO scholarshipProgramDAO = null;
		Connection connection = null;

		try {
			connection = ConnectionUtil.createConnection();

			scholarshipProgramDAO = new ScholarshipProgramDAO(connection);

			scholarshipProgramDAO.deleteScholarshipProgramByScholarshipProgramId(scholarshipProgram.getScholarshipProgramId());

			connection.commit();
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
	}
}
