package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.Agency;
import org.pup.system.osas.core.manager.AgencyManager;
import org.pup.system.osas.exception.BusinessException;

public class AddAgencyAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8910283248066116810L;

	private String agencyId;
	
	private String agencyName;
	
	private String address;
	
	private String contactPerson;
	
	private String contactNumber;
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholarship Agency";
		
		String actionResult = FORWARD_SUCCESS;
		
		try {
			Agency agency = new Agency();
			agency.setAgencyName(agencyName);
			agency.setAddress(address);
			agency.setContactPerson(contactPerson);
			agency.setContactNumber(contactNumber);
			agency.setSemTerm(getCurrentActiveTerm());
		
			AgencyManager agencyManager = new AgencyManager();
			agency = agencyManager.validate(agencyName);
			agencyManager.insertAgency(agency);
			
			if(agency != null) {
				if(agency.getAgencyName() == agencyName) {
					throw new BusinessException("Agency name is already exist.");
				}
			} else {
				throw new BusinessException("Agency has been saved successfully added.");
			}
			
			notificationMessage = "Agency has been saved successfully added.";
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

	public String getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(String agencyId) {
		this.agencyId = agencyId;
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
}
