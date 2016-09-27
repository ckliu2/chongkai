package com.common.service.impl;

import com.common.service.GradeManager;
import com.common.dao.GradeDAO;
import com.common.value.Grade;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public class GradeManagerImpl extends CommonManagerImpl implements GradeManager
{

    public GradeManagerImpl()
    {
    }

    public GradeDAO getGenericDAO()
    {
        return (GradeDAO)super.getGenericDAO();
    }

    public void setGenericDAO(GradeDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveGrade(Grade val)
    {
        getGenericDAO().saveGrade(val);
    }

    public void removeGrade(Grade val)
    {
        getGenericDAO().removeGrade(val);
    }

    public void removeGrade(Long id)
    {
        getGenericDAO().removeGrade(id);
    }

    public Grade getGradeById(Long id)
    {
         return getGenericDAO().findGradeById(id);
    }

    public List<Grade> getGradeList()
    {
        return getGenericDAO().findAllGrade();
    }
    public Long[] getIdsFromMemberList(List<Member> lst)
    {
        return getGenericDAO().getIdsFromMemberList(lst);
    }

    public List<Member> getMemberListByIds(Long[] ids)
    {
        return getGenericDAO().getMemberListByIds(ids);
    }

}

