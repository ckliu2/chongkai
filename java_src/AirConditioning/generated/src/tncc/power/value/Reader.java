package tncc.power.value;

import com.base.value.AppProperty;
import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.base.value.BaseObject;

/** @author Hibernate CodeGenerator */
public class Reader extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;
    /** persistent field */
    private String name;

    /** persistent field */
    private String seqName;

    /** persistent field */
    private Integer readerId;

    /** persistent field */
    private Date createdDate;

    /** nullable persistent field */
    private Integer temp;

    /** nullable persistent field */
    private Boolean active;

    /** nullable persistent field */
    private Boolean sync;

    /** nullable persistent field */
    private Boolean clearDaily;

    /** nullable persistent field */
    private Boolean powerstatus;

    /** nullable persistent field */
    private String information;

    /** nullable persistent field */
    private Date lastModifiedDate;

    /** nullable persistent field */
    private Member createdUser;
    private Long createdUserId;

    /** nullable persistent field */
    private AppProperty drive;
    private Long driveId;

    /** nullable persistent field */
    private AppProperty mode;
    private Long modeId;

    /** nullable persistent field */
    private AppProperty fanSpeed;
    private Long fanSpeedId;

    /** nullable persistent field */
    private AppProperty driveItem;
    private Long driveItemId;

    /** nullable persistent field */
    private AppProperty modeItem;
    private Long modeItemId;

    /** nullable persistent field */
    private AppProperty tempItem;
    private Long tempItemId;

    /** nullable persistent field */
    private AppProperty filterItem;
    private Long filterItemId;

    /** nullable persistent field */
    private AppProperty lock;
    private Long lockId;

    /** nullable persistent field */
    private AppProperty state;
    private Long stateId;

    /** nullable persistent field */
    private Set scheduleDailys;

    /** full constructor */
    public Reader(String name, String seqName, Integer readerId, Date createdDate, Integer temp, Boolean active, Boolean sync, Boolean clearDaily, Boolean powerstatus, String information, Date lastModifiedDate, Member createdUser, AppProperty drive, AppProperty mode, AppProperty fanSpeed, AppProperty driveItem, AppProperty modeItem, AppProperty tempItem, AppProperty filterItem, AppProperty lock, AppProperty state, Set scheduleDailys) {
        this.name = name;
        this.seqName = seqName;
        this.readerId = readerId;
        this.createdDate = createdDate;
        this.temp = temp;
        this.active = active;
        this.sync = sync;
        this.clearDaily = clearDaily;
        this.powerstatus = powerstatus;
        this.information = information;
        this.lastModifiedDate = lastModifiedDate;
        this.createdUser = createdUser;
        this.drive = drive;
        this.mode = mode;
        this.fanSpeed = fanSpeed;
        this.driveItem = driveItem;
        this.modeItem = modeItem;
        this.tempItem = tempItem;
        this.filterItem = filterItem;
        this.lock = lock;
        this.state = state;
        this.scheduleDailys = scheduleDailys;
    }

    /** default constructor */
    public Reader() {
    }

    /** minimal constructor */
    public Reader(String name, String seqName, Integer readerId, Date createdDate) {
        this.name = name;
        this.seqName = seqName;
        this.readerId = readerId;
        this.createdDate = createdDate;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeqName() {
        return this.seqName;
    }

    public void setSeqName(String seqName) {
        this.seqName = seqName;
    }

    public Integer getReaderId() {
        return this.readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getTemp() {
        return this.temp;
    }

    public void setTemp(Integer temp) {
        this.temp = temp;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getSync() {
        return this.sync;
    }

    public void setSync(Boolean sync) {
        this.sync = sync;
    }

    public Boolean getClearDaily() {
        return this.clearDaily;
    }

    public void setClearDaily(Boolean clearDaily) {
        this.clearDaily = clearDaily;
    }

    public Boolean getPowerstatus() {
        return this.powerstatus;
    }

    public void setPowerstatus(Boolean powerstatus) {
        this.powerstatus = powerstatus;
    }

    public String getInformation() {
        return this.information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
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

    public AppProperty getState() {
        return this.state;
    }

    public void setState(AppProperty state) {
        this.state = state;
    }

    public Long getStateId() {
        if (this.state != null && this.state.getId() != null)
            return state.getId();
        return this.stateId;
    }

    public void setStateId(Long id) {
        this.stateId = id;
    }

    public Set getScheduleDailys() {
        return this.scheduleDailys;
    }

    public void setScheduleDailys(Set scheduleDailys) {
        this.scheduleDailys = scheduleDailys;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("name", getName())
            .append("seqName", getSeqName())
            .append("readerId", getReaderId())
            .append("createdDate", getCreatedDate())
            .append("temp", getTemp())
            .append("active", getActive())
            .append("sync", getSync())
            .append("clearDaily", getClearDaily())
            .append("powerstatus", getPowerstatus())
            .append("information", getInformation())
            .append("lastModifiedDate", getLastModifiedDate())
            .append("createdUser", getCreatedUser())
            .append("drive", getDrive())
            .append("mode", getMode())
            .append("fanSpeed", getFanSpeed())
            .append("driveItem", getDriveItem())
            .append("modeItem", getModeItem())
            .append("tempItem", getTempItem())
            .append("filterItem", getFilterItem())
            .append("lock", getLock())
            .append("state", getState())
            .append("scheduleDailys", getScheduleDailys())
            .toString();
    }

    public String getCaption_() {
        return toString();
    }

}
