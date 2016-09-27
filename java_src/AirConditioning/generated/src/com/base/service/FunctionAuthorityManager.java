package com.base.service;

import com.base.value.FunctionAuthority;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public interface FunctionAuthorityManager extends CommonManager 
{
    public abstract void saveFunctionAuthority(FunctionAuthority val);

    public abstract void removeFunctionAuthority(FunctionAuthority val);

    public abstract void removeFunctionAuthority(Long id);

    public abstract FunctionAuthority getFunctionAuthorityById(Long id);

    public abstract List<FunctionAuthority> getFunctionAuthorityList();
    public abstract List<Group> getGroupList();
}

