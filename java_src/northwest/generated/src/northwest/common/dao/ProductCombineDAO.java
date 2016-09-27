package northwest.common.dao;

import northwest.common.value.ProductCombine;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Mar 10 17:34:04 CST 2014
*/

public interface ProductCombineDAO extends CommonDAO 
{
    public abstract void saveProductCombine(ProductCombine val);

    public abstract void removeProductCombine(ProductCombine val);

    public abstract void removeProductCombine(Long id);

    public abstract ProductCombine findProductCombineById(Long id);

    public abstract List<ProductCombine> findAllProductCombine();
    public abstract List<Product> findProductList();
}
