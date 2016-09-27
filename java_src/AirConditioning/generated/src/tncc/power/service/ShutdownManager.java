package tncc.power.service;

import tncc.power.value.Shutdown;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public interface ShutdownManager extends CommonManager 
{
    public abstract void saveShutdown(Shutdown val);

    public abstract void removeShutdown(Shutdown val);

    public abstract void removeShutdown(Long id);

    public abstract Shutdown getShutdownById(Long id);

    public abstract List<Shutdown> getShutdownList();
    public abstract List<Member> getCreatedUserList();
    public abstract List<EvenLevel> getEvenlevelList();
    public abstract Long[] getIdsFromReaderList(List<Reader> lst);

    public abstract List<Reader> getReaderListByIds(Long[] ids);

}

