package tncc.power.web.action;

import tncc.power.value.Shutdown;
import tncc.power.service.ShutdownManager;
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

public class ShutdownAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Shutdown shutdown;
    private Long[] readerIds;
    private Long[] selectedShutdownIds;

    public ShutdownAction()
    {
        log = LogFactory.getLog(tncc.power.web.action.ShutdownAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("SHUTDOWN");
    }

    public Shutdown getShutdown()
    {
        return shutdown;
    }

    public void setShutdown(Shutdown val)
    {
        shutdown = val;
    }

    public void setGenericManager(ShutdownManager m)
    {
        super.setGenericManager(m);
    }

    public ShutdownManager getGenericManager()
    {
        return (ShutdownManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeShutdown(shutdown.getId());
        return DELETE;
    }

    public String edit()
    {
        if (shutdown == null) {
            shutdown = new Shutdown();
        } else if (shutdown.getId() != null) {
            shutdown = getGenericManager().getShutdownById(shutdown.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedShutdownIds != null && selectedShutdownIds.length > 0) {
            Shutdown obj = getGenericManager().getShutdownById(selectedShutdownIds[0]);
            obj.setId(null);
            shutdown = obj;
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
            if (inputValidation(shutdown) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Shutdown val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveShutdown(shutdown);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        readerIds = getGenericManager().getIdsFromReaderList(shutdown.getReader());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        shutdown.setEvenlevel(getGenericManager().getEvenLevelById(shutdown.getEvenlevelId())); 
        shutdown.setReader(getGenericManager().getReaderListByIds(readerIds)); 
        log.info("exit formToBean()");
    }
    public List<EvenLevel> getEvenlevelList()
    {
        return getGenericManager().getEvenlevelList(); // TODO
    }

    public List<List> getReaderList()
    {
        return getGenericManager().getReaderList(); // TODO
    }

    public void setReaderIds(Long[] val)
    {
        readerIds = val;
    }

    public Long[] getReaderIds()
    {
        return readerIds;
    }

    public List<Shutdown> getShutdownList()
    {
        return getGenericManager().getShutdownList();
    }

    public void setSelectedShutdownIds(Long[] val)
    {
        selectedShutdownIds = val;
    }

    public Long[] getSelectedShutdownIds()
    {
        return selectedShutdownIds;
    }
}
