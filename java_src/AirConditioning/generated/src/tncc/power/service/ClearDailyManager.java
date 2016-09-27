package tncc.power.service;

import tncc.power.value.ClearDaily;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public interface ClearDailyManager extends CommonManager 
{
    public abstract void saveClearDaily(ClearDaily val);

    public abstract void removeClearDaily(ClearDaily val);

    public abstract void removeClearDaily(Long id);

    public abstract ClearDaily getClearDailyById(Long id);

    public abstract List<ClearDaily> getClearDailyList();
    public abstract List<Reader> getReaderList();
    public abstract List<PowerController> getPowercontrollerList();
}

