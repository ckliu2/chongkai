package com.city.dao.hibernate;

import com.base.util.MyProperties;
import com.base.util.Tools;
import com.base.value.AppProperty;
import com.base.value.UploadedFile;
import com.city.value.*;
import com.city.dao.CityDAO;

import java.util.*;

import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate.HibernateTemplate;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.common.dao.hibernate.CommonDAOHibernate;
import com.common.value.Member;
import com.opensymphony.xwork.ActionContext;

import java.sql.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CityDAOHibernate extends CommonDAOHibernate implements CityDAO {

	public CityDAOHibernate() {
	}

	// Course
	public void saveCourse(Course val) {
		getHibernateTemplate().saveOrUpdate(val);
	}

	public void removeCourse(Course val) {
		getHibernateTemplate().delete(val);
	}

	public void removeCourse(Long id) {
		Course obj = findCourseById(id);
		try {
			Connection conn = getHibernateSession().connection();
			Statement Stmt = conn.createStatement();
			String sql = "delete WEB_CourseMember where course=" + obj.getId();
			System.out.println(sql);
			Stmt.execute(sql);
			String sql1 = "delete WEB_CoursePhotos where courseId=" + obj.getId();
			System.out.println(sql1);
			Stmt.execute(sql1);
			conn.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		getHibernateTemplate().delete(obj);
	}

	public Course findCourseById(Long id) {
		if (id == null)
			return null;
		Course obj = (Course) getHibernateTemplate().get(com.city.value.Course.class, id);
		if (obj == null)
			throw new ObjectRetrievalFailureException(com.city.value.Course.class, id);
		else
			return obj;
	}

	public List<Course> findAllCourse() {
		return getHibernateTemplate().find("from Course");
	}

	public List<CourseMember> getCourseMemberListByCourse(Course course) {
		Criteria c = getHibernateSession().createCriteria(CourseMember.class);
		c.add(Expression.eq("course", course));
		c.addOrder(Order.desc("createdDate"));
		return c.list();
	}

	public boolean isExistCourseMember(Course course, Member member) {
		Criteria c = getHibernateSession().createCriteria(CourseMember.class);
		c.add(Expression.eq("course", course));
		c.add(Expression.eq("member", member));
		List result = c.list();
		if (result.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void deleteCourseMember(Course course, Member member) {
		Criteria c = getHibernateSession().createCriteria(CourseMember.class);
		c.add(Expression.eq("course", course));
		c.add(Expression.eq("member", member));
		List result = c.list();

		if (c.list().size() > 0) {
			CourseMember val = (CourseMember) c.list().get(0);

			// Email通知
			try {
				System.out.println("removeCourseMember Email通知");
				Connection conn = getHibernateSession().connection();
				Statement Stmt = conn.createStatement();
				String msg = val.getMember().getCname() + " 您好;<br>您已於" + Tools.dateToString(Tools.getCurrentTimestamp()) + "取消報名課程為『 " + val.getCourse().getCourseName() + "』 [中華都更]";
				String subject = "取消都更課程報名通知信";
				String sql = "dbo.sendMail '" + val.getMember().getEmail() + "','" + subject + "','" + msg + "'";
				System.out.println("sql=" + sql);
				Stmt.execute(sql);
				String sql1 = "delete from web_coursemember where id=" + val.getId();
				System.out.println(sql1);
				Stmt.execute(sql1);

				conn.close();
			} catch (Exception e) {
				System.out.println("email error" + e.toString());
			}
		}
	}

	public void sendMailAttachments(String email, String subject, String content, String filepath) {
		// Email通知
		try {
			System.out.println("sendMailAttachments 通知");
			Connection conn = getHibernateSession().connection();
			Statement Stmt = conn.createStatement();
			String sql = "dbo.sendMailAttachments '" + email + "','" + subject + "','" + content + "','" + filepath + "' ";
			System.out.println("sql=" + sql);
			Stmt.execute(sql);
			conn.close();
		} catch (Exception e) {
			System.out.println("email error" + e.toString());
		}

	}

	public Course getLastCourse(AppProperty type) {
		Criteria c = getHibernateSession().createCriteria(Course.class);
		c.add(Expression.eq("type", type));
		c.addOrder(Order.desc("id"));
		List result = c.list();
		if (result.size() > 0) {
			return (Course) result.get(0);
		} else {
			return null;
		}
	}

	public List<Course> getCourseTypeList(AppProperty type) {
		Criteria c = getHibernateSession().createCriteria(Course.class);
		c.add(Expression.eq("type", type));
		c.addOrder(Order.desc("id"));
		return c.list();
	}

	public Set getCoursePhotosByIds(Long[] ids) {
		Set<UploadedFile> s = new HashSet();
		if (ids != null) {
			for (int i = 0; i < ids.length; i++) {
				UploadedFile t = (UploadedFile) findUploadedFileById(ids[i]);
				if (t != null)
					s.add(t);
			}
		}
		return s;
	}

	public HttpSession getSession1() {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest req = (HttpServletRequest) ctx.get("com.opensymphony.xwork.dispatcher.HttpServletRequest");
		HttpSession session = req.getSession();
		return session;
	}

	public MyProperties getMyProperties() {
		ServletContext servletContext = getSession1().getServletContext();
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		MyProperties myProperties = (MyProperties) ctx.getBean("myProperties");
		return myProperties;
	}

	// CourseMember
	public void saveCourseMember(CourseMember val) {
		getHibernateTemplate().saveOrUpdate(getHibernateTemplate().merge(val));
		// Email通知
		try {
			Course course = val.getCourse();
			Member member = val.getMember();
			String subject = course.getCourseName();
			String content = member.getCname() + " 小姐/先生您好，<br>" + course.getEmailDescript();

			if (course.getEmailfile() != null) {
				MyProperties myProperties = getMyProperties();
				String filepath = myProperties.getCoursefilePath() + course.getId() + "\\\\" + course.getEmailfile().getFileName();
				System.out.println(filepath);
				sendMailAttachments(member.getEmail(), subject, content, filepath);
			} else {
				sendMail(member.getEmail(), subject, content);
			}
		} catch (Exception e) {
			System.out.println("email error" + e.toString());
		}
	}

	public void removeCourseMember(CourseMember val) {
		getHibernateTemplate().delete(val);
	}

	public void removeCourseMember(Long id) {
		CourseMember obj = findCourseMemberById(id);
		try {
			Connection conn = getHibernateSession().connection();
			Statement Stmt = conn.createStatement();
			String sql = "delete WEB_CourseMember where id=" + id;
			Stmt.execute(sql);

			String sql1 = "delete COM_Member where id=" + obj.getMemberId();
			Stmt.execute(sql1);

			conn.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public CourseMember findCourseMemberById(Long id) {
		if (id == null)
			return null;
		CourseMember obj = (CourseMember) getHibernateTemplate().get(com.city.value.CourseMember.class, id);
		if (obj == null)
			throw new ObjectRetrievalFailureException(com.city.value.CourseMember.class, id);
		else
			return obj;
	}

	public List<CourseMember> findAllCourseMember() {
		return getHibernateTemplate().find("from CourseMember");
	}

	public void executeSQL(String sql) {
		try {
			Connection conn = getHibernateSession().connection();
			Statement Stmt = conn.createStatement();
			Stmt.execute(sql);
			conn.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public CourseMember getCourseMember(Course course, Member member) {
		Criteria c = getHibernateSession().createCriteria(CourseMember.class);
		c.add(Expression.eq("course", course));
		c.add(Expression.eq("member", member));
		List result = c.list();
		if (result.size() > 0) {
			return (CourseMember) result.get(0);
		} else {
			return null;
		}
	}

	public List<CourseMember> getCourseMemberListByMember(Member member) {
		Criteria c = getHibernateSession().createCriteria(CourseMember.class);		
		c.add(Expression.eq("member", member));
		return c.list();
	}

}
