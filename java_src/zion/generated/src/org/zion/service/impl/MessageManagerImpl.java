package org.zion.service.impl;

import org.zion.service.MessageManager;
import org.zion.dao.MessageDAO;
import org.zion.value.Message;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Dec 08 14:37:53 CST 2014
*/

public class MessageManagerImpl extends CommonManagerImpl implements MessageManager
{

    public MessageManagerImpl()
    {
    }

    public MessageDAO getGenericDAO()
    {
        return (MessageDAO)super.getGenericDAO();
    }

    public void setGenericDAO(MessageDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveMessage(Message val)
    {
        getGenericDAO().saveMessage(val);
    }

    public void removeMessage(Message val)
    {
        getGenericDAO().removeMessage(val);
    }

    public void removeMessage(Long id)
    {
        getGenericDAO().removeMessage(id);
    }

    public Message getMessageById(Long id)
    {
         return getGenericDAO().findMessageById(id);
    }

    public List<Message> getMessageList()
    {
        return getGenericDAO().findAllMessage();
    }
}

