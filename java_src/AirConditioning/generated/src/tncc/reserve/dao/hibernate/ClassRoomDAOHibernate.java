package tncc.reserve.dao.hibernate;

import tncc.reserve.value.ClassRoom;
import tncc.reserve.dao.ClassRoomDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public class ClassRoomDAOHibernate extends CommonDAOHibernate implements ClassRoomDAO
{

    public ClassRoomDAOHibernate()
    {
    }

    public void saveClassRoom(ClassRoom val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeClassRoom(ClassRoom val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeClassRoom(Long id)
    {
        ClassRoom obj = findClassRoomById(id);
        getHibernateTemplate().delete(obj);
    }

    public ClassRoom findClassRoomById(Long id)
    {
        if (id == null)
            return null;
        ClassRoom obj = (ClassRoom)getHibernateTemplate().get(tncc.reserve.value.ClassRoom.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(tncc.reserve.value.ClassRoom.class, id);
        else
            return obj;
    }

    public List<ClassRoom> findAllClassRoom()
    {
        return getHibernateTemplate().find("from ClassRoom");
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

