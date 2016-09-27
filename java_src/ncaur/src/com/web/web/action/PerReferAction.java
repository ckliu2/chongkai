package com.web.web.action;

import com.web.value.*;
import com.web.service.WebManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;

import java.util.*;

import com.common.value.Member;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.*;

public class PerReferAction extends CommonActionSupport {

	private static final long serialVersionUID = 1L;
	private final Log log;
	private PerRefer perRefer, perRefer1;
	private Long[] selectedPerReferIds;
	Member member;

	public PerReferAction() {
		log = LogFactory.getLog(com.web.web.action.PerReferAction.class);
	}

	public Function getFunction() {
		return getGenericManager().getFunctionByKey("PERREFER");
	}

	public PerRefer getPerRefer() {
		return perRefer;
	}

	public void setPerRefer(PerRefer val) {
		perRefer = val;
	}

	public void setGenericManager(WebManager m) {
		super.setGenericManager(m);
	}

	public WebManager getGenericManager() {
		return (WebManager) super.getGenericManager();
	}

	public String delete() {
		getGenericManager().removePerRefer(perRefer.getId());
		return DELETE;
	}

	public String edit() {
		if (perRefer == null) {
			perRefer = new PerRefer();
		} else if (perRefer.getId() != null) {
			perRefer = getGenericManager().getPerReferById(perRefer.getId());
		} else { // TODO
		}
		beanToForm();

		return SUCCESS;
	}

	public String copy() {
		if (selectedPerReferIds != null && selectedPerReferIds.length > 0) {
			PerRefer obj = getGenericManager().getPerReferById(selectedPerReferIds[0]);
			obj.setId(null);
			perRefer = obj;
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
			if (inputValidation(perRefer) == false)
				return INPUT;
		}
		return SUCCESS;
	}

	public boolean inputValidation(PerRefer val) {
		return true;
	}

	public String save1() {
		System.out.println("save1=" + perRefer.getName());

		perRefer1 = new PerRefer();
		perRefer1.setName(perRefer.getName());
		perRefer1.setEmail(perRefer.getEmail());
		perRefer1.setCellphone(perRefer.getCellphone());
		perRefer1.setPhone(perRefer.getPhone());
		perRefer1.setMemo(perRefer.getMemo());
		perRefer1.setCreatedDate(Tools.getCurrentTimestamp());
		perRefer1.setQatype(getGenericManager().getAppPropertyById(perRefer.getQatypeId()));
		
		
		getGenericManager().savePerRefer(perRefer1);

		return SUCCESS;
	}

	public String save() {
		if (perRefer.getId() == null) {
			perRefer.setCreatedDate(Tools.getCurrentTimestamp());
		}
		getGenericManager().savePerRefer(perRefer);
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
		perRefer.setType(getAppPropertyById(perRefer.getTypeId()));
		perRefer.setTeacher(getGenericManager().getMemberById(perRefer.getTeacherId()));
		log.info("exit formToBean()");
	}

	public List<AppProperty> getTypeList() {
		return super.getAppPropertyList("perRefer.type");
	}

	public List<Member> getTeacherList() {
		Group group = getGenericManager().getGroupByGroupKey("Teacher");
		List<Member> al = new ArrayList<Member>();
		Set s = group.getMembers();
		if (s != null) {
			Iterator i = s.iterator();
			while (i.hasNext()) {
				Member m = (Member) i.next();
				al.add(m);
			}
		}
		return al;
	}

	public String peferNoteJSON() {
		System.out.println("peferNoteJSON...");
		JSONObject jo = new JSONObject();
		try {
			perRefer = getGenericManager().getPerReferById(perRefer.getId());
			member = perRefer.getTeacher();
			if (member != null) {
				String subject = "專業諮詢提問[中華都更]";
				
				String body = "提問人姓名：" + perRefer.getName() + "<br>" + "email：" + perRefer.getEmail() + "<br>" + "電話：" + perRefer.getPhone() + "<br>" + "手機：" + perRefer.getCellphone() + "<br>" + "備註：" + perRefer.getMemo() + "<br>" + "問題分類："
						+ ((perRefer.getType() == null) ? "" : perRefer.getType().getValueTw()) + "<br>" + "提問時間：" + perRefer.getCreatedDate() + "<br>";
				
				System.out.println("email="+member.getEmail());
				System.out.println("subject="+subject);
				System.out.println("body"+body);
				perRefer.setNote(true);
				getGenericManager().savePerRefer(perRefer);
				getGenericManager().sendMail(member.getEmail(), subject, body);
				jo.put("returnValue", "success");
			} else {
				jo.put("returnValue", "fail");
			}
		} catch (Exception e) {
			System.out.println("peferNoteJSON error=" + e.toString());
		}
		return jo.toString();
	}

	public List<PerRefer> getPerReferList() {
		return getGenericManager().getPerReferList();
	}

	public void setSelectedPerReferIds(Long[] val) {
		selectedPerReferIds = val;
	}

	public Long[] getSelectedPerReferIds() {
		return selectedPerReferIds;
	}
}
