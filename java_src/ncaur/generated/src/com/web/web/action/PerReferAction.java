package com.web.web.action;

import com.web.value.PerRefer;
import com.web.service.PerReferManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public class PerReferAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private PerRefer perRefer;
    private Long[] selectedPerReferIds;

    public PerReferAction()
    {
        log = LogFactory.getLog(com.web.web.action.PerReferAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("PERREFER");
    }

    public PerRefer getPerRefer()
    {
        return perRefer;
    }

    public void setPerRefer(PerRefer val)
    {
        perRefer = val;
    }

    public void setGenericManager(PerReferManager m)
    {
        super.setGenericManager(m);
    }

    public PerReferManager getGenericManager()
    {
        return (PerReferManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removePerRefer(perRefer.getId());
        return DELETE;
    }

    public String edit()
    {
        if (perRefer == null) {
            perRefer = new PerRefer();
        } else if (perRefer.getId() != null) {
            perRefer = getGenericManager().getPerReferById(perRefer.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedPerReferIds != null && selectedPerReferIds.length > 0) {
            PerRefer obj = getGenericManager().getPerReferById(selectedPerReferIds[0]);
            obj.setId(null);
            perRefer = obj;
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
            if (inputValidation(perRefer) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(PerRefer val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().savePerRefer(perRefer);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        perRefer.setType(getAppPropertyById(perRefer.getTypeId())); 
        perRefer.setQatype(getAppPropertyById(perRefer.getQatypeId())); 
        perRefer.setTeacher(getGenericManager().getMemberById(perRefer.getTeacherId())); 
        log.info("exit formToBean()");
    }
    public List<AppProperty> getTypeList()
    {
        return super.getAppPropertyList("perRefer.type");
    }

    public List<AppProperty> getQatypeList()
    {
        return super.getAppPropertyList("perRefer.qatype");
    }

    public List<Member> getTeacherList()
    {
        return getGenericManager().getTeacherList(); // TODO
    }

    public List<PerRefer> getPerReferList()
    {
        return getGenericManager().getPerReferList();
    }

    public void setSelectedPerReferIds(Long[] val)
    {
        selectedPerReferIds = val;
    }

    public Long[] getSelectedPerReferIds()
    {
        return selectedPerReferIds;
    }
}
