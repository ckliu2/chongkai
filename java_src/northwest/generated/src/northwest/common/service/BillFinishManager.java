package northwest.common.service;

import northwest.common.value.BillFinish;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Feb 20 21:48:11 CST 2017
*/

public interface BillFinishManager extends CommonManager 
{
    public abstract void saveBillFinish(BillFinish val);

    public abstract void removeBillFinish(BillFinish val);

    public abstract void removeBillFinish(Long id);

    public abstract BillFinish getBillFinishById(Long id);

    public abstract List<BillFinish> getBillFinishList();
    public abstract List<Bill> getBillList();
}

