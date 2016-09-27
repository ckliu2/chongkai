package tncc.reserve.service.impl;

import tncc.reserve.service.ReserveManager;
import tncc.reserve.dao.ReserveDAO;
import tncc.reserve.value.*;

import java.util.*;

import tncc.power.service.impl.PowerManagerImpl;
import tncc.power.value.Reader;



public class ReserveManagerImpl extends PowerManagerImpl implements ReserveManager
{
	public ReserveDAO getGenericDAO()
    {
        return (ReserveDAO)super.getGenericDAO();
    }

    public void setGenericDAO(ReserveDAO dao)
    {
        super.setGenericDAO(dao);
    }

	public List<CourseOpen> getCourseOpenList(ClassRoom classroom)
    {
        return getGenericDAO().findAllCourseOpen(classroom);
    }
	
	public List<CourseOpen> getCourseOpenListByWeek(ClassRoom classroom,int week)
	{
		 return getGenericDAO().getCourseOpenListByWeek(classroom,week);
	}
	
	public List<ClassRoom> getClassRoomList()
	{
		 return getGenericDAO().findAllClassRoom();
	}
	
	public List<ClassRoom> getAllClassRooms()
	{
		return getGenericDAO().getAllClassRooms();
	}
	
	public ClassRoom getClassRoomById(String id)
	{
		 return getGenericDAO().getClassRoomById(id);
	}
	
	public List<CourseOpen> getClassScheduleWeekly(ClassRoom classroom,int week)
	{
		 return getGenericDAO().getClassScheduleWeekly(classroom,week);
	}
	
	public List<CourseOpen> getClassScheduleWeekly(Reader reader,int week)
	{
		return getGenericDAO().getClassScheduleWeekly(reader,week);
	}
    
	
}

