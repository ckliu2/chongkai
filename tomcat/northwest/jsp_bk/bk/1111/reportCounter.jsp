<%@ include file="/common/taglibs.jsp"%>
<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/displaytag.css" />
<script type="text/javascript" src="${ctx}/scripts/list.js"></script>
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<script type="text/javascript" src="${ctx}/scripts/printer.js"></script>
<head>
    <title><fmt:message key="report.counter"/></title>
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
    <td align="left" valign="middle" nowrap="nowrap" class="cInputCaption">${bill.customer.name}-${billSchedule.customerScreen.customerDetail.counter}</td>
    <td align="left" valign="middle" nowrap="nowrap" class="cInputCaption"><table width="100%" border="0">
      <tr>
        <td rowspan="2" nowrap="nowrap" class="cInputCaption"><fmt:message key="customerdetail.contacts"/>
          :${row.customerScreen.customerDetail.contacts} </td>
        <td nowrap="nowrap" class="cInputCaption1"><fmt:message key="customerdetail.location"/>
          :${row.customerScreen.customerDetail.location} </td>
      </tr>
      <tr>
        <td nowrap="nowrap" class="cInputCaption"><fmt:message key="customerdetail.counterPhone"/>
          :${row.customerScreen.customerDetail.counterPhone} </td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td align="center" valign="middle"  class="cInputCaption">
    <fmt:message key="customerDetail.planmap"/>    </td>
    <td align="left" valign="top"  class="cInputCaption">
    <img src="${ctx}/<fmt:message key="customerDetail.uploadPlanmap.relativeUrl"/>/${row.customerScreen.customerDetail.id}/${row.customerScreen.customerDetail.planmap.fileName}" width="450">    </td>
  </tr>
</table>
