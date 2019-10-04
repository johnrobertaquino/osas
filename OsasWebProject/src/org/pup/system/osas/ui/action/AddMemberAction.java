package org.pup.system.osas.ui.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.pup.system.osas.core.domain.Member;
import org.pup.system.osas.core.domain.Organization;
import org.pup.system.osas.core.domain.Program;
import org.pup.system.osas.core.manager.MemberManager;
import org.pup.system.osas.core.manager.OrganizationManager;
import org.pup.system.osas.exception.BusinessException;

public class AddMemberAction extends AbstractAction {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4484162865895061330L;

	private static final String FORWARD_DISPLAYADDMEMBER = "displayAddMember";
	
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
	
	private List<Integer> organizationIdList;
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage Organization Member";
		
		String actionResult = FORWARD_SUCCESS;
		File fileToCreate = null;
		
		try {

			
			MemberManager memberManager = new MemberManager();
			OrganizationManager organizationManager = new OrganizationManager();

			Member existingMember = null;

			existingMember = memberManager.getMemberByStudentNumber(studentNumber, getCurrentActiveTerm().getSemTermId());			

			if (existingMember != null) {
				notificationMessage = "Member already exist.";
				return FORWARD_DISPLAYADDMEMBER;
			}
			else
			{
				Member member = new Member();
				member.setStudentNumber(studentNumber);
				member.setFirstName(firstName);
				member.setMiddleName(middleName);
				member.setLastName(lastName);
				member.setProgram(new Program(program));
				if ("on".equalsIgnoreCase(officer)) {
					member.setPosition(position);
				}
				member.setOfficer("on".equalsIgnoreCase(officer));
				
				if(!StringUtils.isEmpty(officerPhotoFileName) && "on".equalsIgnoreCase(officer)) {
					member.setOfficerPhoto(officerPhotoFileName);
					
					String filePath = "C:/OSAS/Organization/Member";
					fileToCreate = new File(filePath, officerPhotoFileName);
					
					FileUtils.copyFile(officerPhoto, fileToCreate);
				}
				member.setGender(gender);
				member.setYear(year);
				member.setSection(section);
				member.setContactNumber(contactNumber);

				int acadCtr = 0;
				
				if(organizationIdList != null) {
					member.setOrganizationList(new ArrayList<Organization>());
					for (Integer organizationId : organizationIdList) {
						Organization organization = organizationManager.getOrganization(organizationId);
						if("A".equals(organization.getOrganizationType().getOrganizationTypeCode())) {
							acadCtr++;
						}
						
						if(acadCtr > 1) {
							throw new BusinessException("You cannot select more than 1 Academic Organization.");
						}
						
						member.getOrganizationList().add(organization);
					}
					
					memberManager.insertMember(member);
					
					notificationMessage = "Member has been successfully added.";
				} else {
					errorMessage = "Please select atleast 1 organization.";
					actionResult = FORWARD_ERROR;
				}
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

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
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
		return middleName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getOfficer() {
		return officer;
	}

	public void setOfficer(String officer) {
		this.officer = officer;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public List<Integer> getOrganizationIdList() {
		return organizationIdList;
	}

	public void setOrganizationIdList(List<Integer> organizationIdList) {
		this.organizationIdList = organizationIdList;
	}

	/**
	 * @return the officerPhoto
	 */
	public File getOfficerPhoto() {
		return officerPhoto;
	}

	/**
	 * @param officerPhoto the officerPhoto to set
	 */
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

	public String getOfficerPhotoFileName() {
		return officerPhotoFileName;
	}

	public void setOfficerPhotoFileName(String officerPhotoFileName) {
		this.officerPhotoFileName = officerPhotoFileName;
	}
	
	
}
