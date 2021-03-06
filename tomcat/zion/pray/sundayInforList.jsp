<%@ include file="/common/taglibs.jsp"%>

<table border="0" cellspacing="1" >
      <tr>
        <td class="cContentTitle" ><fmt:message key="sundayInfor.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editSundayInfor.do'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editSundayInfor.do'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
      <tr>
        <td>
<c:set var="count" value="0" />
<display:table name="sundayInforList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    
    <display:column property="subject" sortable="true" titleKey="sundayInfor.subject" style="text-align:left" />
    <display:column property="youtube" sortable="true" titleKey="sundayInfor.youtube" style="text-align:left" />
    <display:column property="messageDate" sortable="true" titleKey="sundayInfor.messageDate" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column titleKey="common.action">
     <a href="editSundayInfor.do?sundayInfor.id=<c:out value="${row.id}"/>"><fmt:message key="common.edit"/></a>&nbsp;&nbsp;
     <a href="#" onClick="javascript:return myConfirm('<fmt:message key="common.confirmDelete1"/><c:out value="${row.subject}" /><fmt:message key="common.confirmDelete2"/>', 'form1', 'sundayInfor.id', '${row.id}')"><fmt:message key="common.delete"/></a>
    </display:column>
    <c:set var="count" value="${count+1}" />
</display:table>
        </td>
    </tr>
      <tr class="cActionButtonLine">
        <td>
     
        </td>
      </tr>
</table>
<form name="form1" action="saveSundayInfor.do">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="sundayInfor.id" value="">
    <select name="selectedSundayInforIds" multiple="true" style="display:none"></select>
</form>
