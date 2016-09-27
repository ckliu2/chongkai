package tncc.power.dao;

import tncc.power.value.PowerController;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu Mar 20 16:19:30 CST 2014
*/

public interface PowerControllerDAO extends CommonDAO 
{
    public abstract void savePowerController(PowerController val);

    public abstract void removePowerController(PowerController val);

    public abstract void removePowerController(Long id);

    public abstract PowerController findPowerControllerById(Long id);

    public abstract List<PowerController> findAllPowerController();
    public abstract List<Building> findBuildingList();
    public abstract List<Member> findCreatedUserList();
    public abstract Long[] getIdsFromReaderList(List<Reader> lst);

    public abstract List<Reader> getReaderListByIds(Long[] ids);

}

