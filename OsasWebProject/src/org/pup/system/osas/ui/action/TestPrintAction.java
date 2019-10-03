package org.pup.system.osas.ui.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.pup.system.osas.core.domain.Agency;
import org.pup.system.osas.core.domain.User;
import org.pup.system.osas.core.manager.ReportManager;
import org.pup.system.osas.report.ScholarsByAgencyAndProgramReport;
import org.pup.system.osas.report.data.ScholarsByAgencyAndProgramReportData;

public class TestPrintAction extends AbstractAction implements ServletResponseAware, ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -479935379984576456L;
	private HttpServletResponse response;
	private HttpServletRequest request;

	@Override
	public String execute() throws Exception {
		try {
			response.setContentType("application/pdf");
			String imagePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ "/images";

			//AgencyReport report = new AgencyReport(imagePath, "SCHOOL YEAR 2018-2019 - 1st SEM", getAgencyList(), getUser());
			
			ReportManager reportManager = new ReportManager();
			List<ScholarsByAgencyAndProgramReportData> scholarsByAgencyAndProgramReportDataList = reportManager.getScholarsByAgencyAndProgramReportData(1, 1, "BSIT");
			
			ScholarsByAgencyAndProgramReport report = new ScholarsByAgencyAndProgramReport(imagePath, "Tanauan City Scholarship Foundation", scholarsByAgencyAndProgramReportDataList, getUser(), false);	

			report.generateReport(response.getOutputStream());
		} catch (Exception e) {

		}

		return null;
	}	
	
	private User getUser() {
		User user = new User();
		
		user.setFirstName("Levelyn Grace");
		user.setLastName("Rogon");
		user.setPosition("Pinuno");
		
		return user;
	}
	
	private List<Agency> getAgencyList() {
		List<Agency> agencyList = new ArrayList<Agency>();
		
		Agency agency = new Agency();
		agency.setAgencyId(1);
		agency.setAgencyName("Tanauan City Government");
		agency.setAddress("1520 Brgy. 1, Tanauan City, Batangas");
		agency.setContactPerson("My Contactone");
		agency.setContactNumber("09562695695");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(2);
		agency.setAgencyName("Calamba City Government");
		agency.setAddress("1520 Brgy. 1, Calamba City, Laguna");
		agency.setContactPerson("My Contacttwo");
		agency.setContactNumber("09562695691");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(3);
		agency.setAgencyName("San Pablo City Government");
		agency.setAddress("1520 Brgy. 1, San Pablo City, Laguna");
		agency.setContactPerson("My Contactthree");
		agency.setContactNumber("09562695692");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		agency = new Agency();
		agency.setAgencyId(4);
		agency.setAgencyName("Sta. Rosa City Government");
		agency.setAddress("1520 Brgy. 1, Sta. Rosa City, Batangas");
		agency.setContactPerson("My Contactfour");
		agency.setContactNumber("09562695693");
		agencyList.add(agency);
		
		return agencyList;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

}
