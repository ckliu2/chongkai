package tncc.power.service.impl;

import tncc.power.service.LogManager;
import tncc.power.dao.LogDAO;
import tncc.power.value.Log;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public class LogManagerImpl extends CommonManagerImpl implements LogManager
{

    public LogManagerImpl()
    {
    }

    public LogDAO getGenericDAO()
    {
        return (LogDAO)super.getGenericDAO();
    }

    public void setGenericDAO(LogDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveLog(Log val)
    {
        getGenericDAO().saveLog(val);
    }

    public void removeLog(Log val)
    {
        getGenericDAO().removeLog(val);
    }

    public void removeLog(Long id)
    {
        getGenericDAO().removeLog(id);
    }

    public Log getLogById(Long id)
    {
         return getGenericDAO().findLogById(id);
    }

    public List<Log> getLogList()
    {
        return getGenericDAO().findAllLog();
    }
    public List<ScheduleDaily> getScheduleDailyList()
    {
        return getGenericDAO().findScheduleDailyList();
    }

    public List<Reader> getReaderList()
    {
        return getGenericDAO().findReaderList();
    }

    public List<Member> getCreatedUserList()
    {
        return getGenericDAO().findCreatedUserList();
    }

}

