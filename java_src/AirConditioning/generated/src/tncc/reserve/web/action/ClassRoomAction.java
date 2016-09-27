package tncc.reserve.web.action;

import tncc.reserve.value.ClassRoom;
import tncc.reserve.service.ClassRoomManager;
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

public class ClassRoomAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private ClassRoom classRoom;
    private Long[] readersIds;
    private Long[] selectedClassRoomIds;

    public ClassRoomAction()
    {
        log = LogFactory.getLog(tncc.reserve.web.action.ClassRoomAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("CLASSROOM");
    }

    public ClassRoom getClassRoom()
    {
        return classRoom;
    }

    public void setClassRoom(ClassRoom val)
    {
        classRoom = val;
    }

    public void setGenericManager(ClassRoomManager m)
    {
        super.setGenericManager(m);
    }

    public ClassRoomManager getGenericManager()
    {
        return (ClassRoomManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeClassRoom(classRoom.getId());
        return DELETE;
    }

    public String edit()
    {
        if (classRoom == null) {
            classRoom = new ClassRoom();
        } else if (classRoom.getId() != null) {
            classRoom = getGenericManager().getClassRoomById(classRoom.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedClassRoomIds != null && selectedClassRoomIds.length > 0) {
            ClassRoom obj = getGenericManager().getClassRoomById(selectedClassRoomIds[0]);
            obj.setId(null);
            classRoom = obj;
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
            if (inputValidation(classRoom) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(ClassRoom val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveClassRoom(classRoom);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        readersIds = getGenericManager().getIdsFromReaderList(classRoom.getReaders());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        classRoom.setReaders(getGenericManager().getReaderListByIds(readersIds)); 
        log.info("exit formToBean()");
    }
    public List<Set> getReadersList()
    {
        return getGenericManager().getReadersList(); // TODO
    }

    public void setReadersIds(Long[] val)
    {
        readersIds = val;
    }

    public Long[] getReadersIds()
    {
        return readersIds;
    }

    public List<ClassRoom> getClassRoomList()
    {
        return getGenericManager().getClassRoomList();
    }

    public void setSelectedClassRoomIds(Long[] val)
    {
        selectedClassRoomIds = val;
    }

    public Long[] getSelectedClassRoomIds()
    {
        return selectedClassRoomIds;
    }
}
