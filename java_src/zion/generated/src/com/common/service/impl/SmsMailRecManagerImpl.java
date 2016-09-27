package com.common.service.impl;

import com.common.service.SmsMailRecManager;
import com.common.dao.SmsMailRecDAO;
import com.common.value.SmsMailRec;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 18 16:53:07 CST 2014
*/

public class SmsMailRecManagerImpl extends CommonManagerImpl implements SmsMailRecManager
{

    public SmsMailRecManagerImpl()
    {
    }

    public SmsMailRecDAO getGenericDAO()
    {
        return (SmsMailRecDAO)super.getGenericDAO();
    }

    public void setGenericDAO(SmsMailRecDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveSmsMailRec(SmsMailRec val)
    {
        getGenericDAO().saveSmsMailRec(val);
    }

    public void removeSmsMailRec(SmsMailRec val)
    {
        getGenericDAO().removeSmsMailRec(val);
    }

    public void removeSmsMailRec(Long id)
    {
        getGenericDAO().removeSmsMailRec(id);
    }

    public SmsMailRec getSmsMailRecById(Long id)
    {
         return getGenericDAO().findSmsMailRecById(id);
    }

    public List<SmsMailRec> getSmsMailRecList()
    {
        return getGenericDAO().findAllSmsMailRec();
    }
    public List<Member> getTargetList()
    {
        return getGenericDAO().findTargetList();
    }

    public List<Member> getMemberList()
    {
        return getGenericDAO().findMemberList();
    }

}

