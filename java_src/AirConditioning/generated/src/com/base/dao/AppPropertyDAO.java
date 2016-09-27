package com.base.dao;

import com.base.value.AppProperty;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public interface AppPropertyDAO extends CommonDAO 
{
    public abstract void saveAppProperty(AppProperty val);

    public abstract void removeAppProperty(AppProperty val);

    public abstract void removeAppProperty(Long id);

    public abstract AppProperty findAppPropertyById(Long id);

    public abstract List<AppProperty> findAllAppProperty();
}

