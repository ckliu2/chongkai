package com.web.dao.hibernate;

import com.web.value.EquipmentBorQuantity;
import com.web.dao.EquipmentBorQuantityDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
*/

public class EquipmentBorQuantityDAOHibernate extends CommonDAOHibernate implements EquipmentBorQuantityDAO
{

    public EquipmentBorQuantityDAOHibernate()
    {
    }

    public void saveEquipmentBorQuantity(EquipmentBorQuantity val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeEquipmentBorQuantity(EquipmentBorQuantity val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeEquipmentBorQuantity(Long id)
    {
        EquipmentBorQuantity obj = findEquipmentBorQuantityById(id);
        getHibernateTemplate().delete(obj);
    }

    public EquipmentBorQuantity findEquipmentBorQuantityById(Long id)
    {
        if (id == null)
            return null;
        EquipmentBorQuantity obj = (EquipmentBorQuantity)getHibernateTemplate().get(com.web.value.EquipmentBorQuantity.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.web.value.EquipmentBorQuantity.class, id);
        else
            return obj;
    }

    public List<EquipmentBorQuantity> findAllEquipmentBorQuantity()
    {
        return getHibernateTemplate().find("from EquipmentBorQuantity");
    }
    public List<Equipment> findEquipmentList()
    {
        return new ArrayList<Equipment>(); // TODO
    }

}

