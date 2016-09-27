package tncc.power.web.action;

import tncc.power.value.SpaceReader;
import tncc.power.service.SpaceReaderManager;
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

public class SpaceReaderAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private SpaceReader spaceReader;
    private Long[] selectedSpaceReaderIds;

    public SpaceReaderAction()
    {
        log = LogFactory.getLog(tncc.power.web.action.SpaceReaderAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("SPACEREADER");
    }

    public SpaceReader getSpaceReader()
    {
        return spaceReader;
    }

    public void setSpaceReader(SpaceReader val)
    {
        spaceReader = val;
    }

    public void setGenericManager(SpaceReaderManager m)
    {
        super.setGenericManager(m);
    }

    public SpaceReaderManager getGenericManager()
    {
        return (SpaceReaderManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeSpaceReader(spaceReader.getId());
        return DELETE;
    }

    public String edit()
    {
        if (spaceReader == null) {
            spaceReader = new SpaceReader();
        } else if (spaceReader.getId() != null) {
            spaceReader = getGenericManager().getSpaceReaderById(spaceReader.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedSpaceReaderIds != null && selectedSpaceReaderIds.length > 0) {
            SpaceReader obj = getGenericManager().getSpaceReaderById(selectedSpaceReaderIds[0]);
            obj.setId(null);
            spaceReader = obj;
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
            if (inputValidation(spaceReader) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(SpaceReader val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveSpaceReader(spaceReader);
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
        spaceReader.setSpace(getGenericManager().getSpaceById(spaceReader.getSpaceId())); 
        spaceReader.setReader(getGenericManager().getReaderById(spaceReader.getReaderId())); 
        spaceReader.setPowercontroller(getGenericManager().getPowerControllerById(spaceReader.getPowercontrollerId())); 
        spaceReader.setState(getAppPropertyById(spaceReader.getStateId())); 
        log.info("exit formToBean()");
    }
    public List<Space> getSpaceList()
    {
        return getGenericManager().getSpaceList(); // TODO
    }

    public List<Reader> getReaderList()
    {
        return getGenericManager().getReaderList(); // TODO
    }

    public List<PowerController> getPowercontrollerList()
    {
        return getGenericManager().getPowercontrollerList(); // TODO
    }

    public List<AppProperty> getStateList()
    {
        return super.getAppPropertyList("spaceReader.state");
    }

    public List<SpaceReader> getSpaceReaderList()
    {
        return getGenericManager().getSpaceReaderList();
    }

    public void setSelectedSpaceReaderIds(Long[] val)
    {
        selectedSpaceReaderIds = val;
    }

    public Long[] getSelectedSpaceReaderIds()
    {
        return selectedSpaceReaderIds;
    }
}
