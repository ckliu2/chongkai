package com.base.service.impl;

import com.base.service.FunctionAuthorityManager;
import com.base.dao.FunctionAuthorityDAO;
import com.base.value.FunctionAuthority;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public class FunctionAuthorityManagerImpl extends CommonManagerImpl implements FunctionAuthorityManager
{

    public FunctionAuthorityManagerImpl()
    {
    }

    public FunctionAuthorityDAO getGenericDAO()
    {
        return (FunctionAuthorityDAO)super.getGenericDAO();
    }

    public void setGenericDAO(FunctionAuthorityDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveFunctionAuthority(FunctionAuthority val)
    {
        getGenericDAO().saveFunctionAuthority(val);
    }

    public void removeFunctionAuthority(FunctionAuthority val)
    {
        getGenericDAO().removeFunctionAuthority(val);
    }

    public void removeFunctionAuthority(Long id)
    {
        getGenericDAO().removeFunctionAuthority(id);
    }

    public FunctionAuthority getFunctionAuthorityById(Long id)
    {
         return getGenericDAO().findFunctionAuthorityById(id);
    }

    public List<FunctionAuthority> getFunctionAuthorityList()
    {
        return getGenericDAO().findAllFunctionAuthority();
    }
    public List<Group> getGroupList()
    {
        return getGenericDAO().findGroupList();
    }

}

