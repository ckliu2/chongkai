package com.city.value;

import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class CourseMember extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;

    Long id;
    
    /** nullable persistent field */
    private Boolean complete;

    /** nullable persistent field */
    private String attendlog;

    /** nullable persistent field */
    private Date lastModifiedDate;

    /** nullable persistent field */
    private Date createdDate;

    /** persistent field */
    private Course course;
    private Long courseId;

    /** persistent field */
    private Member member;
    private Long memberId;

    /** default constructor */
    public CourseMember() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getComplete() {
        return this.complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public String getAttendlog() {
        return this.attendlog;
    }

    public void setAttendlog(String attendlog) {
        this.attendlog = attendlog;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Course getCourse() {
        return this.course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Long getCourseId() {
        if (this.course != null && this.course.getId() != null)
            return course.getId();
        return this.courseId;
    }

    public void setCourseId(Long id) {
        this.courseId = id;
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
            .append("complete", getComplete())
            .append("attendlog", getAttendlog())
            .append("lastModifiedDate", getLastModifiedDate())
            .append("createdDate", getCreatedDate())
            .append("course", getCourse())
            .append("member", getMember())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
