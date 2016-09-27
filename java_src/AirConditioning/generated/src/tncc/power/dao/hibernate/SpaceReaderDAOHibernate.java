package tncc.power.dao.hibernate;

import tncc.power.value.SpaceReader;
import tncc.power.dao.SpaceReaderDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public class SpaceReaderDAOHibernate extends CommonDAOHibernate implements SpaceReaderDAO
{

    public SpaceReaderDAOHibernate()
    {
    }

    public void saveSpaceReader(SpaceReader val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeSpaceReader(SpaceReader val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeSpaceReader(Long id)
    {
        SpaceReader obj = findSpaceReaderById(id);
        getHibernateTemplate().delete(obj);
    }

    public SpaceReader findSpaceReaderById(Long id)
    {
        if (id == null)
            return null;
        SpaceReader obj = (SpaceReader)getHibernateTemplate().get(tncc.power.value.SpaceReader.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(tncc.power.value.SpaceReader.class, id);
        else
            return obj;
    }

    public List<SpaceReader> findAllSpaceReader()
    {
        return getHibernateTemplate().find("from SpaceReader");
    }
    public List<Space> findSpaceList()
    {
        return new ArrayList<Space>(); // TODO
    }

    public List<Reader> findReaderList()
    {
        return new ArrayList<Reader>(); // TODO
    }

    public List<PowerController> findPowercontrollerList()
    {
        return new ArrayList<PowerController>(); // TODO
    }

}

