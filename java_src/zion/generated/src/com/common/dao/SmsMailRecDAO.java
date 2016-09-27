package com.common.dao;

import com.common.value.SmsMailRec;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 18 16:53:07 CST 2014
*/

public interface SmsMailRecDAO extends CommonDAO 
{
    public abstract void saveSmsMailRec(SmsMailRec val);

    public abstract void removeSmsMailRec(SmsMailRec val);

    public abstract void removeSmsMailRec(Long id);

    public abstract SmsMailRec findSmsMailRecById(Long id);

    public abstract List<SmsMailRec> findAllSmsMailRec();
    public abstract List<Member> findTargetList();
    public abstract List<Member> findMemberList();
}

