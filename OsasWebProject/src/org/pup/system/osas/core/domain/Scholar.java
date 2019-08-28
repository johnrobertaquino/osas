package org.pup.system.osas.core.domain;

public class Scholar {
	
	private int scholarId;
	
	private String studentNumber;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private String email;
	
	private String contactNumber;
	
	private String program;
	
	private String year;
	
	private String section;
	
	private String gwa;
	
	private ScholarshipProgram scholarshipProgram;

	public int getScholarId() {
		return scholarId;
	}

	public void setScholarId(int scholarId) {
		this.scholarId = scholarId;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the contactNumber
	 */
	public String getContactNumber() {
		return contactNumber;
	}

	/**
	 * @param contactNumber the contactNumber to set
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * @return the scholarshipProgram
	 */
	public ScholarshipProgram getScholarshipProgram() {
		return scholarshipProgram;
	}

	/**
	 * @param scholarshipProgram the scholarshipProgram to set
	 */
	public void setScholarshipProgram(ScholarshipProgram scholarshipProgram) {
		this.scholarshipProgram = scholarshipProgram;
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
	public String getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
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
	public String getGwa() {
		return gwa;
	}

	/**
	 * @param gwa the gwa to set
	 */
	public void setGwa(String gwa) {
		this.gwa = gwa;
	}
}