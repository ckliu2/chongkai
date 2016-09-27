package org.zion.web.action;

import org.zion.value.SundayInfor;
import org.zion.service.SundayInforManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public class SundayInforAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private SundayInfor sundayInfor;
    private String messageDate;
    private Long[] selectedSundayInforIds;

    public SundayInforAction()
    {
        log = LogFactory.getLog(org.zion.web.action.SundayInforAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("SUNDAYINFOR");
    }

    public SundayInfor getSundayInfor()
    {
        return sundayInfor;
    }

    public void setSundayInfor(SundayInfor val)
    {
        sundayInfor = val;
    }

    public void setGenericManager(SundayInforManager m)
    {
        super.setGenericManager(m);
    }

    public SundayInforManager getGenericManager()
    {
        return (SundayInforManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeSundayInfor(sundayInfor.getId());
        return DELETE;
    }

    public String edit()
    {
        if (sundayInfor == null) {
            sundayInfor = new SundayInfor();
        } else if (sundayInfor.getId() != null) {
            sundayInfor = getGenericManager().getSundayInforById(sundayInfor.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedSundayInforIds != null && selectedSundayInforIds.length > 0) {
            SundayInfor obj = getGenericManager().getSundayInforById(selectedSundayInforIds[0]);
            obj.setId(null);
            sundayInfor = obj;
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
            if (inputValidation(sundayInfor) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(SundayInfor val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveSundayInfor(sundayInfor);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        messageDate = Tools.dateToString(sundayInfor.getMessageDate());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        sundayInfor.setMessageDate(Tools.convertToDate(messageDate)); 
        log.info("exit formToBean()");
    }
    public void setMessageDate(String val)
    {
        messageDate = val;
    }

    public String getMessageDate()
    {
        return messageDate;
    }

    public List<SundayInfor> getSundayInforList()
    {
        return getGenericManager().getSundayInforList();
    }

    public void setSelectedSundayInforIds(Long[] val)
    {
        selectedSundayInforIds = val;
    }

    public Long[] getSelectedSundayInforIds()
    {
        return selectedSundayInforIds;
    }
}
