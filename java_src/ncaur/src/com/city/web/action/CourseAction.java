package com.city.web.action;

import com.city.value.*;
import com.city.service.CityManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;

import java.net.URLEncoder;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.common.value.Member;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.AppProperty;
import com.base.value.Function;
import com.base.value.Group;
import com.base.value.SessionUser;
import com.base.value.UploadedFile;

public class CourseAction extends CommonActionSupport {

	private static final long serialVersionUID = 1L;
	private final Log log;
	private Course course, course1;
	private String registerBegin;
	private String registerEnd;
	private String noteDate1;
	private String noteDate2;
	private String noteDate3;
	private String noteDate4;
	private Long[] filegroupsIds;
	private Long[] selectedCourseIds;
	Member member;
	CourseMember courseMember;
	String registerUrl;
	private java.io.File fileCoursefile;
	private String fileCoursefileContentType, fileCoursefileFileName, removeCoursefile;
	private java.io.File fileEmailfile;
	private String fileEmailfileContentType, fileEmailfileFileName, removeEmailfile;
	AppProperty type;
	Long[] photosIds;
	String cellphone, email;
	UploadedFile photo;

	public CourseAction() {
		log = LogFactory.getLog(CourseAction.class);
	}

	public Function getFunction() {
		return getGenericManager().getFunctionByKey("COURSE");
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course val) {
		course = val;
	}

	public void setGenericManager(CityManager m) {
		super.setGenericManager(m);
	}

	public CityManager getGenericManager() {
		return (CityManager) super.getGenericManager();
	}

	public String delete() {
		getGenericManager().removeCourse(course.getId());
		return DELETE;
	}

	public String edit() {
		if (course == null) {
			course = new Course();
		} else if (course.getId() != null) {
			course = getGenericManager().getCourseById(course.getId());
		} else { // TODO
		}
		beanToForm();

		return SUCCESS;
	}

	public String copy() {
		if (selectedCourseIds != null && selectedCourseIds.length > 0) {
			Course obj = getGenericManager().getCourseById(selectedCourseIds[0]);
			obj.setId(null);
			course = obj;
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
			if (inputValidation(course) == false)
				return INPUT;
		}
		return SUCCESS;
	}

	public boolean inputValidation(Course val) {
		return true;
	}

	public JSONObject saveCourseUserJSON() {
		System.out.println("saveCourseUserJSON...course.getId()=" + course.getId() + "--member.id=" + member.getId());
		JSONObject p = new JSONObject();
		try {
			course = getGenericManager().getCourseById(course.getId());
			member = getGenericManager().getMemberById(member.getId());
			System.out.println("course.no=" + course.getNo());

			courseMember = getGenericManager().getCourseMember(course, member);
			if (courseMember == null) {
				System.out.println("courseMember==null");
				courseMember = new CourseMember();
				courseMember.setCourse(course);
				courseMember.setMember(member);
				courseMember.setCreatedDate(Tools.getCurrentTimestamp());
				courseMember.setLastModifiedDate(Tools.getCurrentTimestamp());
				getGenericManager().saveCourseMember(courseMember);
				p.accumulate("returnValue", "1");
				p.accumulate("createdDate", Tools.formatSimpleDate1(Tools.getCurrentTimestamp()));
			} else {
				p.accumulate("returnValue", "2");
				p.accumulate("createdDate", Tools.formatSimpleDate1(courseMember.getLastModifiedDate()));
			}
		} catch (Exception e) {
			System.out.println("saveCourseUserJSON=" + e.toString());
		}
		return p;
	}

	public String save1() {
		courseMember = new CourseMember();
		course = getGenericManager().getCourseById(course.getId());
		SessionUser su = (SessionUser) getSession().getAttribute("user");

		boolean r = getGenericManager().isExistCourseMember(course, su.getMember());
		System.out.println(su.getMember().getCname() + "--r=" + r + "--course=" + course.getNo());

		if (r == false) {

			courseMember.setMember(su.getMember());
			courseMember.setCourse(course);
			courseMember.setCreatedDate(Tools.getCurrentTimestamp());
			courseMember.setLastModifiedDate(Tools.getCurrentTimestamp());
			getGenericManager().saveCourseMember(courseMember);
			appendXworkParam("msg=1");
		} else {
			appendXworkParam("msg=2");
		}

		appendXworkParam("course.id=" + course.getId());
		return SUCCESS;
	}

	public String save() {
		log.info("entering 'save' method");
		java.sql.Timestamp ts = Tools.getCurrentTimestamp();
		if (course.getId() == null) {
			course.setCreatedDate(ts);
		}
		course.setLastModifiedDate(ts);
		getGenericManager().saveCourse(course);
		saveFileToLocal(fileCoursefileFileName, fileCoursefile, getTextWithArgs("course.uploadFile.dir"), course.getId());
		saveFileToLocal(fileEmailfileFileName, fileEmailfile, getTextWithArgs("course.uploadEmailfile.dir"), course.getId());

		return SUCCESS;
	}

	public String list() {
		return SUCCESS;
	}

	public Member getMemberCookies() {
		String memberId = getCookies("memberId");
		if (memberId == null) {
			// System.out.println("memberId==null");
			return null;
		} else {
			// System.out.println("memberId!=null");
			member = getGenericManager().getMemberById(Long.parseLong(memberId));
			return member;
		}

	}

	public Course getLastCourse() {
		if (course1.getId() != null) {
			System.out.println("course1.getId() != null");
			return getGenericManager().getCourseById(course1.getId());
		} else {
			System.out.println("course1.getId() == null");
			type = getGenericManager().getAppPropertyById(type.getId());
			return getGenericManager().getLastCourse(type);
		}
	}

	public List<Course> getCourseTypeList() {
		type = getGenericManager().getAppPropertyById(type.getId());
		return getGenericManager().getCourseTypeList(type);
	}

	public Course getCourseById(Long id) {
		System.out.println("getCourseById...id=" + id);
		return getGenericManager().getCourseById(id);
	}

	public Course getCourseById() {
		System.out.println("getCourseById...course.getId()=" + course.getId());
		return getGenericManager().getCourseById(course.getId());
	}

	public Set getPhotosList() {
		Set<UploadedFile> photos = new HashSet();
		Set s = course.getPhotos();
		if (s != null) {
			return s;
		} else {
			return photos;
		}
	}

	protected void beanToForm() {
		log.info("enter beanToForm()");
		registerBegin = Tools.dateToString(course.getRegisterBegin());
		registerEnd = Tools.dateToString(course.getRegisterEnd());
		noteDate1 = Tools.dateToString(course.getNoteDate1());
		noteDate2 = Tools.dateToString(course.getNoteDate2());
		noteDate3 = Tools.dateToString(course.getNoteDate3());
		noteDate4 = Tools.dateToString(course.getNoteDate4());
		filegroupsIds = getGenericManager().getIdsFromGroupList(course.getFilegroups());
		log.info("exit beanToForm()");
	}

	protected void formToBean() {
		log.info("enter formToBean()");
		course.setRegisterBegin(Tools.convertToDate(registerBegin));
		course.setRegisterEnd(Tools.convertToDate(registerEnd));
		course.setNoteDate1(Tools.convertToDate(noteDate1));
		course.setNoteDate2(Tools.convertToDate(noteDate2));
		course.setNoteDate3(Tools.convertToDate(noteDate3));
		course.setNoteDate4(Tools.convertToDate(noteDate4));
		course.setFilegroups(getGenericManager().getGroupListByIds1(filegroupsIds));
		course.setType(getGenericManager().getAppPropertyById(course.getTypeId()));
		if (getRemoveCoursefile() != null && getRemoveCoursefile().length() > 0) {
			course.setCoursefile(computeUploadedFile(fileCoursefileFileName, fileCoursefile));
			removeUploadedFile(getTextWithArgs("course.uploadFile.dir"), course.getCoursefileId(), course.getCoursefileFileName());
		} else {
			if (course.getCoursefileId() != null)
				course.setCoursefile(getGenericManager().getUploadedFileById(course.getCoursefileId()));
			else
				course.setCoursefile(computeUploadedFile(fileCoursefileFileName, fileCoursefile));
		}

		if (getRemoveEmailfile() != null && getRemoveEmailfile().length() > 0) {
			course.setEmailfile(computeUploadedFile(fileEmailfileFileName, fileEmailfile));
			removeUploadedFile(getTextWithArgs("course.uploadEmailfile.dir"), course.getEmailfileId(), course.getEmailfileFileName());
		} else {
			if (course.getEmailfileId() != null)
				course.setEmailfile(getGenericManager().getUploadedFileById(course.getEmailfileId()));
			else
				course.setEmailfile(computeUploadedFile(fileEmailfileFileName, fileEmailfile));
		}

		course.setPhotos(getGenericManager().getCoursePhotosByIds(photosIds));

	}

	public void setRegisterBegin(String val) {
		registerBegin = val;
	}

	public String getRegisterBegin() {
		return registerBegin;
	}

	public void setRegisterEnd(String val) {
		registerEnd = val;
	}

	public String getRegisterEnd() {
		return registerEnd;
	}

	public void setNoteDate1(String val) {
		noteDate1 = val;
	}

	public String getNoteDate1() {
		return noteDate1;
	}

	public void setNoteDate2(String val) {
		noteDate2 = val;
	}

	public String getNoteDate2() {
		return noteDate2;
	}

	public void setNoteDate3(String val) {
		noteDate3 = val;
	}

	public String getNoteDate3() {
		return noteDate3;
	}

	public void setNoteDate4(String val) {
		noteDate4 = val;
	}

	public String getNoteDate4() {
		return noteDate4;
	}

	public List<Group> getFilegroupsList() {
		return getGenericManager().getGroupList();
	}

	public void setFilegroupsIds(Long[] val) {
		filegroupsIds = val;
	}

	public Long[] getFilegroupsIds() {
		return filegroupsIds;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getRegisterUrl() {
		return registerUrl;
	}

	public void setRegisterUrl(String registerUrl) {
		this.registerUrl = registerUrl;
	}

	public List<Course> getCourseList() {
		try {
			System.out.println("course.getTypeId()=" + course.getTypeId());
			if (course.getTypeId() == null) {
				return getGenericManager().getCourseList();
			} else {
				type = getGenericManager().getAppPropertyById(course.getTypeId());
				return getGenericManager().getCourseTypeList(type);
			}
		} catch (Exception e) {
			return getGenericManager().getCourseList();
		}
	}

	public boolean getRegistrAble() {
		Date now = new Date();
		if (course.getRegisterBegin().before(now) && course.getRegisterEnd().after(now)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean getCancelAble() {
		SessionUser su = getSessionUser();
		boolean b = getGenericManager().isExistCourseMember(course, su.getMember());
		if (b && getRegistrAble()) {
			registerUrl = "cancelRegister";
			return true;
		} else {
			registerUrl = "saveRegister";
			return false;
		}

	}

	public boolean getDownloadAuthority() {
		int j = 0;
		SessionUser su = (SessionUser) getSession().getAttribute("user");
		List ls = course.getFilegroups();
		for (int i = 0; i < ls.size(); i++) {
			Group g = (Group) ls.get(i);
			if (checkGroup(su, g.getGroupKey())) {
				j++;
			}
		}
		if (j == 0) {
			return false;
		} else {
			return true;
		}
	}

	public void export() {
		String sql = " select 中文姓名=cname,英文姓名=ename,住家電話=homePhone,email,手機=cellphone,住家地址=homeAddress " + " from WEB_CourseMember a,dbo.COM_Member b where a.member=b.id and course=" + course.getId();
		System.out.println(sql);
		getGenericManager().exportExcel(sql, course.getId() + ".xls");
	}

	public List<CourseMember> getCourseRegisterList() {
		List<CourseMember> ls = new ArrayList<CourseMember>();
		course = getGenericManager().getCourseById(course.getId());
		System.out.println("course.getId()=" + course.getId());
		export();
		return getGenericManager().getCourseMemberListByCourse(course);
	}

	public String cancel() {
		SessionUser su = getSessionUser();
		getGenericManager().deleteCourseMember(course, su.getMember());
		appendXworkParam("course.id=" + course.getId());
		return SUCCESS;
	}

	public void setFileCoursefile(java.io.File val) {
		fileCoursefile = val;
	}

	public java.io.File getFileCoursefile() {
		return fileCoursefile;
	}

	public void setFileCoursefileContentType(String val) {
		fileCoursefileContentType = val;
	}

	public String getFileCoursefileContentType() {
		return fileCoursefileContentType;
	}

	public void setFileCoursefileFileName(String val) {
		fileCoursefileFileName = val;
	}

	public String getFileCoursefileFileName() {
		return fileCoursefileFileName;
	}

	public void setRemoveCoursefile(String val) {
		removeCoursefile = val;
	}

	public String getRemoveCoursefile() {
		return removeCoursefile;
	}

	public void setFileEmailfile(java.io.File val) {
		fileEmailfile = val;
	}

	public java.io.File getFileEmailfile() {
		return fileEmailfile;
	}

	public void setFileEmailfileContentType(String val) {
		fileEmailfileContentType = val;
	}

	public String getFileEmailfileContentType() {
		return fileEmailfileContentType;
	}

	public void setFileEmailfileFileName(String val) {
		fileEmailfileFileName = val;
	}

	public String getFileEmailfileFileName() {
		return fileEmailfileFileName;
	}

	public void setRemoveEmailfile(String val) {
		removeEmailfile = val;
	}

	public String getRemoveEmailfile() {
		return removeEmailfile;
	}

	public AppProperty getType() {
		return type;
	}

	public void setType(AppProperty type) {
		this.type = type;
	}

	public Long[] getPhotosIds() {
		return photosIds;
	}

	public void setPhotosIds(Long[] photosIds) {
		this.photosIds = photosIds;
	}

	public Course getCourse1() {
		return course1;
	}

	public void setCourse1(Course course1) {
		this.course1 = course1;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UploadedFile getPhoto() {
		return photo;
	}

	public void setPhoto(UploadedFile photo) {
		this.photo = photo;
	}

	public String loginx() {
		if (cellphone.equals("") || email.equals("")) {
			System.out.println("cellphone & email ==null ");
			appendXworkParam("msg=2");
			return INPUT;
		}

		Member user = getGenericManager().getMemberByEmailAndCellphone(email.trim(), cellphone.trim());

		if (user == null) {
			// 如果找不到這個user登入失敗
			System.out.println("找不到這個user登入失敗");
			appendXworkParam("course.id=" + course.getId());
			appendXworkParam("msg=2");
			return INPUT;
		} else {
			System.out.println(user.getCname() + " 登入成功!!");
			try {
				Cookie memberId = new Cookie("memberId", String.valueOf(user.getId()));
				Cookie membername = new Cookie("membername", URLEncoder.encode(user.getCname(), "UTF-8"));

				memberId.setMaxAge(Integer.MAX_VALUE);
				membername.setMaxAge(Integer.MAX_VALUE);

				HttpServletResponse response = getHttpServletResponse();
				response.addCookie(memberId);
				response.addCookie(membername);
				getSession().setAttribute("user", copyToSessionUser(user)); // 成功登入

				// 直接報名
				try {
					course = getGenericManager().getCourseById(course.getId());
					member = getSessionUser().getMember();
					System.out.println("course.no=" + course.getNo());

					courseMember = getGenericManager().getCourseMember(course, member);
					if (courseMember == null) {
						System.out.println("courseMember==null");
						courseMember = new CourseMember();
						courseMember.setCourse(course);
						courseMember.setMember(member);
						courseMember.setCreatedDate(Tools.getCurrentTimestamp());
						courseMember.setLastModifiedDate(Tools.getCurrentTimestamp());
						getGenericManager().saveCourseMember(courseMember);
					}

				} catch (Exception e) {
					System.out.println("saveCourseUserJSON=" + e.toString());
				}
				appendXworkParam("course.id=" + course.getId());
			} catch (Exception e) {
				System.out.println("loginx error=" + e.toString());
			}
			return SUCCESS;
		}

	}

	public String removeCoursePhotoJSON() throws Exception {
		JSONObject jo = new JSONObject();
		System.out.println("removeCoursePhotoJSON course.id=" + course.getId() + "---photo.id=" + photo.getId());
		course = getGenericManager().getCourseById(course.getId());
		photo = getGenericManager().getUploadedFileById(photo.getId());
		Set<UploadedFile> photos = new HashSet();
		Set ps = course.getPhotos();
		if (ps != null) {
			Iterator i = course.getPhotos().iterator();
			while (i.hasNext()) {
				UploadedFile g = (UploadedFile) i.next();
				if (g.getId().longValue() != photo.getId().longValue()) {
					photos.add(g);
				}
			}
		}
		course.setPhotos(photos);
		getGenericManager().saveCourse(course);
		jo.put("returnValue", true);
		return jo.toString();
	}
}
