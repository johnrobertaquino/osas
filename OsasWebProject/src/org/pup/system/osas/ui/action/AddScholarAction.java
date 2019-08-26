package org.pup.system.osas.ui.action;

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

	private String scholarId;
	
	private String studentNumber;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private String email;
	
	private String contactNumber;
	
	private String program;
	
	private int year;
	
	private String section;
	
	private float gwa;
	
	private String scholarshipProgramId;
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholar";
		
		String actionResult = FORWARD_SUCCESS;
		
		try {
			ScholarshipProgramManager scholarshipProgramManager = new ScholarshipProgramManager();
			ScholarshipProgram scholarshipProgram = scholarshipProgramManager.getScholarshipProgram(Integer.parseInt(scholarshipProgramId));
			
			Scholar scholar = new Scholar();
			scholar.setStudentNumber(studentNumber);
			scholar.setFirstName(firstName);
			scholar.setMiddleName(middleName);
			scholar.setLastName(lastName);
			scholar.setEmail(email);
			scholar.setContactNumber(contactNumber);
			scholar.setProgram(program);
			scholar.setYear(year);
			scholar.setSection(section);
			scholar.setScholarshipProgram(scholarshipProgram);
			
			ScholarManager scholarManager = new ScholarManager();
			scholarManager.insertScholar(scholar);
			
			notificationMessage = "Scholar has been saved successfully added.";
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

	public String getScholarId() {
		return scholarId;
	}

	public void setScholarId(String scholarId) 
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
	
	public String getScholarshipProgramId() {
		return scholarId;
	}

	public void setScholarshipProgramId(String scholarshipProgramId) 
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
