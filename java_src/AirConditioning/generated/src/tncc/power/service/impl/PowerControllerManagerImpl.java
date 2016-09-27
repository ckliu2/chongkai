package tncc.power.service.impl;

import tncc.power.service.PowerControllerManager;
import tncc.power.dao.PowerControllerDAO;
import tncc.power.value.PowerController;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public class PowerControllerManagerImpl extends CommonManagerImpl implements PowerControllerManager
{

    public PowerControllerManagerImpl()
    {
    }

    public PowerControllerDAO getGenericDAO()
    {
        return (PowerControllerDAO)super.getGenericDAO();
    }

    public void setGenericDAO(PowerControllerDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void savePowerController(PowerController val)
    {
        getGenericDAO().savePowerController(val);
    }

    public void removePowerController(PowerController val)
    {
        getGenericDAO().removePowerController(val);
    }

    public void removePowerController(Long id)
    {
        getGenericDAO().removePowerController(id);
    }

    public PowerController getPowerControllerById(Long id)
    {
         return getGenericDAO().findPowerControllerById(id);
    }

    public List<PowerController> getPowerControllerList()
    {
        return getGenericDAO().findAllPowerController();
    }
    public List<Building> getBuildingList()
    {
        return getGenericDAO().findBuildingList();
    }

    public List<Member> getCreatedUserList()
    {
        return getGenericDAO().findCreatedUserList();
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

