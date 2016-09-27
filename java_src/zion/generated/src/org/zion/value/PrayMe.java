package org.zion.value;

import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class PrayMe extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private String content;

    /** persistent field */
    private Date createdDate;

    /** nullable persistent field */
    private Boolean active;

    /** persistent field */
    private Member member;
    private Long memberId;

    /** full constructor */
    public PrayMe(String content, Date createdDate, Boolean active, Member member) {
        this.content = content;
        this.createdDate = createdDate;
        this.active = active;
        this.member = member;
    }

    /** default constructor */
    public PrayMe() {
    }

    /** minimal constructor */
    public PrayMe(String content, Date createdDate, Member member) {
        this.content = content;
        this.createdDate = createdDate;
        this.member = member;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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
            .append("content", getContent())
            .append("createdDate", getCreatedDate())
            .append("active", getActive())
            .append("member", getMember())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
