<%@ include file="/common/taglibs.jsp"%>

<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/displaytag.css" />
<script type="text/javascript" src="${ctx}/scripts/list.js"></script>
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<script type="text/javascript" src="${ctx}/scripts/printer.js"></script>
<head>
    <title><fmt:message key="report.construction"/></title>
    <STYLE type="text/css">
    @media print {
        .cPrint {
            display:none;
        }        
    }
        
		@media screen  {
        .cPrint {
            color:      #ff0000;
            font-size:  11px;
            position:   absolute;
            text-align: center;
            left:       520px;
            top:        10px;
            width:      50px;
            height:     50px;
            z-index:    100;
        }
    }
    
    </STYLE>

</head>
<ww:set name="row" value="%{getBillScheduleById('${billSchedule.billDetailId}')}"/>
 
<table  border="0"  >
  <tr >
    <td width="20%" align="left" valign="middle" class="cInputCaption">${bill.customer.name}-${billSchedule.customerScreen.customerDetail.counter}</td>
    <td align="left" valign="middle" class="cInputCaption"><table width="100%" border="0">
      <tr>
        <td rowspan="2" nowrap="nowrap" class="cInputCaption">
        <fmt:message key="customerdetail.contacts"/>:${row.customerScreen.customerDetail.contacts}        </td>
        <td nowrap="nowrap" class="cInputCaption1">
              <fmt:message key="customerdetail.location"/> :${row.customerScreen.customerDetail.location}        </td>
      </tr>
      <tr>
        <td nowrap="nowrap" class="cInputCaption">
             <fmt:message key="customerdetail.counterPhone"/> :${row.customerScreen.customerDetail.counterPhone}        </td>
      </tr>
    </table>    </td>
  </tr>
  <tr>
    <td colspan="2" align="center" valign="middle" class="cInputCaption1">
    
      <div align="left"> 
        <fmt:message key="product.name"/> :${row.billDetail.product.productName}<BR>
       
        ${row.billDetail.width}(<fmt:message key='billdetail.width'/>) X ${row.billDetail.heigh}(<fmt:message key='billdetail.heigh'/>) <BR>
        ${row.billDetail.visibleWidth}(<fmt:message key='billdetail.visiblewidth'/>)  X ${row.billDetail.visibleHeigh} (<fmt:message key='billdetail.visibleheight'/>)<BR>
        
        <fmt:message key="customerdetail.screenPosition"/> :${row.customerScreen.name}<BR>
        <fmt:message key="billSchedule.drawingsmemo"/> :${row.drawingsMemo}<BR>
        <fmt:message key="billSchedule.worker"/> :${row.worker}<BR>
        <fmt:message key="billSchedule.uploadDrawingsTime"/> :${row.uploadDrawingsTime}<BR>
    </div>    
    
    </td>
  </tr>
  <tr>
    <td colspan="2" align="center" valign="middle"  class="cInputCaption">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="2" align="center" valign="middle"  class="cInputCaption"><table width="100%" border="0">      
      <tr>
        <td  nowrap="nowrap"  class="cInputCaption1">        
               <img src="${ctx}/<fmt:message key="customerDetail.uploadPhoto1.relativeUrl"/>/${row.customerScreen.customerDetail.id}/${row.customerScreen.customerDetail.photo1.fileName}" width="150" height="150">
               <fmt:message key="customerDetail.photo1"/>&nbsp;&nbsp;&nbsp;&nbsp;
               
               <img src="${ctx}/<fmt:message key="customerDetail.uploadPhoto2.relativeUrl"/>/${row.customerScreen.customerDetail.id}/${row.customerScreen.customerDetail.photo2.fileName}" width="150" height="150">
               <fmt:message key="customerDetail.photo2"/>
        </td>
      </tr>
      
      <tr>
        <td  nowrap="nowrap"  class="cInputCaption1">   
         <c:set var="count" value="1" />  
         <c:forEach var="files" items="${billSchedule.drawingsFiles}">      

         <a href="${ctx}/upload/drawings/${bill.id}/${files.fileName}" target="_blank">
           <img src="${ctx}/upload/drawings/${bill.id}/${files.fileName}" width="150" height="150" border="0"/> 
         </a>
         <fmt:message key="billSchedule.drawings"/>${count}
         
          <ww:if test="${count}%2 == 0">
            <BR>
          </ww:if>
         
         <c:set var="count" value="${count+1}" />
         </c:forEach>              

        </td>
      </tr>

    </table>
    
    </td>
  </tr>
  <tr>
    <td colspan="2" align="center" valign="middle"  class="cInputCaption">

    
    </td>
  </tr>
</table>