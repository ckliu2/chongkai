package org.zion.service.impl;

import org.zion.service.SundayInforManager;
import org.zion.dao.SundayInforDAO;
import org.zion.value.SundayInfor;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public class SundayInforManagerImpl extends CommonManagerImpl implements SundayInforManager
{

    public SundayInforManagerImpl()
    {
    }

    public SundayInforDAO getGenericDAO()
    {
        return (SundayInforDAO)super.getGenericDAO();
    }

    public void setGenericDAO(SundayInforDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveSundayInfor(SundayInfor val)
    {
        getGenericDAO().saveSundayInfor(val);
    }

    public void removeSundayInfor(SundayInfor val)
    {
        getGenericDAO().removeSundayInfor(val);
    }

    public void removeSundayInfor(Long id)
    {
        getGenericDAO().removeSundayInfor(id);
    }

    public SundayInfor getSundayInforById(Long id)
    {
         return getGenericDAO().findSundayInforById(id);
    }

    public List<SundayInfor> getSundayInforList()
    {
        return getGenericDAO().findAllSundayInfor();
    }
}

