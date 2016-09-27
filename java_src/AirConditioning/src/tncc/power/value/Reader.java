package tncc.power.value;

import com.common.value.Member;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import com.base.value.*;

/** @author Hibernate CodeGenerator */
public class Reader extends BaseObject implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /** persistent field */
    private String name;

    private String seqName;

    private Integer readerId;

    /** persistent field */
    private Date createdDate;

    /** persistent field */
    private Member createdUser;
    private Long createdUserId;

    private Integer temp;

    /** nullable persistent field */
    private AppProperty drive;
    private Long driveId;

    /** nullable persistent field */
    private AppProperty mode;
    private Long modeId;

    /** nullable persistent field */
    private AppProperty driveItem;
    private Long driveItemId;

    /** nullable persistent field */
    private AppProperty modeItem;
    private Long modeItemId;

    /** nullable persistent field */
    private AppProperty tempItem;
    private Long tempItemId;

    private AppProperty fanSpeed;
    private Long fanSpeedId;

    /** nullable persistent field */
    private AppProperty filterItem;
    private Long filterItemId;

    private AppProperty lock;
    private Long lockId;

    Set scheduleDailys;

    Boolean active;

    Boolean sync;

    Boolean pass;

    Boolean clearDaily;

    Boolean powerstatus;

    private AppProperty state;

    private Long stateId;

    String information;

    Date lastModifiedDate;

    /** Labor constructor */
    public Reader() {
    }

    public String getSeqName() {
	return seqName;
    }

    public void setSeqName(String seqName) {
	this.seqName = seqName;
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

    public Integer getReaderId() {
	return readerId;
    }

    public void setReaderId(Integer readerId) {
	this.readerId = readerId;
    }

    public String toString() {
	return getName();
    }

    public Integer getTemp() {
	return this.temp;
    }

    public void setTemp(Integer temp) {
	this.temp = temp;
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

    public Long getStateId() {
	if (this.state != null && this.state.getId() != null)
	    return state.getId();
	return this.stateId;
    }

    public void setStateId(Long id) {
	this.stateId = id;
    }

    public Boolean getActive() {
	return active;
    }

    public void setActive(Boolean active) {
	this.active = active;
    }

    public Boolean getSync() {
	return sync;
    }

    public void setSync(Boolean sync) {
	this.sync = sync;
    }

    public Set getScheduleDailys() {
	return scheduleDailys;
    }

    public void setScheduleDailys(Set scheduleDailys) {
	this.scheduleDailys = scheduleDailys;
    }

    public Boolean getClearDaily() {
	return clearDaily;
    }

    public void setClearDaily(Boolean clearDaily) {
	this.clearDaily = clearDaily;
    }

    public AppProperty getState() {
	return state;
    }

    public void setState(AppProperty state) {
	this.state = state;
    }

    public Boolean getPowerstatus() {
	return powerstatus;
    }

    public void setPowerstatus(Boolean powerstatus) {
	this.powerstatus = powerstatus;
    }

    public String getInformation() {
	return information;
    }

    public void setInformation(String information) {
	this.information = information;
    }

    public Date getLastModifiedDate() {
	return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
	this.lastModifiedDate = lastModifiedDate;
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

    public void setLockId(Long id) {
	this.lockId = id;
    }

    public String getCaption_() {
	return toString();
    }
    
    public Boolean getPass() {
        return pass;
    }

    public void setPass(Boolean pass) {
        this.pass = pass;
    }

}
