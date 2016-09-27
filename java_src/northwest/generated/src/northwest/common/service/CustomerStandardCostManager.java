package northwest.common.service;

import northwest.common.value.CustomerStandardCost;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Fri Mar 11 14:58:27 CST 2016
*/

public interface CustomerStandardCostManager extends CommonManager 
{
    public abstract void saveCustomerStandardCost(CustomerStandardCost val);

    public abstract void removeCustomerStandardCost(CustomerStandardCost val);

    public abstract void removeCustomerStandardCost(Long id);

    public abstract CustomerStandardCost getCustomerStandardCostById(Long id);

    public abstract List<CustomerStandardCost> getCustomerStandardCostList();
    public abstract List<Customer> getCustomerList();
    public abstract List<Product> getProductList();
}

