package tncc.power.web.action;

import tncc.power.value.Space;
import tncc.power.service.SpaceManager;
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

public class SpaceAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Space space;
    private Long[] readerIds;
    private Long[] selectedSpaceIds;

    public SpaceAction()
    {
        log = LogFactory.getLog(tncc.power.web.action.SpaceAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("SPACE");
    }

    public Space getSpace()
    {
        return space;
    }

    public void setSpace(Space val)
    {
        space = val;
    }

    public void setGenericManager(SpaceManager m)
    {
        super.setGenericManager(m);
    }

    public SpaceManager getGenericManager()
    {
        return (SpaceManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeSpace(space.getId());
        return DELETE;
    }

    public String edit()
    {
        if (space == null) {
            space = new Space();
        } else if (space.getId() != null) {
            space = getGenericManager().getSpaceById(space.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedSpaceIds != null && selectedSpaceIds.length > 0) {
            Space obj = getGenericManager().getSpaceById(selectedSpaceIds[0]);
            obj.setId(null);
            space = obj;
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
            if (inputValidation(space) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Space val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveSpace(space);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        readerIds = getGenericManager().getIdsFromReaderList(space.getReader());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        space.setReaderType(getAppPropertyById(space.getReaderTypeId())); 
        space.setBuilding(getGenericManager().getBuildingById(space.getBuildingId())); 
        space.setReader(getGenericManager().getReaderListByIds(readerIds)); 
        log.info("exit formToBean()");
    }
    public List<AppProperty> getReaderTypeList()
    {
        return super.getAppPropertyList("space.readerType");
    }

    public List<Building> getBuildingList()
    {
        return getGenericManager().getBuildingList(); // TODO
    }

    public List<Reader> getReaderList()
    {
        List<Reader> al = getGenericManager().getReaderList();
        if (al != null) {
            if (space.getReader() != null)
                al.removeAll(space.getReader());
            return al;
        }
        return new ArrayList<Reader>();
    }

    public List<Reader> getObject_readerList()
    {
        return (space.getReader() == null) ? new ArrayList<Reader>() : space.getReader();
    }

    public void setReaderIds(Long[] val)
    {
        readerIds = val;
    }

    public Long[] getReaderIds()
    {
        return readerIds;
    }

    public List<Space> getSpaceList()
    {
        return getGenericManager().getSpaceList();
    }

    public void setSelectedSpaceIds(Long[] val)
    {
        selectedSpaceIds = val;
    }

    public Long[] getSelectedSpaceIds()
    {
        return selectedSpaceIds;
    }
}
