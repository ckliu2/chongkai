package tncc.power.service.impl;

import tncc.power.service.SpaceManager;
import tncc.power.dao.SpaceDAO;
import tncc.power.value.Space;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public class SpaceManagerImpl extends CommonManagerImpl implements SpaceManager
{

    public SpaceManagerImpl()
    {
    }

    public SpaceDAO getGenericDAO()
    {
        return (SpaceDAO)super.getGenericDAO();
    }

    public void setGenericDAO(SpaceDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveSpace(Space val)
    {
        getGenericDAO().saveSpace(val);
    }

    public void removeSpace(Space val)
    {
        getGenericDAO().removeSpace(val);
    }

    public void removeSpace(Long id)
    {
        getGenericDAO().removeSpace(id);
    }

    public Space getSpaceById(Long id)
    {
         return getGenericDAO().findSpaceById(id);
    }

    public List<Space> getSpaceList()
    {
        return getGenericDAO().findAllSpace();
    }
    public List<Member> getCreatedUserList()
    {
        return getGenericDAO().findCreatedUserList();
    }

    public List<Building> getBuildingList()
    {
        return getGenericDAO().findBuildingList();
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

