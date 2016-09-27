package com.web.dao;

import com.web.value.Bulletin;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
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
    public abstract List<UploadedFile> findFileList();
    public abstract List<UploadedFile> findVoiceList();
    public abstract List<UploadedFile> findVedioList();
    public abstract List<UploadedFile> findFrontcoverList();
}

