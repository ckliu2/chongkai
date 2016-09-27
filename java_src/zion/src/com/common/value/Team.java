package com.common.value;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Team implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id;
    
    
    /** persistent field */
    private String name;

    /** nullable persistent field */
    private Date createdDate;

    /** nullable persistent field */
    private com.common.value.Member primaryLeader;
    private Long primaryLeaderId;

    /** nullable persistent field */
    private com.common.value.Member secondLeader;
    private Long secondLeaderId;

    /** nullable persistent field */
    private Set members;

    /** full constructor */
    public Team(String name, Date createdDate, com.common.value.Member primaryLeader, com.common.value.Member secondLeader, Set members) {
        this.name = name;
        this.createdDate = createdDate;
        this.primaryLeader = primaryLeader;
        this.secondLeader = secondLeader;
        this.members = members;
    }

    /** default constructor */
    public Team() {
    }

    /** minimal constructor */
    public Team(String name) {
        this.name = name;
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

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public com.common.value.Member getPrimaryLeader() {
        return this.primaryLeader;
    }

    public void setPrimaryLeader(com.common.value.Member primaryLeader) {
        this.primaryLeader = primaryLeader;
    }

    public Long getPrimaryLeaderId() {
        if (this.primaryLeader != null && this.primaryLeader.getId() != null)
            return primaryLeader.getId();
        return this.primaryLeaderId;
    }

    public void setPrimaryLeaderId(Long id) {
        this.primaryLeaderId = id;
    }

    public com.common.value.Member getSecondLeader() {
        return this.secondLeader;
    }

    public void setSecondLeader(com.common.value.Member secondLeader) {
        this.secondLeader = secondLeader;
    }

    public Long getSecondLeaderId() {
        if (this.secondLeader != null && this.secondLeader.getId() != null)
            return secondLeader.getId();
        return this.secondLeaderId;
    }

    public void setSecondLeaderId(Long id) {
        this.secondLeaderId = id;
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
