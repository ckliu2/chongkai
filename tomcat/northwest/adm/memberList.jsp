<%@ include file="/common/taglibs.jsp"%>

<form method="POST">
           <img src="images/search.jpg">
           <span class="cLabel2"><fmt:message key="common.keyin"/><fmt:message key="common.loginId"/> or <fmt:message key="member.name"/>:</span>          
           <ww:textfield name="cardId" value="%{cardId}" maxlength="40" cssClass="cInputTextFieldShort" /> 
           <input type="submit" value="<fmt:message key="common.search"/>" class="cButton">
</form>



<table border="0" cellspacing="1" class="cContentTable">
      <tr>
        <td class="cContentTitle" ><fmt:message key="member.list"/></td>
      </tr>    

      <tr>
        <td>
<c:set var="count" value="1" />
<display:table name="memberList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}"   sort="list" >
    <display:setProperty name="paging.banner.placement" value="bottom" />
    
     <display:column titleKey="common.id" style="text-align:left" sortable="true">     
        <c:out value="${count}"/>
     </display:column>
    
    <display:column property="id" sortable="true" titleKey="common.loginId" /> 
    <display:column property="name" sortable="true" titleKey="member.name" style="text-align:left" />
    <display:column property="idNo" sortable="true" titleKey="member.idNo" /> 
    <display:column property="phone" sortable="true" titleKey="member.phone" /> 
    <display:column property="flagName" sortable="true" titleKey="member.flag" />
    <display:column property="groups" sortable="true" titleKey="member.group" />    
    <c:set var="count" value="${count+1}" />
</display:table> 



     

</td>
    </tr>

</table>


<form name="form1" action="saveMember.html">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="member.id" value="">
    <select name="selectedMemberIds" multiple="true" style="display:none"></select>
</form>







