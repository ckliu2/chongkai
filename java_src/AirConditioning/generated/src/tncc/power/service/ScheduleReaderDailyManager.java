package tncc.power.service;

import tncc.power.value.ScheduleReaderDaily;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public interface ScheduleReaderDailyManager extends CommonManager 
{
    public abstract void saveScheduleReaderDaily(ScheduleReaderDaily val);

    public abstract void removeScheduleReaderDaily(ScheduleReaderDaily val);

    public abstract void removeScheduleReaderDaily(Long id);

    public abstract ScheduleReaderDaily getScheduleReaderDailyById(Long id);

    public abstract List<ScheduleReaderDaily> getScheduleReaderDailyList();
    public abstract List<Reader> getReaderList();
    public abstract List<ScheduleDaily> getScheduleDailyList();
    public abstract List<PowerController> getPowerControllerList();
}

