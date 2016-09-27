package tncc.power.dao.hibernate;

import tncc.power.value.ClearDaily;
import tncc.power.dao.ClearDailyDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public class ClearDailyDAOHibernate extends CommonDAOHibernate implements ClearDailyDAO
{

    public ClearDailyDAOHibernate()
    {
    }

    public void saveClearDaily(ClearDaily val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeClearDaily(ClearDaily val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeClearDaily(Long id)
    {
        ClearDaily obj = findClearDailyById(id);
        getHibernateTemplate().delete(obj);
    }

    public ClearDaily findClearDailyById(Long id)
    {
        if (id == null)
            return null;
        ClearDaily obj = (ClearDaily)getHibernateTemplate().get(tncc.power.value.ClearDaily.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(tncc.power.value.ClearDaily.class, id);
        else
            return obj;
    }

    public List<ClearDaily> findAllClearDaily()
    {
        return getHibernateTemplate().find("from ClearDaily");
    }
    public List<Reader> findReaderList()
    {
        return new ArrayList<Reader>(); // TODO
    }

    public List<PowerController> findPowercontrollerList()
    {
        return new ArrayList<PowerController>(); // TODO
    }

}

