package org.zion.dao;

import org.zion.value.Pray;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public interface PrayDAO extends CommonDAO 
{
    public abstract void savePray(Pray val);

    public abstract void removePray(Pray val);

    public abstract void removePray(Long id);

    public abstract Pray findPrayById(Long id);

    public abstract List<Pray> findAllPray();
    public abstract List<Member> findLastModifiedUserList();
    public abstract List<Member> findCreatedUserList();
}

