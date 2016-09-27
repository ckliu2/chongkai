package tncc.wpc.service.impl;

import tncc.wpc.service.*;
import tncc.wpc.dao.*;
import tncc.wpc.value.*;

import java.util.*;

import com.base.value.AppProperty;
import com.common.service.impl.CommonManagerImpl;

public class wpcManagerImpl extends CommonManagerImpl implements wpcManager
{

    public wpcManagerImpl()
    {
    }

    public wpcDAO getGenericDAO()
    {
        return (wpcDAO)super.getGenericDAO();
    }

    public void setGenericDAO(wpcDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveBuilding(Building val)
    {
        getGenericDAO().saveBuilding(val);
    }

    public void removeBuilding(Building val)
    {
        getGenericDAO().removeBuilding(val);
    }

    public void removeBuilding(Long id)
    {
        getGenericDAO().removeBuilding(id);
    }

    public Building getBuildingById(Long id)
    {
         return getGenericDAO().findBuildingById(id);
    }

    public List<Building> getBuildingList()
    {
        return getGenericDAO().findAllBuilding();
    }

    
    
    //sensor
    
    public void saveSensor(Sensor val)
    {
        getGenericDAO().saveSensor(val);
    }

    public void removeSensor(Sensor val)
    {
        getGenericDAO().removeSensor(val);
    }

    public void removeSensor(Long id)
    {
        getGenericDAO().removeSensor(id);
    }

    public Sensor getSensorById(Long id)
    {
         return getGenericDAO().findSensorById(id);
    }

    public List<Sensor> getSensorList()
    {
        return getGenericDAO().findAllSensor();
    }
    
    public List<Sensor> getSensorListByController(Controller c)
    {
        return getGenericDAO().findAllSensorByController(c);
    }  
    
    //room
    
     public void saveRoom(Room val)
    {
        getGenericDAO().saveRoom(val);
    }

    public void removeRoom(Room val)
    {
        getGenericDAO().removeRoom(val);
    }

    public void removeRoom(Long id)
    {
        getGenericDAO().removeRoom(id);
    }

    public Room getRoomById(Long id)
    {
         return getGenericDAO().findRoomById(id);
    }

    public List<Room> getRoomList()
    {
        return getGenericDAO().findAllRoom();
    }
    
    public List<Room> getRoomListByBuilding(Building building)
    {
        return getGenericDAO().findAllRoomByBuilding(building);
    }   
    
    
    //controller
    
    public void saveController(Controller val)
    {
        getGenericDAO().saveController(val);
    }

    public void removeController(Controller val)
    {
        getGenericDAO().removeController(val);
    }

    public void removeController(Long id)
    {
        getGenericDAO().removeController(id);
    }

    public Controller getControllerById(Long id)
    {
         return getGenericDAO().findControllerById(id);
    }

    public List<Controller> getControllerList()
    {
        return getGenericDAO().findAllController();
    }
    
    public List<Controller> getControllerByRoom(Room room)
    {
        return getGenericDAO().findAllControllerByRoom(room);
    }
      
    
    //sensorstatus
    
    public void saveSensorstatus(Sensorstatus val)
    {
        getGenericDAO().saveSensorstatus(val);
    }

    public void removeSensorstatus(Sensorstatus val)
    {
        getGenericDAO().removeSensorstatus(val);
    }

    public void removeSensorstatus(Long id)
    {
        getGenericDAO().removeSensorstatus(id);
    }

    public Sensorstatus getSensorstatusById(Long id)
    {
         return getGenericDAO().findSensorstatusById(id);
    }

    public List<Sensorstatus> getSensorstatusList()
    {
        return getGenericDAO().findAllSensorstatus();
    }
    
    //DevicePropertyManager
    
    public void saveDeviceProperty(DeviceProperty val)
    {
        getGenericDAO().saveDeviceProperty(val);
    }

    public void removeDeviceProperty(DeviceProperty val)
    {
        getGenericDAO().removeDeviceProperty(val);
    }

    public void removeDeviceProperty(Long id)
    {
        getGenericDAO().removeDeviceProperty(id);
    }

    public DeviceProperty getDevicePropertyById(Long id)
    {
         return getGenericDAO().findDevicePropertyById(id);
    }

    public List<DeviceProperty> getDevicePropertyList()
    {
        return getGenericDAO().findAllDeviceProperty();
    }
    
    public List<Rule> getRuleListByDeviceProperty(DeviceProperty deviceProperty){
    	return getGenericDAO().findAllRulelListByDeviceProperty(deviceProperty);
    }
    
    public List<Sensor> getSensorsByDeviceProperty(DeviceProperty val){
    	return getGenericDAO().findAllSensorsByDeviceProperty(val);
    }
    
    //EvenLevelManager
    
    public void saveEvenLevel(EvenLevel val)
    {
        getGenericDAO().saveEvenLevel(val);
    }

    public void removeEvenLevel(EvenLevel val)
    {
        getGenericDAO().removeEvenLevel(val);
    }

    public void removeEvenLevel(Long id)
    {
        getGenericDAO().removeEvenLevel(id);
    }

    public EvenLevel getEvenLevelById(Long id)
    {
         return getGenericDAO().findEvenLevelById(id);
    }

    public List<EvenLevel> getEvenLevelList()
    {
        return getGenericDAO().findAllEvenLevel();
    }
    
    //RuleManager
    public void saveRule(Rule val)
    {
        getGenericDAO().saveRule(val);
    }

    public void removeRule(Rule val)
    {
        getGenericDAO().removeRule(val);
    }

    public void removeRule(Long id)
    {
        getGenericDAO().removeRule(id);
    }

    public Rule getRuleById(Long id)
    {
         return getGenericDAO().findRuleById(id);
    }

    public List<Rule> getRuleList()
    {
        return getGenericDAO().findAllRule();
    }

    //TimesManager
    
    public void saveTimes(Times val)
    {
        getGenericDAO().saveTimes(val);
    }

    public void removeTimes(Times val)
    {
        getGenericDAO().removeTimes(val);
    }

    public void removeTimes(Long id)
    {
        getGenericDAO().removeTimes(id);
    }

    public Times getTimesById(Long id)
    {
         return getGenericDAO().findTimesById(id);
    }

    public List<Times> getTimesList()
    {
        return getGenericDAO().findAllTimes();
    }
    
    //Messenger
    
    public void saveMessenger(Messenger val)
    {
        getGenericDAO().saveMessenger(val);
    }

    public void removeMessenger(Messenger val)
    {
        getGenericDAO().removeMessenger(val);
    }

    public void removeMessenger(Long id)
    {
        getGenericDAO().removeMessenger(id);
    }

    public Messenger getMessengerById(Long id)
    {
         return getGenericDAO().findMessengerById(id);
    }

    public List<Messenger> getMessengerList()
    {
        return getGenericDAO().findAllMessenger();
    }

    public Long[] getIdsFromSecurityList(List<Security> lst)
    {
        return getGenericDAO().getIdsFromSecurityList(lst);
    }

    public List<Security> getSecurityListByIds(Long[] ids)
    {
        return getGenericDAO().getSecurityListByIds(ids);
    }
    
    //Security
    
    public void saveSecurity(Security val)
    {
        getGenericDAO().saveSecurity(val);
    }

    public void removeSecurity(Security val)
    {
        getGenericDAO().removeSecurity(val);
    }

    public void removeSecurity(Long id)
    {
        getGenericDAO().removeSecurity(id);
    }

    public Security getSecurityById(Long id)
    {
         return getGenericDAO().findSecurityById(id);
    }

    public List<Security> getSecurityList()
    {
        return getGenericDAO().findAllSecurity();
    }
    
    //DVR
    public void saveMyDVR(MyDVR val)
    {
        getGenericDAO().saveMyDVR(val);
    }

    public void removeMyDVR(MyDVR val)
    {
        getGenericDAO().removeMyDVR(val);
    }

    public void removeMyDVR(Long id)
    {
        getGenericDAO().removeMyDVR(id);
    }

    public MyDVR getMyDVRById(Long id)
    {
         return getGenericDAO().findMyDVRById(id);
    }

    public List<MyDVR> getMyDVRList()
    {
        return getGenericDAO().findAllMyDVR();
    }




    /**
     * 異常處理 
     **/
    //異常持續時間(秒)
    public  boolean isDuringError(int during,Sensor sensor){
    	return getGenericDAO().isDuringError(during,sensor);
    }
    
    //異常次數/時間
    public  boolean isCycleTimeError(int cycle,int time,Sensor sensor){
    	return getGenericDAO().isCycleTimeError(cycle,time,sensor);
    }
    
  //規則成立與否
    public  List<Sensor> isRuleSetup(Times t,DeviceProperty d,AppProperty ReturnValue){
    	return getGenericDAO().isRuleSetup(t,d,ReturnValue);
    }
   



        

}

