package tncc.power.dao;

import tncc.power.value.Space;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public interface SpaceDAO extends CommonDAO 
{
    public abstract void saveSpace(Space val);

    public abstract void removeSpace(Space val);

    public abstract void removeSpace(Long id);

    public abstract Space findSpaceById(Long id);

    public abstract List<Space> findAllSpace();
    public abstract List<Member> findCreatedUserList();
    public abstract List<Building> findBuildingList();
    public abstract Long[] getIdsFromReaderList(List<Reader> lst);

    public abstract List<Reader> getReaderListByIds(Long[] ids);

}

