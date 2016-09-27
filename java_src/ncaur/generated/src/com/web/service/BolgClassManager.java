package com.web.service;

import com.web.value.BolgClass;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public interface BolgClassManager extends CommonManager 
{
    public abstract void saveBolgClass(BolgClass val);

    public abstract void removeBolgClass(BolgClass val);

    public abstract void removeBolgClass(Long id);

    public abstract BolgClass getBolgClassById(Long id);

    public abstract List<BolgClass> getBolgClassList();
    public abstract List<Member> getLastModifiedUserList();
    public abstract List<Member> getCreatedUserList();
}

