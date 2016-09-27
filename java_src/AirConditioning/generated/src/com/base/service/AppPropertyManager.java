package com.base.service;

import com.base.value.AppProperty;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public interface AppPropertyManager extends CommonManager 
{
    public abstract void saveAppProperty(AppProperty val);

    public abstract void removeAppProperty(AppProperty val);

    public abstract void removeAppProperty(Long id);

    public abstract AppProperty getAppPropertyById(Long id);

    public abstract List<AppProperty> getAppPropertyList();
}

