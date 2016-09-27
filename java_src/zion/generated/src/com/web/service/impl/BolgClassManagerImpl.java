package com.web.service.impl;

import com.web.service.BolgClassManager;
import com.web.dao.BolgClassDAO;
import com.web.value.BolgClass;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
*/

public class BolgClassManagerImpl extends CommonManagerImpl implements BolgClassManager
{

    public BolgClassManagerImpl()
    {
    }

    public BolgClassDAO getGenericDAO()
    {
        return (BolgClassDAO)super.getGenericDAO();
    }

    public void setGenericDAO(BolgClassDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveBolgClass(BolgClass val)
    {
        getGenericDAO().saveBolgClass(val);
    }

    public void removeBolgClass(BolgClass val)
    {
        getGenericDAO().removeBolgClass(val);
    }

    public void removeBolgClass(Long id)
    {
        getGenericDAO().removeBolgClass(id);
    }

    public BolgClass getBolgClassById(Long id)
    {
         return getGenericDAO().findBolgClassById(id);
    }

    public List<BolgClass> getBolgClassList()
    {
        return getGenericDAO().findAllBolgClass();
    }
    public List<Member> getLastModifiedUserList()
    {
        return getGenericDAO().findLastModifiedUserList();
    }

    public List<Member> getCreatedUserList()
    {
        return getGenericDAO().findCreatedUserList();
    }

}

