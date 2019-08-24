package org.pup.system.osas.core.domain;

public class YearlyTerm {
	
	private int yearlyTermId;
	
	private String yearlyTermName;
	
	private String deadline;
	
	private String startDate;
	
	private String endDate;

	private boolean active;

	/**
	 * @return the deadline
	 */
	public int getYearlyTermId() {
		return yearlyTermId;
	}

	/**
	 * @param deadline the deadline to set
	 */
	public void setYearlyTermId(int yearlyTermId) {
		this.yearlyTermId = yearlyTermId;
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

	/**
	 * @return the yearlyTermName
	 */
	public String getYearlyTermName() {
		return yearlyTermName;
	}

	/**
	 * @param yearlyTermName the yearlyTermName to set
	 */
	public void setYearlyTermName(String yearlyTermName) {
		this.yearlyTermName = yearlyTermName;
	}
}
