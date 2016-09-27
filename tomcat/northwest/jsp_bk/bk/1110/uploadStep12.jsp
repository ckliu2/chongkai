<%@ include file="/common/taglibs.jsp"%>
<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css" />
<script type="text/javascript" src="${ctx}/scripts/list.js"></script>
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/displaytag.css" />
<script type="text/javascript" src="${ctx}/scripts/datetimepicker_css.js"></script>


<table width="100%" border="0">
  <tr>
    <td align="left" valign="top">

<c:set var="count" value="1" />
<ww:form name="Form1" action="saveCheck12" method="POST"  enctype="multipart/form-data" onsubmit="onSubmit()" >
  
  <ww:hidden name="bill.id" value="${bill.id}"/>
  <ww:hidden name="billSchedule.billDetailId" value="${billSchedule.billDetailId}"/>


  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="billSchedule.drawings"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <input type="button" value="<fmt:message key="common.window.close.window"/>" onClick="javascript:reflash();" class="cButton">&nbsp;
      </td>
    </tr>    


    <tr><td class="cInputCaption"><fmt:message key="billSchedule.uploadDrawingsTime"/></td>
        <td class="cInputColumn">
        

            <ww:textfield  name="uploadDrawingsTime" id="uploadDrawingsTime"  readonly="true" value="${fn:substring(billSchedule.uploadDrawingsTime,0,16)}" />
            <a href="javascript: NewCssCal('uploadDrawingsTime','yyyymmdd','arrow',true)">
              <img src="images/cal.gif" width="16" height="16" border="0">
            </a> 
         
        </td>
    </tr>


    <tr><td class="cInputCaption"><fmt:message key="billSchedule.drawingsmemo"/></td>
        <td class="cInputColumn">
            <ww:textarea name="billSchedule.drawingsMemo" value="%{billSchedule.drawingsMemo}" cssClass="cInputTextArea" cols="45" rows="3" />
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
                   list="%{getBillDetailListByBillNo('${bill.id}','19')}"
                   listKey="id"
                   listValue="bill.id+'-'+product.productName"               
                   multiple="true"
                   size="8"
                   cssClass="cQueryFieldList"
                />
                </ww:if>
                <ww:else>
                   <ww:select id="allBillDetail"
                   list="%{getBillDetailListByProducts('19')}"
                   listKey="id"
                   listValue="id+'-'+bill.id+'-'+product.productName"
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
    
  
        <tr><td class="cInputCaption"><fmt:message key="billSchedule.uploadDrawings"/></td>
        <td class="cInputColumn">          
          <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="fileDrawing" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
          
        </td>
    </tr>
  
 
   <tr><td class="cInputCaption"></td>
        <td class="cInputColumn">

         <c:forEach var="files" items="${billSchedule.drawingsFiles}">       
         
         
         <table>
         <tr>
         <a href="${ctx}/upload/drawings/${bill.id}/${files.fileName}" target="_blank">
           <img src="${ctx}/upload/drawings/${bill.id}/${files.fileName}" width="150" height="150" border="0"/> 
         </a>
         </tr>
         <tr>  
            [${files.lastModifiedDate}]
           <tr>
          <tr>  
           [<fmt:message key="member.deleted"/><input type="checkbox" name="file${count}" value="${files.id}">]
         <tr>
         </table>
        
          <c:set var="count" value="${count+1}" />   
         </c:forEach> 
       
           
       
          <ww:select name="drawingsFilesIds" 
           list="drawingsFilesList"
           listKey="id"
           listValue="id"
           multiple="true"
           size="8"
          />
   
        </td>
    </tr>
  
 

    <tr class="cActionButtonLine">
      <td colspan="2">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <input type="button" value="<fmt:message key="common.window.close.window"/>" onClick="javascript:reflash();" class="cButton">&nbsp;
       </td>
    </tr>
    
    
    
  </table>
  

          
</ww:form>
    </td>
  </tr>

</table>



<script>
 function reflash(){
   window.opener.parent.location.reload();
   window.close();
 }
 

 
function onSubmit(){ 	

	
	
	
	 mySelectAll(document.Form1.billDetailIds);   
   mySelectAll(document.Form1.drawingsFilesIds);  
   for(j=1;j<=${count};j++){	
		var s = eval('document.Form1.file'+j) ; 			
      if(s.checked==true){
		    var sel=eval('document.Form1.drawingsFilesIds');
        for(k=0;k<sel.length;k++){
        	 var c=sel.options[k].value;
        	 if(c==s.value){
        	 	   document.Form1.drawingsFilesIds.options.remove(k);
        	  }
        }	
		  }  
   } 
   
}
	 
document.Form1.drawingsFilesIds.style.display='none';	


 <%
 String reload=request.getParameter("reload");
  if (reload != null && reload.equals("Y")) {
 %>
   reflash();
 <%
 }
 %>

 moveAll(document.Form1.allBillDetail, document.Form1.selectedBillDetailIds);
</script>







