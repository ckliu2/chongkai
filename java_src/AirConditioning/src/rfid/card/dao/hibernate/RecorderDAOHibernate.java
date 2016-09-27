package rfid.card.dao.hibernate;

import rfid.card.value.*;
import com.common.value.*;
import rfid.card.dao.RecorderDAO;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.ObjectRetrievalFailureException;
import com.common.dao.hibernate.CommonDAOHibernate;
import com.base.value.AppProperty;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Nov 18 14:22:25 CST 2009
*/

public class RecorderDAOHibernate extends CommonDAOHibernate implements RecorderDAO
{

    public RecorderDAOHibernate()
    {
    }

    public void saveRecorder(Recorder val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeRecorder(Recorder val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeRecorder(Long id)
    {
        Recorder obj = findRecorderById(id);
        getHibernateTemplate().delete(obj);
    }

    public Recorder findRecorderById(Long id)
    {
        if (id == null)
            return null;
        Recorder obj = (Recorder)getHibernateTemplate().get(rfid.card.value.Recorder.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(rfid.card.value.Recorder.class, id);
        else
            return obj;
    }

    public List<Recorder> findAllRecorderSave()
    {
        return getHibernateTemplate().find("from Recorder where kind in(1,8) order by createdDate desc");
    }
    
    public List<Recorder> findRecorderByMember(Member m)
    {     
      ArrayList<Recorder> al = new ArrayList<Recorder>();      
  	  try{
      Criteria c = getHibernateSession().createCriteria(rfid.card.value.Recorder.class);
  	  c.add(Expression.eq("member", m));
  	  c.addOrder( Order.desc("createdDate") );

         List result = c.list();
         for(int i=0;i<result.size();i++){
        	 Recorder r=(Recorder)result.get(i);
             al.add(r);   
         }    	
    	return al;
  	  }catch(Exception e){
  		return al;
  	  }
    }
    
    
    public List<Recorder> findRecorderSaveByDate(Date beginDate,Date endDate)
    {     
      ArrayList<Recorder> al = new ArrayList<Recorder>();      
  	  try{
      Criteria c = getHibernateSession().createCriteria(rfid.card.value.Recorder.class);
      
      
      beginDate.setHours(0);
      beginDate.setMinutes(0);
      beginDate.setSeconds(0);
      
      endDate.setHours(23);
      endDate.setMinutes(59);
      endDate.setSeconds(59);
      
      List<AppProperty> kindList = new ArrayList<AppProperty>();
      kindList.add(findAppPropertyById(1L));
      kindList.add(findAppPropertyById(8L));

      c.add(Expression.in("kind", kindList));
      
      System.out.println("Hiber endDate="+endDate);
      c.add(Expression.between("createdDate", beginDate, endDate));
  	  
         List result = c.list();
         for(int i=0;i<result.size();i++){
        	 Recorder r=(Recorder)result.get(i);
             al.add(r);   
         }    	
    	return al;
  	  }catch(Exception e){
  		return al;
  	  }
    }
    
    
    public List<Recorder> findRecorderDisByDate(Date beginDate,Date endDate)
    {     
      ArrayList<Recorder> al = new ArrayList<Recorder>();      
  	  try{
      Criteria c = getHibernateSession().createCriteria(rfid.card.value.Recorder.class);
      
      
      beginDate.setHours(0);
      beginDate.setMinutes(0);
      beginDate.setSeconds(0);
      
      endDate.setHours(23);
      endDate.setMinutes(59);
      endDate.setSeconds(59);
      
      List<AppProperty> kindList = new ArrayList<AppProperty>();
      kindList.add(findAppPropertyById(2L));
      kindList.add(findAppPropertyById(9L));

      c.add(Expression.in("kind", kindList));
      
      System.out.println("Hiber endDate="+endDate);
      c.add(Expression.between("createdDate", beginDate, endDate));
  	  
         List result = c.list();
         for(int i=0;i<result.size();i++){
        	 Recorder r=(Recorder)result.get(i);
             al.add(r);   
         }    	
    	return al;
  	  }catch(Exception e){
  		return al;
  	  }
    }
    
    public List<Member> findMemberList()
    {
        return new ArrayList<Member>(); // TODO
    }
    
   //Machine
    public void saveMachine(Machine val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeMachine(Machine val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeMachine(Long id)
    {
        Machine obj = findMachineById(id);
        getHibernateTemplate().delete(obj);
    }

    public Machine findMachineById(Long id)
    {
        if (id == null)
            return null;
        Machine obj = (Machine)getHibernateTemplate().get(rfid.card.value.Machine.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(rfid.card.value.Machine.class, id);
        else
            return obj;
    }

    public List<Machine> findAllMachine()
    {
        return getHibernateTemplate().find("from Machine");
    }
    
    public List<Machine> findAllMachineByMember(Member member)
    {
        ArrayList<Machine> al = new ArrayList<Machine>();      
    	  try{
        Criteria c = getHibernateSession().createCriteria(rfid.card.value.Machine.class);
        c.add(Expression.eq("member", member ));
    	c.addOrder(Order.desc("createdDate"));  
           List result = c.list();
           for(int i=0;i<result.size();i++){
        	   Machine r=(Machine)result.get(i);
        	   //System.out.println("findAllMachineByMember="+r.getCreatedDate());
               al.add(r);   
           }    	
      	return al;
    	  }catch(Exception e){
    		return al;
    	  }
    }

    

}

