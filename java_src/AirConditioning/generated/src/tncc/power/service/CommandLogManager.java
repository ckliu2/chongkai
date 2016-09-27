package tncc.power.service;

import tncc.power.value.CommandLog;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public interface CommandLogManager extends CommonManager 
{
    public abstract void saveCommandLog(CommandLog val);

    public abstract void removeCommandLog(CommandLog val);

    public abstract void removeCommandLog(Long id);

    public abstract CommandLog getCommandLogById(Long id);

    public abstract List<CommandLog> getCommandLogList();
    public abstract List<Reader> getReaderList();
}

