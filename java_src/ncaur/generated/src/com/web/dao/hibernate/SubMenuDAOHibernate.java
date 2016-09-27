package com.web.dao.hibernate;

import com.web.value.SubMenu;
import com.web.dao.SubMenuDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public class SubMenuDAOHibernate extends CommonDAOHibernate implements SubMenuDAO
{

    public SubMenuDAOHibernate()
    {
    }

    public void saveSubMenu(SubMenu val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeSubMenu(SubMenu val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeSubMenu(Long id)
    {
        SubMenu obj = findSubMenuById(id);
        getHibernateTemplate().delete(obj);
    }

    public SubMenu findSubMenuById(Long id)
    {
        if (id == null)
            return null;
        SubMenu obj = (SubMenu)getHibernateTemplate().get(com.web.value.SubMenu.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.web.value.SubMenu.class, id);
        else
            return obj;
    }

    public List<SubMenu> findAllSubMenu()
    {
        return getHibernateTemplate().find("from SubMenu");
    }
    public List<Menu> findMenuList()
    {
        return new ArrayList<Menu>(); // TODO
    }

    public List<Member> findLastModifiedUserList()
    {
        return new ArrayList<Member>(); // TODO
    }

    public List<Member> findCreatedUserList()
    {
        return new ArrayList<Member>(); // TODO
    }

}

