package com.web.service;

import com.web.value.BolgClass;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
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

