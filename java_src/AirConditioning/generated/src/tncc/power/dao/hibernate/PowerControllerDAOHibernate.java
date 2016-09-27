package tncc.power.dao.hibernate;

import tncc.power.value.PowerController;
import tncc.power.dao.PowerControllerDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public class PowerControllerDAOHibernate extends CommonDAOHibernate implements PowerControllerDAO
{

    public PowerControllerDAOHibernate()
    {
    }

    public void savePowerController(PowerController val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removePowerController(PowerController val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removePowerController(Long id)
    {
        PowerController obj = findPowerControllerById(id);
        getHibernateTemplate().delete(obj);
    }

    public PowerController findPowerControllerById(Long id)
    {
        if (id == null)
            return null;
        PowerController obj = (PowerController)getHibernateTemplate().get(tncc.power.value.PowerController.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(tncc.power.value.PowerController.class, id);
        else
            return obj;
    }

    public List<PowerController> findAllPowerController()
    {
        return getHibernateTemplate().find("from PowerController");
    }
    public List<Building> findBuildingList()
    {
        return new ArrayList<Building>(); // TODO
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

