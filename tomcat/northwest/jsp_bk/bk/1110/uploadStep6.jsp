<%@ include file="/common/taglibs.jsp"%>
<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css" />
<script type="text/javascript" src="${ctx}/scripts/list.js"></script>
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>

<ww:form name="Form1" action="saveCheck6" method="POST" onsubmit="onSubmit()" enctype="multipart/form-data">
  <ww:hidden name="bill.id" value="${bill.id}"/>
   <table border="0" cellspacing="1" class="cContentTable1">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="bill.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
          <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
          <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
      </td>
    </tr>
    
    
    <tr><td class="cInputCaption"><fmt:message key="billSchedule.checkDiagram"/></td>
        <td class="cInputColumn">
           <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="fileCheckDiagram" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </td>
    </tr>
    
    <tr><td class="cInputCaption"><fmt:message key="billSchedule.imageDiagram"/></td>
        <td class="cInputColumn">
           <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="fileImageDiagram" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
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
                   list="%{getBillDetailListByBillNo('${bill.id}','11')}"
                   listKey="id"
                   listValue="id+'-'+product.productName"               
                   multiple="true"
                   size="8"
                   cssClass="cQueryFieldList"
                />
                </ww:if>
                <ww:else>
                   <ww:select id="allBillDetail"
                   list="%{getBillDetailListByProducts('11')}"
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
          <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
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
 
</script>

