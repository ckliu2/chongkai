package com.web.dao.hibernate;

import com.web.value.Menu;
import com.web.dao.MenuDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
*/

public class MenuDAOHibernate extends CommonDAOHibernate implements MenuDAO
{

    public MenuDAOHibernate()
    {
    }

    public void saveMenu(Menu val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeMenu(Menu val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeMenu(Long id)
    {
        Menu obj = findMenuById(id);
        getHibernateTemplate().delete(obj);
    }

    public Menu findMenuById(Long id)
    {
        if (id == null)
            return null;
        Menu obj = (Menu)getHibernateTemplate().get(com.web.value.Menu.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.web.value.Menu.class, id);
        else
            return obj;
    }

    public List<Menu> findAllMenu()
    {
        return getHibernateTemplate().find("from Menu");
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

