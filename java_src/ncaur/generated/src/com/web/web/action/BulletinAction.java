package com.web.web.action;

import com.web.value.Bulletin;
import com.web.service.BulletinManager;
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

public class BulletinAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Bulletin bulletin;
    private String bulletinDate;
    private java.io.File fileMyfile;
    private String fileMyfileContentType, fileMyfileFileName, removeMyfile;
    private java.io.File fileVoice;
    private String fileVoiceContentType, fileVoiceFileName, removeVoice;
    private java.io.File fileVedio;
    private String fileVedioContentType, fileVedioFileName, removeVedio;
    private java.io.File fileFrontcover;
    private String fileFrontcoverContentType, fileFrontcoverFileName, removeFrontcover;
    private Long[] selectedBulletinIds;

    public BulletinAction()
    {
        log = LogFactory.getLog(com.web.web.action.BulletinAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("BULLETIN");
    }

    public Bulletin getBulletin()
    {
        return bulletin;
    }

    public void setBulletin(Bulletin val)
    {
        bulletin = val;
    }

    public void setGenericManager(BulletinManager m)
    {
        super.setGenericManager(m);
    }

    public BulletinManager getGenericManager()
    {
        return (BulletinManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeBulletin(bulletin.getId());
        return DELETE;
    }

    public String edit()
    {
        if (bulletin == null) {
            bulletin = new Bulletin();
        } else if (bulletin.getId() != null) {
            bulletin = getGenericManager().getBulletinById(bulletin.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedBulletinIds != null && selectedBulletinIds.length > 0) {
            Bulletin obj = getGenericManager().getBulletinById(selectedBulletinIds[0]);
            obj.setId(null);
            bulletin = obj;
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
            if (inputValidation(bulletin) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Bulletin val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        java.sql.Timestamp ts = Tools.getCurrentTimestamp();
        if (bulletin.getId() == null) {
            bulletin.setCreatedDate(ts);
            bulletin.setCreatedUser(getSessionUser().getLoginId());
        }
        bulletin.setLastModifiedDate(ts);
        bulletin.setLastModifiedUser(getSessionUser().getLoginId());
        getGenericManager().saveBulletin(bulletin);
        saveFileToLocal(fileMyfileFileName, fileMyfile, getTextWithArgs("bulletin.uploadMyfile.dir"), bulletin.getId());
        saveFileToLocal(fileVoiceFileName, fileVoice, getTextWithArgs("bulletin.uploadVoice.dir"), bulletin.getId());
        saveFileToLocal(fileVedioFileName, fileVedio, getTextWithArgs("bulletin.uploadVedio.dir"), bulletin.getId());
        saveFileToLocal(fileFrontcoverFileName, fileFrontcover, getTextWithArgs("bulletin.uploadFrontcover.dir"), bulletin.getId());
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        bulletinDate = Tools.dateToString(bulletin.getBulletinDate());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        bulletin.setBulletinDate(Tools.convertToDate(bulletinDate)); 
        bulletin.setBulletinType(getAppPropertyById(bulletin.getBulletinTypeId())); 
        if (getRemoveMyfile() != null && getRemoveMyfile().length() > 0) {
            bulletin.setMyfile(computeUploadedFile(fileMyfileFileName, fileMyfile)); 
            removeUploadedFile(getTextWithArgs("bulletin.uploadMyfile.dir"), bulletin.getMyfileId(), bulletin.getMyfileFileName());
        } else {
            if (bulletin.getMyfileId() != null)
                bulletin.setMyfile(getGenericManager().getUploadedFileById(bulletin.getMyfileId())); 
            else
                bulletin.setMyfile(computeUploadedFile(fileMyfileFileName, fileMyfile)); 
        }
        if (getRemoveVoice() != null && getRemoveVoice().length() > 0) {
            bulletin.setVoice(computeUploadedFile(fileVoiceFileName, fileVoice)); 
            removeUploadedFile(getTextWithArgs("bulletin.uploadVoice.dir"), bulletin.getVoiceId(), bulletin.getVoiceFileName());
        } else {
            if (bulletin.getVoiceId() != null)
                bulletin.setVoice(getGenericManager().getUploadedFileById(bulletin.getVoiceId())); 
            else
                bulletin.setVoice(computeUploadedFile(fileVoiceFileName, fileVoice)); 
        }
        if (getRemoveVedio() != null && getRemoveVedio().length() > 0) {
            bulletin.setVedio(computeUploadedFile(fileVedioFileName, fileVedio)); 
            removeUploadedFile(getTextWithArgs("bulletin.uploadVedio.dir"), bulletin.getVedioId(), bulletin.getVedioFileName());
        } else {
            if (bulletin.getVedioId() != null)
                bulletin.setVedio(getGenericManager().getUploadedFileById(bulletin.getVedioId())); 
            else
                bulletin.setVedio(computeUploadedFile(fileVedioFileName, fileVedio)); 
        }
        if (getRemoveFrontcover() != null && getRemoveFrontcover().length() > 0) {
            bulletin.setFrontcover(computeUploadedFile(fileFrontcoverFileName, fileFrontcover)); 
            removeUploadedFile(getTextWithArgs("bulletin.uploadFrontcover.dir"), bulletin.getFrontcoverId(), bulletin.getFrontcoverFileName());
        } else {
            if (bulletin.getFrontcoverId() != null)
                bulletin.setFrontcover(getGenericManager().getUploadedFileById(bulletin.getFrontcoverId())); 
            else
                bulletin.setFrontcover(computeUploadedFile(fileFrontcoverFileName, fileFrontcover)); 
        }
        log.info("exit formToBean()");
    }
    public void setBulletinDate(String val)
    {
        bulletinDate = val;
    }

    public String getBulletinDate()
    {
        return bulletinDate;
    }

    public List<AppProperty> getBulletinTypeList()
    {
        return super.getAppPropertyList("bulletin.bulletinType");
    }

    public void setFileMyfile(java.io.File val)
    {
        fileMyfile = val;
    }

    public java.io.File getFileMyfile()
    {
        return fileMyfile;
    }

    public void setFileMyfileContentType(String val)
    {
        fileMyfileContentType = val;
    }

    public String getFileMyfileContentType()
    {
        return fileMyfileContentType;
    }

    public void setFileMyfileFileName(String val)
    {
        fileMyfileFileName = val;
    }

    public String getFileMyfileFileName()
    {
        return fileMyfileFileName;
    }

    public void setRemoveMyfile(String val)
    {
        removeMyfile = val;
    }

    public String getRemoveMyfile()
    {
        return removeMyfile;
    }

    public void setFileVoice(java.io.File val)
    {
        fileVoice = val;
    }

    public java.io.File getFileVoice()
    {
        return fileVoice;
    }

    public void setFileVoiceContentType(String val)
    {
        fileVoiceContentType = val;
    }

    public String getFileVoiceContentType()
    {
        return fileVoiceContentType;
    }

    public void setFileVoiceFileName(String val)
    {
        fileVoiceFileName = val;
    }

    public String getFileVoiceFileName()
    {
        return fileVoiceFileName;
    }

    public void setRemoveVoice(String val)
    {
        removeVoice = val;
    }

    public String getRemoveVoice()
    {
        return removeVoice;
    }

    public void setFileVedio(java.io.File val)
    {
        fileVedio = val;
    }

    public java.io.File getFileVedio()
    {
        return fileVedio;
    }

    public void setFileVedioContentType(String val)
    {
        fileVedioContentType = val;
    }

    public String getFileVedioContentType()
    {
        return fileVedioContentType;
    }

    public void setFileVedioFileName(String val)
    {
        fileVedioFileName = val;
    }

    public String getFileVedioFileName()
    {
        return fileVedioFileName;
    }

    public void setRemoveVedio(String val)
    {
        removeVedio = val;
    }

    public String getRemoveVedio()
    {
        return removeVedio;
    }

    public void setFileFrontcover(java.io.File val)
    {
        fileFrontcover = val;
    }

    public java.io.File getFileFrontcover()
    {
        return fileFrontcover;
    }

    public void setFileFrontcoverContentType(String val)
    {
        fileFrontcoverContentType = val;
    }

    public String getFileFrontcoverContentType()
    {
        return fileFrontcoverContentType;
    }

    public void setFileFrontcoverFileName(String val)
    {
        fileFrontcoverFileName = val;
    }

    public String getFileFrontcoverFileName()
    {
        return fileFrontcoverFileName;
    }

    public void setRemoveFrontcover(String val)
    {
        removeFrontcover = val;
    }

    public String getRemoveFrontcover()
    {
        return removeFrontcover;
    }

    public List<Bulletin> getBulletinList()
    {
        return getGenericManager().getBulletinList();
    }

    public void setSelectedBulletinIds(Long[] val)
    {
        selectedBulletinIds = val;
    }

    public Long[] getSelectedBulletinIds()
    {
        return selectedBulletinIds;
    }
}
