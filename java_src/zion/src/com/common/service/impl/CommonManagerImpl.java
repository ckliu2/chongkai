package com.common.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;
import com.base.service.impl.BaseManagerImpl;
import com.base.value.AppProperty;
import com.base.value.Function;
import com.base.value.FunctionAuthority;
import com.base.value.FunctionCategory;
import com.base.value.Group;
import com.base.value.MiscCode;
import com.common.dao.CommonDAO;
import com.common.service.CommonManager;
import com.common.value.*;
import com.base.value.*;


public class CommonManagerImpl extends BaseManagerImpl implements CommonManager
{
    public CommonManagerImpl()
    {
        super();
    }
    
    public void saveChecking(Checking obj)
    {
        getGenericDAO().saveChecking(obj);
    }

    public CommonDAO getGenericDAO()
    {
        return (CommonDAO)super.getGenericDAO();
    }

    public void setGenericDAO(CommonDAO dao)
    {
        super.setGenericDAO(dao);
    }

    public void saveAppProperty(AppProperty val)
    {
        getGenericDAO().saveAppProperty(val);
    }

    public void updateMiscCode(MiscCode val)
    {
        getGenericDAO().updateMiscCode(val);
    }

    public void removeAppProperty(AppProperty val)
    {
        getGenericDAO().removeAppProperty(val);
    }

    public void removeAppProperty(Long id)
    {
        getGenericDAO().removeAppProperty(id);
    }

    public AppProperty getAppPropertyById(Long id)
    {
         return getGenericDAO().findAppPropertyById(id);
    }

    public List getAppPropertyList()
    {
        java.util.List ls = getGenericDAO().findAllAppProperty();
        //System.out.println("===========>" + ls);
        return ls;
    }
    
    
    public List<AppProperty> getAppPropertyListByIds(Long[] ids)
    {
    	return getGenericDAO().findAllAppPropertyByIds(ids);
    }
    
    public List getMaxSeqNoOfAppPropertyByKind(String kind)
    {
        return getGenericDAO().getMaxSeqNoOfAppPropertyByKind(kind);
    }

    public Group getGroupById(Long id)
    {
        return getGenericDAO().findGroupById(id);
    }
    public void saveGroup(Group val)
    {
        getGenericDAO().saveGroup(val);
    }

    public void removeGroup(Group val)
    {
        getGenericDAO().removeGroup(val);
    }

    public void removeGroup(Long id)
    {
        getGenericDAO().removeGroup(id);
    }

    public void saveFunction(Function val)
    {
        getGenericDAO().saveFunction(val);
    }

    public void removeFunction(Function val)
    {
        getGenericDAO().removeFunction(val);
    }

    public void removeFunction(Long id)
    {
        getGenericDAO().removeFunction(id);
    }

    public Function getFunctionById(Long id)
    {
         return getGenericDAO().findFunctionById(id);
    }

    public List getFunctionList()
    {
        return getGenericDAO().findAllFunction();
    }

    public List getOnlineFunctionList()
    {
        return getGenericDAO().findOnlineFunction();
    }

    public List getCategoryList()
    {
        return getGenericDAO().findCategoryList();
    }

    public void saveFunctionCategory(FunctionCategory val)
    {
        getGenericDAO().saveFunctionCategory(val);
    }

    public void removeFunctionCategory(FunctionCategory val)
    {
        getGenericDAO().removeFunctionCategory(val);
    }

    public void removeFunctionCategory(Long id)
    {
        getGenericDAO().removeFunctionCategory(id);
    }

    public FunctionCategory getFunctionCategoryById(Long id)
    {
         return getGenericDAO().findFunctionCategoryById(id);
    }

    public List getFunctionCategoryList()
    {
        return getGenericDAO().findAllFunctionCategory();
    }

    public List getFrontFunctionCategoryList()
    {
        return getGenericDAO().findFrontFunctionCategoryList();
    }

    public void saveFunctionAuthority(FunctionAuthority val)
    {
        getGenericDAO().saveFunctionAuthority(val);
    }

    public void removeFunctionAuthority(FunctionAuthority val)
    {
        getGenericDAO().removeFunctionAuthority(val);
    }

    public void removeFunctionAuthority(Long id)
    {
        getGenericDAO().removeFunctionAuthority(id);
    }

    public FunctionAuthority getFunctionAuthorityById(Long id)
    {
         return getGenericDAO().findFunctionAuthorityById(id);
    }

    public List getFunctionAuthorityList()
    {
        return getGenericDAO().findAllFunctionAuthority();
    }
    public List getGroupList()
    {
        return getGenericDAO().findGroupList();
    }

    public Set getGroupListByIds(Long[] ids)
    {
        return getGenericDAO().getGroupListByIds(ids);
    }
    
    public List getSurveyGroupListByIds(Long[] ids)
    {
        return getGenericDAO().getSurveyGroupListByIds(ids);
    }  
    
    
    public Set getUnitListByIds(Long[] ids)
    {
        return getGenericDAO().getUnitListByIds(ids);
    }
    
    
    
    public Long[] getIdsFromGradeList(Set ids)
    {
        return getGenericDAO().getIdsFromGradeList(ids);
    }
    
    public Long[] getIdsFromTeamList(Set ids)
    {
        return getGenericDAO().getIdsFromTeamList(ids);
    }

    
    
    public Long[] getIdsFromGroupList(Set ids)
    {
        return getGenericDAO().getIdsFromGroupList(ids);
    }
    
    public Long[] getIdsFromSurveyGroupList(List ids)
    {
        return getGenericDAO().getIdsFromSurveyGroupList(ids);
    }
    
    public Long[] getIdsFromUnitList(Set ids)
    {
        return getGenericDAO().getIdsFromUnitList(ids);
    }
    
    
    public void saveWebSite(WebSite val)
    {
        getGenericDAO().saveWebSite(val);
    }

    public void removeWebSite(WebSite val)
    {
        getGenericDAO().removeWebSite(val);
    }

    public void removeWebSite(Long id)
    {
        getGenericDAO().removeWebSite(id);
    }

    public WebSite getWebSiteById(Long id)
    {
         return getGenericDAO().findWebSiteById(id);
    }

    public WebSite getWebSiteByCode(String code)
    {
         return getGenericDAO().findWebSiteByCode(code);
    }

    public List getWebSiteList()
    {
        return getGenericDAO().findAllWebSite();
    }
    public Long[] getIdsFromFunctionCategoryList(List al)
    {
        return getGenericDAO().getIdsFromFunctionCategoryList(al);        
    }
    //getIdsFromFunctionCategoryList

    public List getFunctionCategoryListByIds(Long[] ids)
    {
         return getGenericDAO().getFunctionCategoryListByIds(ids);
    }


    public List getOnlineUserFunctionListByFunctionCategoryList(List al)
    {
        return getGenericDAO().getOnlineUserFunctionListByFunctionCategoryList(al);
    }
    
    public List getAllOnlineUserFunctionList()
    {
        return getGenericDAO().getAllOnlineUserFunctionList();
    }

    public void saveMember(Member val)
    {
        getGenericDAO().saveMember(val);
    }

    public void removeMember(Member val)
    {
        getGenericDAO().removeMember(val);
    }

    public void removeMember(Long id)
    {
        getGenericDAO().removeMember(id);
    }

    public Member getMemberById(Long id)
    {
         return getGenericDAO().findMemberById(id);
    }
    
    public Member getMemberByEmail(String email)
    {
         return getGenericDAO().findMemberByEmail(email);
    }

    public List<Member> getMemberList()
    {
        return getGenericDAO().findAllMember();
    }
    
    public Member getMemberByCardId(String cardId)
    {
         return getGenericDAO().findMemberByCardId(cardId);
    }
    
    public Member getMemberByIdWithMD5(String id)
    {
         return getGenericDAO().findMemberByIdWithMD5(id);
    }

    
    public List<Member> getQueryMemberList(String name)
    {
        return getGenericDAO().findQueryMember(name);
    }

    public Member getMemberByCellphone(String cellphone)
    {
        return getGenericDAO().findMemberByCellphone(cellphone);
    }
    
    public Set getMemberListByIds(Long[] ids)
    {
        return getGenericDAO().getMemberListByIds(ids);
    }
    
        public Long[] getIdsFromMemberList(Set ids)
    {
        return getGenericDAO().getIdsFromMemberList(ids);
    }
        
        
    public List<Member> getMemberListById(Long[] ids)
        {
            return getGenericDAO().getMemberListById(ids);
        }
        
   public Long[] getIdFromMemberList(List ids)
        {
            return getGenericDAO().getIdFromMemberList(ids);
        }    
   
        
    
    public List<UploadedFile> getPhotoList()
    {
        return getGenericDAO().findPhotoList();
    }
    
    
    public void saveMiscCode(MiscCode val)
    {
        getGenericDAO().saveMiscCode(val);
    }

    public void removeMiscCode(MiscCode val)
    {
        getGenericDAO().removeMiscCode(val);
    }

    public void removeMiscCode(Long id)
    {
        getGenericDAO().removeMiscCode(id);
    }

    public MiscCode getMiscCodeById(Long id)
    {
         return getGenericDAO().findMiscCodeById(id);
    }

    public List<MiscCode> getMiscCodeList()
    {
        return getGenericDAO().findAllMiscCode();
    }
    
    public List<MiscCode> getMiscCodeListByTw()
    {
        return getGenericDAO().findMiscCodeListByTw();
    }
    
    //Admin
    public boolean  isSuperUser(Long memberid){
    	return getGenericDAO().isSuperUser(memberid);
    }
    
    /**產生Unit 實作*/
    
    public void saveUnit(Unit val)
    {
        getGenericDAO().saveUnit(val);
    }

    public void removeUnit(Unit val)
    {
        getGenericDAO().removeUnit(val);
    }

    public void removeUnit(Long id)
    {
        getGenericDAO().removeUnit(id);
    }

    public Unit getUnitById(Long id)
    {
         return getGenericDAO().findUnitById(id);
    }
    
    public List<Unit> getUnitList()
    {
        return getGenericDAO().findAllUnit();
    }
    
    /**產生Unit 實作*/    
    

    
    /**職稱*/
    public void saveGrade(Grade val)
    {
        getGenericDAO().saveGrade(val);
    }

    public void removeGrade(Grade val)
    {
        getGenericDAO().removeGrade(val);
    }

    public void removeGrade(Long id)
    {
        getGenericDAO().removeGrade(id);
    }

    public Grade getGradeById(Long id)
    {
         return getGenericDAO().findGradeById(id);
    }

    public List<Grade> getGradeList()
    {
        return getGenericDAO().findAllGrade();
    }
    
    public Set getGradeListByIds(Long[] ids)
    {
        return getGenericDAO().getGradeListByIds(ids);
    }
    
    
    /*
     ************************ 
     * WEBLOG 
     ************************
     */
    
    public void saveWebLog(WebLog val)
    {
        getGenericDAO().saveWebLog(val);
    }

    public void removeWebLog(WebLog val)
    {
        getGenericDAO().removeWebLog(val);
    }

    public void removeWebLog(Long id)
    {
        getGenericDAO().removeWebLog(id);
    }

    public WebLog getWebLogById(Long id)
    {
         return getGenericDAO().findWebLogById(id);
    }

    public List<WebLog> getWebLogList()
    {
        return getGenericDAO().findAllWebLog();
    }
    
    /*
     ************************ 
     * 組別管理 
     ************************
    */
    public void saveTeam(Team val)
    {
        getGenericDAO().saveTeam(val);
    }

    public void removeTeam(Team val)
    {
        getGenericDAO().removeTeam(val);
    }

    public void removeTeam(Long id)
    {
        getGenericDAO().removeTeam(id);
    }

    public Team getTeamById(Long id)
    {
         return getGenericDAO().findTeamById(id);
    }

    public List<Team> getTeamList()
    {
        return getGenericDAO().findAllTeam();
    }
    public List<Member> getPrimaryLeaderList()
    {
        return getGenericDAO().findPrimaryLeaderList();
    }

    public List<Member> getSecondLeaderList()
    {
        return getGenericDAO().findSecondLeaderList();
    }

    public Long[] getIdsFromMemberList(List<Member> lst)
    {
        return getGenericDAO().getIdsFromMemberList(lst);
    }
    
    
    public Set getTeamListByIds(Long[] ids)
    {
        return getGenericDAO().getTeamListByIds(ids);
    }


    /*
     ************************ 
     * Industry 
     ************************
    */
    
    public void saveIndustry(Industry val)
    {
        getGenericDAO().saveIndustry(val);
    }

    public void removeIndustry(Industry val)
    {
        getGenericDAO().removeIndustry(val);
    }

    public void removeIndustry(Long id)
    {
        getGenericDAO().removeIndustry(id);
    }

    public Industry getIndustryById(Long id)
    {
         return getGenericDAO().findIndustryById(id);
    }

    public List<Industry> getIndustryList()
    {
        return getGenericDAO().findAllIndustry();
    }

    public Set getIndustryListByIds(Long[] ids)
    {
        return getGenericDAO().getIndustryListByIds(ids);
    }

    /*
     ************************ 
     * SMSMAIL 
     ************************
    */ 
    public  void saveSmsMailRec(SmsMailRec val){
   	   getGenericDAO().saveSmsMailRec(val);
   }
   
   public  List<SmsMailRec> getSmsMailRecList(Member m){
   	   return getGenericDAO().findAllSmsMailRec(m);
   }
   public  SmsMailRec getSmsMailRecById(Long id){
   	   return getGenericDAO().findSmsMailRecById(id);
   }
   
   /*
    ************************ 
    * Department 
    ************************
   */ 
   
   public void saveDepartment(Department val)
   {
       getGenericDAO().saveDepartment(val);
   }

   public void removeDepartment(Department val)
   {
       getGenericDAO().removeDepartment(val);
   }

   public void removeDepartment(Long id)
   {
       getGenericDAO().removeDepartment(id);
   }

   public Department getDepartmentById(Long id)
   {
        return getGenericDAO().findDepartmentById(id);
   }

   public List<Department> getDepartmentList()
   {
       return getGenericDAO().findAllDepartment();
   }
   public Set getDepartmentListByIds(Long[] ids)
   {
       return getGenericDAO().getDepartmentListByIds(ids);
   }

    
 
 
}
