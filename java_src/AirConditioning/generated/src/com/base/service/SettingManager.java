package com.base.service;

import com.base.value.Setting;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Oct 17 16:59:08 CST 2013
*/

public interface SettingManager extends CommonManager 
{
    public abstract void saveSetting(Setting val);

    public abstract void removeSetting(Setting val);

    public abstract void removeSetting(Long id);

    public abstract Setting getSettingById(Long id);

    public abstract List<Setting> getSettingList();
}

