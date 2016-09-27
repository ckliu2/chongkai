package org.zion.service.impl;

import org.zion.service.PrayTWClaimManager;
import org.zion.dao.PrayTWClaimDAO;
import org.zion.value.PrayTWClaim;
import java.util.*;
import com.common.service.impl.CommonManagerImpl;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public class PrayTWClaimManagerImpl extends CommonManagerImpl implements PrayTWClaimManager
{

    public PrayTWClaimManagerImpl()
    {
    }

    public PrayTWClaimDAO getGenericDAO()
    {
        return (PrayTWClaimDAO)super.getGenericDAO();
    }

    public void setGenericDAO(PrayTWClaimDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void savePrayTWClaim(PrayTWClaim val)
    {
        getGenericDAO().savePrayTWClaim(val);
    }

    public void removePrayTWClaim(PrayTWClaim val)
    {
        getGenericDAO().removePrayTWClaim(val);
    }

    public void removePrayTWClaim(Long id)
    {
        getGenericDAO().removePrayTWClaim(id);
    }

    public PrayTWClaim getPrayTWClaimById(Long id)
    {
         return getGenericDAO().findPrayTWClaimById(id);
    }

    public List<PrayTWClaim> getPrayTWClaimList()
    {
        return getGenericDAO().findAllPrayTWClaim();
    }
    public List<PrayTW> getPraytwList()
    {
        return getGenericDAO().findPraytwList();
    }

    public List<Member> getMemberList()
    {
        return getGenericDAO().findMemberList();
    }

}

