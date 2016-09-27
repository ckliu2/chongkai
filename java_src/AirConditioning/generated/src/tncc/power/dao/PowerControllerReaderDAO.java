package tncc.power.dao;

import tncc.power.value.PowerControllerReader;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public interface PowerControllerReaderDAO extends CommonDAO 
{
    public abstract void savePowerControllerReader(PowerControllerReader val);

    public abstract void removePowerControllerReader(PowerControllerReader val);

    public abstract void removePowerControllerReader(Long id);

    public abstract PowerControllerReader findPowerControllerReaderById(Long id);

    public abstract List<PowerControllerReader> findAllPowerControllerReader();
    public abstract List<PowerController> findPowerControllerList();
    public abstract List<Reader> findReaderList();
    public abstract List<ClassRoom> findClassRoomList();
    public abstract List<Course> findCourseList();
}

