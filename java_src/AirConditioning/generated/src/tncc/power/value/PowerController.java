package tncc.power.value;

import com.base.value.AppProperty;
import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;
import tncc.wpc.value.Building;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class PowerController extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** nullable persistent field */
    private String name;

    /** nullable persistent field */
    private String ip;

    /** persistent field */
    private Integer port;

    /** persistent field */
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
    private AppProperty deviceType;
    private Long deviceTypeId;

    /** nullable persistent field */
    private List reader;

    /** full constructor */
    public PowerController(String name, String ip, Integer port, Integer deviceId, Date createdDate, Building building, Member createdUser, AppProperty deviceType, List reader) {
        this.name = name;
        this.ip = ip;
        this.port = port;
        this.deviceId = deviceId;
        this.createdDate = createdDate;
        this.building = building;
        this.createdUser = createdUser;
        this.deviceType = deviceType;
        this.reader = reader;
    }

    /** default constructor */
    public PowerController() {
    }

    /** minimal constructor */
    public PowerController(Integer port, Integer deviceId, Date createdDate, Building building, Member createdUser) {
        this.port = port;
        this.deviceId = deviceId;
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

    public Integer getPort() {
        return this.port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
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

    public List getReader() {
        return this.reader;
    }

    public void setReader(List reader) {
        this.reader = reader;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("name", getName())
            .append("ip", getIp())
            .append("port", getPort())
            .append("deviceId", getDeviceId())
            .append("createdDate", getCreatedDate())
            .append("building", getBuilding())
            .append("createdUser", getCreatedUser())
            .append("deviceType", getDeviceType())
            .append("reader", getReader())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
