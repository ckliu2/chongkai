package tncc.power.dao;

import tncc.power.value.Log;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public interface LogDAO extends CommonDAO 
{
    public abstract void saveLog(Log val);

    public abstract void removeLog(Log val);

    public abstract void removeLog(Long id);

    public abstract Log findLogById(Long id);

    public abstract List<Log> findAllLog();
    public abstract List<ScheduleDaily> findScheduleDailyList();
    public abstract List<Reader> findReaderList();
    public abstract List<Member> findCreatedUserList();
}

