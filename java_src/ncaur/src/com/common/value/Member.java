package com.common.value;

import com.base.value.UploadedFile;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Member implements Serializable {

    private static final long serialVersionUID = 1L;

    Long id;
    
    /** persistent field */
    private String cname;

    /** nullable persistent field */
    private String rgno;

    /** nullable persistent field */
    private String ename;

    /** persistent field */
    private Integer sex;

    /** persistent field */
    private Date birthday;

    /** persistent field */
    private String idNo;

    /** persistent field */
    private String homePhone;

    /** persistent field */
    private String homeZip;

    /** persistent field */
    private String homeAddress;

    /** nullable persistent field */
    private String company;

    /** nullable persistent field */
    private String companyPhone;

    /** nullable persistent field */
    private String companyFax;

    /** nullable persistent field */
    private String title;

    /** nullable persistent field */
    private String companyWeb;

    /** persistent field */
    private String cellphone;

    /** persistent field */
    private String email;

    /** nullable persistent field */
    private String line;

    /** nullable persistent field */
    private String facebook;

    /** nullable persistent field */
    private String companyZip;

    /** nullable persistent field */
    private String companyAddress;

    /** nullable persistent field */
    private String businessItem;

    /** nullable persistent field */
    private String receipt;

    /** nullable persistent field */
    private String companyId;

    /** nullable persistent field */
    private String aliases;

    /** nullable persistent field */
    private Date applyDate;

    /** nullable persistent field */
    private Date lastModifiedDate;

    /** nullable persistent field */
    private Date createdDate;

    /** nullable persistent field */
    private UploadedFile photo;
    private String photoFileName;
    private Long photoId;

    /** nullable persistent field */
    private List contacts;

    /** nullable persistent field */
    private List experiences;

    /** nullable persistent field */
    private List schools;

    private Set groups;

    /** default constructor */
    public Member() {
    }

    /** minimal constructor */
    public Member(String cname, Integer sex, Date birthday, String idNo, String homePhone, String homeZip, String homeAddress, String cellphone, String email) {
        this.cname = cname;
        this.sex = sex;
        this.birthday = birthday;
        this.idNo = idNo;
        this.homePhone = homePhone;
        this.homeZip = homeZip;
        this.homeAddress = homeAddress;
        this.cellphone = cellphone;
        this.email = email;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCname() {
        return this.cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getRgno() {
        return this.rgno;
    }

    public void setRgno(String rgno) {
        this.rgno = rgno;
    }

    public String getEname() {
        return this.ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getSex() {
        return this.sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdNo() {
        return this.idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getHomePhone() {
        return this.homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getHomeZip() {
        return this.homeZip;
    }

    public void setHomeZip(String homeZip) {
        this.homeZip = homeZip;
    }

    public String getHomeAddress() {
        return this.homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanyPhone() {
        return this.companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyFax() {
        return this.companyFax;
    }

    public void setCompanyFax(String companyFax) {
        this.companyFax = companyFax;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompanyWeb() {
        return this.companyWeb;
    }

    public void setCompanyWeb(String companyWeb) {
        this.companyWeb = companyWeb;
    }

    public String getCellphone() {
        return this.cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLine() {
        return this.line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getFacebook() {
        return this.facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getCompanyZip() {
        return this.companyZip;
    }

    public void setCompanyZip(String companyZip) {
        this.companyZip = companyZip;
    }

    public String getCompanyAddress() {
        return this.companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getBusinessItem() {
        return this.businessItem;
    }

    public void setBusinessItem(String businessItem) {
        this.businessItem = businessItem;
    }

    public String getReceipt() {
        return this.receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getCompanyId() {
        return this.companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getAliases() {
        return this.aliases;
    }

    public void setAliases(String aliases) {
        this.aliases = aliases;
    }

    public Date getApplyDate() {
        return this.applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
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

    public List getContacts() {
        return this.contacts;
    }

    public void setContacts(List contacts) {
        this.contacts = contacts;
    }

    public List getExperiences() {
        return this.experiences;
    }

    public void setExperiences(List experiences) {
        this.experiences = experiences;
    }

    public List getSchools() {
        return this.schools;
    }

    public void setSchools(List schools) {
        this.schools = schools;
    }
     
    public Set getGroups() {
	return groups;
    }

    public void setGroups(Set groups) {
	this.groups = groups;
    } 
    
   
    
    public String toString() {
        return new ToStringBuilder(this)
            .append("cname", getCname())         
            .append("rgno", getRgno())
            .append("ename", getEname())
            .append("sex", getSex())
            .append("birthday", getBirthday())
            .append("idNo", getIdNo())
            .append("homePhone", getHomePhone())
            .append("homeZip", getHomeZip())
            .append("homeAddress", getHomeAddress())
            .append("company", getCompany())
            .append("companyPhone", getCompanyPhone())
            .append("companyFax", getCompanyFax())
            .append("title", getTitle())
            .append("companyWeb", getCompanyWeb())
            .append("cellphone", getCellphone())
            .append("email", getEmail())
            .append("line", getLine())
            .append("facebook", getFacebook())
            .append("companyZip", getCompanyZip())
            .append("companyAddress", getCompanyAddress())
            .append("businessItem", getBusinessItem())
            .append("receipt", getReceipt())
            .append("companyId", getCompanyId())
            .append("aliases", getAliases())
            .append("applyDate", getApplyDate())
            .append("lastModifiedDate", getLastModifiedDate())
            .append("createdDate", getCreatedDate())
            .append("photo", getPhoto())
            .append("contacts", getContacts())
            .append("experiences", getExperiences())
            .append("schools", getSchools())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
