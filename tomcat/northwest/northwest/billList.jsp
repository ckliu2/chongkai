<%@ include file="/common/taglibs.jsp"%>

<table border="0" cellspacing="1" >
      <tr>
        <td class="cContentTitle" ><fmt:message key="bill.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td nowrap="nowrap">


        <form name="qform"  method="post" action="billList.html">   
        
        <span class="cLabel2"><fmt:message key="common.search"/><fmt:message key="customer.name"/>/<fmt:message key="common.id"/>:</span>          
        
        <input type="input" class="cInputTextFieldTiny"
         oninput="queryKeyWord(this.value, 'allCustomer', 'findCustomer.html', 'keyword');"
         onPropertyChange="queryKeyWord(this.value, 'allCustomer', 'findCustomer.html', 'keyword');"
        /> 
                   
                <ww:select name="customerId" id="allCustomer"
                headerKey=""
                headerValue="%{getText('common.pleaseSelect')+getText('customer.name')}..."
                list="customerList"
                listKey="id"
                listValue="id+'-'+name"
                cssClass="cQueryFieldList"                              
                />
        
         <span class="cLabel2"><fmt:message key="common.search"/><fmt:message key="bill.id"/>:</span>         
          <ww:textfield name="billNo" value="%{billNo}"  cssClass="cInputTextFieldShort" />
         
         <br>
         
          <span class="cLabel2"><fmt:message key="bill.finish"/>:</span>
          <ww:radio name="state" 
              list="yesNoList"
              listKey="id"
              listValue="value"
              cssStyle="border:0px;"              
          />           
          &nbsp;&nbsp;  
          <script type="text/javascript" src="/northwest/webwork/jscalendar/calendar.js"></script>
          <script type="text/javascript" src="/northwest/webwork/jscalendar/lang/calendar-zh.js"></script>
          <script type="text/javascript" src="/northwest/webwork/jscalendar/calendar-setup.js"></script>
          <input type="text" name="startDate" id="startDate" class="cInputTextFieldTiny" maxlength="8" value="${startDate}"/>
          <a href="#" id="startDate_button"><img src="/northwest/webwork/jscalendar/img.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date"></a>
              <script type="text/javascript">
               Calendar.setup({
               inputField     :    "startDate",
               ifFormat       :    "%Y%m%d",
               button         :    "startDate_button",
               step           :    1
              });
              </script>

              ~
          <input type="text" name="endDate" id="endDate" class="cInputTextFieldTiny" maxlength="8" value="${endDate}"/>
          <a href="#" id="endDate_button"><img src="/northwest/webwork/jscalendar/img.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date"></a>
          <script type="text/javascript">
               Calendar.setup({
               inputField     :    "endDate",
               ifFormat       :    "%Y%m%d",
               button         :    "endDate_button",
               step           :    1
              });
          </script>
          
                  
          <input type="submit" value="<fmt:message key="common.search"/>" class="cButton">
          
           &nbsp;&nbsp;&nbsp;&nbsp;
           
          <input type="button" value="<fmt:message key="report1"/>" class="cButton" onclick="javascript:exportExcel()"/>
          
           &nbsp;&nbsp;&nbsp;&nbsp;
           
          <input type="button" value="<fmt:message key="report2"/>" class="cButton" onclick="javascript:exportExcel2()"/>
           
        </form> 




        </td>
      </tr>
      <tr>
        <td>  
<c:set var="count" value="1" />
<ww:set name="bills" value="%{getBillList()}"/>
<display:table name="bills" class="list" cellspacing="1" requestURI="billList.html" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list" partialList="true" size="${RESULT_SIZE}">
   <display:column titleKey="common.id" style="width:5px">
      ${count}
    </display:column> 
    
    
    <display:column title="photo">  
      <a href="http://192.168.1.222/?rpt=2&id=${row.id}" target="_blank">
         <img src="images/menu_photo.gif" border=0>
      </a>
    </display:column>
    
    <display:column title="photo">  
      <a href="http://192.168.1.222/?rpt=3&id=${row.id}" target="_blank">
         <img src="images/form1.jpg" border=0>
      </a>
    </display:column>
    
    <display:column title="photo">  
      <a href="http://192.168.1.222/?rpt=4&id=${row.id}" target="_blank">
         <img src="images/form2.jpg" border=0>
      </a>
    </display:column>
    
    <display:column title="Barcode">
    <%--
    http://203.71.172.251:8888/?rpt=0&id=${row.id}
    http://192.168.1.222/?rpt=0&id=${row.id}
    --%>
      <a href="http://192.168.1.222/?rpt=0&id=${row.id}" target="_blank">
         <img src="images/barcode.jpg" border=0>
      </a>
    </display:column>
      
    <display:column titleKey="bill.id" sortable="true" style="width:5px">
      <a href="editBill.html?bill.id=${row.id}" target="_blank">${row.id}</a>
    </display:column>      
    <display:column property="customer.name"  sortable="true" titleKey="customer.name" style="width:15%" />
    <display:column property="customer.id"  sortable="true" titleKey="customer.id" style="width:5px" />
    <display:column property="projectName"  sortable="true" titleKey="bill.projectName" style="width:50%" />
    <display:column property="userDef2" sortable="true" titleKey="bill.completeDate" style="width:5%" />
    <display:column titleKey="bill.flow" style="width:3px">    
      <span  onClick="Switch1(p${row.id},'p${row.id}','${row.id}')"><img src="images/GridView.gif" border="0"></span>  
      <div id="p${row.id}" style="display:none;"></div>       
    </display:column> 
    
    <display:column property="remark" sortable="true" titleKey="bill.remark" style="width:10%" />
    
    
    <display:column titleKey="bill.finish" >
     <ww:set name="finish" value="%{isBillFinish('${row.id}')}"/> 
       <ww:if test="${finish} == true">
          <img src="images/yes.gif" border="0">
       </ww:if>
       <ww:else>
          <img src="images/no.gif" border="0">
       </ww:else>       
   </display:column>

    <c:set var="count" value="${count+1}" />
</display:table>
        </td>
    </tr>
      <tr class="cActionButtonLine">
        <td>

        </td>
      </tr>
</table>
<span class="cLabel">
<fmt:message key="bill.memo1"/>
</span>

<form name="form1" action="saveBill.html">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="bill.id" value="">
    <select name="selectedBillIds" multiple="true" style="display:none"></select>
</form>

<script>
 function showTable(id){
    document.getElementById(id).style.display = 'inline';
  }
 
 function hiddenTable(id){ 
   	document.getElementById(id).style.display = 'none';
 }
 
 function _display_obj(obj, status){
        if(obj.style.display!=status)
                obj.style.display=status;
}

 function Switch1(obj,id,j){
    _display_obj(obj, obj.style.display=="none"?"":"none");
		showBillFlow(id,j);
}

  function showBillFlow(id,j){
    getMessage(id,'billFlow.html?bill.id='+j);
  }
  
function exportExcel()
 { 	  
 	  window.open('exportReport1.html?billNo='+qform.billNo.value); 
 }
 
 function exportExcel2()
 { 	  
 	  window.open('exportReport2.html?billNo='+qform.billNo.value); 
 }
 
</script>





