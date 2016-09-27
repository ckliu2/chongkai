<%@ include file="/common/taglibs.jsp"%>

<table border="0" cellspacing="1" >
      <tr>
        <td class="cContentTitle" ><fmt:message key="bolg.list"/></td>
      </tr>
      <tr>
        <td>
        <form name="qform"  method="post" action="bolgList.do">          
          <img src="images/search.jpg">
           <span class="cLabel2"><fmt:message key="common.search"/><fmt:message key="bolgClass.name"/>:</span>          
               <ww:select name="QueryBlogClass"  onchange="javascript:qform.submit()"
                headerKey=""
                headerValue="%{getText('common.pleaseSelect')+getText('bolgClass.name')}..."
                list="bolgClassList"
                listKey="id"
                listValue="name"
                cssClass="cQueryFieldList"
                />
          <input type="submit" value="<fmt:message key="common.search"/>" class="cButton">
        </form> 
        </td>
      </tr>      
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editBolg.do'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="bolgList.size()"/>, 'selectedBolgId', 'copyBolg.do', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editBolg.do'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
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
    <display:column property="bolgClass.name" sortable="true" titleKey="bolgClass.name" style="text-align:left"/>
    
    <display:column property="name" sortable="true" titleKey="bolg.name" style="text-align:left" />
    <display:column property="seqNo" sortable="true" titleKey="bolg.seqNo" />
    <display:column property="status" sortable="true" titleKey="bolg.status" style="text-align:left" />
    <display:column property="beginDate" sortable="true" titleKey="bolg.beginDate" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="endDate" sortable="true" titleKey="bolg.endDate" format="{0,date,yyyy/MM/dd}" style="text-align:left" />

    <display:column titleKey="common.action">
        <ww:if test="recordEditable == true">
            <a href="editBolg.do?bolg.id=<c:out value="${row.id}"/>"><fmt:message key="common.edit"/></a>&nbsp;&nbsp;
            <a href="#" onClick="javascript:return myConfirm('<fmt:message key="common.confirmDelete1"/><c:out value="${row.name}" /><fmt:message key="common.confirmDelete2"/>', 'form1', 'bolg.id', '${row.id}')"><fmt:message key="common.delete"/></a>
        </ww:if>
        <ww:else>
           <a href="editBolg.do?bolg.id=<c:out value="${row.id}"/>"><fmt:message key="common.view"/></a>&nbsp;&nbsp;
        </ww:else>
    </display:column>
    <c:set var="count" value="${count+1}" />
</display:table>
        </td>
    </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editBolg.do'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="bolgList.size()"/>, 'selectedBolgId', 'copyBolg.do', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editBolg.do'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
</table>
<form name="form1" action="saveBolg.do">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="bolg.id" value="">
    <select name="selectedBolgIds" multiple="true" style="display:none"></select>
</form>
