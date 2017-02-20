package northwest.common.service;

import northwest.common.value.BillQA;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Feb 20 21:48:11 CST 2017
*/

public interface BillQAManager extends CommonManager 
{
    public abstract void saveBillQA(BillQA val);

    public abstract void removeBillQA(BillQA val);

    public abstract void removeBillQA(Long id);

    public abstract BillQA getBillQAById(Long id);

    public abstract List<BillQA> getBillQAList();
    public abstract List<Bill> getBillList();
}

