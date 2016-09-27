package org.zion.service;

import org.zion.value.*;

import java.util.*;

import com.base.value.*;
import com.common.service.CommonManager;
import com.common.value.Member;

public interface PrayManager extends CommonManager {
    // Pray
    public abstract void savePray(Pray val);

    public abstract void removePray(Pray val);

    public abstract void removePray(Long id);

    public abstract Pray getPrayById(Long id);

    public abstract List<Pray> getPrayList();

    public abstract List<Pray> getPrayListByClassify(AppProperty classify);

    // PrayMe
    public abstract void savePrayMe(PrayMe val);

    public abstract void removePrayMe(PrayMe val);

    public abstract void removePrayMe(Long id);

    public abstract PrayMe getPrayMeById(Long id);

    public abstract List<PrayMe> getPrayMeList();

    public abstract List<PrayMe> getPrayMeListByMember(Member member);
    
   

    // PrayTWClaim
    public abstract void savePrayTWClaim(PrayTWClaim val);

    public abstract void removePrayTWClaim(PrayTWClaim val);

    public abstract void removePrayTWClaim(Long id);

    public abstract PrayTWClaim getPrayTWClaimById(Long id);

    public abstract List<PrayTWClaim> getPrayTWClaimList();

    public abstract List<PrayTWClaim> getPrayTWClaimListByPrayTW(PrayTW praytw);

    public abstract void savePrayTWClaim(PrayTW praytw, Member member, int join);

    // PrayTWGlobal
    public abstract void savePrayTWGlobal(PrayTWGlobal val);

    public abstract void removePrayTWGlobal(PrayTWGlobal val);

    public abstract void removePrayTWGlobal(Long id);

    public abstract PrayTWGlobal getPrayTWGlobalById(Long id);

    public abstract List<PrayTWGlobal> getPrayTWGlobalList();

    // PrayTW
    public abstract void savePrayTW(PrayTW val);

    public abstract void removePrayTW(PrayTW val);

    public abstract void removePrayTW(Long id);

    public abstract PrayTW getPrayTWById(Long id);

    public abstract List<PrayTW> getPrayTWList();

    public abstract PrayTW getPrayTWByArea(MiscCode area);

    // PrayYou
    public abstract void savePrayYou(PrayYou val);

    public abstract void removePrayYou(PrayYou val);

    public abstract void removePrayYou(Long id);

    public abstract PrayYou getPrayYouById(Long id);

    public abstract List<PrayYou> getPrayYouList();

    public abstract List<PrayYou> getPrayYouListByPrayMe(PrayMe prayme);

    // PrayStreet
    public abstract List<PrayStreet> getPrayStreetListByPrayTW(PrayTW val);

    public abstract void savePrayStreet(PrayStreet val);

    public abstract void removePrayStreet(PrayStreet val);

    public abstract void removePrayStreet(Long id);

    public abstract PrayStreet getPrayStreetById(Long id);

    public abstract boolean isPrayStreetByPrayTW(PrayTW val);    
    
    public abstract int getTownShip(PrayTW praytw);
    
    //SundayInfor
    public abstract void saveSundayInfor(SundayInfor val);
    public abstract void removeSundayInfor(SundayInfor val);
    public abstract void removeSundayInfor(Long id);
    public abstract SundayInfor getSundayInforById(Long id);
    public abstract List<SundayInfor> getSundayInforList();    
    public abstract List<SundayInfor> getSundayInforList(int top);
    
    //EveryBible
    
    public abstract List<Bible> getBibleList();  
    
    public abstract List<EveryBible> getEveryBibleList();   
    
    public abstract EveryBible getEveryBibleByMember(Member member);
    
    public abstract Bible getBibleById(int sn);
    public abstract Bible getBibleById(Long id);
    public abstract List<BibleLection> getBibleLection(int volume,int chapter);
    
    
    //LivelyBible
    public abstract LivelyBible getLivelyBible(String date,int classify);
    public abstract List<LivelyBible> getLivelyBibleList(String date);
    
    

}
