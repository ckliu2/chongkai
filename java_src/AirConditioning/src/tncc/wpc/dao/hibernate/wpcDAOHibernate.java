package tncc.wpc.dao.hibernate;

import tncc.wpc.value.*;
import tncc.wpc.dao.*;
import java.util.*;

import org.springframework.orm.ObjectRetrievalFailureException;

import com.base.util.Tools;
import com.base.value.AppProperty;
import com.common.dao.hibernate.CommonDAOHibernate;
import org.hibernate.criterion.Expression;
import org.hibernate.Criteria;
import org.hibernate.criterion.*;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Fri Jan 29 14:30:29 CST 2010
*/

public class wpcDAOHibernate extends CommonDAOHibernate implements wpcDAO
{

    public wpcDAOHibernate()
    {
    }

    public void saveBuilding(Building val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeBuilding(Building val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeBuilding(Long id)
    {
        Building obj = findBuildingById(id);
        getHibernateTemplate().delete(obj);
    }

    public Building findBuildingById(Long id)
    {
        if (id == null)
            return null;
        Building obj = (Building)getHibernateTemplate().get(tncc.wpc.value.Building.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(tncc.wpc.value.Building.class, id);
        else
            return obj;
    }

    public List<Building> findAllBuilding()
    {
        return getHibernateTemplate().find("from Building");
    }
    

    
    

    
    //sensor
    
        public void saveSensor(Sensor val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeSensor(Sensor val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeSensor(Long id)
    {
        Sensor obj = findSensorById(id);
        getHibernateTemplate().delete(obj);
    }

    public Sensor findSensorById(Long id)
    {
        if (id == null)
            return null;
        Sensor obj = (Sensor)getHibernateTemplate().get(tncc.wpc.value.Sensor.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(tncc.wpc.value.Sensor.class, id);
        else
            return obj;
    }

    public List<Sensor> findAllSensor()
    {
        return getHibernateTemplate().find("from Sensor");
    }
    
    public List<Sensor> findAllSensorByController(Controller c){
    	return getHibernateTemplate().find("from Sensor where controller="+c.getId());    	
    }


   //room
   
     public void saveRoom(Room val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeRoom(Room val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeRoom(Long id)
    {
        Room obj = findRoomById(id);
        getHibernateTemplate().delete(obj);
    }

    public Room findRoomById(Long id)
    {
        if (id == null)
            return null;
        Room obj = (Room)getHibernateTemplate().get(tncc.wpc.value.Room.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(tncc.wpc.value.Room.class, id);
        else
            return obj;
    }

    public List<Room> findAllRoom()
    {
        return getHibernateTemplate().find("from Room");
    }
    
    public List<Room> findAllRoomByBuilding(Building building)
    {
        return getHibernateTemplate().find("from Room where id="+String.valueOf(building.getId()));
    }

    //controller
    
    public void saveController(Controller val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeController(Controller val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeController(Long id)
    {
        Controller obj = findControllerById(id);
        getHibernateTemplate().delete(obj);
    }

    public Controller findControllerById(Long id)
    {
        if (id == null)
            return null;
        Controller obj = (Controller)getHibernateTemplate().get(tncc.wpc.value.Controller.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(tncc.wpc.value.Controller.class, id);
        else
            return obj;
    }

    public List<Controller> findAllController()
    {
        return getHibernateTemplate().find("from Controller");
    }
    
    public List<Controller> findAllControllerByRoom(Room room)
    {
        return getHibernateTemplate().find("from Controller where room="+String.valueOf(room.getId()));
    }   
    

    //sensorstatus
    
    public void saveSensorstatus(Sensorstatus val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeSensorstatus(Sensorstatus val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeSensorstatus(Long id)
    {
        Sensorstatus obj = findSensorstatusById(id);
        getHibernateTemplate().delete(obj);
    }

    public Sensorstatus findSensorstatusById(Long id)
    {
        if (id == null)
            return null;
        Sensorstatus obj = (Sensorstatus)getHibernateTemplate().get(tncc.wpc.value.Sensorstatus.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(tncc.wpc.value.Sensorstatus.class, id);
        else
            return obj;
    }

    public List<Sensorstatus> findAllSensorstatus()
    {
        return getHibernateTemplate().find("from Sensorstatus order by createdDate desc");
    }
    
    //DeviceProperty
    public void saveDeviceProperty(DeviceProperty val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeDeviceProperty(DeviceProperty val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeDeviceProperty(Long id)
    {
        DeviceProperty obj = findDevicePropertyById(id);
        getHibernateTemplate().delete(obj);
    }

    public DeviceProperty findDevicePropertyById(Long id)
    {
        if (id == null)
            return null;
        DeviceProperty obj = (DeviceProperty)getHibernateTemplate().get(tncc.wpc.value.DeviceProperty.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(tncc.wpc.value.DeviceProperty.class, id);
        else
            return obj;
    }

    public List<DeviceProperty> findAllDeviceProperty()
    {
        return getHibernateTemplate().find("from DeviceProperty");
    }
    
    public List<Rule> findAllRulelListByDeviceProperty(DeviceProperty deviceProperty){
       List<Rule> myrule = new ArrayList<Rule>();
       List<Rule> rule=getHibernateTemplate().find("from Rule");
    	   for(int i=0;i<rule.size();i++){
    		   Rule r=rule.get(i);    
    		   DeviceProperty d=r.getDeviceProperty();
    		    if(d!=null){
    		        if(d.getId()==deviceProperty.getId()){
    		    	    myrule.add(r);
    		    	   //System.out.println("findAllRulelListByDeviceProperty rule="+r.getName());
    		         }
    		    } 
    	   }      
    	 return myrule;
    }
    
    public  List<Sensor> findAllSensorsByDeviceProperty(DeviceProperty val){
    	ArrayList<Sensor> sensors = new ArrayList<Sensor>();
    	Criteria c = getHibernateSession().createCriteria(Sensor.class);            
        c.add(Expression.eq("deviceProperty", val)); //相同deviceProperty
        List ls = c.list();   
         for(int i=0;i<ls.size();i++){
        	 Sensor s=(Sensor)ls.get(i);
        	 sensors.add(s);
         }
    	return sensors;
    }
    
    
    //EvenLevel    
    public void saveEvenLevel(EvenLevel val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeEvenLevel(EvenLevel val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeEvenLevel(Long id)
    {
        EvenLevel obj = findEvenLevelById(id);
        getHibernateTemplate().delete(obj);
    }

    public EvenLevel findEvenLevelById(Long id)
    {
        if (id == null)
            return null;
        EvenLevel obj = (EvenLevel)getHibernateTemplate().get(tncc.wpc.value.EvenLevel.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(tncc.wpc.value.EvenLevel.class, id);
        else
            return obj;
    }

    public List<EvenLevel> findAllEvenLevel()
    {
        return getHibernateTemplate().find("from EvenLevel");
    }

    //RuleDAO
    public void saveRule(Rule val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeRule(Rule val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeRule(Long id)
    {
        Rule obj = findRuleById(id);
        getHibernateTemplate().delete(obj);
    }

    public Rule findRuleById(Long id)
    {
        if (id == null)
            return null;
        Rule obj = (Rule)getHibernateTemplate().get(tncc.wpc.value.Rule.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(tncc.wpc.value.Rule.class, id);
        else
            return obj;
    }

    public List<Rule> findAllRule()
    {
        return getHibernateTemplate().find("from Rule");
    }
    
    //TimesDAO
    
    public void saveTimes(Times val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeTimes(Times val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeTimes(Long id)
    {
        Times obj = findTimesById(id);
        getHibernateTemplate().delete(obj);
    }

    public Times findTimesById(Long id)
    {
        if (id == null)
            return null;
        Times obj = (Times)getHibernateTemplate().get(tncc.wpc.value.Times.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(tncc.wpc.value.Times.class, id);
        else
            return obj;
    }

    public List<Times> findAllTimes()
    {
        return getHibernateTemplate().find("from Times");
    }
    
    
    //Messenger
    
    public void saveMessenger(Messenger val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeMessenger(Messenger val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeMessenger(Long id)
    {
        Messenger obj = findMessengerById(id);
        getHibernateTemplate().delete(obj);
    }

    public Messenger findMessengerById(Long id)
    {
        if (id == null)
            return null;
        Messenger obj = (Messenger)getHibernateTemplate().get(tncc.wpc.value.Messenger.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(tncc.wpc.value.Messenger.class, id);
        else
            return obj;
    }

    public List<Messenger> findAllMessenger()
    {
        return getHibernateTemplate().find("from Messenger");
    }
    
    public Long[] getIdsFromSecurityList(List tlist)
    {
        ArrayList<Long> al = new ArrayList<Long>();
        if (tlist != null) {
            for (int i = 0; i < tlist.size(); i++) {
                Security t = (Security) tlist.get(i);
                if (t != null)
                    al.add(t.getId());
            }
        }
        Long lng[] = new Long[al.size()];
        al.toArray(lng);
        
        return lng;
    }

    public List getSecurityListByIds(Long[] ids)
    {
        ArrayList<Security> al = new ArrayList<Security>();
        if (ids != null) {
            for (int i = 0; i < ids.length; i++) {
                Security t = (Security) findSecurityById(ids[i]);
                if (t != null)
                    al.add(t);
            }
        }
        return al;
    }
    
    //Security
    
    public void saveSecurity(Security val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeSecurity(Security val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeSecurity(Long id)
    {
        Security obj = findSecurityById(id);
        getHibernateTemplate().delete(obj);
    }

    public Security findSecurityById(Long id)
    {
        if (id == null)
            return null;
        Security obj = (Security)getHibernateTemplate().get(tncc.wpc.value.Security.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(tncc.wpc.value.Security.class, id);
        else
            return obj;
    }

    public List<Security> findAllSecurity()
    {
        return getHibernateTemplate().find("from Security");
    }

    //DVR
    public void saveMyDVR(MyDVR val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeMyDVR(MyDVR val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeMyDVR(Long id)
    {
    	MyDVR obj = findMyDVRById(id);
        getHibernateTemplate().delete(obj);
    }

    public MyDVR findMyDVRById(Long id)
    {
        if (id == null)
            return null;
        MyDVR obj = (MyDVR)getHibernateTemplate().get(MyDVR.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(MyDVR.class, id);
        else
            return obj;
    }

    public List<MyDVR> findAllMyDVR()
    {
        return getHibernateTemplate().find("from MyDVR");
    }    
    
    /**
     * 異常處理 
     **/
    
    //異常持續時間(秒)    
    public boolean isDuringError(int during,Sensor sensor){    	
             	
        	Calendar calendar= Calendar.getInstance();           	
        	calendar.add(Calendar.SECOND,-during);  
        	Date now = new Date();
        	Date date = calendar.getTime();
        	
            Criteria c = getHibernateSession().createCriteria(Sensorstatus.class);            
            c.add(Expression.eq("sensor", sensor)); //相同SENSOR
            c.add(Expression.gt("createdDate", date)); //大於
            //c.add(Expression.lt("createdDate", now)); //小於
            List ls = c.list();            
           
            System.out.println("V1-ls.size()="+ls.size()+"    during="+during);
            
                if (ls.size() < during ){
            	    return false;     
                }else{
            	    return true;
                 }    
            
    }
    
    
    
    
    //異常次數/時間
    public  boolean isCycleTimeError(int cycle,int time,Sensor sensor){

    	Calendar calendar= Calendar.getInstance();           	
    	calendar.add(Calendar.SECOND,-time);  
    	Date now = new Date();
    	Date date = calendar.getTime();
    	
        Criteria c = getHibernateSession().createCriteria(Sensorstatus.class);            
        c.add(Expression.eq("sensor", sensor)); //相同SENSOR
        c.add(Expression.gt("createdDate", date)); //大於
        //c.add(Expression.lt("createdDate", now)); //小於
        List ls = c.list();            
       
        System.out.println("isCycleTimeError-1-ls.size()="+ls.size()+"    "+time+"/"+cycle);
        
            if (ls.size() >= cycle ){
        	    return true;     
            }else{
        	    return false;
             }  
    }
    
    
    //規則成立與否
    public  List<Sensor> isRuleSetup(Times t,DeviceProperty d,AppProperty ReturnValue){
        ArrayList<Sensor> sensors = new ArrayList<Sensor>();
    	try{
    	//System.out.println("=========== wpcDAOHibernate isRuleSetup() ==========");		
		
		Calendar   now   =   Calendar.getInstance();		
		Calendar   now1   =   Calendar.getInstance();		
		now1.add(Calendar.SECOND,   -t.getCycle()); 		

   	    //System.out.println(u+"次"+cycle+"秒 "+"  DeviceProperty"+d.getName()+"  ReturnValue=");
		
		List<Sensor> s=findAllSensorsByDeviceProperty(d);
		 for(int k=0;k<s.size();k++){
			 Sensor sr=(Sensor)s.get(k);
			 //System.out.println("sr.name="+sr.getName());
		 
		
		    Criteria c = getHibernateSession().createCriteria(Sensorstatus.class);
		    c.add(Expression.gt("createdDate", now1.getTime())); //大於
		    c.add(Expression.lt("createdDate", now.getTime())); //小於
		    c.add(Expression.eq("sensor", sr)); //相同Sensor
		    List ls = c.list();
		    
		    /**判斷是否大於設定值*/
		    if(ls.size()>t.getTime()){				
		    	sensors.add(sr);
			 }
		
		     //System.out.println("sr.getName()="+sr.getName()+"  ls.size()="+ls.size());
	     }
		
		 
		/* if(ls.size()>t.getTime()){
			
			 for(int i=0;i<ls.size();i++){
				 Sensor s=ls.get(i);
			 }
			 sensors.add(e)
		 }*/
		   return sensors;
		}catch(Exception e){
			System.out.println("=========== wpcDAOHibernate isRuleSetup() error==========");
			System.out.println(e.toString());
			return sensors;
		}
    }




}

