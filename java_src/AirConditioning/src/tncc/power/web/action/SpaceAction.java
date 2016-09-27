package tncc.power.web.action;

import tncc.power.value.*;
import tncc.power.service.PowerManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.AppProperty;
import com.base.value.Function;
import com.base.value.SessionUser;
import tncc.wpc.value.*;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Tue Mar 30 11:34:38 CST 2010
*/

public class SpaceAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Space space;
    private Long[] readerIds;
    private Long[] selectedSpaceIds;
	private ScheduleDaily scheduleDaily;
	Set<Reader> readers = new HashSet();

    public SpaceAction()
    {
        log = LogFactory.getLog(tncc.power.web.action.SpaceAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("SPACE");
    }

    public Space getSpace()
    {
        return space;
    }

    public void setSpace(Space val)
    {
        space = val;
    }

    public void setGenericManager(PowerManager m)
    {
        super.setGenericManager(m);
    }

    public PowerManager getGenericManager()
    {
        return (PowerManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeSpace(space.getId());
        return DELETE;
    }

    public String edit()
    {
        if (space == null) {
            space = new Space();
        } else if (space.getId() != null) {
            space = getGenericManager().getSpaceById(space.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedSpaceIds != null && selectedSpaceIds.length > 0) {
            Space obj = getGenericManager().getSpaceById(selectedSpaceIds[0]);
            obj.setId(null);
            space = obj;
        }
        beanToForm();

        return SUCCESS;
    }

    public String execute()
    {
        log.info("entering 'execute' method");
        if (getDelete() != null) {
            return delete();
        } else {
            formToBean();
            if (inputValidation(space) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Space val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveSpace(space);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        readerIds = getGenericManager().getIdsFromReaderList(space.getReader());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        SessionUser s=(SessionUser)getSession().getAttribute("user");   
        space.setCreatedDate(Tools.getCurrentTimestamp());      
        space.setCreatedUser(s.getMember()); 
        space.setBuilding(getGenericManager().getBuildingById(space.getBuildingId())); 
        space.setReader(getGenericManager().getReaderListByIds(readerIds));
        space.setReaderType(getAppPropertyById(space.getReaderTypeId()));
        log.info("exit formToBean()");
    }
    
    public List<Building> getBuildingList()
    {
        return getGenericManager().getBuildingList(); // TODO
    }

    public List<Reader> getReaderList()
    {
        return getGenericManager().getReaderList(); // TODO
    }

    public void setReaderIds(Long[] val)
    {
        readerIds = val;
    }

    public Long[] getReaderIds()
    {
        return readerIds;
    }

    public List<Space> getSpaceList()
    {
        return getGenericManager().getSpaceList();
    }

    public void setSelectedSpaceIds(Long[] val)
    {
        selectedSpaceIds = val;
    }

    public Long[] getSelectedSpaceIds()
    {
        return selectedSpaceIds;
    }
    
    public ScheduleDaily getScheduleDaily() {
		return scheduleDaily;
	}

	public void setScheduleDaily(ScheduleDaily scheduleDaily) {
		this.scheduleDaily = scheduleDaily;
	}
    
    public List<Reader> getReaderAllList()
    {    	
    	List<Reader> al = getGenericManager().getReaderList();
        if (al != null) {
            if (space.getReader() != null)
                al.removeAll(space.getReader());
            return al;
        }
        return new ArrayList<Reader>();
    }
    
    public List<AppProperty> getReaderTypeList()
    {
        return super.getAppPropertyList("reader.device");
    }
    
    public List<Reader> getObject_readerList()
    {     
    	ArrayList<Reader>  rs=new ArrayList(); 
    	if(space.getReader() == null){
    		 return rs;
    	}else{
    		System.out.println("getObject_readerList..");
    		List ls=space.getReader();
    		for(int i=0;i<ls.size();i++){
    			Reader r=(Reader)ls.get(i);
    			System.out.println(r.getName());
    			rs.add(r);
    		}
    		return rs;
    	}
    }
    
    public JSONArray readerByJSON(){
    	System.out.println("readerByJSON "+space.getId());
		JSONArray jsonArray = new JSONArray();
    	try{
    		space=getGenericManager().getSpaceById(space.getId());
    		
    		if (scheduleDaily == null) {
    			scheduleDaily = new ScheduleDaily();
            } else if (scheduleDaily.getId() != null) {
            	scheduleDaily=getGenericManager().getScheduleDailyById(scheduleDaily.getId());
            }
    		
    		if (scheduleDaily.getId() != null )
    		{
    		  scheduleDaily=getGenericManager().getScheduleDailyById(scheduleDaily.getId());
    		  readers=scheduleDaily.getReaders();
    		}
    		
    		List<Reader> ls=space.getReader();  
    		
    		ComparatorReader comparator=new ComparatorReader();
    		Collections.sort(ls, comparator);
    		
    	    for(int i=0;i<ls.size();i++){
    	       Reader s=ls.get(i);
    		   JSONObject jo = new JSONObject();
        	   jo.accumulate("id",s.getId());
        	   //jo.accumulate("name",s.getName());   
        	   jo.accumulate("name","¦WºÙ:"+s.getName()+"-½s¸¹:"+s.getReaderId());
        	   if(readers.contains(s)==false){
        	     jsonArray.put(jo);        	  
        	   }        	  
    	   }    
      	}catch(Exception e){
    		System.out.println("readerByJSON error..");
    	}
    	return jsonArray;
    }
}
