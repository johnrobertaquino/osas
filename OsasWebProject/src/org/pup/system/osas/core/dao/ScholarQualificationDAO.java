package org.pup.system.osas.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.pup.system.osas.core.domain.ScholarQualification;

public class ScholarQualificationDAO extends DAO {

	public ScholarQualificationDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	
	public ScholarQualification getScholarQualificationByScholarshipQualificationIdAndScholarId(
			int scholarshipQualificationId, int scholarId) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ScholarQualification scholarQualification = null;

		try {
			connection = getConnection();

			statement = connection.createStatement();

			resultSet = statement.executeQuery(
					"SELECT ScholarQualificationId, ScholarshipQualificationId, Qualified, Notes, Filename, ScholarId FROM scholarqualification WHERE ScholarshipQualificationId="
							+ scholarshipQualificationId + " AND ScholarId=" + scholarId);

			if (resultSet.next()) {
				scholarQualification = new ScholarQualification();
				scholarQualification.setScholarQualificationId(resultSet.getInt("ScholarQualificationId"));
				scholarQualification.setScholarshipQualificationId(resultSet.getInt("ScholarshipQualificationId"));
				scholarQualification.setQualified(resultSet.getBoolean("Qualified"));
				scholarQualification.setNotes(resultSet.getString("Notes"));
				scholarQualification.setFilename(resultSet.getString("Filename"));
				scholarQualification.setScholarId(resultSet.getInt("ScholarId"));
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getScholarQualificationByScholarshipQualificationIdAndScholarId method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}

		return scholarQualification;
	}
	
	public ScholarQualification getScholarQualificationByScholarQualificationId(
			int scholarQualificationId) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ScholarQualification scholarQualification = null;

		try {
			connection = getConnection();

			statement = connection.createStatement();

			resultSet = statement.executeQuery(
					"SELECT ScholarQualificationId, ScholarshipQualificationId, Qualified, Notes, Filename, ScholarId FROM scholarqualification WHERE ScholarQualificationId="
							+ scholarQualificationId);

			if (resultSet.next()) {
				scholarQualification = new ScholarQualification();
				scholarQualification.setScholarQualificationId(resultSet.getInt("ScholarQualificationId"));
				scholarQualification.setScholarshipQualificationId(resultSet.getInt("ScholarshipQualificationId"));
				scholarQualification.setQualified(resultSet.getBoolean("Qualified"));
				scholarQualification.setNotes(resultSet.getString("Notes"));
				scholarQualification.setFilename(resultSet.getString("Filename"));
				scholarQualification.setScholarId(resultSet.getInt("ScholarId"));
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getScholarQualificationByScholarQualificationId method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}

		return scholarQualification;
	}
	
	public void saveScholarQualification(ScholarQualification scholarQualification) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = getConnection();

			statement = connection.prepareStatement("UPDATE scholarqualification SET ScholarshipQualificationId=?, Qualified=?, Notes=?, Filename=?, ScholarId=? WHERE ScholarQualificationId=?");
			statement.setInt(1, scholarQualification.getScholarshipQualificationId());
			statement.setBoolean(2, scholarQualification.isQualified());
			statement.setString(3, scholarQualification.getNotes());
			statement.setString(4, scholarQualification.getFilename());
			statement.setInt(5, scholarQualification.getScholarId());
			statement.setInt(6, scholarQualification.getScholarQualificationId());
			
			statement.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Error occurred while doing saveScholarQualification method", e);
		} finally {
			ConnectionUtil.closeDbResources(statement);
		}
	}

}
