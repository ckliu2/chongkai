package org.zion.dao;

import org.zion.value.PrayStreet;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public interface PrayStreetDAO extends CommonDAO 
{
    public abstract void savePrayStreet(PrayStreet val);

    public abstract void removePrayStreet(PrayStreet val);

    public abstract void removePrayStreet(Long id);

    public abstract PrayStreet findPrayStreetById(Long id);

    public abstract List<PrayStreet> findAllPrayStreet();
    public abstract List<UploadedFile> findMapList();
    public abstract List<UploadedFile> findPhoto1List();
    public abstract List<UploadedFile> findPhoto2List();
    public abstract List<UploadedFile> findPhoto3List();
    public abstract List<PrayTW> findPraytwList();
}

