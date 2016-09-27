package com.web.web.action;

import com.web.value.Bolg;
import com.web.value.BolgClass;
import com.web.service.WebManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;

import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.*;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Fri May 28 09:33:28 CST 2010
*/

public class BolgAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Bolg bolg;
    private String beginDate;
    private String endDate;
    private java.io.File fileMyfile;
    private String fileMyfileContentType, fileMyfileFileName, removeMyfile;
    private java.io.File filePhoto;
    private String filePhotoContentType, filePhotoFileName, removePhoto;
    private Long[] selectedBolgIds;
    public Long QueryBlogClass;

    public BolgAction()
    {
        log = LogFactory.getLog(com.web.web.action.BolgAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("BOLG");
    }

    public Bolg getBolg()
    {
        return bolg;
    }

    public void setBolg(Bolg val)
    {
        bolg = val;
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
        getGenericManager().removeBolg(bolg.getId());
        return DELETE;
    }

    public String edit()
    {
        if (bolg == null) {
            bolg = new Bolg();
        } else if (bolg.getId() != null) {
            bolg = getGenericManager().getBolgById(bolg.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedBolgIds != null && selectedBolgIds.length > 0) {
            Bolg obj = getGenericManager().getBolgById(selectedBolgIds[0]);
            obj.setId(null);
            bolg = obj;
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
            if (inputValidation(bolg) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Bolg val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        java.sql.Timestamp ts = Tools.getCurrentTimestamp();
        if (bolg.getId() == null) {
            bolg.setCreatedDate(ts);
            bolg.setCreatedUser(getSessionUser().getMember());
        }
        bolg.setLastModifiedDate(ts);
        bolg.setLastModifiedUser(getSessionUser().getMember());
        bolg.setCreatedDate(ts);
        bolg.setCreatedUser(getSessionUser().getMember());
        getGenericManager().saveBolg(bolg);
        
        saveFileToLocal(fileMyfileFileName, fileMyfile, getTextWithArgs("bolg.uploadMyfile.dir"), bolg.getId());
        saveFileToLocal(filePhotoFileName, filePhoto, getTextWithArgs("bolg.uploadPhoto.dir"), bolg.getId());

        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        beginDate = Tools.dateToString(bolg.getBeginDate());
        endDate = Tools.dateToString(bolg.getEndDate());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        bolg.setBeginDate(Tools.convertToDate(beginDate)); 
        bolg.setEndDate(Tools.convertToDate(endDate)); 
        
        if (getRemoveMyfile() != null && getRemoveMyfile().length() > 0) {
            bolg.setMyfile(computeUploadedFile(fileMyfileFileName, fileMyfile)); 
            removeUploadedFile(getTextWithArgs("bolg.uploadMyfile.dir"), bolg.getMyfileId(), bolg.getMyfileFileName());
        } else {
            if (bolg.getMyfileId() != null)
                bolg.setMyfile(getGenericManager().getUploadedFileById(bolg.getMyfileId())); 
            else
                bolg.setMyfile(computeUploadedFile(fileMyfileFileName, fileMyfile)); 
        }
        if (getRemovePhoto() != null && getRemovePhoto().length() > 0) {
            bolg.setPhoto(computeUploadedFile(filePhotoFileName, filePhoto)); 
            removeUploadedFile(getTextWithArgs("bolg.uploadPhoto.dir"), bolg.getPhotoId(), bolg.getPhotoFileName());
        } else {
            if (bolg.getPhotoId() != null)
                bolg.setPhoto(getGenericManager().getUploadedFileById(bolg.getPhotoId())); 
            else
                bolg.setPhoto(computeUploadedFile(filePhotoFileName, filePhoto)); 
        }
        bolg.setBolgClass(getGenericManager().getBolgClassById(bolg.getBolgClassId())); 
        bolg.setLinkType(getAppPropertyById(bolg.getLinkTypeId())); 
        log.info("exit formToBean()");
    }
    public void setBeginDate(String val)
    {
        beginDate = val;
    }

    public String getBeginDate()
    {
        return beginDate;
    }

    public void setEndDate(String val)
    {
        endDate = val;
    }

    public String getEndDate()
    {
        return endDate;
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

    public List<Bolg> getBolgList()
    {      
        
    	if(QueryBlogClass!=null){
      	//System.out.println("QueryBlogClass!=null");
      	BolgClass b=getGenericManager().getBolgClassById(QueryBlogClass);
      	return getGenericManager().getBolgByBlogClass(b);
      	}else{
      		return getGenericManager().getBolgList();
      	}        
    }
    
    
    public List<Bolg> getBannerList()
    {
	BolgClass b=getGenericManager().getBolgClassById(1L);
        return getGenericManager().getBolgByBlogClass(b);
    }
    
    public List<Bolg> getSliderList()
    {
	BolgClass b=getGenericManager().getBolgClassById(2L);
        return getGenericManager().getBolgByBlogClass(b);
    }
    
    public List<BolgClass> getBolgClassList()
    {
        return getGenericManager().getBolgClassList();
    }


    public void setSelectedBolgIds(Long[] val)
    {
        selectedBolgIds = val;
    }

    public Long[] getSelectedBolgIds()
    {
        return selectedBolgIds;
    }
    
    public Long getQueryBlogClass() {
		return QueryBlogClass;
	}

	public void setQueryBlogClass(Long queryBlogClass) {
		QueryBlogClass = queryBlogClass;
	}

}
