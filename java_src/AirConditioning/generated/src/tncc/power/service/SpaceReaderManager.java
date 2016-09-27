package tncc.power.service;

import tncc.power.value.SpaceReader;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public interface SpaceReaderManager extends CommonManager 
{
    public abstract void saveSpaceReader(SpaceReader val);

    public abstract void removeSpaceReader(SpaceReader val);

    public abstract void removeSpaceReader(Long id);

    public abstract SpaceReader getSpaceReaderById(Long id);

    public abstract List<SpaceReader> getSpaceReaderList();
    public abstract List<Space> getSpaceList();
    public abstract List<Reader> getReaderList();
    public abstract List<PowerController> getPowercontrollerList();
}

