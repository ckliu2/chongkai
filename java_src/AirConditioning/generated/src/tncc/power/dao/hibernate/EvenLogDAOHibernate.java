package tncc.power.dao.hibernate;

import tncc.power.value.EvenLog;
import tncc.power.dao.EvenLogDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public class EvenLogDAOHibernate extends CommonDAOHibernate implements EvenLogDAO
{

    public EvenLogDAOHibernate()
    {
    }

    public void saveEvenLog(EvenLog val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeEvenLog(EvenLog val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeEvenLog(Long id)
    {
        EvenLog obj = findEvenLogById(id);
        getHibernateTemplate().delete(obj);
    }

    public EvenLog findEvenLogById(Long id)
    {
        if (id == null)
            return null;
        EvenLog obj = (EvenLog)getHibernateTemplate().get(tncc.power.value.EvenLog.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(tncc.power.value.EvenLog.class, id);
        else
            return obj;
    }

    public List<EvenLog> findAllEvenLog()
    {
        return getHibernateTemplate().find("from EvenLog");
    }
    public List<Shutdown> findShutdownprcList()
    {
        return new ArrayList<Shutdown>(); // TODO
    }

}

