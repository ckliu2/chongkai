package tncc.power.service;

import tncc.power.value.*;

import HoneyWell.*;

import com.base.value.*;

import java.sql.Timestamp;
import java.util.*;
import com.common.service.CommonManager;
import tncc.wpc.service.wpcManager;
import tncc.wpc.value.*;

public interface PowerManager extends wpcManager 
{
	//Controller
    public abstract void savePowerController(PowerController val);
    public abstract void removePowerController(PowerController val);
    public abstract void removePowerController(Long id);
    public abstract PowerController getPowerControllerById(Long id);
    public abstract List<PowerController> getPowerControllerList();
    public abstract List<PowerController> getPowerControllerListByDeviceType(AppProperty device);
    
    //Reader
    public abstract void saveReader(Reader val);
    public abstract void removeReader(Reader val);
    public abstract void removeReader(Long id);
    public abstract Reader getReaderById(Long id);
    public abstract List<Reader> getReaderList();  
    public abstract PowerController getPowerControllerByReader(Reader val);
    public abstract Reader getReaderByName(String name);
    public abstract List<SpaceReader> getReaderListBySpace(Space space);
    public abstract List<SpaceReader> getReaderListBySpace(Space space,AppProperty state);
    public abstract void syncReader();
    public abstract List<Reader> findAllReaderByG50();
    public abstract List<Reader> findAllReaderByDevice(AppProperty device);
    
    
    //PowerControllerReader
    public abstract PowerControllerReader getReaderByControllerDeviceNo(PowerController powerController,int deviceNo);
    public abstract PowerControllerReader getReaderByControllerDeviceNo(Reader reader);
    public abstract List<PowerControllerReader> getReaderByController(PowerController powerController);
    
    //Space
    public abstract void saveSpace(Space val);
    public abstract void removeSpace(Space val);
    public abstract void removeSpace(Long id);
    public abstract Space getSpaceById(Long id);
    public abstract List<Space> getSpaceList();
    public abstract List<Space> getSpaceListByAir(AppProperty air);
    public abstract Long[] getIdsFromReaderList(List<Reader> lst);
    public abstract List<Reader> getReaderListByIds(Long[] ids);    
    public abstract Space getSpaceByBuilding(Long id);
    
    //BasicInfo
    public abstract void saveBasicInfo(BasicInfo val);
    public abstract void removeBasicInfo(BasicInfo val);
    public abstract void removeBasicInfo(Long id);
    public abstract BasicInfo getBasicInfoById(Long id);
    public abstract List<BasicInfo> getBasicInfoList();
    public abstract BasicInfo getBasicInfo();
    
    //Shutdown
    public abstract void saveShutdown(Shutdown val);
    public abstract void removeShutdown(Shutdown val);
    public abstract void removeShutdown(Long id);
    public abstract Shutdown getShutdownById(Long id);
    public abstract List<Shutdown> getShutdownList();

    //EvenLog
    public abstract List<EvenLog> getEvenLogList();
    public abstract void saveEvenLog(EvenLog val);
    public abstract EvenLog getEvenLogLastTime();
    public abstract boolean isAlert(int gap);
    
    //CommandLog
    public abstract void saveCommandLog(CommandLog val);
    public abstract void removeCommandLog(CommandLog val);
    public abstract void removeCommandLogByReader(Reader reader);
    
    //ScheduleDaily    
    public abstract void saveScheduleDaily(ScheduleDaily val);
    public abstract void removeScheduleDaily(ScheduleDaily val);
    public abstract void removeScheduleDaily(Long id);
    public abstract ScheduleDaily getScheduleDailyById(Long id);
    public abstract List<ScheduleDaily> getScheduleDailyListByReader(Reader reader);

    //ScheduleReaderDaily
    public abstract List<ScheduleReaderDaily> getScheduleListByReader(Reader reader,Date scheduledDate);
    public abstract List<ScheduleReaderDaily> getScheduleListByReaderActive(Reader reader,boolean active);
    public abstract Long[] getIdsFromScheduleReader(Set tlist);
    public abstract List<ScheduleReaderDaily> getScheduleListByDate(Date date,boolean active);
    public abstract void scheduleReaderDailyResetByReader(Date date,Reader reader);
    
    
    public abstract List<Reader> getScheduleListByReader(Date date);
    public abstract List<Reader> getScheduleListByReader(Date date,boolean active);
    public abstract List<ScheduleReaderDaily> getScheduleListByDate(Date date,Reader reader);
    public abstract void copyWeeklyToDaily();
    
    //Log    
    public abstract void saveLog(Log val);
    public abstract boolean haveLog(ScheduleDaily scheduleDaily,Reader reader);
    public abstract List<Log> getLogList();
    public abstract List<Log> getLogList(Date start,Date end,AppProperty logtype,String msg,int pageSize,int pageIndex);
    public abstract int getLogListRresultSize(Date start,Date end,AppProperty logtype,String msg);
    
    //ClearDaily
    public abstract List<ClearDaily> getClearDailyList();
    public abstract void readerState();
    public abstract Reader currentReaderState(Long readerId,boolean status);
    public abstract boolean isClearDaily(Reader reader);
    public abstract List<Reader> getlastModifiedDateReaders(Timestamp start);
    
    //HoneyWell
    public abstract Device getHoneyWellCurrentStatus(Reader reader);
    
    //DEM510C
    public abstract int getDEM510CCurrentStatus(Reader reader);
    
}

