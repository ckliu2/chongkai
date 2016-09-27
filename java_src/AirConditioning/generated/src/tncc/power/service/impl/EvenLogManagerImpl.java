package tncc.power.service.impl;

import tncc.power.service.EvenLogManager;
import tncc.power.dao.EvenLogDAO;
import tncc.power.value.EvenLog;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public class EvenLogManagerImpl extends CommonManagerImpl implements EvenLogManager
{

    public EvenLogManagerImpl()
    {
    }

    public EvenLogDAO getGenericDAO()
    {
        return (EvenLogDAO)super.getGenericDAO();
    }

    public void setGenericDAO(EvenLogDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveEvenLog(EvenLog val)
    {
        getGenericDAO().saveEvenLog(val);
    }

    public void removeEvenLog(EvenLog val)
    {
        getGenericDAO().removeEvenLog(val);
    }

    public void removeEvenLog(Long id)
    {
        getGenericDAO().removeEvenLog(id);
    }

    public EvenLog getEvenLogById(Long id)
    {
         return getGenericDAO().findEvenLogById(id);
    }

    public List<EvenLog> getEvenLogList()
    {
        return getGenericDAO().findAllEvenLog();
    }
    public List<Shutdown> getShutdownprcList()
    {
        return getGenericDAO().findShutdownprcList();
    }

}

