package com.city.service.impl;

import com.base.value.AppProperty;
import com.city.service.CityManager;
import com.city.dao.*;
import com.city.value.*;

import java.util.*;

import com.common.service.impl.CommonManagerImpl;
import com.common.value.Member;

public class CityManagerImpl extends CommonManagerImpl implements CityManager {

	public CityManagerImpl() {
	}

	public CityDAO getGenericDAO() {
		return (CityDAO) super.getGenericDAO();
	}

	public void setGenericDAO(CityDAO dao) {
		super.setGenericDAO(dao);
	}

	// Course
	public void saveCourse(Course val) {
		getGenericDAO().saveCourse(val);
	}

	public void removeCourse(Course val) {
		getGenericDAO().removeCourse(val);
	}

	public void removeCourse(Long id) {
		getGenericDAO().removeCourse(id);
	}

	public Course getCourseById(Long id) {
		return getGenericDAO().findCourseById(id);
	}

	public List<Course> getCourseList() {
		return getGenericDAO().findAllCourse();
	}

	public List<CourseMember> getCourseMemberListByCourse(Course course) {
		return getGenericDAO().getCourseMemberListByCourse(course);
	}

	public CourseMember getCourseMember(Course course, Member member) {
		return getGenericDAO().getCourseMember(course, member);
	}

	public boolean isExistCourseMember(Course course, Member member) {
		return getGenericDAO().isExistCourseMember(course, member);
	}

	public void deleteCourseMember(Course course, Member member) {
		getGenericDAO().deleteCourseMember(course, member);
	}

	public Course getLastCourse(AppProperty type) {
		return getGenericDAO().getLastCourse(type);
	}

	public List<Course> getCourseTypeList(AppProperty type) {
		return getGenericDAO().getCourseTypeList(type);
	}

	public Set getCoursePhotosByIds(Long[] ids) {
		return getGenericDAO().getCoursePhotosByIds(ids);
	}

	// CourseMember

	public void saveCourseMember(CourseMember val) {
		getGenericDAO().saveCourseMember(val);
	}

	public void removeCourseMember(CourseMember val) {
		getGenericDAO().removeCourseMember(val);
	}

	public void removeCourseMember(Long id) {
		getGenericDAO().removeCourseMember(id);
	}

	public CourseMember getCourseMemberById(Long id) {
		return getGenericDAO().findCourseMemberById(id);
	}

	public List<CourseMember> getCourseMemberList() {
		return getGenericDAO().findAllCourseMember();
	}

	public List<CourseMember> getCourseMemberListByMember(Member member) {
		return getGenericDAO().getCourseMemberListByMember(member);
	}

}
