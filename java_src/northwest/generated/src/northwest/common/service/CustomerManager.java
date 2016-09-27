package northwest.common.service;

import northwest.common.value.Customer;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Mar 10 17:34:04 CST 2014
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

