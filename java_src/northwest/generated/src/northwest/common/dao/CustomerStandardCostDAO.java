package northwest.common.dao;

import northwest.common.value.CustomerStandardCost;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Fri Mar 11 14:58:27 CST 2016
*/

public interface CustomerStandardCostDAO extends CommonDAO 
{
    public abstract void saveCustomerStandardCost(CustomerStandardCost val);

    public abstract void removeCustomerStandardCost(CustomerStandardCost val);

    public abstract void removeCustomerStandardCost(Long id);

    public abstract CustomerStandardCost findCustomerStandardCostById(Long id);

    public abstract List<CustomerStandardCost> findAllCustomerStandardCost();
    public abstract List<Customer> findCustomerList();
    public abstract List<Product> findProductList();
}

