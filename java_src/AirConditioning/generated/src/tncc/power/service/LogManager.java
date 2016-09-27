package tncc.power.service;

import tncc.power.value.Log;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public interface LogManager extends CommonManager 
{
    public abstract void saveLog(Log val);

    public abstract void removeLog(Log val);

    public abstract void removeLog(Long id);

    public abstract Log getLogById(Long id);

    public abstract List<Log> getLogList();
    public abstract List<ScheduleDaily> getScheduleDailyList();
    public abstract List<Reader> getReaderList();
    public abstract List<Member> getCreatedUserList();
}

