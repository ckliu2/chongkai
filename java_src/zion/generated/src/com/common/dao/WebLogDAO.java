package com.common.dao;

import com.common.value.WebLog;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 18 16:53:07 CST 2014
*/

public interface WebLogDAO extends CommonDAO 
{
    public abstract void saveWebLog(WebLog val);

    public abstract void removeWebLog(WebLog val);

    public abstract void removeWebLog(Long id);

    public abstract WebLog findWebLogById(Long id);

    public abstract List<WebLog> findAllWebLog();
}

