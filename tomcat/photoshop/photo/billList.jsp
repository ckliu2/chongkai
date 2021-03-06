<%@ include file="/common/taglibs.jsp"%>

<table border="0" cellspacing="1" class="cContentTable">
      <tr>
        <td class="cContentTitle" ><fmt:message key="bill.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td>
        
        </td>
      </tr>
      <tr>
        <td>
<c:set var="count" value="0" />
<display:table name="billList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    
    <display:column property="no" sortable="true" title="訂單編號"  style="text-align:left" />
    <display:column property="customer.name" sortable="true" title="客戶" style="text-align:left"/>
    <display:column property="customer.cellphone" sortable="true" title="手機" style="text-align:left"/>
    
    <display:column property="createdDate" format="{0,date,yyyy/MM/dd HH:mm}" sortable="true" title="訂單日期" style="text-align:left"/>
    
    <display:column title="運費">
     ${row.sfee}
    </display:column>
    
    <display:column title="照片金額">
     ${row.totalPrice}
    </display:column>
    
    <display:column title="總金額">
     ${row.totalPrice+row.sfee}
    </display:column>
    
    <display:column titleKey="common.action">
        <ww:if test="recordEditable == true">
            <a href="editBill.html?bill.id=<c:out value="${row.id}"/>"><fmt:message key="common.edit"/></a>&nbsp;&nbsp;
            <a href="#" onClick="javascript:return myConfirm('<fmt:message key="common.confirmDelete1"/><c:out value="${row.caption_}" /><fmt:message key="common.confirmDelete2"/>', 'form1', 'bill.id', '${row.id}')"><fmt:message key="common.delete"/></a>
        </ww:if>
        <ww:else>
           <a href="editBill.html?bill.id=<c:out value="${row.id}"/>"><fmt:message key="common.view"/></a>&nbsp;&nbsp;
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
<form name="form1" action="saveBill.html">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="bill.id" value="">
    <select name="selectedBillIds" multiple="true" style="display:none"></select>
</form>
