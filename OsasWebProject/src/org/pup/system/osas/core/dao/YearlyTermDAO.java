package org.pup.system.osas.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.pup.system.osas.core.domain.YearlyTerm;

public class YearlyTermDAO extends DAO {

	public YearlyTermDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	
	public YearlyTerm getYearlyTermByYearlyTermId(int yearlyTermId) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		YearlyTerm yearlyTerm = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("SELECT YearlyTermId, YearlyTermName, Deadline, StartDate, EndDate, Active FROM yearlyterm WHERE yearlyTermId=" + yearlyTermId);  
			
			if (resultSet.next()) {
				yearlyTerm = new YearlyTerm();
				yearlyTerm.setYearlyTermId(resultSet.getInt("YearlyTermId"));
				yearlyTerm.setYearlyTermName(resultSet.getString("YearlyTermName"));
				yearlyTerm.setDeadline(resultSet.getString("Deadline"));
				yearlyTerm.setStartDate(resultSet.getString("StartDate"));
				yearlyTerm.setEndDate(resultSet.getString("EndDate"));
				yearlyTerm.setActive(resultSet.getBoolean("Active"));
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getYearlyTermByYearlyTermId method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
		
		return yearlyTerm;
	}
	
	public void insertYearlyTerm(YearlyTerm yearlyTerm) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();

			statement = connection.prepareStatement("INSERT INTO yearlyterm(YearlyTermName, Deadline, StartDate, EndDate, Active) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, yearlyTerm.getYearlyTermName());
			statement.setString(2, yearlyTerm.getDeadline());
			statement.setString(3, yearlyTerm.getStartDate());
			statement.setString(4, yearlyTerm.getEndDate());
			statement.setBoolean(5, yearlyTerm.isActive());
			
			statement.executeUpdate();
			
			resultSet = statement.getGeneratedKeys();
			
			if (resultSet.next()) {
				yearlyTerm.setYearlyTermId(resultSet.getInt(1));

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error occurred while doing insertSemTerm method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
	}
	
	public void setInactiveYearlyTerm(YearlyTerm yearlyTerm) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = getConnection();

			statement = connection.prepareStatement("UPDATE yearlyterm set Active = false where YearlyTermId=?");
			statement.setInt(1, yearlyTerm.getYearlyTermId());
			
			statement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error occurred while doing setInactiveYearlyTerm method", e);
		} finally {
			ConnectionUtil.closeDbResources(statement);
		}
	}

	public List<YearlyTerm> getYearlyTermList() throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		YearlyTerm yearlyTerm = null;
		List<YearlyTerm> yearlyTermList = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("SELECT YearlyTermId, YearlyTermName, Deadline, StartDate, EndDate FROM yearlyTerm");  
			
			while (resultSet.next()) {
				if (yearlyTermList == null) {
					yearlyTermList = new ArrayList<YearlyTerm>();
				}
				
				yearlyTerm = new YearlyTerm();
				yearlyTerm.setYearlyTermId(resultSet.getInt("YearlyTermId"));
				yearlyTerm.setYearlyTermName(resultSet.getString("YearlyTermName"));
				yearlyTerm.setDeadline(resultSet.getString("Deadline"));
				yearlyTerm.setEndDate(resultSet.getString("EndDate"));
				
				yearlyTermList.add(yearlyTerm);
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getYearlyTermList method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
		
		return yearlyTermList;
	}

}
