package org.zion.value;

import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class PrayTWClaim extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private Date createdDate;

    /** persistent field */
    private org.zion.value.PrayTW praytw;
    private Long praytwId;

    /** persistent field */
    private Member member;
    private Long memberId;

    /** full constructor */
    public PrayTWClaim(Date createdDate, org.zion.value.PrayTW praytw, Member member) {
        this.createdDate = createdDate;
        this.praytw = praytw;
        this.member = member;
    }

    /** default constructor */
    public PrayTWClaim() {
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public org.zion.value.PrayTW getPraytw() {
        return this.praytw;
    }

    public void setPraytw(org.zion.value.PrayTW praytw) {
        this.praytw = praytw;
    }

    public Long getPraytwId() {
        if (this.praytw != null && this.praytw.getId() != null)
            return praytw.getId();
        return this.praytwId;
    }

    public void setPraytwId(Long id) {
        this.praytwId = id;
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
            .append("createdDate", getCreatedDate())
            .append("praytw", getPraytw())
            .append("member", getMember())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
