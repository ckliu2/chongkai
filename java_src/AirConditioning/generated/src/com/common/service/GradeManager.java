package com.common.service;

import com.common.value.Grade;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public interface GradeManager extends CommonManager 
{
    public abstract void saveGrade(Grade val);

    public abstract void removeGrade(Grade val);

    public abstract void removeGrade(Long id);

    public abstract Grade getGradeById(Long id);

    public abstract List<Grade> getGradeList();
    public abstract Long[] getIdsFromMemberList(List<Member> lst);

    public abstract List<Member> getMemberListByIds(Long[] ids);

}

