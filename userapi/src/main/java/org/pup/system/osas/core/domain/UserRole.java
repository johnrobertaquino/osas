package org.pup.system.osas.core.domain;

public class UserRole {
	private int userRoleId;
	
	private int userId;
	
	private UserRoleReference userRoleReference;

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public UserRoleReference getUserRoleReference() {
		return userRoleReference;
	}

	public void setUserRoleReference(UserRoleReference userRoleReference) {
		this.userRoleReference = userRoleReference;
	}


}
