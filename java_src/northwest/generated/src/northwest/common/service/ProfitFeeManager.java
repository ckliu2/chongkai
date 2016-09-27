package northwest.common.service;

import northwest.common.value.ProfitFee;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Fri Mar 11 14:58:27 CST 2016
*/

public interface ProfitFeeManager extends CommonManager 
{
    public abstract void saveProfitFee(ProfitFee val);

    public abstract void removeProfitFee(ProfitFee val);

    public abstract void removeProfitFee(Long id);

    public abstract ProfitFee getProfitFeeById(Long id);

    public abstract List<ProfitFee> getProfitFeeList();
    public abstract List<Bill> getBillList();
}

