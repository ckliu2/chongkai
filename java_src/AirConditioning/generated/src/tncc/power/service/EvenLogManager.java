package tncc.power.service;

import tncc.power.value.EvenLog;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public interface EvenLogManager extends CommonManager 
{
    public abstract void saveEvenLog(EvenLog val);

    public abstract void removeEvenLog(EvenLog val);

    public abstract void removeEvenLog(Long id);

    public abstract EvenLog getEvenLogById(Long id);

    public abstract List<EvenLog> getEvenLogList();
    public abstract List<Shutdown> getShutdownprcList();
}

