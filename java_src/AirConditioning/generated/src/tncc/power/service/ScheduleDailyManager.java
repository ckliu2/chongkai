package tncc.power.service;

import tncc.power.value.ScheduleDaily;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public interface ScheduleDailyManager extends CommonManager 
{
    public abstract void saveScheduleDaily(ScheduleDaily val);

    public abstract void removeScheduleDaily(ScheduleDaily val);

    public abstract void removeScheduleDaily(Long id);

    public abstract ScheduleDaily getScheduleDailyById(Long id);

    public abstract List<ScheduleDaily> getScheduleDailyList();
    public abstract List<Member> getLastModifiedUserList();
    public abstract Long[] getIdsFromReaderList(List<Reader> lst);

    public abstract List<Reader> getReaderListByIds(Long[] ids);

}

