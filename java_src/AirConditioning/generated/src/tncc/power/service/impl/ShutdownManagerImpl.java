package tncc.power.service.impl;

import tncc.power.service.ShutdownManager;
import tncc.power.dao.ShutdownDAO;
import tncc.power.value.Shutdown;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public class ShutdownManagerImpl extends CommonManagerImpl implements ShutdownManager
{

    public ShutdownManagerImpl()
    {
    }

    public ShutdownDAO getGenericDAO()
    {
        return (ShutdownDAO)super.getGenericDAO();
    }

    public void setGenericDAO(ShutdownDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveShutdown(Shutdown val)
    {
        getGenericDAO().saveShutdown(val);
    }

    public void removeShutdown(Shutdown val)
    {
        getGenericDAO().removeShutdown(val);
    }

    public void removeShutdown(Long id)
    {
        getGenericDAO().removeShutdown(id);
    }

    public Shutdown getShutdownById(Long id)
    {
         return getGenericDAO().findShutdownById(id);
    }

    public List<Shutdown> getShutdownList()
    {
        return getGenericDAO().findAllShutdown();
    }
    public List<Member> getCreatedUserList()
    {
        return getGenericDAO().findCreatedUserList();
    }

    public List<EvenLevel> getEvenlevelList()
    {
        return getGenericDAO().findEvenlevelList();
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

