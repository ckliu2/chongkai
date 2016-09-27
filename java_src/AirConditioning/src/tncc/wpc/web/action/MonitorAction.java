package tncc.wpc.web.action;

import tncc.wpc.value.*;
import tncc.wpc.service.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;

import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.*;

public class MonitorAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
	private Building building;
	private Long id,buildingId,controllerId,sensorId;   
	private List<Sensor> monitors;

    public MonitorAction()
    {
        log = LogFactory.getLog(MonitorAction.class);
    }



    public void setGenericManager(wpcManager m)
    {
        super.setGenericManager(m);
    }

    public wpcManager getGenericManager()
    {
        return (wpcManager) super.getGenericManager();
    }
    
    public String monitorChart(){
    	System.out.println("monitorChart");
    	return SUCCESS;
    }


    public String list()
    {
    	System.out.println("id="+id);
    	building=getGenericManager().getBuildingById(id);
    	System.out.println("building name="+building.getName());
    	
    	//Monitor
    	System.out.println("buildingId="+buildingId+"  controllerId="+controllerId+" sensorId="+sensorId);
    	monitors=getGenericManager().getSensorList();
    	
    	//Monitor
        return SUCCESS;
    }
    
    public  List<Room> getRoomListByBuilding(Building building){   
    	System.out.println("RoomListByBuilding building="+building.getName());
    	return getGenericManager().getRoomListByBuilding(building);
    }
    
    
    public  List<Controller> getControllerByRoom(Long id){    	
    	System.out.println("getControllerByRoom room");
    	Room room=getGenericManager().getRoomById(id);
    	return getGenericManager().getControllerByRoom(room);
    }
    
    public  List<Sensor> getSensorListByController(Long id){    	
    	System.out.println("getSensorListByController controller");
    	Controller controller=getGenericManager().getControllerById(id);
    	return getGenericManager().getSensorListByController(controller);
    }
    
    public  List<Controller> getTestList(){
    	
    	try{
    	System.out.println("getTestList");
    	}catch(Exception e){
    		System.out.println(e.toString());
    	}
    	return getGenericManager().getControllerList();
    }

  
    public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}
	
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Long buildingId) {
		this.buildingId = buildingId;
	}

	public Long getControllerId() {
		return controllerId;
	}

	public void setControllerId(Long controllerId) {
		this.controllerId = controllerId;
	}

	public Long getSensorId() {
		return sensorId;
	}

	public void setSensorId(Long sensorId) {
		this.sensorId = sensorId;
	}
	
	public List<Sensor> getMonitors() {
		System.out.println("List<Sensor> getMonitors()");
		return monitors;
	}

	public void setMonitors(List<Sensor> monitors) {
		this.monitors = monitors;
	}

    
    
}
