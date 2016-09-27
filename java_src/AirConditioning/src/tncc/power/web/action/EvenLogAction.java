package tncc.power.web.action;

import tncc.power.value.*;
import tncc.power.service.PowerManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.Tools;
import com.base.value.Function;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Mon Apr 25 16:41:09 CST 2011
*/

public class EvenLogAction extends CommonActionSupport
{

    private static final long serialVersionUID = 1L;
    private final Log log;
    private EvenLog evenLog;
    private Long[] selectedEvenLogIds;

    public EvenLogAction()
    {
        log = LogFactory.getLog(tncc.power.web.action.EvenLogAction.class);
    }

    public Function getFunction()
    {
        return getGenericManager().getFunctionByKey("EVENLOG");
    }

    public EvenLog getEvenLog()
    {
        return evenLog;
    }

    public void setEvenLog(EvenLog val)
    {
        evenLog = val;
    }

    public void setGenericManager(PowerManager m)
    {
        super.setGenericManager(m);
    }

    public PowerManager getGenericManager()
    {
        return (PowerManager) super.getGenericManager();
    }

    public String list()
    {
        return SUCCESS;
    }

    public List<EvenLog> getEvenLogList()
    {
        return getGenericManager().getEvenLogList();
    }
}
