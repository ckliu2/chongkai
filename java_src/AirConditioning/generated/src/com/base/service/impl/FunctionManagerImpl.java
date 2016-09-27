package com.base.service.impl;

import com.base.service.FunctionManager;
import com.base.dao.FunctionDAO;
import com.base.value.Function;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public class FunctionManagerImpl extends CommonManagerImpl implements FunctionManager
{

    public FunctionManagerImpl()
    {
    }

    public FunctionDAO getGenericDAO()
    {
        return (FunctionDAO)super.getGenericDAO();
    }

    public void setGenericDAO(FunctionDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveFunction(Function val)
    {
        getGenericDAO().saveFunction(val);
    }

    public void removeFunction(Function val)
    {
        getGenericDAO().removeFunction(val);
    }

    public void removeFunction(Long id)
    {
        getGenericDAO().removeFunction(id);
    }

    public Function getFunctionById(Long id)
    {
         return getGenericDAO().findFunctionById(id);
    }

    public List<Function> getFunctionList()
    {
        return getGenericDAO().findAllFunction();
    }
    public List<FunctionCategory> getCategoryList()
    {
        return getGenericDAO().findCategoryList();
    }

}

