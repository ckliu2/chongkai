package org.zion.dao;

import org.zion.value.PrayTW;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public interface PrayTWDAO extends CommonDAO 
{
    public abstract void savePrayTW(PrayTW val);

    public abstract void removePrayTW(PrayTW val);

    public abstract void removePrayTW(Long id);

    public abstract PrayTW findPrayTWById(Long id);

    public abstract List<PrayTW> findAllPrayTW();
    public abstract List<UploadedFile> findMapList();
    public abstract List<UploadedFile> findPhoto1List();
    public abstract List<UploadedFile> findPhoto2List();
    public abstract List<UploadedFile> findPhoto3List();
}

