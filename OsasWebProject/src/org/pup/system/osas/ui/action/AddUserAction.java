package org.pup.system.osas.ui.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.pup.system.osas.core.domain.User;
import org.pup.system.osas.core.domain.UserRole;
import org.pup.system.osas.core.domain.UserRoleReference;
import org.pup.system.osas.core.manager.UserManager;
import org.pup.system.osas.exception.BusinessException;

public class AddUserAction extends AbstractAction{
	
	/**
	 ** 
	 */
	private static final long serialVersionUID = 2407562318288998481L;
	
	private static final String FORWARD_DISPLAYADDUSERACTION = "displayAddUser";
	
	private int userId;
	
	private String userName;
	
	private String password;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private String birthday;
	
	private String contactNumber;
	
	private String position;
	
	private List<String> roleReferenceCodeList;
	
	public String execute() throws Exception {
		pageName = "Manage User Account";

		String actionResult = FORWARD_SUCCESS;

		try {
			User existingUser = new User();
			UserManager userManager = new UserManager();
			existingUser = userManager.checkFullName(firstName, middleName, lastName);
			
			if(existingUser != null)
			{
				notificationMessage = "User already exist.";
				return FORWARD_DISPLAYADDUSERACTION;
			}
			else
			{
				User user = new User();
				user.setFirstName(firstName);
				user.setMiddleName(middleName);
				user.setLastName(lastName);
				user.setBirthday(new SimpleDateFormat("MM/dd/yyyy").parse(birthday));
				password = (new SimpleDateFormat("MMddyyyy")).format(user.getBirthday());
				user.setPassword(password);
				userName = lastName.substring(0, 2).toUpperCase() + firstName.substring(0, 3).toLowerCase() + (new SimpleDateFormat("MM")).format(user.getBirthday()) + (new SimpleDateFormat("yy")).format(user.getBirthday());
				user.setUserName(userName);
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
				userManager.insertUser(user);
				notificationMessage = "User has been successfully registered.";
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
