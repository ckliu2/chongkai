package com.base.dao;

import com.base.value.Setting;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Oct 17 16:59:08 CST 2013
*/

public interface SettingDAO extends CommonDAO 
{
    public abstract void saveSetting(Setting val);

    public abstract void removeSetting(Setting val);

    public abstract void removeSetting(Long id);

    public abstract Setting findSettingById(Long id);

    public abstract List<Setting> findAllSetting();
}

