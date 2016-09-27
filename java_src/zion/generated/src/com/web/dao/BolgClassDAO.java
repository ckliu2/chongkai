package com.web.dao;

import com.web.value.BolgClass;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
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

