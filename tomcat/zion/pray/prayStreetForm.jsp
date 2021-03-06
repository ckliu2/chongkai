<%@ include file="/common/taglibs.jsp"%>
<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css" />

<ww:form name="prayStreetForm" action="savePrayStreet" method="POST" enctype="multipart/form-data">
  <ww:hidden name="prayStreet.id" value="${prayStreet.id}"/>
  <ww:hidden name="prayStreet.praytwId" value="${prayStreet.praytwId}"/>

  <table border="0" cellspacing="1" >
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="prayStreet.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
      
            <input type="button" value="<fmt:message key="common.save"/>" onclick="ck();" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="prayStreet.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
            
      </td>
    </tr>
    
    <tr><td class="cInputCaption">區域</td>
        <td class="cInputColumn">
           ${prayStreet.praytw.area.valueCh}
        </td>
    </tr>
    
    
    <tr><td class="cInputCaption"><fmt:message key="prayStreet.name"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield id="name" name="prayStreet.name" value="%{prayStreet.name}" cssClass="cInputTextFieldLong" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('prayStreet.name')"/></span>
        </td>
    </tr>


    <tr><td class="cInputCaption">緯度</td>
        <td class="cInputColumn">
            <ww:textfield name="prayStreet.latitude" value="%{prayStreet.latitude}" cssClass="cInputTextFieldLong" />
        </td>
    </tr>
    
    
    <tr><td class="cInputCaption">經度</td>
        <td class="cInputColumn">
            <ww:textfield name="prayStreet.longitude" value="%{prayStreet.longitude}" cssClass="cInputTextFieldLong" />
        </td>
    </tr>
    
    
    <tr><td class="cInputCaption">zoom</td>
        <td class="cInputColumn">            
            <ww:select name="prayStreet.zoom" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="zoomList"
               listKey="id"
               listValue="id"
               cssClass="cInputListField"
            />         
        </td>
    </tr>

    

    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="prayStreet.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="prayStreet.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>



 <%
 String reload=request.getParameter("reload"); 
  if (reload != null && reload.equals("1")) {
 %>
  <script>
   window.opener.parent.location.reload();
   window.close();
  </script>  
 <%
 }
 %>	
 
  <script> 
    function ck(){
    	var name=prayStreetForm.name.value;    	
    	if(name!=''){
    		prayStreetForm.submit();
    	}else{
    		alert("街道名稱為必填欄位!!");
    	}
    } 
  </script> 
