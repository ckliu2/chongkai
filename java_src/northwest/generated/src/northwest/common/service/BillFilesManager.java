package northwest.common.service;

import northwest.common.value.BillFiles;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Mar 10 17:34:04 CST 2014
*/

public interface BillFilesManager extends CommonManager 
{
    public abstract void saveBillFiles(BillFiles val);

    public abstract void removeBillFiles(BillFiles val);

    public abstract void removeBillFiles(Long id);

    public abstract BillFiles getBillFilesById(Long id);

    public abstract List<BillFiles> getBillFilesList();
    public abstract List<Bill> getBillList();
    public abstract List<UploadedFile> getDoc1List();
    public abstract List<UploadedFile> getDoc2List();
    public abstract List<UploadedFile> getDoc3List();
    public abstract List<UploadedFile> getDoc4List();
    public abstract List<UploadedFile> getDoc5List();
    public abstract List<UploadedFile> getDoc6List();
}
