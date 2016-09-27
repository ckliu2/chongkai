package com.web.service.impl;

import com.web.service.ConsultantManager;
import com.web.dao.ConsultantDAO;
import com.web.value.Consultant;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public class ConsultantManagerImpl extends CommonManagerImpl implements ConsultantManager
{

    public ConsultantManagerImpl()
    {
    }

    public ConsultantDAO getGenericDAO()
    {
        return (ConsultantDAO)super.getGenericDAO();
    }

    public void setGenericDAO(ConsultantDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveConsultant(Consultant val)
    {
        getGenericDAO().saveConsultant(val);
    }

    public void removeConsultant(Consultant val)
    {
        getGenericDAO().removeConsultant(val);
    }

    public void removeConsultant(Long id)
    {
        getGenericDAO().removeConsultant(id);
    }

    public Consultant getConsultantById(Long id)
    {
         return getGenericDAO().findConsultantById(id);
    }

    public List<Consultant> getConsultantList()
    {
        return getGenericDAO().findAllConsultant();
    }
    public List<Member> getMemberList()
    {
        return getGenericDAO().findMemberList();
    }

}

