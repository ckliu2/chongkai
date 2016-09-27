package com.common.web.action;

import com.common.value.*;
import com.base.value.*;
import com.common.service.CommonManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Tue Jun 16 15:36:14 CST 2009
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

    public void setGenericManager(CommonManager m)
    {
        super.setGenericManager(m);
    }

    public CommonManager getGenericManager()
    {
        return (CommonManager) super.getGenericManager();
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



    public String execute()
    {
        log.info("entering 'execute' method");
        formToBean();        
        return SUCCESS;
    }

    public boolean inputValidation(SmsMailRec val)
    {
        return true;
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
    
    public List<SmsMailRec> getSmsMailRecList()
    {    
    	SessionUser s=(SessionUser)getSession().getAttribute("user");
    	Member m=getGenericManager().getMemberById(s.getId());    	
        return getGenericManager().getSmsMailRecList(m);
    }


}
