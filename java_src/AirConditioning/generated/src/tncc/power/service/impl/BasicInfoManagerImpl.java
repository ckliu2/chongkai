package tncc.power.service.impl;

import tncc.power.service.BasicInfoManager;
import tncc.power.dao.BasicInfoDAO;
import tncc.power.value.BasicInfo;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public class BasicInfoManagerImpl extends CommonManagerImpl implements BasicInfoManager
{

    public BasicInfoManagerImpl()
    {
    }

    public BasicInfoDAO getGenericDAO()
    {
        return (BasicInfoDAO)super.getGenericDAO();
    }

    public void setGenericDAO(BasicInfoDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveBasicInfo(BasicInfo val)
    {
        getGenericDAO().saveBasicInfo(val);
    }

    public void removeBasicInfo(BasicInfo val)
    {
        getGenericDAO().removeBasicInfo(val);
    }

    public void removeBasicInfo(Long id)
    {
        getGenericDAO().removeBasicInfo(id);
    }

    public BasicInfo getBasicInfoById(Long id)
    {
         return getGenericDAO().findBasicInfoById(id);
    }

    public List<BasicInfo> getBasicInfoList()
    {
        return getGenericDAO().findAllBasicInfo();
    }
    public List<Member> getCreatedUserList()
    {
        return getGenericDAO().findCreatedUserList();
    }

    public Long[] getIdsFromReaderList(List<Reader> lst)
    {
        return getGenericDAO().getIdsFromReaderList(lst);
    }

    public List<Reader> getReaderListByIds(Long[] ids)
    {
        return getGenericDAO().getReaderListByIds(ids);
    }

}

