package tncc.reserve.dao;

import tncc.power.value.*;
import tncc.reserve.value.*;

import java.util.*;

import tncc.power.dao.PowerDAO;



public interface ReserveDAO extends PowerDAO 
{
	public abstract List<CourseOpen> findAllCourseOpen(ClassRoom classroom);
	public abstract List<CourseOpen> getCourseOpenListByWeek(ClassRoom classroom,int week);
	public abstract List<ClassRoom> findAllClassRoom();
	public abstract List<ClassRoom> getAllClassRooms();
	public abstract ClassRoom getClassRoomById(String id);
	public abstract List<CourseOpen> getClassScheduleWeekly(ClassRoom classroom,int week);
	public abstract List<CourseOpen> getClassScheduleWeekly(Reader reader,int week);
    
}

