package tncc.power.web.action;

import tncc.power.value.EvenLog;
import tncc.power.service.EvenLogManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public class EvenLogAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private EvenLog evenLog;
    private Long[] selectedEvenLogIds;

    public EvenLogAction()
    {
        log = LogFactory.getLog(tncc.power.web.action.EvenLogAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("EVENLOG");
    }

    public EvenLog getEvenLog()
    {
        return evenLog;
    }

    public void setEvenLog(EvenLog val)
    {
        evenLog = val;
    }

    public void setGenericManager(EvenLogManager m)
    {
        super.setGenericManager(m);
    }

    public EvenLogManager getGenericManager()
    {
        return (EvenLogManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeEvenLog(evenLog.getId());
        return DELETE;
    }

    public String edit()
    {
        if (evenLog == null) {
            evenLog = new EvenLog();
        } else if (evenLog.getId() != null) {
            evenLog = getGenericManager().getEvenLogById(evenLog.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedEvenLogIds != null && selectedEvenLogIds.length > 0) {
            EvenLog obj = getGenericManager().getEvenLogById(selectedEvenLogIds[0]);
            obj.setId(null);
            evenLog = obj;
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
            if (inputValidation(evenLog) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(EvenLog val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveEvenLog(evenLog);
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
        evenLog.setShutdownprc(getGenericManager().getShutdownById(evenLog.getShutdownprcId())); 
        log.info("exit formToBean()");
    }
    public List<Shutdown> getShutdownprcList()
    {
        return getGenericManager().getShutdownprcList(); // TODO
    }

    public List<EvenLog> getEvenLogList()
    {
        return getGenericManager().getEvenLogList();
    }

    public void setSelectedEvenLogIds(Long[] val)
    {
        selectedEvenLogIds = val;
    }

    public Long[] getSelectedEvenLogIds()
    {
        return selectedEvenLogIds;
    }
}
