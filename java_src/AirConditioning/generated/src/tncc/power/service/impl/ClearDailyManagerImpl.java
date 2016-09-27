package tncc.power.service.impl;

import tncc.power.service.ClearDailyManager;
import tncc.power.dao.ClearDailyDAO;
import tncc.power.value.ClearDaily;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public class ClearDailyManagerImpl extends CommonManagerImpl implements ClearDailyManager
{

    public ClearDailyManagerImpl()
    {
    }

    public ClearDailyDAO getGenericDAO()
    {
        return (ClearDailyDAO)super.getGenericDAO();
    }

    public void setGenericDAO(ClearDailyDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveClearDaily(ClearDaily val)
    {
        getGenericDAO().saveClearDaily(val);
    }

    public void removeClearDaily(ClearDaily val)
    {
        getGenericDAO().removeClearDaily(val);
    }

    public void removeClearDaily(Long id)
    {
        getGenericDAO().removeClearDaily(id);
    }

    public ClearDaily getClearDailyById(Long id)
    {
         return getGenericDAO().findClearDailyById(id);
    }

    public List<ClearDaily> getClearDailyList()
    {
        return getGenericDAO().findAllClearDaily();
    }
    public List<Reader> getReaderList()
    {
        return getGenericDAO().findReaderList();
    }

    public List<PowerController> getPowercontrollerList()
    {
        return getGenericDAO().findPowercontrollerList();
    }

}

