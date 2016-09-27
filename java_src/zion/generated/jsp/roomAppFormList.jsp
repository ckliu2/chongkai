<%@ include file="/common/taglibs.jsp"%>

<table border="0" cellspacing="1" class="cContentTable">
      <tr>
        <td class="cContentTitle" ><fmt:message key="roomAppForm.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editRoomAppForm.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="roomAppFormList.size()"/>, 'selectedRoomAppFormId', 'copyRoomAppForm.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editRoomAppForm.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
      <tr>
        <td>
<c:set var="count" value="0" />
<display:table name="roomAppFormList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column titleKey="common.select">
        <input type="checkbox" id="selectedRoomAppFormId_<c:out value="${count}"/>" name="selectedRoomAppFormId" value="<c:out value="${row.id}"/>">
    </display:column>
    <display:column property="date" sortable="true" titleKey="roomAppForm.date" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="otherMeeting" sortable="true" titleKey="roomAppForm.otherMeeting" style="text-align:left" />
    <display:column property="meno" sortable="true" titleKey="roomAppForm.meno" style="text-align:left" />
    <display:column property="borrowDate" sortable="true" titleKey="roomAppForm.borrowDate" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="state" sortable="true" titleKey="roomAppForm.state" style="text-align:left" />
    <display:column property="lastModifiedDate" sortable="true" titleKey="common.lastModifiedDate" style="text-align:left"/>
    <display:column property="createdDate" sortable="true" titleKey="common.createdDate" style="text-align:left"/>
    <display:column property="meeting.caption_" sortable="true" titleKey="roomAppForm.meeting" style="text-align:left"/>
    <display:column property="applyBeginClock.caption_" sortable="true" titleKey="roomAppForm.applyBeginClock" style="text-align:left"/>
    <display:column property="applyEndClock.caption_" sortable="true" titleKey="roomAppForm.applyEndClock" style="text-align:left"/>
    <display:column property="lastModifiedUser" sortable="true" titleKey="common.lastModifiedUser" style="text-align:left"/>
    <display:column property="createdUser" sortable="true" titleKey="common.createdUser" style="text-align:left"/>
    <display:column property="room" sortable="true" titleKey="roomAppForm.room" style="text-align:left" />
    <display:column titleKey="common.action">
        <ww:if test="recordEditable == true">
            <a href="editRoomAppForm.html?roomAppForm.id=<c:out value="${row.id}"/>"><fmt:message key="common.edit"/></a>&nbsp;&nbsp;
            <a href="#" onClick="javascript:return myConfirm('<fmt:message key="common.confirmDelete1"/><c:out value="${row.caption_}" /><fmt:message key="common.confirmDelete2"/>', 'form1', 'roomAppForm.id', '${row.id}')"><fmt:message key="common.delete"/></a>
        </ww:if>
        <ww:else>
           <a href="editRoomAppForm.html?roomAppForm.id=<c:out value="${row.id}"/>"><fmt:message key="common.view"/></a>&nbsp;&nbsp;
        </ww:else>
    </display:column>
    <c:set var="count" value="${count+1}" />
</display:table>
        </td>
    </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editRoomAppForm.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="roomAppFormList.size()"/>, 'selectedRoomAppFormId', 'copyRoomAppForm.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editRoomAppForm.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
</table>
<form name="form1" action="saveRoomAppForm.html">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="roomAppForm.id" value="">
    <select name="selectedRoomAppFormIds" multiple="true" style="display:none"></select>
</form>
