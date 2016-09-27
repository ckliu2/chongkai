package com.base.dao;

import com.base.value.FunctionAuthority;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 18 16:53:07 CST 2014
*/

public interface FunctionAuthorityDAO extends CommonDAO 
{
    public abstract void saveFunctionAuthority(FunctionAuthority val);

    public abstract void removeFunctionAuthority(FunctionAuthority val);

    public abstract void removeFunctionAuthority(Long id);

    public abstract FunctionAuthority findFunctionAuthorityById(Long id);

    public abstract List<FunctionAuthority> findAllFunctionAuthority();
    public abstract List<Group> findGroupList();
}

