package com.base.dao;

import com.base.value.MiscCode;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 18 16:53:07 CST 2014
*/

public interface MiscCodeDAO extends CommonDAO 
{
    public abstract void saveMiscCode(MiscCode val);

    public abstract void removeMiscCode(MiscCode val);

    public abstract void removeMiscCode(Long id);

    public abstract MiscCode findMiscCodeById(Long id);

    public abstract List<MiscCode> findAllMiscCode();
}

