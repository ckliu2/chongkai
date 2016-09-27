package org.zion.service.impl;

import org.zion.service.BibleLectionManager;
import org.zion.dao.BibleLectionDAO;
import org.zion.value.BibleLection;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public class BibleLectionManagerImpl extends CommonManagerImpl implements BibleLectionManager
{

    public BibleLectionManagerImpl()
    {
    }

    public BibleLectionDAO getGenericDAO()
    {
        return (BibleLectionDAO)super.getGenericDAO();
    }

    public void setGenericDAO(BibleLectionDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveBibleLection(BibleLection val)
    {
        getGenericDAO().saveBibleLection(val);
    }

    public void removeBibleLection(BibleLection val)
    {
        getGenericDAO().removeBibleLection(val);
    }

    public void removeBibleLection(Long id)
    {
        getGenericDAO().removeBibleLection(id);
    }

    public BibleLection getBibleLectionById(Long id)
    {
         return getGenericDAO().findBibleLectionById(id);
    }

    public List<BibleLection> getBibleLectionList()
    {
        return getGenericDAO().findAllBibleLection();
    }
}

