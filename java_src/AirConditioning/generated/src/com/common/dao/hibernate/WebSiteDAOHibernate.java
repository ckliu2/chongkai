package com.common.dao.hibernate;

import com.common.value.WebSite;
import com.common.dao.WebSiteDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public class WebSiteDAOHibernate extends CommonDAOHibernate implements WebSiteDAO
{

    public WebSiteDAOHibernate()
    {
    }

    public void saveWebSite(WebSite val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeWebSite(WebSite val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeWebSite(Long id)
    {
        WebSite obj = findWebSiteById(id);
        getHibernateTemplate().delete(obj);
    }

    public WebSite findWebSiteById(Long id)
    {
        if (id == null)
            return null;
        WebSite obj = (WebSite)getHibernateTemplate().get(com.common.value.WebSite.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.common.value.WebSite.class, id);
        else
            return obj;
    }

    public List<WebSite> findAllWebSite()
    {
        return getHibernateTemplate().find("from WebSite");
    }
    public Long[] getIdsFromFunctionCategoryList(List tlist)
    {
        ArrayList<Long> al = new ArrayList<Long>();
        if (tlist != null) {
            for (int i = 0; i < tlist.size(); i++) {
                FunctionCategory t = (FunctionCategory) tlist.get(i);
                if (t != null)
                    al.add(t.getId());
            }
        }
        Long lng[] = new Long[al.size()];
        al.toArray(lng);
        
        return lng;
    }

    public List getFunctionCategoryListByIds(Long[] ids)
    {
        ArrayList<FunctionCategory> al = new ArrayList<FunctionCategory>();
        if (ids != null) {
            for (int i = 0; i < ids.length; i++) {
                FunctionCategory t = (FunctionCategory) findFunctionCategoryById(ids[i]);
                if (t != null)
                    al.add(t);
            }
        }
        return al;
    }
}

