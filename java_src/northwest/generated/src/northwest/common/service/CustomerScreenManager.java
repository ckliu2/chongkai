package northwest.common.service;

import northwest.common.value.CustomerScreen;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Mar 10 17:34:04 CST 2014
*/

public interface CustomerScreenManager extends CommonManager 
{
    public abstract void saveCustomerScreen(CustomerScreen val);

    public abstract void removeCustomerScreen(CustomerScreen val);

    public abstract void removeCustomerScreen(Long id);

    public abstract CustomerScreen getCustomerScreenById(Long id);

    public abstract List<CustomerScreen> getCustomerScreenList();
    public abstract List<CustomerDetail> getCustomerDetailList();
    public abstract Long[] getIdsFromUploadedFileList(List<UploadedFile> lst);

    public abstract List<UploadedFile> getUploadedFileListByIds(Long[] ids);

}

