package tncc.wpc.value;

import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Controller extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;    


	private Long id;
	
	
    /** nullable persistent field */
    private String name;

    /** nullable persistent field */
    private String ip;

    /** persistent field */
    private Date createdDate;

    /** persistent field */
    private Member member;
    private Long memberId;

    /** persistent field */
    private tncc.wpc.value.Room room;
    private Long roomId;

    /** persistent field */
    private Member createdUser;
    private Long createdUserId;

    /** full constructor */
    public Controller(String name, String ip, Date createdDate, Member member, tncc.wpc.value.Room room, Member createdUser) {
        this.name = name;
        this.ip = ip;
        this.createdDate = createdDate;
        this.member = member;
        this.room = room;
        this.createdUser = createdUser;
    }

    /** Labor constructor */
    public Controller() {
    }

    /** minimal constructor */
    public Controller(Date createdDate, Member member, tncc.wpc.value.Room room, Member createdUser) {
        this.createdDate = createdDate;
        this.member = member;
        this.room = room;
        this.createdUser = createdUser;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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

    public tncc.wpc.value.Room getRoom() {
        return this.room;
    }

    public void setRoom(tncc.wpc.value.Room room) {
        this.room = room;
    }

    public Long getRoomId() {
        if (this.room != null && this.room.getId() != null)
            return room.getId();
        return this.roomId;
    }

    public void setRoomId(Long id) {
        this.roomId = id;
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
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public String toString() {
        return new ToStringBuilder(this)
            .append("name", getName())
            .append("ip", getIp())
            .append("createdDate", getCreatedDate())
            .append("member", getMember())
            .append("room", getRoom())
            .append("createdUser", getCreatedUser())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
