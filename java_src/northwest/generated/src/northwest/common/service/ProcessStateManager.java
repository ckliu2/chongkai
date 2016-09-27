package northwest.common.service;

import northwest.common.value.ProcessState;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Mar 10 17:34:04 CST 2014
*/

public interface ProcessStateManager extends CommonManager 
{
    public abstract void saveProcessState(ProcessState val);

    public abstract void removeProcessState(ProcessState val);

    public abstract void removeProcessState(Long id);

    public abstract ProcessState getProcessStateById(Long id);

    public abstract List<ProcessState> getProcessStateList();
    public abstract List<Bill> getBillList();
}

