package org.zion.service;

import org.zion.value.Bible;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public interface BibleManager extends CommonManager 
{
    public abstract void saveBible(Bible val);

    public abstract void removeBible(Bible val);

    public abstract void removeBible(Long id);

    public abstract Bible getBibleById(Long id);

    public abstract List<Bible> getBibleList();
}

