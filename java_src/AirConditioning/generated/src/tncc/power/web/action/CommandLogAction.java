package tncc.power.web.action;

import tncc.power.value.CommandLog;
import tncc.power.service.CommandLogManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public class CommandLogAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private CommandLog commandLog;
    private Long[] selectedCommandLogIds;

    public CommandLogAction()
    {
        log = LogFactory.getLog(tncc.power.web.action.CommandLogAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("COMMANDLOG");
    }

    public CommandLog getCommandLog()
    {
        return commandLog;
    }

    public void setCommandLog(CommandLog val)
    {
        commandLog = val;
    }

    public void setGenericManager(CommandLogManager m)
    {
        super.setGenericManager(m);
    }

    public CommandLogManager getGenericManager()
    {
        return (CommandLogManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeCommandLog(commandLog.getId());
        return DELETE;
    }

    public String edit()
    {
        if (commandLog == null) {
            commandLog = new CommandLog();
        } else if (commandLog.getId() != null) {
            commandLog = getGenericManager().getCommandLogById(commandLog.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedCommandLogIds != null && selectedCommandLogIds.length > 0) {
            CommandLog obj = getGenericManager().getCommandLogById(selectedCommandLogIds[0]);
            obj.setId(null);
            commandLog = obj;
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
            if (inputValidation(commandLog) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(CommandLog val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveCommandLog(commandLog);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        commandLog.setCommandType(getAppPropertyById(commandLog.getCommandTypeId())); 
        commandLog.setReader(getGenericManager().getReaderById(commandLog.getReaderId())); 
        log.info("exit formToBean()");
    }
    public List<AppProperty> getCommandTypeList()
    {
        return super.getAppPropertyList("commandLog.commandType");
    }

    public List<Reader> getReaderList()
    {
        return getGenericManager().getReaderList(); // TODO
    }

    public List<CommandLog> getCommandLogList()
    {
        return getGenericManager().getCommandLogList();
    }

    public void setSelectedCommandLogIds(Long[] val)
    {
        selectedCommandLogIds = val;
    }

    public Long[] getSelectedCommandLogIds()
    {
        return selectedCommandLogIds;
    }
}
