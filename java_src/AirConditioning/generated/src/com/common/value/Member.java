package com.common.value;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Member implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private String name;

    /** persistent field */
    private String cardId;

    /** nullable persistent field */
    private String cardNo;

    /** nullable persistent field */
    private String password;

    /** nullable persistent field */
    private String email;

    /** nullable persistent field */
    private String cellphone;

    /** nullable persistent field */
    private Boolean enabled;

    /** nullable persistent field */
    private Set groups;

    /** full constructor */
    public Member(String name, String cardId, String cardNo, String password, String email, String cellphone, Boolean enabled, Set groups) {
        this.name = name;
        this.cardId = cardId;
        this.cardNo = cardNo;
        this.password = password;
        this.email = email;
        this.cellphone = cellphone;
        this.enabled = enabled;
        this.groups = groups;
    }

    /** Labor constructor */
    public Member() {
    }

    /** minimal constructor */
    public Member(String name, String cardId) {
        this.name = name;
        this.cardId = cardId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardId() {
        return this.cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardNo() {
        return this.cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set getGroups() {
        return this.groups;
    }

    public void setGroups(Set groups) {
        this.groups = groups;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("name", getName())
            .append("cardId", getCardId())
            .append("cardNo", getCardNo())
            .append("password", getPassword())
            .append("email", getEmail())
            .append("cellphone", getCellphone())
            .append("enabled", getEnabled())
            .append("groups", getGroups())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
