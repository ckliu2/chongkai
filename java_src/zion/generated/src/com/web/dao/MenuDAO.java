package com.web.dao;

import com.web.value.Menu;
import java.util.*;
import com.common.dao.CommonDAO;

/**
 WebWork Application Generator V 1.0

    Copyright 2006 Chih-Shyang Chang
    Created Date: Wed Jun 04 15:59:11 CST 2014
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

