<%@ include file="/common/taglibs.jsp"%>
<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/displaytag.css" />
<script type="text/javascript" src="${ctx}/scripts/list.js"></script>
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<script type="text/javascript" src="${ctx}/scripts/datetimepicker_css.js"></script>


<ww:form name="Form1" action="saveCheck8" method="POST" >
  <ww:hidden name="bill.id" value="${bill.id}"/>
   <table border="0" cellspacing="1" class="cContentTable1">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="bill.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
          <input type="button" value="<fmt:message key="common.save"/>" class="cButton" onClick="ChkUpload();">&nbsp;
          <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
      </td>
    </tr>
    
    

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.productionTime"/></td>
        <td class="cInputColumn">
            <ww:textfield  name="productionTime" id="productionTime"  readonly="true" value="%{billSchedule.check8}"/>
            <img src="images/cal.gif" onclick="javascript:NewCssCal ('productionTime','yyyyMMdd','dropdown',true,'24')"  style="cursor:pointer"/>
        </td>
    </tr>
        
       <tr><td class="cInputCaption"><fmt:message key="common.completely"/><fmt:message key="bill.form"/></td>
        <td class="cInputColumn">
            <table>
            <tr>
                <th align="center"><span style="font-size:10pt"><fmt:message key="common.available"/><fmt:message key="bill.form"/></style></th>
                <th>&nbsp;</th>
                <th align="center"><span style="font-size:10pt"><fmt:message key="common.selected"/><fmt:message key="bill.form"/></style></th>
            </tr><tr>
                <td>           
                <ww:if test="bill.id != null">
                   <ww:select id="allBillDetail"
                   list="%{getBillDetailListByBillNo('${bill.id}','13')}"
                   listKey="id"
                   listValue="detail+'-'+product.productName+'-'+width+'X'+heigh+'('+visibleWidth+'X'+visibleHeigh+')-'+quantity+'-'+itemRemark"               
                   multiple="true"
                   size="8"
                   cssClass="cQueryFieldList3"
                />
                </ww:if>
                <ww:else>
                   <ww:select id="allBillDetail"
                   list="%{getBillDetailListByProducts('13')}"
                   listKey="id"
                   listValue="detail+'-'+product.productName+'-'+width+'X'+heigh+'('+visibleWidth+'X'+visibleHeigh+')-'+quantity+'-'+itemRemark"               
                   multiple="true"
                   size="8"
                   cssClass="cQueryFieldList3"
                  />
                </ww:else>           
                </td><td>
                <input type="button" value=">>" class="cSelectButton" onclick="moveAll(allBillDetail, selectedBillDetailIds);"  <c:out value="${modifyEditable}" />><br>
                <input type="button" value=">"  class="cSelectButton" onclick="moveOne(allBillDetail, selectedBillDetailIds);"  <c:out value="${modifyEditable}" />><br>
                <input type="button" value="<"  class="cSelectButton" onclick="moveOne(selectedBillDetailIds, allBillDetail);"  <c:out value="${modifyEditable}" />><br>
                <input type="button" value="<<" class="cSelectButton" onclick="moveAll(selectedBillDetailIds, allBillDetail);"  <c:out value="${modifyEditable}" />><br>
            </td>
            
            <td align="center">
                <select name="billDetailIds" id="selectedBillDetailIds" class="cQueryFieldList3" multiple="true" size="8">
                </select>               
            </td>
            </tr>           
            
            </table>
        </td>
    </tr>
    
        <tr class="cActionButtonLine">
      <td colspan="2">
          <input type="button" value="<fmt:message key="common.save"/>" class="cButton" onClick="ChkUpload();">&nbsp;
          <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
      </td>
    </tr>
    
</table>
  
  
</ww:form>


<hr>

<form name="Form2">

<ww:set name="column" value="%{getText('common.edit')}"/> 

<input type="button" value="<fmt:message key='billSchedule.selected'/>" onClick="javascript:gox();">

<ww:set name="billdetail" value="%{getSelectedBillDetailIds('${bill.id}','13')}"/> 
<c:set var="count" value="1" />
<c:set var="i" value="0" />
<display:table name="billdetail" class="list"  id="row" export="false" pagesize="${GLOBAL_pagesize}"  sort="list"  requestURI="uploadStep1.html"  >
    <ww:set name="schedule" value="%{getBillScheduleById('${row.id}')}"/>
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column  title="${column} <input type='checkbox' name='selectAlls' onClick='javascript:selectAll();'/>" >
         <ww:checkbox name="id${count}" id="id${count}"  cssClass="cCheckboxField"  fieldValue="${row.id}" />              
         <input type="hidden" name="idtext${count}" value="${row.detail}-${row.product.productName}-${row.width}X${row.heigh}(${row.visibleWidth}X${row.visibleHeigh})-${row.quantity}-${row.itemRemark}">
    </display:column>     
    
    <display:column titleKey="common.id" >
        ${count}
    </display:column>  
    <display:column property="detail" sortable="true" titleKey="billDetail.detail" />
    

    <display:column titleKey="billdetail.productName" sortable="true">
       <a href="javascript:openChild('productCombine.html?productId=${row.product.id}')"  >
       ${row.product.productName}
       </a>
    </display:column>
    
    <display:column titleKey="billDetail.itemRemark" sortable="true">
           ${row.itemRemark}      
    </display:column>
    
    <display:column titleKey="common.action" >
        ${row.product.id}
    </display:column> 
    
    <display:column titleKey="common.action" >
      <font color="#008000">
       ${row.width}X${row.heigh}(${row.visibleWidth}X${row.visibleHeigh})---${row.quantity}
      </font>
    </display:column>   
    
    <display:column titleKey="common.action" >

					 <fmt:message key='billSchedule.step8'/>:${fn:substring(schedule.check8,0,16)}/
           <fmt:message key='member.name'/>:${schedule.checker8}
      
    </display:column> 
    
    <c:set var="count" value="${count+1}" />
    
</display:table>
    

</form>


<script>

 //moveAll(document.Form1.allBillDetail, document.Form1.selectedBillDetailIds);
 
 
 function reflash(){
   window.opener.parent.location.reload();
   //window.close();
 }

 function onSubmit(){
 	 mySelectAll(document.Form1.billDetailIds); 	
 }
 
 <%
 String reload=request.getParameter("reload");
 //out.println("reload="+reload);
  if (reload != null && reload.equals("Y")) {
 %>
   reflash();

 <%
 }
 %>
 
 
 
 function ChkUpload()
{	
  if (document.Form1.productionTime.value == ""){
	  alert('<fmt:message key="billSchedule.productionTime"/><fmt:message key="common.required"/>');	       
	  return False;
	}		
	if (document.Form1.billDetailIds.options.length==0){		
		alert("<fmt:message key='billdetail'/><fmt:message key='common.required'/>");
		return False;	  	
	} 
  mySelectAll(document.Form1.billDetailIds); 	
  document.Form1.submit();
}


 <ww:set name="test" value="%{getBillDetailListByBillNo('${bill.id}','13')}"/>
 <ww:iterator value="test"> 
   <ww:set name="s" value="%{getBillScheduleById(id)}"/>
    <ww:if test="${s.step8} == true">     
       removeItem(document.Form1.selectedBillDetailIds,document.Form1.allBillDetail,'${s.id}');
    </ww:if>   
 </ww:iterator>
 
 
  function selectAll(){ 
	var c=${count};
  var result;   
  if(Form2.selectAlls.checked ==true){
  	result=true;
  }else{
  	 result=false;
  }
	for(j=1;j<c;j++){	
		var s = eval('Form2.id'+j) ; 		
		if(s!=null){
		s.checked=result;
	 }
	}	
}	

 function gox(){ 
  var c=${count};
  
  var billDetailIds = eval('Form1.billDetailIds') ;  
  
  for(j=1;j<c;j++){	
		var s = eval('Form2.id'+j) ; 	
		var idtext = eval('Form2.idtext'+j) ; 
		if(s!=null){	
		if(s.checked==true){				    
          var newOpt = document.createElement("option");
          newOpt.text =  idtext.value;
          newOpt.value = s.value;   
          billDetailIds.options.add(newOpt);  
		}
	 }	
	}
}
 
 
</script>

