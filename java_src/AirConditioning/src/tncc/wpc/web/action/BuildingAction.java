package tncc.wpc.web.action;

import tncc.wpc.value.*;
import tncc.wpc.service.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;
import com.base.value.*;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Fri Jan 29 14:30:29 CST 2010
*/

public class BuildingAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Building building;
    private Long[] selectedBuildingIds;
    private java.io.File filePhoto;
    private String filePhotoContentType, filePhotoFileName, removePhoto;

    public BuildingAction()
    {
        log = LogFactory.getLog(tncc.wpc.web.action.BuildingAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("BUILDING");
    }

    public Building getBuilding()
    {
        return building;
    }

    public void setBuilding(Building val)
    {
        building = val;
    }

    public void setGenericManager(wpcManager m)
    {
        super.setGenericManager(m);
    }

    public wpcManager getGenericManager()
    {
        return (wpcManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeBuilding(building.getId());
        return DELETE;
    }

    public String edit()
    {
        if (building == null) {
            building = new Building();
        } else if (building.getId() != null) {
            building = getGenericManager().getBuildingById(building.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedBuildingIds != null && selectedBuildingIds.length > 0) {
            Building obj = getGenericManager().getBuildingById(selectedBuildingIds[0]);
            obj.setId(null);
            building = obj;
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
            if (inputValidation(building) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Building val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveBuilding(building);
        saveFileToLocal(filePhotoFileName, filePhoto, getTextWithArgs("building.uploadPhoto.dir"), building.getId());
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
        SessionUser s=(SessionUser)getSession().getAttribute("user");    
        building.setMember(s.getMember()); 
        building.setCreatedDate(Tools.getCurrentTimestamp());      
        building.setCreatedUser(s.getMember());
        if (getRemovePhoto() != null && getRemovePhoto().length() > 0) {
            building.setPhoto(computeUploadedFile(filePhotoFileName, filePhoto)); 
            removeUploadedFile(getTextWithArgs("building.uploadPhoto.dir"), building.getPhotoId(), building.getPhotoFileName());
        } else {
            if (building.getPhotoId() != null)
                building.setPhoto(getGenericManager().getUploadedFileById(building.getPhotoId())); 
            else
                building.setPhoto(computeUploadedFile(filePhotoFileName, filePhoto)); 
        }
        log.info("exit formToBean()");
    }


    public List<Building> getBuildingList()
    {
        return getGenericManager().getBuildingList();
    }

    public void setSelectedBuildingIds(Long[] val)
    {
        selectedBuildingIds = val;
    }

    public Long[] getSelectedBuildingIds()
    {
        return selectedBuildingIds;
    }
    
    public void setFilePhoto(java.io.File val)
    {
        filePhoto = val;
    }

    public java.io.File getFilePhoto()
    {
        return filePhoto;
    }

    public void setFilePhotoContentType(String val)
    {
        filePhotoContentType = val;
    }

    public String getFilePhotoContentType()
    {
        return filePhotoContentType;
    }

    public void setFilePhotoFileName(String val)
    {
        filePhotoFileName = val;
    }

    public String getFilePhotoFileName()
    {
        return filePhotoFileName;
    }

    public void setRemovePhoto(String val)
    {
        removePhoto = val;
    }

    public String getRemovePhoto()
    {
        return removePhoto;
    }
    
    
}
