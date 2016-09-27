package com.web.value;

import com.base.value.*;
import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;
import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Bulletin extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /** persistent field */
    private Date bulletinDate;

    /** persistent field */
    private String subject;

    /** nullable persistent field */
    private String title;

    /** nullable persistent field */
    private String description;

    /** nullable persistent field */
    private String placeDesc;

    /** nullable persistent field */
    private String timeDesc;

    /** nullable persistent field */
    private String speaker;

    /** nullable persistent field */
    private String flv;

    private String worshipFlv;

    /** nullable persistent field */
    private Boolean status;

    /** persistent field */
    private Date lastModifiedDate;

    /** persistent field */
    private Date createdDate;

    /** persistent field */
    private Member lastModifiedUser;
    private Long lastModifiedUserId;

    /** persistent field */
    private Member createdUser;
    private Long createdUserId;

    /** persistent field */
    private AppProperty bulletinType;
    private Long bulletinTypeId;

    /** nullable persistent field */
    private UploadedFile myfile;
    private String myfileFileName;
    private Long myfileId;

    /** nullable persistent field */
    private UploadedFile voice;
    private String voiceFileName;
    private Long voiceId;

    /** nullable persistent field */
    private UploadedFile vedio;
    private String vedioFileName;
    private Long vedioId;

    /** nullable persistent field */
    private UploadedFile frontcover;
    private String frontcoverFileName;
    private Long frontcoverId;

    /** default constructor */
    public Bulletin() {
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Date getBulletinDate() {
	return this.bulletinDate;
    }

    public void setBulletinDate(Date bulletinDate) {
	this.bulletinDate = bulletinDate;
    }

    public String getSubject() {
	return this.subject;
    }

    public void setSubject(String subject) {
	this.subject = subject;
    }

    public String getTitle() {
	return this.title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public String getDescription() {
	return this.description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getPlaceDesc() {
	return this.placeDesc;
    }

    public void setPlaceDesc(String placeDesc) {
	this.placeDesc = placeDesc;
    }

    public String getTimeDesc() {
	return this.timeDesc;
    }

    public void setTimeDesc(String timeDesc) {
	this.timeDesc = timeDesc;
    }

    public String getSpeaker() {
	return this.speaker;
    }

    public void setSpeaker(String speaker) {
	this.speaker = speaker;
    }

    public Boolean getStatus() {
	return this.status;
    }

    public void setStatus(Boolean status) {
	this.status = status;
    }

    public Date getLastModifiedDate() {
	return this.lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
	this.lastModifiedDate = lastModifiedDate;
    }

    public Date getCreatedDate() {
	return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
	this.createdDate = createdDate;
    }

    public Member getLastModifiedUser() {
	return this.lastModifiedUser;
    }

    public void setLastModifiedUser(Member lastModifiedUser) {
	this.lastModifiedUser = lastModifiedUser;
    }

    public Long getLastModifiedUserId() {
	if (this.lastModifiedUser != null
		&& this.lastModifiedUser.getId() != null)
	    return lastModifiedUser.getId();
	return this.lastModifiedUserId;
    }

    public void setLastModifiedUserId(Long id) {
	this.lastModifiedUserId = id;
    }

    public Member getCreatedUser() {
	return this.createdUser;
    }

    public void setCreatedUser(Member createdUser) {
	this.createdUser = createdUser;
    }

    public Long getCreatedUserId() {
	if (this.createdUser != null && this.createdUser.getId() != null)
	    return createdUser.getId();
	return this.createdUserId;
    }

    public void setCreatedUserId(Long id) {
	this.createdUserId = id;
    }

    public AppProperty getBulletinType() {
	return this.bulletinType;
    }

    public void setBulletinType(AppProperty bulletinType) {
	this.bulletinType = bulletinType;
    }

    public Long getBulletinTypeId() {
	if (this.bulletinType != null && this.bulletinType.getId() != null)
	    return bulletinType.getId();
	return this.bulletinTypeId;
    }

    public void setBulletinTypeId(Long id) {
	this.bulletinTypeId = id;
    }

    public UploadedFile getVoice() {
	return this.voice;
    }

    public void setVoice(UploadedFile voice) {
	this.voice = voice;
    }

    public String getVoiceFileName() {
	return this.voiceFileName;
    }

    public void setVoiceFileName(String val) {
	this.voiceFileName = val;
    }

    public Long getVoiceId() {
	if (this.voice != null && this.voice.getId() != null)
	    return voice.getId();
	return this.voiceId;
    }

    public void setVoiceId(Long id) {
	this.voiceId = id;
    }

    public UploadedFile getVedio() {
	return this.vedio;
    }

    public void setVedio(UploadedFile vedio) {
	this.vedio = vedio;
    }

    public String getVedioFileName() {
	return this.vedioFileName;
    }

    public void setVedioFileName(String val) {
	this.vedioFileName = val;
    }

    public Long getVedioId() {
	if (this.vedio != null && this.vedio.getId() != null)
	    return vedio.getId();
	return this.vedioId;
    }

    public void setVedioId(Long id) {
	this.vedioId = id;
    }

    public String getFlv() {
	return flv;
    }

    public void setFlv(String flv) {
	this.flv = flv;
    }

    public String getWorshipFlv() {
	return worshipFlv;
    }

    public void setWorshipFlv(String worshipFlv) {
	this.worshipFlv = worshipFlv;
    }

    public UploadedFile getFrontcover() {
	return this.frontcover;
    }

    public void setFrontcover(UploadedFile frontcover) {
	this.frontcover = frontcover;
    }

    public String getFrontcoverFileName() {
	return this.frontcoverFileName;
    }

    public void setFrontcoverFileName(String val) {
	this.frontcoverFileName = val;
    }

    public Long getFrontcoverId() {
	if (this.frontcover != null && this.frontcover.getId() != null)
	    return frontcover.getId();
	return this.frontcoverId;
    }

    public void setFrontcoverId(Long id) {
	this.frontcoverId = id;
    }

    public UploadedFile getMyfile() {
	return this.myfile;
    }

    public void setMyfile(UploadedFile myfile) {
	this.myfile = myfile;
    }

    public String getMyfileFileName() {
	return this.myfileFileName;
    }

    public void setMyfileFileName(String val) {
	this.myfileFileName = val;
    }

    public Long getMyfileId() {
	if (this.myfile != null && this.myfile.getId() != null)
	    return myfile.getId();
	return this.myfileId;
    }

    public void setMyfileId(Long id) {
	this.myfileId = id;
    }

    public String toString() {
	return new ToStringBuilder(this)
		.append("bulletinDate", getBulletinDate())
		.append("subject", getSubject()).append("title", getTitle())
		.append("description", getDescription())
		.append("placeDesc", getPlaceDesc())
		.append("timeDesc", getTimeDesc())
		.append("speaker", getSpeaker()).append("status", getStatus())
		.append("lastModifiedDate", getLastModifiedDate())
		.append("createdDate", getCreatedDate())
		.append("lastModifiedUser", getLastModifiedUser())
		.append("createdUser", getCreatedUser())
		.append("bulletinType", getBulletinType())
		.append("voice", getVoice()).append("vedio", getVedio())
		.toString();
    }

    public String getCaption_() {
	return toString();
    }

}
