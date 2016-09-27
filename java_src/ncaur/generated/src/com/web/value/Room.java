package com.web.value;

import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Room extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** nullable persistent field */
    private String no;

    /** persistent field */
    private String name;

    /** persistent field */
    private Integer floor;

    /** persistent field */
    private Integer seqNo;

    /** nullable persistent field */
    private String meno;

    /** persistent field */
    private Date lastModifiedDate;

    /** persistent field */
    private Date createdDate;

    /** persistent field */
    private Member lastModifiedUser;
    private Long lastModifiedUserId;

    /** nullable persistent field */
    private Member createdUser;
    private Long createdUserId;

    /** full constructor */
    public Room(String no, String name, Integer floor, Integer seqNo, String meno, Date lastModifiedDate, Date createdDate, Member lastModifiedUser, Member createdUser) {
        this.no = no;
        this.name = name;
        this.floor = floor;
        this.seqNo = seqNo;
        this.meno = meno;
        this.lastModifiedDate = lastModifiedDate;
        this.createdDate = createdDate;
        this.lastModifiedUser = lastModifiedUser;
        this.createdUser = createdUser;
    }

    /** default constructor */
    public Room() {
    }

    /** minimal constructor */
    public Room(String name, Integer floor, Integer seqNo, Date lastModifiedDate, Date createdDate, Member lastModifiedUser) {
        this.name = name;
        this.floor = floor;
        this.seqNo = seqNo;
        this.lastModifiedDate = lastModifiedDate;
        this.createdDate = createdDate;
        this.lastModifiedUser = lastModifiedUser;
    }

    public String getNo() {
        return this.no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFloor() {
        return this.floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getSeqNo() {
        return this.seqNo;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public String getMeno() {
        return this.meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
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

    public Member getLastModifiedUser() {
        return this.lastModifiedUser;
    }

    public void setLastModifiedUser(Member lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    public Long getLastModifiedUserId() {
        if (this.lastModifiedUser != null && this.lastModifiedUser.getId() != null)
            return lastModifiedUser.getId();
        return this.lastModifiedUserId;
    }

    public void setLastModifiedUserId(Long id) {
        this.lastModifiedUserId = id;
    }

    public Member getCreatedUser() {
        return this.createdUser;
    }

    public void setCreatedUser(Member createdUser) {
        this.createdUser = createdUser;
    }

    public Long getCreatedUserId() {
        if (this.createdUser != null && this.createdUser.getId() != null)
            return createdUser.getId();
        return this.createdUserId;
    }

    public void setCreatedUserId(Long id) {
        this.createdUserId = id;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("no", getNo())
            .append("name", getName())
            .append("floor", getFloor())
            .append("seqNo", getSeqNo())
            .append("meno", getMeno())
            .append("lastModifiedDate", getLastModifiedDate())
            .append("createdDate", getCreatedDate())
            .append("lastModifiedUser", getLastModifiedUser())
            .append("createdUser", getCreatedUser())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
