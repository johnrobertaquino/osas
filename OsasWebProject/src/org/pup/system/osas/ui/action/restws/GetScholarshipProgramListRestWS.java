package org.pup.system.osas.ui.action.restws;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.pup.system.osas.core.domain.JSONResponse;
import org.pup.system.osas.core.domain.ScholarshipProgram;
import org.pup.system.osas.core.manager.ScholarshipProgramManager;
import org.pup.system.osas.exception.BusinessException;
import org.pup.system.osas.ui.action.AbstractAction;

import com.fasterxml.jackson.databind.ObjectMapper;

public class GetScholarshipProgramListRestWS extends AbstractAction implements ServletResponseAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5791138071145604991L;

	private HttpServletResponse httpServletResponse;
	
	private int semTermId;

	@Override
	public String execute() throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();
		
		String json = null;
		
		httpServletResponse.setContentType("application/json");
		
		JSONResponse response = new JSONResponse();
		
		try {
			ScholarshipProgramManager scholarshipProgramManager = new ScholarshipProgramManager();
			List<ScholarshipProgram> scholarshipProgramList = null;
			if (semTermId == 0) {
				scholarshipProgramList = scholarshipProgramManager.getScholarshipProgramList(getCurrentActiveTerm().getSemTermId());
			} else {
				scholarshipProgramList = scholarshipProgramManager.getScholarshipProgramList(semTermId);
			}
			
			response.setResult(scholarshipProgramList);
		} catch (BusinessException be) {
			errorMessage = be.getMessage();
			be.printStackTrace();
			
			response.setError(errorMessage);
		} catch (Exception e) {
			errorMessage = "System error occurred. Please contact administrator.";
			e.printStackTrace();
			
			response.setError(errorMessage);
		}
		
		json = mapper.writeValueAsString(response);
		
		httpServletResponse.getWriter().write(json);
		httpServletResponse.getWriter().flush();
		
		return null;
	}

	public int getSemTermId() {
		return semTermId;
	}

	public void setSemTermId(int semTermId) {
		this.semTermId = semTermId;
	}

	@Override
	public void setServletResponse(HttpServletResponse httpServletResponse) {
		this.httpServletResponse = httpServletResponse;
	}

}
