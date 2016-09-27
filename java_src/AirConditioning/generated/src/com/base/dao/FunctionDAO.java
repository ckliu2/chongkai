package com.base.dao;

import com.base.value.Function;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public interface FunctionDAO extends CommonDAO 
{
    public abstract void saveFunction(Function val);

    public abstract void removeFunction(Function val);

    public abstract void removeFunction(Long id);

    public abstract Function findFunctionById(Long id);

    public abstract List<Function> findAllFunction();
    public abstract List<FunctionCategory> findCategoryList();
}

