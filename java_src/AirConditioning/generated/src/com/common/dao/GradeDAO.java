package com.common.dao;

import com.common.value.Grade;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public interface GradeDAO extends CommonDAO 
{
    public abstract void saveGrade(Grade val);

    public abstract void removeGrade(Grade val);

    public abstract void removeGrade(Long id);

    public abstract Grade findGradeById(Long id);

    public abstract List<Grade> findAllGrade();
    public abstract Long[] getIdsFromMemberList(List<Member> lst);

    public abstract List<Member> getMemberListByIds(Long[] ids);

}

