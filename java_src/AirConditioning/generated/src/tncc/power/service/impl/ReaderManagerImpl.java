package tncc.power.service.impl;

import tncc.power.service.ReaderManager;
import tncc.power.dao.ReaderDAO;
import tncc.power.value.Reader;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public class ReaderManagerImpl extends CommonManagerImpl implements ReaderManager
{

    public ReaderManagerImpl()
    {
    }

    public ReaderDAO getGenericDAO()
    {
        return (ReaderDAO)super.getGenericDAO();
    }

    public void setGenericDAO(ReaderDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveReader(Reader val)
    {
        getGenericDAO().saveReader(val);
    }

    public void removeReader(Reader val)
    {
        getGenericDAO().removeReader(val);
    }

    public void removeReader(Long id)
    {
        getGenericDAO().removeReader(id);
    }

    public Reader getReaderById(Long id)
    {
         return getGenericDAO().findReaderById(id);
    }

    public List<Reader> getReaderList()
    {
        return getGenericDAO().findAllReader();
    }
    public List<Member> getCreatedUserList()
    {
        return getGenericDAO().findCreatedUserList();
    }

    public Long[] getIdsFromScheduleDailyList(List<ScheduleDaily> lst)
    {
        return getGenericDAO().getIdsFromScheduleDailyList(lst);
    }

    public List<ScheduleDaily> getScheduleDailyListByIds(Long[] ids)
    {
        return getGenericDAO().getScheduleDailyListByIds(ids);
    }

}

