<%@ include file="/common/taglibs.jsp"%>
20110831056
<table border="0" cellspacing="1" class="cContentTable">
      <tr>
        <td class="cContentTitle" ><fmt:message key="bill.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td>


        <form name="qform"  method="post" action="billList.html">
        
         <span class="cLabel2"><fmt:message key="common.search"/><fmt:message key="common.condition"/>:</span> 
          <ww:radio name="condition" 
               list="conditionList"
               listKey="id"
               listValue="value"
               cssStyle="border:0px;"              
            />
        
        
        
        <span class="cLabel2"><fmt:message key="common.search"/><fmt:message key="customer.name"/>:</span>          
               <ww:select name="customerId"  
                headerKey=""
                headerValue="%{getText('common.pleaseSelect')+getText('customer.name')}..."
                list="customerList"
                listKey="id"
                listValue="name"
                cssClass="cQueryFieldList"
                />
                
         &nbsp;&nbsp;&nbsp;&nbsp;  
               
         <span class="cLabel2"><fmt:message key="common.search"/><fmt:message key="bill.id"/>:</span>         
          <ww:textfield name="billNo" value="%{billNo}"  cssClass="cInputTextFieldShort" />
          
         &nbsp;&nbsp;&nbsp;&nbsp;          
          <input type="submit" value="<fmt:message key="common.search"/>" class="cButton">
        </form> 




        </td>
      </tr>
      <tr>
        <td>  
<c:set var="count" value="1" />
<ww:set name="bills" value="%{getBillList()}"/>
<display:table name="bills" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list" partialList="true" size="${RESULT_SIZE}">

    <display:column titleKey="common.id">
      ${count}
    </display:column>

    <display:column titleKey="bill.id" sortable="true">
      <a href="editBill.html?bill.id=${row.id}">${row.id}</a>
    </display:column>      
    <display:column property="customer.name" sortable="true" titleKey="customer.name" style="text-align:left" />
    <display:column property="customer.id" sortable="true" titleKey="customer.id" style="text-align:left" />
    <display:column property="projectName" sortable="true" titleKey="bill.projectName" style="text-align:left" />
    
    <display:column titleKey="bill.flow">    
      <span  onClick="Switch1(p${row.id},'p${row.id}','${row.id}')"><img src="images/GridView.gif" border="0"></span>  
      <div id="p${row.id}" style="display:none;"></div>       
    </display:column>  
    
    <display:column property="remark" sortable="true" titleKey="bill.remark" style="text-align:left" />
    
    
    <display:column titleKey="bill.finish">
     <ww:set name="finish" value="%{isBillFinish('${row.id}')}"/> 
       <ww:if test="${finish} == true">
          <img src="images/yes.gif" border="0">
       </ww:if>
       <ww:else>
          <img src="images/no.gif" border="0">
       </ww:else>       
   </display:column>
    
    <%--
    <display:column titleKey="report.complete">
      <a href="reportComplete.html?bill.id=${row.id}" target="_blank">
      <img src="images/report.jpg" border=0>
      </a>
    </display:column>
    --%>

    


    <c:set var="count" value="${count+1}" />
</display:table>
        </td>
    </tr>
      <tr class="cActionButtonLine">
        <td>

        </td>
      </tr>
</table>

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
</script>



