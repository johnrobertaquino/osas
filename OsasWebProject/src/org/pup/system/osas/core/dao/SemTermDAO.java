package org.pup.system.osas.core.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.pup.system.osas.core.domain.Agency;
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
			
			resultSet = statement.executeQuery("SELECT SemTermId, SemTermName, Deadline, StartDate, EndDate, Active FROM semterm WHERE SemTermId=" + semTermId);  
			
			if (resultSet.next()) {
				semTerm = new SemTerm();
				semTerm.setSemTermId(resultSet.getInt("SemTermId"));
				semTerm.setSemTermName(resultSet.getString("SemTermName"));
				semTerm.setDeadline(resultSet.getString("Deadline"));
				semTerm.setStartDate(resultSet.getString("StartDate"));
				semTerm.setEndDate(resultSet.getString("EndDate"));
				semTerm.setSemTermId(resultSet.getInt("Active"));
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getSemTermBySemTermId method", e);
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

			statement = connection.prepareStatement("INSERT INTO semterm(SemTermName, Deadline, StartDate, EndDate, Active) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, semTerm.getSemTermName());
			statement.setString(2, semTerm.getDeadline());
			statement.setString(3, semTerm.getStartDate());
			statement.setString(4, semTerm.getEndDate());
			
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

	public List<SemTerm> getSemTermList() throws Exception {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		SemTerm semTerm = null;
		List<SemTerm> semTermList = null;
		
		try {
			connection = getConnection();
			
			statement = connection.createStatement(); 
			
			resultSet = statement.executeQuery("SELECT SemTermId, SemTermName, Deadline, StartDate, EndDate, SemTermId FROM semterm WHERE SemTermId=1");  
			
			while (resultSet.next()) {
				if (semTermList == null) {
					semTermList = new ArrayList<SemTerm>();
				}
				
				semTerm = new SemTerm();
				semTerm.setSemTermId(resultSet.getInt("SemTermId"));
				semTerm.setSemTermName(resultSet.getString("SemTermName"));
				semTerm.setDeadline(resultSet.getString("Deadline"));
				semTerm.setEndDate(resultSet.getString("EndDate"));
				semTerm.setSemTermId(resultSet.getInt("SemTermId"));
				
				semTermList.add(semTerm);
			}
		} catch (Exception e) {
			throw new Exception("Error occurred while doing getAgencyList method", e);
		} finally {
			ConnectionUtil.closeDbResources(resultSet, statement);
		}
		
		return semTermList;
	}

}
