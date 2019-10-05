package org.pup.system.osas.core.manager;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pup.system.osas.core.dao.AgencyDAO;
import org.pup.system.osas.core.dao.ConnectionUtil;
import org.pup.system.osas.core.dao.MemberDAO;
import org.pup.system.osas.core.dao.OrganizationDAO;
import org.pup.system.osas.core.dao.OrganizationQualificationDAO;
import org.pup.system.osas.core.dao.OrganizationRequirementDAO;
import org.pup.system.osas.core.dao.ProgramDAO;
import org.pup.system.osas.core.dao.ScholarDAO;
import org.pup.system.osas.core.dao.ScholarQualificationDAO;
import org.pup.system.osas.core.dao.ScholarshipProgramDAO;
import org.pup.system.osas.core.dao.ScholarshipQualificationDAO;
import org.pup.system.osas.core.dao.SemTermDAO;
import org.pup.system.osas.core.dao.YearlyTermDAO;
import org.pup.system.osas.core.domain.Agency;
import org.pup.system.osas.core.domain.Member;
import org.pup.system.osas.core.domain.MemberOrganizationReference;
import org.pup.system.osas.core.domain.Organization;
import org.pup.system.osas.core.domain.OrganizationQualification;
import org.pup.system.osas.core.domain.OrganizationRequirement;
import org.pup.system.osas.core.domain.Program;
import org.pup.system.osas.core.domain.Scholar;
import org.pup.system.osas.core.domain.ScholarQualification;
import org.pup.system.osas.core.domain.ScholarshipProgram;
import org.pup.system.osas.core.domain.ScholarshipQualification;
import org.pup.system.osas.core.domain.SemTerm;
import org.pup.system.osas.core.domain.YearlyTerm;
		
public class JobManager {
	
	public static void main(String[] args) {
		JobManager job = new JobManager();
		try {
			job.generateNewFirstSem();
			//job.generateNewSecondSem();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void generateNewSecondSem() throws Exception {
		Connection connection = null;
		
		ProgramDAO programDAO = null;
		SemTermDAO semTermDAO = null;
		AgencyDAO agencyDAO = null;
		ScholarshipProgramDAO scholarshipProgramDAO = null;
		ScholarshipQualificationDAO scholarshipQualificationDAO = null;
		ScholarDAO scholarDAO = null;
		ScholarQualificationDAO scholarQualificationDAO = null;
		OrganizationDAO organizationDAO = null;
		OrganizationRequirementDAO organizationRequirementDAO = null;
		OrganizationQualificationDAO organizationQualificationDAO = null;
		MemberDAO memberDAO = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			semTermDAO = new SemTermDAO(connection);
			agencyDAO = new AgencyDAO(connection);
			scholarshipProgramDAO = new ScholarshipProgramDAO(connection);
			scholarshipQualificationDAO = new ScholarshipQualificationDAO(connection);
			scholarDAO = new ScholarDAO(connection);
			programDAO = new ProgramDAO(connection);
			scholarQualificationDAO = new ScholarQualificationDAO(connection);
			organizationDAO = new OrganizationDAO(connection);
			organizationRequirementDAO = new OrganizationRequirementDAO(connection);
			organizationQualificationDAO = new OrganizationQualificationDAO(connection);
			memberDAO = new MemberDAO(connection);
			
			SemTerm activeSemTerm = semTermDAO.getSemTermByActive(true);
			semTermDAO.setToInactive(activeSemTerm);
			
			int oldSemTermId = activeSemTerm.getSemTermId();
			
			SemTerm newSemTerm = new SemTerm();
			newSemTerm.setActive(true);
			String year1 = new SimpleDateFormat("yyyy").format(activeSemTerm.getStartDate());
			String year2 = (Integer.parseInt(year1) + 1) + "";
			newSemTerm.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse(year2 + "-03-31"));
			newSemTerm.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(year1 + "-11-01"));
			newSemTerm.setDeadline(new Date());
			newSemTerm.setYearlyTermId(activeSemTerm.getYearlyTermId());
			newSemTerm.setSemTermName("2nd Semester " + year1 + " - " +year2);
			
			semTermDAO.insertSemTerm(newSemTerm);
			
			Map<String, Program> programMap = new HashMap<String, Program>();
			List<Program> programList = programDAO.getProgramList(oldSemTermId);
			
			if(programList != null) {
				for (Program program : programList) {
					String oldProgramCode = program.getProgramCode();
					
					//insert program
					program.setSemTerm(newSemTerm);
					programDAO.insertProgram(program);
					
					programMap.put(oldProgramCode, program);
				}
			}
			
			List<Agency> agencyList = agencyDAO.getAgencyList(oldSemTermId);
			
			if(agencyList != null) {
				for (Agency agency : agencyList) {
					int oldAgencyId = agency.getAgencyId();
					
					//insert agency
					agency.setSemTerm(newSemTerm);
					agencyDAO.insertAgency(agency);
					
					List<ScholarshipProgram> scholarshipProgramList = scholarshipProgramDAO.getScholarshipProgramListByAgencyId(oldAgencyId);
					
					if(scholarshipProgramList != null) {
						for (ScholarshipProgram scholarshipProgram : scholarshipProgramList) {
							int oldScholarshipProgramId = scholarshipProgram.getScholarshipProgramId();
							
							//insert scholarship program
							scholarshipProgram.setAgency(agency);
							scholarshipProgramDAO.insertScholarshipProgram(scholarshipProgram);
							
							Map<Integer, ScholarshipQualification> scholarshipQualificationMap = new HashMap<Integer, ScholarshipQualification>();
							List<ScholarshipQualification> scholarshipQualificationList = scholarshipQualificationDAO.getScholarshipQualificationList(oldScholarshipProgramId, oldSemTermId);
							
							if(scholarshipQualificationList != null) {
								for (ScholarshipQualification scholarshipQualification : scholarshipQualificationList) {
									int oldScholarshipQualificationId = scholarshipQualification.getScholarshipQualificationId();
									
									//insert scholarshipQualification
									scholarshipQualification.setScholarshipProgram(scholarshipProgram);
									scholarshipQualificationDAO.insertScholarshipQualification(scholarshipQualification);
									
									scholarshipQualificationMap.put(oldScholarshipQualificationId, scholarshipQualification);
								}
							}
							
							List<Scholar> scholarList = scholarDAO.getScholarListByScholarshipProgramId(oldScholarshipProgramId);
							
							if(scholarList != null) {
								for (Scholar scholar : scholarList) {
									int oldScholarId = scholar.getScholarId();
									String oldScholarProgramCode = scholar.getProgram().getProgramCode();
									
									scholar.setScholarshipProgram(scholarshipProgram);
									scholar.setProgram(programMap.get(oldScholarProgramCode));
									scholarDAO.insertScholar(scholar);
									
									//get list
									List<ScholarQualification> scholarQualificationList = scholarQualificationDAO.getScholarQualificationByScholarIdList(oldScholarId);
									
									if(scholarQualificationList != null) {
										for (ScholarQualification scholarQualification : scholarQualificationList) {
											int oldScholarshipQualificationId = scholarQualification.getScholarshipQualificationId();
											
											ScholarshipQualification scholarshipQualification = scholarshipQualificationMap.get(oldScholarshipQualificationId);
											
											if(scholarshipQualification != null && scholarshipQualification.isYearlyCheck()) {
												scholarQualification.setScholarshipQualificationId(scholarshipQualification.getScholarshipQualificationId());
												scholarQualification.setScholarId(scholar.getScholarId());
											
												scholarQualificationDAO.insertScholarQualification(scholarQualification);
											}
										}
									}
									
								}
							}
						}
					}
				}
			}
			
			Map<Integer, OrganizationRequirement> organizationRequirementMap = new HashMap<Integer, OrganizationRequirement>();
			List<OrganizationRequirement> organizationRequirementList = organizationRequirementDAO.getOrganizationRequirementList(oldSemTermId);
			
			if(organizationRequirementList != null) {
				for (OrganizationRequirement organizationRequirement : organizationRequirementList) {
					int oldOrganizationRequirementId = organizationRequirement.getOrganizationRequirementId();
					
					organizationRequirement.setSemTerm(newSemTerm);
					organizationRequirementDAO.insertOrganizationRequirement(organizationRequirement);
					
					organizationRequirementMap.put(oldOrganizationRequirementId, organizationRequirement);
				}
			}
			
			Map<Integer, Organization> organizationMap = new HashMap<Integer, Organization>();
			List<Organization> organizationList = organizationDAO.getOrganizationList(oldSemTermId);
			
			if(organizationList != null) {
				for (Organization organization : organizationList) {
					int oldOrganizationId = organization.getOrganizationId();
					
					organization.setSemTerm(newSemTerm);
					organizationDAO.insertOrganization(organization);
					
					organizationMap.put(oldOrganizationId, organization);
					
					List<OrganizationQualification> organizationQualificationList = organizationQualificationDAO.getOrganizationQualificationByOrganizationId(oldOrganizationId);
					
					if(organizationQualificationList != null) {
						for (OrganizationQualification organizationQualification : organizationQualificationList) {
							int oldOrganizationRequirementId = organizationQualification.getOrganizationRequirementId();
							
							OrganizationRequirement organizationRequirement = organizationRequirementMap.get(oldOrganizationRequirementId);
							
							if(organizationRequirement != null && organizationRequirement.isYearlyCheck()) {
								organizationQualification.setOrganizationId(oldOrganizationId);
								organizationQualification.setOrganizationRequirementId(oldOrganizationRequirementId);
								
								organizationQualificationDAO.insertOrganizationQualification(organizationQualification);
							}
						}
					}
				}
			}
			
			List<Member> memberList = memberDAO.getMemberList(oldSemTermId);
			
			if(memberList != null)
			{
				for (Member member : memberList) {
					int oldMemberId = member.getMemberId();
					
					memberDAO.insertMember(member);
					
					List<MemberOrganizationReference> memberOrganizationReferenceList = organizationDAO.getMemberOrganizationReferenceList(oldMemberId);
					
					if(memberOrganizationReferenceList != null) {
						for (MemberOrganizationReference memberOrganizationReference : memberOrganizationReferenceList) {
							int oldOrganizationId = memberOrganizationReference.getOrganization().getOrganizationId();
							
							memberOrganizationReference.setMemberId(member.getMemberId());
							memberOrganizationReference.setOrganization(organizationMap.get(oldOrganizationId));
							
							organizationDAO.insertMemberOrganizationReference(memberOrganizationReference);
						}
					}
					
				}
			}
			
			connection.commit();
			
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
	}
	
	public void generateNewFirstSem() throws Exception {
		Connection connection = null;
		
		ProgramDAO programDAO = null;
		SemTermDAO semTermDAO = null;
		AgencyDAO agencyDAO = null;
		ScholarshipProgramDAO scholarshipProgramDAO = null;
		ScholarshipQualificationDAO scholarshipQualificationDAO = null;
		ScholarDAO scholarDAO = null;
		OrganizationDAO organizationDAO = null;
		OrganizationRequirementDAO organizationRequirementDAO = null;
		MemberDAO memberDAO = null;
		YearlyTermDAO yearlyTermDAO = null;
		
		try {
			connection = ConnectionUtil.createConnection();
			
			semTermDAO = new SemTermDAO(connection);
			agencyDAO = new AgencyDAO(connection);
			scholarshipProgramDAO = new ScholarshipProgramDAO(connection);
			scholarshipQualificationDAO = new ScholarshipQualificationDAO(connection);
			scholarDAO = new ScholarDAO(connection);
			programDAO = new ProgramDAO(connection);
			organizationDAO = new OrganizationDAO(connection);
			organizationRequirementDAO = new OrganizationRequirementDAO(connection);
			memberDAO = new MemberDAO(connection);
			yearlyTermDAO = new YearlyTermDAO(connection);
			
			SemTerm activeSemTerm = semTermDAO.getSemTermByActive(true);
			YearlyTerm yearlyTerm = yearlyTermDAO.getYearlyTermByYearlyTermId(activeSemTerm.getYearlyTermId());
			
			yearlyTermDAO.setInactiveYearlyTerm(yearlyTerm);
			
			String year1 = new SimpleDateFormat("yyyy").format(activeSemTerm.getEndDate());
			String year2 = (Integer.parseInt(year1) + 1) + "";
			
			yearlyTerm.setYearlyTermName(year1 + " - " + year2);
			yearlyTermDAO.insertYearlyTerm(yearlyTerm);
			
			
			semTermDAO.setToInactive(activeSemTerm);
			
			int oldSemTermId = activeSemTerm.getSemTermId();
			
			SemTerm newSemTerm = new SemTerm();
			newSemTerm.setActive(true);
			
			newSemTerm.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse(year2 + "-06-01"));
			newSemTerm.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(year1 + "-10-31"));
			newSemTerm.setDeadline(new Date());
			newSemTerm.setYearlyTermId(yearlyTerm.getYearlyTermId());
			newSemTerm.setSemTermName("1st Semester " + year1 + " - " +year2);
			
			semTermDAO.insertSemTerm(newSemTerm);
			
			Map<String, Program> programMap = new HashMap<String, Program>();
			List<Program> programList = programDAO.getProgramList(oldSemTermId);
			
			if(programList != null) {
				for (Program program : programList) {
					String oldProgramCode = program.getProgramCode();
					
					//insert program
					program.setSemTerm(newSemTerm);
					programDAO.insertProgram(program);
					
					programMap.put(oldProgramCode, program);
				}
			}
			
			List<Agency> agencyList = agencyDAO.getAgencyList(oldSemTermId);
			
			if(agencyList != null) {
				for (Agency agency : agencyList) {
					int oldAgencyId = agency.getAgencyId();
					
					//insert agency
					agency.setSemTerm(newSemTerm);
					agencyDAO.insertAgency(agency);
					
					List<ScholarshipProgram> scholarshipProgramList = scholarshipProgramDAO.getScholarshipProgramListByAgencyId(oldAgencyId);
					
					if(scholarshipProgramList != null) {
						for (ScholarshipProgram scholarshipProgram : scholarshipProgramList) {
							int oldScholarshipProgramId = scholarshipProgram.getScholarshipProgramId();
							
							//insert scholarship program
							scholarshipProgram.setAgency(agency);
							scholarshipProgramDAO.insertScholarshipProgram(scholarshipProgram);
							
							List<ScholarshipQualification> scholarshipQualificationList = scholarshipQualificationDAO.getScholarshipQualificationList(oldScholarshipProgramId, oldSemTermId);
							
							if(scholarshipQualificationList != null) {
								for (ScholarshipQualification scholarshipQualification : scholarshipQualificationList) {
									
									//insert scholarshipQualification
									scholarshipQualification.setScholarshipProgram(scholarshipProgram);
									scholarshipQualificationDAO.insertScholarshipQualification(scholarshipQualification);
									
								}
							}
							
							List<Scholar> scholarList = scholarDAO.getScholarListByScholarshipProgramId(oldScholarshipProgramId);
							
							if(scholarList != null) {
								for (Scholar scholar : scholarList) {
									String oldScholarProgramCode = scholar.getProgram().getProgramCode();
									
									scholar.setScholarshipProgram(scholarshipProgram);
									scholar.setProgram(programMap.get(oldScholarProgramCode));
									scholarDAO.insertScholar(scholar);
								}
							}
						}
					}
				}
			}
			
			List<OrganizationRequirement> organizationRequirementList = organizationRequirementDAO.getOrganizationRequirementList(oldSemTermId);
			
			if(organizationRequirementList != null) {
				for (OrganizationRequirement organizationRequirement : organizationRequirementList) {
					
					organizationRequirement.setSemTerm(newSemTerm);
					organizationRequirementDAO.insertOrganizationRequirement(organizationRequirement);
					
				}
			}
			
			Map<Integer, Organization> organizationMap = new HashMap<Integer, Organization>();
			List<Organization> organizationList = organizationDAO.getOrganizationList(oldSemTermId);
			
			if(organizationList != null) {
				for (Organization organization : organizationList) {
					int oldOrganizationId = organization.getOrganizationId();
					
					organization.setSemTerm(newSemTerm);
					organizationDAO.insertOrganization(organization);
					
					organizationMap.put(oldOrganizationId, organization);
				}
			}
			
			List<Member> memberList = memberDAO.getMemberList(oldSemTermId);
			
			if(memberList != null)
			{
				for (Member member : memberList) {
					int oldMemberId = member.getMemberId();
					
					memberDAO.insertMember(member);
					
					List<MemberOrganizationReference> memberOrganizationReferenceList = organizationDAO.getMemberOrganizationReferenceList(oldMemberId);
					
					if(memberOrganizationReferenceList != null) {
						for (MemberOrganizationReference memberOrganizationReference : memberOrganizationReferenceList) {
							int oldOrganizationId = memberOrganizationReference.getOrganization().getOrganizationId();
							
							memberOrganizationReference.setMemberId(member.getMemberId());
							memberOrganizationReference.setOrganization(organizationMap.get(oldOrganizationId));
							
							organizationDAO.insertMemberOrganizationReference(memberOrganizationReference);
						}
					}
					
				}
			}
			
			connection.commit();
			
		} catch (Exception e) {
			ConnectionUtil.rollbackConnection(connection);
			throw e;
		} finally {
			ConnectionUtil.closeDbConnection(connection);
		}
	}

}
