package com.base.web.action;

import com.base.value.MiscCode;
import com.base.service.MiscCodeManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public class MiscCodeAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private MiscCode miscCode;
    private Long[] selectedMiscCodeIds;

    public MiscCodeAction()
    {
        log = LogFactory.getLog(com.base.web.action.MiscCodeAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("MISCCODE");
    }

    public MiscCode getMiscCode()
    {
        return miscCode;
    }

    public void setMiscCode(MiscCode val)
    {
        miscCode = val;
    }

    public void setGenericManager(MiscCodeManager m)
    {
        super.setGenericManager(m);
    }

    public MiscCodeManager getGenericManager()
    {
        return (MiscCodeManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeMiscCode(miscCode.getId());
        return DELETE;
    }

    public String edit()
    {
        if (miscCode == null) {
            miscCode = new MiscCode();
        } else if (miscCode.getId() != null) {
            miscCode = getGenericManager().getMiscCodeById(miscCode.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedMiscCodeIds != null && selectedMiscCodeIds.length > 0) {
            MiscCode obj = getGenericManager().getMiscCodeById(selectedMiscCodeIds[0]);
            obj.setId(null);
            miscCode = obj;
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
            if (inputValidation(miscCode) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(MiscCode val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveMiscCode(miscCode);
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
        log.info("exit formToBean()");
    }
    public List<MiscCode> getMiscCodeList()
    {
        return getGenericManager().getMiscCodeList();
    }

    public void setSelectedMiscCodeIds(Long[] val)
    {
        selectedMiscCodeIds = val;
    }

    public Long[] getSelectedMiscCodeIds()
    {
        return selectedMiscCodeIds;
    }
}
