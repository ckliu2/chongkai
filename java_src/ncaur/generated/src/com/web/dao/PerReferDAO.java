package com.web.dao;

import com.web.value.PerRefer;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public interface PerReferDAO extends CommonDAO 
{
    public abstract void savePerRefer(PerRefer val);

    public abstract void removePerRefer(PerRefer val);

    public abstract void removePerRefer(Long id);

    public abstract PerRefer findPerReferById(Long id);

    public abstract List<PerRefer> findAllPerRefer();
    public abstract List<Member> findTeacherList();
}

