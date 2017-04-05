package northwest.common.service;

import northwest.common.value.LogisticsCode;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Tue Apr 04 10:27:20 CST 2017
*/

public interface LogisticsCodeManager extends CommonManager 
{
    public abstract void saveLogisticsCode(LogisticsCode val);

    public abstract void removeLogisticsCode(LogisticsCode val);

    public abstract void removeLogisticsCode(Long id);

    public abstract LogisticsCode getLogisticsCodeById(Long id);

    public abstract List<LogisticsCode> getLogisticsCodeList();
}

