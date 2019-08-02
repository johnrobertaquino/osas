package org.pup.system.osas.ui.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.pup.system.osas.core.domain.User;
import org.pup.system.osas.core.domain.UserRole;
import org.pup.system.osas.core.domain.UserRoleReference;
import org.pup.system.osas.core.manager.UserManager;
import org.pup.system.osas.exception.BusinessException;

public class EditUserAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1719224812724606894L;
	
	private String userId;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private String birthday;
	
	private String contactNumber;
	
	private String position;
	
	private List<String> roleReferenceCodeList;

	@Override
	public String execute() throws Exception {
		pageName = "Manage User Account";

		String actionResult = FORWARD_SUCCESS;

		try {
			UserManager userManager = new UserManager();
			User user = userManager.getUser(Integer.parseInt(userId));
			
			user.setFirstName(firstName);
			user.setMiddleName(middleName);
			user.setLastName(lastName);
			user.setBirthday(new SimpleDateFormat("MM/dd/yyyy").parse(birthday));
			user.setContactNumber(contactNumber);
			user.setPosition(position);
			
			user.setUserRoleList(new ArrayList<UserRole>());
			if(roleReferenceCodeList != null) {
				for (String roleReferenceCode : roleReferenceCodeList) {
					UserRole userRole = new UserRole();
					userRole.setUserId(user.getUserId());
					userRole.setUserRoleReference(new UserRoleReference());
					userRole.getUserRoleReference().setUserRoleReferenceCode(roleReferenceCode);
					
					user.getUserRoleList().add(userRole);
				}
			}

			userManager.saveUser(user);
			
			notificationMessage = "Changes to user has been saved successfully.";
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public List<String> getRoleReferenceCodeList() {
		return roleReferenceCodeList;
	}

	public void setRoleReferenceCodeList(List<String> roleReferenceCodeList) {
		this.roleReferenceCodeList = roleReferenceCodeList;
	}
	

}
