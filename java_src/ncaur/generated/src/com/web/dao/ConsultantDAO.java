package com.web.dao;

import com.web.value.Consultant;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public interface ConsultantDAO extends CommonDAO 
{
    public abstract void saveConsultant(Consultant val);

    public abstract void removeConsultant(Consultant val);

    public abstract void removeConsultant(Long id);

    public abstract Consultant findConsultantById(Long id);

    public abstract List<Consultant> findAllConsultant();
    public abstract List<Member> findMemberList();
}

