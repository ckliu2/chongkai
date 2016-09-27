package org.zion.dao;

import org.zion.value.Message;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Dec 08 14:37:53 CST 2014
*/

public interface MessageDAO extends CommonDAO 
{
    public abstract void saveMessage(Message val);

    public abstract void removeMessage(Message val);

    public abstract void removeMessage(Long id);

    public abstract Message findMessageById(Long id);

    public abstract List<Message> findAllMessage();
}

