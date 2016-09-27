package tncc.power.dao.hibernate;

import tncc.power.value.CommandLog;
import tncc.power.dao.CommandLogDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public class CommandLogDAOHibernate extends CommonDAOHibernate implements CommandLogDAO
{

    public CommandLogDAOHibernate()
    {
    }

    public void saveCommandLog(CommandLog val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeCommandLog(CommandLog val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeCommandLog(Long id)
    {
        CommandLog obj = findCommandLogById(id);
        getHibernateTemplate().delete(obj);
    }

    public CommandLog findCommandLogById(Long id)
    {
        if (id == null)
            return null;
        CommandLog obj = (CommandLog)getHibernateTemplate().get(tncc.power.value.CommandLog.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(tncc.power.value.CommandLog.class, id);
        else
            return obj;
    }

    public List<CommandLog> findAllCommandLog()
    {
        return getHibernateTemplate().find("from CommandLog");
    }
    public List<Reader> findReaderList()
    {
        return new ArrayList<Reader>(); // TODO
    }

}

