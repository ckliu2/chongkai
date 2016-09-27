package org.zion.web.action;

import org.zion.value.*;
import org.zion.service.PrayManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.*;


public class PrayStreetAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private PrayStreet prayStreet;
    private java.io.File fileMap;
    private String fileMapContentType, fileMapFileName, removeMap;
    private java.io.File filePhoto1;
    private String filePhoto1ContentType, filePhoto1FileName, removePhoto1;
    private java.io.File filePhoto2;
    private String filePhoto2ContentType, filePhoto2FileName, removePhoto2;
    private java.io.File filePhoto3;
    private String filePhoto3ContentType, filePhoto3FileName, removePhoto3;
    private Long[] selectedPrayStreetIds;

    public PrayStreetAction()
    {
        log = LogFactory.getLog(org.zion.web.action.PrayStreetAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("PRAYSTREET");
    }

    public PrayStreet getPrayStreet()
    {
        return prayStreet;
    }

    public void setPrayStreet(PrayStreet val)
    {
        prayStreet = val;
    }

    public void setGenericManager(PrayManager m)
    {
        super.setGenericManager(m);
    }

    public PrayManager getGenericManager()
    {
        return (PrayManager) super.getGenericManager();
    }

    public String delete()
    {
    	appendXworkParam("reload=1");
        getGenericManager().removePrayStreet(prayStreet.getId());        
        return DELETE;
    }

    public String edit()
    {
    	if (prayStreet == null) {
            prayStreet = new PrayStreet();           
        } else if (prayStreet.getId() != null) {
            prayStreet = getGenericManager().getPrayStreetById(prayStreet.getId());            
        } else { // TODO        	
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
            if (inputValidation(prayStreet) == false) {
                
            	// appendXworkParam("prayStreet.praytwId="+prayStreet.getPraytw().getId());
                // appendXworkParam("prayStreet.id="+prayStreet.getId());
                 
            	return INPUT;
            }
        }
        return SUCCESS;
    }

    public boolean inputValidation(PrayStreet val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().savePrayStreet(prayStreet);
        saveFileToLocal(fileMapFileName, fileMap, getTextWithArgs("prayStreet.uploadMap.dir"), prayStreet.getId());
        saveFileToLocal(filePhoto1FileName, filePhoto1, getTextWithArgs("prayStreet.uploadPhoto1.dir"), prayStreet.getId());
        saveFileToLocal(filePhoto2FileName, filePhoto2, getTextWithArgs("prayStreet.uploadPhoto2.dir"), prayStreet.getId());
        saveFileToLocal(filePhoto3FileName, filePhoto3, getTextWithArgs("prayStreet.uploadPhoto3.dir"), prayStreet.getId());
        
        appendXworkParam("prayStreet.praytwId="+prayStreet.getPraytw().getId());
        appendXworkParam("prayStreet.id="+prayStreet.getId());
    	appendXworkParam("reload=1");
        
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        prayStreet.setPraytw(getGenericManager().getPrayTWById(prayStreet.getPraytwId()));
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        if (getRemoveMap() != null && getRemoveMap().length() > 0) {
            prayStreet.setMap(computeUploadedFile(fileMapFileName, fileMap)); 
            removeUploadedFile(getTextWithArgs("prayStreet.uploadMap.dir"), prayStreet.getMapId(), prayStreet.getMapFileName());
        } else {
            if (prayStreet.getMapId() != null)
                prayStreet.setMap(getGenericManager().getUploadedFileById(prayStreet.getMapId())); 
            else
                prayStreet.setMap(computeUploadedFile(fileMapFileName, fileMap)); 
        }
        if (getRemovePhoto1() != null && getRemovePhoto1().length() > 0) {
            prayStreet.setPhoto1(computeUploadedFile(filePhoto1FileName, filePhoto1)); 
            removeUploadedFile(getTextWithArgs("prayStreet.uploadPhoto1.dir"), prayStreet.getPhoto1Id(), prayStreet.getPhoto1FileName());
        } else {
            if (prayStreet.getPhoto1Id() != null)
                prayStreet.setPhoto1(getGenericManager().getUploadedFileById(prayStreet.getPhoto1Id())); 
            else
                prayStreet.setPhoto1(computeUploadedFile(filePhoto1FileName, filePhoto1)); 
        }
        if (getRemovePhoto2() != null && getRemovePhoto2().length() > 0) {
            prayStreet.setPhoto2(computeUploadedFile(filePhoto2FileName, filePhoto2)); 
            removeUploadedFile(getTextWithArgs("prayStreet.uploadPhoto2.dir"), prayStreet.getPhoto2Id(), prayStreet.getPhoto2FileName());
        } else {
            if (prayStreet.getPhoto2Id() != null)
                prayStreet.setPhoto2(getGenericManager().getUploadedFileById(prayStreet.getPhoto2Id())); 
            else
                prayStreet.setPhoto2(computeUploadedFile(filePhoto2FileName, filePhoto2)); 
        }
        if (getRemovePhoto3() != null && getRemovePhoto3().length() > 0) {
            prayStreet.setPhoto3(computeUploadedFile(filePhoto3FileName, filePhoto3)); 
            removeUploadedFile(getTextWithArgs("prayStreet.uploadPhoto3.dir"), prayStreet.getPhoto3Id(), prayStreet.getPhoto3FileName());
        } else {
            if (prayStreet.getPhoto3Id() != null)
                prayStreet.setPhoto3(getGenericManager().getUploadedFileById(prayStreet.getPhoto3Id())); 
            else
                prayStreet.setPhoto3(computeUploadedFile(filePhoto3FileName, filePhoto3)); 
        }
        prayStreet.setPraytw(getGenericManager().getPrayTWById(prayStreet.getPraytwId())); 
        log.info("exit formToBean()");
    }
    public void setFileMap(java.io.File val)
    {
        fileMap = val;
    }

    public java.io.File getFileMap()
    {
        return fileMap;
    }

    public void setFileMapContentType(String val)
    {
        fileMapContentType = val;
    }

    public String getFileMapContentType()
    {
        return fileMapContentType;
    }

    public void setFileMapFileName(String val)
    {
        fileMapFileName = val;
    }

    public String getFileMapFileName()
    {
        return fileMapFileName;
    }

    public void setRemoveMap(String val)
    {
        removeMap = val;
    }

    public String getRemoveMap()
    {
        return removeMap;
    }

    public void setFilePhoto1(java.io.File val)
    {
        filePhoto1 = val;
    }

    public java.io.File getFilePhoto1()
    {
        return filePhoto1;
    }

    public void setFilePhoto1ContentType(String val)
    {
        filePhoto1ContentType = val;
    }

    public String getFilePhoto1ContentType()
    {
        return filePhoto1ContentType;
    }

    public void setFilePhoto1FileName(String val)
    {
        filePhoto1FileName = val;
    }

    public String getFilePhoto1FileName()
    {
        return filePhoto1FileName;
    }

    public void setRemovePhoto1(String val)
    {
        removePhoto1 = val;
    }

    public String getRemovePhoto1()
    {
        return removePhoto1;
    }

    public void setFilePhoto2(java.io.File val)
    {
        filePhoto2 = val;
    }

    public java.io.File getFilePhoto2()
    {
        return filePhoto2;
    }

    public void setFilePhoto2ContentType(String val)
    {
        filePhoto2ContentType = val;
    }

    public String getFilePhoto2ContentType()
    {
        return filePhoto2ContentType;
    }

    public void setFilePhoto2FileName(String val)
    {
        filePhoto2FileName = val;
    }

    public String getFilePhoto2FileName()
    {
        return filePhoto2FileName;
    }

    public void setRemovePhoto2(String val)
    {
        removePhoto2 = val;
    }

    public String getRemovePhoto2()
    {
        return removePhoto2;
    }

    public void setFilePhoto3(java.io.File val)
    {
        filePhoto3 = val;
    }

    public java.io.File getFilePhoto3()
    {
        return filePhoto3;
    }

    public void setFilePhoto3ContentType(String val)
    {
        filePhoto3ContentType = val;
    }

    public String getFilePhoto3ContentType()
    {
        return filePhoto3ContentType;
    }

    public void setFilePhoto3FileName(String val)
    {
        filePhoto3FileName = val;
    }

    public String getFilePhoto3FileName()
    {
        return filePhoto3FileName;
    }

    public void setRemovePhoto3(String val)
    {
        removePhoto3 = val;
    }

    public String getRemovePhoto3()
    {
        return removePhoto3;
    }


    public void setSelectedPrayStreetIds(Long[] val)
    {
        selectedPrayStreetIds = val;
    }

    public Long[] getSelectedPrayStreetIds()
    {
        return selectedPrayStreetIds;
    }
}
