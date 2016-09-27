package org.zion.service.impl;

import org.zion.service.PrayManager;
import org.zion.dao.PrayDAO;
import org.zion.value.*;

import java.util.*;

import com.base.value.AppProperty;
import com.base.value.MiscCode;
import com.common.service.impl.CommonManagerImpl;
import com.common.value.Member;


public class PrayManagerImpl extends CommonManagerImpl implements PrayManager
{

    public PrayManagerImpl()
    {
    }

    public PrayDAO getGenericDAO()
    {
        return (PrayDAO)super.getGenericDAO();
    }

    public void setGenericDAO(PrayDAO dao)
    {
        super.setGenericDAO(dao);
    }

    
    //Pray
    public void savePray(Pray val)
    {
        getGenericDAO().savePray(val);
    }

    public void removePray(Pray val)
    {
        getGenericDAO().removePray(val);
    }

    public void removePray(Long id)
    {
        getGenericDAO().removePray(id);
    }

    public Pray getPrayById(Long id)
    {
         return getGenericDAO().findPrayById(id);
    }

    public List<Pray> getPrayList()
    {
        return getGenericDAO().findAllPray();
    }
    
    public List<Pray> getPrayListByClassify(AppProperty classify)
    {
    	return getGenericDAO().getPrayListByClassify(classify);
    }

    //PrayMe
    public void savePrayMe(PrayMe val)
    {
        getGenericDAO().savePrayMe(val);
    }

    public void removePrayMe(PrayMe val)
    {
        getGenericDAO().removePrayMe(val);
    }

    public void removePrayMe(Long id)
    {
        getGenericDAO().removePrayMe(id);
    }

    public PrayMe getPrayMeById(Long id)
    {
         return getGenericDAO().findPrayMeById(id);
    }

    public List<PrayMe> getPrayMeList()
    {
        return getGenericDAO().findAllPrayMe();
    }
    
    public List<PrayMe> getPrayMeListByMember(Member member)
    {
	return getGenericDAO().getPrayMeListByMember(member);
    }
    
    
    //PrayTW
    public void savePrayTW(PrayTW val)
    {
        getGenericDAO().savePrayTW(val);
    }

    public void removePrayTW(PrayTW val)
    {
        getGenericDAO().removePrayTW(val);
    }

    public void removePrayTW(Long id)
    {
        getGenericDAO().removePrayTW(id);
    }

    public PrayTW getPrayTWById(Long id)
    {
         return getGenericDAO().findPrayTWById(id);
    }

    public List<PrayTW> getPrayTWList()
    {
        return getGenericDAO().findAllPrayTW();
    }
    
    public PrayTW getPrayTWByArea(MiscCode area)
    {
    	return getGenericDAO().findPrayTWByArea(area);
    }
    
    
    //PrayTWClaim
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
    
    public List<PrayTWClaim> getPrayTWClaimListByPrayTW(PrayTW praytw)
    {
    	return getGenericDAO().getPrayTWClaimListByPrayTW(praytw);
    }
    
    public void savePrayTWClaim(PrayTW praytw,Member member,int join)
    {
	getGenericDAO().savePrayTWClaim(praytw,member,join);
    }
    
    //PrayTWGlobal
    public void savePrayTWGlobal(PrayTWGlobal val)
    {
        getGenericDAO().savePrayTWGlobal(val);
    }

    public void removePrayTWGlobal(PrayTWGlobal val)
    {
        getGenericDAO().removePrayTWGlobal(val);
    }

    public void removePrayTWGlobal(Long id)
    {
        getGenericDAO().removePrayTWGlobal(id);
    }

    public PrayTWGlobal getPrayTWGlobalById(Long id)
    {
         return getGenericDAO().findPrayTWGlobalById(id);
    }

    public List<PrayTWGlobal> getPrayTWGlobalList()
    {
        return getGenericDAO().findAllPrayTWGlobal();
    }
    
    
    //PrayYou
    public void savePrayYou(PrayYou val)
    {
        getGenericDAO().savePrayYou(val);
    }

    public void removePrayYou(PrayYou val)
    {
        getGenericDAO().removePrayYou(val);
    }

    public void removePrayYou(Long id)
    {
        getGenericDAO().removePrayYou(id);
    }

    public PrayYou getPrayYouById(Long id)
    {
         return getGenericDAO().findPrayYouById(id);
    }

    public List<PrayYou> getPrayYouList()
    {
        return getGenericDAO().findAllPrayYou();
    }
    
    public List<PrayYou> getPrayYouListByPrayMe(PrayMe prayme)
    {
	return getGenericDAO().getPrayYouListByPrayMe(prayme);
    }
    
    //PrayStreet
    public List<PrayStreet> getPrayStreetListByPrayTW(PrayTW val)
    {
    	return getGenericDAO().getPrayStreetListByPrayTW(val);
    }
    
    public void savePrayStreet(PrayStreet val)
    {
        getGenericDAO().savePrayStreet(val);
    }

    public void removePrayStreet(PrayStreet val)
    {
        getGenericDAO().removePrayStreet(val);
    }

    public void removePrayStreet(Long id)
    {
        getGenericDAO().removePrayStreet(id);
    }

    public PrayStreet getPrayStreetById(Long id)
    {
         return getGenericDAO().findPrayStreetById(id);
    }
    
    public boolean isPrayStreetByPrayTW(PrayTW val)
    {
    	return getGenericDAO().isPrayStreetByPrayTW(val);
    }

    public int getTownShip(PrayTW praytw)
    {
	return getGenericDAO().getTownShip(praytw);
    }
    
    //SundayInfor
    public void saveSundayInfor(SundayInfor val)
    {
        getGenericDAO().saveSundayInfor(val);
    }

    public void removeSundayInfor(SundayInfor val)
    {
        getGenericDAO().removeSundayInfor(val);
    }

    public void removeSundayInfor(Long id)
    {
        getGenericDAO().removeSundayInfor(id);
    }

    public SundayInfor getSundayInforById(Long id)
    {
         return getGenericDAO().findSundayInforById(id);
    }

    public List<SundayInfor> getSundayInforList()
    {
        return getGenericDAO().findAllSundayInfor();
    }
    
    public List<SundayInfor> getSundayInforList(int top)
    {
        return getGenericDAO().findAllSundayInfor(top);
    }
    
    //EveryBible
    public List<EveryBible> getEveryBibleList()
    {
	return getGenericDAO().getEveryBibleList();
    }
    
    public EveryBible getEveryBibleByMember(Member member)
    {
	return getGenericDAO().getEveryBibleByMember(member);
    }
    
    
    public Bible getBibleById(int sn)
    {
	return getGenericDAO().getBibleById(sn);
    }
    
    public Bible getBibleById(Long id)
    {
	return getGenericDAO().getBibleById(id);
    }
    
    public List<BibleLection> getBibleLection(int volume,int chapter)
    {
	return getGenericDAO().getBibleLection(volume,chapter);
    }
    
    public List<Bible> getBibleList()
    {
	return getGenericDAO().getBibleList();
    }
    
    //LivelyBible
    public LivelyBible getLivelyBible(String date,int classify)
    {
	return getGenericDAO().getLivelyBible(date,classify);
    }
    
    public List<LivelyBible> getLivelyBibleList(String date)
    {
	return getGenericDAO().getLivelyBibleList(date);
    }
    
}

