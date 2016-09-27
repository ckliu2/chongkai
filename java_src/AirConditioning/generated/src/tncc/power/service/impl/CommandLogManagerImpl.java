package tncc.power.service.impl;

import tncc.power.service.CommandLogManager;
import tncc.power.dao.CommandLogDAO;
import tncc.power.value.CommandLog;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public class CommandLogManagerImpl extends CommonManagerImpl implements CommandLogManager
{

    public CommandLogManagerImpl()
    {
    }

    public CommandLogDAO getGenericDAO()
    {
        return (CommandLogDAO)super.getGenericDAO();
    }

    public void setGenericDAO(CommandLogDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveCommandLog(CommandLog val)
    {
        getGenericDAO().saveCommandLog(val);
    }

    public void removeCommandLog(CommandLog val)
    {
        getGenericDAO().removeCommandLog(val);
    }

    public void removeCommandLog(Long id)
    {
        getGenericDAO().removeCommandLog(id);
    }

    public CommandLog getCommandLogById(Long id)
    {
         return getGenericDAO().findCommandLogById(id);
    }

    public List<CommandLog> getCommandLogList()
    {
        return getGenericDAO().findAllCommandLog();
    }
    public List<Reader> getReaderList()
    {
        return getGenericDAO().findReaderList();
    }

}

