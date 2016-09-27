<%@ include file="/common/taglibs.jsp"%>

<table border="0" cellspacing="1" class="cContentTable">
      <tr>
        <td class="cContentTitle" ><fmt:message key="reader.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editReader.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="readerList.size()"/>, 'selectedReaderId', 'copyReader.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editReader.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
      <tr>
        <td>
<c:set var="count" value="0" />
<display:table name="readerList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column titleKey="common.select">
        <input type="checkbox" id="selectedReaderId_<c:out value="${count}"/>" name="selectedReaderId" value="<c:out value="${row.id}"/>">
    </display:column>
    <display:column property="name" sortable="true" titleKey="reader.name" style="text-align:left" />
    <display:column property="seqName" sortable="true" titleKey="reader.seqName" style="text-align:left" />
    <display:column property="readerId" sortable="true" titleKey="reader.readerId" />
    <display:column property="createdDate" sortable="true" titleKey="common.createdDate" style="text-align:left"/>
    <display:column property="temp" sortable="true" titleKey="reader.temp" />
    <display:column property="active" sortable="true" titleKey="reader.active" style="text-align:left" />
    <display:column property="sync" sortable="true" titleKey="reader.sync" style="text-align:left" />
    <display:column property="clearDaily" sortable="true" titleKey="reader.clearDaily" style="text-align:left" />
    <display:column property="powerstatus" sortable="true" titleKey="reader.powerstatus" style="text-align:left" />
    <display:column property="information" sortable="true" titleKey="reader.information" style="text-align:left" />
    <display:column property="lastModifiedDate" sortable="true" titleKey="common.lastModifiedDate" style="text-align:left"/>
    <display:column property="createdUser" sortable="true" titleKey="common.createdUser" style="text-align:left"/>
    <display:column property="drive.caption_" sortable="true" titleKey="reader.drive" style="text-align:left"/>
    <display:column property="mode.caption_" sortable="true" titleKey="reader.mode" style="text-align:left"/>
    <display:column property="fanSpeed.caption_" sortable="true" titleKey="reader.fanSpeed" style="text-align:left"/>
    <display:column property="driveItem.caption_" sortable="true" titleKey="reader.driveItem" style="text-align:left"/>
    <display:column property="modeItem.caption_" sortable="true" titleKey="reader.modeItem" style="text-align:left"/>
    <display:column property="tempItem.caption_" sortable="true" titleKey="reader.tempItem" style="text-align:left"/>
    <display:column property="filterItem.caption_" sortable="true" titleKey="reader.filterItem" style="text-align:left"/>
    <display:column property="lock.caption_" sortable="true" titleKey="reader.lock" style="text-align:left"/>
    <display:column property="state.caption_" sortable="true" titleKey="reader.state" style="text-align:left"/>
    <display:column property="scheduleDailys" sortable="true" titleKey="reader.scheduleDailys" style="text-align:left" />
    <display:column titleKey="common.action">
        <ww:if test="recordEditable == true">
            <a href="editReader.html?reader.id=<c:out value="${row.id}"/>"><fmt:message key="common.edit"/></a>&nbsp;&nbsp;
            <a href="#" onClick="javascript:return myConfirm('<fmt:message key="common.confirmDelete1"/><c:out value="${row.caption_}" /><fmt:message key="common.confirmDelete2"/>', 'form1', 'reader.id', '${row.id}')"><fmt:message key="common.delete"/></a>
        </ww:if>
        <ww:else>
           <a href="editReader.html?reader.id=<c:out value="${row.id}"/>"><fmt:message key="common.view"/></a>&nbsp;&nbsp;
        </ww:else>
    </display:column>
    <c:set var="count" value="${count+1}" />
</display:table>
        </td>
    </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editReader.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="readerList.size()"/>, 'selectedReaderId', 'copyReader.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editReader.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
</table>
<form name="form1" action="saveReader.html">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="reader.id" value="">
    <select name="selectedReaderIds" multiple="true" style="display:none"></select>
</form>
