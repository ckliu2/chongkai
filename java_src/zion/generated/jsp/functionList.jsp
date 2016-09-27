<%@ include file="/common/taglibs.jsp"%>

<table border="0" cellspacing="1" class="cContentTable">
      <tr>
        <td class="cContentTitle" ><fmt:message key="function.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editFunction.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="functionList.size()"/>, 'selectedFunctionId', 'copyFunction.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editFunction.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
      <tr>
        <td>
<c:set var="count" value="0" />
<display:table name="functionList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column titleKey="common.select">
        <input type="checkbox" id="selectedFunctionId_<c:out value="${count}"/>" name="selectedFunctionId" value="<c:out value="${row.id}"/>">
    </display:column>
    <display:column property="seqNo" sortable="true" titleKey="function.seqNo" />
    <display:column property="funKey" sortable="true" titleKey="function.funKey" style="text-align:left" />
    <display:column property="funNameCh" sortable="true" titleKey="function.funNameCh" style="text-align:left" />
    <display:column property="funNameEn" sortable="true" titleKey="function.funNameEn" style="text-align:left" />
    <display:column property="funUrl" sortable="true" titleKey="function.funUrl" style="text-align:left" />
    <display:column property="descCh" sortable="true" titleKey="function.descCh" style="text-align:left" />
    <display:column property="descEn" sortable="true" titleKey="function.descEn" style="text-align:left" />
    <display:column property="editBegin" sortable="true" titleKey="function.editBegin" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="editEnd" sortable="true" titleKey="function.editEnd" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="disabled" sortable="true" titleKey="function.disabled" style="text-align:left" />
    <display:column property="category.caption_" sortable="true" titleKey="function.category" style="text-align:left"/>
    <display:column property="authority" sortable="true" titleKey="function.authority" style="text-align:left" />
    <display:column titleKey="common.action">
        <ww:if test="recordEditable == true">
            <a href="editFunction.html?function.id=<c:out value="${row.id}"/>"><fmt:message key="common.edit"/></a>&nbsp;&nbsp;
            <a href="#" onClick="javascript:return myConfirm('<fmt:message key="common.confirmDelete1"/><c:out value="${row.caption_}" /><fmt:message key="common.confirmDelete2"/>', 'form1', 'function.id', '${row.id}')"><fmt:message key="common.delete"/></a>
        </ww:if>
        <ww:else>
           <a href="editFunction.html?function.id=<c:out value="${row.id}"/>"><fmt:message key="common.view"/></a>&nbsp;&nbsp;
        </ww:else>
    </display:column>
    <c:set var="count" value="${count+1}" />
</display:table>
        </td>
    </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editFunction.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="functionList.size()"/>, 'selectedFunctionId', 'copyFunction.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editFunction.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
</table>
<form name="form1" action="saveFunction.html">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="function.id" value="">
    <select name="selectedFunctionIds" multiple="true" style="display:none"></select>
</form>
