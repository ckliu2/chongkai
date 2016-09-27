package northwest.common.dao;

import northwest.common.value.ProfitFee;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Fri Mar 11 14:58:27 CST 2016
*/

public interface ProfitFeeDAO extends CommonDAO 
{
    public abstract void saveProfitFee(ProfitFee val);

    public abstract void removeProfitFee(ProfitFee val);

    public abstract void removeProfitFee(Long id);

    public abstract ProfitFee findProfitFeeById(Long id);

    public abstract List<ProfitFee> findAllProfitFee();
    public abstract List<Bill> findBillList();
}

