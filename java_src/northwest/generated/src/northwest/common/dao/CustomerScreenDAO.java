package northwest.common.dao;

import northwest.common.value.CustomerScreen;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Mar 10 17:34:04 CST 2014
*/

public interface CustomerScreenDAO extends CommonDAO 
{
    public abstract void saveCustomerScreen(CustomerScreen val);

    public abstract void removeCustomerScreen(CustomerScreen val);

    public abstract void removeCustomerScreen(Long id);

    public abstract CustomerScreen findCustomerScreenById(Long id);

    public abstract List<CustomerScreen> findAllCustomerScreen();
    public abstract List<CustomerDetail> findCustomerDetailList();
    public abstract Long[] getIdsFromUploadedFileList(List<UploadedFile> lst);

    public abstract List<UploadedFile> getUploadedFileListByIds(Long[] ids);

}
