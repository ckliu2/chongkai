package com.base.service.impl;

import com.base.service.MiscCodeManager;
import com.base.dao.MiscCodeDAO;
import com.base.value.MiscCode;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public class MiscCodeManagerImpl extends CommonManagerImpl implements MiscCodeManager
{

    public MiscCodeManagerImpl()
    {
    }

    public MiscCodeDAO getGenericDAO()
    {
        return (MiscCodeDAO)super.getGenericDAO();
    }

    public void setGenericDAO(MiscCodeDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveMiscCode(MiscCode val)
    {
        getGenericDAO().saveMiscCode(val);
    }

    public void removeMiscCode(MiscCode val)
    {
        getGenericDAO().removeMiscCode(val);
    }

    public void removeMiscCode(Long id)
    {
        getGenericDAO().removeMiscCode(id);
    }

    public MiscCode getMiscCodeById(Long id)
    {
         return getGenericDAO().findMiscCodeById(id);
    }

    public List<MiscCode> getMiscCodeList()
    {
        return getGenericDAO().findAllMiscCode();
    }
}

