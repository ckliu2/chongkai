<%@ include file="/common/taglibs.jsp"%>
<ww:set name="groupsList" value="%{getBillAuthorityListByBill('${bill.id}')}"/> 
<ww:set name="bills" value="%{getBillDetailListByBillNo('${bill.id}')}"/> 
<table width="100%" border="1" class="list">
  <tr>
    <td nowrap="nowrap"><font color="blue"><fmt:message key="bill.flow"/></font></td>
    <ww:iterator value="groupsList">
     <td nowrap="nowrap">${group.groupName}</td>
    </ww:iterator>
  </tr>
  <tr>
    <td nowrap="nowrap"><font color="blue"><fmt:message key="bill.complete"/></font></td>
    <ww:iterator value="groupsList">
     <td nowrap="nowrap">${complete}</td>
    </ww:iterator>

  </tr>
  <tr>
    <td nowrap="nowrap"><font color="blue"><fmt:message key="bill.uncomplete"/></font></td>
    <ww:iterator value="groupsList">
     <td nowrap="nowrap">${uncomplete}</td>
    </ww:iterator>   
  </tr>
</table>
<fmt:message key="common.count"/>:${fn:length(bills)}


