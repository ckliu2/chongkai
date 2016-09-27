package com.web.dao;

import com.web.value.Bulletin;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public interface BulletinDAO extends CommonDAO 
{
    public abstract void saveBulletin(Bulletin val);

    public abstract void removeBulletin(Bulletin val);

    public abstract void removeBulletin(Long id);

    public abstract Bulletin findBulletinById(Long id);

    public abstract List<Bulletin> findAllBulletin();
    public abstract List<Member> findLastModifiedUserList();
    public abstract List<Member> findCreatedUserList();
    public abstract List<UploadedFile> findMyfileList();
    public abstract List<UploadedFile> findVoiceList();
    public abstract List<UploadedFile> findVedioList();
    public abstract List<UploadedFile> findFrontcoverList();
}

