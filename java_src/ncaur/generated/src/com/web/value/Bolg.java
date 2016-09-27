package com.web.value;

import com.base.value.AppProperty;
import com.base.value.UploadedFile;
import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Bolg extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private String name;

    /** nullable persistent field */
    private String title;

    /** nullable persistent field */
    private String link;

    /** nullable persistent field */
    private String content;

    /** nullable persistent field */
    private String memo;

    /** persistent field */
    private Integer seqNo;

    /** nullable persistent field */
    private Boolean status;

    /** nullable persistent field */
    private Date beginDate;

    /** nullable persistent field */
    private Date endDate;

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

    /** nullable persistent field */
    private UploadedFile myfile;
    private String myfileFileName;
    private Long myfileId;

    /** nullable persistent field */
    private UploadedFile photo;
    private String photoFileName;
    private Long photoId;

    /** nullable persistent field */
    private com.web.value.BolgClass bolgClass;
    private Long bolgClassId;

    /** nullable persistent field */
    private AppProperty linkType;
    private Long linkTypeId;

    /** full constructor */
    public Bolg(String name, String title, String link, String content, String memo, Integer seqNo, Boolean status, Date beginDate, Date endDate, Date lastModifiedDate, Date createdDate, Member lastModifiedUser, Member createdUser, UploadedFile myfile, UploadedFile photo, com.web.value.BolgClass bolgClass, AppProperty linkType) {
        this.name = name;
        this.title = title;
        this.link = link;
        this.content = content;
        this.memo = memo;
        this.seqNo = seqNo;
        this.status = status;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.lastModifiedDate = lastModifiedDate;
        this.createdDate = createdDate;
        this.lastModifiedUser = lastModifiedUser;
        this.createdUser = createdUser;
        this.myfile = myfile;
        this.photo = photo;
        this.bolgClass = bolgClass;
        this.linkType = linkType;
    }

    /** default constructor */
    public Bolg() {
    }

    /** minimal constructor */
    public Bolg(String name, Integer seqNo, Date lastModifiedDate, Date createdDate, Member lastModifiedUser, Member createdUser) {
        this.name = name;
        this.seqNo = seqNo;
        this.lastModifiedDate = lastModifiedDate;
        this.createdDate = createdDate;
        this.lastModifiedUser = lastModifiedUser;
        this.createdUser = createdUser;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMemo() {
        return this.memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Integer getSeqNo() {
        return this.seqNo;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getBeginDate() {
        return this.beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
        if (this.lastModifiedUser != null && this.lastModifiedUser.getId() != null)
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

    public UploadedFile getPhoto() {
        return this.photo;
    }

    public void setPhoto(UploadedFile photo) {
        this.photo = photo;
    }

    public String getPhotoFileName() {
        return this.photoFileName;
    }

    public void setPhotoFileName(String val) {
        this.photoFileName = val;
    }

    public Long getPhotoId() {
        if (this.photo != null && this.photo.getId() != null)
            return photo.getId();
        return this.photoId;
    }

    public void setPhotoId(Long id) {
        this.photoId = id;
    }

    public com.web.value.BolgClass getBolgClass() {
        return this.bolgClass;
    }

    public void setBolgClass(com.web.value.BolgClass bolgClass) {
        this.bolgClass = bolgClass;
    }

    public Long getBolgClassId() {
        if (this.bolgClass != null && this.bolgClass.getId() != null)
            return bolgClass.getId();
        return this.bolgClassId;
    }

    public void setBolgClassId(Long id) {
        this.bolgClassId = id;
    }

    public AppProperty getLinkType() {
        return this.linkType;
    }

    public void setLinkType(AppProperty linkType) {
        this.linkType = linkType;
    }

    public Long getLinkTypeId() {
        if (this.linkType != null && this.linkType.getId() != null)
            return linkType.getId();
        return this.linkTypeId;
    }

    public void setLinkTypeId(Long id) {
        this.linkTypeId = id;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("name", getName())
            .append("title", getTitle())
            .append("link", getLink())
            .append("content", getContent())
            .append("memo", getMemo())
            .append("seqNo", getSeqNo())
            .append("status", getStatus())
            .append("beginDate", getBeginDate())
            .append("endDate", getEndDate())
            .append("lastModifiedDate", getLastModifiedDate())
            .append("createdDate", getCreatedDate())
            .append("lastModifiedUser", getLastModifiedUser())
            .append("createdUser", getCreatedUser())
            .append("myfile", getMyfile())
            .append("photo", getPhoto())
            .append("bolgClass", getBolgClass())
            .append("linkType", getLinkType())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
