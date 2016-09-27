package org.zion.dao;

import org.zion.value.*;

import java.util.*;

import com.base.value.*;
import com.common.dao.CommonDAO;
import com.common.value.Member;

public interface PrayDAO extends CommonDAO {

    // Pray
    public abstract void savePray(Pray val);

    public abstract void removePray(Pray val);

    public abstract void removePray(Long id);

    public abstract Pray findPrayById(Long id);

    public abstract List<Pray> findAllPray();

    public abstract List<Pray> getPrayListByClassify(AppProperty classify);

    // PrayMe
    public abstract void savePrayMe(PrayMe val);

    public abstract void removePrayMe(PrayMe val);

    public abstract void removePrayMe(Long id);

    public abstract PrayMe findPrayMeById(Long id);

    public abstract List<PrayMe> findAllPrayMe();
    
    public abstract List<PrayMe> getPrayMeListByMember(Member member);

    // PrayTWClaim
    public abstract void savePrayTWClaim(PrayTWClaim val);

    public abstract void removePrayTWClaim(PrayTWClaim val);

    public abstract void removePrayTWClaim(Long id);

    public abstract PrayTWClaim findPrayTWClaimById(Long id);

    public abstract List<PrayTWClaim> findAllPrayTWClaim();

    public abstract List<PrayTWClaim> getPrayTWClaimListByPrayTW(PrayTW praytw);

    public abstract void savePrayTWClaim(PrayTW praytw,Member member,int join);
    
    // PrayTW
    public abstract void savePrayTW(PrayTW val);

    public abstract void removePrayTW(PrayTW val);

    public abstract void removePrayTW(Long id);

    public abstract PrayTW findPrayTWById(Long id);

    public abstract List<PrayTW> findAllPrayTW();

    public abstract PrayTW findPrayTWByArea(MiscCode area);

    // PrayTWGlobal
    public abstract void savePrayTWGlobal(PrayTWGlobal val);

    public abstract void removePrayTWGlobal(PrayTWGlobal val);

    public abstract void removePrayTWGlobal(Long id);

    public abstract PrayTWGlobal findPrayTWGlobalById(Long id);

    public abstract List<PrayTWGlobal> findAllPrayTWGlobal();

    // PrayYou
    public abstract void savePrayYou(PrayYou val);

    public abstract void removePrayYou(PrayYou val);

    public abstract void removePrayYou(Long id);

    public abstract PrayYou findPrayYouById(Long id);

    public abstract List<PrayYou> findAllPrayYou();
    
    public abstract List<PrayYou> getPrayYouListByPrayMe(PrayMe prayme);

    // PrayStreet
    public abstract List<PrayStreet> getPrayStreetListByPrayTW(PrayTW val);

    public abstract void savePrayStreet(PrayStreet val);

    public abstract void removePrayStreet(PrayStreet val);

    public abstract void removePrayStreet(Long id);

    public abstract PrayStreet findPrayStreetById(Long id);

    public abstract boolean isPrayStreetByPrayTW(PrayTW val);
    
    public abstract int getTownShip(PrayTW praytw);
    
    //SundayInfor
    public abstract void saveSundayInfor(SundayInfor val);

    public abstract void removeSundayInfor(SundayInfor val);

    public abstract void removeSundayInfor(Long id);

    public abstract SundayInfor findSundayInforById(Long id);

    public abstract List<SundayInfor> findAllSundayInfor();
    
    public abstract List<SundayInfor> findAllSundayInfor(int top);
    
    //EveryBible
    public abstract List<EveryBible> getEveryBibleList();
    public abstract EveryBible getEveryBibleByMember(Member member);
    public abstract List<Bible> getBibleList(); 
    
    public abstract Bible getBibleById(int sn);
    public abstract Bible getBibleById(Long id);
    public abstract List<BibleLection> getBibleLection(int volume,int chapter);
    
    //LivelyBible
    public abstract LivelyBible getLivelyBible(String date,int classify);
    public abstract List<LivelyBible> getLivelyBibleList(String date);

}
