package tncc.power.dao;

import tncc.power.value.BasicInfo;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public interface BasicInfoDAO extends CommonDAO 
{
    public abstract void saveBasicInfo(BasicInfo val);

    public abstract void removeBasicInfo(BasicInfo val);

    public abstract void removeBasicInfo(Long id);

    public abstract BasicInfo findBasicInfoById(Long id);

    public abstract List<BasicInfo> findAllBasicInfo();
    public abstract List<Member> findCreatedUserList();
    public abstract Long[] getIdsFromReaderList(List<Reader> lst);

    public abstract List<Reader> getReaderListByIds(Long[] ids);

}

