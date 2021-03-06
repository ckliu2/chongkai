package northwest.common.dao;

import northwest.common.value.Logistics;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Tue Apr 04 10:27:20 CST 2017
*/

public interface LogisticsDAO extends CommonDAO 
{
    public abstract void saveLogistics(Logistics val);

    public abstract void removeLogistics(Logistics val);

    public abstract void removeLogistics(Long id);

    public abstract Logistics findLogisticsById(Long id);

    public abstract List<Logistics> findAllLogistics();
    public abstract List<Bill> findBillList();
    public abstract List<Member> findMemberList();
}

