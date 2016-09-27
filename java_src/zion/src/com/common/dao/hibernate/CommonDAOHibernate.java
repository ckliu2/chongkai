package com.common.dao.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.base.dao.hibernate.BaseDAOHibernate;
import com.base.value.AppProperty;
import com.base.value.Function;
import com.base.value.FunctionAuthority;
import com.base.value.FunctionCategory;
import com.base.value.Group;
import com.base.value.MiscCode;
import com.base.value.SessionUser;
import com.common.dao.CommonDAO;
import com.common.value.*;
import com.base.value.*;
import org.hibernate.criterion.Expression;
import org.hibernate.Criteria;
import org.hibernate.criterion.*;





 
public class CommonDAOHibernate extends BaseDAOHibernate implements CommonDAO 
{
    public Long[] getIdsFromFunctionCategoryList(List tlist)
    {
        ArrayList<Long> al = new ArrayList<Long>();
        if (tlist != null) {
            for (int i = 0; i < tlist.size(); i++) {
                FunctionCategory t = (FunctionCategory) tlist.get(i);
                if (t != null)
                    al.add(t.getId());
            }
        }
        Long lng[] = new Long[al.size()];
        al.toArray(lng);

        return lng;
    }

    public List getFunctionCategoryListByIds(Long[] ids)
    {
        ArrayList<FunctionCategory> al = new ArrayList<FunctionCategory>();
        if (ids != null) {
            for (int i = 0; i < ids.length; i++) {
                FunctionCategory t = (FunctionCategory) findFunctionCategoryById(ids[i]);
                if (t != null)
                    al.add(t);
            }
        }
        return al;
    }

    public Set getGroupListByIds(Long[] ids)
    {
    	Set groups = new HashSet();
        if (ids != null) {
            for (int i = 0; i < ids.length; i++) {
                Group t = (Group) findGroupById(ids[i]);
                if (t != null)
                	groups.add(t);
            }
        }
        return groups;
    }
    
	 public List getSurveyGroupListByIds(Long[] ids)
	    {
	        ArrayList<Group> al = new ArrayList<Group>();
	        if (ids != null) {
	            for (int i = 0; i < ids.length; i++) {
	                Group t = (Group) findGroupById(ids[i]);
	                if (t != null)
	                    al.add(t);
	            }
	        }
	        return al;
	    } 
    
    
    public Set getUnitListByIds(Long[] ids)
    {
    	Set units = new HashSet();
        if (ids != null) {
            for (int i = 0; i < ids.length; i++) {
                Unit t = (Unit) findUnitById(ids[i]);
                if (t != null)
                	units.add(t);
            }
        }
        return units;
    	/*ArrayList<Unit> al = new ArrayList<Unit>();
        if (ids != null) {
            for (int i = 0; i < ids.length; i++) {
            	Unit t = (Unit) findUnitById(ids[i]);
                if (t != null)
                    al.add(t);
            }
        }
        return al;*/
    }
    
    public List<AppProperty> findAllAppPropertyByIds(Long[] ids)
    {
    	 ArrayList<AppProperty> al = new ArrayList<AppProperty>();
         if (ids != null) {        	
             for (int j=0; j < ids.length; j++) { 
            	 AppProperty a = findAppPropertyById(ids[j]);
             	 al.add(a);
             }
         }    	
    	return al;
    }

    public List findAllAppProperty()
    {
        return getHibernateTemplate()
                .find(
                        "select distinct app.kind from AppProperty as app order by app.kind");
    }

    public void saveAppProperty(AppProperty obj)
    {
        getHibernateTemplate().saveOrUpdate(obj);
        if (logger.isDebugEnabled())
            logger.debug((new StringBuffer()).append("id set to: ").append(
                    obj.getId()).toString());
    }

    public void removeAppProperty(Long id)
    {
        getHibernateTemplate().delete(findAppPropertyById(id));
    }

    public void removeAppProperty(AppProperty obj)
    {
        if (obj == null)
            throw new ObjectRetrievalFailureException(
                    com.base.value.AppProperty.class, obj);
        getHibernateTemplate().delete(obj);
    }

    public List getMaxSeqNoOfAppPropertyByKind(String kind)
    {
        java.util.List result = new java.util.ArrayList();

        try {
            String hsql = "select max(app.seqNo) from AppProperty as app where app.kind=:kind";

            Query query = getHibernateSession().createQuery(hsql);
            query.setParameter("kind", kind);

            result = query.list();

            logger.debug(query.getQueryString());
        } catch (HibernateException ex) {
            if (logger.isErrorEnabled()) {
                logger.error(ex.getMessage(), ex);
            }

            throw new RuntimeException(ex);
        }

        return result;
    }

    public void saveChecking(Checking obj)
    {
        getHibernateTemplate().saveOrUpdate(obj);
        if (logger.isDebugEnabled())
            logger.debug((new StringBuffer()).append("id set to: ").append(
                    obj.getId()).toString());
    }

    public Group findGroupById(Long id)
    {
        if (id == null)
            return null;
        Group obj = (Group) getHibernateTemplate().get(
                com.base.value.Group.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(
                    com.base.value.Group.class, id);
        else
            return obj;
    }

    public void saveGroup(Group val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeGroup(Group val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeGroup(Long id)
    {
        Group obj = findGroupById(id);
        getHibernateTemplate().delete(obj);
    }

    public List findAllGroup()
    {
        return getHibernateTemplate().find("from Group");
    }

    public void saveFunction(Function val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeFunction(Function val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeFunction(Long id)
    {
        Function obj = findFunctionById(id);
        getHibernateTemplate().delete(obj);
    }

    public Function findFunctionById(Long id)
    {
        if (id == null)
            return null;
        Function obj = (Function) getHibernateTemplate().get(
                com.base.value.Function.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(
                    com.base.value.Function.class, id);
        else
            return obj;
    }

    public List findAllFunction()
    {
        return getHibernateTemplate().find("from Function order by category");
    }

    public List findOnlineFunction()
    {
        return getHibernateTemplate().find("from Function order by category");
    }

    public List findCategoryList()
    {
        return new ArrayList(); // TODO
    }

    public void saveFunctionCategory(FunctionCategory val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeFunctionCategory(FunctionCategory val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeFunctionCategory(Long id)
    {
        FunctionCategory obj = findFunctionCategoryById(id);
        getHibernateTemplate().delete(obj);
    }

    public FunctionCategory findFunctionCategoryById(Long id)
    {
        if (id == null)
            return null;
        FunctionCategory obj = (FunctionCategory) getHibernateTemplate().get(
                com.base.value.FunctionCategory.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(
                    com.base.value.FunctionCategory.class, id);
        else
            return obj;
    }

    public List findAllFunctionCategory()
    {
        return getHibernateTemplate().find(
                "from FunctionCategory order by seqNo");
    }

    public List findFrontFunctionCategoryList()
    {
        return getHibernateTemplate().find(
                "from FunctionCategory where isFront=true order by seqNo ");
    }

    public void saveFunctionAuthority(FunctionAuthority val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeFunctionAuthority(FunctionAuthority val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeFunctionAuthority(Long id)
    {
        FunctionAuthority obj = findFunctionAuthorityById(id);
        getHibernateTemplate().delete(obj);
    }

    public FunctionAuthority findFunctionAuthorityById(Long id)
    {
        if (id == null)
            return null;
        FunctionAuthority obj = (FunctionAuthority) getHibernateTemplate().get(
                com.base.value.FunctionAuthority.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(
                    com.base.value.FunctionAuthority.class, id);
        else
            return obj;
    }

    public List findAllFunctionAuthority()
    {
        return getHibernateTemplate().find("from FunctionAuthority");
    }

    public List findGroupList()
    {
        return findAllGroup();
    }
    
    
    public Long[] getIdsFromGradeList(Set tlist)
    {
        ArrayList<Long> al = new ArrayList<Long>();
        if (tlist != null) {        	
            for (int j=0; j < tlist.size(); j++) { 
            	Grade g = (Grade) tlist.iterator().next();
            	 al.add(g.getId());
            }
        }
        Long lng[] = new Long[al.size()];
        al.toArray(lng);
        return lng;
    }
    
    
    public Long[] getIdsFromTeamList(Set tlist)
    {
        ArrayList<Long> al = new ArrayList<Long>();
        if (tlist != null) {        	
            for (int j=0; j < tlist.size(); j++) { 
            	 Team g = (Team) tlist.iterator().next();
            	 al.add(g.getId());
            }
        }
        Long lng[] = new Long[al.size()];
        al.toArray(lng);
        return lng;
    }
    
    

    public Long[] getIdsFromGroupList(Set tlist)
    {
        ArrayList<Long> al = new ArrayList<Long>();
        if (tlist != null) {        	
            for (int j=0; j < tlist.size(); j++) { 
            	Group g = (Group) tlist.iterator().next();
            	 al.add(g.getId());
            }
        }
        Long lng[] = new Long[al.size()];
        al.toArray(lng);
        return lng;
    }
    
   
    public Long[] getIdsFromSurveyGroupList(List tlist)
    {
        ArrayList<Long> al = new ArrayList<Long>();
        if (tlist != null) {
            for (int i = 0; i < tlist.size(); i++) {
            	Group t = (Group) tlist.get(i);
                if (t != null)
                    al.add(t.getId());
            }
        }
        Long lng[] = new Long[al.size()];
        al.toArray(lng);

        return lng;
    }
    
    
    public Long[] getIdsFromUnitList(Set tlist)
    {
        ArrayList<Long> al = new ArrayList<Long>();
        if (tlist != null) {        	
            for (int j=0; j < tlist.size(); j++) { 
            	Unit u = (Unit) tlist.iterator().next();
            	 al.add(u.getId());
            }
        }
        Long lng[] = new Long[al.size()];
        al.toArray(lng);
        return lng;   	
    }
    

    public void saveWebSite(WebSite val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeWebSite(WebSite val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeWebSite(Long id)
    {
        WebSite obj = findWebSiteById(id);
        getHibernateTemplate().delete(obj);
    }

    public WebSite findWebSiteById(Long id)
    {
        if (id == null)
            return null;
        WebSite obj = (WebSite) getHibernateTemplate().get(
                com.common.value.WebSite.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(
                    com.common.value.WebSite.class, id);
        else
            return obj;
    }

    public WebSite findWebSiteByCode(String code)
    {
        //System.out.println("WebSiteByCode:" + code);
        if (code == null)
            return null;
        Criteria c = getHibernateSession().createCriteria(
                com.common.value.WebSite.class);
        c.add(Expression.eq("code", code));
        List ll = c.list();
        if (ll.size() > 0)
            return (WebSite) ll.get(0);
        else
            return null;
    }

    public List findAllWebSite()
    {
        return getHibernateTemplate().find("from WebSite");
    }

    public void saveMember(Member val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeMember(Member val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeMember(Long id)
    {
        Member obj = findMemberById(id);
        getHibernateTemplate().delete(obj);
    }

    public Member findMemberById(Long id)
    {
        if (id == null)
            return null;
        Member obj = (Member)getHibernateTemplate().get(com.common.value.Member.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.common.value.Member.class, id);
        else
            return obj;
    }
    
    public Member findMemberByEmail(String email)
    {
        System.out.println("findMemberByEmail..email="+email);
    	if (email == null)
            return null;
        Criteria c = getHibernateSession().createCriteria(
                com.common.value.Member.class);
        c.add(Expression.eq("email", email));
        List ll = c.list();
        if (ll.size() > 0)
            return (Member) ll.get(0);
        else
            return null;
    }

    public List<Member> findAllMember()
    {   
    	return getHibernateTemplate().find("from Member order by name desc");    	
    }
    
    public Member findMemberByCardId(String cardId)
    {   
        Member user = null;
        try {
    	  Criteria c = getHibernateSession().createCriteria(com.common.value.Member.class);
          c.add(Expression.eq("cardId", cardId));         
          
             List result = c.list();
             if (result.size() > 0){
                 user = (Member) result.get(0);   
             }
             return user;
        }catch (HibernateException ex) {
            System.out.println("findMemberByCardId error!");
            return user;
        }
    	  	
    }
    
    
    public List<Member> findQueryMember(String name)
    {

        if(name!=null){
          name.trim();
        }        

        String hsql = "select m from Member as m where m.name like :name or nickname like :nickname";
        Query qry = getHibernateSession().createQuery(hsql);
        qry.setParameter("name", "%"+name+"%");
        qry.setParameter("nickname", "%"+name+"%");


        
        List query = qry.list();  
        ArrayList<Member> al = new ArrayList<Member>();
            for (int i = 0; i < query.size(); i++) {
            	   Member m=(Member) query.get(i);
                   al.add(m);
                   //System.out.println("查詢結果："+m.getName());
            }
        return al;
    }
    
    public Member findMemberByCellphone(String cellphone)
    {
        Member user = null;

        try {
            Criteria c = getHibernateSession().createCriteria(
                    com.common.value.Member.class);
            c.add(Expression.eq("cellphone", cellphone));           
            List result = c.list();
            if (result.size() > 0)
                user = (Member) result.get(0);           
        }
        catch (HibernateException ex) {
            if ( logger.isErrorEnabled() ) {
                logger.error(ex.getMessage(), ex);
            }

            throw new RuntimeException(ex);
        }
        
        return user;
    }
    
    public List<UploadedFile> findPhotoList()
    {
        return new ArrayList<UploadedFile>(); // TODO
    }

    public void saveMiscCode(MiscCode val)
    {
        getHibernateTemplate().save(val);
    }

    public void updateMiscCode(MiscCode val)
    {
        getHibernateTemplate().update(val);
    }
    
    public void removeMiscCode(MiscCode val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeMiscCode(Long id)
    {
        MiscCode obj = findMiscCodeById(id);
        getHibernateTemplate().delete(obj);
    }

    public List<MiscCode> findAllMiscCode()
    {
        return getHibernateTemplate().find("from MiscCode");
    }
    
    
    public List<MiscCode> findMiscCodeListByTw()
    {
        return getHibernateTemplate().find("from MiscCode where codeName like '%county%' ");
    }
    
    //Admin
    public  boolean  isSuperUser(Long memberid){
    	HashSet<Long> hset=new HashSet<Long>(); 
    	Member m=findMemberById(memberid);
    	Set s=m.getGroups();
    	Iterator its = s.iterator();        		  
 	    while (its.hasNext()) {
 		  Group g= (Group) its.next();
 		  hset.add(g.getId());	
 		  //System.out.println("isSuperUser Group.getId()="+g.getId());
        }
 	    Long user=1L;
 	    if(hset.contains(user)){   	
 	    	//System.out.println("is SuperUser");
 	    	return true;
 		}else{
 			//System.out.println("is not SuperUser");
 			return false;
 		} 
    }
    
    /**產生 Unit Hibernate impl*/
    
    public void saveUnit(Unit val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeUnit(Unit val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeUnit(Long id)
    {
    	Unit obj = findUnitById(id);
        getHibernateTemplate().delete(obj);
    }

    public Unit findUnitById(Long id)
    {
        if (id == null)
            return null;
        Unit obj = (Unit)getHibernateTemplate().get(com.common.value.Unit.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(com.common.value.Unit.class, id);
        else
            return obj;
    }
    
    public List findAllUnit()
    {
        return getHibernateTemplate().find("from Unit");
    }    
    
    public Set getMemberListByIds(Long[] ids)
    {
        Set<Member> al = new HashSet();
        if (ids != null) {
           for(int i=0;i<ids.length;i++){
        	Member m = (Member) findMemberById(ids[i]);
        	System.out.println("getMemberListByIds 加入Member name="+m.getName());
        	al.add(m);
           }
        }
        return al;
    }
    
   public Long[] getIdsFromMemberList(Set tlist)
    {
        ArrayList<Long> al = new ArrayList<Long>();
        if (tlist != null) {
        	Iterator i = tlist.iterator();    	
    		while (i.hasNext()) {
    			Member m= (Member) i.next();               
                al.add(m.getId());
            }    
        }
        Long lng[] = new Long[al.size()];
        al.toArray(lng);
        return lng;
    }
   
   
   public List<Member> getMemberListById(Long[] ids)
   {	  
	   ArrayList<Member> al = new ArrayList<Member>();
       if (ids != null) {
          for(int i=0;i<ids.length;i++){
       	    Member m = (Member) findMemberById(ids[i]);
       	    System.out.println("getMemberListByIds 加入Member name="+m.getName());
       	    al.add(m);
          }
       }
       return al;
   }
   
  public Long[] getIdFromMemberList(List tlist)
   {
       ArrayList<Long> al = new ArrayList<Long>();
       if (tlist != null) {
       	Iterator i = tlist.iterator();    	
   		while (i.hasNext()) {
   			Member m= (Member) i.next();               
               al.add(m.getId());
           }    
       }
       Long lng[] = new Long[al.size()];
       al.toArray(lng);
       return lng;
   }
  
   
   /**職稱管理*/
    
   public void saveGrade(Grade val)
   {
       getHibernateTemplate().saveOrUpdate(val);
   }

   public void removeGrade(Grade val)
   {
       getHibernateTemplate().delete(val);
   }

   public void removeGrade(Long id)
   {
       Grade obj = findGradeById(id);
       getHibernateTemplate().delete(obj);
   }

   public Grade findGradeById(Long id)
   {
       if (id == null)
           return null;
       Grade obj = (Grade)getHibernateTemplate().get(com.common.value.Grade.class, id);
       if (obj == null)
           throw new ObjectRetrievalFailureException(com.common.value.Grade.class, id);
       else
           return obj;
   }

   public List<Grade> findAllGrade()
   {
       return getHibernateTemplate().find("from Grade");
   }
   
   public Set getGradeListByIds(Long[] ids)
   {
       Set<Grade> al = new HashSet();
       if (ids != null) {
          for(int i=0;i<ids.length;i++){
        	  Grade g = (Grade) findGradeById(ids[i]);
              al.add(g);
          }
       }
       return al;
   }
   
   public  Member findMemberByIdWithMD5(String id){
	   Member user = null;

       try {
           Criteria c = getHibernateSession().createCriteria(
                   com.common.value.Member.class);
           c.add(Expression.eq("md5", id));

           List result = c.list();
           if (result.size() > 0)
               user = (Member) result.get(0);           
       }
       catch (HibernateException ex) {
           if ( logger.isErrorEnabled() ) {
               logger.error(ex.getMessage(), ex);
           }

           throw new RuntimeException(ex);
       }
       
       return user;
	   
   }
   
   
   /*
    ************************ 
    * WEBLOG 
    ************************
    */
   public void saveWebLog(WebLog val)
   {
       getHibernateTemplate().saveOrUpdate(val);
   }

   public void removeWebLog(WebLog val)
   {
       getHibernateTemplate().delete(val);
   }

   public void removeWebLog(Long id)
   {
       WebLog obj = findWebLogById(id);
       getHibernateTemplate().delete(obj);
   }

   public WebLog findWebLogById(Long id)
   {
       if (id == null)
           return null;
       WebLog obj = (WebLog)getHibernateTemplate().get(com.common.value.WebLog.class, id);
       if (obj == null)
           throw new ObjectRetrievalFailureException(com.common.value.WebLog.class, id);
       else
           return obj;
   }

   public List<WebLog> findAllWebLog()
   {
       return getHibernateTemplate().find("from WebLog");
   }
   
   /*
    ************************ 
    * 組別管理 
    ************************
   */
   public void saveTeam(Team val)
   {
       getHibernateTemplate().saveOrUpdate(val);
   }

   public void removeTeam(Team val)
   {
       getHibernateTemplate().delete(val);
   }

   public void removeTeam(Long id)
   {
       Team obj = findTeamById(id);
       getHibernateTemplate().delete(obj);
   }

   public Team findTeamById(Long id)
   {
       if (id == null)
           return null;
       Team obj = (Team)getHibernateTemplate().get(com.common.value.Team.class, id);
       if (obj == null)
           throw new ObjectRetrievalFailureException(com.common.value.Team.class, id);
       else
           return obj;
   }

   public List<Team> findAllTeam()
   {
       return getHibernateTemplate().find("from Team");
   }
   public List<Member> findPrimaryLeaderList()
   {
       return new ArrayList<Member>(); // TODO
   }

   public List<Member> findSecondLeaderList()
   {
       return new ArrayList<Member>(); // TODO
   }

   public Long[] getIdsFromMemberList(List tlist)
   {
       ArrayList<Long> al = new ArrayList<Long>();
       if (tlist != null) {
           for (int i = 0; i < tlist.size(); i++) {
               Member t = (Member) tlist.get(i);
               if (t != null)
                   al.add(t.getId());
           }
       }
       Long lng[] = new Long[al.size()];
       al.toArray(lng);
       
       return lng;
   }

   
   public Set getTeamListByIds(Long[] ids)
   {
       Set<Team> al = new HashSet();
       if (ids != null) {
          for(int i=0;i<ids.length;i++){
        	  Team g = (Team) findTeamById(ids[i]);
              al.add(g);
          }
       }
       return al;
   }
   
   
   /*
    ************************ 
    * Industry 
    ************************
   */
   
   public void saveIndustry(Industry val)
   {
       getHibernateTemplate().saveOrUpdate(val);
   }

   public void removeIndustry(Industry val)
   {
       getHibernateTemplate().delete(val);
   }

   public void removeIndustry(Long id)
   {
       Industry obj = findIndustryById(id);
       getHibernateTemplate().delete(obj);
   }

   public Industry findIndustryById(Long id)
   {
       if (id == null)
           return null;
       Industry obj = (Industry)getHibernateTemplate().get(com.common.value.Industry.class, id);
       if (obj == null)
           throw new ObjectRetrievalFailureException(com.common.value.Industry.class, id);
       else
           return obj;
   }

   public List<Industry> findAllIndustry()
   {
       return getHibernateTemplate().find("from Industry");
   }
   
   public Set getIndustryListByIds(Long[] ids)
   {
       Set<Industry> al = new HashSet();
       if (ids != null) {
          for(int i=0;i<ids.length;i++){
        	  Industry g = (Industry) findIndustryById(ids[i]);
              al.add(g);
          }
       }
       return al;
   }
   
   /*
    ************************ 
    * SMSMAIL 
    ************************
   */
   public void saveSmsMailRec(SmsMailRec val)
   {
       getHibernateTemplate().saveOrUpdate(val);
   }
   
   public List<SmsMailRec> findAllSmsMailRec(Member m)   
   {	
       Criteria c = getHibernateSession().createCriteria(com.common.value.SmsMailRec.class);
       c.add(Expression.eq("member", m));       
       c.addOrder(Order.desc("sendDate"));   
      
       List query = c.list();  
       ArrayList<SmsMailRec> al = new ArrayList<SmsMailRec>();
           for (int i = 0; i < query.size(); i++) {
        	   SmsMailRec s=(SmsMailRec) query.get(i);
                  al.add(s);                
           }
       return al;
   }
   
   public SmsMailRec findSmsMailRecById(Long id)
   {
       if (id == null)
           return null;
       SmsMailRec obj = (SmsMailRec) getHibernateTemplate().get(
               com.common.value.SmsMailRec.class, id);
       if (obj == null)
           throw new ObjectRetrievalFailureException(
                   com.common.value.SmsMailRec.class, id);
       else
           return obj;
   }
   
   
   /*
    ************************ 
    * Department 
    ************************
   */
   public void saveDepartment(Department val)
   {
       getHibernateTemplate().saveOrUpdate(val);
   }

   public void removeDepartment(Department val)
   {
       getHibernateTemplate().delete(val);
   }

   public void removeDepartment(Long id)
   {
       Department obj = findDepartmentById(id);
       getHibernateTemplate().delete(obj);
   }

   public Department findDepartmentById(Long id)
   {
       if (id == null)
           return null;
       Department obj = (Department)getHibernateTemplate().get(com.common.value.Department.class, id);
       if (obj == null)
           throw new ObjectRetrievalFailureException(com.common.value.Department.class, id);
       else
           return obj;
   }

   public List<Department> findAllDepartment()
   {
       return getHibernateTemplate().find("from Department");
   }
   
   public Set getDepartmentListByIds(Long[] ids)
   {
       Set<Department> al = new HashSet();
       if (ids != null) {
          for(int i=0;i<ids.length;i++){
        	  Department g = (Department) findDepartmentById(ids[i]);
              al.add(g);
          }
       }
       return al;
   }
   
   
 
}
