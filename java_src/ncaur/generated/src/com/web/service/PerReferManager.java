package com.web.service;

import com.web.value.PerRefer;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public interface PerReferManager extends CommonManager 
{
    public abstract void savePerRefer(PerRefer val);

    public abstract void removePerRefer(PerRefer val);

    public abstract void removePerRefer(Long id);

    public abstract PerRefer getPerReferById(Long id);

    public abstract List<PerRefer> getPerReferList();
    public abstract List<Member> getTeacherList();
}

