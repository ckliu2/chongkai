package com.base.service;

import com.base.value.FunctionCategory;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 18 16:53:07 CST 2014
*/

public interface FunctionCategoryManager extends CommonManager 
{
    public abstract void saveFunctionCategory(FunctionCategory val);

    public abstract void removeFunctionCategory(FunctionCategory val);

    public abstract void removeFunctionCategory(Long id);

    public abstract FunctionCategory getFunctionCategoryById(Long id);

    public abstract List<FunctionCategory> getFunctionCategoryList();
}

