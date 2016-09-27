package northwest.common.dao;

import northwest.common.value.StandardCost;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Fri Mar 11 14:58:27 CST 2016
*/

public interface StandardCostDAO extends CommonDAO 
{
    public abstract void saveStandardCost(StandardCost val);

    public abstract void removeStandardCost(StandardCost val);

    public abstract void removeStandardCost(Long id);

    public abstract StandardCost findStandardCostById(Long id);

    public abstract List<StandardCost> findAllStandardCost();
    public abstract List<Product> findProductList();
}

