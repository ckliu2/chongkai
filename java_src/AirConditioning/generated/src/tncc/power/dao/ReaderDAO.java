package tncc.power.dao;

import tncc.power.value.Reader;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public interface ReaderDAO extends CommonDAO 
{
    public abstract void saveReader(Reader val);

    public abstract void removeReader(Reader val);

    public abstract void removeReader(Long id);

    public abstract Reader findReaderById(Long id);

    public abstract List<Reader> findAllReader();
    public abstract List<Member> findCreatedUserList();
    public abstract Long[] getIdsFromScheduleDailyList(List<ScheduleDaily> lst);

    public abstract List<ScheduleDaily> getScheduleDailyListByIds(Long[] ids);

}

