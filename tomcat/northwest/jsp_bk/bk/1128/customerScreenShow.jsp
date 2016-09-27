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

      </td>
    </tr>
    
     <tr><td class="cInputCaption"><fmt:message key="customer.name"/></td>
        <td class="cInputColumn">
            ${customerScreen.customerDetail.customer.name}
        </td>
    </tr>
    
    
    <tr><td class="cInputCaption"><fmt:message key="customerdetail.counter"/></td>
        <td class="cInputColumn">
            ${customerScreen.customerDetail.counter}
        </td>
    </tr>
    
    <tr><td class="cInputCaption"><fmt:message key="customerdetail.counterNo"/></td>
        <td class="cInputColumn">
            ${customerScreen.customerDetail.counterNo}
        </td>
    </tr>
    
    
    <tr><td class="cInputCaption"><fmt:message key="customerdetail.contacts"/></td>
        <td class="cInputColumn">
            ${customerScreen.customerDetail.contacts}
        </td>
    </tr>
    
    
    <tr><td class="cInputCaption"><fmt:message key="customerdetail.counterPhone"/></td>
        <td class="cInputColumn">
            ${customerScreen.customerDetail.counterPhone}
        </td>
    </tr>
    
    
    <tr><td class="cInputCaption"><fmt:message key="customerdetail.location"/></td>
        <td class="cInputColumn">
            ${customerScreen.customerDetail.location}
        </td>
    </tr>
    
    
     <tr><td class="cInputCaption"><fmt:message key="customerScreen.name"/></td>
        <td class="cInputColumn">
            ${customerScreen.name}
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="customerScreen.memo"/></td>
        <td class="cInputColumn">
            ${customerScreen.memo}
        </td>
    </tr>

    
    
   <tr><td class="cInputCaption"></td>
        <td class="cInputColumn">
        <ww:if test="customerScreen.id != null">  
            
         <c:forEach var="files" items="${customerScreen.customerScreenFiles}">
           <a href="${ctx}/upload/customerScreen/${customerScreen.id}/${files.fileName}" target="_blank">
            <img src="${ctx}/upload/customerScreen/${customerScreen.id}/${files.fileName}" width="150" height="150" border="0"/>
           </a>  
           &nbsp;&nbsp;
         
          <c:set var="count" value="${count+1}" />   
         </c:forEach> 

       </ww:if> 
       
        </td>
    </tr>
    

    <tr class="cActionButtonLine">
      <td colspan="2">

      </td>
    </tr>
    
    
    
  </table>
  

          
</ww:form>
    </td>
  </tr>

</table>


