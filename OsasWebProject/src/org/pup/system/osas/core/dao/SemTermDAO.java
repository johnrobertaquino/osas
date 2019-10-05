	package org.pup.system.osas.core.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.pup.system.osas.core.domain.SemTerm;

public class SemTermDAO extends DAO {

	public SemTermDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	
	public SemTerm getSemTermBySemTermId(int semTermId) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		SemTerm semTerm = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("SELECT SemTermId, SemTermName, Deadline, StartDate, EndDate, Active, YearlyTermId FROM semterm WHERE SemTermId=" + semTermId);  
			
			if (resultSet.next()) {
				semTerm = new SemTerm();
				semTerm.setSemTermId(resultSet.getInt("SemTermId"));
				semTerm.setSemTermName(resultSet.getString("SemTermName"));
				semTerm.setDeadline(resultSet.getDate("Deadline"));
				semTerm.setStartDate(resultSet.getDate("StartDate"));
				semTerm.setEndDate(resultSet.getDate("EndDate"));
				semTerm.setActive(resultSet.getBoolean("Active"));	
				semTerm.setYearlyTermId(resultSet.getInt("YearlyTermId"));
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getSemTermBySemTermId method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
		
		return semTerm;
	}
	
	public SemTerm getSemTermByActive(boolean active) throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		SemTerm semTerm = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("SELECT SemTermId, SemTermName, Deadline, StartDate, EndDate, Active, YearlyTermId FROM semterm WHERE Active=" + active);  
			
			if (resultSet.next()) {
				semTerm = new SemTerm();
				semTerm.setSemTermId(resultSet.getInt("SemTermId"));
				semTerm.setSemTermName(resultSet.getString("SemTermName"));
				semTerm.setDeadline(resultSet.getDate("Deadline"));
				semTerm.setStartDate(resultSet.getDate("StartDate"));
				semTerm.setEndDate(resultSet.getDate("EndDate"));
				semTerm.setActive(resultSet.getBoolean("Active"));	
				semTerm.setYearlyTermId(resultSet.getInt("YearlyTermId"));
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getSemTermByActive method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
		
		return semTerm;
	}
	
	public void insertSemTerm(SemTerm semTerm) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();

			statement = connection.prepareStatement("INSERT INTO semterm(SemTermName, Deadline, StartDate, EndDate, Active, YearlyTermId) VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, semTerm.getSemTermName());
			statement.setDate(2, new Date(semTerm.getDeadline().getTime()));
			statement.setDate(3, new Date(semTerm.getStartDate().getTime()));
			statement.setDate(4, new Date(semTerm.getEndDate().getTime()));
			statement.setBoolean(5, semTerm.isActive());
			statement.setInt(6, semTerm.getYearlyTermId());
			
			statement.executeUpdate();
			
			resultSet = statement.getGeneratedKeys();
			
			if (resultSet.next()) {
				semTerm.setSemTermId(resultSet.getInt(1));

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error occurred while doing insertSemTerm method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
	}
	
	public void setToInactive(SemTerm semTerm) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = getConnection();

			statement = connection.prepareStatement("UPDATE semterm set Active = false WHERE SemTermId = ?");
			statement.setInt(1, semTerm.getSemTermId());
			
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error occurred while doing setToInactive method", e);
		} finally {
			ConnectionUtil.closeDbResources(statement);
		}
	}

	public List<SemTerm> getSemTermList() throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		SemTerm semTerm = null;
		List<SemTerm> semTermList = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("SELECT SemTermId, SemTermName, Deadline, StartDate, EndDate, Active, YearlyTermId FROM semterm");  
			
			while (resultSet.next()) {
				if (semTermList == null) {
					semTermList = new ArrayList<SemTerm>();
				}
				
				semTerm = new SemTerm();
				semTerm.setSemTermId(resultSet.getInt("SemTermId"));
				semTerm.setSemTermName(resultSet.getString("SemTermName"));
				semTerm.setDeadline(resultSet.getDate("Deadline"));
				semTerm.setStartDate(resultSet.getDate("StartDate"));
				semTerm.setEndDate(resultSet.getDate("EndDate"));
				semTerm.setActive(resultSet.getBoolean("Active"));
				semTerm.setYearlyTermId(resultSet.getInt("YearlyTermId"));
				
				semTermList.add(semTerm);
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getSemTermList method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
		
		return semTermList;
	}

}