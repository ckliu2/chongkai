package com.web.service;

import com.web.value.AgreeTerms;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public interface AgreeTermsManager extends CommonManager 
{
    public abstract void saveAgreeTerms(AgreeTerms val);

    public abstract void removeAgreeTerms(AgreeTerms val);

    public abstract void removeAgreeTerms(Long id);

    public abstract AgreeTerms getAgreeTermsById(Long id);

    public abstract List<AgreeTerms> getAgreeTermsList();
    public abstract List<Member> getCreatedUserList();
}

