package tncc.power.service;

import tncc.power.value.PowerController;
import java.util.*;
import com.common.service.CommonManager;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public interface PowerControllerManager extends CommonManager 
{
    public abstract void savePowerController(PowerController val);

    public abstract void removePowerController(PowerController val);

    public abstract void removePowerController(Long id);

    public abstract PowerController getPowerControllerById(Long id);

    public abstract List<PowerController> getPowerControllerList();
    public abstract List<Building> getBuildingList();
    public abstract List<Member> getCreatedUserList();
    public abstract Long[] getIdsFromReaderList(List<Reader> lst);

    public abstract List<Reader> getReaderListByIds(Long[] ids);

}

