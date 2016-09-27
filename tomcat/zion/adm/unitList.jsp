<%@ include file="/common/taglibs.jsp"%>
<table border="0" cellspacing="1" >
      <tr>
        <td class="cContentTitle" ><fmt:message key="unit.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editUnit.do'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>

        </ww:if>
        <ww:else>
            <button onclick="location.href='editUnit.do'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
      <tr>
        <td>
        
        
<c:set var="count" value="0" />

<display:table name="unitList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="10" sort="list">
    <display:column property="name" sortable="true" titleKey="unit.name" style="text-align:left" />
    <display:column property="ename" sortable="true" titleKey="unit.ename" style="text-align:left" />
    
    <display:column property="members" sortable="true" titleKey="member.unit" style="text-align:left" />
    
    
    <display:column property="lastModifiedDate" sortable="true" titleKey="common.lastModifiedDate" style="text-align:left" />
    <display:column property="lastModifiedUser" sortable="true" titleKey="common.lastModifiedUser" style="text-align:left" />
   
   
    <display:column titleKey="common.action">
        <ww:if test="recordEditable == true">
            <a href="editUnit.do?unit.id=<c:out value="${row.id}"/>"><fmt:message key="common.edit"/></a>&nbsp;&nbsp;
             <a href="#" onClick="javascript:return myConfirm('<fmt:message key="common.confirmDelete1"/><c:out value="${row.name}" /><fmt:message key="common.confirmDelete2"/>', 'form1', 'unit.id', '${row.id}')"><fmt:message key="common.delete"/></a>
         </ww:if>
        <ww:else>
           <a href="editUnit.do?unit.id=<c:out value="${row.id}"/>"><fmt:message key="common.view"/></a>&nbsp;&nbsp;
        </ww:else>
    </display:column>
   
   
   <c:set var="count" value="${count+1}" />
</display:table>



    
    
        </td>
    </tr>
    
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editUnit.do'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
           
        </ww:if>
        <ww:else>
            <button onclick="location.href='editUnit.do'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
      
</table>



<form name="form1" action="saveUnit.do">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="unit.id" value="">
   
</form>

