package northwest.common.service;

import northwest.common.value.BillAuthority;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Mar 10 17:34:04 CST 2014
*/

public interface BillAuthorityManager extends CommonManager 
{
    public abstract void saveBillAuthority(BillAuthority val);

    public abstract void removeBillAuthority(BillAuthority val);

    public abstract void removeBillAuthority(Long id);

    public abstract BillAuthority getBillAuthorityById(Long id);

    public abstract List<BillAuthority> getBillAuthorityList();
    public abstract List<Bill> getBillList();
    public abstract List<Group> getGroupList();
}

