package tncc.reserve.service.impl;

import tncc.reserve.service.ClassRoomManager;
import tncc.reserve.dao.ClassRoomDAO;
import tncc.reserve.value.ClassRoom;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public class ClassRoomManagerImpl extends CommonManagerImpl implements ClassRoomManager
{

    public ClassRoomManagerImpl()
    {
    }

    public ClassRoomDAO getGenericDAO()
    {
        return (ClassRoomDAO)super.getGenericDAO();
    }

    public void setGenericDAO(ClassRoomDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveClassRoom(ClassRoom val)
    {
        getGenericDAO().saveClassRoom(val);
    }

    public void removeClassRoom(ClassRoom val)
    {
        getGenericDAO().removeClassRoom(val);
    }

    public void removeClassRoom(Long id)
    {
        getGenericDAO().removeClassRoom(id);
    }

    public ClassRoom getClassRoomById(Long id)
    {
         return getGenericDAO().findClassRoomById(id);
    }

    public List<ClassRoom> getClassRoomList()
    {
        return getGenericDAO().findAllClassRoom();
    }
    public Long[] getIdsFromReaderList(List<Reader> lst)
    {
        return getGenericDAO().getIdsFromReaderList(lst);
    }

    public List<Reader> getReaderListByIds(Long[] ids)
    {
        return getGenericDAO().getReaderListByIds(ids);
    }

}

