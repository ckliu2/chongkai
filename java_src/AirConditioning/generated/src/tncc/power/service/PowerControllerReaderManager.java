package tncc.power.service;

import tncc.power.value.PowerControllerReader;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public interface PowerControllerReaderManager extends CommonManager 
{
    public abstract void savePowerControllerReader(PowerControllerReader val);

    public abstract void removePowerControllerReader(PowerControllerReader val);

    public abstract void removePowerControllerReader(Long id);

    public abstract PowerControllerReader getPowerControllerReaderById(Long id);

    public abstract List<PowerControllerReader> getPowerControllerReaderList();
    public abstract List<PowerController> getPowerControllerList();
    public abstract List<Reader> getReaderList();
    public abstract List<ClassRoom> getClassRoomList();
    public abstract List<Course> getCourseList();
}

