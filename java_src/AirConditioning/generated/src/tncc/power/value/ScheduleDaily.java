package tncc.power.value;

import com.base.value.AppProperty;
import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class ScheduleDaily extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** nullable persistent field */
    private Integer temp;

    /** persistent field */
    private Date scheduledDate;

    /** nullable persistent field */
    private Boolean active;

    /** nullable persistent field */
    private Date createdDate;

    /** nullable persistent field */
    private String ip;

    /** nullable persistent field */
    private Date lastModifiedDate;

    /** nullable persistent field */
    private String groupCode;

    /** nullable persistent field */
    private Integer courseNum;

    /** nullable persistent field */
    private Integer flag;

    /** persistent field */
    private AppProperty drive;
    private Long driveId;

    /** persistent field */
    private AppProperty mode;
    private Long modeId;

    /** nullable persistent field */
    private AppProperty fanSpeed;
    private Long fanSpeedId;

    /** nullable persistent field */
    private AppProperty lock;
    private Long lockId;

    /** persistent field */
    private AppProperty driveItem;
    private Long driveItemId;

    /** persistent field */
    private AppProperty modeItem;
    private Long modeItemId;

    /** persistent field */
    private AppProperty tempItem;
    private Long tempItemId;

    /** persistent field */
    private AppProperty filterItem;
    private Long filterItemId;

    /** nullable persistent field */
    private AppProperty type;
    private Long typeId;

    /** nullable persistent field */
    private Member lastModifiedUser;
    private Long lastModifiedUserId;

    /** nullable persistent field */
    private Set readers;

    /** full constructor */
    public ScheduleDaily(Integer temp, Date scheduledDate, Boolean active, Date createdDate, String ip, Date lastModifiedDate, String groupCode, Integer courseNum, Integer flag, AppProperty drive, AppProperty mode, AppProperty fanSpeed, AppProperty lock, AppProperty driveItem, AppProperty modeItem, AppProperty tempItem, AppProperty filterItem, AppProperty type, Member lastModifiedUser, Set readers) {
        this.temp = temp;
        this.scheduledDate = scheduledDate;
        this.active = active;
        this.createdDate = createdDate;
        this.ip = ip;
        this.lastModifiedDate = lastModifiedDate;
        this.groupCode = groupCode;
        this.courseNum = courseNum;
        this.flag = flag;
        this.drive = drive;
        this.mode = mode;
        this.fanSpeed = fanSpeed;
        this.lock = lock;
        this.driveItem = driveItem;
        this.modeItem = modeItem;
        this.tempItem = tempItem;
        this.filterItem = filterItem;
        this.type = type;
        this.lastModifiedUser = lastModifiedUser;
        this.readers = readers;
    }

    /** default constructor */
    public ScheduleDaily() {
    }

    /** minimal constructor */
    public ScheduleDaily(Date scheduledDate, AppProperty drive, AppProperty mode, AppProperty driveItem, AppProperty modeItem, AppProperty tempItem, AppProperty filterItem) {
        this.scheduledDate = scheduledDate;
        this.drive = drive;
        this.mode = mode;
        this.driveItem = driveItem;
        this.modeItem = modeItem;
        this.tempItem = tempItem;
        this.filterItem = filterItem;
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

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getGroupCode() {
        return this.groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public Integer getCourseNum() {
        return this.courseNum;
    }

    public void setCourseNum(Integer courseNum) {
        this.courseNum = courseNum;
    }

    public Integer getFlag() {
        return this.flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
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

    public AppProperty getFanSpeed() {
        return this.fanSpeed;
    }

    public void setFanSpeed(AppProperty fanSpeed) {
        this.fanSpeed = fanSpeed;
    }

    public Long getFanSpeedId() {
        if (this.fanSpeed != null && this.fanSpeed.getId() != null)
            return fanSpeed.getId();
        return this.fanSpeedId;
    }

    public void setFanSpeedId(Long id) {
        this.fanSpeedId = id;
    }

    public AppProperty getLock() {
        return this.lock;
    }

    public void setLock(AppProperty lock) {
        this.lock = lock;
    }

    public Long getLockId() {
        if (this.lock != null && this.lock.getId() != null)
            return lock.getId();
        return this.lockId;
    }

    public void setLockId(Long id) {
        this.lockId = id;
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

    public AppProperty getType() {
        return this.type;
    }

    public void setType(AppProperty type) {
        this.type = type;
    }

    public Long getTypeId() {
        if (this.type != null && this.type.getId() != null)
            return type.getId();
        return this.typeId;
    }

    public void setTypeId(Long id) {
        this.typeId = id;
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

    public Set getReaders() {
        return this.readers;
    }

    public void setReaders(Set readers) {
        this.readers = readers;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("temp", getTemp())
            .append("scheduledDate", getScheduledDate())
            .append("active", getActive())
            .append("createdDate", getCreatedDate())
            .append("ip", getIp())
            .append("lastModifiedDate", getLastModifiedDate())
            .append("groupCode", getGroupCode())
            .append("courseNum", getCourseNum())
            .append("flag", getFlag())
            .append("drive", getDrive())
            .append("mode", getMode())
            .append("fanSpeed", getFanSpeed())
            .append("lock", getLock())
            .append("driveItem", getDriveItem())
            .append("modeItem", getModeItem())
            .append("tempItem", getTempItem())
            .append("filterItem", getFilterItem())
            .append("type", getType())
            .append("lastModifiedUser", getLastModifiedUser())
            .append("readers", getReaders())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
