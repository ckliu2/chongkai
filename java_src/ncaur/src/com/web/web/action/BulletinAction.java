package com.web.web.action;

import com.web.value.*;
import com.web.service.WebManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;

import com.common.value.WebSite;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.*;

public class BulletinAction extends CommonActionSupport {

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
    private String fileFrontcoverContentType, fileFrontcoverFileName,
	    removeFrontcover;
    private Long[] selectedBulletinIds;
    private String subject;
    private Date begindate, enddate;
    private Long bulletinTypeId, bulletinId;

    public BulletinAction() {
	log = LogFactory.getLog(com.web.web.action.BulletinAction.class);
    }

    public Function getFunction() {
	return getGenericManager().getFunctionByKey("BULLETIN");
    }

    public Bulletin getBulletin() {
	return bulletin;
    }

    public void setBulletin(Bulletin val) {
	bulletin = val;
    }

    public void setGenericManager(WebManager m) {
	super.setGenericManager(m);
    }

    public WebManager getGenericManager() {
	return (WebManager) super.getGenericManager();
    }

    public String delete() {
	getGenericManager().removeBulletin(bulletin.getId());
	return DELETE;
    }

    public String edit() {
	if (bulletin == null) {
	    bulletin = new Bulletin();
	} else if (bulletin.getId() != null) {
	    bulletin = getGenericManager().getBulletinById(bulletin.getId());
	} else { // TODO
	}
	beanToForm();

	return SUCCESS;
    }

    public String copy() {
	if (selectedBulletinIds != null && selectedBulletinIds.length > 0) {
	    Bulletin obj = getGenericManager().getBulletinById(
		    selectedBulletinIds[0]);
	    obj.setId(null);
	    bulletin = obj;
	}
	beanToForm();

	return SUCCESS;
    }

    public String execute() {
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

    public boolean inputValidation(Bulletin val) {
	return true;
    }

    public String save() {
	log.info("entering 'save' method");
	java.sql.Timestamp ts = Tools.getCurrentTimestamp();
	if (bulletin.getId() == null) {
	    bulletin.setCreatedDate(ts);
	    bulletin.setCreatedUser(getSessionUser().getMember());
	}
	bulletin.setLastModifiedDate(ts);
	bulletin.setLastModifiedUser(getSessionUser().getMember());
	getGenericManager().saveBulletin(bulletin);
	try {
	    saveFileToLocal(fileMyfileFileName, fileMyfile,
		    getTextWithArgs("bulletin.uploadMyfile.dir"),
		    bulletin.getId());
	    saveFileToLocal(fileVoiceFileName, fileVoice,
		    getTextWithArgs("bulletin.uploadVoice.dir"),
		    bulletin.getId());
	    saveFileToLocal(fileVedioFileName, fileVedio,
		    getTextWithArgs("bulletin.uploadVedio.dir"),
		    bulletin.getId());
	    saveFileToLocal(fileFrontcoverFileName, fileFrontcover,
		    getTextWithArgs("bulletin.uploadFrontcover.dir"),
		    bulletin.getId());
	} catch (Exception e) {
	    System.out.println("bulletinActon save() error..");
	}
	return SUCCESS;
    }

    public String list() {
	return SUCCESS;
    }

    protected void beanToForm() {
	log.info("enter beanToForm()");
	bulletinDate = Tools.dateToString(bulletin.getBulletinDate());
	log.info("exit beanToForm()");
    }

    protected void formToBean() {
	log.info("enter formToBean()");
	bulletin.setBulletinDate(Tools.convertToDate(bulletinDate));
	bulletin.setBulletinType(getAppPropertyById(bulletin
		.getBulletinTypeId()));
	try {
	    if (getRemoveMyfile() != null && getRemoveMyfile().length() > 0) {
		bulletin.setMyfile(computeUploadedFile(fileMyfileFileName,
			fileMyfile));
		removeUploadedFile(
			getTextWithArgs("bulletin.uploadMyfile.dir"),
			bulletin.getMyfileId(), bulletin.getMyfileFileName());
	    } else {
		if (bulletin.getMyfileId() != null)
		    bulletin.setMyfile(getGenericManager().getUploadedFileById(
			    bulletin.getMyfileId()));
		else
		    bulletin.setMyfile(computeUploadedFile(fileMyfileFileName,
			    fileMyfile));
	    }
	    if (getRemoveVoice() != null && getRemoveVoice().length() > 0) {
		bulletin.setVoice(computeUploadedFile(fileVoiceFileName,
			fileVoice));
		removeUploadedFile(getTextWithArgs("bulletin.uploadVoice.dir"),
			bulletin.getVoiceId(), bulletin.getVoiceFileName());
	    } else {
		if (bulletin.getVoiceId() != null)
		    bulletin.setVoice(getGenericManager().getUploadedFileById(
			    bulletin.getVoiceId()));
		else
		    bulletin.setVoice(computeUploadedFile(fileVoiceFileName,
			    fileVoice));
	    }
	    if (getRemoveVedio() != null && getRemoveVedio().length() > 0) {
		bulletin.setVedio(computeUploadedFile(fileVedioFileName,
			fileVedio));
		removeUploadedFile(getTextWithArgs("bulletin.uploadVedio.dir"),
			bulletin.getVedioId(), bulletin.getVedioFileName());
	    } else {
		if (bulletin.getVedioId() != null)
		    bulletin.setVedio(getGenericManager().getUploadedFileById(
			    bulletin.getVedioId()));
		else
		    bulletin.setVedio(computeUploadedFile(fileVedioFileName,
			    fileVedio));
	    }
	    if (getRemoveFrontcover() != null
		    && getRemoveFrontcover().length() > 0) {
		bulletin.setFrontcover(computeUploadedFile(
			fileFrontcoverFileName, fileFrontcover));
		removeUploadedFile(
			getTextWithArgs("bulletin.uploadFrontcover.dir"),
			bulletin.getFrontcoverId(),
			bulletin.getFrontcoverFileName());
	    } else {
		if (bulletin.getFrontcoverId() != null)
		    bulletin.setFrontcover(getGenericManager()
			    .getUploadedFileById(bulletin.getFrontcoverId()));
		else
		    bulletin.setFrontcover(computeUploadedFile(
			    fileFrontcoverFileName, fileFrontcover));
	    }
	} catch (Exception e) {
	}
	log.info("exit formToBean()");
    }

    public void setBulletinDate(String val) {
	bulletinDate = val;
    }

    public String getBulletinDate() {
	return bulletinDate;
    }

    public List<AppProperty> getBulletinTypeList() {
	return super.getAppPropertyList("bulletin.type");
    }

    public void setFileMyfile(java.io.File val) {
	fileMyfile = val;
    }

    public java.io.File getFileMyfile() {
	return fileMyfile;
    }

    public void setFileMyfileContentType(String val) {
	fileMyfileContentType = val;
    }

    public String getFileMyfileContentType() {
	return fileMyfileContentType;
    }

    public void setFileMyfileFileName(String val) {
	fileMyfileFileName = val;
    }

    public String getFileMyfileFileName() {
	return fileMyfileFileName;
    }

    public void setRemoveMyfile(String val) {
	removeMyfile = val;
    }

    public String getRemoveMyfile() {
	return removeMyfile;
    }

    public void setFileVoice(java.io.File val) {
	fileVoice = val;
    }

    public java.io.File getFileVoice() {
	return fileVoice;
    }

    public void setFileVoiceContentType(String val) {
	fileVoiceContentType = val;
    }

    public String getFileVoiceContentType() {
	return fileVoiceContentType;
    }

    public void setFileVoiceFileName(String val) {
	fileVoiceFileName = val;
    }

    public String getFileVoiceFileName() {
	return fileVoiceFileName;
    }

    public void setRemoveVoice(String val) {
	removeVoice = val;
    }

    public String getRemoveVoice() {
	return removeVoice;
    }

    public void setFileVedio(java.io.File val) {
	fileVedio = val;
    }

    public java.io.File getFileVedio() {
	return fileVedio;
    }

    public void setFileVedioContentType(String val) {
	fileVedioContentType = val;
    }

    public String getFileVedioContentType() {
	return fileVedioContentType;
    }

    public void setFileVedioFileName(String val) {
	fileVedioFileName = val;
    }

    public String getFileVedioFileName() {
	return fileVedioFileName;
    }

    public void setRemoveVedio(String val) {
	removeVedio = val;
    }

    public String getRemoveVedio() {
	return removeVedio;
    }
    
    

    public List<Bulletin> getBulletinList() {
	// System.out.println("subject="+subject+"  beginbDate="+begindate+"   enddate="+enddate);
	if (subject != null || begindate != null || enddate != null
		|| bulletinTypeId != null) {
	    AppProperty bulletinType = getGenericManager().getAppPropertyById(
		    bulletinTypeId);
	    return getGenericManager().getQueryBulletinList(bulletinType,
		    subject, begindate, enddate);
	} else {
	    return getGenericManager().getBulletinList();
	}
    }

    public void setSelectedBulletinIds(Long[] val) {
	selectedBulletinIds = val;
    }

    public Long[] getSelectedBulletinIds() {
	return selectedBulletinIds;
    }

    public String getSubject() {
	return subject;
    }

    public void setSubject(String subject) {
	this.subject = subject;
    }

    public Date getBegindate() {
	return begindate;
    }

    public void setBegindate(Date begindate) {
	this.begindate = begindate;
    }

    public Date getEnddate() {
	return enddate;
    }

    public void setEnddate(Date enddate) {
	this.enddate = enddate;
    }

    public Long getBulletinTypeId() {
	return bulletinTypeId;
    }

    public void setBulletinTypeId(Long bulletinTypeId) {
	this.bulletinTypeId = bulletinTypeId;
    }

    public Long getBulletinId() {
	return bulletinId;
    }

    public void setBulletinId(Long bulletinId) {
	this.bulletinId = bulletinId;
    }

    public java.io.File getFileFrontcover() {
	return fileFrontcover;
    }

    public void setFileFrontcover(java.io.File fileFrontcover) {
	this.fileFrontcover = fileFrontcover;
    }

    public String getFileFrontcoverContentType() {
	return fileFrontcoverContentType;
    }

    public void setFileFrontcoverContentType(String fileFrontcoverContentType) {
	this.fileFrontcoverContentType = fileFrontcoverContentType;
    }

    public String getFileFrontcoverFileName() {
	return fileFrontcoverFileName;
    }

    public void setFileFrontcoverFileName(String fileFrontcoverFileName) {
	this.fileFrontcoverFileName = fileFrontcoverFileName;
    }

    public String getRemoveFrontcover() {
	return removeFrontcover;
    }

    public void setRemoveFrontcover(String removeFrontcover) {
	this.removeFrontcover = removeFrontcover;
    }

}
