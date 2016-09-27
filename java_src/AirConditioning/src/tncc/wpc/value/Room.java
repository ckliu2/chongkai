package tncc.wpc.value;

import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Room extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    


	private Long id;
	
	
    /** nullable persistent field */
    private String name;

    /** persistent field */
    private Date createdDate;

    /** persistent field */
    private Member member;
    private Long memberId;

    /** persistent field */
    private tncc.wpc.value.Building building;
    private Long buildingId;

    /** persistent field */
    private Member createdUser;
    private Long createdUserId;

    /** full constructor */
    public Room(String name, Date createdDate, Member member, tncc.wpc.value.Building building, Member createdUser) {
        this.name = name;
        this.createdDate = createdDate;
        this.member = member;
        this.building = building;
        this.createdUser = createdUser;
    }

    /** Labor constructor */
    public Room() {
    }

    /** minimal constructor */
    public Room(Date createdDate, Member member, tncc.wpc.value.Building building, Member createdUser) {
        this.createdDate = createdDate;
        this.member = member;
        this.building = building;
        this.createdUser = createdUser;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    public tncc.wpc.value.Building getBuilding() {
        return this.building;
    }

    public void setBuilding(tncc.wpc.value.Building building) {
        this.building = building;
    }

    public Long getBuildingId() {
        if (this.building != null && this.building.getId() != null)
            return building.getId();
        return this.buildingId;
    }

    public void setBuildingId(Long id) {
        this.buildingId = id;
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
            .append("createdDate", getCreatedDate())
            .append("member", getMember())
            .append("building", getBuilding())
            .append("createdUser", getCreatedUser())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
