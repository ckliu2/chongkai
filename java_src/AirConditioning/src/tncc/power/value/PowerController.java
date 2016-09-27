package tncc.power.value;

import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;
import tncc.wpc.value.Building;

import com.base.value.AppProperty;
import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class PowerController extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /** nullable persistent field */
    private String name;

    /** nullable persistent field */
    private String ip;

    private Integer port;

    private Integer deviceId;

    /** persistent field */
    private Date createdDate;

    /** persistent field */
    private Building building;
    private Long buildingId;

    /** persistent field */
    private Member createdUser;
    private Long createdUserId;

    /** nullable persistent field */
    private List reader;

    /** nullable persistent field */
    private AppProperty deviceType;
    private Long deviceTypeId;

    boolean active;

    /** full constructor */
    public PowerController(String name, String ip, Date createdDate,
	    Building building, Member createdUser, List reader) {
	this.name = name;
	this.ip = ip;
	this.createdDate = createdDate;
	this.building = building;
	this.createdUser = createdUser;
	this.reader = reader;
    }

    /** Labor constructor */
    public PowerController() {
    }

    /** minimal constructor */
    public PowerController(Date createdDate, Building building,
	    Member createdUser) {
	this.createdDate = createdDate;
	this.building = building;
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

    public Building getBuilding() {
	return this.building;
    }

    public void setBuilding(Building building) {
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

    public List getReader() {
	return this.reader;
    }

    public void setReader(List reader) {
	this.reader = reader;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Integer getPort() {
	return port;
    }

    public void setPort(Integer port) {
	this.port = port;
    }

    public Integer getDeviceId() {
	return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
	this.deviceId = deviceId;
    }

    public AppProperty getDeviceType() {
	return this.deviceType;
    }

    public void setDeviceType(AppProperty deviceType) {
	this.deviceType = deviceType;
    }

    public Long getDeviceTypeId() {
	if (this.deviceType != null && this.deviceType.getId() != null)
	    return deviceType.getId();
	return this.deviceTypeId;
    }

    public void setDeviceTypeId(Long id) {
	this.deviceTypeId = id;
    }
    
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String toString() {
	return new ToStringBuilder(this).append("name", getName())
		.append("ip", getIp()).append("createdDate", getCreatedDate())
		.append("building", getBuilding())
		.append("createdUser", getCreatedUser())
		.append("reader", getReader()).toString();
    }

    public String getCaption_() {
	return toString();
    }

}
