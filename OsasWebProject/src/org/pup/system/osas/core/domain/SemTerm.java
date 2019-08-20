package org.pup.system.osas.core.domain;

public class SemTerm {
	
	private int semTermId;
	
	private String semTermName;
	
	private String deadline;
	
	private String startDate;
	
	private String endDate;
	
	private String yearlyTermId;

	private boolean active;

	/**
	 * @return the semTermId
	 */
	public int getSemTermId() {
		return semTermId;
	}

	/**
	 * @param semTermId the semTermId to set
	 */
	public void setSemTermId(int semTermId) {
		this.semTermId = semTermId;
	}

	/**
	 * @return the semTermName
	 */
	public String getSemTermName() {
		return semTermName;
	}

	/**
	 * @param semTermName the semTermName to set
	 */
	public void setSemTermName(String semTermName) {
		this.semTermName = semTermName;
	}

	/**
	 * @return the deadline
	 */
	public String getDeadline() {
		return deadline;
	}

	/**
	 * @param deadline the deadline to set
	 */
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the yearlyTermId
	 */
	public String getYearlyTermId() {
		return yearlyTermId;
	}

	/**
	 * @param yearlyTermId the yearlyTermId to set
	 */
	public void setYearlyTermId(String yearlyTermId) {
		this.yearlyTermId = yearlyTermId;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
}
