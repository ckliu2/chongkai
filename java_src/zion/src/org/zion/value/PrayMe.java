package org.zion.value;

import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class PrayMe extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    
	Long id;
	
    /** persistent field */
    private String content;

    /** persistent field */
    private Date createdDate;

    /** persistent field */
    private Member member;
    private Long memberId;
    Boolean active;

    /** full constructor */
    public PrayMe(String content, Date createdDate, Member member) {
        this.content = content;
        this.createdDate = createdDate;
        this.member = member;
    }

    /** default constructor */
    public PrayMe() {
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
    
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("content", getContent())
            .append("createdDate", getCreatedDate())
            .append("member", getMember())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
