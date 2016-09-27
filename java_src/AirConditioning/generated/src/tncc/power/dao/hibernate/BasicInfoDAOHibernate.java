package tncc.power.dao.hibernate;

import tncc.power.value.BasicInfo;
import tncc.power.dao.BasicInfoDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public class BasicInfoDAOHibernate extends CommonDAOHibernate implements BasicInfoDAO
{

    public BasicInfoDAOHibernate()
    {
    }

    public void saveBasicInfo(BasicInfo val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeBasicInfo(BasicInfo val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeBasicInfo(Long id)
    {
        BasicInfo obj = findBasicInfoById(id);
        getHibernateTemplate().delete(obj);
    }

    public BasicInfo findBasicInfoById(Long id)
    {
        if (id == null)
            return null;
        BasicInfo obj = (BasicInfo)getHibernateTemplate().get(tncc.power.value.BasicInfo.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(tncc.power.value.BasicInfo.class, id);
        else
            return obj;
    }

    public List<BasicInfo> findAllBasicInfo()
    {
        return getHibernateTemplate().find("from BasicInfo");
    }
    public List<Member> findCreatedUserList()
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

