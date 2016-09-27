package tncc.wpc.value;

import com.base.value.AppProperty;
import com.common.value.Member;
import java.io.Serializable;
import java.util.*;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Rule extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;   


	private Long id;
    
    /** nullable persistent field */
    private String name;

    /** nullable persistent field */
    private Integer during;

    /** nullable persistent field */
    private String memo;

    /** persistent field */
    private Date createdDate;

    /** persistent field */
    private Member member;
    private Long memberId;

    /** persistent field */
    private Member createdUser;
    private Long createdUserId;
    
    
    /** nullable persistent field */
    private DeviceProperty deviceProperty;
    private Long devicePropertyId;



    /** persistent field */
    private AppProperty status;
    private Long statusId;

    /** persistent field */
    private tncc.wpc.value.Times times;
    private Long timesId;

    /** persistent field */
    private tncc.wpc.value.EvenLevel evenLevel;
    private Long evenLevelId;

    /** persistent field */
    private AppProperty decision;
    private Long decisionId;
    
    
    /** nullable persistent field */
    private List conditions;

    /** full constructor */
    public Rule(String name, Integer during, String memo, Date createdDate, Member member, Member createdUser, tncc.wpc.value.DeviceProperty deviceProperty, AppProperty status, tncc.wpc.value.Times times, tncc.wpc.value.EvenLevel evenLevel, AppProperty decision) {
        this.name = name;
        this.during = during;
        this.memo = memo;
        this.createdDate = createdDate;
        this.member = member;
        this.createdUser = createdUser;
        this.status = status;
        this.times = times;
        this.evenLevel = evenLevel;
        this.decision = decision;
    }

    /** Labor constructor */
    public Rule() {
    }

    /** minimal constructor */
    public Rule(Date createdDate, Member member, Member createdUser, tncc.wpc.value.DeviceProperty deviceProperty, AppProperty status, tncc.wpc.value.Times times, tncc.wpc.value.EvenLevel evenLevel, AppProperty decision) {
        this.createdDate = createdDate;
        this.member = member;
        this.createdUser = createdUser;
        this.status = status;
        this.times = times;
        this.evenLevel = evenLevel;
        this.decision = decision;
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

    public Integer getDuring() {
        return this.during;
    }

    public void setDuring(Integer during) {
        this.during = during;
    }

    public String getMemo() {
        return this.memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
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


    public AppProperty getStatus() {
        return this.status;
    }

    public void setStatus(AppProperty status) {
        this.status = status;
    }

    public Long getStatusId() {
        if (this.status != null && this.status.getId() != null)
            return status.getId();
        return this.statusId;
    }

    public void setStatusId(Long id) {
        this.statusId = id;
    }

    public tncc.wpc.value.Times getTimes() {
        return this.times;
    }

    public void setTimes(tncc.wpc.value.Times times) {
        this.times = times;
    }

    public Long getTimesId() {
        if (this.times != null && this.times.getId() != null)
            return times.getId();
        return this.timesId;
    }

    public void setTimesId(Long id) {
        this.timesId = id;
    }

    public tncc.wpc.value.EvenLevel getEvenLevel() {
        return this.evenLevel;
    }

    public void setEvenLevel(tncc.wpc.value.EvenLevel evenLevel) {
        this.evenLevel = evenLevel;
    }

    public Long getEvenLevelId() {
        if (this.evenLevel != null && this.evenLevel.getId() != null)
            return evenLevel.getId();
        return this.evenLevelId;
    }

    public void setEvenLevelId(Long id) {
        this.evenLevelId = id;
    }

    public AppProperty getDecision() {
        return this.decision;
    }

    public void setDecision(AppProperty decision) {
        this.decision = decision;
    }

    public Long getDecisionId() {
        if (this.decision != null && this.decision.getId() != null)
            return decision.getId();
        return this.decisionId;
    }

    public void setDecisionId(Long id) {
        this.decisionId = id;
    }
    
    public DeviceProperty getDeviceProperty() {
        return this.deviceProperty;
    }

    public void setDeviceProperty(DeviceProperty deviceProperty) {
        this.deviceProperty = deviceProperty;
    }

    public Long getDevicePropertyId() {
        if (this.deviceProperty != null && this.deviceProperty.getId() != null)
            return deviceProperty.getId();
        return this.devicePropertyId;
    }

    public void setDevicePropertyId(Long id) {
        this.devicePropertyId = id;
    }
    
    public List getConditions() {
        return this.conditions;
    }

    public void setConditions(List conditions) {
        this.conditions = conditions;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("name", getName())
            .append("during", getDuring())
            .append("memo", getMemo())
            .append("createdDate", getCreatedDate())
            .append("member", getMember())
            .append("createdUser", getCreatedUser())
            .append("status", getStatus())
            .append("times", getTimes())
            .append("evenLevel", getEvenLevel())
            .append("decision", getDecision())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
