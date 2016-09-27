package tncc.power.service.impl;

import tncc.power.service.SpaceReaderManager;
import tncc.power.dao.SpaceReaderDAO;
import tncc.power.value.SpaceReader;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public class SpaceReaderManagerImpl extends CommonManagerImpl implements SpaceReaderManager
{

    public SpaceReaderManagerImpl()
    {
    }

    public SpaceReaderDAO getGenericDAO()
    {
        return (SpaceReaderDAO)super.getGenericDAO();
    }

    public void setGenericDAO(SpaceReaderDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveSpaceReader(SpaceReader val)
    {
        getGenericDAO().saveSpaceReader(val);
    }

    public void removeSpaceReader(SpaceReader val)
    {
        getGenericDAO().removeSpaceReader(val);
    }

    public void removeSpaceReader(Long id)
    {
        getGenericDAO().removeSpaceReader(id);
    }

    public SpaceReader getSpaceReaderById(Long id)
    {
         return getGenericDAO().findSpaceReaderById(id);
    }

    public List<SpaceReader> getSpaceReaderList()
    {
        return getGenericDAO().findAllSpaceReader();
    }
    public List<Space> getSpaceList()
    {
        return getGenericDAO().findSpaceList();
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

