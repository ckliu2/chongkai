package com.common.web.action;

import com.common.value.*;
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
    Created Date: Wed Jun 09 12:11:30 CST 2010
*/

public class WebLogAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private WebLog webLog;
    private Long[] selectedWebLogIds;

    public WebLogAction()
    {
        log = LogFactory.getLog(com.common.web.action.WebLogAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("WEBLOG");
    }

    public WebLog getWebLog()
    {
        return webLog;
    }

    public void setWebLog(WebLog val)
    {
        webLog = val;
    }

    public void setGenericManager(CommonManager m)
    {
        super.setGenericManager(m);
    }

    public CommonManager getGenericManager()
    {
        return (CommonManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeWebLog(webLog.getId());
        return DELETE;
    }

    public String edit()
    {
        if (webLog == null) {
            webLog = new WebLog();
        } else if (webLog.getId() != null) {
            webLog = getGenericManager().getWebLogById(webLog.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedWebLogIds != null && selectedWebLogIds.length > 0) {
            WebLog obj = getGenericManager().getWebLogById(selectedWebLogIds[0]);
            obj.setId(null);
            webLog = obj;
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
            if (inputValidation(webLog) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(WebLog val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveWebLog(webLog);
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
    public List<WebLog> getWebLogList()
    {
        return getGenericManager().getWebLogList();
    }

    public void setSelectedWebLogIds(Long[] val)
    {
        selectedWebLogIds = val;
    }

    public Long[] getSelectedWebLogIds()
    {
        return selectedWebLogIds;
    }
}
