<%@ include file="/common/taglibs.jsp"%>

<table border="0" cellspacing="1" >
      <tr>
        <td class="cContentTitle" ><fmt:message key="bolgClass.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editBolgClass.do'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="bolgClassList.size()"/>, 'selectedBolgClassId', 'copyBolgClass.do', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editBolgClass.do'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
      <tr>
        <td>
     <c:set var="count" value="0" />
    <display:table name="bolgClassList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column titleKey="common.select">
        <input type="checkbox" id="selectedBolgClassId_<c:out value="${count}"/>" name="selectedBolgClassId" value="<c:out value="${row.id}"/>">
    </display:column>
    <display:column property="name" sortable="true" titleKey="bolgClass.name" style="text-align:left" />
    <display:column property="seqNo" sortable="true" titleKey="bolgClass.seqNo" />
    <display:column property="status" sortable="true" titleKey="bolgClass.status" style="text-align:left" />
    <display:column property="lastModifiedDate" sortable="true" titleKey="common.lastModifiedDate" style="text-align:left"/>
    <display:column property="createdDate" sortable="true" titleKey="common.createdDate" style="text-align:left"/>
    <display:column property="lastModifiedUser.cname" sortable="true" titleKey="common.lastModifiedUser" style="text-align:left"/>
    <display:column property="createdUser.cname" sortable="true" titleKey="common.createdUser" style="text-align:left"/>
    <display:column titleKey="common.action">
        <ww:if test="recordEditable == true">
            <a href="editBolgClass.do?bolgClass.id=<c:out value="${row.id}"/>"><fmt:message key="common.edit"/></a>&nbsp;&nbsp;
            <a href="#" onClick="javascript:return myConfirm('<fmt:message key="common.confirmDelete1"/><c:out value="${row.caption_}" /><fmt:message key="common.confirmDelete2"/>', 'form1', 'bolgClass.id', '${row.id}')"><fmt:message key="common.delete"/></a>
        </ww:if>
        <ww:else>
           <a href="editBolgClass.do?bolgClass.id=<c:out value="${row.id}"/>"><fmt:message key="common.view"/></a>&nbsp;&nbsp;
        </ww:else>
    </display:column>
    <c:set var="count" value="${count+1}" />
   
   </display:table>
        </td>
    </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editBolgClass.do'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="bolgClassList.size()"/>, 'selectedBolgClassId', 'copyBolgClass.do', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editBolgClass.do'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
</table>
<form name="form1" action="saveBolgClass.do">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="bolgClass.id" value="">
    <select name="selectedBolgClassIds" multiple="true" style="display:none"></select>
</form>
