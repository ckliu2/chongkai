package northwest.common.service;

import northwest.common.value.Customer;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Sat Feb 25 16:16:34 CST 2017
*/

public interface CustomerManager extends CommonManager 
{
    public abstract void saveCustomer(Customer val);

    public abstract void removeCustomer(Customer val);

    public abstract void removeCustomer(Long id);

    public abstract Customer getCustomerById(Long id);

    public abstract List<Customer> getCustomerList();
    public abstract List<Member> getSalemanList();
}

