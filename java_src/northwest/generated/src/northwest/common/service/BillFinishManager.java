package northwest.common.service;

import northwest.common.value.BillFinish;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Mar 10 17:34:04 CST 2014
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

