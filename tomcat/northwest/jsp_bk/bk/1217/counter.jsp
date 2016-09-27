<%@ include file="/common/taglibs.jsp"%>
<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css" />
<script type="text/javascript" src="${ctx}/scripts/list.js"></script>
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>

<ww:set name="c" value="%{getCustomerDetailById()}"/> 
   <table border="0" cellspacing="1" class="cContentTable1">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="customer.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">           
      </td>
    </tr>    
    
    <tr><td class="cInputCaption"><fmt:message key="customer.id"/></td>
        <td class="cInputColumn">
           ${c.customer.id}       
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="customer.name"/></td>
        <td class="cInputColumn">
            ${c.customer.name}         
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="customer.linkMan"/></td>
        <td class="cInputColumn">
             ${c.customer.linkMan}    
        </td>
    </tr>
    

    <tr><td class="cInputCaption"><fmt:message key="customer.address"/></td>
        <td class="cInputColumn">
             ${c.customer.address}            
        </td>
    </tr>    
    
     <tr><td class="cInputCaption"><fmt:message key="customer.telephone"/></td>
        <td class="cInputColumn">
             ${c.customer.telephone}    
        </td>
    </tr>
    
    
    <tr><td class="cInputCaption"><fmt:message key="customerdetail.counterNo"/></td>
        <td class="cInputColumn"> 
             ${c.counterNo}    
        </td>
    </tr>
  
  
    <tr><td class="cInputCaption"><fmt:message key="customerdetail.counter"/></td>
        <td class="cInputColumn"> 
              ${c.counter} 
        </td>
    </tr>   
    
    <tr><td class="cInputCaption"><fmt:message key="customerdetail.screenPosition"/></td>
        <td class="cInputColumn"> 
              ${c.screenPosition} 
        </td>
    </tr>
    
    <tr><td class="cInputCaption"><fmt:message key="customerdetail.location"/></td>
        <td class="cInputColumn"> 
             ${c.location} 
        </td>
    </tr>
  
  
    <tr><td class="cInputCaption"><fmt:message key="customerdetail.counterPhone"/></td>
        <td class="cInputColumn"> 
             ${c.counterPhone}
        </td>
    </tr> 
    
    
    <tr><td class="cInputCaption"><fmt:message key="customerDetail.photo1"/></td>
        <td class="cInputColumn">  
         <ww:if test="${c.photo1.id} != null">
              <a href="${ctx}/<fmt:message key="customerDetail.uploadPhoto1.relativeUrl"/>/${c.id}/${c.photo1.fileName}" target="_blank">             
               <img src="${ctx}/<fmt:message key="customerDetail.uploadPhoto1.relativeUrl"/>/${c.id}/${c.photo1.fileName}" width="100" border="0"/>
              </a>
         </ww:if>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="customerDetail.photo2"/></td>
        <td class="cInputColumn">
         <ww:if test="${c.photo2.id} != null">
              <a href="${ctx}/<fmt:message key="customerDetail.uploadPhoto2.relativeUrl"/>/${c.id}/${c.photo2.fileName}" target="_blank">             
               <img src="${ctx}/<fmt:message key="customerDetail.uploadPhoto2.relativeUrl"/>/${c.id}/${c.photo2.fileName}" width="100" border="0"/>
              </a>
         </ww:if>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="customerDetail.photo3"/></td>
        <td class="cInputColumn">
         <ww:if test="${c.photo3.id} != null">
              <a href="${ctx}/<fmt:message key="customerDetail.uploadPhoto3.relativeUrl"/>/${c.id}/${c.photo3.fileName}" target="_blank">             
               <img src="${ctx}/<fmt:message key="customerDetail.uploadPhoto3.relativeUrl"/>/${c.id}/${c.photo3.fileName}" width="100" border="0"/>
              </a>
         </ww:if>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="customerDetail.photo4"/></td>
        <td class="cInputColumn">
         <ww:if test="${c.photo4.id} != null">
              <a href="${ctx}/<fmt:message key="customerDetail.uploadPhoto4.relativeUrl"/>/${c.id}/${c.photo4.fileName}" target="_blank">             
               <img src="${ctx}/<fmt:message key="customerDetail.uploadPhoto4.relativeUrl"/>/${c.id}/${c.photo4.fileName}" width="100" border="0"/>
              </a>
         </ww:if>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="customerDetail.photo5"/></td>
        <td class="cInputColumn">
         <ww:if test="${c.photo5.id} != null">
              <a href="${ctx}/<fmt:message key="customerDetail.uploadPhoto5.relativeUrl"/>/${c.id}/${c.photo5.fileName}" target="_blank">             
               <img src="${ctx}/<fmt:message key="customerDetail.uploadPhoto5.relativeUrl"/>/${c.id}/${c.photo5.fileName}" width="100" border="0"/>
              </a>
         </ww:if>
        </td>
    </tr>


    <tr><td class="cInputCaption"><fmt:message key="customerDetail.saleman"/></td>
        <td class="cInputColumn">
            ${c.customer.saleman}
        </td>       
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="customerDetail.customerService"/></td>
        <td class="cInputColumn">
             ${c.customerService}
        </td>
    </tr>
 
     <tr class="cActionButtonLine">
      <td colspan="2">
           
      </td>
    </tr>     
</table>
  
  








