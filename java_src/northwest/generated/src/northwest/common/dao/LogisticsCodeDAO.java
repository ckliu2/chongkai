package northwest.common.dao;

import northwest.common.value.LogisticsCode;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Tue Apr 04 10:27:20 CST 2017
*/

public interface LogisticsCodeDAO extends CommonDAO 
{
    public abstract void saveLogisticsCode(LogisticsCode val);

    public abstract void removeLogisticsCode(LogisticsCode val);

    public abstract void removeLogisticsCode(Long id);

    public abstract LogisticsCode findLogisticsCodeById(Long id);

    public abstract List<LogisticsCode> findAllLogisticsCode();
}

