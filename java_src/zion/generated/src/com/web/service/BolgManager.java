package com.web.service;

import com.web.value.Bolg;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
*/

public interface BolgManager extends CommonManager 
{
    public abstract void saveBolg(Bolg val);

    public abstract void removeBolg(Bolg val);

    public abstract void removeBolg(Long id);

    public abstract Bolg getBolgById(Long id);

    public abstract List<Bolg> getBolgList();
    public abstract List<Member> getLastModifiedUserList();
    public abstract List<Member> getCreatedUserList();
    public abstract List<UploadedFile> getFileList();
    public abstract List<UploadedFile> getPhotoList();
    public abstract List<BolgClass> getBolgClassList();
}
