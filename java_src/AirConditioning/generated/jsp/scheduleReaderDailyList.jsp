<%@ include file="/common/taglibs.jsp"%>

<table border="0" cellspacing="1" class="cContentTable">
      <tr>
        <td class="cContentTitle" ><fmt:message key="scheduleReaderDaily.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editScheduleReaderDaily.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="scheduleReaderDailyList.size()"/>, 'selectedScheduleReaderDailyId', 'copyScheduleReaderDaily.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editScheduleReaderDaily.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
      <tr>
        <td>
<c:set var="count" value="0" />
<display:table name="scheduleReaderDailyList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column titleKey="common.select">
        <input type="checkbox" id="selectedScheduleReaderDailyId_<c:out value="${count}"/>" name="selectedScheduleReaderDailyId" value="<c:out value="${row.id}"/>">
    </display:column>
    <display:column property="scheduledDate" sortable="true" titleKey="scheduleReaderDaily.scheduledDate" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="active" sortable="true" titleKey="scheduleReaderDaily.active" style="text-align:left" />
    <display:column property="reader.caption_" sortable="true" titleKey="scheduleReaderDaily.reader" style="text-align:left"/>
    <display:column property="scheduleDaily.caption_" sortable="true" titleKey="scheduleReaderDaily.scheduleDaily" style="text-align:left"/>
    <display:column property="type.caption_" sortable="true" titleKey="scheduleReaderDaily.type" style="text-align:left"/>
    <display:column property="powerController.caption_" sortable="true" titleKey="scheduleReaderDaily.powerController" style="text-align:left"/>
    <display:column titleKey="common.action">
        <ww:if test="recordEditable == true">
            <a href="editScheduleReaderDaily.html?scheduleReaderDaily.id=<c:out value="${row.id}"/>"><fmt:message key="common.edit"/></a>&nbsp;&nbsp;
            <a href="#" onClick="javascript:return myConfirm('<fmt:message key="common.confirmDelete1"/><c:out value="${row.caption_}" /><fmt:message key="common.confirmDelete2"/>', 'form1', 'scheduleReaderDaily.id', '${row.id}')"><fmt:message key="common.delete"/></a>
        </ww:if>
        <ww:else>
           <a href="editScheduleReaderDaily.html?scheduleReaderDaily.id=<c:out value="${row.id}"/>"><fmt:message key="common.view"/></a>&nbsp;&nbsp;
        </ww:else>
    </display:column>
    <c:set var="count" value="${count+1}" />
</display:table>
        </td>
    </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editScheduleReaderDaily.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="scheduleReaderDailyList.size()"/>, 'selectedScheduleReaderDailyId', 'copyScheduleReaderDaily.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editScheduleReaderDaily.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
</table>
<form name="form1" action="saveScheduleReaderDaily.html">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="scheduleReaderDaily.id" value="">
    <select name="selectedScheduleReaderDailyIds" multiple="true" style="display:none"></select>
</form>
