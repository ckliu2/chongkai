package com.web.dao;

import com.web.value.Bolg;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
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
    public abstract List<UploadedFile> findFileList();
    public abstract List<UploadedFile> findPhotoList();
    public abstract List<BolgClass> findBolgClassList();
}

