package com.web.web.action;

import com.web.value.*;
import com.web.service.WebManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Fri May 28 09:33:28 CST 2010
*/

public class LinksAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Links links;
    private Long[] selectedLinksIds;
    private java.io.File filePhoto;
    private String filePhotoContentType, filePhotoFileName, removePhoto;

    public LinksAction()
    {
        log = LogFactory.getLog(com.web.web.action.LinksAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("LINKS");
    }

    public Links getLinks()
    {
        return links;
    }

    public void setLinks(Links val)
    {
        links = val;
    }

    public void setGenericManager(WebManager m)
    {
        super.setGenericManager(m);
    }

    public WebManager getGenericManager()
    {
        return (WebManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeLinks(links.getId());
        return DELETE;
    }

    public String edit()
    {
        if (links == null) {
            links = new Links();
        } else if (links.getId() != null) {
            links = getGenericManager().getLinksById(links.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedLinksIds != null && selectedLinksIds.length > 0) {
            Links obj = getGenericManager().getLinksById(selectedLinksIds[0]);
            obj.setId(null);
            links = obj;
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
            if (inputValidation(links) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Links val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        java.sql.Timestamp ts = Tools.getCurrentTimestamp();
        if (links.getId() == null) {
            links.setCreatedDate(ts);
            links.setCreatedUser(getSessionUser().getMember());
        }
        links.setLastModifiedDate(ts);
        links.setLastModifiedUser(getSessionUser().getMember());
        links.setCreatedDate(ts);
        links.setCreatedUser(getSessionUser().getMember());
        getGenericManager().saveLinks(links);
        saveFileToLocal(filePhotoFileName, filePhoto, getTextWithArgs("links.uploadPhoto.dir"), links.getId());
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
        if (getRemovePhoto() != null && getRemovePhoto().length() > 0) {
            links.setPhoto(computeUploadedFile(filePhotoFileName, filePhoto)); 
            removeUploadedFile(getTextWithArgs("links.uploadPhoto.dir"), links.getPhotoId(), links.getPhotoFileName());
        } else {
            if (links.getPhotoId() != null)
                links.setPhoto(getGenericManager().getUploadedFileById(links.getPhotoId())); 
            else
                links.setPhoto(computeUploadedFile(filePhotoFileName, filePhoto)); 
        }
        log.info("exit formToBean()");
    }
    
    public List<Links> getLinksList()
    {
        return getGenericManager().getLinksList();
    }

    public void setSelectedLinksIds(Long[] val)
    {
        selectedLinksIds = val;
    }

    public Long[] getSelectedLinksIds()
    {
        return selectedLinksIds;
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
