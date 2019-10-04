package org.pup.system.osas.core.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
					"SELECT ScholarQualificationId, ScholarshipQualificationId, Qualified, Notes, DateSubmitted, Filename, ScholarId FROM scholarqualification WHERE ScholarshipQualificationId="
							+ scholarshipQualificationId + " AND ScholarId=" + scholarId);

			if (resultSet.next()) {
				scholarQualification = new ScholarQualification();
				scholarQualification.setScholarQualificationId(resultSet.getInt("ScholarQualificationId"));
				scholarQualification.setScholarshipQualificationId(resultSet.getInt("ScholarshipQualificationId"));
				scholarQualification.setQualified(resultSet.getBoolean("Qualified"));
				scholarQualification.setNotes(resultSet.getString("Notes"));
				scholarQualification.setDateSubmitted(resultSet.getDate("DateSubmitted"));
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
					"SELECT ScholarQualificationId, ScholarshipQualificationId, Qualified, Notes, DateSubmitted, Filename, ScholarId FROM scholarqualification WHERE ScholarQualificationId="
							+ scholarQualificationId);

			if (resultSet.next()) {
				scholarQualification = new ScholarQualification();
				scholarQualification.setScholarQualificationId(resultSet.getInt("ScholarQualificationId"));
				scholarQualification.setScholarshipQualificationId(resultSet.getInt("ScholarshipQualificationId"));
				scholarQualification.setQualified(resultSet.getBoolean("Qualified"));
				scholarQualification.setNotes(resultSet.getString("Notes"));
				scholarQualification.setDateSubmitted(resultSet.getDate("DateSubmitted"));
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
	
	public List<ScholarQualification> getScholarQualificationListByScholarQualificationSearchText(
		String scholarQualificationSearchText, int semTermId) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ScholarQualification scholarQualification = null;
		List<ScholarQualification> scholarQualificationList = null;

		try {
			connection = getConnection();

			statement = connection.createStatement();

			resultSet = statement.executeQuery(
					"SELECT ScholarQualificationId, ScholarshipQualificationId, Qualified, Notes, DateSubmitted, Filename, ScholarId FROM scholarqualification WHERE DateSubmitted="
							+ scholarQualificationSearchText);

			while (resultSet.next()) {
				if(scholarQualificationList == null) {
					scholarQualificationList = new ArrayList<ScholarQualification>();
				}
				scholarQualification = new ScholarQualification();
				scholarQualification.setScholarQualificationId(resultSet.getInt("ScholarQualificationId"));
				scholarQualification.setScholarshipQualificationId(resultSet.getInt("ScholarshipQualificationId"));
				scholarQualification.setQualified(resultSet.getBoolean("Qualified"));
				scholarQualification.setNotes(resultSet.getString("Notes"));
				scholarQualification.setDateSubmitted(resultSet.getDate("DateSubmitted"));
				scholarQualification.setFilename(resultSet.getString("Filename"));
				scholarQualification.setScholarId(resultSet.getInt("ScholarId"));
				
				scholarQualificationList.add(scholarQualification);

			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getScholarshipProgramList method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}

		return scholarQualificationList;
	}
	
	public void insertScholarQualification(ScholarQualification scholarQualification) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();

			statement = connection.prepareStatement(
					"INSERT INTO scholarqualification(ScholarshipQualificationId, Qualified, Notes, DateSubmitted, Filename, ScholarId) VALUES (?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, scholarQualification.getScholarshipQualificationId());
			statement.setBoolean(2, scholarQualification.isQualified());
			statement.setString(3, scholarQualification.getNotes());
			statement.setDate(4, new Date(scholarQualification.getDateSubmitted().getTime()));
			statement.setString(5, scholarQualification.getFilename());
			statement.setInt(6, scholarQualification.getScholarId());

			statement.executeUpdate();

			resultSet = statement.getGeneratedKeys();

			if (resultSet.next()) {
				scholarQualification.setScholarQualificationId(resultSet.getInt(1));

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error occurred while doing insertScholarshipQualification method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
	}

	
	public void saveScholarQualification(ScholarQualification scholarQualification) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = getConnection();

			statement = connection.prepareStatement("UPDATE scholarqualification SET ScholarshipQualificationId=?, Qualified=?, Notes=?, DateSubmitted=?, Filename=?, ScholarId=? WHERE ScholarQualificationId=?");
			statement.setInt(1, scholarQualification.getScholarshipQualificationId());
			statement.setBoolean(2, scholarQualification.isQualified());
			statement.setString(3, scholarQualification.getNotes());
			statement.setDate(4, new Date(scholarQualification.getDateSubmitted().getTime()));
			statement.setString(5, scholarQualification.getFilename());
			statement.setInt(6, scholarQualification.getScholarId());
			statement.setInt(7, scholarQualification.getScholarQualificationId());
			
			statement.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Error occurred while doing saveScholarQualification method", e);
		} finally {
			ConnectionUtil.closeDbResources(statement);
		}
	}

}
