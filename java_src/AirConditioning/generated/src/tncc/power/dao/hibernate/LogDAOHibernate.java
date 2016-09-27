package tncc.power.dao.hibernate;

import tncc.power.value.Log;
import tncc.power.dao.LogDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public class LogDAOHibernate extends CommonDAOHibernate implements LogDAO
{

    public LogDAOHibernate()
    {
    }

    public void saveLog(Log val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeLog(Log val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeLog(Long id)
    {
        Log obj = findLogById(id);
        getHibernateTemplate().delete(obj);
    }

    public Log findLogById(Long id)
    {
        if (id == null)
            return null;
        Log obj = (Log)getHibernateTemplate().get(tncc.power.value.Log.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(tncc.power.value.Log.class, id);
        else
            return obj;
    }

    public List<Log> findAllLog()
    {
        return getHibernateTemplate().find("from Log");
    }
    public List<ScheduleDaily> findScheduleDailyList()
    {
        return new ArrayList<ScheduleDaily>(); // TODO
    }

    public List<Reader> findReaderList()
    {
        return new ArrayList<Reader>(); // TODO
    }

    public List<Member> findCreatedUserList()
    {
        return new ArrayList<Member>(); // TODO
    }

}

