package com.web.dao.hibernate;

import com.web.value.SubItem;
import com.web.dao.SubItemDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
*/

public class SubItemDAOHibernate extends CommonDAOHibernate implements SubItemDAO
{

    public SubItemDAOHibernate()
    {
    }

    public void saveSubItem(SubItem val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeSubItem(SubItem val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeSubItem(Long id)
    {
        SubItem obj = findSubItemById(id);
        getHibernateTemplate().delete(obj);
    }

    public SubItem findSubItemById(Long id)
    {
        if (id == null)
            return null;
        SubItem obj = (SubItem)getHibernateTemplate().get(com.web.value.SubItem.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.web.value.SubItem.class, id);
        else
            return obj;
    }

    public List<SubItem> findAllSubItem()
    {
        return getHibernateTemplate().find("from SubItem");
    }
    public List<Member> findLastModifiedUserList()
    {
        return new ArrayList<Member>(); // TODO
    }

    public List<Member> findCreatedUserList()
    {
        return new ArrayList<Member>(); // TODO
    }

    public List<SubMenu> findSubMenuList()
    {
        return new ArrayList<SubMenu>(); // TODO
    }

}

