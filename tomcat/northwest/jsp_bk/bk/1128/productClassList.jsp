<%@ include file="/common/taglibs.jsp"%>

<table border="0" cellspacing="1" class="cContentTable">
      <tr>
        <td class="cContentTitle" ><fmt:message key="productClass.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td>

        </td>
      </tr>
      <tr>
        <td>
<c:set var="count" value="1" />
<display:table name="productClassList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column titleKey="common.id">
          ${count}
    </display:column>
    <display:column property="className" sortable="true" titleKey="productClass.className" style="text-align:left" />
    <display:column property="expectionFlows" sortable="true" titleKey="productClass.expectionFlows" style="text-align:left" />
    <display:column titleKey="common.action">
          <a href="editProductClass.html?productClass.id=<c:out value="${row.id}"/>"><fmt:message key="common.edit"/></a>&nbsp;&nbsp;
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
<form name="form1" action="saveProductClass.html">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="productClass.id" value="">
    <select name="selectedProductClassIds" multiple="true" style="display:none"></select>
</form>
