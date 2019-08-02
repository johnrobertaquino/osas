package org.pup.system.osas.core.domain;

import java.util.Date;
import java.util.List;

public class User {

	private int userId;
	
	private String userName;
	
	private String password;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private Date birthday;
	
	private String contactNumber;
	
	private String position;
	
	private FirstTimeLoginReference firstTimeLoginReference;
	
	private List<UserRole> userRoleList;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public List<UserRole> getUserRoleList() {
		return userRoleList;
	}

	public void setUserRoleList(List<UserRole> userRoleList) {
		this.userRoleList = userRoleList;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
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

	public FirstTimeLoginReference getFirstTimeLoginReference() {
		return firstTimeLoginReference;
	}

	public void setFirstTimeLoginReference(FirstTimeLoginReference firstTimeLoginReference) {
		this.firstTimeLoginReference = firstTimeLoginReference;
	}
	
	/**
	 * Sample Output: Administrator, Approver
	 * @return
	 */
	public String getUserRoleForDisplay() {
		String userRoleForDisplay = "";
		
		if (this.userRoleList != null) {
			for (UserRole userRole : this.userRoleList) {
				if(!userRoleForDisplay.isEmpty()) {
					userRoleForDisplay = userRoleForDisplay + ", ";
				}
				userRoleForDisplay = userRoleForDisplay + userRole.getUserRoleReference().getUserRoleName();
			}
		}
		
		return userRoleForDisplay;
	}
	
	public boolean isAdmin() {
		return hasUserRole("AD");
	}
	
	public boolean isApprover() {
		return hasUserRole("AP");
	}
	
	public boolean isUser() {
		return hasUserRole("US");
	}
	
	private boolean hasUserRole(String userRoleReferenceCode) {
		boolean hasUserRole = false;
		
		if (this.userRoleList != null) {
			for (UserRole userRole : this.userRoleList) {
				if (userRoleReferenceCode.equalsIgnoreCase(userRole.getUserRoleReference().getUserRoleReferenceCode())) {
					hasUserRole = true;
				}
			}
		}
		
		return hasUserRole;
	}
	
}
