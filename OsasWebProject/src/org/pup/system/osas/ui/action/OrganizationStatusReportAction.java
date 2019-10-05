package org.pup.system.osas.ui.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.pup.system.osas.core.domain.User;
import org.pup.system.osas.core.domain.YearlyTerm;
import org.pup.system.osas.core.manager.ReportManager;
import org.pup.system.osas.core.manager.YearlyTermManager;
import org.pup.system.osas.exception.BusinessException;
import org.pup.system.osas.report.OrganizationsStatusReport;
import org.pup.system.osas.report.data.OrganizationsStatusReportData;

public class OrganizationStatusReportAction extends AbstractAction
		implements ServletResponseAware, ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -479935379984576456L;
	
	private HttpServletResponse response;
	
	private HttpServletRequest request;
	
	private int yearlyTermId;
	
	private String organizationTypeCode;

	@Override
	public String execute() throws Exception {
		String actionResult = null;
		
		try {
			response.setContentType("application/pdf");
			String imagePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ "/images";

			ReportManager reportManager = new ReportManager();
			OrganizationsStatusReportData organizationsStatusReportData = reportManager.getOrganizationsStatusReportData(yearlyTermId, organizationTypeCode);

			YearlyTermManager yearlyTermManager = new YearlyTermManager();
			YearlyTerm yearlyTerm = yearlyTermManager.getYearlyTerm(yearlyTermId);
			
			if (organizationsStatusReportData.getOrganizationReportDataList() == null || organizationsStatusReportData.getOrganizationReportDataList().isEmpty()) {
				errorMessage = "No records found.";
				actionResult = FORWARD_ERROR;
			} else {
				boolean landscape = false;
				if (organizationsStatusReportData.getOrganizationReportDataList().size() > 4) {
					landscape = true;
				}
				OrganizationsStatusReport report = new OrganizationsStatusReport(imagePath,
						yearlyTerm.getYearlyTermName() + " CHECKLIST", organizationsStatusReportData,
						(User) userSession.get(USER), landscape);
	
				response.setContentType("application/octet-stream");
				response.setHeader("Content-Disposition","attachment;filename=" + "Organization Status Report - " + yearlyTerm.getYearlyTermName() + ".pdf");
				report.generateReport(response.getOutputStream());
				
				actionResult = null;
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

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}
	public int getYearlyTermId() {
		return yearlyTermId;
	}

	public void setYearlyTermId(int yearlyTermId) {
		this.yearlyTermId = yearlyTermId;
	}

	public String getOrganizationTypeCode() {
		return organizationTypeCode;
	}

	public void setOrganizationTypeCode(String organizationTypeCode) {
		this.organizationTypeCode = organizationTypeCode;
	}
	
	

}
