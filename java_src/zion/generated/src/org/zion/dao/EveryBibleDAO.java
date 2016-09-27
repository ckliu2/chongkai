package org.zion.dao;

import org.zion.value.EveryBible;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public interface EveryBibleDAO extends CommonDAO 
{
    public abstract void saveEveryBible(EveryBible val);

    public abstract void removeEveryBible(EveryBible val);

    public abstract void removeEveryBible(Long id);

    public abstract EveryBible findEveryBibleById(Long id);

    public abstract List<EveryBible> findAllEveryBible();
    public abstract List<Member> findMemberList();
}

