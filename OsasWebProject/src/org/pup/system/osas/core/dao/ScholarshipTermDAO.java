package org.pup.system.osas.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.pup.system.osas.core.domain.ScholarshipTerm;

public class ScholarshipTermDAO extends DAO {

	public ScholarshipTermDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	public ScholarshipTerm getScholarshipTermByScholarshipTermId(int scholarshipTermId) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ScholarshipTerm scholarshipTerm = null;

		try {
			connection = getConnection();

			statement = connection.createStatement();

			resultSet = statement.executeQuery(
					"SELECT ScholarshipTermId, ScholarshipTermName, StartDate, EndDate, Active FROM scholarshipterm WHERE ScholarshipTermId="
							+ scholarshipTermId);

			if (resultSet.next()) {
				scholarshipTerm = new ScholarshipTerm();
				scholarshipTerm.setScholarshipTermId(resultSet.getInt("ScholarshipTermId"));
				scholarshipTerm.setScholarshipTermName(resultSet.getString("ScholarshipTermName"));
				scholarshipTerm.setStartDate(resultSet.getString("StartDate"));
				scholarshipTerm.setEndDate(resultSet.getString("EndDate"));
				scholarshipTerm.setActive(resultSet.getBoolean("Active"));

			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getScholarshipTermByScholarshipTermId method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}

		return scholarshipTerm;
	}

	public void insertScholarshipTerm(ScholarshipTerm scholarshipTerm) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();

			statement = connection.prepareStatement(
					"INSERT INTO scholarshipterm(ScholarshipTermName, StartDate, EndDate, Active) VALUES (?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, scholarshipTerm.getScholarshipTermName());
			statement.setString(2, scholarshipTerm.getStartDate());
			statement.setString(3, scholarshipTerm.getEndDate());
			statement.setBoolean(4, scholarshipTerm.getActive());

			statement.executeUpdate();

			resultSet = statement.getGeneratedKeys();

			if (resultSet.next()) {
				scholarshipTerm.setScholarshipTermId(resultSet.getInt(1));

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error occurred while doing insertScholarshipTerm method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
	}

	public List<ScholarshipTerm> getScholarshipTermList() throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ScholarshipTerm scholarshipTerm = null;
		List<ScholarshipTerm> scholarshipTermList = null;

		try {
			connection = getConnection();

			statement = connection.createStatement();

			resultSet = statement.executeQuery(
					"SELECT ScholarshipTermId, ScholarshipTermName, StartDate, EndDate, Active FROM scholarshipterm");

			while (resultSet.next()) {
				if (scholarshipTermList == null) {
					scholarshipTermList = new ArrayList<ScholarshipTerm>();
				}
				scholarshipTerm = new ScholarshipTerm();
				scholarshipTerm.setScholarshipTermId(resultSet.getInt("ScholarshipTermId"));
				scholarshipTerm.setScholarshipTermName(resultSet.getString("ScholarshipTermName"));
				scholarshipTerm.setStartDate(resultSet.getString("StartDate"));
				scholarshipTerm.setEndDate(resultSet.getString("EndDate"));
				scholarshipTerm.setActive(resultSet.getBoolean("Active"));
				
				scholarshipTermList.add(scholarshipTerm);
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getScholarshipProgramList method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}

		return scholarshipTermList;
	}

	public List<ScholarshipTerm> getScholarshipTermListByScholarshipTermSearchText(String scholarshipTermSearchText) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ScholarshipTerm scholarshipTerm = null;
		List<ScholarshipTerm> scholarshipTermList = null;

		try {
			connection = getConnection();

			statement = connection.createStatement();

			resultSet = statement.executeQuery(
					"SELECT ScholarshipTermId, ScholarshipTermName, StartDate, EndDate, Active FROM scholarshipterm WHERE ScholarshipTermName LIKE '%"
							+ scholarshipTermSearchText + "%'");

			while (resultSet.next()) {
				if (scholarshipTermList == null) {
					scholarshipTermList = new ArrayList<ScholarshipTerm>();
				}

				scholarshipTerm = new ScholarshipTerm();
				scholarshipTerm.setScholarshipTermId(resultSet.getInt("ScholarshipTermId"));
				scholarshipTerm.setScholarshipTermName(resultSet.getString("ScholarshipTermName"));
				scholarshipTerm.setStartDate(resultSet.getString("StartDate"));
				scholarshipTerm.setEndDate(resultSet.getString("EndDate"));
				scholarshipTerm.setActive(resultSet.getBoolean("Active"));
				
				scholarshipTermList.add(scholarshipTerm);
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getScholarshipTermListByScholarshipTermSearchText method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}

		return scholarshipTermList;
	}

	public void saveScholarshipTerm(ScholarshipTerm scholarshipTerm) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = getConnection();

			statement = connection.prepareStatement(
					"UPDATE scholarshipterm SET ScholarshipTermName=?, StartDate=?, EndDate=?, Active=? WHERE ScholarshipTermId=?");
			statement.setString(1, scholarshipTerm.getScholarshipTermName());
			statement.setString(2, scholarshipTerm.getStartDate());
			statement.setString(3, scholarshipTerm.getEndDate());
			statement.setBoolean(4, scholarshipTerm.getActive());

			statement.setInt(5, scholarshipTerm.getScholarshipTermId());

			statement.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Error occurred while doing saveScholarshipTerm method", e);
		} finally {
			ConnectionUtil.closeDbResources(statement);
		}
	}

	public void deleteScholarshipTermByScholarshipTermId(int scholarshipTermId) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = getConnection();
			statement = connection.prepareStatement("DELETE FROM scholarshipterm WHERE ScholarshipTermId=?");
			statement.setInt(1, scholarshipTermId);

			statement.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Error occurred while doing deleteScholarshipProgramByScholarshipProgramId method", e);
		} finally {
			ConnectionUtil.closeDbResources(statement);
		}
	}

}
