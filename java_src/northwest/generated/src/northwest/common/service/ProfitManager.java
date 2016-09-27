package northwest.common.service;

import northwest.common.value.Profit;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Fri Mar 11 14:58:27 CST 2016
*/

public interface ProfitManager extends CommonManager 
{
    public abstract void saveProfit(Profit val);

    public abstract void removeProfit(Profit val);

    public abstract void removeProfit(Long id);

    public abstract Profit getProfitById(Long id);

    public abstract List<Profit> getProfitList();
    public abstract List<Customer> getCustomerList();
    public abstract List<Member> getSalesmenList();
}
