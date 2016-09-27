package tncc.reserve.service;

import tncc.reserve.value.ClassRoom;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public interface ClassRoomManager extends CommonManager 
{
    public abstract void saveClassRoom(ClassRoom val);

    public abstract void removeClassRoom(ClassRoom val);

    public abstract void removeClassRoom(Long id);

    public abstract ClassRoom getClassRoomById(Long id);

    public abstract List<ClassRoom> getClassRoomList();
    public abstract Long[] getIdsFromReaderList(List<Reader> lst);

    public abstract List<Reader> getReaderListByIds(Long[] ids);

}

