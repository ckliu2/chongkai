package com.common.service;

import com.common.value.WebLog;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 18 16:53:07 CST 2014
*/

public interface WebLogManager extends CommonManager 
{
    public abstract void saveWebLog(WebLog val);

    public abstract void removeWebLog(WebLog val);

    public abstract void removeWebLog(Long id);

    public abstract WebLog getWebLogById(Long id);

    public abstract List<WebLog> getWebLogList();
}

