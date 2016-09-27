package tncc.power.dao.hibernate;

import tncc.power.value.ScheduleDaily;
import tncc.power.dao.ScheduleDailyDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public class ScheduleDailyDAOHibernate extends CommonDAOHibernate implements ScheduleDailyDAO
{

    public ScheduleDailyDAOHibernate()
    {
    }

    public void saveScheduleDaily(ScheduleDaily val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeScheduleDaily(ScheduleDaily val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeScheduleDaily(Long id)
    {
        ScheduleDaily obj = findScheduleDailyById(id);
        getHibernateTemplate().delete(obj);
    }

    public ScheduleDaily findScheduleDailyById(Long id)
    {
        if (id == null)
            return null;
        ScheduleDaily obj = (ScheduleDaily)getHibernateTemplate().get(tncc.power.value.ScheduleDaily.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(tncc.power.value.ScheduleDaily.class, id);
        else
            return obj;
    }

    public List<ScheduleDaily> findAllScheduleDaily()
    {
        return getHibernateTemplate().find("from ScheduleDaily");
    }
    public List<Member> findLastModifiedUserList()
    {
        return new ArrayList<Member>(); // TODO
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

