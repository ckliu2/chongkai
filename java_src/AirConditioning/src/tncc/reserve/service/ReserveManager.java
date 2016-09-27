package tncc.reserve.service;

import tncc.power.value.*;
import tncc.reserve.value.*;

import java.util.*;
import tncc.power.service.PowerManager;


public interface ReserveManager extends PowerManager 
{
	//CourseOpen
	public abstract List<CourseOpen> getCourseOpenList(ClassRoom classroom);
	public abstract List<CourseOpen> getCourseOpenListByWeek(ClassRoom classroom,int week);
	public abstract List<ClassRoom> getClassRoomList();
	public abstract List<ClassRoom> getAllClassRooms();
	public abstract ClassRoom getClassRoomById(String id);
	public abstract List<CourseOpen> getClassScheduleWeekly(ClassRoom classroom,int week);
	public abstract List<CourseOpen> getClassScheduleWeekly(Reader reader,int week);
    
}

