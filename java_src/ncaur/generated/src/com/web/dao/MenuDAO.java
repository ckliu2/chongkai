package com.web.dao;

import com.web.value.Menu;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Thu May 19 17:41:56 CST 2016
*/

public interface MenuDAO extends CommonDAO 
{
    public abstract void saveMenu(Menu val);

    public abstract void removeMenu(Menu val);

    public abstract void removeMenu(Long id);

    public abstract Menu findMenuById(Long id);

    public abstract List<Menu> findAllMenu();
    public abstract List<Member> findLastModifiedUserList();
    public abstract List<Member> findCreatedUserList();
}

