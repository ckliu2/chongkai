package com.web.service.impl;

import com.web.service.AgreeTermsManager;
import com.web.dao.AgreeTermsDAO;
import com.web.value.AgreeTerms;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public class AgreeTermsManagerImpl extends CommonManagerImpl implements AgreeTermsManager
{

    public AgreeTermsManagerImpl()
    {
    }

    public AgreeTermsDAO getGenericDAO()
    {
        return (AgreeTermsDAO)super.getGenericDAO();
    }

    public void setGenericDAO(AgreeTermsDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveAgreeTerms(AgreeTerms val)
    {
        getGenericDAO().saveAgreeTerms(val);
    }

    public void removeAgreeTerms(AgreeTerms val)
    {
        getGenericDAO().removeAgreeTerms(val);
    }

    public void removeAgreeTerms(Long id)
    {
        getGenericDAO().removeAgreeTerms(id);
    }

    public AgreeTerms getAgreeTermsById(Long id)
    {
         return getGenericDAO().findAgreeTermsById(id);
    }

    public List<AgreeTerms> getAgreeTermsList()
    {
        return getGenericDAO().findAllAgreeTerms();
    }
    public List<Member> getCreatedUserList()
    {
        return getGenericDAO().findCreatedUserList();
    }

}

