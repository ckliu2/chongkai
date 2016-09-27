package tncc.power.service.impl;

import tncc.power.service.ScheduleDailyManager;
import tncc.power.dao.ScheduleDailyDAO;
import tncc.power.value.ScheduleDaily;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public class ScheduleDailyManagerImpl extends CommonManagerImpl implements ScheduleDailyManager
{

    public ScheduleDailyManagerImpl()
    {
    }

    public ScheduleDailyDAO getGenericDAO()
    {
        return (ScheduleDailyDAO)super.getGenericDAO();
    }

    public void setGenericDAO(ScheduleDailyDAO dao)
    {
        super.setGenericDAO(dao);
    }

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

    public List<ScheduleDaily> getScheduleDailyList()
    {
        return getGenericDAO().findAllScheduleDaily();
    }
    public List<Member> getLastModifiedUserList()
    {
        return getGenericDAO().findLastModifiedUserList();
    }

    public Long[] getIdsFromReaderList(List<Reader> lst)
    {
        return getGenericDAO().getIdsFromReaderList(lst);
    }

    public List<Reader> getReaderListByIds(Long[] ids)
    {
        return getGenericDAO().getReaderListByIds(ids);
    }

}

