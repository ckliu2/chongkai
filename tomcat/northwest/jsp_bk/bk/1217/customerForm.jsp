<%@ include file="/common/taglibs.jsp"%>


  
  <table width="100%" border="0">
  <tr>
    <td colspan="2" align="left" valign="top" class="cContentTitle">
    

    <fmt:message key="customer.form"/>
    </td>
    </tr>
  <tr>
    <td align="left" valign="top">
<ww:form name="customerForm" action="saveCustomer" method="POST" enctype="multipart/form-data" >
  <ww:hidden name="customer.id" value="${customer.id}"/>
  <ww:hidden name="customerDetail.id" value="${customerDetail.id}"/>    
    <!----------------- 客戶基本資料------------------>
         <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;

        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;

        </ww:else>   
    
 <table border="0" cellspacing="1" class="cContentTable">

    <tr><td class="cInputCaption"><fmt:message key="customer.id"/></td>
        <td class="cInputColumn">
        ${customer.id}
        </td>
    </tr>


    <tr><td class="cInputCaption"><fmt:message key="customer.name"/></td>
        <td class="cInputColumn">
        ${customer.name}
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="customer.linkMan"/></td>
        <td class="cInputColumn">
        ${customer.linkMan}
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="customer.address"/></td>
        <td class="cInputColumn">
         ${customer.address}
        </td>
    </tr>    
    
     <tr><td class="cInputCaption"><fmt:message key="customer.telephone"/></td>
        <td class="cInputColumn">
        ${customer.telephone}
        </td>
    </tr>
    
    

  
  
    <tr><td class="cInputCaption"><fmt:message key="customerdetail.counter"/></td>
        <td class="cInputColumn"> 
          <ww:textfield name="customerDetail.counter" value="%{customerDetail.counter}" maxlength="20" cssClass="cInputTextFieldShort" />
        </td>
    </tr>  
    
    
     <tr><td class="cInputCaption"><fmt:message key="customerdetail.counterNo"/></td>
        <td class="cInputColumn"> 
         <ww:textfield name="customerDetail.counterNo" value="%{customerDetail.counterNo}" maxlength="20" cssClass="cInputTextFieldShort" />
        </td>
    </tr>
    
    
    <tr><td class="cInputCaption"><fmt:message key="customerdetail.contacts"/></td>
        <td class="cInputColumn"> 
         <ww:textfield name="customerDetail.contacts" value="%{customerDetail.contacts}" maxlength="20" cssClass="cInputTextFieldShort" />
        </td>
    </tr> 
    

    
    <tr><td class="cInputCaption"><fmt:message key="customerdetail.location"/></td>
        <td class="cInputColumn"> 
            <ww:textfield name="customerDetail.location" value="%{customerDetail.location}" maxlength="100" cssClass="cInputTextFieldLong" />
        </td>
    </tr>
  
  
    <tr><td class="cInputCaption"><fmt:message key="customerdetail.counterPhone"/></td>
        <td class="cInputColumn"> 
          <ww:textfield name="customerDetail.counterPhone" value="%{customerDetail.counterPhone}" maxlength="20" cssClass="cInputTextFieldShort" />
      </td>
    </tr> 
    
    
    <tr><td class="cInputCaption"><fmt:message key="customerDetail.planmap"/></td>
        <td class="cInputColumn">
        <ww:if test="customerDetail.planmap != null">
            <input type="checkbox" name="removePlanmap" onclick="if (this.checked == true) document.customerForm.filePlanmap.style.display='inline'; else document.customerDetailForm.filePlanmap.style.display='none';" value="<ww:property value="customerDetail.planmap.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="customerDetail.uploadPlanmap.relativeUrl"/>/<ww:property value="customerDetail.id"/>/<ww:property value="customerDetail.planmap.fileName"/>"><ww:property value="customerDetail.planmap.fileName" /> (<ww:property value="customerDetail.planmap.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="filePlanmap" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="customerDetail.planmapId" value="${customerDetail.planmap.id}"/>
            <ww:hidden name="customerDetail.planmapFileName" value="${customerDetail.planmap.fileName}"/>
            <img src="${ctx}/<fmt:message key="customerDetail.uploadPlanmap.relativeUrl"/>/<ww:property value="customerDetail.id"/>/${customerDetail.planmap.fileName}" width="150">
       </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="filePlanmap" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    
    
    <tr><td class="cInputCaption"><fmt:message key="customerDetail.photo1"/></td>
        <td class="cInputColumn">
        <ww:if test="customerDetail.photo1 != null">
            <input type="checkbox" name="removePhoto1" onclick="if (this.checked == true) document.customerForm.filePhoto1.style.display='inline'; else document.customerForm.filePhoto1.style.display='none';" value="<ww:property value="customerDetail.photo1.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="customerDetail.uploadPhoto1.relativeUrl"/>/<ww:property value="customerDetail.id"/>/<ww:property value="customerDetail.photo1.fileName"/>"><ww:property value="customerDetail.photo1.fileName" /> (<ww:property value="customerDetail.photo1.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="filePhoto1" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="customerDetail.photo1Id" value="${customerDetail.photo1.id}"/>
            <ww:hidden name="customerDetail.photo1FileName" value="${customerDetail.photo1.fileName}"/>
            <img src="${ctx}/<fmt:message key="customerDetail.uploadPhoto1.relativeUrl"/>/<ww:property value="customerDetail.id"/>/${customerDetail.photo1.fileName}" width="150">
       </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="filePhoto1" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="customerDetail.photo2"/></td>
        <td class="cInputColumn">
        <ww:if test="customerDetail.photo2 != null">
            <input type="checkbox" name="removePhoto2" onclick="if (this.checked == true) document.customerForm.filePhoto2.style.display='inline'; else document.customerForm.filePhoto2.style.display='none';" value="<ww:property value="customerDetail.photo2.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="customerDetail.uploadPhoto2.relativeUrl"/>/<ww:property value="customerDetail.id"/>/<ww:property value="customerDetail.photo2.fileName"/>"><ww:property value="customerDetail.photo2.fileName" /> (<ww:property value="customerDetail.photo2.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="filePhoto2" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="customerDetail.photo2Id" value="${customerDetail.photo2.id}"/>
            <ww:hidden name="customerDetail.photo2FileName" value="${customerDetail.photo2.fileName}"/>
            <img src="${ctx}/<fmt:message key="customerDetail.uploadPhoto2.relativeUrl"/>/<ww:property value="customerDetail.id"/>/${customerDetail.photo2.fileName}" width="150">
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="filePhoto2" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="customerDetail.photo3"/></td>
        <td class="cInputColumn">
        <ww:if test="customerDetail.photo3 != null">
            <input type="checkbox" name="removePhoto3" onclick="if (this.checked == true) document.customerForm.filePhoto3.style.display='inline'; else document.customerForm.filePhoto3.style.display='none';" value="<ww:property value="customerDetail.photo3.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="customerDetail.uploadPhoto3.relativeUrl"/>/<ww:property value="customerDetail.id"/>/<ww:property value="customerDetail.photo3.fileName"/>"><ww:property value="customerDetail.photo3.fileName" /> (<ww:property value="customerDetail.photo3.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="filePhoto3" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="customerDetail.photo3Id" value="${customerDetail.photo3.id}"/>
            <ww:hidden name="customerDetail.photo3FileName" value="${customerDetail.photo3.fileName}"/>
            <img src="${ctx}/<fmt:message key="customerDetail.uploadPhoto3.relativeUrl"/>/<ww:property value="customerDetail.id"/>/${customerDetail.photo3.fileName}" width="150">
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="filePhoto3" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="customerDetail.photo4"/></td>
        <td class="cInputColumn">
        <ww:if test="customerDetail.photo4 != null">
            <input type="checkbox" name="removePhoto4" onclick="if (this.checked == true) document.customerForm.filePhoto4.style.display='inline'; else document.customerForm.filePhoto4.style.display='none';" value="<ww:property value="customerDetail.photo4.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="customerDetail.uploadPhoto4.relativeUrl"/>/<ww:property value="customerDetail.id"/>/<ww:property value="customerDetail.photo4.fileName"/>"><ww:property value="customerDetail.photo4.fileName" /> (<ww:property value="customerDetail.photo4.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="filePhoto4" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="customerDetail.photo4Id" value="${customerDetail.photo4.id}"/>
            <ww:hidden name="customerDetail.photo4FileName" value="${customerDetail.photo4.fileName}"/>
            <img src="${ctx}/<fmt:message key="customerDetail.uploadPhoto4.relativeUrl"/>/<ww:property value="customerDetail.id"/>/${customerDetail.photo4.fileName}" width="150">
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="filePhoto4" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="customerDetail.photo5"/></td>
        <td class="cInputColumn">
        <ww:if test="customerDetail.photo5 != null">
            <input type="checkbox" name="removePhoto5" onclick="if (this.checked == true) document.customerForm.filePhoto5.style.display='inline'; else document.customerForm.filePhoto5.style.display='none';" value="<ww:property value="customerDetail.photo5.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="customerDetail.uploadPhoto5.relativeUrl"/>/<ww:property value="customerDetail.id"/>/<ww:property value="customerDetail.photo5.fileName"/>"><ww:property value="customerDetail.photo5.fileName" /> (<ww:property value="customerDetail.photo5.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="filePhoto5" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />

            <ww:hidden name="customerDetail.photo5Id" value="${customerDetail.photo5.id}"/>
            <ww:hidden name="customerDetail.photo5FileName" value="${customerDetail.photo5.fileName}"/>
            <img src="${ctx}/<fmt:message key="customerDetail.uploadPhoto5.relativeUrl"/>/<ww:property value="customerDetail.id"/>/${customerDetail.photo5.fileName}" width="150">
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="filePhoto5" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>


    <tr><td class="cInputCaption"><fmt:message key="customerDetail.saleman"/></td>
        <td class="cInputColumn">
           ${customer.saleman}
        </td>
       
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="customerDetail.customerService"/></td>
        <td class="cInputColumn">
            <ww:select name="customerDetail.customerServiceId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="memberList"
               listKey="id"
                listValue="id+'--'+name"
               cssClass="cInputListField"
            />
        </td>
    </tr>
 </table>
 
          <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;

        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;

        </ww:else>  
</ww:form>    
    <!----------------- 客戶基本資料------------------>
    
    
    
    </td>
    <td align="left" valign="top" >
    
    <!----------------- 櫃點------------------>
<form action="queryCustomerDetail.html" method="post">   
<ww:hidden name="customer.id" value="${customer.id}"/> 
<span class="cLabel">    
<fmt:message key="common.keyin"/><fmt:message key="customerdetail.counterNo"/>/<fmt:message key="customerdetail.counter"/>: <ww:textfield name="keyword" value="%{keyword}" maxlength="30" cssClass="cInputTextFieldShort" />
<input type="submit" value="<fmt:message key="common.search"/>" class="cButton" >
</span>

<c:set var="count" value="1" />
<display:table name="customerDetails" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column titleKey="common.select">
         ${count}
    </display:column>
    
    <display:column property="counterNo" sortable="true" titleKey="customerdetail.counterNo" style="text-align:left" />
    <display:column property="counter" sortable="true" titleKey="customerdetail.counter" style="text-align:left" />    
    <display:column property="contacts" sortable="true" titleKey="customerdetail.contacts" style="text-align:left" />    
    <display:column property="location" sortable="true" titleKey="customerdetail.location" style="text-align:left" />
    <display:column property="counterPhone" sortable="true" titleKey="customerdetail.counterPhone" style="text-align:left" />

    <display:column titleKey="customerDetail.photo1">
         ${row.photo1.fileName}
    </display:column>
    <display:column titleKey="customerDetail.photo2">
         ${row.photo2.fileName}
    </display:column>
    <display:column titleKey="customerDetail.photo3">
         ${row.photo3.fileName}
    </display:column>
    <display:column titleKey="customerDetail.photo4">
         ${row.photo4.fileName}
    </display:column>
    <display:column titleKey="customerDetail.photo5">
         ${row.photo5.fileName}
    </display:column>
    
    
    <display:column property="customer.saleman" sortable="true" titleKey="customerDetail.saleman" style="text-align:left" />
    <display:column property="customerService" sortable="true" titleKey="customerDetail.customerService" style="text-align:left" />
    
    <display:column titleKey="common.action">
      <a href="javascript:openChild('customerScreenList.html?customerdetail.id=${row.id}')"><fmt:message key="common.setting"/><fmt:message key="customerdetail.screenPosition"/></a>
    </display:column>
    
    
    <display:column titleKey="common.action">
        <ww:if test="recordEditable == true">
            <a href="editCustomer.html?customer.id=${row.customer.id}&customerDetail.id=<c:out value="${row.id}"/>"><fmt:message key="common.edit"/></a>&nbsp;&nbsp;
            <a href="#" onClick="javascript:return myConfirm('<fmt:message key="common.confirmDelete1"/><c:out value="${row.counterNo}" /><fmt:message key="common.confirmDelete2"/>', 'form1', 'customerDetail.id', '${row.id}')"><fmt:message key="common.delete"/></a>
        </ww:if>
        <ww:else>
           <a href="editCustomer.html?customer.id=${row.customer.id}&customerDetail.id=<c:out value="${row.id}"/>"><fmt:message key="common.view"/></a>&nbsp;&nbsp;
        </ww:else>
         
    </display:column>
  
   
    <c:set var="count" value="${count+1}" />
</display:table>
 </form>    
    <!----------------- 櫃點------------------>
    
    </td>
  </tr>
</table>






<form name="form1" action="saveCustomer.html">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="customerDetail.id" value="">
</form>


<script>

function openChild(page){ 
	 lovechild = window.open(page, "screenPosition","height=600, width=800,resizable=yes,menubar=0,toolbar=0,location=0,directories=0,scrollbars=yes,status=0")
}

</script>
