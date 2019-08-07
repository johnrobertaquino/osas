package org.pup.system.osas.ui.action;


import org.pup.system.osas.core.domain.Agency;
import org.pup.system.osas.core.manager.AgencyManager;
import org.pup.system.osas.exception.BusinessException;

public class EditAgencyAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1719224812724606894L;
	
	private int agencyId;
	
	private String agencyName;
	
	private String address;
	
	private String contactPerson;
	
	private String contactNumber;
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage User Account";

		String actionResult = FORWARD_SUCCESS;

		try {
			AgencyManager agencyManager = new AgencyManager();
			Agency agency = agencyManager.getAgency(agencyId);
			
			agency.setAgencyId(agencyId);
			agency.setAgencyName(agencyName);
			agency.setAddress(address);
			agency.setContactPerson(contactPerson);
			agency.setContactNumber(contactNumber);
			
			agencyManager.saveAgency(agency);
			
			notificationMessage = "Changes to agency has been saved successfully.";
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

	public int getAgencyId() {
		return agencyId;
	}
	/**
	 * @param agencyName the agencyName to set
	 */
	public void setAgencyId(int agencyId) {
		this.agencyId = agencyId;
	}
	
	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the contactPerson
	 */
	public String getContactPerson() {
		return contactPerson;
	}

	/**
	 * @param contactPerson the contactPerson to set
	 */
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	/**
	 * @return the contactPerson
	 */
	public String getContactNumber() {
		return contactNumber;
	}

	/**
	 * @param contactPerson the contactPerson to set
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	

}
