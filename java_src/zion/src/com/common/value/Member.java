package com.common.value;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Member implements Serializable {

	Long id;

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private String name;

    /** nullable persistent field */
    private String nickname;

    /** nullable persistent field */
    private String email;

    /** nullable persistent field */
    private String cellphone;

    /** persistent field */
    private Date lastModifiedDate;

    /** nullable persistent field */
    private Date createdDate;

    /** nullable persistent field */
    private Set groups;

    /** nullable persistent field */
    private Set grades;

    /** nullable persistent field */
    private Set teams;

    /** full constructor */
    public Member(String name, String nickname, String email, String cellphone, Date lastModifiedDate, Date createdDate, Set groups, Set grades, Set teams) {
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.cellphone = cellphone;
        this.lastModifiedDate = lastModifiedDate;
        this.createdDate = createdDate;
        this.groups = groups;
        this.grades = grades;
        this.teams = teams;
    }

    /** default constructor */
    public Member() {
    }

    /** minimal constructor */
    public Member(String name, Date lastModifiedDate) {
        this.name = name;
        this.lastModifiedDate = lastModifiedDate;
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

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return this.cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
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

    public Set getGroups() {
        return this.groups;
    }

    public void setGroups(Set groups) {
        this.groups = groups;
    }

    public Set getGrades() {
        return this.grades;
    }

    public void setGrades(Set grades) {
        this.grades = grades;
    }

    public Set getTeams() {
        return this.teams;
    }

    public void setTeams(Set teams) {
        this.teams = teams;
    }

    public String toString() {
        return getName();
    }

    public String getCaption_() {
        return toString();
    }

}
