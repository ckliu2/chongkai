package org.zion.service;

import org.zion.value.PrayStreet;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public interface PrayStreetManager extends CommonManager 
{
    public abstract void savePrayStreet(PrayStreet val);

    public abstract void removePrayStreet(PrayStreet val);

    public abstract void removePrayStreet(Long id);

    public abstract PrayStreet getPrayStreetById(Long id);

    public abstract List<PrayStreet> getPrayStreetList();
    public abstract List<UploadedFile> getMapList();
    public abstract List<UploadedFile> getPhoto1List();
    public abstract List<UploadedFile> getPhoto2List();
    public abstract List<UploadedFile> getPhoto3List();
    public abstract List<PrayTW> getPraytwList();
}

