package MITSUBISHI_G50;

import java.util.*;

public class Device {
	Calendar calendar;
	String Group;
	String Drive;
	String Mode;
	String ModeStatus;
	String SetTemp;
	String SetBack;
	String TempLimitCool;
	String TempLimitHeat;
	String TempLimit;
	String CoolMin;
	String CoolMax;
	String HeatMin;
	String HeatMax;
	String AutoMin;
	String AutoMax;
	String InletTemp;
	String AirDirection;
	String FanSpeed;
	String RemoCon;
	String DriveItem;
	String ModeItem;
	String SetTempItem;
	String FilterItem;
	String Ventilation;
	String Schedule;
	String EnergyControl;
	String FilterSign;
	String ErrorSign;
	String TurnOff;
	String TempDetail;
	String dailyMSG;
	int index;
	int hour;
	int minute;
	int week;
	int year;
	int month;
	int date;
	
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
	public String getModeStatus() {
		return ModeStatus;
	}
	public void setModeStatus(String modeStatus) {
		ModeStatus = modeStatus;
	}
	public String getSetTemp() {
		return SetTemp;
	}
	public void setSetTemp(String setTemp) {
		SetTemp = setTemp;
	}
	public String getTempLimitCool() {
		return TempLimitCool;
	}
	public void setTempLimitCool(String tempLimitCool) {
		TempLimitCool = tempLimitCool;
	}
	public String getTempLimitHeat() {
		return TempLimitHeat;
	}
	public void setTempLimitHeat(String tempLimitHeat) {
		TempLimitHeat = tempLimitHeat;
	}
	public String getTempLimit() {
		return TempLimit;
	}
	public void setTempLimit(String tempLimit) {
		TempLimit = tempLimit;
	}
	public String getCoolMin() {
		return CoolMin;
	}
	public void setCoolMin(String coolMin) {
		CoolMin = coolMin;
	}
	public String getCoolMax() {
		return CoolMax;
	}
	public void setCoolMax(String coolMax) {
		CoolMax = coolMax;
	}
	public String getHeatMin() {
		return HeatMin;
	}
	public void setHeatMin(String heatMin) {
		HeatMin = heatMin;
	}
	public String getHeatMax() {
		return HeatMax;
	}
	public void setHeatMax(String heatMax) {
		HeatMax = heatMax;
	}
	public String getAutoMin() {
		return AutoMin;
	}
	public void setAutoMin(String autoMin) {
		AutoMin = autoMin;
	}
	public String getAutoMax() {
		return AutoMax;
	}
	public void setAutoMax(String autoMax) {
		AutoMax = autoMax;
	}
	public String getInletTemp() {
		return InletTemp;
	}
	public void setInletTemp(String inletTemp) {
		InletTemp = inletTemp;
	}
	public String getAirDirection() {
		return AirDirection;
	}
	public void setAirDirection(String airDirection) {
		AirDirection = airDirection;
	}
	public String getFanSpeed() {
		return FanSpeed;
	}
	public void setFanSpeed(String fanSpeed) {
		FanSpeed = fanSpeed;
	}
	public String getRemoCon() {
		return RemoCon;
	}
	public void setRemoCon(String remoCon) {
		RemoCon = remoCon;
	}
	public String getDriveItem() {
		return DriveItem;
	}
	public void setDriveItem(String driveItem) {
		DriveItem = driveItem;
	}
	public String getModeItem() {
		return ModeItem;
	}
	public void setModeItem(String modeItem) {
		ModeItem = modeItem;
	}
	public String getSetTempItem() {
		return SetTempItem;
	}
	public void setSetTempItem(String setTempItem) {
		SetTempItem = setTempItem;
	}
	public String getFilterItem() {
		return FilterItem;
	}
	public void setFilterItem(String filterItem) {
		FilterItem = filterItem;
	}
	public String getVentilation() {
		return Ventilation;
	}
	public void setVentilation(String ventilation) {
		Ventilation = ventilation;
	}
	public String getSchedule() {
		return Schedule;
	}
	public void setSchedule(String schedule) {
		Schedule = schedule;
	}
	public String getEnergyControl() {
		return EnergyControl;
	}
	public void setEnergyControl(String energyControl) {
		EnergyControl = energyControl;
	}
	public String getFilterSign() {
		return FilterSign;
	}
	public void setFilterSign(String filterSign) {
		FilterSign = filterSign;
	}
	public String getErrorSign() {
		return ErrorSign;
	}
	public void setErrorSign(String errorSign) {
		ErrorSign = errorSign;
	}
	public String getTurnOff() {
		return TurnOff;
	}
	public void setTurnOff(String turnOff) {
		TurnOff = turnOff;
	}
	public String getTempDetail() {
		return TempDetail;
	}
	public void setTempDetail(String tempDetail) {
		TempDetail = tempDetail;
	}
	
	public String getSetBack() {
		return SetBack;
	}
	public void setSetBack(String setBack) {
		SetBack = setBack;
	}
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	
	public Calendar getCalendar() {
		return calendar;
	}
	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}
	
	public String getDailyMSG() {
		String content="";
		char c='"';
		
 		content+="<img src="+c+"./images/girl.jpg"+c+"/> <br>";
		content+="課程名稱:尚未整合<br>";
		content+="授課教師:尚未整合<br>";
		if(calendar!=null){
			content+=String.valueOf(calendar.getTime().getYear()+1900)+"/"+String.valueOf(calendar.getTime().getMonth()+1)+"/"+String.valueOf(calendar.getTime().getDate())+" "+getChineseWeek(calendar.getTime().getDay())+" "+String.valueOf(hour)+":"+String.valueOf(minute)+"<br>"; 	
		}else{
		    content+=String.valueOf(year)+"/"+String.valueOf(month+1)+"/"+String.valueOf(date)+" "+getChineseWeek(week)+" "+String.valueOf(hour)+":"+String.valueOf(minute)+"<br>";
		}
		content+="是否開啟:"+Drive+"<br>";
		content+="設定溫度:"+SetTemp+"<br>";
		content+="冷氣模式:"+Mode+"<br>";
		content+="准許手動控制開關:"+DriveItem+"<br>";
		content+="准許手動更改冷氣模式:"+ModeItem+"<br>";
		
		return content;
	}
	
	public String getChineseWeek(int week){
    	String c="";
    	switch(week){
            case 0: 
    		  c="(日)";
    	    break;	
            case 1: 
      		  c="(一)";
      	    break;
            case 2: 
      		  c="(二)";
      	    break;
            case 3: 
      		  c="(三)";
      	    break;
            case 4: 
      		  c="(四)";
      	    break;
            case 5: 
      		  c="(五)";
      	    break;
            case 6: 
      		  c="(六)";
      	    break;
    	}    	
    	return c;
    }
}
