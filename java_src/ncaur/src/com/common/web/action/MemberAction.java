package com.common.web.action;

import com.city.value.*;
import com.common.value.*;
import com.common.service.CommonManager;
import com.city.service.CityManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URLEncoder;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.*;

public class MemberAction extends CommonActionSupport {

	private static final long serialVersionUID = 1L;
	private final Log log;
	private Member member, newmember;
	private String birthday;
	private String applyDate;
	private java.io.File filePhoto;
	private String filePhotoContentType, filePhotoFileName, removePhoto;
	private Long[] contactsIds;
	private Long[] selectedMemberIds;
	private Long[] groupIds;
	String[] experiencesDescription, school, department;
	int experiencesCount, schoolCount;
	private Set<Group> newGroups = new HashSet();
	String keyword, actionUrl;
	Course course;
	CourseMember courseMember;

	public MemberAction() {
		log = LogFactory.getLog(com.common.web.action.MemberAction.class);
	}

	public Function getFunction() {
		return getGenericManager().getFunctionByKey("MEMBER");
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member val) {
		member = val;
	}

	public void setGenericManager(CommonManager m) {
		super.setGenericManager(m);
	}

	public CommonManager getGenericManager() {
		return (CommonManager) super.getGenericManager();
	}

	public void setCityManager(CityManager m) {
		super.setGenericManager(m);
	}

	public CityManager getCityManager() {
		return (CityManager) super.getGenericManager();
	}

	public String delete() {
		getGenericManager().removeMember(member.getId());
		return DELETE;
	}

	public String edit1() {
		SessionUser s = (SessionUser) getSession().getAttribute("user");
		member = getGenericManager().getMemberById(s.getMember().getId());
		beanToForm();
		actionUrl = "savePersonnel";
		return SUCCESS;
	}

	public String edit() {
		if (member == null) {
			member = new Member();
		} else if (member.getId() != null) {
			member = getGenericManager().getMemberById(member.getId());
		} else { // TODO
		}
		beanToForm();
		actionUrl = "saveMember";

		return SUCCESS;
	}

	public String copy() {
		if (selectedMemberIds != null && selectedMemberIds.length > 0) {
			Member obj = getGenericManager().getMemberById(selectedMemberIds[0]);
			obj.setId(null);
			member = obj;
		}
		beanToForm();

		return SUCCESS;
	}

	public String execute() {
		log.info("entering 'execute' method");
		if (getDelete() != null) {
			return delete();
		} else {
			formToBean();
			if (inputValidation(member) == false)
				return INPUT;
		}
		return SUCCESS;
	}

	public boolean inputValidation(Member val) {
		return true;
	}

	public String save2() {
		java.sql.Timestamp ts = Tools.getCurrentTimestamp();
		if (member.getId() == null) {
			member.setCreatedDate(ts);
		}
		member.setLastModifiedDate(ts);
		getGenericManager().saveMember(member);
		saveFileToLocal(filePhotoFileName, filePhoto, getTextWithArgs("member.uploadPhoto.dir"), member.getId());
		getSession().setAttribute("user", copyToSessionUser(member));

		// Set Cookie
		try {
			Cookie memberId = new Cookie("memberId", String.valueOf(member.getId()));
			Cookie membername = new Cookie("membername", URLEncoder.encode(member.getCname(), "UTF-8"));
			memberId.setMaxAge(Integer.MAX_VALUE);
			membername.setMaxAge(Integer.MAX_VALUE);
			HttpServletResponse response = getHttpServletResponse();
			response.addCookie(memberId);
			response.addCookie(membername);
		} catch (Exception e) {
			System.out.println("save2 Set Cookie error=" + e.toString());
		}

		// save course
		try {
			course = getCityManager().getCourseById(course.getId());
			System.out.println("save2 save course()=" + course.getNo());
			courseMember = getCityManager().getCourseMember(course, member);
			if (courseMember == null) {
				System.out.println("courseMember==null");
				courseMember = new CourseMember();
				courseMember.setCourse(course);
				courseMember.setMember(member);
				courseMember.setCreatedDate(Tools.getCurrentTimestamp());
				courseMember.setLastModifiedDate(Tools.getCurrentTimestamp());
				getCityManager().saveCourseMember(courseMember);
			}
		} catch (Exception e) {
			System.out.println("save2 save course error=" + e.toString());
		}

		appendXworkParam("course.id=" + course.getId());

		return SUCCESS;
	}

	public String save() {
		log.info("entering 'save' method");
		java.sql.Timestamp ts = Tools.getCurrentTimestamp();
		if (member.getId() == null) {
			member.setCreatedDate(ts);
		}
		member.setLastModifiedDate(ts);
		getGenericManager().saveMember(member);
		saveFileToLocal(filePhotoFileName, filePhoto, getTextWithArgs("member.uploadPhoto.dir"), member.getId());
		return SUCCESS;
	}

	public String save1() {
		log.info("entering 'save' method");
		java.sql.Timestamp ts = Tools.getCurrentTimestamp();
		if (member.getId() == null) {
			member.setCreatedDate(ts);
		}
		member.setLastModifiedDate(ts);
		getGenericManager().saveMember(member);
		saveFileToLocal(filePhotoFileName, filePhoto, getTextWithArgs("member.uploadPhoto.dir"), member.getId());
		appendXworkParam("msg=1");
		return SUCCESS;
	}

	public String list() {
		return SUCCESS;
	}

	protected void beanToForm() {
		log.info("enter beanToForm()");
		birthday = Tools.dateToString(member.getBirthday());
		applyDate = Tools.dateToString(member.getApplyDate());
		contactsIds = getGenericManager().getIdsFromAppPropertyList(member.getContacts());
		// experiencesIds =
		// getGenericManager().getIdsFromExperienceList(member.getExperiences());
		// schoolsIds =
		// getGenericManager().getIdsFromExperienceList(member.getSchools());
		log.info("exit beanToForm()");
	}

	protected void formToBean() {
		log.info("enter formToBean()");
		member.setBirthday(Tools.convertToDate(birthday));
		member.setApplyDate(Tools.convertToDate(applyDate));
		if (getRemovePhoto() != null && getRemovePhoto().length() > 0) {
			member.setPhoto(computeUploadedFile(filePhotoFileName, filePhoto));
			removeUploadedFile(getTextWithArgs("member.uploadPhoto.dir"), member.getPhotoId(), member.getPhotoFileName());
		} else {
			if (member.getPhotoId() != null)
				member.setPhoto(getGenericManager().getUploadedFileById(member.getPhotoId()));
			else
				member.setPhoto(computeUploadedFile(filePhotoFileName, filePhoto));
		}
		member.setContacts(getGenericManager().getAppPropertyListByIds(contactsIds));
		member.setGroups(getGenericManager().getGroupListByIds(groupIds));
		setExperiences();
		setSchools();
		log.info("exit formToBean()");
	}

	public void setBirthday(String val) {
		birthday = val;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setApplyDate(String val) {
		applyDate = val;
	}

	public String getApplyDate() {
		return applyDate;
	}

	public void setFilePhoto(java.io.File val) {
		filePhoto = val;
	}

	public java.io.File getFilePhoto() {
		return filePhoto;
	}

	public void setFilePhotoContentType(String val) {
		filePhotoContentType = val;
	}

	public String getFilePhotoContentType() {
		return filePhotoContentType;
	}

	public void setFilePhotoFileName(String val) {
		filePhotoFileName = val;
	}

	public String getFilePhotoFileName() {
		return filePhotoFileName;
	}

	public void setRemovePhoto(String val) {
		removePhoto = val;
	}

	public String getRemovePhoto() {
		return removePhoto;
	}

	public void setContactsIds(Long[] val) {
		contactsIds = val;
	}

	public Long[] getContactsIds() {
		return contactsIds;
	}

	public Long[] getGroupIds() {
		return groupIds;
	}

	public void setGroupIds(Long[] groupIds) {
		this.groupIds = groupIds;
	}

	public Set<Group> getNewGroups() {
		return newGroups;
	}

	public void setNewGroups(Set<Group> newGroups) {
		this.newGroups = newGroups;
	}

	public String[] getExperiencesDescription() {
		return experiencesDescription;
	}

	public void setExperiencesDescription(String[] experiencesDescription) {
		this.experiencesDescription = experiencesDescription;
	}

	public int getExperiencesCount() {
		return experiencesCount;
	}

	public void setExperiencesCount(int experiencesCount) {
		this.experiencesCount = experiencesCount;
	}

	public int getSchoolCount() {
		return schoolCount;
	}

	public void setSchoolCount(int schoolCount) {
		this.schoolCount = schoolCount;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public void setExperiences() {
		ArrayList<Experience> al = new ArrayList<Experience>();
		System.out.println("experiencesCount=" + experiencesCount);

		try {
			for (int i = 0; i < experiencesCount; i++) {
				Experience s = new Experience();
				s.setDescription(experiencesDescription[i]);
				al.add(s);
				System.out.println("experiencesDescription[i]=" + experiencesDescription[i]);
			}
		} catch (Exception e) {
			System.out.println("setExperiences error=" + e.toString());
		}
		member.setExperiences(al);
	}

	public void setSchools() {
		ArrayList<School> al = new ArrayList<School>();
		System.out.println("schoolCount=" + schoolCount);

		try {
			for (int i = 0; i < schoolCount; i++) {
				School s = new School();
				s.setSchool(school[i]);
				s.setDepartment(department[i]);
				al.add(s);
			}
		} catch (Exception e) {
			System.out.println("setSchools error=" + e.toString());
		}
		member.setSchools(al);
	}

	public Set<Group> getObject_groupList() {
		Set groups = member.getGroups();
		if (groups != null) {
			return member.getGroups();
		} else {
			return newGroups;
		}
	}

	public List<Experience> getObject_experiencesList() {
		return (member.getExperiences() == null) ? new ArrayList<Experience>() : member.getExperiences();
	}

	public String[] getSchool() {
		return school;
	}

	public void setSchool(String[] school) {
		this.school = school;
	}

	public String[] getDepartment() {
		return department;
	}

	public void setDepartment(String[] department) {
		this.department = department;
	}

	public String getActionUrl() {
		return actionUrl;
	}

	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}

	public List<Member> getMemberList() {
		System.out.println("keyword=" + keyword);
		return getGenericManager().getMemberList(keyword);
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String findMemberJSON() {
		JSONArray ja = new JSONArray();
		
		System.out.println("findMemberJSON keyword="+keyword);
		try {
			List<Member> ls=getMemberList();
			for(int i=0;i<ls.size();i++)
			{
				member=ls.get(i);
				JSONObject jo = new JSONObject();
				jo.put("value", member.getId());
				jo.put("text", member.getCname());
				
				jo.put("company", (member.getCompany() == null) ? "" : member.getCompany());
				jo.put("title", (member.getTitle() == null) ? "" :member.getTitle());
				jo.put("cellphone", (member.getCellphone() == null) ? "" :member.getCellphone());
				jo.put("companyAddress", (member.getCompanyAddress() == null) ? "" :member.getCompanyAddress());
				jo.put("email", (member.getEmail() == null) ? "" :member.getEmail());
				jo.put("line", (member.getLine() == null) ? "" :member.getLine());
				
				String photo="images/nobody.bmp";
				if(member.getPhoto()!=null)
				{
					photo="upload/member/"+member.getId()+"/"+member.getPhoto().getFileName();	
				}	
				jo.put("photo", photo);
				
				//CourseMember
				List<CourseMember> courses=getCityManager().getCourseMemberListByMember(member);
				String c="";
				for(int j=0;j<courses.size();j++)
				{
					CourseMember cm=courses.get(j);
					c+=  (j+1)+":"+cm.getCourse().getCourseName()+"<br>";
				}
				jo.put("courses", c);
				

				
				ja.put(jo);
			}
		} catch (Exception e) {

		}
		return ja.toString();
	}
}
