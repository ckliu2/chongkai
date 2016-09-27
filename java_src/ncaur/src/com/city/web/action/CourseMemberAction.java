package com.city.web.action;

import com.city.value.*;
import com.city.service.CityManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.*;

import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

public class CourseMemberAction extends CommonActionSupport {

	private static final long serialVersionUID = 1L;
	private final Log log;
	private CourseMember courseMember;
	Course course;

	public CourseMemberAction() {
		log = LogFactory.getLog(com.city.web.action.CourseMemberAction.class);
	}

	public Function getFunction() {
		return getGenericManager().getFunctionByKey("COURSEMEMBER");
	}

	public void setGenericManager(CityManager m) {
		super.setGenericManager(m);
	}

	public CityManager getGenericManager() {
		return (CityManager) super.getGenericManager();
	}

	public String delete() {
		System.out.println(courseMember.getId());
		getGenericManager().removeCourseMember(courseMember.getId());
		appendXworkParam("course.id=" + course.getId());
		return DELETE;
	}

	public String edit() {
		if (courseMember == null) {
			courseMember = new CourseMember();
		} else if (courseMember.getId() != null) {
			courseMember = getGenericManager().getCourseMemberById(courseMember.getId());
		} else { // TODO
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
			if (inputValidation(courseMember) == false)
				return INPUT;
		}
		return SUCCESS;
	}

	public boolean inputValidation(CourseMember val) {
		return true;
	}

	public String save() {
		log.info("entering 'save' method");
		java.sql.Timestamp ts = Tools.getCurrentTimestamp();
		if (courseMember.getId() == null) {
			courseMember.setCreatedDate(ts);
		}
		courseMember.setLastModifiedDate(ts);
		getGenericManager().saveCourseMember(courseMember);
		return SUCCESS;
	}

	public String list() {
		return SUCCESS;
	}

	protected void beanToForm() {
		log.info("enter beanToForm()");
		log.info("exit beanToForm()");
	}

	protected void formToBean() {
		log.info("enter formToBean()");
		courseMember.setCourse(getGenericManager().getCourseById(courseMember.getCourseId()));
		courseMember.setMember(getGenericManager().getMemberById(courseMember.getMemberId()));
		log.info("exit formToBean()");
	}

	public List<Course> getCourseList() {
		return getGenericManager().getCourseList(); // TODO
	}

	public List<CourseMember> getCourseMemberList() {
		return getGenericManager().getCourseMemberList();
	}

	

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public CourseMember getCourseMember() {
		return courseMember;
	}

	public void setCourseMember(CourseMember courseMember) {
		this.courseMember = courseMember;
	}
}
