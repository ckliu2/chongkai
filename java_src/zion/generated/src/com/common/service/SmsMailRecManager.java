package com.common.service;

import com.common.value.SmsMailRec;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 18 16:53:07 CST 2014
*/

public interface SmsMailRecManager extends CommonManager 
{
    public abstract void saveSmsMailRec(SmsMailRec val);

    public abstract void removeSmsMailRec(SmsMailRec val);

    public abstract void removeSmsMailRec(Long id);

    public abstract SmsMailRec getSmsMailRecById(Long id);

    public abstract List<SmsMailRec> getSmsMailRecList();
    public abstract List<Member> getTargetList();
    public abstract List<Member> getMemberList();
}

