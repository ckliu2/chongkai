package org.zion.service.impl;

import org.zion.service.EveryBibleManager;
import org.zion.dao.EveryBibleDAO;
import org.zion.value.EveryBible;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public class EveryBibleManagerImpl extends CommonManagerImpl implements EveryBibleManager
{

    public EveryBibleManagerImpl()
    {
    }

    public EveryBibleDAO getGenericDAO()
    {
        return (EveryBibleDAO)super.getGenericDAO();
    }

    public void setGenericDAO(EveryBibleDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveEveryBible(EveryBible val)
    {
        getGenericDAO().saveEveryBible(val);
    }

    public void removeEveryBible(EveryBible val)
    {
        getGenericDAO().removeEveryBible(val);
    }

    public void removeEveryBible(Long id)
    {
        getGenericDAO().removeEveryBible(id);
    }

    public EveryBible getEveryBibleById(Long id)
    {
         return getGenericDAO().findEveryBibleById(id);
    }

    public List<EveryBible> getEveryBibleList()
    {
        return getGenericDAO().findAllEveryBible();
    }
    public List<Member> getMemberList()
    {
        return getGenericDAO().findMemberList();
    }

}

