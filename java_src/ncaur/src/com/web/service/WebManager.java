package com.web.service;

import com.web.value.*;
import java.util.*;

import com.common.service.CommonManager;
import com.common.value.Member;
import com.base.value.*;
import com.city.service.*;

//CommonManager
public interface WebManager extends CityManager 
{
    //部落格類別
    public abstract void saveBolgClass(BolgClass val);
    public abstract void removeBolgClass(BolgClass val);
    public abstract void removeBolgClass(Long id);
    public abstract BolgClass getBolgClassById(Long id);
    public abstract List<BolgClass> getBolgClassList(); 

    
    //部落格
    public abstract void saveBolg(Bolg val);
    public abstract void removeBolg(Bolg val);
    public abstract void removeBolg(Long id);
    public abstract Bolg getBolgById(Long id);
    public abstract List<Bolg> getBolgList();
    public abstract List<Bolg> getBolgByBlogClass(BolgClass b);

    
    //超連接
    public abstract void saveLinks(Links val);
    public abstract void removeLinks(Links val);
    public abstract void removeLinks(Long id);
    public abstract Links getLinksById(Long id);
    public abstract List<Links> getLinksList();   

    
    
    //主選單
    public abstract void saveMenu(Menu val);
    public abstract void removeMenu(Menu val);
    public abstract void removeMenu(Long id);
    public abstract Menu getMenuById(Long id);
    public abstract List<Menu> getMenuList();

    
    //子選單
    public abstract void saveSubMenu(SubMenu val);
    public abstract void removeSubMenu(SubMenu val);
    public abstract void removeSubMenu(Long id);
    public abstract SubMenu getSubMenuById(Long id);
    public abstract List<SubMenu> getSubMenuList();
    public abstract List<SubMenu> getSubMenuByMenu(Long id);
    public abstract boolean isEndSubMenuBySubMenuId(Long id);

    
    //子項目
    public abstract void saveSubItem(SubItem val);
    public abstract void removeSubItem(SubItem val);
    public abstract void removeSubItem(Long id);
    public abstract SubItem getSubItemById(Long id);
    public abstract List<SubItem> getSubItemList();
    public abstract List<SubItem> getSubItemBySubMenu(Long id);
    
    //公告管理
    public abstract void saveBulletin(Bulletin val);
    public abstract void removeBulletin(Bulletin val);
    public abstract void removeBulletin(Long id);
    public abstract Bulletin getBulletinById(Long id);
    public abstract List<Bulletin> getBulletinList();
    public abstract List<Bulletin> getQueryBulletinList(AppProperty bulletinType,String subject,Date begindate,Date enddate);
    public abstract Bulletin getTopBulletin();
    public abstract List<Bulletin> getBulletinByTopList(AppProperty bulletinType,Integer num);
    
    //簽呈狀態
    public abstract void saveCheckingState(CheckingState val);
    public abstract void removeCheckingState(CheckingState val);
    public abstract void removeCheckingState(Long id);
    public abstract CheckingState getCheckingStateById(Long id);
    public abstract List<CheckingState> getCheckingStateList();
    
    //時段管理
    public abstract void saveClock(Clock val);
    public abstract void removeClock(Clock val);
    public abstract void removeClock(Long id);
    public abstract Clock getClockById(Long id);
    public abstract List<Clock> getClockList();
    
  
    
    //場地管理   
    public abstract void saveRoom(Room val);
    public abstract void removeRoom(Room val);
    public abstract void removeRoom(Long id);
    public abstract Room getRoomById(Long id);
    public abstract List<Room> getRoomList();
    public abstract List<Room> getRoomListByIds(Long[] ids);
    public abstract Long[] getIdsFromRoomList(List<Room> lst); 
    
    //AgreeTerms
    public abstract void saveAgreeTerms(AgreeTerms val);
    public abstract AgreeTerms getAgreeTermsByMember(Member member);
    
    //PerRefer
    public abstract void savePerRefer(PerRefer val);
    public abstract void removePerRefer(PerRefer val);
    public abstract void removePerRefer(Long id);
    public abstract PerRefer getPerReferById(Long id);
    public abstract List<PerRefer> getPerReferList();
    
    //Consultant
    public abstract void saveConsultant(Consultant val);
    public abstract void removeConsultant(Consultant val);
    public abstract void removeConsultant(Long id);
    public abstract Consultant getConsultantById(Long id);
    public abstract List<Consultant> getConsultantList();
    

}

