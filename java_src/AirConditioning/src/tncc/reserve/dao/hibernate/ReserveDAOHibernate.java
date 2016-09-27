package tncc.reserve.dao.hibernate;

import tncc.power.value.*;
import tncc.reserve.value.*;
import tncc.reserve.dao.ReserveDAO;
import java.util.*;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.ObjectRetrievalFailureException;
import tncc.power.dao.hibernate.PowerDAOHibernate;
import com.base.value.Function;
import com.common.value.Member;

public class ReserveDAOHibernate extends PowerDAOHibernate implements ReserveDAO
{
    //CourseOpen
	public List<CourseOpen> findAllCourseOpen()
    {
        return getHibernateTemplate().find("from CourseOpen");
    }
	
	public List<CourseOpen> findAllCourseOpen(ClassRoom classroom)
    {
		Criteria c = getHibernateSession().createCriteria(CourseOpen.class);
   	    c.add(Expression.eq("classroom", classroom));   	   
   	    return c.list();
    }	
	
	public List<CourseOpen> getCourseOpenListByWeek(ClassRoom classroom,int week)
	{
		Criteria c = getHibernateSession().createCriteria(CourseOpen.class);
   	    c.add(Expression.eq("classroom", classroom));  
   	    c.add(Expression.eq("week", week)); 
   	    c.add(Expression.ne("active", "none"));    	  
   	    return c.list();
	}
	
	//ClassRoom
	
	public List<ClassRoom> getAllClassRooms()
	{
		return getHibernateTemplate().find("from ClassRoom");
	}
	
	public List<ClassRoom> findAllClassRoom()
	{
		ArrayList<ClassRoom> al = new ArrayList<ClassRoom>();
		List<CourseOpen> ls=findAllCourseOpen();
		 for(int i=0;i<ls.size();i++){
			 ClassRoom c=ls.get(i).getClassroom();
			 if(al.contains(c)==false){
				 al.add(c);
			 }	        	
		 }
		return al;
	}
	
	public ClassRoom getClassRoomById(String id)
	{
		 if (id == null)
	            return null;
		 ClassRoom obj = (ClassRoom) getHibernateTemplate().get(ClassRoom.class, id);
	        if (obj == null)
	            throw new ObjectRetrievalFailureException(ClassRoom.class, id);
	        else
	            return obj;
	}
	
	public List<CourseOpen> getClassScheduleWeekly(ClassRoom classroom,int week)
	{
		ArrayList<CourseOpen> al = new ArrayList<CourseOpen>();
		Date now=new Date();
		BasicInfo basicInfo=getBasicInfo();
		if(now.after(basicInfo.getScheduleStart()) && now.before(basicInfo.getScheduleEnd()))
		{
			Criteria c = getHibernateSession().createCriteria(CourseOpen.class);
	   	    c.add(Expression.eq("classroom", classroom));  
	   	    c.add(Expression.eq("week", week));  
	   	    c.addOrder( Order.asc("node") );
	   	    return c.list();
		}else{
			return al;
		}
	}
	
	public List<CourseOpen> getClassScheduleWeekly(Reader reader,int week)
	{
		PowerControllerReader p=new PowerControllerReader();
		Criteria c = getHibernateSession().createCriteria(PowerControllerReader.class);
   	    c.add(Expression.eq("reader", reader));
   	    List ls=c.list();
   	    if(ls.size()>0){
   	    	p=(PowerControllerReader)ls.get(0);
   	    }		 
   	   return getClassScheduleWeekly(p.getClassRoom(),week); 
	}
    
}

