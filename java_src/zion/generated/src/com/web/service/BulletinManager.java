package com.web.service;

import com.web.value.Bulletin;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
*/

public interface BulletinManager extends CommonManager 
{
    public abstract void saveBulletin(Bulletin val);

    public abstract void removeBulletin(Bulletin val);

    public abstract void removeBulletin(Long id);

    public abstract Bulletin getBulletinById(Long id);

    public abstract List<Bulletin> getBulletinList();
    public abstract List<Member> getLastModifiedUserList();
    public abstract List<Member> getCreatedUserList();
    public abstract List<UploadedFile> getFileList();
    public abstract List<UploadedFile> getVoiceList();
    public abstract List<UploadedFile> getVedioList();
    public abstract List<UploadedFile> getFrontcoverList();
}

