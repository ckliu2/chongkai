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
<c:set var="count" value="1" />
<display:table name="billList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
     
    <display:column titleKey="common.id">
      ${count}
    </display:column>

    <display:column titleKey="bill.id">
      <a href="editBill.html?bill.id=${row.id}">${row.id}</a>
    </display:column>      
    <display:column property="customer.name" sortable="true" titleKey="customer.name" style="text-align:left" />
    <display:column property="projectName" sortable="true" titleKey="bill.projectName" style="text-align:left" />
    <display:column property="remark" sortable="true" titleKey="bill.remark" style="text-align:left" />
    
    
    

    <ww:set name="groupsList" value="%{getBillAuthorityListByBill('${row.id}')}"/> 
    
    
    <display:column titleKey="common.action">
             <display:table name="groupsList" class="list" cellspacing="1" requestURI="" id="grouprow" export="false" pagesize="15" sort="list">
             <display:setProperty name="paging.banner.placement" value="bottom" />
                  <display:column property="group.groupNameEn" sortable="true" titleKey="bill.flow" style="text-align:left" />
                  <display:column property="complete" sortable="true" titleKey="bill.complete" style="text-align:left" />
                  <display:column property="uncomplete" sortable="true" titleKey="bill.uncomplete" style="text-align:left" />
             </display:table>
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
