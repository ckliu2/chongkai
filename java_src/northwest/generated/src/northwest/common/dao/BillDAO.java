package northwest.common.dao;

import northwest.common.value.Bill;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Mar 10 17:34:04 CST 2014
*/

public interface BillDAO extends CommonDAO 
{
    public abstract void saveBill(Bill val);

    public abstract void removeBill(Bill val);

    public abstract void removeBill(Long id);

    public abstract Bill findBillById(Long id);

    public abstract List<Bill> findAllBill();
    public abstract List<Customer> findCustomerList();
}

