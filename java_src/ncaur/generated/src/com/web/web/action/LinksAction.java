package com.web.web.action;

import com.web.value.Links;
import com.web.service.LinksManager;
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

public class LinksAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Links links;
    private java.io.File filePhoto;
    private String filePhotoContentType, filePhotoFileName, removePhoto;
    private Long[] selectedLinksIds;

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

    public void setGenericManager(LinksManager m)
    {
        super.setGenericManager(m);
    }

    public LinksManager getGenericManager()
    {
        return (LinksManager) super.getGenericManager();
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
            links.setCreatedUser(getSessionUser().getLoginId());
        }
        links.setLastModifiedDate(ts);
        links.setLastModifiedUser(getSessionUser().getLoginId());
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
}
