<%@ include file="/common/taglibs.jsp"%>

<table border="0" cellspacing="1" class="cContentTable1">
      <tr>
        <td class="cContentTitle" ><fmt:message key="perRefer.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editPerRefer.do'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="perReferList.size()"/>, 'selectedPerReferId', 'copyPerRefer.do', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editPerRefer.do'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
      <tr>
        <td>
<c:set var="count" value="0" />
<display:table name="perReferList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column property="id" sortable="true" title="編號" style="text-align:left" />
    
    
    <display:column title="諮商來源">
    	<font color='blue'> ${row.qatype.valueTw} </font>
    </display:column>	
     	
     	
    <display:column property="name" sortable="true" titleKey="perRefer.name" style="text-align:left" />
    <display:column property="email" sortable="true" titleKey="perRefer.email" style="text-align:left" />
    <display:column property="phone" sortable="true" titleKey="perRefer.phone" style="text-align:left" />
    <display:column property="cellphone" sortable="true" titleKey="perRefer.cellphone" style="text-align:left" />
    <display:column property="createdDate" sortable="true" format="{0,date,yyyy-MM-dd HH:mm}" titleKey="common.createdDate" style="text-align:left"/>
    <%--
    <display:column property="type.valueTw" sortable="true" titleKey="perRefer.type" style="text-align:left"/>
    --%>
    <display:column property="teacher.cname" sortable="true" titleKey="perRefer.teacher" style="text-align:left"/>
    <display:column titleKey="common.action">
        <ww:if test="recordEditable == true">
            <a href="editPerRefer.do?perRefer.id=<c:out value="${row.id}"/>"><fmt:message key="common.edit"/></a>&nbsp;&nbsp;
            <a href="#" onClick="javascript:return myConfirm('<fmt:message key="common.confirmDelete1"/><c:out value="${row.id}" /><fmt:message key="common.confirmDelete2"/>', 'form1', 'perRefer.id', '${row.id}')"><fmt:message key="common.delete"/></a>
        </ww:if>
        <ww:else>
           <a href="editPerRefer.do?perRefer.id=<c:out value="${row.id}"/>"><fmt:message key="common.view"/></a>&nbsp;&nbsp;
        </ww:else>
    </display:column>
    <c:set var="count" value="${count+1}" />
</display:table>
        </td>
    </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editPerRefer.do'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="perReferList.size()"/>, 'selectedPerReferId', 'copyPerRefer.do', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editPerRefer.do'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
</table>
<form name="form1" action="savePerRefer.do">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="perRefer.id" value="">
    <select name="selectedPerReferIds" multiple="true" style="display:none"></select>
</form>
