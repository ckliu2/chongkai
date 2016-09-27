<%@ include file="/common/taglibs.jsp"%>
<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css" />
<script type="text/javascript" src="${ctx}/scripts/list.js"></script>
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/displaytag.css" />

<table width="100%" border="0">
  <tr>
    <td align="left" valign="top">
    
<c:set var="count" value="1" />
<ww:form name="customerScreenForm" action="saveCustomerScreen" method="POST"  enctype="multipart/form-data" onsubmit="onSubmit()">
  <ww:hidden name="customerScreen.customerDetailId" value="${customerdetail.id}"/> 
  <ww:hidden name="customerScreen.id" value="${customerScreen.id}"/>
  
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="customerScreen.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;

        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            
        </ww:else>
      </td>
    </tr>
    

    
     <tr><td class="cInputCaption"><fmt:message key="customerScreen.name"/></td>
        <td class="cInputColumn">
            <ww:textfield name="customerScreen.name" value="%{customerScreen.name}"  cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="customerScreen.memo"/></td>
        <td class="cInputColumn">
            <ww:textarea name="customerScreen.memo" value="%{customerScreen.memo}" cssClass="cInputTextArea" cols="45" rows="3" />
        </td>
    </tr>





    <tr><td class="cInputCaption"><fmt:message key="customerScreen.customerScreenFiles"/></td>
        <td class="cInputColumn">
              
          <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="filePhoto1" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
          
        </td>
    </tr>
    
    
   <tr><td class="cInputCaption"></td>
        <td class="cInputColumn">
        <ww:if test="customerScreen.id != null">  
            
         <c:forEach var="files" items="${customerScreen.customerScreenFiles}">
         <a href="${ctx}/upload/customerScreen/${customerScreen.id}/${files.fileName}" target="_blank">
           <img src="${ctx}/upload/customerScreen/${customerScreen.id}/${files.fileName}" width="150" height="150" border="0"/> 
         </a>  
          [<fmt:message key="member.deleted"/><input type="checkbox" name="file${count}" value="${files.id}">]
         
          <c:set var="count" value="${count+1}" />   
         </c:forEach> 
     
           
        
          <ww:select name="customerScreenFilesIds" 
           list="customerScreenFilesList"
           listKey="id"
           listValue="id"
           multiple="true"
           size="8"
          />
       </ww:if> 
       
        </td>
    </tr>
    

    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
           
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="customerScreen.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    
    
    
  </table>
  

          
</ww:form>
    </td>
  </tr>

</table>



<script>
function onSubmit(){ 
mySelectAll(document.customerScreenForm.customerScreenFilesIds);  
  for(j=1;j<=${count};j++){	
		var s = eval('document.customerScreenForm.file'+j) ; 	
      if(s.checked==true){
		    //alert(s.value);
		    document.customerScreenForm.customerScreenFilesIds.options.remove(j-1);
		  }  
   } 
}
	 
document.customerScreenForm.customerScreenFilesIds.style.display='none';	 
</script>