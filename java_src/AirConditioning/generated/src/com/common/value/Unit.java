package com.common.value;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Unit implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private String name;

    /** persistent field */
    private String ename;

    /** nullable persistent field */
    private Date lastModifiedDate;

    /** nullable persistent field */
    private String lastModifiedUser;

    /** nullable persistent field */
    private Date createdDate;

    /** nullable persistent field */
    private String createdUser;

    /** full constructor */
    public Unit(String name, String ename, Date lastModifiedDate, String lastModifiedUser, Date createdDate, String createdUser) {
        this.name = name;
        this.ename = ename;
        this.lastModifiedDate = lastModifiedDate;
        this.lastModifiedUser = lastModifiedUser;
        this.createdDate = createdDate;
        this.createdUser = createdUser;
    }

    /** Labor constructor */
    public Unit() {
    }

    /** minimal constructor */
    public Unit(String name, String ename) {
        this.name = name;
        this.ename = ename;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEname() {
        return this.ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedUser() {
        return this.lastModifiedUser;
    }

    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedUser() {
        return this.createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("name", getName())
            .append("ename", getEname())
            .append("lastModifiedDate", getLastModifiedDate())
            .append("lastModifiedUser", getLastModifiedUser())
            .append("createdDate", getCreatedDate())
            .append("createdUser", getCreatedUser())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
