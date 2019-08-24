package org.pup.system.osas.core.domain;


public class ScholarTerm {

	private int scholarTermId;
	
	private int scholarshipTermId;
	
	private int scholarId;
	
	private String program;
	
	private int year;
	
	private String section;
	
	private float gwa;

	/**
	 * @return the scholarTermId
	 */
	public int getScholarTermId() {
		return scholarTermId;
	}

	/**
	 * @param scholarTermId the scholarTermId to set
	 */
	public void setScholarTermId(int scholarTermId) {
		this.scholarTermId = scholarTermId;
	}

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
	 * @return the scholarId
	 */
	public int getScholarId() {
		return scholarId;
	}

	/**
	 * @param scholarId the scholarId to set
	 */
	public void setScholarId(int scholarId) {
		this.scholarId = scholarId;
	}

	/**
	 * @return the program
	 */
	public String getProgram() {
		return program;
	}

	/**
	 * @param program the program to set
	 */
	public void setProgram(String program) {
		this.program = program;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the section
	 */
	public String getSection() {
		return section;
	}

	/**
	 * @param section the section to set
	 */
	public void setSection(String section) {
		this.section = section;
	}

	/**
	 * @return the gwa
	 */
	public float getGwa() {
		return gwa;
	}

	/**
	 * @param gwa the gwa to set
	 */
	public void setGwa(float gwa) {
		this.gwa = gwa;
	}
}
