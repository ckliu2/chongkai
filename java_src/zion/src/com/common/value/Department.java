package com.common.value;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id;
    
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

    /** nullable persistent field */
    private Set members;

    /** full constructor */
    public Department(String name, String ename, Date lastModifiedDate, String lastModifiedUser, Date createdDate, String createdUser, Set members) {
        this.name = name;
        this.ename = ename;
        this.lastModifiedDate = lastModifiedDate;
        this.lastModifiedUser = lastModifiedUser;
        this.createdDate = createdDate;
        this.createdUser = createdUser;
        this.members = members;
    }

    /** default constructor */
    public Department() {
    }

    /** minimal constructor */
    public Department(String name, String ename) {
        this.name = name;
        this.ename = ename;
    }
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

    public Set getMembers() {
        return this.members;
    }

    public void setMembers(Set members) {
        this.members = members;
    }

    public String toString() {
        return getName();
    }

    public String getCaption_() {
        return toString();
    }

}
