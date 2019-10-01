package org.pup.system.osas.ui.action;


import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.pup.system.osas.core.domain.Member;
import org.pup.system.osas.core.domain.Program;
import org.pup.system.osas.core.manager.MemberManager;
import org.pup.system.osas.exception.BusinessException;

public class EditMemberAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1719224812724606894L;
	
	private static final String FORWARD_DISPLAYEDITMEMBER = "displayEditMember";
	
	private int memberId;
	
	private String studentNumber;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private String program;
	
	private String position;

	private String officer;
	
	private String officerPhotoContentType;

	private String officerPhotoFileName;
	
	private File officerPhoto;
	
	private String gender;
	
	private String year;
	
	private String section;
	
	private String contactNumber;
	
	private int organizationId;
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage Organization Member";
		String actionResult = FORWARD_SUCCESS;
		
		File fileToCreate = null;
		
		try {
			MemberManager memberManager = new MemberManager();
			Member member = memberManager.getMember(memberId);
			
			Member existingMember = null;
			existingMember = memberManager.validate(studentNumber, firstName, middleName, lastName, organizationId, getCurrentActiveTerm().getSemTermId());			
			if (existingMember != null) {
				notificationMessage = "Member already exist.";
				return FORWARD_DISPLAYEDITMEMBER;
			}
			
			else
			{
				member.setMemberId(memberId);
				member.setStudentNumber(studentNumber);
				member.setFirstName(firstName);
				member.setMiddleName(middleName);
				member.setLastName(lastName);
				if ("on".equalsIgnoreCase(officer)) {
					member.setPosition(position);
				} else {
					member.setPosition(null);
				}
				member.setOfficer("on".equalsIgnoreCase(officer));
				
				if(!StringUtils.isEmpty(officerPhotoFileName) && "on".equalsIgnoreCase(officer)) {
					member.setOfficerPhoto(officerPhotoFileName);
					
					String filePath = "C:/OSAS/Organization/Member";
					fileToCreate = new File(filePath, officerPhotoFileName);
					
					FileUtils.copyFile(officerPhoto, fileToCreate);
				}
				
				member.setGender(gender);
				member.setProgram(new Program(program));
				member.setYear(year);
				member.setSection(section);
				member.setContactNumber(contactNumber);
				
				memberManager.saveMember(member);
				
				notificationMessage = "Changes to member has been saved successfully.";
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
	public String getOfficer() {
		return officer;
	}

	/**
	 * @param officer the officer to set
	 */
	public void setOfficer(String officer) {
		this.officer = officer;
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
	
	public String getOfficerPhotoFileName() {
		return officerPhotoFileName;
	}


	public void setOfficerPhotoFileName(String officerPhotoFileName) {
		this.officerPhotoFileName = officerPhotoFileName;
	}


	public File getOfficerPhoto() {
		return officerPhoto;
	}


	public void setOfficerPhoto(File officerPhoto) {
		this.officerPhoto = officerPhoto;
	}


	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}


	/**
	 * @return the officerPhotoContentType
	 */
	public String getOfficerPhotoContentType() {
		return officerPhotoContentType;
	}


	/**
	 * @param officerPhotoContentType the officerPhotoContentType to set
	 */
	public void setOfficerPhotoContentType(String officerPhotoContentType) {
		this.officerPhotoContentType = officerPhotoContentType;
	}

}
