package HoneyWell;

import java.util.*;


import com.common.value.Member;

import tncc.power.value.*;

public class Device {
    String id;
    ScheduleReaderDaily scheduleReaderDaily;
    PowerController powerController;
    String Group;
    String Drive;
    String Mode;
    String SetTemp;
    String InletTemp;
    String FanSpeed;
    String Lock;
    Date scheduledDate;
    String statusCode;
    ScheduleDaily scheduledaily;
    String detection;
    java.sql.Timestamp timestamp;

    public Device() {

    }

    public String getId() {
	return powerController.getId()+"-"+Group;
    }


    public Device(PowerController powerController) {
	this.powerController = powerController;
    }

    public PowerController getPowerController() {
	return powerController;
    }

    public void setPowerController(PowerController powerController) {
	this.powerController = powerController;
    }

    public String getGroup() {
	return Group;
    }

    public void setGroup(String group) {
	Group = group;
    }

    public String getDrive() {
	return Drive;
    }

    public void setDrive(String drive) {
	Drive = drive;
    }

    public String getMode() {
	return Mode;
    }

    public void setMode(String mode) {
	Mode = mode;
    }

    public String getSetTemp() {
	return SetTemp;
    }

    public void setSetTemp(String setTemp) {
	SetTemp = setTemp;
    }

    public String getInletTemp() {
	return InletTemp;
    }

    public void setInletTemp(String inletTemp) {
	InletTemp = inletTemp;
    }

    public String getFanSpeed() {
	return FanSpeed;
    }

    public void setFanSpeed(String fanSpeed) {
	FanSpeed = fanSpeed;
    }

    public String getLock() {
	return Lock;
    }

    public void setLock(String lock) {
	Lock = lock;
    }

    public Date getScheduledDate() {
	return scheduledDate;
    }

    public void setScheduledDate(Date scheduledDate) {
	this.scheduledDate = scheduledDate;
    }

    public ScheduleReaderDaily getScheduleReaderDaily() {
	return scheduleReaderDaily;
    }

    public void setScheduleReaderDaily(ScheduleReaderDaily scheduleReaderDaily) {
	this.scheduleReaderDaily = scheduleReaderDaily;
    }

    public String getStatusCode() {
	return statusCode;
    }

    public void setStatusCode(String statusCode) {
	this.statusCode = statusCode;
    }

    public ScheduleDaily getScheduledaily() {
	return scheduledaily;
    }

    public void setScheduledaily(ScheduleDaily scheduledaily) {
	this.scheduledaily = scheduledaily;
    }

    public java.sql.Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(java.sql.Timestamp timestamp) {
        this.timestamp = timestamp;
    }
    
    public String getDetection() {
	String lockcode = "";
	if (Lock.equals("lock")) {
	    lockcode = "1";
	} else {
	    lockcode = "0";
	}
	if(SetTemp.length()==2){
	    SetTemp=SetTemp+"0";
	}
	
	 return Drive + "-" + Mode + "-" + SetTemp.replace(".", "") + "-"
		+ FanSpeed + "-" + lockcode;
	 
	
    }

}
