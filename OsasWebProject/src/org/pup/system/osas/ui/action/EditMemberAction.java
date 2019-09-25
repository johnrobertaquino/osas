package org.pup.system.osas.ui.action;


import org.pup.system.osas.core.domain.Member;
import org.pup.system.osas.core.domain.Program;
import org.pup.system.osas.core.manager.MemberManager;
import org.pup.system.osas.exception.BusinessException;

public class EditMemberAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1719224812724606894L;
	
	private int memberId;
	
	private String studentNumber;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private String program;
	
	private String position;

	private boolean officer;
	
	private String officerPhoto;
	
	private String gender;
	
	private String year;
	
	private String section;
	
	private String contactNumber;
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage Organization Member";
		String actionResult = FORWARD_SUCCESS;

		try {
			MemberManager memberManager = new MemberManager();
			Member member = memberManager.getMember(memberId);
			
			member.setMemberId(memberId);
			member.setStudentNumber(studentNumber);
			member.setFirstName(firstName);
			member.setMiddleName(middleName);
			member.setLastName(lastName);
			member.setPosition(position);
			member.setOfficer(officer);
			member.setOfficerPhoto(officerPhoto);
			member.setGender(gender);
			member.setProgram(new Program(program));
			member.setYear(year);
			member.setSection(section);
			member.setContactNumber(contactNumber);
			
			memberManager.saveMember(member);
			
			notificationMessage = "Changes to member has been saved successfully.";
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
	 * @return the memberId
	 */
	public int getMemberId() {
		return memberId;
	}

	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * @return the officer
	 */
	public boolean getOfficer() {
		return officer;
	}

	/**
	 * @param officer the officer to set
	 */
	public void setOfficer(boolean officer) {
		this.officer = officer;
	}

	/**
	 * @return the officerPhoto
	 */
	public String getOfficerPhoto() {
		return officerPhoto;
	}

	/**
	 * @param officerPhoto the officerPhoto to set
	 */
	public void setOfficerPhoto(String officerPhoto) {
		this.officerPhoto = officerPhoto;
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
	
	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

}
