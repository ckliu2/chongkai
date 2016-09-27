package com.web.service.impl;

import com.web.service.LinksManager;
import com.web.dao.LinksDAO;
import com.web.value.Links;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
*/

public class LinksManagerImpl extends CommonManagerImpl implements LinksManager
{

    public LinksManagerImpl()
    {
    }

    public LinksDAO getGenericDAO()
    {
        return (LinksDAO)super.getGenericDAO();
    }

    public void setGenericDAO(LinksDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveLinks(Links val)
    {
        getGenericDAO().saveLinks(val);
    }

    public void removeLinks(Links val)
    {
        getGenericDAO().removeLinks(val);
    }

    public void removeLinks(Long id)
    {
        getGenericDAO().removeLinks(id);
    }

    public Links getLinksById(Long id)
    {
         return getGenericDAO().findLinksById(id);
    }

    public List<Links> getLinksList()
    {
        return getGenericDAO().findAllLinks();
    }
    public List<Member> getLastModifiedUserList()
    {
        return getGenericDAO().findLastModifiedUserList();
    }

    public List<Member> getCreatedUserList()
    {
        return getGenericDAO().findCreatedUserList();
    }

    public List<UploadedFile> getPhotoList()
    {
        return getGenericDAO().findPhotoList();
    }

}

