package tncc.power.dao;

import tncc.power.value.ScheduleDaily;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public interface ScheduleDailyDAO extends CommonDAO 
{
    public abstract void saveScheduleDaily(ScheduleDaily val);

    public abstract void removeScheduleDaily(ScheduleDaily val);

    public abstract void removeScheduleDaily(Long id);

    public abstract ScheduleDaily findScheduleDailyById(Long id);

    public abstract List<ScheduleDaily> findAllScheduleDaily();
    public abstract List<Member> findLastModifiedUserList();
    public abstract Long[] getIdsFromReaderList(List<Reader> lst);

    public abstract List<Reader> getReaderListByIds(Long[] ids);

}

