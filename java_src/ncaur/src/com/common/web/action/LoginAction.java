package com.common.web.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.opensymphony.xwork.ActionContext;
import com.base.value.BaseObject;
import com.base.value.SessionUser;
import com.common.service.CommonManager;
import com.common.value.*;
import com.opensymphony.webwork.config.Configuration;
import com.opensymphony.xwork.util.LocalizedTextUtil;
import com.common.mail.*;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.base.value.*;
import com.common.web.*;

public class LoginAction extends CommonActionSupport {
	private static final long serialVersionUID = 100L;
	private final Log log;
	private String cellphone, idNo, msg, email;

	public LoginAction() {
		log = LogFactory.getLog(com.common.web.action.LoginAction.class);
	}

	public void setGenericManager(CommonManager m) {
		super.setGenericManager(m);
	}

	public CommonManager getGenericManager() {
		return (CommonManager) super.getGenericManager();
	}

	public String logout() {
		super.getSession().removeAttribute("user"); // .remove(AuthenticationInterceptor.USER);
		super.getSession().invalidate();
		log.info("exit 'logout' method");
		return SUCCESS;
	}
	
	
	public String logout1() {
		//super.getSession().removeAttribute("user"); // .remove(AuthenticationInterceptor.USER);
		//super.getSession().invalidate();
		System.out.println("logout1...");
		Cookie cookie = new Cookie("membername", null);
		cookie.setMaxAge(0);		
		getHttpServletResponse().addCookie(cookie);
		
		Cookie cookie1 = new Cookie("memberId", null);
		cookie1.setMaxAge(0);		
		getHttpServletResponse().addCookie(cookie1);
		
		return SUCCESS;
	}

	public String save() {
		log.info("entering 'execute' method");
		return SUCCESS;
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
			//System.out.println("找不到這個user登入失敗");
			appendXworkParam("msg=2");
			return INPUT;
		} else {
			//System.out.println(user.getCname() + " 登入成功!!");
			try {
				Cookie memberId = new Cookie("memberId", String.valueOf(user.getId()));
				Cookie membername = new Cookie("membername", URLEncoder.encode(user.getCname(), "UTF-8"));

				memberId.setMaxAge(Integer.MAX_VALUE);
				membername.setMaxAge(Integer.MAX_VALUE);

				HttpServletResponse response = getHttpServletResponse();
				response.addCookie(memberId);
				response.addCookie(membername);
				getSession().setAttribute("user", copyToSessionUser(user)); // 成功登入

			} catch (Exception e) {
				System.out.println("loginx error=" + e.toString());
			}
			return SUCCESS;
		}

	}

	public String execute() {
		if (cellphone == null || idNo == null) {
			appendXworkParam("msg=2");
			return INPUT;
		}
		Member user = getGenericManager().getMemberByLoginIdAndPassword(cellphone, idNo);
		if (user == null) {
			// 如果找不到這個user登入失敗
			//System.out.println("如果找不到這個user登入失敗");
			appendXworkParam("msg=2");
			return INPUT;
		} else {
			//System.out.println(user.getCname() + " 登入成功!!    getLocal()=" + getLocal());
			getSession().setAttribute("user", copyToSessionUser(user)); // 成功登入
			return SUCCESS;
		}
	}

	public String list() {
		return SUCCESS;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}