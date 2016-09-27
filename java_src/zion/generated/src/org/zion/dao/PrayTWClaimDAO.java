package org.zion.dao;

import org.zion.value.PrayTWClaim;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public interface PrayTWClaimDAO extends CommonDAO 
{
    public abstract void savePrayTWClaim(PrayTWClaim val);

    public abstract void removePrayTWClaim(PrayTWClaim val);

    public abstract void removePrayTWClaim(Long id);

    public abstract PrayTWClaim findPrayTWClaimById(Long id);

    public abstract List<PrayTWClaim> findAllPrayTWClaim();
    public abstract List<PrayTW> findPraytwList();
    public abstract List<Member> findMemberList();
}

