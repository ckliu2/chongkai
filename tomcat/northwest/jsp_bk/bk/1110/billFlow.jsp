<%@ include file="/common/taglibs.jsp"%>

    <ww:set name="groupsList" value="%{getBillAuthorityListByBill('${bill.id}')}"/> 
<%--
             <display:table name="groupsList" class="list" cellspacing="1" requestURI="" id="grouprow${bill.id}" export="false" pagesize="15" sort="list">
             <display:setProperty name="paging.banner.placement" value="bottom" />
                  <display:column property="group.groupNameEn" sortable="true" titleKey="bill.flow" style="text-align:left" />
                  <display:column property="complete" sortable="true" titleKey="bill.complete" style="text-align:left" />
                  <display:column property="uncomplete" sortable="true" titleKey="bill.uncomplete" style="text-align:left" />
             </display:table>             

<BR>
--%>

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


