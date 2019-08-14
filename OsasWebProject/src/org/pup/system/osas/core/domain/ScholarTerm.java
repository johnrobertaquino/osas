package org.pup.system.osas.core.domain;

public class ScholarTerm {

	private int scholarTermId;

	private ScholarshipTerm scholarshipTerm;

	private Scholar scholar;

	private String program;

	private String year;

	private String section;

	private String gwa;

	public int getScholarTermId() {
		return scholarTermId;
	}

	public void setScholarTermId(int scholarTermId) {
		this.scholarTermId = scholarTermId;
	}

	public ScholarshipTerm getScholarshipTerm() {
		return scholarshipTerm;
	}

	public void setScholarshipTerm(ScholarshipTerm scholarshipTerm) {
		this.scholarshipTerm = scholarshipTerm;
	}

	public Scholar getScholar() {
		return scholar;
	}

	public void setScholar(Scholar scholar) {
		this.scholar = scholar;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getGwa() {
		return gwa;
	}

	public void setGwa(String gwa) {
		this.gwa = gwa;
	}

}
