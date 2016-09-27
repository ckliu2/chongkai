package rfid.card.dao;

import rfid.card.value.*;
import java.util.*;
import com.common.dao.CommonDAO;
import com.common.value.*;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Nov 18 14:22:25 CST 2009
*/

public interface RecorderDAO extends CommonDAO 
{
    //Recorder
	public abstract void saveRecorder(Recorder val);
    public abstract void removeRecorder(Recorder val);
    public abstract void removeRecorder(Long id);
    public abstract Recorder findRecorderById(Long id);
    public abstract List<Recorder> findAllRecorderSave();    
    public abstract List<Recorder> findRecorderByMember(Member m);    
    public abstract List<Recorder> findRecorderSaveByDate(Date beginDate,Date endDate);    
    public abstract List<Recorder> findRecorderDisByDate(Date beginDate,Date endDate);    
    public abstract List<Member> findMemberList();
    //Machine
    public abstract void saveMachine(Machine val);
    public abstract void removeMachine(Machine val);
    public abstract void removeMachine(Long id);
    public abstract Machine findMachineById(Long id);
    public abstract List<Machine> findAllMachine();
    public abstract List<Machine> findAllMachineByMember(Member member);
}

