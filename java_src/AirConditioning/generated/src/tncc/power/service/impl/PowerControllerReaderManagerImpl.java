package tncc.power.service.impl;

import tncc.power.service.PowerControllerReaderManager;
import tncc.power.dao.PowerControllerReaderDAO;
import tncc.power.value.PowerControllerReader;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public class PowerControllerReaderManagerImpl extends CommonManagerImpl implements PowerControllerReaderManager
{

    public PowerControllerReaderManagerImpl()
    {
    }

    public PowerControllerReaderDAO getGenericDAO()
    {
        return (PowerControllerReaderDAO)super.getGenericDAO();
    }

    public void setGenericDAO(PowerControllerReaderDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void savePowerControllerReader(PowerControllerReader val)
    {
        getGenericDAO().savePowerControllerReader(val);
    }

    public void removePowerControllerReader(PowerControllerReader val)
    {
        getGenericDAO().removePowerControllerReader(val);
    }

    public void removePowerControllerReader(Long id)
    {
        getGenericDAO().removePowerControllerReader(id);
    }

    public PowerControllerReader getPowerControllerReaderById(Long id)
    {
         return getGenericDAO().findPowerControllerReaderById(id);
    }

    public List<PowerControllerReader> getPowerControllerReaderList()
    {
        return getGenericDAO().findAllPowerControllerReader();
    }
    public List<PowerController> getPowerControllerList()
    {
        return getGenericDAO().findPowerControllerList();
    }

    public List<Reader> getReaderList()
    {
        return getGenericDAO().findReaderList();
    }

    public List<ClassRoom> getClassRoomList()
    {
        return getGenericDAO().findClassRoomList();
    }

    public List<Course> getCourseList()
    {
        return getGenericDAO().findCourseList();
    }

}

