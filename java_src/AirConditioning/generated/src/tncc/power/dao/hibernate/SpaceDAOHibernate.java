package tncc.power.dao.hibernate;

import tncc.power.value.Space;
import tncc.power.dao.SpaceDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public class SpaceDAOHibernate extends CommonDAOHibernate implements SpaceDAO
{

    public SpaceDAOHibernate()
    {
    }

    public void saveSpace(Space val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeSpace(Space val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeSpace(Long id)
    {
        Space obj = findSpaceById(id);
        getHibernateTemplate().delete(obj);
    }

    public Space findSpaceById(Long id)
    {
        if (id == null)
            return null;
        Space obj = (Space)getHibernateTemplate().get(tncc.power.value.Space.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(tncc.power.value.Space.class, id);
        else
            return obj;
    }

    public List<Space> findAllSpace()
    {
        return getHibernateTemplate().find("from Space");
    }
    public List<Member> findCreatedUserList()
    {
        return new ArrayList<Member>(); // TODO
    }

    public List<Building> findBuildingList()
    {
        return new ArrayList<Building>(); // TODO
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

