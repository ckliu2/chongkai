package org.zion.service;

import org.zion.value.BibleLection;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public interface BibleLectionManager extends CommonManager 
{
    public abstract void saveBibleLection(BibleLection val);

    public abstract void removeBibleLection(BibleLection val);

    public abstract void removeBibleLection(Long id);

    public abstract BibleLection getBibleLectionById(Long id);

    public abstract List<BibleLection> getBibleLectionList();
}

