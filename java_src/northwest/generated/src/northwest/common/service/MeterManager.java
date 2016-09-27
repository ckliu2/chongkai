package northwest.common.service;

import northwest.common.value.Meter;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Mar 10 17:34:04 CST 2014
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

