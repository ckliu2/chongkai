package tncc.power.dao.hibernate;

import tncc.power.value.Reader;
import tncc.power.dao.ReaderDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public class ReaderDAOHibernate extends CommonDAOHibernate implements ReaderDAO
{

    public ReaderDAOHibernate()
    {
    }

    public void saveReader(Reader val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeReader(Reader val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeReader(Long id)
    {
        Reader obj = findReaderById(id);
        getHibernateTemplate().delete(obj);
    }

    public Reader findReaderById(Long id)
    {
        if (id == null)
            return null;
        Reader obj = (Reader)getHibernateTemplate().get(tncc.power.value.Reader.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(tncc.power.value.Reader.class, id);
        else
            return obj;
    }

    public List<Reader> findAllReader()
    {
        return getHibernateTemplate().find("from Reader");
    }
    public List<Member> findCreatedUserList()
    {
        return new ArrayList<Member>(); // TODO
    }

    public Long[] getIdsFromScheduleDailyList(List tlist)
    {
        ArrayList<Long> al = new ArrayList<Long>();
        if (tlist != null) {
            for (int i = 0; i < tlist.size(); i++) {
                ScheduleDaily t = (ScheduleDaily) tlist.get(i);
                if (t != null)
                    al.add(t.getId());
            }
        }
        Long lng[] = new Long[al.size()];
        al.toArray(lng);
        
        return lng;
    }

    public List getScheduleDailyListByIds(Long[] ids)
    {
        ArrayList<ScheduleDaily> al = new ArrayList<ScheduleDaily>();
        if (ids != null) {
            for (int i = 0; i < ids.length; i++) {
                ScheduleDaily t = (ScheduleDaily) findScheduleDailyById(ids[i]);
                if (t != null)
                    al.add(t);
            }
        }
        return al;
    }
}

