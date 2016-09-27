package com.web.value;

import com.base.value.AppProperty;
import com.common.value.Member;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Consultant extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    
    Long id;

	/** persistent field */
    private AppProperty type;
    private Long typeId;

    /** persistent field */
    private Member member;
    private Long memberId;

    /** full constructor */
    public Consultant(AppProperty type, Member member) {
        this.type = type;
        this.member = member;
    }

    /** default constructor */
    public Consultant() {
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

    public Member getMember() {
        return this.member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Long getMemberId() {
        if (this.member != null && this.member.getId() != null)
            return member.getId();
        return this.memberId;
    }

    public void setMemberId(Long id) {
        this.memberId = id;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("type", getType())
            .append("member", getMember())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
