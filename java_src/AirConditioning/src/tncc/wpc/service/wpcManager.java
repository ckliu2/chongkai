package tncc.wpc.service;

import tncc.wpc.value.*;

import com.base.value.*;

import java.util.*;

import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Fri Jan 29 14:30:29 CST 2010
*/

public interface wpcManager extends CommonManager 
{
    public abstract void saveBuilding(Building val);
    public abstract void removeBuilding(Building val);
    public abstract void removeBuilding(Long id);
    public abstract Building getBuildingById(Long id);
    public abstract List<Building> getBuildingList();

    public abstract void saveRoom(Room val);
    public abstract void removeRoom(Room val);
    public abstract void removeRoom(Long id);
    public abstract Room getRoomById(Long id);
    public abstract List<Room> getRoomList();
    public abstract List<Room> getRoomListByBuilding(Building building);
    
    public abstract void saveSensor(Sensor val);
    public abstract void removeSensor(Sensor val);
    public abstract void removeSensor(Long id);
    public abstract Sensor getSensorById(Long id);
    public abstract List<Sensor> getSensorList();
    public abstract List<Sensor> getSensorListByController(Controller c);
    
    public abstract void saveController(Controller val);
    public abstract void removeController(Controller val);
    public abstract void removeController(Long id);
    public abstract Controller getControllerById(Long id);
    public abstract List<Controller> getControllerList();
    public abstract List<Controller> getControllerByRoom(Room room);
    
    
    public abstract void saveSensorstatus(Sensorstatus val);
    public abstract void removeSensorstatus(Sensorstatus val);
    public abstract void removeSensorstatus(Long id);
    public abstract Sensorstatus getSensorstatusById(Long id);
    public abstract List<Sensorstatus> getSensorstatusList();
    
    public abstract void saveDeviceProperty(DeviceProperty val);
    public abstract void removeDeviceProperty(DeviceProperty val);
    public abstract void removeDeviceProperty(Long id);
    public abstract DeviceProperty getDevicePropertyById(Long id);
    public abstract List<DeviceProperty> getDevicePropertyList();    
    public abstract List<Rule> getRuleListByDeviceProperty(DeviceProperty deviceProperty);
    public abstract List<Sensor> getSensorsByDeviceProperty(DeviceProperty val);  
    
    
    
    public abstract void saveEvenLevel(EvenLevel val);
    public abstract void removeEvenLevel(EvenLevel val);
    public abstract void removeEvenLevel(Long id);
    public abstract EvenLevel getEvenLevelById(Long id);
    public abstract List<EvenLevel> getEvenLevelList();
    
    public abstract void saveRule(Rule val);
    public abstract void removeRule(Rule val);
    public abstract void removeRule(Long id);
    public abstract Rule getRuleById(Long id);
    public abstract List<Rule> getRuleList();
    
    public abstract void saveTimes(Times val);
    public abstract void removeTimes(Times val);
    public abstract void removeTimes(Long id);
    public abstract Times getTimesById(Long id);
    public abstract List<Times> getTimesList();
    
    public abstract void saveMessenger(Messenger val);
    public abstract void removeMessenger(Messenger val);
    public abstract void removeMessenger(Long id);
    public abstract Messenger getMessengerById(Long id);
    public abstract List<Messenger> getMessengerList();
    public abstract Long[] getIdsFromSecurityList(List<Security> lst);
    public abstract List<Security> getSecurityListByIds(Long[] ids);
    
    
    public abstract void saveSecurity(Security val);
    public abstract void removeSecurity(Security val);
    public abstract void removeSecurity(Long id);
    public abstract Security getSecurityById(Long id);
    public abstract List<Security> getSecurityList();
    
    public abstract void saveMyDVR(MyDVR val);
    public abstract void removeMyDVR(MyDVR val);
    public abstract void removeMyDVR(Long id);
    public abstract MyDVR getMyDVRById(Long id);
    public abstract List<MyDVR> getMyDVRList();

    
    //異常持續時間(秒)
    public abstract boolean isDuringError(int during,Sensor sensor); 
    
    //異常次數/時間
    public abstract boolean isCycleTimeError(int cycle,int time,Sensor sensor); 
    
    //規則成立與否
    public abstract List<Sensor> isRuleSetup(Times t,DeviceProperty d,AppProperty ReturnValue); 
    
    


}

