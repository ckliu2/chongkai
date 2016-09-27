package com.base.web.action;

import com.base.value.UploadedFile;
import com.base.service.UploadedFileManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public class UploadedFileAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private UploadedFile uploadedFile;
    private Long[] selectedUploadedFileIds;

    public UploadedFileAction()
    {
        log = LogFactory.getLog(com.base.web.action.UploadedFileAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("UPLOADEDFILE");
    }

    public UploadedFile getUploadedFile()
    {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile val)
    {
        uploadedFile = val;
    }

    public void setGenericManager(UploadedFileManager m)
    {
        super.setGenericManager(m);
    }

    public UploadedFileManager getGenericManager()
    {
        return (UploadedFileManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeUploadedFile(uploadedFile.getId());
        return DELETE;
    }

    public String edit()
    {
        if (uploadedFile == null) {
            uploadedFile = new UploadedFile();
        } else if (uploadedFile.getId() != null) {
            uploadedFile = getGenericManager().getUploadedFileById(uploadedFile.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedUploadedFileIds != null && selectedUploadedFileIds.length > 0) {
            UploadedFile obj = getGenericManager().getUploadedFileById(selectedUploadedFileIds[0]);
            obj.setId(null);
            uploadedFile = obj;
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
            if (inputValidation(uploadedFile) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(UploadedFile val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveUploadedFile(uploadedFile);
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
    public List<UploadedFile> getUploadedFileList()
    {
        return getGenericManager().getUploadedFileList();
    }

    public void setSelectedUploadedFileIds(Long[] val)
    {
        selectedUploadedFileIds = val;
    }

    public Long[] getSelectedUploadedFileIds()
    {
        return selectedUploadedFileIds;
    }
}
