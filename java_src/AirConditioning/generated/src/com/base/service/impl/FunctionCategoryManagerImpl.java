package com.base.service.impl;

import com.base.service.FunctionCategoryManager;
import com.base.dao.FunctionCategoryDAO;
import com.base.value.FunctionCategory;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public class FunctionCategoryManagerImpl extends CommonManagerImpl implements FunctionCategoryManager
{

    public FunctionCategoryManagerImpl()
    {
    }

    public FunctionCategoryDAO getGenericDAO()
    {
        return (FunctionCategoryDAO)super.getGenericDAO();
    }

    public void setGenericDAO(FunctionCategoryDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveFunctionCategory(FunctionCategory val)
    {
        getGenericDAO().saveFunctionCategory(val);
    }

    public void removeFunctionCategory(FunctionCategory val)
    {
        getGenericDAO().removeFunctionCategory(val);
    }

    public void removeFunctionCategory(Long id)
    {
        getGenericDAO().removeFunctionCategory(id);
    }

    public FunctionCategory getFunctionCategoryById(Long id)
    {
         return getGenericDAO().findFunctionCategoryById(id);
    }

    public List<FunctionCategory> getFunctionCategoryList()
    {
        return getGenericDAO().findAllFunctionCategory();
    }
}

