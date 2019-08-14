package org.pup.system.osas.core.domain;

import java.util.Date;

public class ScholarshipTerm {
	
	private int scholarshipTermId;
	
	private String scholarshipTermName;
	
	private Date startDate;
	
	private Date endDate;
	
	private boolean active;
	
	public ScholarshipTerm() {
		
	}
	
	public ScholarshipTerm(int scholarshipTermId) {
		this.scholarshipTermId = scholarshipTermId;
	}

	public int getScholarshipTermId() {
		return scholarshipTermId;
	}

	public void setScholarshipTermId(int scholarshipTermId) {
		this.scholarshipTermId = scholarshipTermId;
	}

	public String getScholarshipTermName() {
		return scholarshipTermName;
	}

	public void setScholarshipTermName(String scholarshipTermName) {
		this.scholarshipTermName = scholarshipTermName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
