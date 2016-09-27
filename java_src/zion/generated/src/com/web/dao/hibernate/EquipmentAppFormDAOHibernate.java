package com.web.dao.hibernate;

import com.web.value.EquipmentAppForm;
import com.web.dao.EquipmentAppFormDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
*/

public class EquipmentAppFormDAOHibernate extends CommonDAOHibernate implements EquipmentAppFormDAO
{

    public EquipmentAppFormDAOHibernate()
    {
    }

    public void saveEquipmentAppForm(EquipmentAppForm val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeEquipmentAppForm(EquipmentAppForm val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeEquipmentAppForm(Long id)
    {
        EquipmentAppForm obj = findEquipmentAppFormById(id);
        getHibernateTemplate().delete(obj);
    }

    public EquipmentAppForm findEquipmentAppFormById(Long id)
    {
        if (id == null)
            return null;
        EquipmentAppForm obj = (EquipmentAppForm)getHibernateTemplate().get(com.web.value.EquipmentAppForm.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.web.value.EquipmentAppForm.class, id);
        else
            return obj;
    }

    public List<EquipmentAppForm> findAllEquipmentAppForm()
    {
        return getHibernateTemplate().find("from EquipmentAppForm");
    }
    public List<Room> findRoomList()
    {
        return new ArrayList<Room>(); // TODO
    }

    public List<Clock> findApplyBeginClockList()
    {
        return new ArrayList<Clock>(); // TODO
    }

    public List<Clock> findApplyEndClockList()
    {
        return new ArrayList<Clock>(); // TODO
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

