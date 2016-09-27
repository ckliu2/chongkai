package com.base.service;

import com.base.value.MiscCode;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public interface MiscCodeManager extends CommonManager 
{
    public abstract void saveMiscCode(MiscCode val);

    public abstract void removeMiscCode(MiscCode val);

    public abstract void removeMiscCode(Long id);

    public abstract MiscCode getMiscCodeById(Long id);

    public abstract List<MiscCode> getMiscCodeList();
}

