package org.pup.system.osas.ui.action;


import org.pup.system.osas.core.domain.Scholar;
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
	
	private String email;
	
	private String contactNumber;
	
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
			scholar.setEmail(email);
			scholar.setContactNumber(contactNumber);
			
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
	public String getmiddleName() {
		return middleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	/**
	 * @return the address
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setLaststName(String lastName) {
		this.lastName = lastName;
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

}
