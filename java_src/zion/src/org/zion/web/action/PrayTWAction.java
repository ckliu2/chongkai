package org.zion.web.action;

import org.zion.value.*;
import org.zion.service.PrayManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;

import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.*;



public class PrayTWAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private PrayTW prayTW;
    private java.io.File fileMap;
    private String fileMapContentType, fileMapFileName, removeMap;
    private java.io.File filePhoto1;
    private String filePhoto1ContentType, filePhoto1FileName, removePhoto1;
    private java.io.File filePhoto2;
    private String filePhoto2ContentType, filePhoto2FileName, removePhoto2;
    private java.io.File filePhoto3;
    private String filePhoto3ContentType, filePhoto3FileName, removePhoto3;
    private Long[] selectedPrayTWIds;
	Long countyId;
    

    public PrayTWAction()
    {
        log = LogFactory.getLog(org.zion.web.action.PrayTWAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("PRAYTW");
    }

    public PrayTW getPrayTW()
    {
        return prayTW;
    }

    public void setPrayTW(PrayTW val)
    {
        prayTW = val;
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
        getGenericManager().removePrayTW(prayTW.getId());
        return DELETE;
    }

    public String edit()
    {
    	MiscCode area=getGenericManager().getMiscCodeById(prayTW.getAreaId());
    	prayTW=getGenericManager().getPrayTWByArea(area);

    	
        
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedPrayTWIds != null && selectedPrayTWIds.length > 0) {
            PrayTW obj = getGenericManager().getPrayTWById(selectedPrayTWIds[0]);
            obj.setId(null);
            prayTW = obj;
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
            if (inputValidation(prayTW) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(PrayTW val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().savePrayTW(prayTW);
        saveFileToLocal(fileMapFileName, fileMap, getTextWithArgs("prayTW.uploadMap.dir"), prayTW.getId());
        saveFileToLocal(filePhoto1FileName, filePhoto1, getTextWithArgs("prayTW.uploadPhoto1.dir"), prayTW.getId());
        saveFileToLocal(filePhoto2FileName, filePhoto2, getTextWithArgs("prayTW.uploadPhoto2.dir"), prayTW.getId());
        saveFileToLocal(filePhoto3FileName, filePhoto3, getTextWithArgs("prayTW.uploadPhoto3.dir"), prayTW.getId());
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
        if (getRemoveMap() != null && getRemoveMap().length() > 0) {
            prayTW.setMap(computeUploadedFile(fileMapFileName, fileMap)); 
            removeUploadedFile(getTextWithArgs("prayTW.uploadMap.dir"), prayTW.getMapId(), prayTW.getMapFileName());
        } else {
            if (prayTW.getMapId() != null)
                prayTW.setMap(getGenericManager().getUploadedFileById(prayTW.getMapId())); 
            else
                prayTW.setMap(computeUploadedFile(fileMapFileName, fileMap)); 
        }
        if (getRemovePhoto1() != null && getRemovePhoto1().length() > 0) {
            prayTW.setPhoto1(computeUploadedFile(filePhoto1FileName, filePhoto1)); 
            removeUploadedFile(getTextWithArgs("prayTW.uploadPhoto1.dir"), prayTW.getPhoto1Id(), prayTW.getPhoto1FileName());
        } else {
            if (prayTW.getPhoto1Id() != null)
                prayTW.setPhoto1(getGenericManager().getUploadedFileById(prayTW.getPhoto1Id())); 
            else
                prayTW.setPhoto1(computeUploadedFile(filePhoto1FileName, filePhoto1)); 
        }
        if (getRemovePhoto2() != null && getRemovePhoto2().length() > 0) {
            prayTW.setPhoto2(computeUploadedFile(filePhoto2FileName, filePhoto2)); 
            removeUploadedFile(getTextWithArgs("prayTW.uploadPhoto2.dir"), prayTW.getPhoto2Id(), prayTW.getPhoto2FileName());
        } else {
            if (prayTW.getPhoto2Id() != null)
                prayTW.setPhoto2(getGenericManager().getUploadedFileById(prayTW.getPhoto2Id())); 
            else
                prayTW.setPhoto2(computeUploadedFile(filePhoto2FileName, filePhoto2)); 
        }
        if (getRemovePhoto3() != null && getRemovePhoto3().length() > 0) {
            prayTW.setPhoto3(computeUploadedFile(filePhoto3FileName, filePhoto3)); 
            removeUploadedFile(getTextWithArgs("prayTW.uploadPhoto3.dir"), prayTW.getPhoto3Id(), prayTW.getPhoto3FileName());
        } else {
            if (prayTW.getPhoto3Id() != null)
                prayTW.setPhoto3(getGenericManager().getUploadedFileById(prayTW.getPhoto3Id())); 
            else
                prayTW.setPhoto3(computeUploadedFile(filePhoto3FileName, filePhoto3)); 
        }
        prayTW.setArea(getMiscCodeById(prayTW.getAreaId())); 
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

    public List<MiscCode> getCountyList()
    {
    	if(countyId!=null){    		
    		MiscCode county=getGenericManager().getMiscCodeById(countyId);
    		String keyName="county."+county.getKeyName();
    		return getGenericManager().getMiscCodeListByCodeName(keyName);
    	}else{
    		return getGenericManager().getMiscCodeListByTw();
    	}
        
    }

    public List<PrayTW> getPrayTWList()
    {
        return getGenericManager().getPrayTWList();
    }

    public void setSelectedPrayTWIds(Long[] val)
    {
        selectedPrayTWIds = val;
    }

    public Long[] getSelectedPrayTWIds()
    {
        return selectedPrayTWIds;
    }
    
    public Long getCountyId() {
		return countyId;
	}

	public void setCountyId(Long countyId) {
		this.countyId = countyId;
	}
    
    public List<MiscCode> getCountryList1()
    {
        return getGenericManager().getMiscCodeListByCodeName("county");
    }
    
    public List<PrayStreet> getStreetList()
    {
    	return getGenericManager().getPrayStreetListByPrayTW(prayTW);
    }
    
}
