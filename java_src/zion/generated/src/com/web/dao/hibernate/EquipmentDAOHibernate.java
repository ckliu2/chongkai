package com.web.dao.hibernate;

import com.web.value.Equipment;
import com.web.dao.EquipmentDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
*/

public class EquipmentDAOHibernate extends CommonDAOHibernate implements EquipmentDAO
{

    public EquipmentDAOHibernate()
    {
    }

    public void saveEquipment(Equipment val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeEquipment(Equipment val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeEquipment(Long id)
    {
        Equipment obj = findEquipmentById(id);
        getHibernateTemplate().delete(obj);
    }

    public Equipment findEquipmentById(Long id)
    {
        if (id == null)
            return null;
        Equipment obj = (Equipment)getHibernateTemplate().get(com.web.value.Equipment.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.web.value.Equipment.class, id);
        else
            return obj;
    }

    public List<Equipment> findAllEquipment()
    {
        return getHibernateTemplate().find("from Equipment");
    }
    public List<Department> findDepartmentList()
    {
        return new ArrayList<Department>(); // TODO
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

