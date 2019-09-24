package org.pup.system.osas.core.domain;

public class ScholarQualification {
	
	private int scholarQualificationId;
	
	private int scholarshipQualificationId;
	
	private boolean qualified;
	
	private String notes;
	
	private String filename;
	
	private int scholarId;

	public int getScholarQualificationId() {
		return scholarQualificationId;
	}

	public void setScholarQualificationId(int scholarQualificationId) {
		this.scholarQualificationId = scholarQualificationId;
	}

	public int getScholarshipQualificationId() {
		return scholarshipQualificationId;
	}

	public void setScholarshipQualificationId(int scholarshipQualificationId) {
		this.scholarshipQualificationId = scholarshipQualificationId;
	}

	public boolean isQualified() {
		return qualified;
	}

	public void setQualified(boolean qualified) {
		this.qualified = qualified;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getScholarId() {
		return scholarId;
	}

	public void setScholarId(int scholarId) {
		this.scholarId = scholarId;
	}
	
}
