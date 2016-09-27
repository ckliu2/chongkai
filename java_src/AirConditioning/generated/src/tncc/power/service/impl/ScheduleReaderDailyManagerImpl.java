package tncc.power.service.impl;

import tncc.power.service.ScheduleReaderDailyManager;
import tncc.power.dao.ScheduleReaderDailyDAO;
import tncc.power.value.ScheduleReaderDaily;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public class ScheduleReaderDailyManagerImpl extends CommonManagerImpl implements ScheduleReaderDailyManager
{

    public ScheduleReaderDailyManagerImpl()
    {
    }

    public ScheduleReaderDailyDAO getGenericDAO()
    {
        return (ScheduleReaderDailyDAO)super.getGenericDAO();
    }

    public void setGenericDAO(ScheduleReaderDailyDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveScheduleReaderDaily(ScheduleReaderDaily val)
    {
        getGenericDAO().saveScheduleReaderDaily(val);
    }

    public void removeScheduleReaderDaily(ScheduleReaderDaily val)
    {
        getGenericDAO().removeScheduleReaderDaily(val);
    }

    public void removeScheduleReaderDaily(Long id)
    {
        getGenericDAO().removeScheduleReaderDaily(id);
    }

    public ScheduleReaderDaily getScheduleReaderDailyById(Long id)
    {
         return getGenericDAO().findScheduleReaderDailyById(id);
    }

    public List<ScheduleReaderDaily> getScheduleReaderDailyList()
    {
        return getGenericDAO().findAllScheduleReaderDaily();
    }
    public List<Reader> getReaderList()
    {
        return getGenericDAO().findReaderList();
    }

    public List<ScheduleDaily> getScheduleDailyList()
    {
        return getGenericDAO().findScheduleDailyList();
    }

    public List<PowerController> getPowerControllerList()
    {
        return getGenericDAO().findPowerControllerList();
    }

}

