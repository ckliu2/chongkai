package com.common.service;

import java.util.*;
import com.base.service.BaseManager;
import com.base.value.AppProperty;
import com.base.value.Function;
import com.base.value.FunctionAuthority;
import com.base.value.FunctionCategory;
import com.base.value.Group;
import com.base.value.MiscCode;
import com.common.value.*;
import com.base.value.*;



public interface CommonManager extends BaseManager
{
    
	public abstract List<AppProperty> getAppPropertyListByIds(Long[] ids); 
	public abstract AppProperty getAppPropertyById(Long id);
    public abstract Function getFunctionById(Long id);
    public abstract FunctionAuthority getFunctionAuthorityById(Long id);
    public abstract FunctionCategory getFunctionCategoryById(Long id);
    public abstract Group getGroupById(Long id);
    public abstract List getAppPropertyList();
    public abstract List getCategoryList();
    public abstract List getFunctionAuthorityList();
    public abstract List getFunctionCategoryList();
    public abstract List getFrontFunctionCategoryList();
    public abstract List getFunctionList();
    public abstract List getOnlineFunctionList();
    public abstract List getGroupList();
    public abstract Set getGroupListByIds(Long[] ids); 
    public abstract List getSurveyGroupListByIds(Long[] ids); 
    
    
    
    public abstract Long[] getIdsFromGradeList(Set lst); 
    public abstract Long[] getIdsFromTeamList(Set lst); 
    
    
    public abstract Long[] getIdsFromSurveyGroupList(List lst);
    public abstract Long[] getIdsFromGroupList(Set lst); 
    public abstract Long[] getIdsFromUnitList(Set lst);     
    public abstract List getMaxSeqNoOfAppPropertyByKind(String kind);
    public abstract void removeAppProperty(AppProperty val);
    public abstract void removeAppProperty(Long id);
    public abstract void removeFunction(Function val);
    public abstract void removeFunction(Long id);
    public abstract void removeFunctionAuthority(FunctionAuthority val);
    public abstract void removeFunctionAuthority(Long id);
    public abstract void removeFunctionCategory(FunctionCategory val);
    public abstract void removeFunctionCategory(Long id);
    public abstract void removeGroup(Group val);
    public abstract void removeGroup(Long id);
    public abstract void saveAppProperty(AppProperty val);
    public abstract void saveChecking(Checking obj);    
    public abstract void saveFunction(Function val);
    public abstract void saveFunctionAuthority(FunctionAuthority val);
    public abstract void saveFunctionCategory(FunctionCategory val);
    public abstract void saveGroup(Group val);

    //  WebSite
    public abstract void saveWebSite(WebSite val);
    public abstract void removeWebSite(WebSite val);
    public abstract void removeWebSite(Long id);
    public abstract WebSite getWebSiteById(Long id);
    public abstract WebSite getWebSiteByCode(String code);
    public abstract List getWebSiteList();
    public abstract Long[] getIdsFromFunctionCategoryList(List al);
    public abstract List getFunctionCategoryListByIds(Long[] ids); 

    public abstract List getOnlineUserFunctionListByFunctionCategoryList(List al);
    public abstract List getAllOnlineUserFunctionList();
  
    public abstract void saveMember(Member val);
    public abstract void removeMember(Member val);
    public abstract void removeMember(Long id);
    public abstract Member getMemberById(Long id);
    public abstract List<Member> getMemberList();  
    
    public abstract Member getMemberByIdWithMD5(String id);
    
    public abstract List<Member> getQueryMemberList(String name);
    public abstract Member getMemberByEmail(String email);
    public abstract List<UploadedFile> getPhotoList();
    
    public abstract Set getMemberListByIds(Long[] ids);
    public abstract Long[] getIdsFromMemberList(Set lst); 
    
    public abstract List<Member> getMemberListById(Long[] ids);
    public abstract Long[] getIdFromMemberList(List lst); 

    
    
    public abstract void saveMiscCode(MiscCode val);
    public abstract void updateMiscCode(MiscCode val);
    public abstract void removeMiscCode(MiscCode val);
    public abstract void removeMiscCode(Long id);
    public abstract MiscCode getMiscCodeById(Long id);
    public abstract List<MiscCode> getMiscCodeList();    
    
    public abstract List<MiscCode> getMiscCodeListByTw();
    
    
    public abstract Member getMemberByCellphone(String cellphone);
    
    public abstract Member getMemberByCardId(String cardId);
    
    
    //Admin
    public abstract boolean  isSuperUser(Long memberid);
    
    /**產生Unit*/
    public abstract void saveUnit(Unit val);
    public abstract void removeUnit(Unit val);
    public abstract void removeUnit(Long id);
    public abstract Unit getUnitById(Long id);    
    public abstract List getUnitList();    
    public abstract Set getUnitListByIds(Long[] ids);
    /**產生Unit*/  
    
    /*
    ************************ 
    * 職稱 
    ************************
    */
    public abstract void saveGrade(Grade val);
    public abstract void removeGrade(Grade val);
    public abstract void removeGrade(Long id);
    public abstract Grade getGradeById(Long id);
    public abstract List<Grade> getGradeList();
    public abstract Set getGradeListByIds(Long[] ids);
    
    /*
     ************************ 
     * WEBLOG 
     ************************
     */
    public abstract void saveWebLog(WebLog val);
    public abstract void removeWebLog(WebLog val);
    public abstract void removeWebLog(Long id);
    public abstract WebLog getWebLogById(Long id);
    public abstract List<WebLog> getWebLogList();
    
    /*
     ************************ 
     * 組別管理 
     ************************
    */
    public abstract void saveTeam(Team val);
    public abstract void removeTeam(Team val);
    public abstract void removeTeam(Long id);
    public abstract Team getTeamById(Long id);
    public abstract List<Team> getTeamList();
    public abstract List<Member> getPrimaryLeaderList();
    public abstract List<Member> getSecondLeaderList();
    public abstract Long[] getIdsFromMemberList(List<Member> lst);
    public abstract Set getTeamListByIds(Long[] ids);
    
    /*
     ************************ 
     * Industry 
     ************************
    */    
    public abstract void saveIndustry(Industry val);
    public abstract void removeIndustry(Industry val);
    public abstract void removeIndustry(Long id);
    public abstract Industry getIndustryById(Long id);
    public abstract List<Industry> getIndustryList();
    public abstract Set getIndustryListByIds(Long[] ids);
    
    /*
     ************************ 
     * Department 
     ************************
    */ 
    public abstract void saveDepartment(Department val);
    public abstract void removeDepartment(Department val);
    public abstract void removeDepartment(Long id);
    public abstract Department getDepartmentById(Long id);
    public abstract List<Department> getDepartmentList();
    public abstract Set getDepartmentListByIds(Long[] ids);

    /*
     ************************ 
     * SMSMAIL 
     ************************
    */ 
    public abstract void saveSmsMailRec(SmsMailRec val);
    public abstract List<SmsMailRec> getSmsMailRecList(Member m);
    public abstract SmsMailRec getSmsMailRecById(Long id);
    

    
}
