package com.base.dao;

import com.base.value.UploadedFile;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 18 16:53:07 CST 2014
*/

public interface UploadedFileDAO extends CommonDAO 
{
    public abstract void saveUploadedFile(UploadedFile val);

    public abstract void removeUploadedFile(UploadedFile val);

    public abstract void removeUploadedFile(Long id);

    public abstract UploadedFile findUploadedFileById(Long id);

    public abstract List<UploadedFile> findAllUploadedFile();
}

