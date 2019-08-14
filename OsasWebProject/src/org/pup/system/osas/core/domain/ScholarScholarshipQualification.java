package org.pup.system.osas.core.domain;

public class ScholarScholarshipQualification {

	private int scholarScholarshipQualificationId;

	private int scholarScholarshipProgramTermId;

	private ScholarshipQualification scholarshipQualification;

	private boolean qualied;

	private String notes;

	private String filename;

	public int getScholarScholarshipQualificationId() {
		return scholarScholarshipQualificationId;
	}

	public void setScholarScholarshipQualificationId(int scholarScholarshipQualificationId) {
		this.scholarScholarshipQualificationId = scholarScholarshipQualificationId;
	}

	public int getScholarScholarshipProgramTermId() {
		return scholarScholarshipProgramTermId;
	}

	public void setScholarScholarshipProgramTermId(int scholarScholarshipProgramTermId) {
		this.scholarScholarshipProgramTermId = scholarScholarshipProgramTermId;
	}

	public ScholarshipQualification getScholarshipQualification() {
		return scholarshipQualification;
	}

	public void setScholarshipQualification(ScholarshipQualification scholarshipQualification) {
		this.scholarshipQualification = scholarshipQualification;
	}

	public boolean isQualied() {
		return qualied;
	}

	public void setQualied(boolean qualied) {
		this.qualied = qualied;
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
}
