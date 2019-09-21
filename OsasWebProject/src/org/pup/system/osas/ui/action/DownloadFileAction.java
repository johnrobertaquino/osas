package org.pup.system.osas.ui.action;

import java.io.File;
import java.io.FileInputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

public class DownloadFileAction extends AbstractAction implements ServletResponseAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6466310967847927828L;
	
	private HttpServletResponse httpServletResponse;
	
	private String fileName;
	
	private String type;
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholarship > Qualifications";

		String actionResult = FORWARD_SUCCESS;

		try {
			httpServletResponse.setContentType("application/octet-stream");
			httpServletResponse.setHeader("Content-Disposition","attachment;filename=" + fileName);
			
			if ("SQ".equalsIgnoreCase(type)) {
				FileInputStream in = new FileInputStream(new File("C:/OSAS/scholarAttachment/" + fileName));
				
				ServletOutputStream out = httpServletResponse.getOutputStream();
	        	 
		        byte[] outputByte = new byte[4096];
		        //copy binary content to output stream
		        while(in.read(outputByte, 0, 4096) != -1){
		        	out.write(outputByte, 0, 4096);
		        }
		        in.close();
		        out.flush();
		        out.close();
			}
		     
		}catch (Exception e) {
			errorMessage = "System error occurred. Please contact administrator.";
			actionResult = FORWARD_ERROR;
			e.printStackTrace();
		}

		return actionResult;
	}

	@Override
	public void setServletResponse(HttpServletResponse httpServletResponse) {
		this.httpServletResponse = httpServletResponse;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
