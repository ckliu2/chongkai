package com.web.dao;

import com.web.value.Bolg;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public interface BolgDAO extends CommonDAO 
{
    public abstract void saveBolg(Bolg val);

    public abstract void removeBolg(Bolg val);

    public abstract void removeBolg(Long id);

    public abstract Bolg findBolgById(Long id);

    public abstract List<Bolg> findAllBolg();
    public abstract List<Member> findLastModifiedUserList();
    public abstract List<Member> findCreatedUserList();
    public abstract List<UploadedFile> findMyfileList();
    public abstract List<UploadedFile> findPhotoList();
    public abstract List<BolgClass> findBolgClassList();
}

