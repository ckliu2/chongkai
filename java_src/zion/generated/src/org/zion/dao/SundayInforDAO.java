package org.zion.dao;

import org.zion.value.SundayInfor;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public interface SundayInforDAO extends CommonDAO 
{
    public abstract void saveSundayInfor(SundayInfor val);

    public abstract void removeSundayInfor(SundayInfor val);

    public abstract void removeSundayInfor(Long id);

    public abstract SundayInfor findSundayInforById(Long id);

    public abstract List<SundayInfor> findAllSundayInfor();
}

