package org.zion.dao.hibernate;

import org.zion.value.Message;
import org.zion.dao.MessageDAO;
import java.util.*;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Dec 08 14:37:53 CST 2014
*/

public class MessageDAOHibernate extends CommonDAOHibernate implements MessageDAO
{

    public MessageDAOHibernate()
    {
    }

    public void saveMessage(Message val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeMessage(Message val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeMessage(Long id)
    {
        Message obj = findMessageById(id);
        getHibernateTemplate().delete(obj);
    }

    public Message findMessageById(Long id)
    {
        if (id == null)
            return null;
        Message obj = (Message)getHibernateTemplate().get(org.zion.value.Message.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(org.zion.value.Message.class, id);
        else
            return obj;
    }

    public List<Message> findAllMessage()
    {
        return getHibernateTemplate().find("from Message");
    }
}

