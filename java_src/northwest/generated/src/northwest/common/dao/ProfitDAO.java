package northwest.common.dao;

import northwest.common.value.Profit;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Fri Mar 11 14:58:27 CST 2016
*/

public interface ProfitDAO extends CommonDAO 
{
    public abstract void saveProfit(Profit val);

    public abstract void removeProfit(Profit val);

    public abstract void removeProfit(Long id);

    public abstract Profit findProfitById(Long id);

    public abstract List<Profit> findAllProfit();
    public abstract List<Customer> findCustomerList();
    public abstract List<Member> findSalesmenList();
}

