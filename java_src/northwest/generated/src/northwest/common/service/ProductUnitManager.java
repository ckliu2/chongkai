package northwest.common.service;

import northwest.common.value.ProductUnit;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Tue Apr 04 10:27:20 CST 2017
*/

public interface ProductUnitManager extends CommonManager 
{
    public abstract void saveProductUnit(ProductUnit val);

    public abstract void removeProductUnit(ProductUnit val);

    public abstract void removeProductUnit(Long id);

    public abstract ProductUnit getProductUnitById(Long id);

    public abstract List<ProductUnit> getProductUnitList();
}

