package rfid.card.service;

import rfid.card.value.*;
import java.util.*;
import com.common.service.CommonManager;
import com.common.value.*;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Nov 18 14:22:25 CST 2009
*/

public interface RecorderManager extends CommonManager 
{
    //Recorder
	public abstract void saveRecorder(Recorder val);
    public abstract void removeRecorder(Recorder val);
    public abstract void removeRecorder(Long id);
    public abstract Recorder getRecorderById(Long id);
    public abstract List<Recorder> getRecorderListSave();    
    public abstract List<Member> getMemberList();    
    public abstract List<Recorder> getRecorderListByMember(Member m);
    public abstract List<Recorder> getRecorderListSaveByDate(Date beginDate,Date endDate);
    public abstract List<Recorder> getRecorderListDisByDate(Date beginDate,Date endDate);

    //Machine
    public abstract void saveMachine(Machine val);
    public abstract void removeMachine(Machine val);
    public abstract void removeMachine(Long id);
    public abstract Machine getMachineById(Long id);
    public abstract List<Machine> getMachineList();
    public abstract List<Machine> getMachineListByMember(Member member);
}

