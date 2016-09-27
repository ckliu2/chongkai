package tncc.wpc.value;

import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Sensor extends BaseObject implements Serializable {

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
    private tncc.wpc.value.Controller controller;
    private Long controllerId;

    /** persistent field */
    private Member createdUser;
    private Long createdUserId;

	private boolean status;
	
	
    /** persistent field */
    private DeviceProperty deviceProperty;
    private Long devicePropertyId;
    
    /** nullable persistent field */
    private MyDVR mydvr;
    private Long mydvrId;


	/** nullable persistent field */
    private Integer channel;

    /** full constructor */
    public Sensor(String name, Date createdDate, Member member, tncc.wpc.value.Controller controller, Member createdUser) {
        this.name = name;
        this.createdDate = createdDate;
        this.member = member;
        this.controller = controller;
        this.createdUser = createdUser;
    }

    /** Labor constructor */
    public Sensor() {
    }

    /** minimal constructor */
    public Sensor(Date createdDate, Member member, tncc.wpc.value.Controller controller, Member createdUser) {
        this.createdDate = createdDate;
        this.member = member;
        this.controller = controller;
        this.createdUser = createdUser;
    }
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
    public Integer getChannel() {
		return channel;
	}

	public void setChannel(Integer channel) {
		this.channel = channel;
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

    public tncc.wpc.value.Controller getController() {
        return this.controller;
    }

    public void setController(tncc.wpc.value.Controller controller) {
        this.controller = controller;
    }

    public Long getControllerId() {
        if (this.controller != null && this.controller.getId() != null)
            return controller.getId();
        return this.controllerId;
    }

    public void setControllerId(Long id) {
        this.controllerId = id;
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
    
    
    public boolean isStatus() {
		return status;
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
    
    public MyDVR getMydvr() {
        return this.mydvr;
    }

    public void setMydvr(MyDVR mydvr) {
        this.mydvr = mydvr;
    }

    public Long getMydvrId() {
        if (this.mydvr != null && this.mydvr.getId() != null)
            return mydvr.getId();
        return this.mydvrId;
    }

    public void setMydvrId(Long id) {
        this.mydvrId = id;
    }


    public String toString() {
        return new ToStringBuilder(this)
            .append("name", getName())
            .append("createdDate", getCreatedDate())
            .append("member", getMember())
            .append("controller", getController())
            .append("createdUser", getCreatedUser())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
