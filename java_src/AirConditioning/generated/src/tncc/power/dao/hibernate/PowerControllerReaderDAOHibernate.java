package tncc.power.dao.hibernate;

import tncc.power.value.PowerControllerReader;
import tncc.power.dao.PowerControllerReaderDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public class PowerControllerReaderDAOHibernate extends CommonDAOHibernate implements PowerControllerReaderDAO
{

    public PowerControllerReaderDAOHibernate()
    {
    }

    public void savePowerControllerReader(PowerControllerReader val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removePowerControllerReader(PowerControllerReader val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removePowerControllerReader(Long id)
    {
        PowerControllerReader obj = findPowerControllerReaderById(id);
        getHibernateTemplate().delete(obj);
    }

    public PowerControllerReader findPowerControllerReaderById(Long id)
    {
        if (id == null)
            return null;
        PowerControllerReader obj = (PowerControllerReader)getHibernateTemplate().get(tncc.power.value.PowerControllerReader.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(tncc.power.value.PowerControllerReader.class, id);
        else
            return obj;
    }

    public List<PowerControllerReader> findAllPowerControllerReader()
    {
        return getHibernateTemplate().find("from PowerControllerReader");
    }
    public List<PowerController> findPowerControllerList()
    {
        return new ArrayList<PowerController>(); // TODO
    }

    public List<Reader> findReaderList()
    {
        return new ArrayList<Reader>(); // TODO
    }

    public List<ClassRoom> findClassRoomList()
    {
        return new ArrayList<ClassRoom>(); // TODO
    }

    public List<Course> findCourseList()
    {
        return new ArrayList<Course>(); // TODO
    }

}

