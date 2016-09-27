<%@ include file="/common/taglibs.jsp"%>

<table border="0" cellspacing="1" class="cContentTable">
      <tr>
        <td class="cContentTitle" ><fmt:message key="bolg.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editBolg.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="bolgList.size()"/>, 'selectedBolgId', 'copyBolg.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editBolg.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
      <tr>
        <td>
<c:set var="count" value="0" />
<display:table name="bolgList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column titleKey="common.select">
        <input type="checkbox" id="selectedBolgId_<c:out value="${count}"/>" name="selectedBolgId" value="<c:out value="${row.id}"/>">
    </display:column>
    <display:column property="name" sortable="true" titleKey="bolg.name" style="text-align:left" />
    <display:column property="title" sortable="true" titleKey="bolg.title" style="text-align:left" />
    <display:column property="link" sortable="true" titleKey="bolg.link" style="text-align:left" />
    <display:column property="content" sortable="true" titleKey="bolg.content" style="text-align:left" />
    <display:column property="memo" sortable="true" titleKey="bolg.memo" style="text-align:left" />
    <display:column property="seqNo" sortable="true" titleKey="bolg.seqNo" />
    <display:column property="status" sortable="true" titleKey="bolg.status" style="text-align:left" />
    <display:column property="beginDate" sortable="true" titleKey="bolg.beginDate" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="endDate" sortable="true" titleKey="bolg.endDate" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="lastModifiedDate" sortable="true" titleKey="common.lastModifiedDate" style="text-align:left"/>
    <display:column property="createdDate" sortable="true" titleKey="common.createdDate" style="text-align:left"/>
    <display:column property="lastModifiedUser" sortable="true" titleKey="common.lastModifiedUser" style="text-align:left"/>
    <display:column property="createdUser" sortable="true" titleKey="common.createdUser" style="text-align:left"/>
    <display:column property="myfile.caption_" sortable="true" titleKey="bolg.myfile" style="text-align:left"/>
    <display:column property="photo.caption_" sortable="true" titleKey="bolg.photo" style="text-align:left"/>
    <display:column property="bolgClass.caption_" sortable="true" titleKey="bolg.bolgClass" style="text-align:left"/>
    <display:column property="linkType.caption_" sortable="true" titleKey="bolg.linkType" style="text-align:left"/>
    <display:column titleKey="common.action">
        <ww:if test="recordEditable == true">
            <a href="editBolg.html?bolg.id=<c:out value="${row.id}"/>"><fmt:message key="common.edit"/></a>&nbsp;&nbsp;
            <a href="#" onClick="javascript:return myConfirm('<fmt:message key="common.confirmDelete1"/><c:out value="${row.caption_}" /><fmt:message key="common.confirmDelete2"/>', 'form1', 'bolg.id', '${row.id}')"><fmt:message key="common.delete"/></a>
        </ww:if>
        <ww:else>
           <a href="editBolg.html?bolg.id=<c:out value="${row.id}"/>"><fmt:message key="common.view"/></a>&nbsp;&nbsp;
        </ww:else>
    </display:column>
    <c:set var="count" value="${count+1}" />
</display:table>
        </td>
    </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editBolg.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="bolgList.size()"/>, 'selectedBolgId', 'copyBolg.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editBolg.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
</table>
<form name="form1" action="saveBolg.html">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="bolg.id" value="">
    <select name="selectedBolgIds" multiple="true" style="display:none"></select>
</form>
