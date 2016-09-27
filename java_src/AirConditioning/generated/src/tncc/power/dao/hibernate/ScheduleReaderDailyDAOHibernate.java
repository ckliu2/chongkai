package tncc.power.dao.hibernate;

import tncc.power.value.ScheduleReaderDaily;
import tncc.power.dao.ScheduleReaderDailyDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public class ScheduleReaderDailyDAOHibernate extends CommonDAOHibernate implements ScheduleReaderDailyDAO
{

    public ScheduleReaderDailyDAOHibernate()
    {
    }

    public void saveScheduleReaderDaily(ScheduleReaderDaily val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeScheduleReaderDaily(ScheduleReaderDaily val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeScheduleReaderDaily(Long id)
    {
        ScheduleReaderDaily obj = findScheduleReaderDailyById(id);
        getHibernateTemplate().delete(obj);
    }

    public ScheduleReaderDaily findScheduleReaderDailyById(Long id)
    {
        if (id == null)
            return null;
        ScheduleReaderDaily obj = (ScheduleReaderDaily)getHibernateTemplate().get(tncc.power.value.ScheduleReaderDaily.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(tncc.power.value.ScheduleReaderDaily.class, id);
        else
            return obj;
    }

    public List<ScheduleReaderDaily> findAllScheduleReaderDaily()
    {
        return getHibernateTemplate().find("from ScheduleReaderDaily");
    }
    public List<Reader> findReaderList()
    {
        return new ArrayList<Reader>(); // TODO
    }

    public List<ScheduleDaily> findScheduleDailyList()
    {
        return new ArrayList<ScheduleDaily>(); // TODO
    }

    public List<PowerController> findPowerControllerList()
    {
        return new ArrayList<PowerController>(); // TODO
    }

}

