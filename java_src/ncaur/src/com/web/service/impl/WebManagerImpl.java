package com.web.service.impl;

import com.web.service.WebManager;
import com.web.dao.WebDAO;
import com.web.value.*;

import java.util.*;

import com.base.value.AppProperty;
import com.common.service.impl.CommonManagerImpl;
import com.common.value.Member;
import com.city.service.*;
import com.city.service.impl.CityManagerImpl;

public class WebManagerImpl extends CityManagerImpl implements WebManager {

	public WebDAO getGenericDAO() {
		return (WebDAO) super.getGenericDAO();
	}

	public void setGenericDAO(WebDAO dao) {
		super.setGenericDAO(dao);
	}

	// 部落格類別

	public void saveBolgClass(BolgClass val) {
		getGenericDAO().saveBolgClass(val);
	}

	public void removeBolgClass(BolgClass val) {
		getGenericDAO().removeBolgClass(val);
	}

	public void removeBolgClass(Long id) {
		getGenericDAO().removeBolgClass(id);
	}

	public BolgClass getBolgClassById(Long id) {
		return getGenericDAO().findBolgClassById(id);
	}

	public List<BolgClass> getBolgClassList() {
		return getGenericDAO().findAllBolgClass();
	}

	// 部落格
	public void saveBolg(Bolg val) {
		getGenericDAO().saveBolg(val);
	}

	public void removeBolg(Bolg val) {
		getGenericDAO().removeBolg(val);
	}

	public void removeBolg(Long id) {
		getGenericDAO().removeBolg(id);
	}

	public Bolg getBolgById(Long id) {
		return getGenericDAO().findBolgById(id);
	}

	public List<Bolg> getBolgList() {
		return getGenericDAO().findAllBolg();
	}

	public List<Bolg> getBolgByBlogClass(BolgClass b) {
		// System.out.println("getBolgByBlogClass imp="+b.getName());
		return getGenericDAO().findBolgByBlogClass(b);
	}

	// 超連結
	public void saveLinks(Links val) {
		getGenericDAO().saveLinks(val);
	}

	public void removeLinks(Links val) {
		getGenericDAO().removeLinks(val);
	}

	public void removeLinks(Long id) {
		getGenericDAO().removeLinks(id);
	}

	public Links getLinksById(Long id) {
		return getGenericDAO().findLinksById(id);
	}

	public List<Links> getLinksList() {
		return getGenericDAO().findAllLinks();
	}

	// 公告管理
	public void saveBulletin(Bulletin val) {
		getGenericDAO().saveBulletin(val);
	}

	public void removeBulletin(Bulletin val) {
		getGenericDAO().removeBulletin(val);
	}

	public void removeBulletin(Long id) {
		getGenericDAO().removeBulletin(id);
	}

	public Bulletin getBulletinById(Long id) {
		return getGenericDAO().findBulletinById(id);
	}

	public List<Bulletin> getBulletinList() {
		return getGenericDAO().findAllBulletin();
	}

	public List<Bulletin> getQueryBulletinList(AppProperty bulletinType, String subject, Date begindate, Date enddate) {
		return getGenericDAO().findQueryBulletinList(bulletinType, subject, begindate, enddate);
	}

	public Bulletin getTopBulletin() {
		return getGenericDAO().getTopBulletin();
	}

	public List<Bulletin> getBulletinByTopList(AppProperty bulletinType, Integer num) {
		return getGenericDAO().getBulletinByTopList(bulletinType, num);
	}

	// 主選單
	public void saveMenu(Menu val) {
		getGenericDAO().saveMenu(val);
	}

	public void removeMenu(Menu val) {
		getGenericDAO().removeMenu(val);
	}

	public void removeMenu(Long id) {
		getGenericDAO().removeMenu(id);
	}

	public Menu getMenuById(Long id) {
		return getGenericDAO().findMenuById(id);
	}

	public List<Menu> getMenuList() {
		return getGenericDAO().findAllMenu();
	}

	// 子選單
	public void saveSubMenu(SubMenu val) {
		getGenericDAO().saveSubMenu(val);
	}

	public void removeSubMenu(SubMenu val) {
		getGenericDAO().removeSubMenu(val);
	}

	public void removeSubMenu(Long id) {
		getGenericDAO().removeSubMenu(id);
	}

	public SubMenu getSubMenuById(Long id) {
		return getGenericDAO().findSubMenuById(id);
	}

	public List<SubMenu> getSubMenuList() {
		return getGenericDAO().findAllSubMenu();
	}

	public List<SubMenu> getSubMenuByMenu(Long id) {
		return getGenericDAO().findSubMenuByMenu(id);
	}

	public boolean isEndSubMenuBySubMenuId(Long id) {
		return getGenericDAO().isEndSubMenuBySubMenuId(id);
	}

	// 子選項
	public void saveSubItem(SubItem val) {
		getGenericDAO().saveSubItem(val);
	}

	public void removeSubItem(SubItem val) {
		getGenericDAO().removeSubItem(val);
	}

	public void removeSubItem(Long id) {
		getGenericDAO().removeSubItem(id);
	}

	public SubItem getSubItemById(Long id) {
		return getGenericDAO().findSubItemById(id);
	}

	public List<SubItem> getSubItemList() {
		return getGenericDAO().findAllSubItem();
	}

	public List<SubItem> getSubItemBySubMenu(Long id) {
		return getGenericDAO().findAllSubItemBySubMenu(id);
	}

	// 簽呈狀態
	public void saveCheckingState(CheckingState val) {
		getGenericDAO().saveCheckingState(val);
	}

	public void removeCheckingState(CheckingState val) {
		getGenericDAO().removeCheckingState(val);
	}

	public void removeCheckingState(Long id) {
		getGenericDAO().removeCheckingState(id);
	}

	public CheckingState getCheckingStateById(Long id) {
		return getGenericDAO().findCheckingStateById(id);
	}

	public List<CheckingState> getCheckingStateList() {
		return getGenericDAO().findAllCheckingState();
	}

	// 時段管理
	public void saveClock(Clock val) {
		getGenericDAO().saveClock(val);
	}

	public void removeClock(Clock val) {
		getGenericDAO().removeClock(val);
	}

	public void removeClock(Long id) {
		getGenericDAO().removeClock(id);
	}

	public Clock getClockById(Long id) {
		return getGenericDAO().findClockById(id);
	}

	public List<Clock> getClockList() {
		return getGenericDAO().findAllClock();
	}

	// 場地管理
	public void saveRoom(Room val) {
		getGenericDAO().saveRoom(val);
	}

	public void removeRoom(Room val) {
		getGenericDAO().removeRoom(val);
	}

	public void removeRoom(Long id) {
		getGenericDAO().removeRoom(id);
	}

	public Room getRoomById(Long id) {
		return getGenericDAO().findRoomById(id);
	}

	public List<Room> getRoomList() {
		return getGenericDAO().findAllRoom();
	}

	public List<Room> getRoomListByIds(Long[] ids) {
		return getGenericDAO().findAllRoomById(ids);
	}

	public Long[] getIdsFromRoomList(List<Room> lst) {
		return getGenericDAO().getIdsFromRoomList(lst);
	}

	// AgreeTerms
	public void saveAgreeTerms(AgreeTerms val) {
		getGenericDAO().saveAgreeTerms(val);
	}

	public AgreeTerms getAgreeTermsByMember(Member member) {
		return getGenericDAO().getAgreeTermsByMember(member);
	}

	//PerRefer
	public void savePerRefer(PerRefer val)
    {
        getGenericDAO().savePerRefer(val);
    }

    public void removePerRefer(PerRefer val)
    {
        getGenericDAO().removePerRefer(val);
    }

    public void removePerRefer(Long id)
    {
        getGenericDAO().removePerRefer(id);
    }

    public PerRefer getPerReferById(Long id)
    {
         return getGenericDAO().findPerReferById(id);
    }

    public List<PerRefer> getPerReferList()
    {
        return getGenericDAO().findAllPerRefer();
    }
    
    //Consultant
    public void saveConsultant(Consultant val)
    {
        getGenericDAO().saveConsultant(val);
    }

    public void removeConsultant(Consultant val)
    {
        getGenericDAO().removeConsultant(val);
    }

    public void removeConsultant(Long id)
    {
        getGenericDAO().removeConsultant(id);
    }

    public Consultant getConsultantById(Long id)
    {
         return getGenericDAO().findConsultantById(id);
    }

    public List<Consultant> getConsultantList()
    {
        return getGenericDAO().findAllConsultant();
    }
	
	
}
