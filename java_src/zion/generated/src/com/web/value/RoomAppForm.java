package com.web.value;

import com.base.value.AppProperty;
import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class RoomAppForm extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private Date date;

    /** nullable persistent field */
    private String otherMeeting;

    /** nullable persistent field */
    private String meno;

    /** nullable persistent field */
    private Date borrowDate;

    /** nullable persistent field */
    private String state;

    /** persistent field */
    private Date lastModifiedDate;

    /** persistent field */
    private Date createdDate;

    /** persistent field */
    private AppProperty meeting;
    private Long meetingId;

    /** persistent field */
    private com.web.value.Clock applyBeginClock;
    private Long applyBeginClockId;

    /** persistent field */
    private com.web.value.Clock applyEndClock;
    private Long applyEndClockId;

    /** persistent field */
    private Member lastModifiedUser;
    private Long lastModifiedUserId;

    /** nullable persistent field */
    private Member createdUser;
    private Long createdUserId;

    /** nullable persistent field */
    private List room;

    /** full constructor */
    public RoomAppForm(Date date, String otherMeeting, String meno, Date borrowDate, String state, Date lastModifiedDate, Date createdDate, AppProperty meeting, com.web.value.Clock applyBeginClock, com.web.value.Clock applyEndClock, Member lastModifiedUser, Member createdUser, List room) {
        this.date = date;
        this.otherMeeting = otherMeeting;
        this.meno = meno;
        this.borrowDate = borrowDate;
        this.state = state;
        this.lastModifiedDate = lastModifiedDate;
        this.createdDate = createdDate;
        this.meeting = meeting;
        this.applyBeginClock = applyBeginClock;
        this.applyEndClock = applyEndClock;
        this.lastModifiedUser = lastModifiedUser;
        this.createdUser = createdUser;
        this.room = room;
    }

    /** default constructor */
    public RoomAppForm() {
    }

    /** minimal constructor */
    public RoomAppForm(Date date, Date lastModifiedDate, Date createdDate, AppProperty meeting, com.web.value.Clock applyBeginClock, com.web.value.Clock applyEndClock, Member lastModifiedUser) {
        this.date = date;
        this.lastModifiedDate = lastModifiedDate;
        this.createdDate = createdDate;
        this.meeting = meeting;
        this.applyBeginClock = applyBeginClock;
        this.applyEndClock = applyEndClock;
        this.lastModifiedUser = lastModifiedUser;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOtherMeeting() {
        return this.otherMeeting;
    }

    public void setOtherMeeting(String otherMeeting) {
        this.otherMeeting = otherMeeting;
    }

    public String getMeno() {
        return this.meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public Date getBorrowDate() {
        return this.borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
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

    public AppProperty getMeeting() {
        return this.meeting;
    }

    public void setMeeting(AppProperty meeting) {
        this.meeting = meeting;
    }

    public Long getMeetingId() {
        if (this.meeting != null && this.meeting.getId() != null)
            return meeting.getId();
        return this.meetingId;
    }

    public void setMeetingId(Long id) {
        this.meetingId = id;
    }

    public com.web.value.Clock getApplyBeginClock() {
        return this.applyBeginClock;
    }

    public void setApplyBeginClock(com.web.value.Clock applyBeginClock) {
        this.applyBeginClock = applyBeginClock;
    }

    public Long getApplyBeginClockId() {
        if (this.applyBeginClock != null && this.applyBeginClock.getId() != null)
            return applyBeginClock.getId();
        return this.applyBeginClockId;
    }

    public void setApplyBeginClockId(Long id) {
        this.applyBeginClockId = id;
    }

    public com.web.value.Clock getApplyEndClock() {
        return this.applyEndClock;
    }

    public void setApplyEndClock(com.web.value.Clock applyEndClock) {
        this.applyEndClock = applyEndClock;
    }

    public Long getApplyEndClockId() {
        if (this.applyEndClock != null && this.applyEndClock.getId() != null)
            return applyEndClock.getId();
        return this.applyEndClockId;
    }

    public void setApplyEndClockId(Long id) {
        this.applyEndClockId = id;
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

    public List getRoom() {
        return this.room;
    }

    public void setRoom(List room) {
        this.room = room;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("date", getDate())
            .append("otherMeeting", getOtherMeeting())
            .append("meno", getMeno())
            .append("borrowDate", getBorrowDate())
            .append("state", getState())
            .append("lastModifiedDate", getLastModifiedDate())
            .append("createdDate", getCreatedDate())
            .append("meeting", getMeeting())
            .append("applyBeginClock", getApplyBeginClock())
            .append("applyEndClock", getApplyEndClock())
            .append("lastModifiedUser", getLastModifiedUser())
            .append("createdUser", getCreatedUser())
            .append("room", getRoom())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
