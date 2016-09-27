package org.zion.value;

import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class PrayYou extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    
	Long id;
	
    /** nullable persistent field */
    private String content;

    /** persistent field */
    private Date createdDate;

    /** nullable persistent field */
    private Boolean apply;

    /** persistent field */
    private org.zion.value.PrayMe prayme;
    private Long praymeId;

    /** persistent field */
    private Member member;
    private Long memberId;

    /** full constructor */
    public PrayYou(String content, Date createdDate, Boolean apply, org.zion.value.PrayMe prayme, Member member) {
        this.content = content;
        this.createdDate = createdDate;
        this.apply = apply;
        this.prayme = prayme;
        this.member = member;
    }

    /** default constructor */
    public PrayYou() {
    }

    /** minimal constructor */
    public PrayYou(Date createdDate, org.zion.value.PrayMe prayme, Member member) {
        this.createdDate = createdDate;
        this.prayme = prayme;
        this.member = member;
    }
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

    public Boolean getApply() {
        return this.apply;
    }

    public void setApply(Boolean apply) {
        this.apply = apply;
    }

    public org.zion.value.PrayMe getPrayme() {
        return this.prayme;
    }

    public void setPrayme(org.zion.value.PrayMe prayme) {
        this.prayme = prayme;
    }

    public Long getPraymeId() {
        if (this.prayme != null && this.prayme.getId() != null)
            return prayme.getId();
        return this.praymeId;
    }

    public void setPraymeId(Long id) {
        this.praymeId = id;
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
            .append("apply", getApply())
            .append("prayme", getPrayme())
            .append("member", getMember())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
