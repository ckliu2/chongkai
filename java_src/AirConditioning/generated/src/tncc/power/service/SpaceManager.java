package tncc.power.service;

import tncc.power.value.Space;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public interface SpaceManager extends CommonManager 
{
    public abstract void saveSpace(Space val);

    public abstract void removeSpace(Space val);

    public abstract void removeSpace(Long id);

    public abstract Space getSpaceById(Long id);

    public abstract List<Space> getSpaceList();
    public abstract List<Member> getCreatedUserList();
    public abstract List<Building> getBuildingList();
    public abstract Long[] getIdsFromReaderList(List<Reader> lst);

    public abstract List<Reader> getReaderListByIds(Long[] ids);

}

