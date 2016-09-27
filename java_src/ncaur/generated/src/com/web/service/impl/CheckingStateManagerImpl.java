package com.web.service.impl;

import com.web.service.CheckingStateManager;
import com.web.dao.CheckingStateDAO;
import com.web.value.CheckingState;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public class CheckingStateManagerImpl extends CommonManagerImpl implements CheckingStateManager
{

    public CheckingStateManagerImpl()
    {
    }

    public CheckingStateDAO getGenericDAO()
    {
        return (CheckingStateDAO)super.getGenericDAO();
    }

    public void setGenericDAO(CheckingStateDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveCheckingState(CheckingState val)
    {
        getGenericDAO().saveCheckingState(val);
    }

    public void removeCheckingState(CheckingState val)
    {
        getGenericDAO().removeCheckingState(val);
    }

    public void removeCheckingState(Long id)
    {
        getGenericDAO().removeCheckingState(id);
    }

    public CheckingState getCheckingStateById(Long id)
    {
         return getGenericDAO().findCheckingStateById(id);
    }

    public List<CheckingState> getCheckingStateList()
    {
        return getGenericDAO().findAllCheckingState();
    }
    public List<Member> getCreatedUserList()
    {
        return getGenericDAO().findCreatedUserList();
    }

}

