package org.pup.system.osas.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.pup.system.osas.core.domain.Agency;
import org.pup.system.osas.core.domain.ScholarshipProgram;
import org.pup.system.osas.core.domain.SemTerm;

public class ScholarshipProgramDAO extends DAO {

	public ScholarshipProgramDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	public ScholarshipProgram getScholarshipProgramByScholarshipProgramId(int scholarshipProgramId) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ScholarshipProgram scholarshipProgram = null;

		try {
			connection = getConnection();

			statement = connection.createStatement();

			resultSet = statement.executeQuery(
					"SELECT ScholarshipProgramId, ScholarshipProgramName, AgencyId FROM scholarshipprogram WHERE ScholarshipProgramId="
							+ scholarshipProgramId);

			if (resultSet.next()) {
				scholarshipProgram = new ScholarshipProgram();
				scholarshipProgram.setScholarshipProgramId(resultSet.getInt("ScholarshipProgramId"));
				scholarshipProgram.setScholarshipProgramName(resultSet.getString("ScholarshipProgramName"));

				Agency agency = new Agency();
				agency.setAgencyId(resultSet.getInt("AgencyId"));
				scholarshipProgram.setAgency(agency);
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getScholarshipProgramByScholarshipProgramId method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}

		return scholarshipProgram;
	}

	public void insertScholarshipProgram(ScholarshipProgram scholarshipProgram) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();

			statement = connection.prepareStatement(
					"INSERT INTO scholarshipProgram(ScholarshipProgramName, AgencyId) VALUES (?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, scholarshipProgram.getScholarshipProgramName());

			Agency agency = new Agency();
			statement.setInt(2, agency.getAgencyId());
			scholarshipProgram.setAgency(agency);

			statement.executeUpdate();

			resultSet = statement.getGeneratedKeys();

			if (resultSet.next()) {
				scholarshipProgram.setScholarshipProgramId(resultSet.getInt(1));

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error occurred while doing insertScholarshipProgram method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
	}

	public List<ScholarshipProgram> getScholarshipProgramList(int semTermId) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ScholarshipProgram scholarshipProgram = null;
		List<ScholarshipProgram> scholarshipProgramList = null;

		try {
			connection = getConnection();

			statement = connection.createStatement();

			resultSet = statement.executeQuery(
					"SELECT * FROM scholarshipprogram JOIN agency on scholarshipprogram.AgencyId = agency.AgencyId WHERE agency.SemTermId=" + semTermId);

			while (resultSet.next()) {
				if (scholarshipProgramList == null) {
					scholarshipProgramList = new ArrayList<ScholarshipProgram>();
				}
				scholarshipProgram = new ScholarshipProgram();
				scholarshipProgram.setScholarshipProgramId(resultSet.getInt("ScholarshipProgramId"));
				scholarshipProgram.setScholarshipProgramName(resultSet.getString("ScholarshipProgramName"));

				Agency agency = new Agency();
				agency.setAgencyId(resultSet.getInt("AgencyId"));
				scholarshipProgram.setAgency(agency);

				scholarshipProgramList.add(scholarshipProgram);
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getScholarshipProgramList method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}

		return scholarshipProgramList;
	}

	public List<ScholarshipProgram> getScholarshipProgramListByScholarshipProgramSearchText(
			String scholarshipProgramSearchText) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ScholarshipProgram scholarshipProgram = null;
		List<ScholarshipProgram> scholarshipProgramList = null;

		try {
			connection = getConnection();

			statement = connection.createStatement();

			resultSet = statement.executeQuery(
					"SELECT ScholarshipProgramId, ScholarshipProgramName, AgencyId FROM scholarshipprogram WHERE ScholarshipProgramName LIKE '%"
							+ scholarshipProgramSearchText + "%'");

			while (resultSet.next()) {
				if (scholarshipProgramList == null) {
					scholarshipProgramList = new ArrayList<ScholarshipProgram>();
				}

				scholarshipProgram = new ScholarshipProgram();
				scholarshipProgram.setScholarshipProgramId(resultSet.getInt("ScholarshipProgramId"));
				scholarshipProgram.setScholarshipProgramName(resultSet.getString("ScholarshipProgramName"));

				Agency agency = new Agency();
				agency.setAgencyId(resultSet.getInt("AgencyId"));
				scholarshipProgram.setAgency(agency);

				scholarshipProgramList.add(scholarshipProgram);
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getScholarshipProgramList method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}

		return scholarshipProgramList;
	}

	public void saveScholarshipProgram(ScholarshipProgram scholarshipProgram) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = getConnection();

			statement = connection.prepareStatement(
					"UPDATE scholarshipprogram SET ScholarshipProgramName=? WHERE ScholarshipProgramId=?");
			statement.setString(1, scholarshipProgram.getScholarshipProgramName());
			statement.setInt(2, scholarshipProgram.getScholarshipProgramId());

			statement.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Error occurred while doing saveScholarshipProgram method", e);
		} finally {
			ConnectionUtil.closeDbResources(statement);
		}
	}

	public void deleteScholarshipProgramByScholarshipProgramId(int scholarshipProgramId) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = getConnection();
			statement = connection.prepareStatement("DELETE FROM scholarshipprogram WHERE ScholarshipProgramId=?");
			statement.setInt(1, scholarshipProgramId);

			statement.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Error occurred while doing deleteScholarshipProgramByScholarshipProgramId method", e);
		} finally {
			ConnectionUtil.closeDbResources(statement);
		}
	}
}
