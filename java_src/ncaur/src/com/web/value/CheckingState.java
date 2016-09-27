package com.web.value;

import com.base.value.AppProperty;
import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class CheckingState extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id;
    
    /** persistent field */
    private String formName;

    /** persistent field */
    private Long formId;

    /** nullable persistent field */
    private String comment;

    /** persistent field */
    private Date createdDate;

    /** persistent field */
    private AppProperty state;
    private Long stateId;

    /** persistent field */
    private Member createdUser;
    private Long createdUserId;

    /** full constructor */
    public CheckingState(String formName, Long formId, String comment, Date createdDate, AppProperty state, Member createdUser) {
        this.formName = formName;
        this.formId = formId;
        this.comment = comment;
        this.createdDate = createdDate;
        this.state = state;
        this.createdUser = createdUser;
    }

    /** default constructor */
    public CheckingState() {
    }

    /** minimal constructor */
    public CheckingState(String formName, Long formId, Date createdDate, AppProperty state, Member createdUser) {
        this.formName = formName;
        this.formId = formId;
        this.createdDate = createdDate;
        this.state = state;
        this.createdUser = createdUser;
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public String getFormName() {
        return this.formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public Long getFormId() {
        return this.formId;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public AppProperty getState() {
        return this.state;
    }

    public void setState(AppProperty state) {
        this.state = state;
    }

    public Long getStateId() {
        if (this.state != null && this.state.getId() != null)
            return state.getId();
        return this.stateId;
    }

    public void setStateId(Long id) {
        this.stateId = id;
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("formName", getFormName())
            .append("formId", getFormId())
            .append("comment", getComment())
            .append("createdDate", getCreatedDate())
            .append("state", getState())
            .append("createdUser", getCreatedUser())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
