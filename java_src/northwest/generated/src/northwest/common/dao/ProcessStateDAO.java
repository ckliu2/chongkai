package northwest.common.dao;

import northwest.common.value.ProcessState;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Mar 10 17:34:04 CST 2014
*/

public interface ProcessStateDAO extends CommonDAO 
{
    public abstract void saveProcessState(ProcessState val);

    public abstract void removeProcessState(ProcessState val);

    public abstract void removeProcessState(Long id);

    public abstract ProcessState findProcessStateById(Long id);

    public abstract List<ProcessState> findAllProcessState();
    public abstract List<Bill> findBillList();
}
