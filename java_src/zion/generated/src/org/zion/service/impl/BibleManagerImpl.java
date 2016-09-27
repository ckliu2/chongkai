package org.zion.service.impl;

import org.zion.service.BibleManager;
import org.zion.dao.BibleDAO;
import org.zion.value.Bible;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public class BibleManagerImpl extends CommonManagerImpl implements BibleManager
{

    public BibleManagerImpl()
    {
    }

    public BibleDAO getGenericDAO()
    {
        return (BibleDAO)super.getGenericDAO();
    }

    public void setGenericDAO(BibleDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveBible(Bible val)
    {
        getGenericDAO().saveBible(val);
    }

    public void removeBible(Bible val)
    {
        getGenericDAO().removeBible(val);
    }

    public void removeBible(Long id)
    {
        getGenericDAO().removeBible(id);
    }

    public Bible getBibleById(Long id)
    {
         return getGenericDAO().findBibleById(id);
    }

    public List<Bible> getBibleList()
    {
        return getGenericDAO().findAllBible();
    }
}

