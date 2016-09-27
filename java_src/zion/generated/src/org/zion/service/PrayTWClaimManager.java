package org.zion.service;

import org.zion.value.PrayTWClaim;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jan 07 15:37:44 CST 2015
*/

public interface PrayTWClaimManager extends CommonManager 
{
    public abstract void savePrayTWClaim(PrayTWClaim val);

    public abstract void removePrayTWClaim(PrayTWClaim val);

    public abstract void removePrayTWClaim(Long id);

    public abstract PrayTWClaim getPrayTWClaimById(Long id);

    public abstract List<PrayTWClaim> getPrayTWClaimList();
    public abstract List<PrayTW> getPraytwList();
    public abstract List<Member> getMemberList();
}

