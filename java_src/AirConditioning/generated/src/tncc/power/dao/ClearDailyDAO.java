package tncc.power.dao;

import tncc.power.value.ClearDaily;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public interface ClearDailyDAO extends CommonDAO 
{
    public abstract void saveClearDaily(ClearDaily val);

    public abstract void removeClearDaily(ClearDaily val);

    public abstract void removeClearDaily(Long id);

    public abstract ClearDaily findClearDailyById(Long id);

    public abstract List<ClearDaily> findAllClearDaily();
    public abstract List<Reader> findReaderList();
    public abstract List<PowerController> findPowercontrollerList();
}

