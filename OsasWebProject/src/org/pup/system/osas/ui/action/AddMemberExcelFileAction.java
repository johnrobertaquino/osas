package org.pup.system.osas.ui.action;

import org.pup.system.osas.core.domain.Member;
import org.pup.system.osas.core.domain.Organization;
import org.pup.system.osas.core.domain.Scholar;
import org.pup.system.osas.core.domain.ScholarshipProgram;
import org.pup.system.osas.core.domain.transformer.MemberExcelRowToDomainTransformer;
import org.pup.system.osas.core.domain.transformer.ScholarExcelRowToDomainTransformer;
import org.pup.system.osas.core.manager.MemberManager;
import org.pup.system.osas.core.manager.OrganizationManager;
import org.pup.system.osas.core.manager.ScholarManager;
import org.pup.system.osas.core.manager.ScholarshipProgramManager;
import org.pup.system.osas.exception.BusinessException;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.pup.system.osas.ui.action.AbstractAction;

public class AddMemberExcelFileAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8910283248066116810L;

	private File file;
	
	private List<Member> memberList;
	
	private String organizationId;
	
	@Override
	public String execute() throws Exception {
		pageName = "Manage Scholar";
		
		String actionResult = FORWARD_SUCCESS;
		
		FileInputStream fis = null;
		XSSFWorkbook workbook = null;

		try {
			OrganizationManager organizationManager = new OrganizationManager();
			Organization organization = organizationManager.getOrganization(Integer.parseInt(organizationId));
			

			fis = new FileInputStream(file);

			workbook = new XSSFWorkbook(fis);

			XSSFSheet sheet = workbook.getSheetAt(0);

			int index = 0;

			MemberExcelRowToDomainTransformer transformer = null;

			memberList = null;

			for (Row row : sheet) {
				if (index == 0) {
					
					transformer = new MemberExcelRowToDomainTransformer(row);
				} else {
					Member member = transformer.transform(row);

					if (memberList == null) {
						memberList = new ArrayList<Member>();

					}
					memberList.add(member);
					member.setOrganization(organization);
					MemberManager memberManager = new MemberManager();
					memberManager.insertMember(member);
					
					notificationMessage = "Member has been saved successfully added.";
				}

				index++;
			}
		}
			
		catch (BusinessException be) {
			errorMessage = be.getMessage();
			actionResult = FORWARD_ERROR;
			be.printStackTrace();
		} catch (Exception e) {
			errorMessage = "System error occurred. Please contact administrator.";
			actionResult = FORWARD_ERROR;
			e.printStackTrace();
		} finally {
			if (workbook != null) {
				workbook.close();
			}
			if (fis != null) {
				fis.close();
			}
		}

		return actionResult;

	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	/**
	 * @return the memberList
	 */
	public List<Member> getMemberList() {
		return memberList;
	}

	/**
	 * @param memberList the memberList to set
	 */
	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}

	/**
	 * @return the organizationId
	 */
	public String getOrganizationId() {
		return organizationId;
	}

	/**
	 * @param organizationId the organizationId to set
	 */
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	
	
}
