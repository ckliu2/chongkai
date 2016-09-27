package tncc.power.service;

import tncc.power.value.Reader;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public interface ReaderManager extends CommonManager 
{
    public abstract void saveReader(Reader val);

    public abstract void removeReader(Reader val);

    public abstract void removeReader(Long id);

    public abstract Reader getReaderById(Long id);

    public abstract List<Reader> getReaderList();
    public abstract List<Member> getCreatedUserList();
    public abstract Long[] getIdsFromScheduleDailyList(List<ScheduleDaily> lst);

    public abstract List<ScheduleDaily> getScheduleDailyListByIds(Long[] ids);

}

