package com.web.web.action;

import com.web.value.*;
import com.web.service.WebManager;
import com.city.service.CityManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.*;

import com.city.value.Course;
import com.city.value.CourseMember;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.*;
import com.common.value.*;

public class WebSiteAction extends CommonActionSupport {

	private static final long serialVersionUID = 1L;
	private final Log log;
	private Links links;
	private Long[] selectedLinksIds;
	private WebSite website;
	private Member member;
	private Long menuId, subMenuId, subItemId, memberId;
	Menu menu;
	SubMenu submenu;
	SubItem subitem;
	private String subject;
	private Date begindate, enddate;
	private Long bulletinTypeId, bulletinId, id;
	private AppProperty bulletinType;
	private Member loginUser;
	private Course course;
	CourseMember courseMember;

	public WebSiteAction() {
		log = LogFactory.getLog(com.web.web.action.WebSiteAction.class);
	}

	public void setGenericManager(WebManager m) {
		super.setGenericManager(m);
	}

	public WebManager getGenericManager() {
		return (WebManager) super.getGenericManager();
	}

	public List<Menu> getMenuList() {
		return getGenericManager().getMenuList();
	}

	public List<SubMenu> getSubMenuByMenu(Long id) {

		return getGenericManager().getSubMenuByMenu(id);
	}

	public List<SubItem> getSubItemBySubMenu(Long id) {

		return getGenericManager().getSubItemBySubMenu(id);
	}

	public List<Links> getLinksList() {

		return getGenericManager().getLinksList();
	}

	public SubMenu getSubMenuById(Long id) {
		return getGenericManager().getSubMenuById(id);
	}

	public SubItem getSubItemById(Long id) {
		return getGenericManager().getSubItemById(id);
	}

	public String list() {
		try {
			loginUser = getSessionUser().getMember();
		} catch (Exception e) {
			System.out.println("loginUser error!");
		}
		return SUCCESS;
	}

	public List<Bulletin> getBulletinList() {
		// System.out.println("subject="+subject+"  beginbDate="+begindate+"   enddate="+enddate);
		if (subject != null || begindate != null || enddate != null || bulletinTypeId != null) {
			AppProperty bulletinType = getGenericManager().getAppPropertyById(bulletinTypeId);
			return getGenericManager().getQueryBulletinList(bulletinType, subject, begindate, enddate);
		} else {
			return getGenericManager().getBulletinList();
		}
	}

	public List<SubMenu> getSubMenuListByMenu(Long id) {
		return getGenericManager().getSubMenuByMenu(id);
	}

	public BolgClass getBlogClassById(Long id) {
		return getGenericManager().getBolgClassById(id);
	}

	public List<Bolg> getBolgByBlogClass(Long id) {
		System.out.println("getBolgByBlogClass Bolg_Id=" + id);
		BolgClass b = getGenericManager().getBolgClassById(id);
		// System.out.println("BolgClass="+b.getName());
		return getGenericManager().getBolgByBlogClass(b);
	}

	public Bolg getBolgById(Long id) {
		// System.out.println("getBolgById="+id);
		Bolg bolg = getGenericManager().getBolgById(id);
		// System.out.println("bolg name="+bolg.getName());
		return bolg;
	}

	public Bulletin getBulletinById(Long id) {
		System.out.println("getBulletinById id=" + id);
		return getGenericManager().getBulletinById(id);
	}

	public boolean isEndSubMenu(Long id) {
		return getGenericManager().isEndSubMenuBySubMenuId(id);
	}

	public WebSite getWebsite() {
		return website;
	}

	public void setWebsite(WebSite website) {
		this.website = website;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public Long getSubMenuId() {
		return subMenuId;
	}

	public void setSubMenuId(Long subMenuId) {
		this.subMenuId = subMenuId;
	}

	public Long getSubItemId() {
		return subItemId;
	}

	public void setSubItemId(Long subItemId) {
		this.subItemId = subItemId;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public SubMenu getSubmenu() {
		return submenu;
	}

	public void setSubmenu(SubMenu submenu) {
		this.submenu = submenu;
	}

	public SubItem getSubitem() {
		return subitem;
	}

	public void setSubitem(SubItem subitem) {
		this.subitem = subitem;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getBegindate() {
		return begindate;
	}

	public void setBegindate(Date begindate) {
		this.begindate = begindate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Long getBulletinTypeId() {
		return bulletinTypeId;
	}

	public void setBulletinTypeId(Long bulletinTypeId) {
		this.bulletinTypeId = bulletinTypeId;
	}

	public AppProperty getBulletinType() {
		return bulletinType;
	}

	public void setBulletinType(AppProperty bulletinType) {
		this.bulletinType = bulletinType;
	}

	public SubMenu getTopSubMenuByMenu(Long id) {
		SubMenu submenu = new SubMenu();
		List<SubMenu> s = getGenericManager().getSubMenuByMenu(id);
		if (s.size() > 0) {
			submenu = (SubMenu) s.get(0);
		}
		// System.out.println("getTopSubMenuByMenu="+submenu.getName());
		return submenu;
	}

	public boolean isBulletinSubMenuByMenu(Long id) {
		boolean rs = false;
		List<SubMenu> s = getGenericManager().getSubMenuByMenu(id);
		Menu m = getGenericManager().getMenuById(id);
		if (s.size() > 0) {
			SubMenu submenu = (SubMenu) s.get(0);
			String url = submenu.getUrl();
			if (url != null && !url.equals("")) {
				rs = true;
			}
			// System.out.println("menu="+m.getName()+"   submenu="+submenu.getName()+"   url="+url+"   isBulletinSubMenuByMenu("+id+")="+rs);
		}
		return rs;
	}

	public Bulletin getTopBulletin() {
		return getGenericManager().getTopBulletin();
	}

	public Long getBulletinId() {
		return bulletinId;
	}

	public void setBulletinId(Long bulletinId) {
		this.bulletinId = bulletinId;
	}

	public List<Bulletin> getBulletinByTopList(Long id, int top) {
		AppProperty bulletinType = getGenericManager().getAppPropertyById(id);
		System.out.println(bulletinType.getValueTw());

		List<Bulletin> a = getGenericManager().getBulletinByTopList(bulletinType, top);
		System.out.println("a.size=" + a.size());
		return a;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Member getMemberById() {
		Member m = getGenericManager().getMemberById(getMemberId());
		return m;
	}

	public Member getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(Member loginUser) {
		this.loginUser = loginUser;
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

	// course
	public List<Course> getCourseList() {
		return getGenericManager().getCourseList();
	}

	public boolean isExistCourseMember(Long courseId) {
		System.out.println("isExistCourseMember courseId=" + courseId);
		course = getGenericManager().getCourseById(courseId);
		return getGenericManager().isExistCourseMember(course, getSessionUser().getMember());
	}

	public CourseMember getCourseMember(Long courseId) {
		System.out.println("getCourseMember courseId=" + courseId);
		course = getGenericManager().getCourseById(courseId);
		return getGenericManager().getCourseMember(course, getSessionUser().getMember());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
