package org.pup.system.osas.ui.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.pup.system.osas.report.AgencyReport;

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

			AgencyReport report = new AgencyReport(imagePath, "SCHOOL YEAR 2018-2019 - 1st SEM");

			report.generateReport(response.getOutputStream());
		} catch (Exception e) {

		}

		return null;
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
