package com.web.service;

import com.web.value.Links;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
*/

public interface LinksManager extends CommonManager 
{
    public abstract void saveLinks(Links val);

    public abstract void removeLinks(Links val);

    public abstract void removeLinks(Long id);

    public abstract Links getLinksById(Long id);

    public abstract List<Links> getLinksList();
    public abstract List<Member> getLastModifiedUserList();
    public abstract List<Member> getCreatedUserList();
    public abstract List<UploadedFile> getPhotoList();
}

