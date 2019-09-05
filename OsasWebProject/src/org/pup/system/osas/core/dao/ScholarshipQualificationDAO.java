package org.pup.system.osas.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.pup.system.osas.core.domain.Agency;
import org.pup.system.osas.core.domain.ScholarshipProgram;
import org.pup.system.osas.core.domain.ScholarshipQualification;

public class ScholarshipQualificationDAO extends DAO {

	public ScholarshipQualificationDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	
	public ScholarshipQualification getScholarshipQualificationByScholarshipQualificationId(int scholarshipQualificationId) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ScholarshipQualification scholarshipQualification = null;

		try {
			connection = getConnection();

			statement = connection.createStatement();

			resultSet = statement.executeQuery(
					"SELECT ScholarshipQualificationId, ScholarshipQualificationName, ScholarshipProgramId FROM scholarshipqualification WHERE ScholarshipQualificationId="
							+ scholarshipQualificationId);

			if (resultSet.next()) {
				scholarshipQualification = new ScholarshipQualification();
				scholarshipQualification.setScholarshipQualificationId(resultSet.getInt("ScholarshipQualificationId"));
				scholarshipQualification.setScholarshipQualificationName(resultSet.getString("ScholarshipQualificationName"));

				ScholarshipProgram scholarshipProgram = new ScholarshipProgram();
				scholarshipProgram.setScholarshipProgramId(resultSet.getInt("ScholarshipProgramId"));
				scholarshipQualification.setScholarshipProgram(scholarshipProgram);
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getScholarshipProgramByScholarshipProgramId method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}

		return scholarshipQualification;
	}

	public void insertScholarshipQualification(ScholarshipQualification scholarshipQualification) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();

			statement = connection.prepareStatement(
					"INSERT INTO scholarshipqualification(ScholarshipQualificationName, ScholarshipProgramId) VALUES (?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, scholarshipQualification.getScholarshipQualificationName());
			statement.setInt(2, scholarshipQualification.getScholarshipProgram().getScholarshipProgramId());

			statement.executeUpdate();

			resultSet = statement.getGeneratedKeys();

			if (resultSet.next()) {
				scholarshipQualification.setScholarshipQualificationId(resultSet.getInt(1));

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error occurred while doing insertScholarshipQualification method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
	}

	public List<ScholarshipQualification> getScholarshipQualificationList(int scholashipProgramId, int semTermId) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ScholarshipQualification scholarshipQualification = null;
		List<ScholarshipQualification> scholarshipQualificationList = null;

		try {
			connection = getConnection();

			statement = connection.createStatement();

			resultSet = statement.executeQuery(
					"SELECT scholarshipqualification.ScholarshipQualificationId, scholarshipqualification.ScholarshipQualificationName, scholarshipqualification.ScholarshipProgramId FROM scholarshipqualification JOIN scholarshipprogram on "
					+ "scholarshipqualification.ScholarshipProgramId = scholarshipprogram.ScholarshipProgramId JOIN agency on scholarshipprogram.AgencyId = agency.AgencyId WHERE scholarshipProgram.ScholarshipProgramId =" + scholashipProgramId + " AND agency.SemTermId =" + semTermId);

			while (resultSet.next()) {
				if (scholarshipQualificationList == null) {
					scholarshipQualificationList = new ArrayList<ScholarshipQualification>();
				}
				scholarshipQualification = new ScholarshipQualification();
				scholarshipQualification.setScholarshipQualificationId(resultSet.getInt("ScholarshipQualificationId"));
				scholarshipQualification.setScholarshipQualificationName(resultSet.getString("ScholarshipQualificationName"));

				ScholarshipProgram scholarshipProgram = new ScholarshipProgram();
				scholarshipProgram.setScholarshipProgramId(resultSet.getInt("ScholarshipProgramId"));
				scholarshipQualification.setScholarshipProgram(scholarshipProgram);

				scholarshipQualificationList.add(scholarshipQualification);
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getScholarshipProgramList method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}

		return scholarshipQualificationList;
	}

	public List<ScholarshipQualification> getScholarshipQualificationListByScholarshipQualificationSearchText(
		String scholarshipQualificationSearchText) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ScholarshipQualification scholarshipQualification = null;
		List<ScholarshipQualification> scholarshipQualificationList = null;

		try {
			connection = getConnection();

			statement = connection.createStatement();

			resultSet = statement.executeQuery(
					"SELECT ScholarshipQualificationId, ScholarshipQualificationName, ScholarshipProgramId FROM scholarshipqualification WHERE ScholarshipQualificationName LIKE '%"
							+ scholarshipQualificationSearchText + "%'");

			while (resultSet.next()) {
				if (scholarshipQualificationList == null) {
					scholarshipQualificationList = new ArrayList<ScholarshipQualification>();
				}

				scholarshipQualification = new ScholarshipQualification();
				scholarshipQualification.setScholarshipQualificationId(resultSet.getInt("ScholarshipQualificationId"));
				scholarshipQualification.setScholarshipQualificationName(resultSet.getString("ScholarshipQualificationName"));

				ScholarshipProgram scholarshipProgram = new ScholarshipProgram();
				scholarshipProgram.setScholarshipProgramId(resultSet.getInt("ScholarshipProgramId"));
				scholarshipQualification.setScholarshipProgram(scholarshipProgram);

				scholarshipQualificationList.add(scholarshipQualification);
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getScholarshipQualificationListByScholarshipQualificationSearchText method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}

		return scholarshipQualificationList;
	}

	public void saveScholarshipQualification(ScholarshipQualification scholarshipQualification) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = getConnection();

			statement = connection.prepareStatement(
					"UPDATE scholarshipqualification SET ScholarshipQualificationName=? WHERE ScholarshipQualificationId=?");
			statement.setString(1, scholarshipQualification.getScholarshipQualificationName());
			statement.setInt(2, scholarshipQualification.getScholarshipQualificationId());

			statement.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Error occurred while doing saveScholarshipQualification method", e);
		} finally {
			ConnectionUtil.closeDbResources(statement);
		}
	}

	public void deleteScholarshipQualificationByScholarshipQualificationId(int scholarshipQualificationId) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = getConnection();
			statement = connection.prepareStatement("DELETE FROM scholarshipqualification WHERE ScholarshipQualificationId=?");
			statement.setInt(1, scholarshipQualificationId);

			statement.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Error occurred while doing deleteScholarshipProgramByScholarshipProgramId method", e);
		} finally {
			ConnectionUtil.closeDbResources(statement);
		}
	}
}
