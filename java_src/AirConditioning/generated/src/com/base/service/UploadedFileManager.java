package com.base.service;

import com.base.value.UploadedFile;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Dec 12 16:17:33 CST 2013
*/

public interface UploadedFileManager extends CommonManager 
{
    public abstract void saveUploadedFile(UploadedFile val);

    public abstract void removeUploadedFile(UploadedFile val);

    public abstract void removeUploadedFile(Long id);

    public abstract UploadedFile getUploadedFileById(Long id);

    public abstract List<UploadedFile> getUploadedFileList();
}

