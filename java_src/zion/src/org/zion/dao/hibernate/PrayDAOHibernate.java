package org.zion.dao.hibernate;

import org.zion.value.*;
import org.zion.dao.PrayDAO;

import java.util.*;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.ObjectRetrievalFailureException;

import com.base.util.Tools;
import com.base.value.AppProperty;
import com.base.value.MiscCode;
import com.common.dao.hibernate.CommonDAOHibernate;
import com.common.value.Member;


public class PrayDAOHibernate extends CommonDAOHibernate implements PrayDAO
{

    public PrayDAOHibernate()
    {
    }

    //Pray
    
    public void savePray(Pray val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removePray(Pray val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removePray(Long id)
    {
        Pray obj = findPrayById(id);
        getHibernateTemplate().delete(obj);
    }

    public Pray findPrayById(Long id)
    {
        if (id == null)
            return null;
        Pray obj = (Pray)getHibernateTemplate().get(org.zion.value.Pray.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(org.zion.value.Pray.class, id);
        else
            return obj;
    }

    public List<Pray> findAllPray()
    {
        return getHibernateTemplate().find("from Pray order by classify");
    }
    
    public List<Pray> getPrayListByClassify(AppProperty classify)
    {
    	Criteria c = getHibernateSession().createCriteria(Pray.class);
        c.add(Expression.eq("classify", classify));       
        return c.list();
    }

    //PrayMe
    public void savePrayMe(PrayMe val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removePrayMe(PrayMe val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removePrayMe(Long id)
    {
        PrayMe obj = findPrayMeById(id);
        getHibernateTemplate().delete(obj);
    }

    public PrayMe findPrayMeById(Long id)
    {
        if (id == null)
            return null;
        PrayMe obj = (PrayMe)getHibernateTemplate().get(org.zion.value.PrayMe.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(org.zion.value.PrayMe.class, id);
        else
            return obj;
    }

    public List<PrayMe> findAllPrayMe()
    {
        return getHibernateTemplate().find("from PrayMe where active=true order by createdDate desc");
    }
    
    public List<PrayMe> getPrayMeListByMember(Member member)
    {
	Criteria c = getHibernateSession().createCriteria(PrayMe.class);
        c.add(Expression.eq("member", member));
        c.addOrder(Order.desc("createdDate"));
        return c.list();
    }
    
    
    //PrayTWClaim
    public void savePrayTWClaim(PrayTWClaim val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removePrayTWClaim(PrayTWClaim val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removePrayTWClaim(Long id)
    {
        PrayTWClaim obj = findPrayTWClaimById(id);
        getHibernateTemplate().delete(obj);
    }

    public PrayTWClaim findPrayTWClaimById(Long id)
    {
        if (id == null)
            return null;
        PrayTWClaim obj = (PrayTWClaim)getHibernateTemplate().get(org.zion.value.PrayTWClaim.class, id);
        getHibernateTemplate().refresh( obj );        
        if (obj == null)
            throw new ObjectRetrievalFailureException(org.zion.value.PrayTWClaim.class, id);
        else
            return obj;
    }

    public List<PrayTWClaim> findAllPrayTWClaim()
    {
        return getHibernateTemplate().find("from PrayTWClaim");
    }
    
    public List<PrayTWClaim> getPrayTWClaimListByPrayTW(PrayTW praytw)
    {
    	Criteria c = getHibernateSession().createCriteria(PrayTWClaim.class);
        c.add(Expression.eq("praytw", praytw));
        c.addOrder(Order.desc("createdDate"));
        return c.list();
    }
    
    public void savePrayTWClaim(PrayTW praytw,Member member,int join)
    {
	//刪除已經存在
	Criteria c = getHibernateSession().createCriteria(PrayTWClaim.class);
        c.add(Expression.eq("praytw", praytw));
        c.add(Expression.eq("member", member));
        List ls=c.list();
        for(int i=0;i<ls.size();i++){
            PrayTWClaim p=(PrayTWClaim)ls.get(i);
            removePrayTWClaim(p);
        }
        
        //新增
        if(join==1){        
         PrayTWClaim m=new PrayTWClaim();
         m.setPraytw(praytw);
         m.setMember(member);
         m.setCreatedDate(Tools.getCurrentTimestamp());
         savePrayTWClaim(m);
        }
        
    }
    
    //PrayTW
    public void savePrayTW(PrayTW val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removePrayTW(PrayTW val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removePrayTW(Long id)
    {
        PrayTW obj = findPrayTWById(id);
        getHibernateTemplate().delete(obj);
    }

    public PrayTW findPrayTWById(Long id)
    {
        if (id == null)
            return null;
        PrayTW obj = (PrayTW)getHibernateTemplate().get(org.zion.value.PrayTW.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(org.zion.value.PrayTW.class, id);
        else
            return obj;
    }
    
    public PrayTW findPrayTWByArea(MiscCode area)
    {
    	PrayTW obj = null;
        try {
            Criteria c = getHibernateSession().createCriteria(PrayTW.class);
            c.add(Expression.eq("area", area));
            List result = c.list();
            if (result.size() > 0)
            	obj = (PrayTW) result.get(0);           
        }
        catch (Exception ex) {
         System.out.println(ex.toString());
        }       
        return obj;     
    }

    public List<PrayTW> findAllPrayTW()
    {
        return getHibernateTemplate().find("from PrayTW");
    }
    
    //PrayTWGlobal
    public void savePrayTWGlobal(PrayTWGlobal val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removePrayTWGlobal(PrayTWGlobal val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removePrayTWGlobal(Long id)
    {
        PrayTWGlobal obj = findPrayTWGlobalById(id);
        getHibernateTemplate().delete(obj);
    }

    public PrayTWGlobal findPrayTWGlobalById(Long id)
    {
        if (id == null)
            return null;
        PrayTWGlobal obj = (PrayTWGlobal)getHibernateTemplate().get(org.zion.value.PrayTWGlobal.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(org.zion.value.PrayTWGlobal.class, id);
        else
            return obj;
    }

    public List<PrayTWGlobal> findAllPrayTWGlobal()
    {
        return getHibernateTemplate().find("from PrayTWGlobal");
    }
    
    //PrayYou
    public void savePrayYou(PrayYou val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removePrayYou(PrayYou val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removePrayYou(Long id)
    {
        PrayYou obj = findPrayYouById(id);
        getHibernateTemplate().delete(obj);
    }

    public PrayYou findPrayYouById(Long id)
    {
        if (id == null)
            return null;
        PrayYou obj = (PrayYou)getHibernateTemplate().get(org.zion.value.PrayYou.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(org.zion.value.PrayYou.class, id);
        else
            return obj;
    }

    public List<PrayYou> findAllPrayYou()
    {
        return getHibernateTemplate().find("from PrayYou");
    }
    
    public List<PrayYou> getPrayYouListByPrayMe(PrayMe prayme)
    {
	Criteria c = getHibernateSession().createCriteria(PrayYou.class);
        c.add(Expression.eq("prayme", prayme));
        c.addOrder(Order.desc("createdDate"));
        return c.list();
    }
    
    //PrayStreet
    public List<PrayStreet> getPrayStreetListByPrayTW(PrayTW val)
    {
    	 Criteria c = getHibernateSession().createCriteria(PrayStreet.class);
         c.add(Expression.eq("praytw", val));
         return c.list();
    }
    
    public void savePrayStreet(PrayStreet val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removePrayStreet(PrayStreet val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removePrayStreet(Long id)
    {
        PrayStreet obj = findPrayStreetById(id);
        getHibernateTemplate().delete(obj);
    }

    public PrayStreet findPrayStreetById(Long id)
    {
        if (id == null)
            return null;
        PrayStreet obj = (PrayStreet)getHibernateTemplate().get(org.zion.value.PrayStreet.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(org.zion.value.PrayStreet.class, id);
        else
            return obj;
    }
    
    public boolean isPrayStreetByPrayTW(PrayTW val)
    {
    	 Criteria c = getHibernateSession().createCriteria(PrayStreet.class);
         c.add(Expression.eq("praytw", val));
         if(c.list().size()>0){
        	 return true;
         }else{
        	 return false;
         }
    }
    
    public int getTownShip(PrayTW praytw)
    {
	Criteria c = getHibernateSession().createCriteria(PrayTWClaim.class);
        c.add(Expression.eq("praytw", praytw));
        return c.list().size();
    }
    
    //SundayInfor
    public void saveSundayInfor(SundayInfor val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeSundayInfor(SundayInfor val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeSundayInfor(Long id)
    {
        SundayInfor obj = findSundayInforById(id);
        getHibernateTemplate().delete(obj);
    }

    public SundayInfor findSundayInforById(Long id)
    {
        if (id == null)
            return null;
        SundayInfor obj = (SundayInfor)getHibernateTemplate().get(org.zion.value.SundayInfor.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(org.zion.value.SundayInfor.class, id);
        else
            return obj;
    }

    public List<SundayInfor> findAllSundayInfor()
    {
        return getHibernateTemplate().find("from SundayInfor");
    }
    
    public List<SundayInfor> findAllSundayInfor(int top)
    {
	Criteria c = getHibernateSession().createCriteria(SundayInfor.class);       
	c.addOrder(Order.desc("messageDate"));
	c.setMaxResults(top);
	return c.list();
    }
    
    //EveryBible
    public List<EveryBible> getEveryBibleList()
    {
	return getHibernateTemplate().find("from EveryBible order by name asc");
    }
    
    public List<Bible> getBibleList()
    {
	return getHibernateTemplate().find("from Bible order by sn asc");
    }
    
    public EveryBible getEveryBibleByMember(Member member)
    {
	EveryBible b=null;
	Criteria c = getHibernateSession().createCriteria(EveryBible.class);
        c.add(Expression.eq("member", member));
        if(c.list().size()>0){
          b=(EveryBible)c.list().get(0);          
        }
        return b;
    }
    
    
    public Bible getBibleById(int sn)
    {
	Bible bible=null;
	Criteria c = getHibernateSession().createCriteria(Bible.class);
        c.add(Expression.eq("sn", sn));
        if(c.list().size()>0){
          bible=(Bible)c.list().get(0);          
        }
        return bible;
    }
    
    public Bible getBibleById(Long id)
    {
	if (id == null)
            return null;
	Bible obj = (Bible)getHibernateTemplate().get(Bible.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(Bible.class, id);
        else
            return obj;
    }
    
    public List<BibleLection> getBibleLection(int volume,int chapter)
    {
	Criteria c = getHibernateSession().createCriteria(BibleLection.class);
        c.add(Expression.eq("volume", volume));
        c.add(Expression.eq("chapter", chapter));
        c.addOrder(Order.asc("verse"));
        return c.list();
    }
    
    //LivelyBible
    public LivelyBible getLivelyBible(String date,int classify)
    {
	LivelyBible bible=null;
	Criteria c = getHibernateSession().createCriteria(LivelyBible.class);
        c.add(Expression.eq("date", date));
        c.add(Expression.eq("classify", classify));
        if(c.list().size()>0){
            bible=(LivelyBible)c.list().get(0);          
          }
         return bible;
    }
    
    public List<LivelyBible> getLivelyBibleList(String date)
    {
	Criteria c = getHibernateSession().createCriteria(LivelyBible.class);
        c.add(Expression.eq("date", date));
        c.addOrder(Order.asc("classify"));
        return c.list();
    }
    

}

