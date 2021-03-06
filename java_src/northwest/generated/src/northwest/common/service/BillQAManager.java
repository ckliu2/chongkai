package northwest.common.service;

import northwest.common.value.BillQA;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Tue Apr 04 10:27:20 CST 2017
*/

public interface BillQAManager extends CommonManager 
{
    public abstract void saveBillQA(BillQA val);

    public abstract void removeBillQA(BillQA val);

    public abstract void removeBillQA(Long id);

    public abstract BillQA getBillQAById(Long id);

    public abstract List<BillQA> getBillQAList();
    public abstract List<Bill> getBillList();
    public abstract List<Member> getMemberList();
    public abstract Long[] getIdsFromMemberList(List<Member> lst);

    public abstract List<Member> getMemberListByIds(Long[] ids);

}

