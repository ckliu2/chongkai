<%@ include file="/common/taglibs.jsp"%>


<table border="0" cellspacing="1" >
      <tr>
        <td class="cContentTitle" ><fmt:message key="member.list"/></td>
      </tr>    
      <tr>
        <td class="cMenuItem">        
        
        <form  method="post">


          請輸入真實姓名/暱稱:<ww:textfield name="keyword"   id="keyword"  maxlength="10"  cssClass="cInputTextFieldShort" />
          <input type="submit" value="<fmt:message key="common.search"/>" class="cButton" >
         </form>
         </td>         
      </tr>
      
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editMember.do'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>            </ww:if>
         </ww:if>
        <ww:else>
            <button onclick="location.href='editMember.do'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>        </ww:else>        </td>
      </tr>
      <tr>
        <td>


<c:set var="count" value="0" />
<display:table name="memberList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
   
    <display:column property="name" sortable="true" title="真實姓名" style="text-align:left" />
    <display:column property="nickname" sortable="true" title="暱稱" style="text-align:left" />
    <display:column property="cellphone" sortable="true" title="手機" style="text-align:left" />
    <display:column property="email" sortable="true" title="Email" style="text-align:left" />
    
    <display:column property="groups" sortable="true" titleKey="member.groups" style="text-align:left" />
    <display:column property="grades" sortable="true" titleKey="member.grades" style="text-align:left" />
    <display:column property="teams" sortable="true" titleKey="member.teams" style="text-align:left" />
    
  
    <display:column titleKey="common.action">
        <ww:if test="recordEditable == true">
            <a href="editMember.do?member.id=<c:out value="${row.id}"/>"><fmt:message key="common.edit"/></a>&nbsp;&nbsp;
            <a href="#" onClick="javascript:return myConfirm('<fmt:message key="common.confirmDelete1"/><c:out value="${row.name}" /><fmt:message key="common.confirmDelete2"/>', 'form1', 'member.id', '${row.id}')"><fmt:message key="common.delete"/></a>        </ww:if>
        <ww:else>
           <a href="editMember.do?member.id=<c:out value="${row.id}"/>"><fmt:message key="common.view"/></a>&nbsp;&nbsp;        </ww:else>
    </display:column>
    <c:set var="count" value="${count+1}" />
   
</display:table>        



</td>
    </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editMember.do'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>            </ww:if>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editMember.do'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>        </ww:else>        </td>
      </tr>
</table>
<form name="form1" action="saveMember.do">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="member.id" value="">
    <select name="selectedMemberIds" multiple="true" style="display:none"></select>
</form>




