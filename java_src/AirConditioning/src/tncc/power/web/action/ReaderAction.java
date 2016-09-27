package tncc.power.web.action;

import tncc.power.value.*;
import tncc.power.service.PowerManager;
import tncc.wpc.value.Building;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.util.*;

import javax.servlet.ServletContext;

import MITSUBISHI_G50.DeviceConnection;

import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.*;


public class ReaderAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Reader reader;
	private Long[] selectedReaderIds,scheduledDateIds;
	Long spaceId;
	private ScheduleDaily scheduleDaily,daily;
	String scheduledDate;
	Set<Reader> myScheduleDailys = new HashSet();
	ArrayList<Reader> al = new ArrayList<Reader>();	
	String today,delete1,beginDate;
	PowerControllerReader powerControllerReader;
	
    public ReaderAction()
    {
        log = LogFactory.getLog(tncc.power.web.action.ReaderAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("READER");
    }

    public Reader getReader()
    {
        return reader;
    }

    public void setReader(Reader val)
    {
        reader = val;
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
        getGenericManager().removeReader(reader.getId());
        return DELETE;
    }
    
    public String deleteScheduled()
    {
    	//System.out.println("deleteScheduled scheduleDaily.getId()="+scheduleDaily.getId());
        //判斷是否無排程
    	scheduleDaily=getGenericManager().getScheduleDailyById(scheduleDaily.getId());
    	Set s=scheduleDaily.getReaders();
    	getGenericManager().removeScheduleDaily(scheduleDaily.getId());
    	emptyScheduled(s);    	
        appendXworkParam("msg=1");
        appendXworkParam("reader.id="+reader.getId());        
        return "DELETESCHEDULED";
    }
    
    public void emptyScheduled(Set s)
    {
      try{  		  
    	  System.out.println("emptyScheduled...");	    	
    	  if(s!=null){
     	   Iterator i = s.iterator(); 
     	    while (i.hasNext()) {
     	    	Reader r= (Reader) i.next();      	    	
     	    	boolean b=getGenericManager().isClearDaily(r);
     	    	//System.out.println("emptyScheduled reader="+r.getName()+"--b="+b);     	  
     	    	if(b==true)
     	    	{
     	    	 PowerController pc=getGenericManager().getPowerControllerByReader(r);
     	    	 String cmd=emptyCommand(r);
     	    	 DeviceConnection cn=new DeviceConnection(pc.getIp(), Integer.parseInt( String.valueOf(r.getReaderId()) ) );
		    	 cn.sendCommand(cmd);
     	    	}	     	    	
     	    }
    	  } 		 
      }catch(Exception e){
    	System.out.println("emptyScheduled error="+e.toString());
      }
    }
    
 	public String emptyCommand(Reader reader){
 		String cmd="";
 		try{
			Element packet = new Element("Packet");
			Document doc = new Document(packet);
			doc.setRootElement(packet);			
			Element command = new Element("Command");
			command.setText("setRequest");
			doc.getRootElement().addContent(command);			
			Element databaseManager = new Element("DatabaseManager");			
			Element scheduleControl = new Element("ScheduleControl");			
			Element todayList = new Element("TodayList");    			
			scheduleControl.addContent(todayList);    			
			databaseManager.addContent(scheduleControl);   
			todayList.setAttribute("Group", String.valueOf(reader.getReaderId()) );
	   	    doc.getRootElement().addContent(databaseManager);	
			XMLOutputter xmlOutput = new XMLOutputter();
	      	Format format = Format.getPrettyFormat();
	        format.setEncoding("UTF-8");
			xmlOutput.setFormat(format.getPrettyFormat());    			
			//xmlOutput.output(doc, new FileWriter("d:\\tmp\\file2.xml"));    			
			cmd=xmlOutput.outputString(doc);
			return cmd;
			}catch(Exception e){
				System.out.println(e.toString());
			}
			return cmd;
 	  }

    public String edit()
    {
        if (reader == null) {
            reader = new Reader();
        } else if (reader.getId() != null) {
            reader = getGenericManager().getReaderById(reader.getId());
       	    powerControllerReader=getGenericManager().getReaderByControllerDeviceNo(reader);
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedReaderIds != null && selectedReaderIds.length > 0) {
            Reader obj = getGenericManager().getReaderById(selectedReaderIds[0]);
            obj.setId(null);
            reader = obj;
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
            if (inputValidation(reader) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Reader val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        reader.setSync(false);
        getGenericManager().saveReader(reader);
        appendXworkParam("msg=1");
        appendXworkParam("reader.id="+reader.getId());
        //如果有批次更新
        if(selectedReaderIds!=null){
        	for(int i=0;i<selectedReaderIds.length;i++){
        		//System.out.println("selectedReaderIds="+selectedReaderIds[i]);
        		Reader r=getGenericManager().getReaderById(selectedReaderIds[i]);
        		r.setTemp(reader.getTemp());
        		r.setDrive(reader.getDrive());
        		r.setMode(reader.getMode());
        		r.setDriveItem(reader.getDriveItem());
        		r.setModeItem(reader.getModeItem());
        		r.setTempItem(reader.getTempItem());
        		r.setFilterItem(reader.getFilterItem());
        		r.setActive(reader.getActive());
        		r.setPass(reader.getPass());
        		r.setSync(false);
        		getGenericManager().saveReader(r);
        	}
        }
        return SUCCESS;
    }

    public String list()
    {   
    	
    	try{
    	 scheduleDailyEdit();
    	 beginDateSelect();
    	 reader=getGenericManager().getReaderById(reader.getId());
    	 powerControllerReader=getGenericManager().getReaderByControllerDeviceNo(reader);
    	}catch(Exception e){}
    	
    	return SUCCESS;
    }
    
    protected void beginDateSelect()
    {
    	if(beginDate==null || beginDate.equals(""))
    	{
    		beginDate=Tools.getTodaytoString();
    	}
    }
    
    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        
        
        reader.setCreatedDate(Tools.getCurrentTimestamp());     
        reader.setDrive(getAppPropertyById(reader.getDriveId())); 
        reader.setMode(getAppPropertyById(reader.getModeId())); 
        reader.setDriveItem(getAppPropertyById(reader.getDriveItemId())); 
        reader.setModeItem(getAppPropertyById(reader.getModeItemId())); 
        reader.setTempItem(getAppPropertyById(reader.getTempItemId())); 
        reader.setFilterItem(getAppPropertyById(reader.getFilterItemId()));
        reader.setFanSpeed(getAppPropertyById(reader.getFanSpeedId()));
        reader.setLock(getAppPropertyById(reader.getLockId())); 
        reader.setState(getAppPropertyById(reader.getStateId()));        
       
        
        if(reader.getPass()==null){
    	  reader.setPass(false);
        }
        
        if(reader.getActive()==null){
        	reader.setActive(false);
        }
        log.info("exit formToBean()");
    }
    
    public void scheduleDailyEdit(){
    	if(scheduleDaily!=null){	
        	if (scheduleDaily.getId() != null) {
            	scheduleDaily = getGenericManager().getScheduleDailyById(scheduleDaily.getId());
            	scheduledDate=Tools.formatSimpleDate1(scheduleDaily.getScheduledDate());
        	}
          }    	
    }
    
    public List<Reader> getReaderList()
    {
        return getGenericManager().getReaderList();
    }
    
    public List getSelectedReaderList()
    {    	
    	if(scheduleDaily!=null){	
        	if (scheduleDaily.getId() != null) {
            	scheduleDaily = getGenericManager().getScheduleDailyById(scheduleDaily.getId());
            	List list = new ArrayList(scheduleDaily.getReaders());            	
            	ComparatorReader comparator=new ComparatorReader();
        		Collections.sort(list, comparator);            	
            	return list;
        	}
        	return al;
          }else{
        	reader=getGenericManager().getReaderById(reader.getId());
        	al.add(reader);
        	return al;
          }    	
    }
    
    public void setSelectedReaderIds(Long[] val)
    {
        selectedReaderIds = val;
    }

    public Long[] getSelectedReaderIds()
    {
        return selectedReaderIds;
    }
    
    public Long[] getScheduledDateIds() {
		return scheduledDateIds;
	}

	public void setScheduledDateIds(Long[] scheduledDateIds) {
		this.scheduledDateIds = scheduledDateIds;
	}
    
    public Long getSpaceId() {
		return spaceId;
	}

	public void setSpaceId(Long spaceId) {
		this.spaceId = spaceId;
	}
	
	public ScheduleDaily getScheduleDaily() {
		return scheduleDaily;
	}

	public void setScheduleDaily(ScheduleDaily scheduleDaily) {
		this.scheduleDaily = scheduleDaily;
	}
	
	public String getScheduledDate() {
		return scheduledDate;
	}

	public void setScheduledDate(String scheduledDate) {
		this.scheduledDate = scheduledDate;
	}	   
    
	public ScheduleDaily getDaily() {
		return daily;
	}

	public void setDaily(ScheduleDaily daily) {
		this.daily = daily;
	}	

    public String syncReader(){
    	System.out.println("==================syncReader====================");
    	getGenericManager().syncReader();
    	return SUCCESS;
    }
    
    
    public List<Space> getSpaceListAir()
    {   
       return getGenericManager().getSpaceListByAir(powerControllerReader.getPowerController().getDeviceType());
    }
    
    public List<SpaceReader> getReaderListBySpace()
    {    	
    	Space space=getGenericManager().getSpaceById(spaceId);
        return getGenericManager().getReaderListBySpace(space);
    }
    
    public List<ScheduleReaderDaily> getScheduleDailyByReader()
    {    
    	reader = getGenericManager().getReaderById(reader.getId());
    	System.out.println("getScheduleDailyByReader reader="+reader.getName());
    	
    	Date d;
    	if(beginDate==null || beginDate.equals(""))
    	{
    		//System.out.println("getScheduleDailyByReader today");
    		d=new Date();
    	}else{
    		//System.out.println("getScheduleDailyByReader beginDate="+beginDate);
    		d=Tools.convertToDate1(beginDate);
    	}
    	return getGenericManager().getScheduleListByReader(reader,d);
    }
    
    
	public String getToday() {
		
		return Tools.getTodaytoString();
	}
    
	public String getDelete1() {
		return delete1;
	}

	public void setDelete1(String delete1) {
		this.delete1 = delete1;
	}
	
	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}	

	public PowerControllerReader getPowerControllerReader() {
		return powerControllerReader;
	}

	public void setPowerControllerReader(PowerControllerReader powerControllerReader) {
		this.powerControllerReader = powerControllerReader;
	}
	
    public String saveScheduleDaily()
    {
    	System.out.println("==================saveScheduleDaily====================");
    	
    	System.out.println("scheduleDaily.getId()="+scheduleDaily.getId());
    	if (getDelete1() != null) {
            return deleteScheduled();
        }
    	
    	if (daily == null) {
    		daily = new ScheduleDaily();
        } else if (scheduleDaily.getId() != null) {
        	daily = getGenericManager().getScheduleDailyById(scheduleDaily.getId());
        }
    	
    	try{
    	System.out.println("id="+daily.getId()+"--Temp="+daily.getTemp());
    	daily.setId(scheduleDaily.getId());
    	daily.setTemp(scheduleDaily.getTemp());   		
    	daily.setDrive(getAppPropertyById(scheduleDaily.getDriveId())); 
    	daily.setMode(getAppPropertyById(scheduleDaily.getModeId())); 
    	daily.setFanSpeed(getAppPropertyById(scheduleDaily.getFanSpeedId())); 
    	daily.setDriveItem(getAppPropertyById(scheduleDaily.getDriveItemId())); 
    	daily.setModeItem(getAppPropertyById(scheduleDaily.getModeItemId())); 
    	daily.setTempItem(getAppPropertyById(scheduleDaily.getTempItemId())); 
    	daily.setFilterItem(getAppPropertyById(scheduleDaily.getFilterItemId())); 
    	daily.setLock(getAppPropertyById(scheduleDaily.getLockId()));
    	daily.setCreatedDate(Tools.getCurrentTimestamp());
    	daily.setActive(false);
    	daily.setScheduledDate(Tools.convertToDateTime(scheduledDate));     	
    	daily.setType(getGenericManager().getAppPropertyById(82L));
    	daily.setPass(scheduleDaily.getPass());
    	
    	if(scheduledDate==null)
    	{
    		Calendar cal=java.util.Calendar.getInstance();   
    		cal.add(java.util.Calendar.MINUTE,3);      		
    		daily.setScheduledDate(cal.getTime()); 
    	}else{
    	    daily.setScheduledDate(Tools.convertToDateTime(scheduledDate));  
    	}
    	
    	if(selectedReaderIds!=null){
        	for(int i=0;i<selectedReaderIds.length;i++){
        	  Reader r=getGenericManager().getReaderById(selectedReaderIds[i]);
        	  myScheduleDailys.add(r);
        	}
        }
        
    	daily.setReaders(myScheduleDailys); 
    	daily.setIp(getSessionUser().getIp());
    	daily.setLastModifiedDate(Tools.getCurrentTimestamp());
    	daily.setLastModifiedUser(getSessionUser().getMember());
    	
    	getGenericManager().saveScheduleDaily(daily);
    	
    	}catch(Exception e){
    		System.out.println(e.toString());
    	}
    	
    	appendXworkParam("msg=1");
    	appendXworkParam("reader.id="+reader.getId());
    	
    	return SUCCESS;
    }
    
    public String saveScheduleDaily1()
    {
    	System.out.println("==================saveScheduleDaily1====================");
        String uuid=Tools.uuid();
    	for(int i=0;i<scheduledDateIds.length;i++)
    	{    		
        	try{
        		AppProperty course=getGenericManager().getAppPropertyById(scheduledDateIds[i]);
        		for(int k=0;k<2;k++)
        		{
        			Date d;
        			String time;
        			AppProperty drive;
        			if(k==0)
        			{
        				time=course.getValueTw();
        				drive=getGenericManager().getAppPropertyById(29L);
        			}else
        			{
        				time=course.getValueUs();
        				drive=getGenericManager().getAppPropertyById(30L);
        			}
        			String coursetime=beginDate+" "+time.substring(0,2)+":"+time.substring(2,4);
            		d=Tools.convertToDateTime(coursetime);
            		System.out.println(scheduledDateIds[i]+"--"+beginDate+"--"+course.getValueTw()+"--"+course.getValueUs()+"--"+d);
            		
            		daily = new ScheduleDaily();
                	daily.setScheduledDate(Tools.convertToDateTime(coursetime));    	
                	daily.setId(scheduleDaily.getId());
                	daily.setTemp(scheduleDaily.getTemp());   		
                	daily.setDrive(drive); 
                	daily.setMode(getAppPropertyById(scheduleDaily.getModeId())); 
                	daily.setFanSpeed(getAppPropertyById(scheduleDaily.getFanSpeedId())); 
                	daily.setDriveItem(getAppPropertyById(scheduleDaily.getDriveItemId())); 
                	daily.setModeItem(getAppPropertyById(scheduleDaily.getModeItemId())); 
                	daily.setTempItem(getAppPropertyById(scheduleDaily.getTempItemId())); 
                	daily.setFilterItem(getAppPropertyById(scheduleDaily.getFilterItemId()));
                	daily.setCreatedDate(Tools.getCurrentTimestamp());
                	daily.setActive(false);
                	daily.setType(getGenericManager().getAppPropertyById(82L));
                        daily.setPass(scheduleDaily.getPass());
                	
                	if(selectedReaderIds!=null){
                    	for(int j=0;j<selectedReaderIds.length;j++){
                    	  Reader r=getGenericManager().getReaderById(selectedReaderIds[j]);
                    	  myScheduleDailys.add(r);
                    	}
                    }                
                	daily.setReaders(myScheduleDailys);    
                	daily.setIp(getSessionUser().getIp());
                	daily.setLastModifiedDate(Tools.getCurrentTimestamp());
                	daily.setLastModifiedUser(getSessionUser().getMember());
                	daily.setGroupCode(uuid);
                	int courseNum=course.getSeqNo();
                	if(drive.getValueTw().equals("ON")){
                		courseNum+=1;
                	}else if(drive.getValueTw().equals("OFF")){
                		courseNum+=2;
                	}
                	daily.setCourseNum(courseNum);
                	getGenericManager().saveScheduleDaily(daily);
        		}
           }catch(Exception e){
              System.out.println(e.toString());
           }
    	}
        System.out.println("scheduledDateIds.len="+scheduledDateIds.length);
   
    	appendXworkParam("msg=1");
    	appendXworkParam("reader.id="+reader.getId());
    	
    	return SUCCESS;
    }
    
    //device Attribute
    
    public List getFanSpeedList()
    {
        return super.getDevicePropertyList("reader.fanspeed",powerControllerReader.getPowerController().getDeviceType().getValueTw());
    }
    
    public List getFanSpeedListInit()
    {
        return super.getAppPropertyList("reader.fanspeed");
    }
    
    public List<AppProperty> getDriveList()
    {
    	return super.getDevicePropertyList("reader.drive",powerControllerReader.getPowerController().getDeviceType().getValueTw());
    }
    
    public List<AppProperty> getDriveListInit()
    {
    	return super.getAppPropertyList("reader.drive");
    }
    
    public List<AppProperty> getModeList()
    {
        return super.getDevicePropertyList("reader.mode",powerControllerReader.getPowerController().getDeviceType().getValueTw());
    }
    
    
    public List<AppProperty> getModeListInit()
    {
        return super.getAppPropertyList("reader.mode");
    }

    public List<AppProperty> getDriveItemList()
    {
        return super.getAppPropertyList("reader.driveItem");
    }

    public List<AppProperty> getModeItemList()
    {
        return super.getAppPropertyList("reader.modeItem");
    }

    public List<AppProperty> getTempItemList()
    {
        return super.getAppPropertyList("reader.tempItem");
    }

    public List<AppProperty> getFilterItemList()
    {
        return super.getAppPropertyList("reader.filterItem");
    }
    
    public List<AppProperty> getCourseNodeList()
    {
        return super.getAppPropertyList("course.node");
    }
    
    public List getLockList()
    {
        return getAppPropertyList("reader.lock");
    }

    
   
}
