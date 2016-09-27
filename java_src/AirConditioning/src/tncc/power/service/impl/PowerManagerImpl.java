package tncc.power.service.impl;

import tncc.power.service.PowerManager;
import tncc.power.dao.PowerDAO;
import tncc.power.value.*;

import java.sql.Timestamp;
import java.util.*;

import HoneyWell.Device;

import com.base.value.AppProperty;

import tncc.wpc.service.impl.wpcManagerImpl;
import tncc.wpc.value.Building;
/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Mar 29 15:38:35 CST 2010
*/

public class PowerManagerImpl extends wpcManagerImpl implements PowerManager
{

    public PowerManagerImpl()
    {
    }

    public PowerDAO getGenericDAO()
    {
        return (PowerDAO)super.getGenericDAO();
    }

    public void setGenericDAO(PowerDAO dao)
    {
        super.setGenericDAO(dao);
    }

    // PowerController
    public void savePowerController(PowerController val)
    {
        getGenericDAO().savePowerController(val);
    }

    public void removePowerController(PowerController val)
    {
        getGenericDAO().removePowerController(val);
    }

    public void removePowerController(Long id)
    {
        getGenericDAO().removePowerController(id);
    }

    public PowerController getPowerControllerById(Long id)
    {
         return getGenericDAO().findPowerControllerById(id);
    }

    public List<PowerController> getPowerControllerList()
    {
        return getGenericDAO().findAllPowerController();
    }

    public Long[] getIdsFromReaderList(List<Reader> lst)
    {
        return getGenericDAO().getIdsFromReaderList(lst);
    }

    public List<Reader> getReaderListByIds(Long[] ids)
    {
        return getGenericDAO().getReaderListByIds(ids);
    }
    
    public List<PowerController> getPowerControllerListByDeviceType(AppProperty device)
    {
    	 return getGenericDAO().getPowerControllerListByDeviceType(device);
    }
    
  //Reader
    public void saveReader(Reader val)
    {
        getGenericDAO().saveReader(val);
    }

    public void removeReader(Reader val)
    {
        getGenericDAO().removeReader(val);
    }

    public void removeReader(Long id)
    {
        getGenericDAO().removeReader(id);
    }

    public Reader getReaderById(Long id)
    {
         return getGenericDAO().findReaderById(id);
    }
    
    public Reader getReaderByName(String name){
    	return getGenericDAO().findReaderByName(name);
    }

    public List<Reader> getReaderList()
    {
        return getGenericDAO().findAllReader();
    }
    
    public void syncReader()
    {
    	 getGenericDAO().syncReader();
    }
    
    public PowerController getPowerControllerByReader(Reader val){
    	return getGenericDAO().getPowerControllerByReader(val);
    }

    public PowerControllerReader getReaderByControllerDeviceNo(PowerController powerController,int deviceNo)
    {
    	return getGenericDAO().getReaderByControllerDeviceNo(powerController,deviceNo);
    }
    
    public PowerControllerReader getReaderByControllerDeviceNo(Reader reader)
    {
    	return getGenericDAO().getReaderByControllerDeviceNo(reader);
    }
    
    public List<PowerControllerReader> getReaderByController(PowerController powerController)
    {
    	return getGenericDAO().getReaderByController(powerController);
    }
    
    
    public List<SpaceReader> getReaderListBySpace(Space space)
    {
    	return getGenericDAO().getReaderListBySpace(space);
    }
    
    public List<SpaceReader> getReaderListBySpace(Space space,AppProperty state)
    {
    	return getGenericDAO().getReaderListBySpace(space,state);
    }
    
    public List<Reader> findAllReaderByG50()
    {
    	return getGenericDAO().findAllReaderByG50();
    }
    
    public List<Reader> findAllReaderByDevice(AppProperty Device)
    {
    	return getGenericDAO().findAllReaderByDevice(Device);
    }
    
    
    //Space
    public void saveSpace(Space val)
    {
        getGenericDAO().saveSpace(val);
    }

    public void removeSpace(Space val)
    {
        getGenericDAO().removeSpace(val);
    }

    public void removeSpace(Long id)
    {
        getGenericDAO().removeSpace(id);
    }

    public Space getSpaceById(Long id)
    {
         return getGenericDAO().findSpaceById(id);
    }

    public List<Space> getSpaceList()
    {
        return getGenericDAO().findAllSpace();
    }
    
    public List<Space> getSpaceListByAir(AppProperty air)
    {
    	return getGenericDAO().getSpaceListByAir(air);
    }
    
    //取得節電空間
    public  Space getSpaceByBuilding(Long id){
    	return getGenericDAO().getSpaceByBuilding(id);
    }
    
   //BasicInfo
    public void saveBasicInfo(BasicInfo val)
    {
        getGenericDAO().saveBasicInfo(val);
    }

    public void removeBasicInfo(BasicInfo val)
    {
        getGenericDAO().removeBasicInfo(val);
    }

    public void removeBasicInfo(Long id)
    {
        getGenericDAO().removeBasicInfo(id);
    }

    public BasicInfo getBasicInfoById(Long id)
    {
         return getGenericDAO().findBasicInfoById(id);
    }

    public List<BasicInfo> getBasicInfoList()
    {
        return getGenericDAO().findAllBasicInfo();
    }
    
    public BasicInfo getBasicInfo()
    {
    	return getGenericDAO().getBasicInfo();
    }
    
    //Shutdown
    
    public void saveShutdown(Shutdown val)
    {
        getGenericDAO().saveShutdown(val);
    }

    public void removeShutdown(Shutdown val)
    {
        getGenericDAO().removeShutdown(val);
    }

    public void removeShutdown(Long id)
    {
        getGenericDAO().removeShutdown(id);
    }

    public Shutdown getShutdownById(Long id)
    {
         return getGenericDAO().findShutdownById(id);
    }

    public List<Shutdown> getShutdownList()
    {
        return getGenericDAO().findAllShutdown();
    }
    
    //EvenLog
    public List<EvenLog> getEvenLogList()
    {
        return getGenericDAO().findAllEvenLog();
    }
    
    public void saveEvenLog(EvenLog val)
    {
        getGenericDAO().saveEvenLog(val);
    }
    
    public  EvenLog getEvenLogLastTime(){
    	return getGenericDAO().getEvenLogLastTime();
    }
    
    public  boolean isAlert(int gap){
    	return getGenericDAO().isAlert(gap);
    }

    //CommandLog
    
    public void saveCommandLog(CommandLog val)
    {
        getGenericDAO().saveCommandLog(val);
    }

    public void removeCommandLog(CommandLog val)
    {
        getGenericDAO().removeCommandLog(val);
    }
    
    public void removeCommandLogByReader(Reader reader)
    {
    	getGenericDAO().removeCommandLogByReader(reader);
    }
    
    //ScheduleDaily  
    public void saveScheduleDaily(ScheduleDaily val)
    {
        getGenericDAO().saveScheduleDaily(val);
    }

    public void removeScheduleDaily(ScheduleDaily val)
    {
        getGenericDAO().removeScheduleDaily(val);
    }

    public void removeScheduleDaily(Long id)
    {
        getGenericDAO().removeScheduleDaily(id);
    }

    public ScheduleDaily getScheduleDailyById(Long id)
    {
         return getGenericDAO().findScheduleDailyById(id);
    }

    public List<ScheduleDaily> getScheduleDailyListByReader(Reader reader)
    {
        return getGenericDAO().findScheduleDailyById(reader);
    }    
    
    //ScheduleReaderDaily
    public  List<ScheduleReaderDaily> getScheduleListByReader(Reader reader,Date scheduledDate)
    {
    	return getGenericDAO().getScheduleListByReader(reader,scheduledDate);
    }
    public  List<ScheduleReaderDaily> getScheduleListByReaderActive(Reader reader,boolean active)
    {
    	return getGenericDAO().getScheduleListByReaderActive(reader,active);
    }
    
    public Long[] getIdsFromScheduleReader(Set tlist)
    {
    	return getGenericDAO().getIdsFromScheduleReader(tlist);
    }
    
    public List<ScheduleReaderDaily> getScheduleListByDate(Date date,boolean active)
    {
    	return getGenericDAO().getScheduleListByDate(date,active);
    }
    
    public void scheduleReaderDailyResetByReader(Date date,Reader reader)
    {
    	getGenericDAO().scheduleReaderDailyResetByReader(date,reader);
    }
    
    
    public List<Reader> getScheduleListByReader(Date date)
    {
    	return getGenericDAO().getScheduleListByReader(date);
    }
    
    public List<Reader> getScheduleListByReader(Date date,boolean active)
    {
    	return getGenericDAO().getScheduleListByReader(date,active);
    }
    
    public List<ScheduleReaderDaily> getScheduleListByDate(Date date,Reader reader)
    {
    	return getGenericDAO().getScheduleListByDate(date,reader);
    }
    
    public void copyWeeklyToDaily()
    {
    	getGenericDAO().copyWeeklyToDaily();
    }
    
    //Log

    public void saveLog(Log val)
    {
    	getGenericDAO().saveLog(val);
    }
    
    public boolean haveLog(ScheduleDaily scheduleDaily,Reader reader)
    {
    	return getGenericDAO().haveLog(scheduleDaily,reader);
    }
    
    public List<Log> getLogList()
    {
        return getGenericDAO().findAllLog();
    }
    
    public List<Log> getLogList(Date start,Date end,AppProperty logtype,String msg,int pageSize,int pageIndex)
    {
    	return getGenericDAO().getLogList(start,end,logtype,msg,pageSize,pageIndex);
    }
    
    public int getLogListRresultSize(Date start,Date end,AppProperty logtype,String msg)
    {
    	return getGenericDAO().getLogListRresultSize(start,end,logtype,msg);
    }
    
    //ClearDaily
    public List<ClearDaily> getClearDailyList()
    {
    	return getGenericDAO().getClearDailyList();
    }
    
    public void readerState()
    {
    	getGenericDAO().readerState();
    }
    
    public Reader currentReaderState(Long readerId,boolean status)
    {
    	return getGenericDAO().currentReaderState(readerId,status);
    }
    
    public boolean isClearDaily(Reader reader)
    {
    	return getGenericDAO().isClearDaily(reader);
    }
    
    public List<Reader> getlastModifiedDateReaders(Timestamp start)
    {
    	return getGenericDAO().getlastModifiedDateReaders(start);
    }
    
    //HoneyWell
    public Device getHoneyWellCurrentStatus(Reader reader)
    {
    	return getGenericDAO().getHoneyWellCurrentStatus(reader);
    }
    
    //DEM510C
    public int getDEM510CCurrentStatus(Reader reader)
    {
	return getGenericDAO().getDEM510CCurrentStatus(reader);
    }
}

