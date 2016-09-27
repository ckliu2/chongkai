package com.common.web.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;

import com.base.util.Tools;
import com.base.value.BaseObject;
import com.base.value.SessionUser;
import com.common.service.CommonManager;
import com.common.value.Member;
import com.opensymphony.webwork.config.Configuration;
import com.opensymphony.xwork.util.LocalizedTextUtil;

import java.net.URLEncoder;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.base.value.Group;

public class LoginAction extends CommonActionSupport {
    private static final long serialVersionUID = 100L;
    private final Log log;
    private String cellphone;
    private String msg;

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
	log.info("entering 'logout' method");
	super.getSession().removeAttribute("user"); // .remove(AuthenticationInterceptor.USER);
	super.getSession().invalidate();
	log.info("exit 'logout' method");
	return SUCCESS;
    }

    public String save() {
	log.info("entering 'execute' method");

	return SUCCESS;
    }

    public String execute() {

	if (cellphone == null) {
	    appendXworkParam("msg=2");
	    return INPUT;
	}

	Member user = getGenericManager().getMemberByCellphone(cellphone);

	if (user == null) {
	    // 如果找不到這個user登入失敗
	    System.out.println("如果找不到這個user登入失敗");
	    appendXworkParam("msg=2");
	    return INPUT;
	} else {
	    System.out.println(" 登入成功!!    getLocal()=" + getLocal());
	    getSession().setAttribute("user", copyToSessionUser(user)); // 成功登入
	    return SUCCESS;
	}
    }

    public String getCellphone() {
	return cellphone;
    }

    public void setCellphone(String cellphone) {
	this.cellphone = cellphone;
    }

    public JSONObject userlogin() {
	System.out.println("userlogin cellphone=" + cellphone);
	JSONObject p = new JSONObject();
	try {
	    Member member = getGenericManager().getMemberByCellphone(cellphone);
	    if (member != null) {
		Cookie memberId = new Cookie("memberId", String.valueOf(member
			.getId()));
		
		Cookie membername = new Cookie("membername", URLEncoder.encode(member.getName(), "UTF-8"));
		Cookie email = new Cookie("email", member.getEmail());
		Cookie lastVisited = new Cookie("lastVisited",
			String.valueOf(Tools.getCurrentTimestamp()));

		memberId.setMaxAge(Integer.MAX_VALUE);
		email.setMaxAge(Integer.MAX_VALUE);
		membername.setMaxAge(Integer.MAX_VALUE);
		lastVisited.setMaxAge(Integer.MAX_VALUE);
		HttpServletResponse response = getHttpServletResponse();
		response.addCookie(memberId);
		response.addCookie(lastVisited);
		response.addCookie(membername);
		response.addCookie(email);
		
		p.accumulate("returnValue", "login-success");

	    } else {
		p.accumulate("returnValue", "login-fail");
	    }

	} catch (Exception e) {
	    System.out.println("userlogin=" + e.toString());
	}
	return p;
    }

    public String list() {
	return SUCCESS;
    }

    public String getMsg() {
	return msg;
    }

    public void setMsg(String msg) {
	this.msg = msg;
    }

}