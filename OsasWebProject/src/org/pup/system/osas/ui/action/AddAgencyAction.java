package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.Agency;
import org.pup.system.osas.core.manager.AgencyManager;
import org.pup.system.osas.exception.BusinessException;

public class AddAgencyAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8910283248066116810L;
	
	private static final String FORWARD_DISPLAYADDAGENCY = "displayAddAgency";
	
	private String agencyName;
	
	private String address;
	
	private String position;
	
	private String contactPerson;
	
	private String contactNumber;
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholarship Agency";
		
		String actionResult = FORWARD_SUCCESS;
		
		try {
			Agency agency = new Agency();
			AgencyManager agencyManager = new AgencyManager();
			agency = agencyManager.validate(agencyName, getCurrentActiveTerm().getSemTermId());
			
			if(agency != null) { 
				notificationMessage = "Agency already exist.";
				actionResult = FORWARD_DISPLAYADDAGENCY;
			}
			else
			{
				agency = new Agency();
				agency.setAgencyName(agencyName);
				agency.setAddress(address);
				agency.setContactPerson(contactPerson);
				agency.setPosition(position);
				agency.setContactNumber(contactNumber);
				agency.setSemTerm(getCurrentActiveTerm());
				agencyManager.insertAgency(agency);
				notificationMessage = "Agency has been successfully added.";
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

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	
	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
}
