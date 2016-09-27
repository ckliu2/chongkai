<%@ include file="/common/taglibs.jsp"%>

<table border="0" cellspacing="1" >
      <tr>
        <td class="cContentTitle" ><fmt:message key="equipmentAppForm.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editEquipmentAppForm.do'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="equipmentAppFormList.size()"/>, 'selectedEquipmentAppFormId', 'copyEquipmentAppForm.do', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editEquipmentAppForm.do'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
      <tr>
        <td>
<c:set var="count" value="0" />
<display:table name="equipmentAppFormList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column titleKey="common.select">
        <input type="checkbox" id="selectedEquipmentAppFormId_<c:out value="${count}"/>" name="selectedEquipmentAppFormId" value="<c:out value="${row.id}"/>">
    </display:column>
    <display:column property="date" sortable="true" titleKey="equipmentAppForm.date" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="createdUser" sortable="true" titleKey="common.createdUser" style="text-align:left"/>
    <display:column property="applyBeginClock.name" sortable="true" titleKey="equipmentAppForm.applyBeginClock" style="text-align:left"/>
    <display:column property="applyEndClock.name" sortable="true" titleKey="equipmentAppForm.applyEndClock" style="text-align:left"/>
    <display:column property="room" sortable="true" titleKey="equipmentAppForm.room" style="text-align:left"/>
    <display:column property="borrowDate" sortable="true" titleKey="equipmentAppForm.borrowDate" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="returnDate" sortable="true" titleKey="equipmentAppForm.returnDate" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="borrowDetail" sortable="true" titleKey="equipment.name" style="text-align:left" />
    <display:column titleKey="common.checkingState">
       <c:out value="${row.state}" />
    </display:column>
    

    
    <display:column titleKey="common.action">
        <ww:if test="recordEditable == true">
            <a href="editEquipmentAppForm.do?equipmentAppForm.id=<c:out value="${row.id}"/>"><fmt:message key="common.edit"/></a>&nbsp;&nbsp;
            <a href="#" onClick="javascript:return myConfirm('<fmt:message key="common.confirmDelete1"/><c:out value="${row.caption_}" /><fmt:message key="common.confirmDelete2"/>', 'form1', 'equipmentAppForm.id', '${row.id}')"><fmt:message key="common.delete"/></a>
        </ww:if>
        <ww:else>
           <a href="editEquipmentAppForm.do?equipmentAppForm.id=<c:out value="${row.id}"/>"><fmt:message key="common.view"/></a>&nbsp;&nbsp;
        </ww:else>
    </display:column>
    <c:set var="count" value="${count+1}" />
</display:table>
        </td>
    </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editEquipmentAppForm.do'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="equipmentAppFormList.size()"/>, 'selectedEquipmentAppFormId', 'copyEquipmentAppForm.do', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editEquipmentAppForm.do'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
</table>
<form name="form1" action="saveEquipmentAppForm.do">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="equipmentAppForm.id" value="">
    <select name="selectedEquipmentAppFormIds" multiple="true" style="display:none"></select>
</form>
