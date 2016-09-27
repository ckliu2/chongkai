package com.web.service;

import com.web.value.CheckingState;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
*/

public interface CheckingStateManager extends CommonManager 
{
    public abstract void saveCheckingState(CheckingState val);

    public abstract void removeCheckingState(CheckingState val);

    public abstract void removeCheckingState(Long id);

    public abstract CheckingState getCheckingStateById(Long id);

    public abstract List<CheckingState> getCheckingStateList();
    public abstract List<Member> getCreatedUserList();
}

