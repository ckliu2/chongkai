package tncc.power.dao;

import tncc.power.value.ScheduleReaderDaily;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public interface ScheduleReaderDailyDAO extends CommonDAO 
{
    public abstract void saveScheduleReaderDaily(ScheduleReaderDaily val);

    public abstract void removeScheduleReaderDaily(ScheduleReaderDaily val);

    public abstract void removeScheduleReaderDaily(Long id);

    public abstract ScheduleReaderDaily findScheduleReaderDailyById(Long id);

    public abstract List<ScheduleReaderDaily> findAllScheduleReaderDaily();
    public abstract List<Reader> findReaderList();
    public abstract List<ScheduleDaily> findScheduleDailyList();
    public abstract List<PowerController> findPowerControllerList();
}

