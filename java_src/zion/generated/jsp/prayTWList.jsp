<%@ include file="/common/taglibs.jsp"%>

<table border="0" cellspacing="1" class="cContentTable">
      <tr>
        <td class="cContentTitle" ><fmt:message key="prayTW.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editPrayTW.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="prayTWList.size()"/>, 'selectedPrayTWId', 'copyPrayTW.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editPrayTW.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
      <tr>
        <td>
<c:set var="count" value="0" />
<display:table name="prayTWList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column titleKey="common.select">
        <input type="checkbox" id="selectedPrayTWId_<c:out value="${count}"/>" name="selectedPrayTWId" value="<c:out value="${row.id}"/>">
    </display:column>
    <display:column property="descriptionUrl" sortable="true" titleKey="prayTW.descriptionUrl" style="text-align:left" />
    <display:column property="latitude" sortable="true" titleKey="prayTW.latitude" style="text-align:left" />
    <display:column property="longitude" sortable="true" titleKey="prayTW.longitude" style="text-align:left" />
    <display:column property="zoom" sortable="true" titleKey="prayTW.zoom" />
    <display:column property="map.caption_" sortable="true" titleKey="prayTW.map" style="text-align:left"/>
    <display:column property="photo1.caption_" sortable="true" titleKey="prayTW.photo1" style="text-align:left"/>
    <display:column property="photo2.caption_" sortable="true" titleKey="prayTW.photo2" style="text-align:left"/>
    <display:column property="photo3.caption_" sortable="true" titleKey="prayTW.photo3" style="text-align:left"/>
    <display:column property="area.caption_" sortable="true" titleKey="prayTW.area" style="text-align:left"/>
    <display:column titleKey="common.action">
        <ww:if test="recordEditable == true">
            <a href="editPrayTW.html?prayTW.id=<c:out value="${row.id}"/>"><fmt:message key="common.edit"/></a>&nbsp;&nbsp;
            <a href="#" onClick="javascript:return myConfirm('<fmt:message key="common.confirmDelete1"/><c:out value="${row.caption_}" /><fmt:message key="common.confirmDelete2"/>', 'form1', 'prayTW.id', '${row.id}')"><fmt:message key="common.delete"/></a>
        </ww:if>
        <ww:else>
           <a href="editPrayTW.html?prayTW.id=<c:out value="${row.id}"/>"><fmt:message key="common.view"/></a>&nbsp;&nbsp;
        </ww:else>
    </display:column>
    <c:set var="count" value="${count+1}" />
</display:table>
        </td>
    </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editPrayTW.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="prayTWList.size()"/>, 'selectedPrayTWId', 'copyPrayTW.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editPrayTW.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
</table>
<form name="form1" action="savePrayTW.html">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="prayTW.id" value="">
    <select name="selectedPrayTWIds" multiple="true" style="display:none"></select>
</form>
