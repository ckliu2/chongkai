package com.base.value;

import java.io.Serializable;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Group extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private String groupKey;

    /** persistent field */
    private String groupNameCh;

    /** persistent field */
    private String groupNameEn;

    /** nullable persistent field */
    private Set members;

    /** full constructor */
    public Group(String groupKey, String groupNameCh, String groupNameEn, Set members) {
        this.groupKey = groupKey;
        this.groupNameCh = groupNameCh;
        this.groupNameEn = groupNameEn;
        this.members = members;
    }

    /** Labor constructor */
    public Group() {
    }

    /** minimal constructor */
    public Group(String groupKey, String groupNameCh, String groupNameEn) {
        this.groupKey = groupKey;
        this.groupNameCh = groupNameCh;
        this.groupNameEn = groupNameEn;
    }

    public String getGroupKey() {
        return this.groupKey;
    }

    public void setGroupKey(String groupKey) {
        this.groupKey = groupKey;
    }

    public String getGroupNameCh() {
        return this.groupNameCh;
    }

    public void setGroupNameCh(String groupNameCh) {
        this.groupNameCh = groupNameCh;
    }

    public String getGroupNameEn() {
        return this.groupNameEn;
    }

    public void setGroupNameEn(String groupNameEn) {
        this.groupNameEn = groupNameEn;
    }

    public Set getMembers() {
        return this.members;
    }

    public void setMembers(Set members) {
        this.members = members;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("groupKey", getGroupKey())
            .append("groupNameCh", getGroupNameCh())
            .append("groupNameEn", getGroupNameEn())
            .append("members", getMembers())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
