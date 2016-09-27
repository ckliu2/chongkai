package northwest.common.dao;

import northwest.common.value.ProductUnit;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Mar 10 17:34:04 CST 2014
*/

public interface ProductUnitDAO extends CommonDAO 
{
    public abstract void saveProductUnit(ProductUnit val);

    public abstract void removeProductUnit(ProductUnit val);

    public abstract void removeProductUnit(Long id);

    public abstract ProductUnit findProductUnitById(Long id);

    public abstract List<ProductUnit> findAllProductUnit();
}
