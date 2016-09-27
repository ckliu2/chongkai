<%@ include file="/common/taglibs.jsp"%>
<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css" />
<script type="text/javascript" src="${ctx}/scripts/list.js"></script>
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>

<ww:form name="Form1" action="saveBillFreight" method="POST" onsubmit="onSubmit()" >
  <ww:hidden name="bill.id" value="${bill.id}"/>
   <table border="0" cellspacing="1" class="cContentTable1">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="bill.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
          <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
          <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
      </td>
    </tr>
    
    
    <tr><td class="cInputCaption"><fmt:message key="billSchedule.sendMethod"/></td>
        <td class="cInputColumn">
            <ww:select name="billSchedule.isSendId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="isSendList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>
    
   <tr><td class="cInputCaption"><fmt:message key="freight.name"/></td>
        <td class="cInputColumn">
            <ww:select name="billSchedule.freightId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="freightList"
               listKey="id"
               listValue="name"
               cssClass="cInputListField"
            />
        </td>
    </tr>
    
    <tr><td class="cInputCaption"><fmt:message key="freight.no"/></td>
        <td class="cInputColumn">
            <ww:textfield name="billSchedule.freightNo" value="%{billSchedule.freightNo}"  cssClass="cInputTextField" />
        </td>
    </tr>
    
    <tr><td class="cInputCaption"><fmt:message key="billSchedule.location"/></td>
        <td class="cInputColumn">
          <ww:select name="billSchedule.customerAddressId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="%{getCustomerAddressList('${bill.id}')}"
               listKey="id"
               listValue="counter+'('+location+')'"
               cssClass="cInputListField"
            />
   
        </td>
    </tr>
    
    <tr><td class="cInputCaption"><fmt:message key="billSchedule.worker"/></td>
        <td class="cInputColumn">
            <ww:select name="billSchedule.workerId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="workerList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>
    
    <tr><td class="cInputCaption"><fmt:message key="billSchedule.costs"/></td>
        <td class="cInputColumn">
            <ww:textfield name="billSchedule.costs" value="%{billSchedule.costs}" cssClass="cInputTextFieldTiny" />
        </td>
    </tr>
    
    
    
    
        
       <tr><td class="cInputCaption"><fmt:message key="common.completely"/><fmt:message key="bill.form"/></td>
        <td class="cInputColumn">
            <table>
            <tr>
                <th align="center"><span style="font-size:10pt"><fmt:message key="common.available"/><fmt:message key="bill.form"/></style></th>
                <th>&nbsp;</th>
                <th align="center"><span style="font-size:10pt"><fmt:message key="common.selected"/><fmt:message key="bill.form"/></style></th>
            </tr><tr>
                <td>           
                <ww:select id="allBillDetail"
                list="%{getBillDetailListByBillNo('${bill.id}')}"
                listKey="id"
                listValue="product.productName"
                multiple="true"
                size="8"
                cssClass="cQueryFieldList"
                />           
                </td><td>
                <input type="button" value=">>" class="cSelectButton" onclick="moveAll(allBillDetail, selectedBillDetailIds);"  <c:out value="${modifyEditable}" />><br>
                <input type="button" value=">"  class="cSelectButton" onclick="moveOne(allBillDetail, selectedBillDetailIds);"  <c:out value="${modifyEditable}" />><br>
                <input type="button" value="<"  class="cSelectButton" onclick="moveOne(selectedBillDetailIds, allBillDetail);"  <c:out value="${modifyEditable}" />><br>
                <input type="button" value="<<" class="cSelectButton" onclick="moveAll(selectedBillDetailIds, allBillDetail);"  <c:out value="${modifyEditable}" />><br>
            </td>
            
            <td align="center">
                <select name="billDetailIds" id="selectedBillDetailIds" class="cQueryFieldList" multiple="true" size="8">
                </select>               
            </td>
            </tr>           
            
            </table>
        </td>
    </tr>
    
</table>
  
  
</ww:form>





<script>
 function reflash(){
   window.opener.parent.location.reload();
   window.close();
 }

 function onSubmit(){
 	 mySelectAll(document.Form1.billDetailIds); 	
 }
 
 <%
 String reload=request.getParameter("reload");
 //out.println("reload="+reload);
  if (reload != null && reload.equals("Y")) {
 %>
   reflash();

 <%
 }
 %>
 
</script>

