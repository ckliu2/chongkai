<%@ include file="/common/taglibs.jsp"%>

<table border="0" cellspacing="1" >
      <tr>
        <td class="cContentTitle" >Banner管理</td>
      </tr>
      <tr>
        <td>
 
        </td>
      </tr>      
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editBanner.do'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editBolg.do'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
      <tr>
        <td>
<c:set var="count" value="0" />
<display:table name="bannerList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column titleKey="common.select">
        <input type="checkbox" id="selectedBolgId_<c:out value="${count}"/>" name="selectedBolgId" value="<c:out value="${row.id}"/>">
    </display:column>    
    <display:column property="name" sortable="true" title="Banner名稱" style="text-align:left" />
    <display:column property="link" sortable="true" title="Banner Link" style="text-align:left" />
    
    <display:column property="seqNo" sortable="true" title="Banner排序" />
    <display:column property="status" sortable="true" titleKey="bolg.status" style="text-align:left" />
  
    <display:column titleKey="common.action">
        <ww:if test="recordEditable == true">
            <a href="editBanner.do?bolg.id=<c:out value="${row.id}"/>"><fmt:message key="common.edit"/></a>&nbsp;&nbsp;
            <a href="#" onClick="javascript:return myConfirm('<fmt:message key="common.confirmDelete1"/><c:out value="${row.name}" /><fmt:message key="common.confirmDelete2"/>', 'form1', 'bolg.id', '${row.id}')"><fmt:message key="common.delete"/></a>
        </ww:if>
        <ww:else>
           <a href="editBanner.do?bolg.id=<c:out value="${row.id}"/>"><fmt:message key="common.view"/></a>&nbsp;&nbsp;
        </ww:else>
    </display:column>
    <c:set var="count" value="${count+1}" />
</display:table>
        </td>
    </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editBanner.do'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editBolg.do'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
</table>
<form name="form1" action="saveBanner.do">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="bolg.id" value="">
    <select name="selectedBolgIds" multiple="true" style="display:none"></select>
</form>
