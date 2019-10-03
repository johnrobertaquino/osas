package org.pup.system.osas.ui.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.pup.system.osas.core.domain.ScholarshipProgram;
import org.pup.system.osas.core.domain.User;
import org.pup.system.osas.core.manager.ReportManager;
import org.pup.system.osas.core.manager.ScholarshipProgramManager;
import org.pup.system.osas.exception.BusinessException;
import org.pup.system.osas.report.ScholarsByAgencyAndProgramReport;
import org.pup.system.osas.report.data.ScholarsByAgencyAndProgramReportData;

public class ScholarsByAgencyAndProgramReportAction extends AbstractAction
		implements ServletResponseAware, ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -479935379984576456L;
	private HttpServletResponse response;
	private HttpServletRequest request;

	private int semTermId;

	private int scholarshipProgramId;

	private String program;

	@Override
	public String execute() throws Exception {
		String actionResult = null;
		
		try {
			response.setContentType("application/pdf");
			String imagePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ "/images";

			ReportManager reportManager = new ReportManager();
			List<ScholarsByAgencyAndProgramReportData> scholarsByAgencyAndProgramReportDataList = reportManager
					.getScholarsByAgencyAndProgramReportData(semTermId, scholarshipProgramId, program);

			ScholarshipProgramManager scholarshipProgramManager = new ScholarshipProgramManager();
			ScholarshipProgram scholarshipProgram = scholarshipProgramManager
					.getScholarshipProgram(scholarshipProgramId);
			
			if (scholarsByAgencyAndProgramReportDataList == null || scholarsByAgencyAndProgramReportDataList.isEmpty()) {
				errorMessage = "No records found.";
				actionResult = FORWARD_ERROR;
			} else {

				ScholarsByAgencyAndProgramReport report = new ScholarsByAgencyAndProgramReport(imagePath,
						scholarshipProgram.getScholarshipProgramName(), scholarsByAgencyAndProgramReportDataList,
						(User) userSession.get(USER), false);
	
				response.setContentType("application/octet-stream");
				response.setHeader("Content-Disposition","attachment;filename=" + "Scholarship Agency/Program Report - " + scholarshipProgram.getScholarshipProgramName() + ".pdf");
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

	public int getSemTermId() {
		return semTermId;
	}

	public void setSemTermId(int semTermId) {
		this.semTermId = semTermId;
	}

	public int getScholarshipProgramId() {
		return scholarshipProgramId;
	}

	public void setScholarshipProgramId(int scholarshipProgramId) {
		this.scholarshipProgramId = scholarshipProgramId;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

}
