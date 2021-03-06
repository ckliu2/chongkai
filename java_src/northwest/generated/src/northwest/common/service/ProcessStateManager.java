package northwest.common.service;

import northwest.common.value.ProcessState;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Tue Apr 04 10:27:20 CST 2017
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

