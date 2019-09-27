package org.pup.system.osas.ui.action;


import org.pup.system.osas.core.domain.Program;
import org.pup.system.osas.core.domain.Scholar;
import org.pup.system.osas.core.domain.ScholarshipProgram;
import org.pup.system.osas.core.manager.ScholarManager;
import org.pup.system.osas.exception.BusinessException;

public class EditScholarAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1719224812724606894L;
	
	private int scholarId;
	
	private String studentNumber;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private String gender;
	
	private String email;
	
	private String contactNumber;
	
	private String program;
	
	private String year;
	
	private String section;
	
	private ScholarshipProgram scholarshipProgram;
	
	private String gwa;
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholar";
		String actionResult = FORWARD_SUCCESS;

		try {
			ScholarManager scholarManager = new ScholarManager();
			Scholar scholar = scholarManager.getScholar(scholarId);
			
			scholar.setScholarId(scholarId);
			scholar.setStudentNumber(studentNumber);
			scholar.setFirstName(firstName);
			scholar.setMiddleName(middleName);
			scholar.setLastName(lastName);
			scholar.setGender(gender);
			scholar.setEmail(email);
			scholar.setContactNumber(contactNumber);
			scholar.setProgram(new Program(program));
			scholar.setYear(year);
			scholar.setSection(section);
			scholar.setGwa(gwa);
			
			scholarManager.saveScholar(scholar);
			
			notificationMessage = "Changes to scholar has been saved successfully.";
		} catch (BusinessException be) {
			errorMessage = be.getMessage();
			actionResult = FORWARD_ERROR;
			be.printStackTrace();
		} catch (Exception e) {
			errorMessage = "System error occurred. Please contact administrator.";
			actionResult = FORWARD_ERROR;
			e.printStackTrace();
		}
		
		return actionResult;
	}

	
	
	public int getScholarId() {
		return scholarId;
	}
	/**
	 * @param studentNumber the studentNumber to set
	 */
	public void setScholarId(int scholarId) {
		this.scholarId = scholarId;
	}
	
	public String getStudentNumber() {
		return studentNumber;
	}
	
	

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the address
	 */
	public String getMiddlename() {
		return middleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	

	/**
	 * @param firstName the firstName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the address
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @return the address
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the contactPerson
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



	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}



	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

}
