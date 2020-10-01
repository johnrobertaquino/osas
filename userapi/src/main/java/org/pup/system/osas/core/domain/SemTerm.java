package org.pup.system.osas.core.domain;

import java.util.Date;

public class SemTerm {

	private int semTermId;

	private String semTermName;

	private Date deadline;

	private Date startDate;

	private Date endDate;

	private int yearlyTermId;

	private boolean active;

	public int getSemTermId() {
		return semTermId;
	}

	public void setSemTermId(int semTermId) {
		this.semTermId = semTermId;
	}

	public String getSemTermName() {
		return semTermName;
	}

	public void setSemTermName(String semTermName) {
		this.semTermName = semTermName;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
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

	public int getYearlyTermId() {
		return yearlyTermId;
	}

	public void setYearlyTermId(int yearlyTermId) {
		this.yearlyTermId = yearlyTermId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}	
