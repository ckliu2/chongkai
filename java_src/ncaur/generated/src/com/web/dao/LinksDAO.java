package com.web.dao;

import com.web.value.Links;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public interface LinksDAO extends CommonDAO 
{
    public abstract void saveLinks(Links val);

    public abstract void removeLinks(Links val);

    public abstract void removeLinks(Long id);

    public abstract Links findLinksById(Long id);

    public abstract List<Links> findAllLinks();
    public abstract List<Member> findLastModifiedUserList();
    public abstract List<Member> findCreatedUserList();
    public abstract List<UploadedFile> findPhotoList();
}

