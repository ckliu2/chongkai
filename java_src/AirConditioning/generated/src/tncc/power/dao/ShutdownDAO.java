package tncc.power.dao;

import tncc.power.value.Shutdown;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public interface ShutdownDAO extends CommonDAO 
{
    public abstract void saveShutdown(Shutdown val);

    public abstract void removeShutdown(Shutdown val);

    public abstract void removeShutdown(Long id);

    public abstract Shutdown findShutdownById(Long id);

    public abstract List<Shutdown> findAllShutdown();
    public abstract List<Member> findCreatedUserList();
    public abstract List<EvenLevel> findEvenlevelList();
    public abstract Long[] getIdsFromReaderList(List<Reader> lst);

    public abstract List<Reader> getReaderListByIds(Long[] ids);

}

