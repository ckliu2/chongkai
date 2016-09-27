package org.zion.web.action;

import org.zion.value.Message;
import org.zion.service.MessageManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Dec 08 14:37:53 CST 2014
*/

public class MessageAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private Message message;
    private String messageDate;
    private Long[] selectedMessageIds;

    public MessageAction()
    {
        log = LogFactory.getLog(org.zion.web.action.MessageAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("MESSAGE");
    }

    public Message getMessage()
    {
        return message;
    }

    public void setMessage(Message val)
    {
        message = val;
    }

    public void setGenericManager(MessageManager m)
    {
        super.setGenericManager(m);
    }

    public MessageManager getGenericManager()
    {
        return (MessageManager) super.getGenericManager();
    }

    public String delete()
    {
        getGenericManager().removeMessage(message.getId());
        return DELETE;
    }

    public String edit()
    {
        if (message == null) {
            message = new Message();
        } else if (message.getId() != null) {
            message = getGenericManager().getMessageById(message.getId());
        } else { // TODO
        }
        beanToForm();

        return SUCCESS;
    }

    public String copy()
    {
        if (selectedMessageIds != null && selectedMessageIds.length > 0) {
            Message obj = getGenericManager().getMessageById(selectedMessageIds[0]);
            obj.setId(null);
            message = obj;
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
            if (inputValidation(message) == false) 
                return INPUT;
        }
        return SUCCESS;
    }

    public boolean inputValidation(Message val)
    {
        return true;
    }

    public String save()
    {
        log.info("entering 'save' method");
        getGenericManager().saveMessage(message);
        return SUCCESS;
    }

    public String list()
    {
        return SUCCESS;
    }

    protected void beanToForm()
    {
        log.info("enter beanToForm()");
        messageDate = Tools.dateToString(message.getMessageDate());
        log.info("exit beanToForm()");
    }

    protected void formToBean()
    {
        log.info("enter formToBean()");
        message.setMessageDate(Tools.convertToDate(messageDate)); 
        log.info("exit formToBean()");
    }
    public void setMessageDate(String val)
    {
        messageDate = val;
    }

    public String getMessageDate()
    {
        return messageDate;
    }

    public List<Message> getMessageList()
    {
        return getGenericManager().getMessageList();
    }

    public void setSelectedMessageIds(Long[] val)
    {
        selectedMessageIds = val;
    }

    public Long[] getSelectedMessageIds()
    {
        return selectedMessageIds;
    }
}
