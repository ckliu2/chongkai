<%@ include file="/common/taglibs.jsp"%>

<table border="0" cellspacing="1" class="cContentTable">
      <tr>
        <td class="cContentTitle" ><fmt:message key="customer.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td>

        </td>
      </tr>
      <tr>
        <td>
<c:set var="count" value="0" />
<display:table name="customerList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column property="id" sortable="true" titleKey="customer.id" style="text-align:left" />
    <display:column property="name" sortable="true" titleKey="customer.name" style="text-align:left" />
    <display:column property="linkMan" sortable="true" titleKey="customer.linkMan" style="text-align:left" />
    <display:column property="address" sortable="true" titleKey="customer.address" style="text-align:left" />
    <display:column property="telephone" sortable="true" titleKey="customer.telephone" style="text-align:left" />
    <%--
    <display:column property="saleman" sortable="true" titleKey="customerDetail.saleman" style="text-align:left" />
    --%>
    <display:column titleKey="common.action">
        <ww:if test="recordEditable == true">
            <a href="editCustomer.html?customer.id=<c:out value="${row.id}"/>"><fmt:message key="common.edit"/></a>&nbsp;&nbsp;
        </ww:if>
        <ww:else>
           <a href="editCustomer.html?customer.id=<c:out value="${row.id}"/>"><fmt:message key="common.view"/></a>&nbsp;&nbsp;
        </ww:else>
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
<form name="form1" action="saveCustomer.html">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="customer.id" value="">
    <select name="selectedCustomerIds" multiple="true" style="display:none"></select>
</form>

