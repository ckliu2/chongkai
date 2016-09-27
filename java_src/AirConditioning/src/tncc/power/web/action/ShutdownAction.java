package tncc.power.web.action;

import tncc.wpc.value.*;
import tncc.power.value.*;
import tncc.reserve.service.*;
import tncc.reserve.value.ClassRoom;
import tncc.reserve.value.CourseOpen;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.jdom.xpath.XPath;

import java.io.File;
import java.io.FileWriter;
import java.util.*;

import HoneyWell.DT200;
import MITSUBISHI_G50.Device;
import MITSUBISHI_G50.DeviceConnection;

import com.common.web.action.CommonActionSupport;
import com.base.util.MyProperties;
import com.base.util.Tools;
import com.base.value.*;

import org.json.*;

import service.*;

public class ShutdownAction extends CommonActionSupport {

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Shutdown shutdown;
    private Long[] readerIds;
    private Long[] selectedShutdownIds;
    private String door, ps;
    private Long buildingId, readerId, spaceId, readerStateId;
    private BasicInfo basicInfo;
    ClassRoom classroom;
    Reader reader;

    int week;

    public ShutdownAction() {
	log = LogFactory.getLog(tncc.power.web.action.ShutdownAction.class);
    }

    public Function getFunction() {
	return getGenericManager().getFunctionByKey("SHUTDOWN");
    }

    public Shutdown getShutdown() {
	return shutdown;
    }

    public void setShutdown(Shutdown val) {
	shutdown = val;
    }

    public void setGenericManager(ReserveManager m) {
	super.setGenericManager(m);
    }

    public ReserveManager getGenericManager() {
	return (ReserveManager) super.getGenericManager();
    }

    public String delete() {
	getGenericManager().removeShutdown(shutdown.getId());
	return DELETE;
    }

    public String edit() {
	if (shutdown == null) {
	    shutdown = new Shutdown();
	} else if (shutdown.getId() != null) {
	    shutdown = getGenericManager().getShutdownById(shutdown.getId());
	} else { // TODO
	}
	beanToForm();

	return SUCCESS;
    }

    public String copy() {
	if (selectedShutdownIds != null && selectedShutdownIds.length > 0) {
	    Shutdown obj = getGenericManager().getShutdownById(
		    selectedShutdownIds[0]);
	    obj.setId(null);
	    shutdown = obj;
	}
	beanToForm();

	return SUCCESS;
    }

    public String execute() {
	log.info("entering 'execute' method");
	if (getDelete() != null) {
	    return delete();
	} else {
	    formToBean();
	    if (inputValidation(shutdown) == false)
		return INPUT;
	}
	return SUCCESS;
    }

    public boolean inputValidation(Shutdown val) {
	return true;
    }

    public String save() {
	log.info("entering 'save' method");
	getGenericManager().saveShutdown(shutdown);
	return SUCCESS;
    }

    public String list() {
	if (week == 0) {
	    week = Tools.getCurrentTimestamp().getDay() + 1;
	}
	return SUCCESS;
    }

    protected void beanToForm() {
	log.info("enter beanToForm()");
	readerIds = getGenericManager().getIdsFromReaderList(
		shutdown.getReader());
	log.info("exit beanToForm()");
    }

    protected void formToBean() {
	log.info("enter formToBean()");
	shutdown.setReader(getGenericManager().getReaderListByIds(readerIds));
	shutdown.setEvenlevel(getGenericManager().getEvenLevelById(
		shutdown.getEvenlevelId()));
	SessionUser s = (SessionUser) getSession().getAttribute("user");
	shutdown.setCreatedDate(Tools.getCurrentTimestamp());
	shutdown.setCreatedUser(s.getMember());
	log.info("exit formToBean()");
    }

    public List<Building> getBuildingList() {
	return getGenericManager().getBuildingList();
    }

    public List<Building> getBuilding() {

	ArrayList<Building> al = new ArrayList<Building>();
	if (buildingId != null) {
	    Building b = getGenericManager().getBuildingById(buildingId);
	    al.add(b);
	    return al;
	} else {

	    return getBuildingList();
	}

    }

    // 取得節電空間
    public Space getSpaceByBuilding(Long id) {
	return getGenericManager().getSpaceByBuilding(id);
    }

    public List<SpaceReader> getReaderListBySpace(Long spaceId) {
	Space space = getGenericManager().getSpaceById(spaceId);
	AppProperty state = getGenericManager().getAppPropertyById(
		readerStateId);
	return getGenericManager().getReaderListBySpace(space, state);
    }

    public List<PowerController> getPowerControllerList() {
	return getGenericManager().getPowerControllerList();
    }

    public List<Reader> getReaderList() {
	return getGenericManager().getReaderList(); // TODO
    }

    public void setReaderIds(Long[] val) {
	readerIds = val;
    }

    public Long[] getReaderIds() {
	return readerIds;
    }

    public List<Shutdown> getShutdownList() {
	return getGenericManager().getShutdownList();
    }

    public void setSelectedShutdownIds(Long[] val) {
	selectedShutdownIds = val;
    }

    public Long[] getSelectedShutdownIds() {
	return selectedShutdownIds;
    }

    public String getDoor() {
	return door;
    }

    public void setDoor(String door) {
	this.door = door;
    }

    public String getPs() {
	return ps;
    }

    public void setPs(String ps) {
	this.ps = ps;
    }

    public Long getBuildingId() {
	return buildingId;
    }

    public void setBuildingId(Long buildingId) {
	this.buildingId = buildingId;
    }

    public BasicInfo getBasicInfo() {
	basicInfo = getGenericManager().getBasicInfoById(1L);
	return basicInfo;
    }

    public Long getReaderId() {
	return readerId;
    }

    public void setReaderId(Long readerId) {
	this.readerId = readerId;
    }

    public ClassRoom getClassroom() {
	return classroom;
    }

    public void setClassroom(ClassRoom classroom) {
	this.classroom = classroom;
    }

    public int getWeek() {
	return week;
    }

    public void setWeek(int week) {
	this.week = week;
    }

    public Long getSpaceId() {
	return spaceId;
    }

    public void setSpaceId(Long spaceId) {
	this.spaceId = spaceId;
    }

    public Long getReaderStateId() {
	return readerStateId;
    }

    public Reader getReader() {
	return reader;
    }

    public void setReader(Reader reader) {
	this.reader = reader;
    }

    public void setReaderStateId(Long readerStateId) {
	this.readerStateId = readerStateId;
    }

    public JSONArray setLockStatus() {
	// System.out.println("action setLockStatus..readerId="+readerId+"--ps="+ps);
	JSONArray jsonArray = new JSONArray();
	try {
	    Reader reader = getGenericManager().getReaderById(readerId);
	    PowerController p = getGenericManager().getPowerControllerByReader(
		    reader);
	    boolean r;
	    String psch = "";
	    if (ps.equals("LUCK")) {
		r = true;
		psch = "解鎖";
	    } else {
		r = false;
		psch = "鎖定";
	    }
	    System.out.println("p.getDeviceTypeId()=" + p.getDeviceTypeId());

	    DT200.setLock(p.getIp(), p.getPort(), p.getDeviceId(),
		    reader.getReaderId(), r);

	    JSONObject jo = new JSONObject();
	    jo.accumulate("info", "");
	    jsonArray.put(jo);

	    // 寫Log
	    /*
	     * tncc.power.value.Log g=new tncc.power.value.Log();
	     * g.setType(getGenericManager().getAppPropertyById(85L)); //即時開/解鎖
	     * g.setCreatedDate(Tools.getCurrentTimestamp());
	     * g.setCreatedUser(getMemberFromSessionUser());
	     * g.setReader(reader); String msg=reader.getName()+"已被"+psch;
	     * g.setMsg(msg); getGenericManager().saveLog(g);
	     */

	} catch (Exception e) {
	    System.out.println("setLockStatus error=" + e.toString());
	}

	return jsonArray;
    }

    public JSONArray setDevicePowerStatus() {
	// System.out.println("action setDevicePowerStatus..readerId="+readerId+"--ps="+ps);
	JSONArray jsonArray = new JSONArray();
	try {
	    Reader reader = getGenericManager().getReaderById(readerId);
	    PowerController p = getGenericManager().getPowerControllerByReader(
		    reader);
	    boolean r;
	    String psch = "";
	    Long powerstatusId;
	    if (ps.equals("ON")) {
		r = true;
		psch = "開啟";
		powerstatusId=29L;
	    } else {
		r = false;
		psch = "關閉";
		powerstatusId=30L;
	    }

	    System.out.println("p.getDeviceTypeId()=" + p.getDeviceTypeId());
	    // MITSUBISHI G50
	    if (p.getDeviceTypeId() == 45L) {
		DeviceConnection c = new DeviceConnection(p.getIp());
		c.setDeviceStatus(reader.getReaderId(), ps);

		// 更新面板
		Reader rd = displayPanel(readerId, ps, r);

		// System.out.println("更新面板 setDevicePowerStatus="+rd.getName()+"---"+ps+"--"+p.getDeviceTypeId());

		JSONObject jo = new JSONObject();
		jo.accumulate("info", rd.getInformation());
		jo.accumulate("powerstatus", rd.getPowerstatus());
		jo.accumulate("state", rd.getState().getValueUs());
		jo.accumulate("id", rd.getId());
		jo.accumulate("deviceType", "45");
		jo.accumulate("countroltime", Tools.getCurrentTimestamp());
		jsonArray.put(jo);
		// System.out.println("end="+rd.getId()+"--Powerstatus="+rd.getPowerstatus());
	    }

	    // OG Server
	    if (p.getDeviceTypeId() == 46L) {
		OGServer.setDevicePowerStatus(reader.getName(), r);
	    }

	    // HoneyWell
	    if (p.getDeviceTypeId() == 94L) {
		System.out.println("即時開啟/關閉" + r + "---" + reader.getReaderId());
		DT200.setDevicePowerStatus(p.getIp(), p.getPort(),p.getDeviceId(), reader.getReaderId(), r);
	        //新增排程
		ScheduleDaily s=new ScheduleDaily();
		s.setDrive(getGenericManager().getAppPropertyById(powerstatusId));
		s.setMode(getGenericManager().getAppPropertyById(97L));
		s.setTemp(24);
		s.setDriveItem(getGenericManager().getAppPropertyById(35L));
		s.setModeItem(getGenericManager().getAppPropertyById(37L));
		s.setTempItem(getGenericManager().getAppPropertyById(39L));
		s.setFilterItem(getGenericManager().getAppPropertyById(41L));
		s.setScheduledDate(Tools.getCurrentTimestamp());
		s.setActive(false);
		s.setCreatedDate(Tools.getCurrentTimestamp());
		
		s.setFanSpeed(getGenericManager().getAppPropertyById(100L));
		s.setType(getGenericManager().getAppPropertyById(82L));
		s.setIp(getClientIP());
		s.setLastModifiedDate(Tools.getCurrentTimestamp());
		s.setLastModifiedUser(getMemberFromSessionUser());
		s.setLock(getGenericManager().getAppPropertyById(95L));		
		Set<Reader> readers = new HashSet();
		readers.add(reader);
		s.setReaders(readers);
		getGenericManager().saveScheduleDaily(s);
		
	    }

	    // 寫Log
	    tncc.power.value.Log g = new tncc.power.value.Log();
	    g.setType(getGenericManager().getAppPropertyById(85L)); // 即時開/關
	    g.setCreatedDate(Tools.getCurrentTimestamp());
	    g.setCreatedUser(getMemberFromSessionUser());
	    g.setReader(reader);
	    String msg = reader.getName() + "已被" + psch;
	    g.setMsg(msg);
	    g.setIp(getClientIP());
	    getGenericManager().saveLog(g);

	} catch (Exception e) {
	    System.out.println("setDevicePowerStatus error=" + e.toString());
	}

	return jsonArray;
    }

    public Reader displayPanel(Long id, String content, boolean status) {
	Reader reader = null;
	try {
	    // update reader status
	    reader = getGenericManager().currentReaderState(id, status);
	    // System.out.println("displayPanel reader="+reader.getInformation());
	    // save log
	    CommandLog log = new CommandLog();
	    log.setCommandType(getGenericManager().getAppPropertyById(44L));
	    log.setReader(reader);
	    log.setCommand(content);
	    log.setCreatedDate(Tools.getCurrentTimestamp());
	    getGenericManager().saveCommandLog(log);

	} catch (Exception e) {
	    System.out.println("displayPanel error=" + e.toString());
	}
	return reader;
    }

    public List<EvenLevel> getEvenlevelList() {
	return getGenericManager().getEvenLevelList(); // TODO
    }

    public Reader getReaderById() {
	Reader reader = getGenericManager().getReaderById(readerId);
	return reader;
    }

    public List<Device> getDeviceDaily() {
	Reader reader = getGenericManager().getReaderById(readerId);
	PowerControllerReader p = getGenericManager()
		.getReaderByControllerDeviceNo(reader);
	DeviceConnection c = new DeviceConnection(p.getPowerController()
		.getIp(), p.getDeviceNo());
	return c.getDailyStatus();
    }

    public List<Device> getDeviceWeekly() {
	Reader reader = getGenericManager().getReaderById(readerId);
	PowerControllerReader p = getGenericManager()
		.getReaderByControllerDeviceNo(reader);
	DeviceConnection c = new DeviceConnection(p.getPowerController()
		.getIp(), p.getDeviceNo());
	return c.getWeeklyStatus();
    }

    public List<CourseOpen> getClassScheduleWeekly(String classroomId,
	    String week) {
	System.out.println("getClassScheduleWeekly classroomId=" + classroomId
		+ "--week=" + week);
	classroom = getGenericManager().getClassRoomById(classroomId);
	return getGenericManager().getClassScheduleWeekly(classroom,
		Integer.parseInt(week));
    }

    public List<CourseOpen> getClassScheduleWeeklyByReader(String readerId,
	    String week) {
	System.out.println("getClassScheduleWeekly readerId=" + readerId
		+ "--week=" + week);
	reader = getGenericManager().getReaderById(Long.parseLong(readerId));
	PowerControllerReader p = getGenericManager()
		.getReaderByControllerDeviceNo(reader);
	System.out.println("getClassScheduleWeeklyByReader p.getClassRoom()="
		+ p.getClassRoom().getName() + "--week=" + week);
	return getGenericManager().getClassScheduleWeekly(p.getClassRoom(),
		Integer.parseInt(week));
    }

    public List<AppProperty> getDriveList() {
	return super.getAppPropertyList("reader.drive");
    }

    public List<AppProperty> getModeList() {
	return super.getAppPropertyList("reader.mode");
    }

    public List<AppProperty> getDriveItemList() {
	return super.getAppPropertyList("reader.driveItem");
    }

    public List<AppProperty> getModeItemList() {
	return super.getAppPropertyList("reader.modeItem");
    }

    public List<AppProperty> getTempItemList() {
	return super.getAppPropertyList("reader.tempItem");
    }

    public List<AppProperty> getFilterItemList() {
	return super.getAppPropertyList("reader.filterItem");
    }

    public List<AppProperty> getReaderState() {
	return super.getAppPropertyList("reader.status");
    }

    public List<Space> getSpaceListAir() {
	AppProperty air = getGenericManager().getAppPropertyById(45L);
	return getGenericManager().getSpaceListByAir(air);
    }

    public List<SpaceReader> getReaderListBySpace() {
	Space space = getGenericManager().getSpaceById(spaceId);
	return getGenericManager().getReaderListBySpace(space);
    }

}
