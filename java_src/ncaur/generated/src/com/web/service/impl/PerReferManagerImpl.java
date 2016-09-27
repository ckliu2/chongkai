package com.web.service.impl;

import com.web.service.PerReferManager;
import com.web.dao.PerReferDAO;
import com.web.value.PerRefer;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public class PerReferManagerImpl extends CommonManagerImpl implements PerReferManager
{

    public PerReferManagerImpl()
    {
    }

    public PerReferDAO getGenericDAO()
    {
        return (PerReferDAO)super.getGenericDAO();
    }

    public void setGenericDAO(PerReferDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void savePerRefer(PerRefer val)
    {
        getGenericDAO().savePerRefer(val);
    }

    public void removePerRefer(PerRefer val)
    {
        getGenericDAO().removePerRefer(val);
    }

    public void removePerRefer(Long id)
    {
        getGenericDAO().removePerRefer(id);
    }

    public PerRefer getPerReferById(Long id)
    {
         return getGenericDAO().findPerReferById(id);
    }

    public List<PerRefer> getPerReferList()
    {
        return getGenericDAO().findAllPerRefer();
    }
    public List<Member> getTeacherList()
    {
        return getGenericDAO().findTeacherList();
    }

}

