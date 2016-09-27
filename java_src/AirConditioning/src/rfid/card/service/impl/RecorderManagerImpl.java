package rfid.card.service.impl;

import rfid.card.service.RecorderManager;
import rfid.card.dao.RecorderDAO;
import rfid.card.value.*;
import java.util.*;

import com.common.service.impl.CommonManagerImpl;
import com.common.value.*;
/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Nov 18 14:22:25 CST 2009
*/

public class RecorderManagerImpl extends CommonManagerImpl implements RecorderManager
{

    public RecorderManagerImpl()
    {
    }

    public RecorderDAO getGenericDAO()
    {
        return (RecorderDAO)super.getGenericDAO();
    }

    public void setGenericDAO(RecorderDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveRecorder(Recorder val)
    {
        getGenericDAO().saveRecorder(val);
    }

    public void removeRecorder(Recorder val)
    {
        getGenericDAO().removeRecorder(val);
    }

    public void removeRecorder(Long id)
    {
        getGenericDAO().removeRecorder(id);
    }

    public Recorder getRecorderById(Long id)
    {
         return getGenericDAO().findRecorderById(id);
    }

    public List<Recorder> getRecorderListSave()
    {
        return getGenericDAO().findAllRecorderSave();
    }
    
    public List<Recorder> getRecorderListByMember(Member m)
    {
        return getGenericDAO().findRecorderByMember(m);
    }
    
    public List<Recorder> getRecorderListSaveByDate(Date beginDate,Date endDate)
    {
    	return getGenericDAO().findRecorderSaveByDate(beginDate,endDate);
    }
    
    public List<Recorder> getRecorderListDisByDate(Date beginDate,Date endDate)
    {
    	return getGenericDAO().findRecorderDisByDate(beginDate,endDate);
    }
    

    
    //Machine
    public void saveMachine(Machine val)
    {
        getGenericDAO().saveMachine(val);
    }

    public void removeMachine(Machine val)
    {
        getGenericDAO().removeMachine(val);
    }

    public void removeMachine(Long id)
    {
        getGenericDAO().removeMachine(id);
    }

    public Machine getMachineById(Long id)
    {
         return getGenericDAO().findMachineById(id);
    }

    public List<Machine> getMachineList()
    {
        return getGenericDAO().findAllMachine();
    }
    
    public List<Machine> getMachineListByMember(Member member)
    {
        return getGenericDAO().findAllMachineByMember(member);
    }


}

