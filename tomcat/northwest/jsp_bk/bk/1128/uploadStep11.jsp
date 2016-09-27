<%@ include file="/common/taglibs.jsp"%>
<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css" />
<script type="text/javascript" src="${ctx}/scripts/list.js"></script>
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<script type="text/javascript" src="${ctx}/scripts/datetimepicker_css.js"></script>

<ww:form name="Form1" action="saveCheck11" method="POST" >
  <ww:hidden name="bill.id" value="${bill.id}"/>
   <table border="0" cellspacing="1" class="cContentTable1">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="bill.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type="button" value="<fmt:message key="common.save"/>" class="cButton" onClick="ChkUpload();">&nbsp;
        <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
      </td>
    </tr>
    
    
    <tr><td class="cInputCaption"><fmt:message key="billSchedule.sendMethod"/></td>
        <td class="cInputColumn">
            <ww:select name="billSchedule.isSendId"  id="sendMethod"
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
            <ww:select name="billSchedule.freightId"  id="freight"
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
            <ww:textfield id="freightNo" name="billSchedule.freightNo" value="%{billSchedule.freightNo}"  cssClass="cInputTextField" />
        </td>
    </tr>
    


    <tr><td class="cInputCaption"><fmt:message key="billSchedule.arrival"/></td>
        <td class="cInputColumn">
            <ww:textfield  name="arrival" id="arrival"  readonly="true" />
            <a href="javascript: NewCssCal('arrival','yyyymmdd','arrow',true)">
              <img src="images/cal.gif" width="16" height="16" border="0">
            </a>    
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
                   list="%{getBillDetailListByBillNo('${bill.id}','17')}"
                   listKey="id"
                   listValue="id+'-'+product.productName"               
                   multiple="true"
                   size="8"
                   cssClass="cQueryFieldList"
                />
                </ww:if>
                <ww:else>
                   <ww:select id="allBillDetail"
                   list="%{getBillDetailListByProducts('17')}"
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
  if (document.Form1.sendMethod.value == ""){
	  alert('<fmt:message key="billSchedule.sendMethod"/><fmt:message key="common.required"/>');	       
	  return False;
	}		
	if (document.Form1.freight.value == ""){
	  alert('<fmt:message key="freight.name"/><fmt:message key="common.required"/>');	       
	  return False;
	}	
  if (document.Form1.freightNo.value == ""){
	  alert('<fmt:message key="freight.no"/><fmt:message key="common.required"/>');	       
	  return False;
	}			
	if (document.Form1.arrival.value == ""){
	  alert('<fmt:message key="billSchedule.arrival"/><fmt:message key="common.required"/>');	       
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

