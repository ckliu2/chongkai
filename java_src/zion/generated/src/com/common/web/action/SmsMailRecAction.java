package com.common.web.action;

import com.common.value.SmsMailRec;
import com.common.service.SmsMailRecManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 18 16:53:07 CST 2014
*/

public class SmsMailRecAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private SmsMailRec smsMailRec;
    private String sendDate;
    private Long[] selectedSmsMailRecIds;

    public SmsMailRecAction()
    {
        log = LogFactory.getLog(com.common.web.action.SmsMailRecAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("SMSMAILREC");
    }

    public SmsMailRec getSmsMailRec()
    {
        return smsMailRec;
    }

    public void setSmsMailRec(SmsMailRec val)
    {
        smsMailRec = val;
    }

    public void setGenericManager(SmsMailRecManager m)
    {
        super.setGenericManager(m);
    }

    public SmsMailRecManager getGenericManager()
    {
        return (SmsMailRecManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeSmsMailRec(smsMailRec.getId());
        return DELETE;
    }

    public String edit()
    {
        if (smsMailRec == null) {
            smsMailRec = new SmsMailRec();
        } else if (smsMailRec.getId() != null) {
            smsMailRec = getGenericManager().getSmsMailRecById(smsMailRec.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedSmsMailRecIds != null && selectedSmsMailRecIds.length > 0) {
            SmsMailRec obj = getGenericManager().getSmsMailRecById(selectedSmsMailRecIds[0]);
            obj.setId(null);
            smsMailRec = obj;
        }
        beanToForm();

        return SUCCESS;
    }

    public String execute()
    {
        log.info("entering 'execute' method");
        if (getDelete() != null) {
            return delete();
        } else {
            formToBean();
            if (inputValidation(smsMailRec) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(SmsMailRec val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveSmsMailRec(smsMailRec);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        sendDate = Tools.dateToString(smsMailRec.getSendDate());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        smsMailRec.setSendDate(Tools.convertToDate(sendDate)); 
        smsMailRec.setTarget(getGenericManager().getMemberById(smsMailRec.getTargetId())); 
        smsMailRec.setMember(getGenericManager().getMemberById(smsMailRec.getMemberId())); 
        log.info("exit formToBean()");
    }
    public void setSendDate(String val)
    {
        sendDate = val;
    }

    public String getSendDate()
    {
        return sendDate;
    }

    public List<Member> getTargetList()
    {
        return getGenericManager().getTargetList(); // TODO
    }

    public List<Member> getMemberList()
    {
        return getGenericManager().getMemberList(); // TODO
    }

    public List<SmsMailRec> getSmsMailRecList()
    {
        return getGenericManager().getSmsMailRecList();
    }

    public void setSelectedSmsMailRecIds(Long[] val)
    {
        selectedSmsMailRecIds = val;
    }

    public Long[] getSelectedSmsMailRecIds()
    {
        return selectedSmsMailRecIds;
    }
}
