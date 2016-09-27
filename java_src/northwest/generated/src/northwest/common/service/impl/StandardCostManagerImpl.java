package northwest.common.service.impl;

import northwest.common.service.StandardCostManager;
import northwest.common.dao.StandardCostDAO;
import northwest.common.value.StandardCost;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Fri Mar 11 14:58:27 CST 2016
*/

public class StandardCostManagerImpl extends CommonManagerImpl implements StandardCostManager
{

    public StandardCostManagerImpl()
    {
    }

    public StandardCostDAO getGenericDAO()
    {
        return (StandardCostDAO)super.getGenericDAO();
    }

    public void setGenericDAO(StandardCostDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveStandardCost(StandardCost val)
    {
        getGenericDAO().saveStandardCost(val);
    }

    public void removeStandardCost(StandardCost val)
    {
        getGenericDAO().removeStandardCost(val);
    }

    public void removeStandardCost(Long id)
    {
        getGenericDAO().removeStandardCost(id);
    }

    public StandardCost getStandardCostById(Long id)
    {
         return getGenericDAO().findStandardCostById(id);
    }

    public List<StandardCost> getStandardCostList()
    {
        return getGenericDAO().findAllStandardCost();
    }
    public List<Product> getProductList()
    {
        return getGenericDAO().findProductList();
    }

}

