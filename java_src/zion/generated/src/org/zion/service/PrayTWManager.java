package org.zion.service;

import org.zion.value.PrayTW;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public interface PrayTWManager extends CommonManager 
{
    public abstract void savePrayTW(PrayTW val);

    public abstract void removePrayTW(PrayTW val);

    public abstract void removePrayTW(Long id);

    public abstract PrayTW getPrayTWById(Long id);

    public abstract List<PrayTW> getPrayTWList();
    public abstract List<UploadedFile> getMapList();
    public abstract List<UploadedFile> getPhoto1List();
    public abstract List<UploadedFile> getPhoto2List();
    public abstract List<UploadedFile> getPhoto3List();
}

