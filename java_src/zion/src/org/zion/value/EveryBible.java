package org.zion.value;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;
import com.common.value.Member;

/** @author Hibernate CodeGenerator */
public class EveryBible extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;


    Long id;
    
    /** persistent field */
    private String name;

    /** persistent field */
    private Date startDate;

    /** persistent field */
    private Integer volume;

    /** persistent field */
    private Integer chapter;    


    Member member;

    /** full constructor */
    public EveryBible(String name, Date startDate, Integer volume, Integer chapter) {
        this.name = name;
        this.startDate = startDate;
        this.volume = volume;
        this.chapter = chapter;
    }

    /** default constructor */
    public EveryBible() {
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
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("name", getName())
            .append("startDate", getStartDate())
            .append("volume", getVolume())
            .append("chapter", getChapter())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
