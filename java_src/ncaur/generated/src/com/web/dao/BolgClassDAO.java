package com.web.dao;

import com.web.value.BolgClass;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public interface BolgClassDAO extends CommonDAO 
{
    public abstract void saveBolgClass(BolgClass val);

    public abstract void removeBolgClass(BolgClass val);

    public abstract void removeBolgClass(Long id);

    public abstract BolgClass findBolgClassById(Long id);

    public abstract List<BolgClass> findAllBolgClass();
    public abstract List<Member> findLastModifiedUserList();
    public abstract List<Member> findCreatedUserList();
}

