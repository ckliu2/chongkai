package northwest.common.dao;

import northwest.common.value.BillDetail;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Mar 10 17:34:04 CST 2014
*/

public interface BillDetailDAO extends CommonDAO 
{
    public abstract void saveBillDetail(BillDetail val);

    public abstract void removeBillDetail(BillDetail val);

    public abstract void removeBillDetail(Long id);

    public abstract BillDetail findBillDetailById(Long id);

    public abstract List<BillDetail> findAllBillDetail();
    public abstract List<Product> findProductList();
    public abstract List<Bill> findBillList();
}
