package northwest.common.service.impl;

import northwest.common.service.BillAuthorityManager;
import northwest.common.dao.BillAuthorityDAO;
import northwest.common.value.BillAuthority;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Mar 10 17:34:04 CST 2014
*/

public class BillAuthorityManagerImpl extends CommonManagerImpl implements BillAuthorityManager
{

    public BillAuthorityManagerImpl()
    {
    }

    public BillAuthorityDAO getGenericDAO()
    {
        return (BillAuthorityDAO)super.getGenericDAO();
    }

    public void setGenericDAO(BillAuthorityDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveBillAuthority(BillAuthority val)
    {
        getGenericDAO().saveBillAuthority(val);
    }

    public void removeBillAuthority(BillAuthority val)
    {
        getGenericDAO().removeBillAuthority(val);
    }

    public void removeBillAuthority(Long id)
    {
        getGenericDAO().removeBillAuthority(id);
    }

    public BillAuthority getBillAuthorityById(Long id)
    {
         return getGenericDAO().findBillAuthorityById(id);
    }

    public List<BillAuthority> getBillAuthorityList()
    {
        return getGenericDAO().findAllBillAuthority();
    }
    public List<Bill> getBillList()
    {
        return getGenericDAO().findBillList();
    }

    public List<Group> getGroupList()
    {
        return getGenericDAO().findGroupList();
    }

}

