package northwest.common.dao;

import northwest.common.value.BillQA;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Tue Apr 04 10:27:20 CST 2017
*/

public interface BillQADAO extends CommonDAO 
{
    public abstract void saveBillQA(BillQA val);

    public abstract void removeBillQA(BillQA val);

    public abstract void removeBillQA(Long id);

    public abstract BillQA findBillQAById(Long id);

    public abstract List<BillQA> findAllBillQA();
    public abstract List<Bill> findBillList();
    public abstract List<Member> findMemberList();
    public abstract Long[] getIdsFromMemberList(List<Member> lst);

    public abstract List<Member> getMemberListByIds(Long[] ids);

}

