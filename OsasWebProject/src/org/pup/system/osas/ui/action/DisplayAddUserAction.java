package org.pup.system.osas.ui.action;

import java.util.List;

public class DisplayAddUserAction extends AbstractAction  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2936689632600612372L;

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
	
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage User Account";
		
		return FORWARD_SUCCESS;
	}
	
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
