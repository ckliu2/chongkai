package tncc.wpc.dao;

import tncc.wpc.value.*;

import java.util.*;

import com.base.value.AppProperty;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Fri Jan 29 14:30:29 CST 2010
*/

public interface wpcDAO extends CommonDAO 
{
    public abstract void saveBuilding(Building val);
    public abstract void removeBuilding(Building val);
    public abstract void removeBuilding(Long id);
    public abstract Building findBuildingById(Long id);
    public abstract List<Building> findAllBuilding();

    public abstract void saveSensor(Sensor val);
    public abstract void removeSensor(Sensor val);
    public abstract void removeSensor(Long id);
    public abstract Sensor findSensorById(Long id);
    public abstract List<Sensor> findAllSensor();
    public abstract List<Sensor> findAllSensorByController(Controller c);
    
    public abstract void saveRoom(Room val);
    public abstract void removeRoom(Room val);
    public abstract void removeRoom(Long id);
    public abstract Room findRoomById(Long id);
    public abstract List<Room> findAllRoom();
    public abstract List<Room> findAllRoomByBuilding(Building building);
    
    public abstract void saveController(Controller val);
    public abstract void removeController(Controller val);
    public abstract void removeController(Long id);
    public abstract Controller findControllerById(Long id);
    public abstract List<Controller> findAllController();
    public abstract List<Controller> findAllControllerByRoom(Room room);
    
    public abstract void saveSensorstatus(Sensorstatus val);
    public abstract void removeSensorstatus(Sensorstatus val);
    public abstract void removeSensorstatus(Long id);
    public abstract Sensorstatus findSensorstatusById(Long id);
    public abstract List<Sensorstatus> findAllSensorstatus();
    
    public abstract void saveDeviceProperty(DeviceProperty val);
    public abstract void removeDeviceProperty(DeviceProperty val);
    public abstract void removeDeviceProperty(Long id);
    public abstract DeviceProperty findDevicePropertyById(Long id);
    public abstract List<DeviceProperty> findAllDeviceProperty();
    public abstract List<Rule> findAllRulelListByDeviceProperty(DeviceProperty deviceProperty);
    public abstract List<Sensor> findAllSensorsByDeviceProperty(DeviceProperty val);
    	
    
    
    
    public abstract void saveEvenLevel(EvenLevel val);
    public abstract void removeEvenLevel(EvenLevel val);
    public abstract void removeEvenLevel(Long id);
    public abstract EvenLevel findEvenLevelById(Long id);
    public abstract List<EvenLevel> findAllEvenLevel();
   
    
    public abstract void saveRule(Rule val);
    public abstract void removeRule(Rule val);
    public abstract void removeRule(Long id);
    public abstract Rule findRuleById(Long id);
    public abstract List<Rule> findAllRule();
    
    public abstract void saveTimes(Times val);
    public abstract void removeTimes(Times val);
    public abstract void removeTimes(Long id);
    public abstract Times findTimesById(Long id);
    public abstract List<Times> findAllTimes();
    
    public abstract void saveMessenger(Messenger val);
    public abstract void removeMessenger(Messenger val);
    public abstract void removeMessenger(Long id);
    public abstract Messenger findMessengerById(Long id);
    public abstract List<Messenger> findAllMessenger();
    public abstract Long[] getIdsFromSecurityList(List<Security> lst);
    public abstract List<Security> getSecurityListByIds(Long[] ids);
    
    public abstract void saveSecurity(Security val);
    public abstract void removeSecurity(Security val);
    public abstract void removeSecurity(Long id);
    public abstract Security findSecurityById(Long id);
    public abstract List<Security> findAllSecurity();
    
    public abstract void saveMyDVR(MyDVR val);
    public abstract void removeMyDVR(MyDVR val);
    public abstract void removeMyDVR(Long id);
    public abstract MyDVR findMyDVRById(Long id);
    public abstract List<MyDVR> findAllMyDVR();
    
    //異常持續時間(秒)
    public abstract boolean isDuringError(int during,Sensor sensor); 
    
    //異常次數/時間
    public abstract boolean isCycleTimeError(int cycle,int time,Sensor sensor); 
    
    //規則成立與否
    public abstract List<Sensor> isRuleSetup(Times t,DeviceProperty d,AppProperty ReturnValue); 
    
}

