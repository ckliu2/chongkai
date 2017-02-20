package northwest.common.dao.hibernate;

import northwest.common.value.BillQA;
import northwest.common.dao.BillQADAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Feb 20 21:48:11 CST 2017
*/

public class BillQADAOHibernate extends CommonDAOHibernate implements BillQADAO
{

    public BillQADAOHibernate()
    {
    }

    public void saveBillQA(BillQA val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeBillQA(BillQA val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeBillQA(Long id)
    {
        BillQA obj = findBillQAById(id);
        getHibernateTemplate().delete(obj);
    }

    public BillQA findBillQAById(Long id)
    {
        if (id == null)
            return null;
        BillQA obj = (BillQA)getHibernateTemplate().get(northwest.common.value.BillQA.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(northwest.common.value.BillQA.class, id);
        else
            return obj;
    }

    public List<BillQA> findAllBillQA()
    {
        return getHibernateTemplate().find("from BillQA");
    }
    public List<Bill> findBillList()
    {
        return new ArrayList<Bill>(); // TODO
    }

}

