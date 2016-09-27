package com.web.value;

import com.base.value.AppProperty;
import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class PerRefer extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private String name;

    /** persistent field */
    private String email;

    /** persistent field */
    private String phone;

    /** persistent field */
    private String cellphone;

    /** nullable persistent field */
    private String memo;

    /** nullable persistent field */
    private Boolean note;

    /** persistent field */
    private Date createdDate;

    /** nullable persistent field */
    private AppProperty type;
    private Long typeId;

    /** nullable persistent field */
    private AppProperty qatype;
    private Long qatypeId;

    /** nullable persistent field */
    private Member teacher;
    private Long teacherId;

    /** full constructor */
    public PerRefer(String name, String email, String phone, String cellphone, String memo, Boolean note, Date createdDate, AppProperty type, AppProperty qatype, Member teacher) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.cellphone = cellphone;
        this.memo = memo;
        this.note = note;
        this.createdDate = createdDate;
        this.type = type;
        this.qatype = qatype;
        this.teacher = teacher;
    }

    /** default constructor */
    public PerRefer() {
    }

    /** minimal constructor */
    public PerRefer(String name, String email, String phone, String cellphone, Date createdDate) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.cellphone = cellphone;
        this.createdDate = createdDate;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCellphone() {
        return this.cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getMemo() {
        return this.memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Boolean getNote() {
        return this.note;
    }

    public void setNote(Boolean note) {
        this.note = note;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public AppProperty getType() {
        return this.type;
    }

    public void setType(AppProperty type) {
        this.type = type;
    }

    public Long getTypeId() {
        if (this.type != null && this.type.getId() != null)
            return type.getId();
        return this.typeId;
    }

    public void setTypeId(Long id) {
        this.typeId = id;
    }

    public AppProperty getQatype() {
        return this.qatype;
    }

    public void setQatype(AppProperty qatype) {
        this.qatype = qatype;
    }

    public Long getQatypeId() {
        if (this.qatype != null && this.qatype.getId() != null)
            return qatype.getId();
        return this.qatypeId;
    }

    public void setQatypeId(Long id) {
        this.qatypeId = id;
    }

    public Member getTeacher() {
        return this.teacher;
    }

    public void setTeacher(Member teacher) {
        this.teacher = teacher;
    }

    public Long getTeacherId() {
        if (this.teacher != null && this.teacher.getId() != null)
            return teacher.getId();
        return this.teacherId;
    }

    public void setTeacherId(Long id) {
        this.teacherId = id;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("name", getName())
            .append("email", getEmail())
            .append("phone", getPhone())
            .append("cellphone", getCellphone())
            .append("memo", getMemo())
            .append("note", getNote())
            .append("createdDate", getCreatedDate())
            .append("type", getType())
            .append("qatype", getQatype())
            .append("teacher", getTeacher())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
