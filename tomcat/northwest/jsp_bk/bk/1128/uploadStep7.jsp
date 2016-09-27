<%@ include file="/common/taglibs.jsp"%>
<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css" />
<script type="text/javascript" src="${ctx}/scripts/list.js"></script>
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<script type="text/javascript" src="${ctx}/scripts/datetimepicker_css.js"></script>


<ww:form name="Form1" action="saveCheck7" method="POST"  >
  <ww:hidden name="bill.id" value="${bill.id}"/>
   <table border="0" cellspacing="1" class="cContentTable1">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="bill.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
          <input type="button" value="<fmt:message key="common.save"/>" class="cButton" onClick="ChkUpload();">&nbsp;
          <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
      </td>
    </tr>
    
    

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.outputEquipmentTime"/></td>
        <td class="cInputColumn">
            <ww:textfield  name="outputTime" id="outputTime"  readonly="true" />
            <a href="javascript: NewCssCal('outputTime','yyyymmdd','arrow',true)">
              <img src="images/cal.gif" width="16" height="16" border="0">
            </a>    
        </td>
    </tr>
    
   <tr><td class="cInputCaption"><fmt:message key="billSchedule.outputEquipment"/></td>
        <td class="cInputColumn">
             <ww:select name="billSchedule.outputEquipmentId"  id="outputEquipmentId"
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="%{outputEquipmentList}"
               listKey="id"
               listValue="name"
               cssClass="cInputListField"
            />
        </td>
    </tr>
    
   <tr><td class="cInputCaption"><fmt:message key="billSchedule.outputDevice"/></td>
        <td class="cInputColumn">
           <ww:textarea name="billSchedule.outputDevice" value="%{billSchedule.outputDevice}" cssClass="cInputTextArea" cols="45" rows="4" />
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
                <ww:if test="bill.id != null">
                   <ww:select id="allBillDetail"
                   list="%{getBillDetailListByBillNo('${bill.id}','12')}"
                   listKey="id"
                   listValue="id+'-'+product.productName"               
                   multiple="true"
                   size="8"
                   cssClass="cQueryFieldList"
                />
                </ww:if>
                <ww:else>
                   <ww:select id="allBillDetail"
                   list="%{getBillDetailListByProducts('12')}"
                   listKey="id"
                   listValue="bill.id+'-'+product.productName"
                   multiple="true"
                   size="8"
                   cssClass="cQueryFieldList"
                  />
                </ww:else>           
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
    
        <tr class="cActionButtonLine">
      <td colspan="2">
         <input type="button" value="<fmt:message key="common.save"/>" class="cButton" onClick="ChkUpload();">&nbsp;
         <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
      </td>
    </tr>
    
</table>
  
  
</ww:form>





<script>

 moveAll(document.Form1.allBillDetail, document.Form1.selectedBillDetailIds);
 
 
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
 
 
function ChkUpload()
{	
  if (document.Form1.outputTime.value == ""){
	  alert('<fmt:message key="billSchedule.outputEquipmentTime"/><fmt:message key="common.required"/>');	       
	  return False;
	}		
	if (document.Form1.outputEquipmentId.value == ""){
	  alert('<fmt:message key="billSchedule.outputEquipment"/><fmt:message key="common.required"/>');	       
	  return False;
	}
	if (document.Form1.billDetailIds.options.length==0){		
		alert("<fmt:message key='billdetail'/><fmt:message key='common.required'/>");
		return False;	  	
	} 
  mySelectAll(document.Form1.billDetailIds); 	
  document.Form1.submit();
}
 
</script>

