<%@ include file="/common/taglibs.jsp"%>
<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/displaytag.css" />
<script type="text/javascript" src="${ctx}/scripts/list.js"></script>
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<script type="text/javascript" src="${ctx}/scripts/printer.js"></script>
<head>
    <title><fmt:message key="report.complete"/></title>
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

<table  border="0"  >
  <tr >
    <td width="20%" align="left" valign="middle" class="cInputCaption">${bill.customer.name}</td>
    <td align="left" valign="middle" class="cInputCaption"><table width="100%" border="0">
      <tr>
        <td nowrap="nowrap" class="cInputCaption1">
              <fmt:message key="customer.address"/> :${bill.customer.address}        </td>
      </tr>
      <tr>
        <td nowrap="nowrap" class="cInputCaption">
             <fmt:message key="customer.telephone"/> :${bill.customer.telephone}        </td>
      </tr>
    </table>    </td>
  </tr>
  <tr>
    <td colspan="2" align="left" valign="middle" nowrap="nowrap"  class="cInputCaption1">

    <c:set var="i" value="1" />
     <ww:set name="al" value="%{getBillDetailListByBillNo('${bill.id}')}"/>    
        <ww:iterator value="al">
          <ww:set name="schedule" value="%{getBillScheduleById('${id}')}"/>   
           <c:set var="count" value="0" />       
           <c:forEach var="files" items="${schedule.drawingsFiles}"> 
               <ww:if test="${count} == 0">
                  <a href="${ctx}/upload/drawings/${bill.id}/${files.fileName}" target="_blank">
                   <img src="${ctx}/upload/drawings/${bill.id}/${files.fileName}" width="150" height="150" border="0"/> 
                  </a>
                  ${schedule.customerScreen.name}
                       <ww:if test="${i}%2 == 0">
                         <BR>                           
                       </ww:if>
                  <c:set var="i" value="${i+1}" />
               </ww:if>

              <c:set var="count" value="${count+1}" />
           </c:forEach>  
        </ww:iterator>    
    </td>
  </tr>
</table>


