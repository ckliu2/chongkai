package northwest.common.service;

import northwest.common.value.Meter;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Tue Apr 04 10:27:20 CST 2017
*/

public interface MeterManager extends CommonManager 
{
    public abstract void saveMeter(Meter val);

    public abstract void removeMeter(Meter val);

    public abstract void removeMeter(Long id);

    public abstract Meter getMeterById(Long id);

    public abstract List<Meter> getMeterList();
    public abstract List<BillSchedule> getScheduleList();
    public abstract List<BillDetail> getBilldetailList();
    public abstract List<Bill> getBillList();
    public abstract List<Product> getProductList();
}

