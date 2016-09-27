<%@ include file="/common/taglibs.jsp"%>
<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css" />
<script type="text/javascript" src="${ctx}/scripts/list.js"></script>
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/displaytag.css" />
<script type="text/javascript" src="${ctx}/scripts/datetimepicker_css.js"></script>


<table width="100%" border="0">
  <tr>
    <td align="left" valign="top">



  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="billSchedule.drawings"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">

      </td>
    </tr>    


    <tr><td class="cInputCaption"><fmt:message key="billSchedule.uploadDrawingsTime"/></td>
        <td class="cInputColumn">
           ${fn:substring(billSchedule.uploadDrawingsTime,0,16)}
        </td>
    </tr>


    <tr><td class="cInputCaption"><fmt:message key="billSchedule.drawingsmemo"/></td>
        <td class="cInputColumn">
            ${billSchedule.drawingsMemo}
        </td>
    </tr>

           
       <tr><td class="cInputCaption"><fmt:message key="common.completely"/><fmt:message key="bill.form"/></td>
        <td class="cInputColumn">
            ${billSchedule.billDetail.product.productName}
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

         </table> 
         
         
         </c:forEach>          
        </td>
    </tr>
 

    <tr class="cActionButtonLine">
      <td colspan="2">

      </td>
    </tr>    
  </table>
    </td>
  </tr>

</table>



