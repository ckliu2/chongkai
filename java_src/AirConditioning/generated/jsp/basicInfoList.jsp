<%@ include file="/common/taglibs.jsp"%>

<table border="0" cellspacing="1" class="cContentTable">
      <tr>
        <td class="cContentTitle" ><fmt:message key="basicInfo.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editBasicInfo.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="basicInfoList.size()"/>, 'selectedBasicInfoId', 'copyBasicInfo.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editBasicInfo.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
      <tr>
        <td>
<c:set var="count" value="0" />
<display:table name="basicInfoList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column titleKey="common.select">
        <input type="checkbox" id="selectedBasicInfoId_<c:out value="${count}"/>" name="selectedBasicInfoId" value="<c:out value="${row.id}"/>">
    </display:column>
    <display:column property="sem" sortable="true" titleKey="basicInfo.sem" />
    <display:column property="onMinutes" sortable="true" titleKey="basicInfo.onMinutes" />
    <display:column property="offMinutes" sortable="true" titleKey="basicInfo.offMinutes" />
    <display:column property="scheduleStart" sortable="true" titleKey="basicInfo.scheduleStart" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="scheduleEnd" sortable="true" titleKey="basicInfo.scheduleEnd" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="threshold" sortable="true" titleKey="basicInfo.threshold" />
    <display:column property="contract" sortable="true" titleKey="basicInfo.contract" />
    <display:column property="timingEveryMins" sortable="true" titleKey="basicInfo.timingEveryMins" />
    <display:column property="weeklyEveryMins" sortable="true" titleKey="basicInfo.weeklyEveryMins" />
    <display:column property="panelUpdateMins" sortable="true" titleKey="basicInfo.panelUpdateMins" />
    <display:column property="scheduleCheckMins" sortable="true" titleKey="basicInfo.scheduleCheckMins" />
    <display:column property="createdDate" sortable="true" titleKey="common.createdDate" style="text-align:left"/>
    <display:column property="flag" sortable="true" titleKey="basicInfo.flag" />
    <display:column property="shutdownTime" sortable="true" titleKey="basicInfo.shutdownTime" style="text-align:left" />
    <display:column property="initializeTime" sortable="true" titleKey="basicInfo.initializeTime" style="text-align:left" />
    <display:column property="createdUser" sortable="true" titleKey="common.createdUser" style="text-align:left"/>
    <display:column property="shutdownReaders" sortable="true" titleKey="basicInfo.shutdownReaders" style="text-align:left" />
    <display:column titleKey="common.action">
        <ww:if test="recordEditable == true">
            <a href="editBasicInfo.html?basicInfo.id=<c:out value="${row.id}"/>"><fmt:message key="common.edit"/></a>&nbsp;&nbsp;
            <a href="#" onClick="javascript:return myConfirm('<fmt:message key="common.confirmDelete1"/><c:out value="${row.caption_}" /><fmt:message key="common.confirmDelete2"/>', 'form1', 'basicInfo.id', '${row.id}')"><fmt:message key="common.delete"/></a>
        </ww:if>
        <ww:else>
           <a href="editBasicInfo.html?basicInfo.id=<c:out value="${row.id}"/>"><fmt:message key="common.view"/></a>&nbsp;&nbsp;
        </ww:else>
    </display:column>
    <c:set var="count" value="${count+1}" />
</display:table>
        </td>
    </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editBasicInfo.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="basicInfoList.size()"/>, 'selectedBasicInfoId', 'copyBasicInfo.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editBasicInfo.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
</table>
<form name="form1" action="saveBasicInfo.html">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="basicInfo.id" value="">
    <select name="selectedBasicInfoIds" multiple="true" style="display:none"></select>
</form>
