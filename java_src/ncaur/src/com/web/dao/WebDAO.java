package com.web.dao;

import com.web.value.*;

import java.util.*;

import com.base.value.AppProperty;
import com.city.dao.CityDAO;
import com.common.dao.CommonDAO;
import com.common.value.Member;

public interface WebDAO extends CityDAO 
{
    //���������O
	public abstract void saveBolgClass(BolgClass val);
    public abstract void removeBolgClass(BolgClass val);
    public abstract void removeBolgClass(Long id);
    public abstract BolgClass findBolgClassById(Long id);
    public abstract List<BolgClass> findAllBolgClass();
    
    
    //������
    public abstract void saveBolg(Bolg val);
    public abstract void removeBolg(Bolg val);
    public abstract void removeBolg(Long id);
    public abstract Bolg findBolgById(Long id);
    public abstract List<Bolg> findAllBolg();
    public abstract List<Bolg> findBolgByBlogClass(BolgClass b);

    
    //�W�s��
    public abstract void saveLinks(Links val);
    public abstract void removeLinks(Links val);
    public abstract void removeLinks(Long id);
    public abstract Links findLinksById(Long id);
    public abstract List<Links> findAllLinks();
    
    //���i�޲z
    public abstract void saveBulletin(Bulletin val);
    public abstract void removeBulletin(Bulletin val);
    public abstract void removeBulletin(Long id);
    public abstract Bulletin findBulletinById(Long id);
    public abstract List<Bulletin> findAllBulletin();
    public abstract List<Bulletin> findQueryBulletinList(AppProperty bulletinType,String subject,Date begindate,Date enddate);
    public abstract Bulletin getTopBulletin();
    public List<Bulletin> getBulletinByTopList(AppProperty bulletinType,Integer num);
    
    //�D���
    public abstract void saveMenu(Menu val);
    public abstract void removeMenu(Menu val);
    public abstract void removeMenu(Long id);
    public abstract Menu findMenuById(Long id);
    public abstract List<Menu> findAllMenu();

    
    //�l���
    public abstract void saveSubMenu(SubMenu val);
    public abstract void removeSubMenu(SubMenu val);
    public abstract void removeSubMenu(Long id);
    public abstract SubMenu findSubMenuById(Long id);
    public abstract List<SubMenu> findAllSubMenu();
    public abstract List<Menu> findMenuList();
    public abstract List<SubMenu> findSubMenuByMenu(Long id);
    public abstract boolean isEndSubMenuBySubMenuId(Long id);
    
    //�l�ﶵ
    public abstract void saveSubItem(SubItem val);
    public abstract void removeSubItem(SubItem val);
    public abstract void removeSubItem(Long id);
    public abstract SubItem findSubItemById(Long id);
    public abstract List<SubItem> findAllSubItem();
    public abstract List<SubMenu> findSubMenuList();
    public abstract List<SubItem> findAllSubItemBySubMenu(Long id);

   //ñ�e���A
    public abstract void saveCheckingState(CheckingState val);
    public abstract void removeCheckingState(CheckingState val);
    public abstract void removeCheckingState(Long id);
    public abstract CheckingState findCheckingStateById(Long id);
    public abstract List<CheckingState> findAllCheckingState();

    //�ɬq�޲z
    public abstract void saveClock(Clock val);
    public abstract void removeClock(Clock val);
    public abstract void removeClock(Long id);
    public abstract Clock findClockById(Long id);
    public abstract List<Clock> findAllClock();  

  
    //���a�޲z 
    public abstract void saveRoom(Room val);
    public abstract void removeRoom(Room val);
    public abstract void removeRoom(Long id);
    public abstract Room findRoomById(Long id);
    public abstract List<Room> findAllRoom();    
    public abstract List<Room> findAllRoomById(Long[] ids); 
    public abstract Long[] getIdsFromRoomList(List<Room> lst);
    
    //AgreeTerms
    public abstract void saveAgreeTerms(AgreeTerms val);
    public abstract AgreeTerms getAgreeTermsByMember(Member member);
    
    //PerRefer
    public abstract void savePerRefer(PerRefer val);
    public abstract void removePerRefer(PerRefer val);
    public abstract void removePerRefer(Long id);
    public abstract PerRefer findPerReferById(Long id);
    public abstract List<PerRefer> findAllPerRefer();
    
    //Consultant
    public abstract void saveConsultant(Consultant val);
    public abstract void removeConsultant(Consultant val);
    public abstract void removeConsultant(Long id);
    public abstract Consultant findConsultantById(Long id);
    public abstract List<Consultant> findAllConsultant();
    
}

