package northwest.common.dao;

import northwest.common.value.ProductClass;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Mar 10 17:34:04 CST 2014
*/

public interface ProductClassDAO extends CommonDAO 
{
    public abstract void saveProductClass(ProductClass val);

    public abstract void removeProductClass(ProductClass val);

    public abstract void removeProductClass(Long id);

    public abstract ProductClass findProductClassById(Long id);

    public abstract List<ProductClass> findAllProductClass();
    public abstract Long[] getIdsFromGroupList(List<Group> lst);

    public abstract List<Group> getGroupListByIds(Long[] ids);

}
