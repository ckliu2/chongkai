package org.zion.value;

import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class EveryBible extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private String name;

    /** persistent field */
    private Date startDate;

    /** persistent field */
    private Integer volume;

    /** persistent field */
    private Integer chapter;

    /** persistent field */
    private Member member;
    private Long memberId;

    /** full constructor */
    public EveryBible(String name, Date startDate, Integer volume, Integer chapter, Member member) {
        this.name = name;
        this.startDate = startDate;
        this.volume = volume;
        this.chapter = chapter;
        this.member = member;
    }

    /** default constructor */
    public EveryBible() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getVolume() {
        return this.volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getChapter() {
        return this.chapter;
    }

    public void setChapter(Integer chapter) {
        this.chapter = chapter;
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
            .append("name", getName())
            .append("startDate", getStartDate())
            .append("volume", getVolume())
            .append("chapter", getChapter())
            .append("member", getMember())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
