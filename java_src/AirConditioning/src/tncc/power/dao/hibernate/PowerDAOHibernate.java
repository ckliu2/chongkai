package tncc.power.dao.hibernate;

import tncc.power.value.*;
import tncc.power.dao.PowerDAO;

import java.text.DateFormat;
import java.util.*;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate.HibernateTemplate;

import HoneyWell.Device;

import com.base.util.Tools;
import com.base.value.AppProperty;
import com.base.value.Group;
import com.common.value.Member;

import java.sql.*;

import tncc.wpc.dao.hibernate.wpcDAOHibernate;
import tncc.wpc.value.Building;

public class PowerDAOHibernate extends wpcDAOHibernate implements PowerDAO
{

    public PowerDAOHibernate()
    {
    }

    //Controller
    
    public void savePowerController(PowerController val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removePowerController(PowerController val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removePowerController(Long id)
    {
        PowerController obj = findPowerControllerById(id);
        getHibernateTemplate().delete(obj);
    }

    public PowerController findPowerControllerById(Long id)
    {
        if (id == null)
            return null;
        PowerController obj = (PowerController)getHibernateTemplate().get(tncc.power.value.PowerController.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(tncc.power.value.PowerController.class, id);
        else
            return obj;
    }
    
    public List<PowerControllerReader> getReaderByController(PowerController powerController)
    {
    	Criteria c = getHibernateSession().createCriteria(PowerControllerReader.class);
   	    c.add(Expression.eq("powerController", powerController));
   	    return c.list();
    }
    

    public List<PowerController> findAllPowerController()
    {
        return getHibernateTemplate().find("from PowerController");
    }

    
    public Long[] getIdsFromReaderList(List tlist)
    {
        ArrayList<Long> al = new ArrayList<Long>();
        if (tlist != null) {
            for (int i = 0; i < tlist.size(); i++) {
                Reader t = (Reader) tlist.get(i);
                if (t != null)
                    al.add(t.getId());
            }
        }
        Long lng[] = new Long[al.size()];
        al.toArray(lng);
        
        return lng;
    }

    public List getReaderListByIds(Long[] ids)
    {
        ArrayList<Reader> al = new ArrayList<Reader>();
        if (ids != null) {
            for (int i = 0; i < ids.length; i++) {
                Reader t = (Reader) findReaderById(ids[i]);
                if (t != null)
                    al.add(t);
            }
        }
        return al;
    }
    
    
    public List<PowerController> getPowerControllerListByDeviceType(AppProperty device)
    {
    	Criteria c = getHibernateSession().createCriteria(PowerController.class);
   	c.add(Expression.eq("deviceType", device));   
   	c.add(Expression.eq("active", true));  
   	return c.list();
    }
    
    
    //Reader
    public void saveReader(Reader val)
    {	
	try{
	getHibernateSession().connection().setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
	getHibernateTemplate().saveOrUpdate(val);
	}catch(Exception e){
	    System.out.println("hiber saveReader error="+e.toString());
	}
    }

    public void removeReader(Reader val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeReader(Long id)
    {
        Reader obj = findReaderById(id);
        getHibernateTemplate().delete(obj);
    }

    public Reader findReaderById(Long id)
    {
        if (id == null)
            return null;
        Reader obj = (Reader)getHibernateTemplate().get(tncc.power.value.Reader.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(tncc.power.value.Reader.class, id);
        else
            return obj;
    }  
    
    public List<Reader> findAllReader()
    {
        return getHibernateTemplate().find("from Reader order by seqName asc");
    }


    public List<Reader> findAllReaderByG50()
    {
    	ArrayList<Reader> readers=new ArrayList<Reader>();
    	Criteria c = getHibernateSession().createCriteria(Space.class);
        c.add(Expression.eq("readerType", findAppPropertyById(45L))); 
        List ls=c.list();
        for(int i=0;i<ls.size();i++)
        {
        	Space s=(Space)ls.get(i);
        	//List a=s.getReader();
        	//for(int)
        	readers.addAll(s.getReader());
        }        
        return readers;
    }
    
    public List<Reader> findAllReaderByDevice(AppProperty Device)
    {
    	ArrayList<Reader> readers=new ArrayList<Reader>();
    	Criteria c = getHibernateSession().createCriteria(Space.class);
        c.add(Expression.eq("readerType", Device)); 
        List ls=c.list();
        for(int i=0;i<ls.size();i++)
        {
        	Space s=(Space)ls.get(i);
        	readers.addAll(s.getReader());
        }        
        return readers;
    }
    
       
    public Reader findReaderByName(String name)
    {
    	Reader reader = null;

        try {
            Criteria c = getHibernateSession().createCriteria(Reader.class);
            c.add(Expression.eq("name", name));          
            List result = c.list();
            if (result.size() > 0)
            	reader = (Reader) result.get(0);           
        }
        catch (HibernateException ex) {
            if ( logger.isErrorEnabled() ) {
                logger.error(ex.getMessage(), ex);
            }

            throw new RuntimeException(ex);
        }
        
        return reader;
    }
    
    public void syncReader()
    {
      try{
	 /*
    	 System.out.println("hiber syncReader.."); 
       	 //Connection conn=getHibernateSession().connection();
       	 Connection conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=AirConditioning_0421","chongkai","2aixujxu");
       	 Statement Stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
       	 Stmt.execute(" dbo.SyncReader ");
         conn.close();
         */
      }catch(Exception e){
       	 System.out.println(e.toString());
      }
      
    }
    
    public PowerController getPowerControllerByReader(Reader val)
    {
    	PowerController pc=new PowerController();
    	List<PowerController> powerController=findAllPowerController();
    	for(int i=0;i<powerController.size();i++){
    		PowerController pcl=powerController.get(i);
    		List<Reader> reader=pcl.getReader();
    		 for(int j=0;j<reader.size();j++){
    			 Reader m=reader.get(j);
    			 //System.out.println("getPowerControllerByReader="+m.getId()+"--"+val.getId());
    			  if(String.valueOf(m.getId()).equals( String.valueOf(val.getId()) )){
    				  //System.out.println(pcl+" hiber getPowerControllerByReader");    	    			 
    				  //pc=pcl;
    				  return pcl;
    			  }
    		 }

    	}
    	
    	return pc;
    }
    
    public PowerControllerReader findPowerControllerReaderById(String id)
    {
        if (id == null)
            return null;
        PowerControllerReader obj = (PowerControllerReader)getHibernateTemplate().get(PowerControllerReader.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(PowerControllerReader.class, id);
        else
            return obj;
    }
    
    public PowerControllerReader getReaderByControllerDeviceNo(PowerController powerController,int deviceNo)
    {
    	Criteria c = getHibernateSession().createCriteria(PowerControllerReader.class);
   	    c.add(Expression.eq("powerController", powerController));
   	    c.add(Expression.eq("deviceNo", deviceNo));
   	    List result = c.list();
   	    if (result.size() > 0){
   	    	PowerControllerReader p = (PowerControllerReader) result.get(0);
   	    	return p;
   	    }else{
   	    	return null;
   	    }        	
    }
    
    public PowerControllerReader getReaderByControllerDeviceNo(Reader reader)
    {
    	Criteria c = getHibernateSession().createCriteria(PowerControllerReader.class);
   	    c.add(Expression.eq("reader", reader));   	  
   	    List result = c.list();
   	    if (result.size() > 0){
   	    	PowerControllerReader p = (PowerControllerReader) result.get(0);
   	    	return p;
   	    }else{
   	    	return null;
   	    } 
    }
    
    public SpaceReader findSpaceReaderById(Long id)
    {
        if (id == null)
            return null;
        SpaceReader obj = (SpaceReader)getHibernateTemplate().get(SpaceReader.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(SpaceReader.class, id);
        else
            return obj;
    }

    
    public List<SpaceReader> getReaderListBySpace(Space space)
    {
    	ArrayList<Reader> al = new ArrayList<Reader>();
    	Criteria c = getHibernateSession().createCriteria(SpaceReader.class);
   	    c.add(Expression.eq("space", space));
   	    c.addOrder(Order.asc("seqName"));
   	    return c.list(); 
    }
    
    public List<SpaceReader> getReaderListBySpace(Space space,AppProperty state)
    {
    	ArrayList<Reader> al = new ArrayList<Reader>();
    	Criteria c = getHibernateSession().createCriteria(SpaceReader.class);
   	    c.add(Expression.eq("space", space));
   	    if(state!=null){
   	      c.add(Expression.eq("state", state));
   	    }
   	    c.addOrder(Order.asc("seqName"));
   	    return c.list(); 
    }
    
    //Space
    public void saveSpace(Space val)
    {    	
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeSpace(Space val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeSpace(Long id)
    {
        Space obj = findSpaceById(id);
        getHibernateTemplate().delete(obj);
    }

    public Space findSpaceById(Long id)
    {
        if (id == null)
            return null;
        Space obj = (Space)getHibernateTemplate().get(tncc.power.value.Space.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(tncc.power.value.Space.class, id);
        else
            return obj;
    }

    public List<Space> findAllSpace()
    {
        return getHibernateTemplate().find("from Space");
    }
    
    public List<Space> getSpaceListByAir(AppProperty air)
    {
    	Criteria c = getHibernateSession().createCriteria(Space.class);
   	    c.add(Expression.eq("readerType", air));
   	    List result = c.list();
   	    return result;
    }
    
    //取得節電空間
    public  Space getSpaceByBuilding(Long id){
    	 Space space=new Space();
    	 Criteria c = getHibernateSession().createCriteria(Space.class);
    	 c.add(Expression.eq("building", findBuildingById(id)));
    	 List result = c.list();
    	 if (result.size() > 0){
    		 space = (Space) result.get(0);    
    	 }
    	 return space;
    }
    
    //BasicInfo
    
    public void saveBasicInfo(BasicInfo val)
    {
    	getHibernateTemplate().saveOrUpdate(val);   
    }

    public void removeBasicInfo(BasicInfo val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeBasicInfo(Long id)
    {
        BasicInfo obj = findBasicInfoById(id);
        getHibernateTemplate().delete(obj);
    }

    public BasicInfo findBasicInfoById(Long id)
    {
        if (id == null)
            return null;
        BasicInfo obj = (BasicInfo)getHibernateTemplate().get(tncc.power.value.BasicInfo.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(tncc.power.value.BasicInfo.class, id);
        else
            return obj;
    }

    public List<BasicInfo> findAllBasicInfo()
    {
        return getHibernateTemplate().find("from BasicInfo");
    }
    
    public BasicInfo getBasicInfo()
    {
    	BasicInfo b=new BasicInfo();
   	    Criteria c = getHibernateSession().createCriteria(BasicInfo.class);
   	    c.add(Expression.eq("flag", 1));
   	    List result = c.list();
   	    if (result.size() > 0){
   		 b = (BasicInfo) result.get(0);    
   	    }
   	    return b;
    }
    
    //Shutdown
    public void saveShutdown(Shutdown val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeShutdown(Shutdown val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeShutdown(Long id)
    {
        Shutdown obj = findShutdownById(id);
        getHibernateTemplate().delete(obj);
    }

    public Shutdown findShutdownById(Long id)
    {
        if (id == null)
            return null;
        Shutdown obj = (Shutdown)getHibernateTemplate().get(tncc.power.value.Shutdown.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(tncc.power.value.Shutdown.class, id);
        else
            return obj;
    }

    public List<Shutdown> findAllShutdown()
    {
        return getHibernateTemplate().find("from Shutdown");
    }
    
    //EvenLog
    
    public void saveEvenLog(EvenLog val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }
    
    public List<EvenLog> findAllEvenLog()
    {
        return getHibernateTemplate().find("from EvenLog order by createdDate desc");
    }
    
    public  EvenLog getEvenLogLastTime(){
    	EvenLog e=null;
    	Query query = getHibernateSession().createQuery("from EvenLog order by createdDate desc");
    	List result =query.list();
    	if (result.size() > 0){
            e = (EvenLog) result.get(0);           
        }
    	return e;
    }
    
    public  boolean isAlert(int gap){
    
    	Date now=Tools.getCurrentTimestamp();
    	Long s=now.getTime()-gap*60000;
    	Date pass = new Date(s);       	
   	    Criteria c = getHibernateSession().createCriteria(EvenLog.class);
   	    c.add(Expression.eq("alertmsg", true));
	    c.add(Expression.between("createdDate", pass, now));
	    List result = c.list();  
	    
    	System.out.println("now="+now);
    	System.out.println("pas="+pass);
	    System.out.println("result.size()="+result.size());
	    
	     if(result.size()==0){
	    	 return true;
	     }else{
	    	 return false;
	     }   	
    }
    
    //CommandLog
    public void saveCommandLog(CommandLog val)
    {
        getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeCommandLog(CommandLog val)
    {
        getHibernateTemplate().delete(val);
    }
    
    public void removeCommandLogByReader(Reader reader)
    {
    	Criteria c = getHibernateSession().createCriteria(CommandLog.class);
   	    c.add(Expression.eq("reader", reader));	   
	    List result = c.list();  
	    for(int i=0;i<result.size();i++){
	    	CommandLog log=(CommandLog)result.get(i);
	    	removeCommandLog(log);
	    }
    }
    
    //ScheduleDaily
    public void saveScheduleDaily(ScheduleDaily val)
    {    	
	//System.out.println("hiber saveScheduleDaily="+val.getId()+"--active="+val.getActive()+"--ip="+val.getIp());
    	getHibernateTemplate().saveOrUpdate(val);
    }

    public void removeScheduleDaily(ScheduleDaily val)
    {
        getHibernateTemplate().delete(val);
    }

    public void removeScheduleDaily(Long id)
    {
    	//清除LOG記錄
    	try{
         Connection conn=getHibernateSession().connection();    	
         Statement Stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
         Stmt.execute(" DELETE POWER_Log where scheduleDaily="+id);
         conn.close();
      	}catch(Exception e){
         		System.out.println(e.toString());
        }
    	
    	
        ScheduleDaily obj = findScheduleDailyById(id);
        getHibernateTemplate().delete(obj);
    }

    public ScheduleDaily findScheduleDailyById(Long id)
    {
        if (id == null)
            return null;
        ScheduleDaily obj = (ScheduleDaily)getHibernateTemplate().get(tncc.power.value.ScheduleDaily.class, id);
        if (obj == null)
            throw new ObjectRetrievalFailureException(tncc.power.value.ScheduleDaily.class, id);
        else
            return obj;
    }

    public List<ScheduleDaily> findScheduleDailyById(Reader reader)
    {	///*and s.readers in(:r)*/
    	String hsql = "select s from ScheduleDaily s where s.scheduledDate=:sdate  and s.readers in(:r) order by s.id desc ";  	
    	Query query = getHibernateSession().createQuery(hsql);     	
		query.setParameter("sdate", Tools.convertToDateTime("2013-10-25 00:00"));
		query.setParameter("r",reader.getId());
		return query.list();
		//return getHibernateTemplate().find("from ScheduleDaily");
    }
    
  //ScheduleReaderDaily
    public  List<ScheduleReaderDaily> getScheduleListByReader(Reader reader,Date scheduledDate) 
    {    	
    	ArrayList<ScheduleReaderDaily> al = new ArrayList<ScheduleReaderDaily>();
    	Date start,end;
    	String mydate=(scheduledDate.getYear()+1900)+"/"+(scheduledDate.getMonth()+1)+"/"+scheduledDate.getDate();
  	    System.out.println("hiber scheduledDate mydate="+mydate);
 	 	try{
    	 DateFormat df = DateFormat.getDateInstance();
    	 start = df.parse(mydate);
    	 end = df.parse(mydate);
    	 start.setHours(0);
         start.setMinutes(0);
         start.setSeconds(0);	        
         end.setHours(23);
         end.setMinutes(59);
         end.setSeconds(59);	
         String hsql="select s from ScheduleReaderDaily s where reader=:reader and scheduledDate between :s and :e order by scheduledDate desc";
         
         System.out.println("hiber getScheduleListByReader start="+start);
         System.out.println("hiber getScheduleListByReader end="+end);
         
         Query query = getHibernateSession().createQuery(hsql);  
         query.setParameter("reader", reader);
         query.setParameter("s", start);
  	     query.setParameter("e", end);
  	     return query.list(); 
    	}catch(Exception e){
    		return al;
    	}
    }
    public  List<ScheduleReaderDaily> getScheduleListByReaderActive(Reader reader,boolean active)
    {
    	Criteria c = getHibernateSession().createCriteria(ScheduleReaderDaily.class);
   	    c.add(Expression.eq("reader", reader));
   	    c.add(Expression.eq("active", active));
	    return c.list(); 
    }
    
    public Long[] getIdsFromScheduleReader(Set tlist)
    {
    	System.out.println("hiber getIdsFromScheduleReader..");
    	ArrayList<Long> al = new ArrayList<Long>();
        if (tlist != null) {   
            Iterator i = tlist.iterator(); 
	    		 while (i.hasNext()) {
	    			 Reader u= (Reader) i.next();  
	    			 System.out.println("hiner Reader="+u.getId());
	            	 al.add(u.getId());
	    		 }
        }
        Long lng[] = new Long[al.size()];
        al.toArray(lng);
        return lng;   
    }
    
    public List<ScheduleReaderDaily> getScheduleListByDate(Date date,boolean active)
    {    	
    	Date start=new Date();
        Date end=new Date();	        
        start.setHours(0);
        start.setMinutes(0);
        start.setSeconds(0);	        
        end.setHours(23);
        end.setMinutes(59);
        end.setSeconds(59);	            
    	Criteria c = getHibernateSession().createCriteria(ScheduleReaderDaily.class);
    	c.add(Expression.between("scheduledDate",start, end));
   	    c.add(Expression.eq("active", active));
   	    c.addOrder(Order.asc("scheduledDate"));
	    return c.list();
    }
    
    public List<Reader> getScheduleListByReader(Date date)
    {
    	//System.out.println("hiber getScheduleListByReader..");
    	Date start=new Date();
        Date end=new Date();	        
        start.setHours(0);
        start.setMinutes(0);
        start.setSeconds(0);	        
        end.setHours(23);
        end.setMinutes(59);
        end.setSeconds(59);	        
   	  
        String hsql = "select f from ScheduleReaderDaily f where f.scheduledDate between :start and :end and active=:active  ";
   	    Query query = getHibernateSession().createQuery(hsql);     	
		query.setParameter("start", start);
		query.setParameter("end", end);	
		List ls=query.list();
		ArrayList<Reader> al = new ArrayList<Reader>();		
		for(int i=0;i<ls.size();i++){
			ScheduleReaderDaily s=(ScheduleReaderDaily)ls.get(i);			
			if(al.contains(s.getReader())==false){				
			  al.add(s.getReader());
			}
		}
		return al;
    }
    
    public List<Reader> getScheduleListByReader(Date date,boolean active)
    {
    	//System.out.println("hiber getScheduleListByReader..");
    	Date start=new Date();
        Date end=new Date();	        
        start.setHours(0);
        start.setMinutes(0);
        start.setSeconds(0);	        
        end.setHours(23);
        end.setMinutes(59);
        end.setSeconds(59);	        
   	  
        String hsql = "select f from ScheduleReaderDaily f where f.scheduledDate between :start and :end and active=:active";
   	    Query query = getHibernateSession().createQuery(hsql);     	
		query.setParameter("start", start);
		query.setParameter("end", end);		
		query.setParameter("active", active);	
		List ls=query.list();
		ArrayList<Reader> al = new ArrayList<Reader>();		
		for(int i=0;i<ls.size();i++){
			ScheduleReaderDaily s=(ScheduleReaderDaily)ls.get(i);			
			if(al.contains(s.getReader())==false){				
			  al.add(s.getReader());
			}
		}
		return al;
    }
    
    public void scheduleReaderDailyResetByReader(Date date,Reader reader)
    {
    	List<ScheduleReaderDaily> ls=getScheduleListByDate(date,reader);
    	for(int i=0;i<ls.size();i++){
    		ScheduleReaderDaily s=ls.get(i);
    		ScheduleDaily daily=s.getScheduleDaily();
    		daily.setActive(false);
    		saveScheduleDaily(daily);
    	}
    	
    	 //Email
    	/*
    	 String subject=reader.getName()+" Poling有問題";
         String content=reader.getName()+" Poling結果與DB記錄不一致,已強制修正 [ "+Tools.getCurrentTimestamp()+"]";
         Group g=findGroupById(1L); //系統管理者
         Set members=g.getMembers();
         if(members!=null){
    	   Iterator i = members.iterator(); 
    	     while (i.hasNext()) {
    	      Member member= (Member) i.next();   
    	      sendMail(member.getEmail(),subject,content);
    	     }
         }
         */
    }
    
    public List<ScheduleReaderDaily> getScheduleListByDate(Date date,Reader reader)
    {
    	Date start=new Date();
        Date end=new Date();	        
        start.setHours(0);
        start.setMinutes(0);
        start.setSeconds(0);	        
        end.setHours(23);
        end.setMinutes(59);
        end.setSeconds(59);	         
   	    String hsql = "select f from ScheduleReaderDaily f where f.scheduledDate between :start and :end  and reader = :reader order by scheduledDate asc";
   	    Query query = getHibernateSession().createQuery(hsql);     	
		query.setParameter("start", start);
		query.setParameter("end", end);
		query.setParameter("reader", reader);
		return query.list();
    }
    
    public void copyWeeklyToDaily()
    {
    	try{
         	  Connection conn=getHibernateSession().connection();    	
         	  Statement Stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
         	  Stmt.execute(" dbo.copyWeeklyToDaily ");
            conn.close();
      	}catch(Exception e){
         		System.out.println(e.toString());
        }
    }
    
    //Log
    public void saveLog(Log val)
    {
	try{
		getHibernateSession().connection().setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
		getHibernateTemplate().saveOrUpdate(val);
	   }catch(Exception e){
		    System.out.println("hiber saveReader error="+e.toString());
	   }
    	
    }
    
    public boolean haveLog(ScheduleDaily scheduleDaily,Reader reader)
    {
    	Criteria c = getHibernateSession().createCriteria(Log.class);
    	c.add(Expression.eq("scheduleDaily", scheduleDaily));
    	c.add(Expression.eq("reader", reader));
    	if (c.list().size()==0)
    	{
    		return false;
    	}else
    	{
    		return true;
    	}
    }
    
    public List<Log> findAllLog()
    {
        return getHibernateTemplate().find("from Log order by createdDate desc");
    }
    
    public synchronized List<Log> getLogList(Date start,Date end,AppProperty logtype,String msg,int pageSize,int pageIndex)
    {
    	Criteria c = getHibernateSession().createCriteria(Log.class);
    	c.add(Restrictions.between("createdDate", start, end));    	
    	c.setFirstResult(pageSize * pageIndex); 
    	c.setMaxResults(pageSize);
    	
    	if(logtype!=null){
      	  c.add(Expression.eq("type", logtype));
      	}
    	
    	if(msg!=null && !msg.equals("")){
    		c.add(Restrictions.like("msg", "%"+msg+"%"));
    	}
    	
    	c.addOrder(Order.desc("createdDate"));
    	return c.list(); 
    }
    
    public int getLogListRresultSize(Date start,Date end,AppProperty logtype,String msg)
    {
	Criteria c = getHibernateSession().createCriteria(Log.class);
    	c.add(Restrictions.between("createdDate", start, end));  
    	if(logtype!=null){
      	  c.add(Expression.eq("type", logtype));
      	}    	
    	if(msg!=null && !msg.equals("")){
    		c.add(Restrictions.like("msg", "%"+msg+"%"));
    	}  
    	ScrollableResults scr = c.scroll();
    	scr.last();
    	int rowCount = scr.getRowNumber() + 1;
    	//System.out.println("rowCount="+rowCount);
    	return rowCount; 
    }
    
    //ClearDaily
    public List<ClearDaily> getClearDailyList()
    {
    	return getHibernateTemplate().find("from ClearDaily");
    }
    
    public void readerState(){    	
    	try{
    	  /*  
       	  Connection conn=getHibernateSession().connection();    	
       	  Statement Stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
       	  Stmt.execute(" dbo.readerState ");
          conn.close();
          */
    	}catch(Exception e){
       		System.out.println(e.toString());
       	}
    }
    
    public Reader currentReaderState(Long readerId,boolean status)
    {
    	Reader reader=null;
    	try{
         Connection conn=getHibernateSession().connection();    	
         Statement Stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
         int s;
         if(status==true){
        	 s=1;
         }else{
        	 s=0;
         }
         String sql=" dbo.currentReaderState '"+readerId+"' ,'"+s+"' ";
         System.out.println("hiber currentReaderState sql="+sql);
         Stmt.execute(sql);
        
         reader=findReaderById(readerId);
         String sql1="SELECT * FROM POWER_Reader where id="+readerId;
         ResultSet result = Stmt.executeQuery(sql1); 
         result.last(); 
         String state=result.getString("state");
         String powerstatus=result.getString("powerstatus");
         String information=result.getString("information");
         reader=findReaderById(readerId);
         reader.setState(findAppPropertyById(Long.parseLong(state)));
         reader.setInformation(information);
         if(powerstatus.equals("0")){
           reader.setPowerstatus(false);
         }else{
           reader.setPowerstatus(true); 
         }  
         result.close();         
         conn.close();
  
      	}catch(Exception e){
         		System.out.println("hiber="+e.toString());
        }      	
      	return reader;
    }
    
    public boolean isClearDaily(Reader reader)
    {
    	Criteria c = getHibernateSession().createCriteria(ClearDaily.class);
    	c.add(Expression.eq("reader", reader));
    	if (c.list().size()==0)
    	{
    		return false;
    	}else
    	{
    		return true;
    	}
    }
    
    public List<Reader> getlastModifiedDateReaders(Timestamp start)
    {
    	Criteria c = getHibernateSession().createCriteria(Reader.class);
    	c.add(Expression.gt("lastModifiedDate", start));
    	return c.list();
    }
    
    public void sendMail(String email,String subject,String content){
    	try{
            Connection conn=getHibernateSession().connection();    	
            Statement Stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql="dbo.sendMail '"+email+"','"+subject+"','"+content+"'";
            Stmt.execute(sql);
            conn.close();
      	}catch(Exception e){
           System.out.println(e.toString());
        }
    }
    
    
    //HoneyWell
    public Vector getHoneyWellManualStatus(Reader reader)
    {
    	Vector vc=new Vector();
    	Date d=null;
    	int s=0;
    	try{
    		Date now=Tools.getCurrentTimestamp();
    		Criteria c = getHibernateSession().createCriteria(Log.class);
       	    c.add(Expression.eq("reader", reader)); 
       	    c.add(Expression.eq("type", findAppPropertyById(85L))); 
       	    c.add(Expression.le("createdDate", now));         	    
       	    c.add(Expression.ge("createdDate",Tools.getTodaydate1()));
       	    c.add(Expression.le("createdDate",Tools.getTodaydate2()));        	    
       	    c.addOrder(Order.desc("createdDate"));
       	    List result = c.list();   
       	    if (result.size() > 0){ 
       	    	Log log=(Log)result.get(0);
       	    	d=log.getCreatedDate();
       	    	if(log.getMsg().indexOf("開啟")!=-1)
       	    	{
       	    		s=1;        	    		
       	    	}else{
       	    		s=2;
       	    	}
       	    }
    	}catch(Exception e){
           System.out.println("getHoneyWellManualStatus error="+e.toString());
        }
    	vc.add(s);
    	vc.add(d);
    	return vc;
    }
    
    //HoneyWell
    public Device getHoneyWellCurrentStatus(Reader reader)
    {
    	Device d=new Device();
    	try{    		
    	    Date now=Tools.getCurrentTimestamp();
    	    Criteria c = getHibernateSession().createCriteria(ScheduleReaderDaily.class);
    	    c.add(Restrictions.between("scheduledDate", Tools.getTodaydate1(), Tools.getTodaydate2()));
   	    c.add(Expression.eq("reader", reader)); 
       	    c.add(Expression.le("scheduledDate", now));       	    
       	    c.addOrder(Order.desc("scheduledDate"));
       	    List result = c.list();  
       	    String lock="";       	    
       	    //System.out.println(reader.getName()+"--result.size()="+result.size()+"-s="+Tools.formatSimpleDate2(Tools.getTodaydate1())+"-e="+Tools.formatSimpleDate2(Tools.getTodaydate2())+"--"+Tools.formatSimpleDate2(now));       	    
       	    if (result.size() > 0){   
       	    	ScheduleReaderDaily s=(ScheduleReaderDaily)result.get(0);  
       	    	//System.out.println("getHoneyWellCurrentStatus id="+s.getId());
       	    	d.setDrive(s.getScheduleDaily().getDrive().getValueUs());
       	    	d.setSetTemp(String.valueOf(s.getScheduleDaily().getTemp())+"0");
       	    	d.setMode(s.getScheduleDaily().getMode().getValueUs());       	    	
       	    	d.setFanSpeed(s.getScheduleDaily().getFanSpeed().getValueUs());
       	    	d.setLock(s.getScheduleDaily().getLock().getValueUs());   
       	    	d.setScheduledDate(s.getScheduledDate());       	    	
       	    	d.setScheduleReaderDaily(s);  
       	        //System.out.println("ScheduleDaily.id="+s.getScheduleDaily().getId());
       	        //System.out.println("Drive="+s.getScheduleDaily().getDrive().getValueUs());
                d.setScheduledaily(s.getScheduleDaily());       	    	
       	    }else{
       		//System.out.println("當日無排程");
       		d.setDrive("OFF");
       		d.setSetTemp(String.valueOf(reader.getTemp()));
       		d.setMode(reader.getMode().getValueUs());
       		d.setFanSpeed("0");
       		d.setLock(reader.getLock().getValueUs());    
       		lock="0";
       	    }
       	    //String statusCode=d.getDrive()+"-"+d.getMode()+"-"+d.getSetTemp()+"0-"+d.getFanSpeed()+"-"+lock;
  	    //d.setStatusCode(statusCode);     
    	}catch(Exception e){
           System.out.println("getHoneyWellCurrentStatus error="+e.toString()+"--reader="+reader.getName());
        }
    	return d;
    }
    
    //DEM510C
    public int getDEM510CCurrentStatus(Reader reader)
    {
	int r;
	try{    		
    	    Date now=Tools.getCurrentTimestamp();
    	    Criteria c = getHibernateSession().createCriteria(ScheduleReaderDaily.class);
    	    c.add(Restrictions.between("scheduledDate", Tools.getTodaydate1(), Tools.getTodaydate2()));
   	    c.add(Expression.eq("reader", reader)); 
       	    c.add(Expression.le("scheduledDate", now));       	    
       	    c.addOrder(Order.desc("scheduledDate"));
       	    List result = c.list();  
       	    String lock="";       	    
       	    //System.out.println(reader.getName()+"--result.size()="+result.size()+"-s="+Tools.formatSimpleDate2(Tools.getTodaydate1())+"-e="+Tools.formatSimpleDate2(Tools.getTodaydate2())+"--"+Tools.formatSimpleDate2(now));       	    
       	    if (result.size() > 0){   
       	    	ScheduleReaderDaily s=(ScheduleReaderDaily)result.get(0);  
       	        System.out.println("getDEM510CCurrentStatus s.getScheduleDaily().getId()="+s.getScheduleDaily().getId());
       	    	String code=s.getScheduleDaily().getDrive().getValueUs();
       	    	if(code.equals("ON")){
       	    	 r=1;  
       	    	}else{
       	    	 r=0;  
       	    	}
       	    }else{
       		r=0;       		
       	    }       	   
    	}catch(Exception e){
           System.out.println("getDEM510CCurrentStatus error="+e.toString()+"--reader="+reader.getName());
           r=1;
    	}
	return r;
    }
    
    
}

