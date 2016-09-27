package tncc.power.dao;

import tncc.power.value.SpaceReader;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public interface SpaceReaderDAO extends CommonDAO 
{
    public abstract void saveSpaceReader(SpaceReader val);

    public abstract void removeSpaceReader(SpaceReader val);

    public abstract void removeSpaceReader(Long id);

    public abstract SpaceReader findSpaceReaderById(Long id);

    public abstract List<SpaceReader> findAllSpaceReader();
    public abstract List<Space> findSpaceList();
    public abstract List<Reader> findReaderList();
    public abstract List<PowerController> findPowercontrollerList();
}

