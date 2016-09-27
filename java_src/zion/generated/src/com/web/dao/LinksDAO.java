package com.web.dao;

import com.web.value.Links;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
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

