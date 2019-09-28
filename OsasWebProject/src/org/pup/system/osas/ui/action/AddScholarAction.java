package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.Program;
import org.pup.system.osas.core.domain.Scholar;
import org.pup.system.osas.core.domain.ScholarshipProgram;
import org.pup.system.osas.core.manager.ScholarManager;
import org.pup.system.osas.core.manager.ScholarshipProgramManager;
import org.pup.system.osas.exception.BusinessException;

public class AddScholarAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8910283248066116810L;

	private static final String FORWARD_DISPLAYADDSCHOLAR = "displayAddScholar";
	
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
	
	private String gwa;
	
	private int scholarshipProgramId;
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholar";
		
		String actionResult = FORWARD_SUCCESS;
		
		try {
			ScholarshipProgramManager scholarshipProgramManager = new ScholarshipProgramManager();
			ScholarshipProgram scholarshipProgram = scholarshipProgramManager.getScholarshipProgram(scholarshipProgramId);
			
			
			ScholarManager scholarManager = new ScholarManager();
			
			Scholar existingScholar = null;
			existingScholar = scholarManager.getValidateScholar(studentNumber, firstName, lastName, scholarshipProgramId);
			
			
			if (existingScholar != null && scholarId != existingScholar.getScholarId()) {
				notificationMessage = "Scholar already exist.";
				return FORWARD_DISPLAYADDSCHOLAR;
			}
			else
			{
				Scholar scholar = new Scholar();
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
				scholar.setScholarshipProgram(scholarshipProgram);
				
				scholarManager.insertScholar(scholar);
				
				notificationMessage = "Scholar has been successfully added.";
			}
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

	public void setScholarId(int scholarId) 
	{
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

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public int getScholarshipProgramId() {
		return scholarshipProgramId;
	}

	public void setScholarshipProgramId(int scholarshipProgramId) 
	{
		this.scholarshipProgramId = scholarshipProgramId;
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
