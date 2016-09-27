package com.city.web.action;

import com.city.value.*;
import com.city.service.CityManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.*;

import com.common.value.*;
import com.common.web.action.CommonActionSupport;
import com.base.util.*;
import com.base.value.*;

public class WebAction extends CommonActionSupport {

    
    
    public void setGenericManager(CityManager m) {
	super.setGenericManager(m);
    }

    public CityManager getGenericManager() {
	return (CityManager) super.getGenericManager();
    }
    
    public String list() {
	return SUCCESS;
    }

}
