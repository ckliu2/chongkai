package northwest.common.service;

import northwest.common.value.Bill;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Mar 10 17:34:04 CST 2014
*/

public interface BillManager extends CommonManager 
{
    public abstract void saveBill(Bill val);

    public abstract void removeBill(Bill val);

    public abstract void removeBill(Long id);

    public abstract Bill getBillById(Long id);

    public abstract List<Bill> getBillList();
    public abstract List<Customer> getCustomerList();
}

