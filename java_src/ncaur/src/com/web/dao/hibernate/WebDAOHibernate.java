package com.web.dao.hibernate;

import com.web.value.*;
import com.web.dao.WebDAO;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.base.value.AppProperty;
import com.base.value.Group;
import com.city.dao.hibernate.CityDAOHibernate;
import com.common.dao.hibernate.CommonDAOHibernate;
import com.common.value.Member;



public class WebDAOHibernate extends CityDAOHibernate implements WebDAO
{

    public WebDAOHibernate()
    {
    }

    //部落格類別
    public void saveBolgClass(BolgClass val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeBolgClass(BolgClass val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeBolgClass(Long id)
    {
        BolgClass obj = findBolgClassById(id);
        getHibernateTemplate().delete(obj);
    }

    public BolgClass findBolgClassById(Long id)
    {
        if (id == null)
            return null;
        BolgClass obj = (BolgClass)getHibernateTemplate().get(com.web.value.BolgClass.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.web.value.BolgClass.class, id);
        else
            return obj;
    }

    public List<BolgClass> findAllBolgClass()
    {
        return getHibernateTemplate().find("from BolgClass order by seqNo asc");
    }  
    
   // public List<Bolg> findBolgList()
   // {
   //     return new ArrayList<Bolg>(); // TODO
   // }
    
    //部落格
    public void saveBolg(Bolg val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeBolg(Bolg val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeBolg(Long id)
    {
        Bolg obj = findBolgById(id);
        getHibernateTemplate().delete(obj);
    }

    public Bolg findBolgById(Long id)
    {
        if (id == null)
            return null;
        Bolg obj = (Bolg)getHibernateTemplate().get(com.web.value.Bolg.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.web.value.Bolg.class, id);
        else
            return obj;
    }

    public List<Bolg> findAllBolg()
    {
        return getHibernateTemplate().find("from Bolg order by seqNo asc");
    }
    
    public List<Bolg> findBolgByBlogClass(BolgClass b)
    {    	
    	ArrayList<Bolg> bolg = new ArrayList<Bolg>();
    	Criteria c = getHibernateSession().createCriteria(Bolg.class);
    	c.add(Expression.eq("bolgClass", b));   
    	c.add(Expression.eq("status", true));
    	c.addOrder(Order.asc("seqNo"));    	
    	List ls = c.list(); 
   	     for(int i=0;i<ls.size();i++){
   	   		 Bolg bo=(Bolg)ls.get(i);
   	   		 //System.out.println("bolg name="+bo.getName());
   	   		 bolg.add(bo);   
   	   	  }
    	    return bolg;
    }
    
    
  
    //超連結
    public void saveLinks(Links val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeLinks(Links val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeLinks(Long id)
    {
        Links obj = findLinksById(id);
        getHibernateTemplate().delete(obj);
    }

    public Links findLinksById(Long id)
    {
        if (id == null)
            return null;
        Links obj = (Links)getHibernateTemplate().get(com.web.value.Links.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.web.value.Links.class, id);
        else
            return obj;
    }

    public List<Links> findAllLinks()
    {
        return getHibernateTemplate().find("from Links order by seqNo");
    }
    
    //公告管理
    
    public void saveBulletin(Bulletin val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeBulletin(Bulletin val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeBulletin(Long id)
    {
        Bulletin obj = findBulletinById(id);
        getHibernateTemplate().delete(obj);
    }

    public Bulletin findBulletinById(Long id)
    {
        if (id == null)
            return null;
        Bulletin obj = (Bulletin)getHibernateTemplate().get(com.web.value.Bulletin.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.web.value.Bulletin.class, id);
        else
            return obj;
    }

    public List<Bulletin> findAllBulletin()
    {
        return getHibernateTemplate().find("from Bulletin order by bulletinDate desc");
    }
    
    public Bulletin getTopBulletin(){
    	Bulletin bulletin=new Bulletin();
    	List<Bulletin> b= getHibernateTemplate().find("from Bulletin where bulletinType=24  order by bulletinDate desc");
        if(b.size()>0){
        	bulletin=(Bulletin)b.get(0);
        }
        return bulletin;
    }
    
    public List<Bulletin> findQueryBulletinList(AppProperty bulletinType,String subject,Date begindate,Date enddate){
    	ArrayList<Bulletin> bulletin = new ArrayList<Bulletin>();
    	Criteria c = getHibernateSession().createCriteria(Bulletin.class);
    	c.addOrder(Order.desc("bulletinDate"));
    	if(bulletinType!=null){
    		c.add(Expression.eq("bulletinType", bulletinType)); 
    	}    	
    	if(subject!=null){
    		c.add(Expression.like("subject", "%"+subject+"%")); 
    	}
    	if(begindate!=null){
    		c.add(Expression.ge("bulletinDate", begindate)); 
    	}
    	if(enddate!=null){
    		c.add(Expression.le("bulletinDate", enddate)); 
    	}
    	
    	List ls = c.list(); 
   	     for(int i=0;i<ls.size();i++){
   	    	Bulletin b=(Bulletin)ls.get(i);   	   		 
   	    	bulletin.add(b);   
   	   	  }
    	    return bulletin;
    }
    
    
    public List<Bulletin> getBulletinByTopList(AppProperty bulletinType,Integer num){
    	ArrayList<Bulletin> bulletin = new ArrayList<Bulletin>();
    	Criteria c = getHibernateSession().createCriteria(Bulletin.class);
    	c.add(Expression.eq("bulletinType", bulletinType));
    	c.addOrder(Order.desc("bulletinDate"));  
    	List ls = c.list(); 
  	     for(int i=0;i<ls.size();i++){
  	    	Bulletin b=(Bulletin)ls.get(i);   	
  	    	 if(i<num){
  	    	   bulletin.add(b);
  	    	 }
  	   	  }
    	 return bulletin;
    }
    
    
   //主選單
    public void saveMenu(Menu val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeMenu(Menu val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeMenu(Long id)
    {
        Menu obj = findMenuById(id);
        getHibernateTemplate().delete(obj);
    }

    public Menu findMenuById(Long id)
    {
        if (id == null)
            return null;
        Menu obj = (Menu)getHibernateTemplate().get(com.web.value.Menu.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.web.value.Menu.class, id);
        else
            return obj;
    }

    public List<Menu> findAllMenu()
    {
        return getHibernateTemplate().find("from Menu order by seqNo asc");
    }
    
    //子選單
    public void saveSubMenu(SubMenu val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeSubMenu(SubMenu val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeSubMenu(Long id)
    {
        SubMenu obj = findSubMenuById(id);
        getHibernateTemplate().delete(obj);
    }

    public SubMenu findSubMenuById(Long id)
    {
        if (id == null)
            return null;
        SubMenu obj = (SubMenu)getHibernateTemplate().get(com.web.value.SubMenu.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.web.value.SubMenu.class, id);
        else
            return obj;
    }

    public List<SubMenu> findAllSubMenu()
    {
        return getHibernateTemplate().find("from SubMenu order by seqNo asc");
    }
    
    public List<SubMenu> findSubMenuList()
    {
        return new ArrayList<SubMenu>(); // TODO
    }
    
    public List<Menu> findMenuList()
    {
        return new ArrayList<Menu>(); // TODO
    }
    
    public List<SubMenu> findSubMenuByMenu(Long id)
    {
    	ArrayList<SubMenu> submenus = new ArrayList<SubMenu>();    	
    	Criteria c = getHibernateSession().createCriteria(SubMenu.class);    	
    	c.add(Expression.eq("menu", findMenuById(id) ));   
    	c.addOrder(Order.asc("seqNo"));
    	 List ls = c.list(); 
    	 //System.out.println("ls.size="+ls.size());
    	 for(int i=0;i<ls.size();i++){
    		 SubMenu s=(SubMenu)ls.get(i);
    		 //System.out.println("s="+s.getName());
    		 submenus.add(s);    		 
    	 }   	 
    	 return submenus;
    }
    
    public boolean isEndSubMenuBySubMenuId(Long id){
    	ArrayList<SubItem> items = new ArrayList<SubItem>();    	
    	Criteria c = getHibernateSession().createCriteria(SubItem.class);    	
    	c.add(Expression.eq("subMenu", findSubMenuById(id) ));     	
    	List ls = c.list(); 
          if(ls.size()>0){
        	  return true;
          }else{
        	  return false;
          }
    }
    
    //子選項
    public void saveSubItem(SubItem val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeSubItem(SubItem val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeSubItem(Long id)
    {
        SubItem obj = findSubItemById(id);
        getHibernateTemplate().delete(obj);
    }

    public SubItem findSubItemById(Long id)
    {
        if (id == null)
            return null;
        SubItem obj = (SubItem)getHibernateTemplate().get(com.web.value.SubItem.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.web.value.SubItem.class, id);
        else
            return obj;
    }

    public List<SubItem> findAllSubItem()
    {
        return getHibernateTemplate().find("from SubItem order by seqNo asc");
    }
    
    public List<SubItem> findAllSubItemBySubMenu(Long id)
    {
    	ArrayList<SubItem> sub = new ArrayList<SubItem>();    	
    	Criteria c = getHibernateSession().createCriteria(SubItem.class);    	
    	c.add(Expression.eq("subMenu", findSubMenuById(id) ));    	   
    	c.addOrder(Order.asc("seqNo"));
    	 List ls = c.list(); 
    	 
    	 //System.out.println("ls.size="+ls.size());
    	 for(int i=0;i<ls.size();i++){
    		 SubItem s=(SubItem)ls.get(i);
    		 //System.out.println("s="+s.getName());
    		 sub.add(s);
    		 
    	 }   	 
    	 return sub;
    }
    
    //簽呈狀態
    public void saveCheckingState(CheckingState val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeCheckingState(CheckingState val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeCheckingState(Long id)
    {
        CheckingState obj = findCheckingStateById(id);
        getHibernateTemplate().delete(obj);
    }

    public CheckingState findCheckingStateById(Long id)
    {
        if (id == null)
            return null;
        CheckingState obj = (CheckingState)getHibernateTemplate().get(com.web.value.CheckingState.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.web.value.CheckingState.class, id);
        else
            return obj;
    }

    public List<CheckingState> findAllCheckingState()
    {
        return getHibernateTemplate().find("from CheckingState");
    }

    //時段管理
    public void saveClock(Clock val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeClock(Clock val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeClock(Long id)
    {
        Clock obj = findClockById(id);
        getHibernateTemplate().delete(obj);
    }

    public Clock findClockById(Long id)
    {
        if (id == null)
            return null;
        Clock obj = (Clock)getHibernateTemplate().get(com.web.value.Clock.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.web.value.Clock.class, id);
        else
            return obj;
    }

    public List<Clock> findAllClock()
    {
        return getHibernateTemplate().find("from Clock order by seqNo asc");
    }
    
        
    //場地管理 
    public void saveRoom(Room val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeRoom(Room val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeRoom(Long id)
    {
        Room obj = findRoomById(id);
        getHibernateTemplate().delete(obj);
    }

    public Room findRoomById(Long id)
    {
        if (id == null)
            return null;
        Room obj = (Room)getHibernateTemplate().get(com.web.value.Room.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.web.value.Room.class, id);
        else
            return obj;
    }

    public List<Room> findAllRoom()
    {
        return getHibernateTemplate().find("from Room order by seqNo asc");
    }
    
    public List<Room> findAllRoomById(Long[] ids)
    {
 	   ArrayList<Room> al = new ArrayList<Room>();
       if (ids != null) {
          for(int i=0;i<ids.length;i++){
        	Room room = (Room) findRoomById(ids[i]);       	   
       	    al.add(room);
          }
       }
       return al;
    }
    
    public Long[] getIdsFromRoomList(List<Room> lst)
    {
        ArrayList<Long> al = new ArrayList<Long>();
        if (lst != null) {
            for (int i = 0; i < lst.size(); i++) {
            	Room t = (Room) lst.get(i);
                if (t != null)
                    al.add(t.getId());
            }
        }
        Long lng[] = new Long[al.size()];
        al.toArray(lng);

        return lng;
    }
    
    
    //AgreeTerms
    public void saveAgreeTerms(AgreeTerms val)
    {
	 getHibernateTemplate().saveOrUpdate(val);
    }
    
    
    public AgreeTerms getAgreeTermsByMember(Member member)
    {
	AgreeTerms val=null;
	Criteria c = getHibernateSession().createCriteria(AgreeTerms.class);
    	c.add(Expression.eq("createdUser", member));   
    	if(c.list().size()>0){
    	  return (AgreeTerms)c.list().get(0);
    	}    	
    	return val;
    }
    
    //PerRefer
    public void savePerRefer(PerRefer val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removePerRefer(PerRefer val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removePerRefer(Long id)
    {
        PerRefer obj = findPerReferById(id);
        getHibernateTemplate().delete(obj);
    }

    public PerRefer findPerReferById(Long id)
    {
        if (id == null)
            return null;
        PerRefer obj = (PerRefer)getHibernateTemplate().get(com.web.value.PerRefer.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.web.value.PerRefer.class, id);
        else
            return obj;
    }

    public List<PerRefer> findAllPerRefer()
    {
        return getHibernateTemplate().find("from PerRefer");
    }
    
    //Consultant
    public void saveConsultant(Consultant val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeConsultant(Consultant val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeConsultant(Long id)
    {
        Consultant obj = findConsultantById(id);
        getHibernateTemplate().delete(obj);
    }

    public Consultant findConsultantById(Long id)
    {
        if (id == null)
            return null;
        Consultant obj = (Consultant)getHibernateTemplate().get(com.web.value.Consultant.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.web.value.Consultant.class, id);
        else
            return obj;
    }

    public List<Consultant> findAllConsultant()
    {
        return getHibernateTemplate().find("from Consultant");
    }
    
    
    
    

}

