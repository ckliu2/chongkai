package northwest.common.service.impl;

import northwest.common.service.CustomerScreenManager;
import northwest.common.dao.CustomerScreenDAO;
import northwest.common.value.CustomerScreen;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Mar 10 17:34:04 CST 2014
*/

public class CustomerScreenManagerImpl extends CommonManagerImpl implements CustomerScreenManager
{

    public CustomerScreenManagerImpl()
    {
    }

    public CustomerScreenDAO getGenericDAO()
    {
        return (CustomerScreenDAO)super.getGenericDAO();
    }

    public void setGenericDAO(CustomerScreenDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveCustomerScreen(CustomerScreen val)
    {
        getGenericDAO().saveCustomerScreen(val);
    }

    public void removeCustomerScreen(CustomerScreen val)
    {
        getGenericDAO().removeCustomerScreen(val);
    }

    public void removeCustomerScreen(Long id)
    {
        getGenericDAO().removeCustomerScreen(id);
    }

    public CustomerScreen getCustomerScreenById(Long id)
    {
         return getGenericDAO().findCustomerScreenById(id);
    }

    public List<CustomerScreen> getCustomerScreenList()
    {
        return getGenericDAO().findAllCustomerScreen();
    }
    public List<CustomerDetail> getCustomerDetailList()
    {
        return getGenericDAO().findCustomerDetailList();
    }

    public Long[] getIdsFromUploadedFileList(List<UploadedFile> lst)
    {
        return getGenericDAO().getIdsFromUploadedFileList(lst);
    }

    public List<UploadedFile> getUploadedFileListByIds(Long[] ids)
    {
        return getGenericDAO().getUploadedFileListByIds(ids);
    }

}
