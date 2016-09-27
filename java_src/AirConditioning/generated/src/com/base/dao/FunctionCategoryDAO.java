package com.base.dao;

import com.base.value.FunctionCategory;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public interface FunctionCategoryDAO extends CommonDAO 
{
    public abstract void saveFunctionCategory(FunctionCategory val);

    public abstract void removeFunctionCategory(FunctionCategory val);

    public abstract void removeFunctionCategory(Long id);

    public abstract FunctionCategory findFunctionCategoryById(Long id);

    public abstract List<FunctionCategory> findAllFunctionCategory();
}

