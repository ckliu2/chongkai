package com.base.service;

import com.base.value.Function;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 18 16:53:07 CST 2014
*/

public interface FunctionManager extends CommonManager 
{
    public abstract void saveFunction(Function val);

    public abstract void removeFunction(Function val);

    public abstract void removeFunction(Long id);

    public abstract Function getFunctionById(Long id);

    public abstract List<Function> getFunctionList();
    public abstract List<FunctionCategory> getCategoryList();
}

