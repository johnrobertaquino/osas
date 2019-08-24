package org.pup.system.osas.core.domain;

public class ScholarshipTerm {

	private int scholarshipTermId;
	
	private String scholarshipTermName;
	
	private String startDate;
	
	private String endDate;
	
	private Boolean active;

	/**
	 * @return the scholarshipTermId
	 */
	public int getScholarshipTermId() {
		return scholarshipTermId;
	}

	/**
	 * @param scholarshipTermId the scholarshipTermId to set
	 */
	public void setScholarshipTermId(int scholarshipTermId) {
		this.scholarshipTermId = scholarshipTermId;
	}

	/**
	 * @return the scholarshipTermName
	 */
	public String getScholarshipTermName() {
		return scholarshipTermName;
	}

	/**
	 * @param scholarshipTermName the scholarshipTermName to set
	 */
	public void setScholarshipTermName(String scholarshipTermName) {
		this.scholarshipTermName = scholarshipTermName;
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
	public Boolean getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

}
