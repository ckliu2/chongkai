package com.web.service;

import com.web.value.Consultant;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public interface ConsultantManager extends CommonManager 
{
    public abstract void saveConsultant(Consultant val);

    public abstract void removeConsultant(Consultant val);

    public abstract void removeConsultant(Long id);

    public abstract Consultant getConsultantById(Long id);

    public abstract List<Consultant> getConsultantList();
    public abstract List<Member> getMemberList();
}

