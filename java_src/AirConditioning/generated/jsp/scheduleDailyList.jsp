<%@ include file="/common/taglibs.jsp"%>

<table border="0" cellspacing="1" class="cContentTable">
      <tr>
        <td class="cContentTitle" ><fmt:message key="scheduleDaily.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editScheduleDaily.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="scheduleDailyList.size()"/>, 'selectedScheduleDailyId', 'copyScheduleDaily.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editScheduleDaily.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
      <tr>
        <td>
<c:set var="count" value="0" />
<display:table name="scheduleDailyList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column titleKey="common.select">
        <input type="checkbox" id="selectedScheduleDailyId_<c:out value="${count}"/>" name="selectedScheduleDailyId" value="<c:out value="${row.id}"/>">
    </display:column>
    <display:column property="temp" sortable="true" titleKey="scheduleDaily.temp" />
    <display:column property="scheduledDate" sortable="true" titleKey="scheduleDaily.scheduledDate" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="active" sortable="true" titleKey="scheduleDaily.active" style="text-align:left" />
    <display:column property="createdDate" sortable="true" titleKey="common.createdDate" style="text-align:left"/>
    <display:column property="ip" sortable="true" titleKey="scheduleDaily.ip" style="text-align:left" />
    <display:column property="lastModifiedDate" sortable="true" titleKey="common.lastModifiedDate" style="text-align:left"/>
    <display:column property="groupCode" sortable="true" titleKey="scheduleDaily.groupCode" style="text-align:left" />
    <display:column property="courseNum" sortable="true" titleKey="scheduleDaily.courseNum" />
    <display:column property="flag" sortable="true" titleKey="scheduleDaily.flag" />
    <display:column property="drive.caption_" sortable="true" titleKey="scheduleDaily.drive" style="text-align:left"/>
    <display:column property="mode.caption_" sortable="true" titleKey="scheduleDaily.mode" style="text-align:left"/>
    <display:column property="fanSpeed.caption_" sortable="true" titleKey="scheduleDaily.fanSpeed" style="text-align:left"/>
    <display:column property="lock.caption_" sortable="true" titleKey="scheduleDaily.lock" style="text-align:left"/>
    <display:column property="driveItem.caption_" sortable="true" titleKey="scheduleDaily.driveItem" style="text-align:left"/>
    <display:column property="modeItem.caption_" sortable="true" titleKey="scheduleDaily.modeItem" style="text-align:left"/>
    <display:column property="tempItem.caption_" sortable="true" titleKey="scheduleDaily.tempItem" style="text-align:left"/>
    <display:column property="filterItem.caption_" sortable="true" titleKey="scheduleDaily.filterItem" style="text-align:left"/>
    <display:column property="type.caption_" sortable="true" titleKey="scheduleDaily.type" style="text-align:left"/>
    <display:column property="lastModifiedUser" sortable="true" titleKey="common.lastModifiedUser" style="text-align:left"/>
    <display:column property="readers" sortable="true" titleKey="scheduleDaily.readers" style="text-align:left" />
    <display:column titleKey="common.action">
        <ww:if test="recordEditable == true">
            <a href="editScheduleDaily.html?scheduleDaily.id=<c:out value="${row.id}"/>"><fmt:message key="common.edit"/></a>&nbsp;&nbsp;
            <a href="#" onClick="javascript:return myConfirm('<fmt:message key="common.confirmDelete1"/><c:out value="${row.caption_}" /><fmt:message key="common.confirmDelete2"/>', 'form1', 'scheduleDaily.id', '${row.id}')"><fmt:message key="common.delete"/></a>
        </ww:if>
        <ww:else>
           <a href="editScheduleDaily.html?scheduleDaily.id=<c:out value="${row.id}"/>"><fmt:message key="common.view"/></a>&nbsp;&nbsp;
        </ww:else>
    </display:column>
    <c:set var="count" value="${count+1}" />
</display:table>
        </td>
    </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editScheduleDaily.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="scheduleDailyList.size()"/>, 'selectedScheduleDailyId', 'copyScheduleDaily.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editScheduleDaily.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
</table>
<form name="form1" action="saveScheduleDaily.html">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="scheduleDaily.id" value="">
    <select name="selectedScheduleDailyIds" multiple="true" style="display:none"></select>
</form>
