package tncc.power.dao.hibernate;

import tncc.power.value.Shutdown;
import tncc.power.dao.ShutdownDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public class ShutdownDAOHibernate extends CommonDAOHibernate implements ShutdownDAO
{

    public ShutdownDAOHibernate()
    {
    }

    public void saveShutdown(Shutdown val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeShutdown(Shutdown val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeShutdown(Long id)
    {
        Shutdown obj = findShutdownById(id);
        getHibernateTemplate().delete(obj);
    }

    public Shutdown findShutdownById(Long id)
    {
        if (id == null)
            return null;
        Shutdown obj = (Shutdown)getHibernateTemplate().get(tncc.power.value.Shutdown.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(tncc.power.value.Shutdown.class, id);
        else
            return obj;
    }

    public List<Shutdown> findAllShutdown()
    {
        return getHibernateTemplate().find("from Shutdown");
    }
    public List<Member> findCreatedUserList()
    {
        return new ArrayList<Member>(); // TODO
    }

    public List<EvenLevel> findEvenlevelList()
    {
        return new ArrayList<EvenLevel>(); // TODO
    }

    public Long[] getIdsFromReaderList(List tlist)
    {
        ArrayList<Long> al = new ArrayList<Long>();
        if (tlist != null) {
            for (int i = 0; i < tlist.size(); i++) {
                Reader t = (Reader) tlist.get(i);
                if (t != null)
                    al.add(t.getId());
            }
        }
        Long lng[] = new Long[al.size()];
        al.toArray(lng);
        
        return lng;
    }

    public List getReaderListByIds(Long[] ids)
    {
        ArrayList<Reader> al = new ArrayList<Reader>();
        if (ids != null) {
            for (int i = 0; i < ids.length; i++) {
                Reader t = (Reader) findReaderById(ids[i]);
                if (t != null)
                    al.add(t);
            }
        }
        return al;
    }
}

