package com.city.web.action;

import com.city.value.Course;
import com.city.service.CourseManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public class CourseAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Course course;
    private String registerBegin;
    private String registerEnd;
    private String noteDate1;
    private String noteDate2;
    private String noteDate3;
    private String noteDate4;
    private java.io.File fileCoursefile;
    private String fileCoursefileContentType, fileCoursefileFileName, removeCoursefile;
    private java.io.File fileEmailfile;
    private String fileEmailfileContentType, fileEmailfileFileName, removeEmailfile;
    private Long[] filegroupsIds;
    private Long[] photosIds;
    private Long[] selectedCourseIds;

    public CourseAction()
    {
        log = LogFactory.getLog(com.city.web.action.CourseAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("COURSE");
    }

    public Course getCourse()
    {
        return course;
    }

    public void setCourse(Course val)
    {
        course = val;
    }

    public void setGenericManager(CourseManager m)
    {
        super.setGenericManager(m);
    }

    public CourseManager getGenericManager()
    {
        return (CourseManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeCourse(course.getId());
        return DELETE;
    }

    public String edit()
    {
        if (course == null) {
            course = new Course();
        } else if (course.getId() != null) {
            course = getGenericManager().getCourseById(course.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedCourseIds != null && selectedCourseIds.length > 0) {
            Course obj = getGenericManager().getCourseById(selectedCourseIds[0]);
            obj.setId(null);
            course = obj;
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
            if (inputValidation(course) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Course val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        java.sql.Timestamp ts = Tools.getCurrentTimestamp();
        if (course.getId() == null) {
            course.setCreatedDate(ts);
            course.setCreatedUser(getSessionUser().getLoginId());
        }
        course.setLastModifiedDate(ts);
        course.setLastModifiedUser(getSessionUser().getLoginId());
        getGenericManager().saveCourse(course);
        saveFileToLocal(fileCoursefileFileName, fileCoursefile, getTextWithArgs("course.uploadCoursefile.dir"), course.getId());
        saveFileToLocal(fileEmailfileFileName, fileEmailfile, getTextWithArgs("course.uploadEmailfile.dir"), course.getId());
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        registerBegin = Tools.dateToString(course.getRegisterBegin());
        registerEnd = Tools.dateToString(course.getRegisterEnd());
        noteDate1 = Tools.dateToString(course.getNoteDate1());
        noteDate2 = Tools.dateToString(course.getNoteDate2());
        noteDate3 = Tools.dateToString(course.getNoteDate3());
        noteDate4 = Tools.dateToString(course.getNoteDate4());
        filegroupsIds = getGenericManager().getIdsFromGroupList(course.getFilegroups());
        photosIds = getGenericManager().getIdsFromUploadedFileList(course.getPhotos());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        course.setRegisterBegin(Tools.convertToDate(registerBegin)); 
        course.setRegisterEnd(Tools.convertToDate(registerEnd)); 
        course.setNoteDate1(Tools.convertToDate(noteDate1)); 
        course.setNoteDate2(Tools.convertToDate(noteDate2)); 
        course.setNoteDate3(Tools.convertToDate(noteDate3)); 
        course.setNoteDate4(Tools.convertToDate(noteDate4)); 
        if (getRemoveCoursefile() != null && getRemoveCoursefile().length() > 0) {
            course.setCoursefile(computeUploadedFile(fileCoursefileFileName, fileCoursefile)); 
            removeUploadedFile(getTextWithArgs("course.uploadCoursefile.dir"), course.getCoursefileId(), course.getCoursefileFileName());
        } else {
            if (course.getCoursefileId() != null)
                course.setCoursefile(getGenericManager().getUploadedFileById(course.getCoursefileId())); 
            else
                course.setCoursefile(computeUploadedFile(fileCoursefileFileName, fileCoursefile)); 
        }
        if (getRemoveEmailfile() != null && getRemoveEmailfile().length() > 0) {
            course.setEmailfile(computeUploadedFile(fileEmailfileFileName, fileEmailfile)); 
            removeUploadedFile(getTextWithArgs("course.uploadEmailfile.dir"), course.getEmailfileId(), course.getEmailfileFileName());
        } else {
            if (course.getEmailfileId() != null)
                course.setEmailfile(getGenericManager().getUploadedFileById(course.getEmailfileId())); 
            else
                course.setEmailfile(computeUploadedFile(fileEmailfileFileName, fileEmailfile)); 
        }
        course.setType(getAppPropertyById(course.getTypeId())); 
        course.setFilegroups(getGenericManager().getGroupListByIds(filegroupsIds)); 
        course.setPhotos(getGenericManager().getUploadedFileListByIds(photosIds)); 
        log.info("exit formToBean()");
    }
    public void setRegisterBegin(String val)
    {
        registerBegin = val;
    }

    public String getRegisterBegin()
    {
        return registerBegin;
    }

    public void setRegisterEnd(String val)
    {
        registerEnd = val;
    }

    public String getRegisterEnd()
    {
        return registerEnd;
    }

    public void setNoteDate1(String val)
    {
        noteDate1 = val;
    }

    public String getNoteDate1()
    {
        return noteDate1;
    }

    public void setNoteDate2(String val)
    {
        noteDate2 = val;
    }

    public String getNoteDate2()
    {
        return noteDate2;
    }

    public void setNoteDate3(String val)
    {
        noteDate3 = val;
    }

    public String getNoteDate3()
    {
        return noteDate3;
    }

    public void setNoteDate4(String val)
    {
        noteDate4 = val;
    }

    public String getNoteDate4()
    {
        return noteDate4;
    }

    public void setFileCoursefile(java.io.File val)
    {
        fileCoursefile = val;
    }

    public java.io.File getFileCoursefile()
    {
        return fileCoursefile;
    }

    public void setFileCoursefileContentType(String val)
    {
        fileCoursefileContentType = val;
    }

    public String getFileCoursefileContentType()
    {
        return fileCoursefileContentType;
    }

    public void setFileCoursefileFileName(String val)
    {
        fileCoursefileFileName = val;
    }

    public String getFileCoursefileFileName()
    {
        return fileCoursefileFileName;
    }

    public void setRemoveCoursefile(String val)
    {
        removeCoursefile = val;
    }

    public String getRemoveCoursefile()
    {
        return removeCoursefile;
    }

    public void setFileEmailfile(java.io.File val)
    {
        fileEmailfile = val;
    }

    public java.io.File getFileEmailfile()
    {
        return fileEmailfile;
    }

    public void setFileEmailfileContentType(String val)
    {
        fileEmailfileContentType = val;
    }

    public String getFileEmailfileContentType()
    {
        return fileEmailfileContentType;
    }

    public void setFileEmailfileFileName(String val)
    {
        fileEmailfileFileName = val;
    }

    public String getFileEmailfileFileName()
    {
        return fileEmailfileFileName;
    }

    public void setRemoveEmailfile(String val)
    {
        removeEmailfile = val;
    }

    public String getRemoveEmailfile()
    {
        return removeEmailfile;
    }

    public List<AppProperty> getTypeList()
    {
        return super.getAppPropertyList("course.type");
    }

    public List<Group> getFilegroupsList()
    {
        List<Group> al = getGenericManager().getGroupList();
        if (al != null) {
            if (course.getFilegroups() != null)
                al.removeAll(course.getFilegroups());
            return al;
        }
        return new ArrayList<Group>();
    }

    public List<Group> getObject_filegroupsList()
    {
        return (course.getFilegroups() == null) ? new ArrayList<Group>() : course.getFilegroups();
    }

    public void setFilegroupsIds(Long[] val)
    {
        filegroupsIds = val;
    }

    public Long[] getFilegroupsIds()
    {
        return filegroupsIds;
    }

    public List<Set> getPhotosList()
    {
        return getGenericManager().getPhotosList(); // TODO
    }

    public void setPhotosIds(Long[] val)
    {
        photosIds = val;
    }

    public Long[] getPhotosIds()
    {
        return photosIds;
    }

    public List<Course> getCourseList()
    {
        return getGenericManager().getCourseList();
    }

    public void setSelectedCourseIds(Long[] val)
    {
        selectedCourseIds = val;
    }

    public Long[] getSelectedCourseIds()
    {
        return selectedCourseIds;
    }
}
