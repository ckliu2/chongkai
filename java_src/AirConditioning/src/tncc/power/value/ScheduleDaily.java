package tncc.power.value;

import com.base.value.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;
import com.base.value.*;
import com.common.value.*;

/** @author Hibernate CodeGenerator */
public class ScheduleDaily extends BaseObject implements Serializable {

    Long id;

    private static final long serialVersionUID = 1L;
    /** nullable persistent field */
    private Integer temp;

    /** nullable persistent field */
    private Date scheduledDate;

    /** nullable persistent field */
    private Boolean active;

    /** nullable persistent field */
    private Date createdDate;

    /** nullable persistent field */
    private AppProperty drive;
    private Long driveId;

    /** nullable persistent field */
    private AppProperty mode;
    private Long modeId;

    private AppProperty fanSpeed;
    private Long fanSpeedId;

    /** nullable persistent field */
    private AppProperty driveItem;
    private Long driveItemId;

    /** nullable persistent field */
    private AppProperty modeItem;
    private Long modeItemId;

    private AppProperty lock;
    private Long lockId;

    /** nullable persistent field */
    private AppProperty tempItem;
    private Long tempItemId;

    /** nullable persistent field */
    private AppProperty filterItem;
    private Long filterItemId;

    private AppProperty type;

    /** nullable persistent field */
    private Set readers;

    String ip;

    Date lastModifiedDate;

    Member lastModifiedUser;

    String groupCode;

    Integer courseNum;

    Integer flag;

    Boolean pass;

    /** full constructor */
    public ScheduleDaily(Integer temp, Date scheduledDate, Boolean active,
	    Date createdDate, AppProperty drive, AppProperty mode,
	    AppProperty driveItem, AppProperty modeItem, AppProperty tempItem,
	    AppProperty filterItem, Set readers) {
	this.temp = temp;
	this.scheduledDate = scheduledDate;
	this.active = active;
	this.createdDate = createdDate;
	this.drive = drive;
	this.mode = mode;
	this.driveItem = driveItem;
	this.modeItem = modeItem;
	this.tempItem = tempItem;
	this.filterItem = filterItem;
	this.readers = readers;
    }

    /** Labor constructor */
    public ScheduleDaily() {
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Integer getTemp() {
	return this.temp;
    }

    public void setTemp(Integer temp) {
	this.temp = temp;
    }

    public Date getScheduledDate() {
	return this.scheduledDate;
    }

    public void setScheduledDate(Date scheduledDate) {
	this.scheduledDate = scheduledDate;
    }

    public Boolean getActive() {
	return this.active;
    }

    public void setActive(Boolean active) {
	this.active = active;
    }

    public Date getCreatedDate() {
	return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
	this.createdDate = createdDate;
    }

    public AppProperty getDrive() {
	return this.drive;
    }

    public void setDrive(AppProperty drive) {
	this.drive = drive;
    }

    public Long getDriveId() {
	if (this.drive != null && this.drive.getId() != null)
	    return drive.getId();
	return this.driveId;
    }

    public void setDriveId(Long id) {
	this.driveId = id;
    }

    public AppProperty getMode() {
	return this.mode;
    }

    public void setMode(AppProperty mode) {
	this.mode = mode;
    }

    public Long getModeId() {
	if (this.mode != null && this.mode.getId() != null)
	    return mode.getId();
	return this.modeId;
    }

    public void setModeId(Long id) {
	this.modeId = id;
    }

    public AppProperty getDriveItem() {
	return this.driveItem;
    }

    public void setDriveItem(AppProperty driveItem) {
	this.driveItem = driveItem;
    }

    public Long getDriveItemId() {
	if (this.driveItem != null && this.driveItem.getId() != null)
	    return driveItem.getId();
	return this.driveItemId;
    }

    public void setDriveItemId(Long id) {
	this.driveItemId = id;
    }

    public AppProperty getModeItem() {
	return this.modeItem;
    }

    public void setModeItem(AppProperty modeItem) {
	this.modeItem = modeItem;
    }

    public Long getModeItemId() {
	if (this.modeItem != null && this.modeItem.getId() != null)
	    return modeItem.getId();
	return this.modeItemId;
    }

    public void setModeItemId(Long id) {
	this.modeItemId = id;
    }

    public AppProperty getTempItem() {
	return this.tempItem;
    }

    public void setTempItem(AppProperty tempItem) {
	this.tempItem = tempItem;
    }

    public Long getTempItemId() {
	if (this.tempItem != null && this.tempItem.getId() != null)
	    return tempItem.getId();
	return this.tempItemId;
    }

    public void setTempItemId(Long id) {
	this.tempItemId = id;
    }

    public AppProperty getFilterItem() {
	return this.filterItem;
    }

    public void setFilterItem(AppProperty filterItem) {
	this.filterItem = filterItem;
    }

    public Long getFilterItemId() {
	if (this.filterItem != null && this.filterItem.getId() != null)
	    return filterItem.getId();
	return this.filterItemId;
    }

    public void setFilterItemId(Long id) {
	this.filterItemId = id;
    }

    public Set getReaders() {
	return this.readers;
    }

    public void setReaders(Set readers) {
	this.readers = readers;
    }

    public AppProperty getFanSpeed() {
	return fanSpeed;
    }

    public void setFanSpeed(AppProperty fanSpeed) {
	this.fanSpeed = fanSpeed;
    }

    public Long getFanSpeedId() {
	if (this.fanSpeed != null && this.fanSpeed.getId() != null)
	    return fanSpeed.getId();
	return this.fanSpeedId;
    }

    public void setFanSpeedId(Long fanSpeedId) {
	this.fanSpeedId = fanSpeedId;
    }

    public AppProperty getLock() {
	return lock;
    }

    public void setLock(AppProperty lock) {
	this.lock = lock;
    }

    public Long getLockId() {
	if (this.lock != null && this.lock.getId() != null)
	    return lock.getId();
	return this.lockId;
    }

    public void setLockId(Long lockId) {
	this.lockId = lockId;
    }

    public AppProperty getType() {
	return type;
    }

    public void setType(AppProperty type) {
	this.type = type;
    }

    public String getIp() {
	return ip;
    }

    public void setIp(String ip) {
	this.ip = ip;
    }

    public Date getLastModifiedDate() {
	return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
	this.lastModifiedDate = lastModifiedDate;
    }

    public Member getLastModifiedUser() {
	return lastModifiedUser;
    }

    public void setLastModifiedUser(Member lastModifiedUser) {
	this.lastModifiedUser = lastModifiedUser;
    }

    public String getGroupCode() {
	return groupCode;
    }

    public void setGroupCode(String groupCode) {
	this.groupCode = groupCode;
    }

    public Integer getCourseNum() {
	return courseNum;
    }

    public void setCourseNum(Integer courseNum) {
	this.courseNum = courseNum;
    }

    public Integer getFlag() {
	return flag;
    }

    public void setFlag(Integer flag) {
	this.flag = flag;
    }
    
    public Boolean getPass() {
        return pass;
    }

    public void setPass(Boolean pass) {
        this.pass = pass;
    }

    public String toString() {
	return new ToStringBuilder(this).append("temp", getTemp())
		.append("scheduledDate", getScheduledDate())
		.append("active", getActive())
		.append("createdDate", getCreatedDate())
		.append("drive", getDrive()).append("mode", getMode())
		.append("driveItem", getDriveItem())
		.append("modeItem", getModeItem())
		.append("tempItem", getTempItem())
		.append("filterItem", getFilterItem())
		.append("readers", getReaders()).toString();
    }

    public String getCaption_() {
	return toString();
    }

}
