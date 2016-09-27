<%@ include file="/common/taglibs.jsp"%>
 
 
<table border="0" cellspacing="1" class="cContentTable">
    

    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="bill.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">

            <form  method="post"> 
            <fmt:message key="bill.flow"/>:
             <ww:select name="groupId" id="groupId"
                headerKey=""
                headerValue="%{getText('common.pleaseSelect')}..."
                list="billGroupAuthorityList"
                listKey="id"
                listValue="caption_"  
                cssClass="cQueryFieldList"
             />
             &nbsp;&nbsp;&nbsp;
            
             <fmt:message key="product.name"/>:
             <ww:textfield name="productName" value="%{productName}" cssClass="cInputTextField" readonly="true" onclick="query();"/>
             
             <ww:hidden name="productId" value="${productId}"/>
           
             &nbsp;&nbsp;&nbsp;
             <fmt:message key="billSchedule.ischeck"/>:
             <ww:radio name="condition" 
               list="yesNoList"
               listKey="id"
               listValue="value"
               cssStyle="border:0px;"              
            />
             <input type="submit" value="<fmt:message key="common.search"/>" class="cButton">
             </form>
      </td>
    </tr>
 <tr>
  <td>
<ww:form name="billForm" action="saveBill" method="POST" onsubmit="onSubmit()">
<ww:set name="billdetail" value="%{getBillScheduleListByCondition()}"/> 
<c:set var="count" value="1" />
<c:set var="i" value="0" />
<display:table name="billdetail" class="list"  id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">

  <%--群組權限--%>
  <ww:set name="ck1" value="true"/> 
  <ww:set name="ck2" value="true"/> 
  <ww:set name="ck3" value="true"/> 
  <ww:set name="ck4" value="true"/> 
  <ww:set name="ck5" value="true"/> 
  <ww:set name="ck6" value="true"/> 
  <ww:set name="ck7" value="true"/> 
  <ww:set name="ck8" value="true"/> 
  <ww:set name="ck9" value="true"/> 
  <ww:set name="ck10" value="true"/> 
  <ww:set name="ck11" value="true"/> 
  <ww:set name="ck12" value="true"/>

    <ww:set name="schedule" value="%{getBillScheduleById('${row.id}')}"/>
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column titleKey="common.id" >
        ${count}
    </display:column>
    
    <display:column titleKey="bill.id" >
       <a href="editBill.html?bill.id=${row.bill.id}" target="_blank">
         ${row.bill.id}
       </a>
    </display:column>
    <display:column property="product.productClass.className" sortable="false" titleKey="productClass.className" />
    <display:column titleKey="billdetail.productName">
       <a href="javascript:openChild('productCombine.html?productId=${row.product.id}')"  >
       ${row.product.productName}
       </a>
     <br><br><br>      
      <ww:if test="${i} >0 ">
      <c:set var="i" value="${i+1}" /> 
      </ww:if>       
     <a id="jttrigger-${i}" href="#"><img src="images/GridView.gif" border="0"></a>
			  <div id="jttip-${i}" class="jttip" style="display:none;">
				 <div class="jttipcontent" >
				   <fmt:message key='customer.saleman'/>:${row.bill.customer.saleman}<BR>
				   <fmt:message key='customer.customerservice'/>:${schedule.customerAddress.customerService} <BR>
			     <fmt:message key='billdetail.fromRow'/>:${row.fromRow}<BR>
					 <fmt:message key='billdetail.price'/>:${row.price}<BR>
					 <fmt:message key='product.unit'/>:${row.product.unit}<BR>
					 <fmt:message key='billdetail.width'/>:${row.width}<BR>
					 <fmt:message key='billdetail.heigh'/>:${row.heigh}<BR>
					 <fmt:message key='billdetail.visiblewidth'/>:${row.visibleWidth}<BR>
					 <fmt:message key='billdetail.visibleheight'/>:${row.visibleHeigh}<BR>
					 <fmt:message key='billdetail.area'/>:${row.area}<BR>
					 <fmt:message key='billDetail.quantity'/>:${row.quantity}<BR>
					 <fmt:message key='billDetail.detail'/>:${row.detail}<BR>
					 <fmt:message key='billDetail.itemRemark'/>:${row.itemRemark}<BR>
					 <fmt:message key='billDetail.paperPrice'/>:${row.paperPrice}<BR>
					 <fmt:message key='billDetail.amount'/>:${row.amount}<BR>            
					</div>
		  </div>            
    </display:column>
    
   <%--設定步驟1(完成時間)--%>
    <ww:if test="${ck1} == true">            
    <ww:set name="step1column" value="%{getText('billSchedule.step1')}"/>  
    <display:column title="${step1column} <input type='checkbox' name='selectall1' onClick='javascript:selectAll(1);' ${selectPower1} />" class="results" sortable="false">
        <ww:set name="stepEditable" value="%{getRecordEditable('${schedule.billDetail.id}','6',${Permissions1})}"/>  
        <ww:checkbox name="step1Ids_${count}" id="step1Ids_${count}"  cssClass="cCheckboxField" value="${schedule.step1}"  fieldValue="${schedule.billDetail.id}-1"  disabled="${stepEditable}"/> 
        <br><br>
        <a href="javascript:openChild('uploadStep1.html')"  ><img src="images/edit.gif" border=0></a>         
        <ww:if test="${schedule.step1} == true">
        <br><br>
        <c:set var="i" value="${i+1}" />     
        <a id="jttrigger-${i}" href="#"><img src="images/GridView.gif" border="0"></a>
			  <div id="jttip-${i}" class="jttip" style="display:none;">
				 <div class="jttipcontent" >
					 <fmt:message key='billSchedule.step1'/>:${fn:substring(schedule.check1,0,16)}<BR>
           <fmt:message key='member.name'/>:${schedule.checker1}<BR>
           <fmt:message key='billschedule.fileName'/>:${schedule.fileName}<BR>
           <fmt:message key='billSchedule.worker'/>:${schedule.worker}<BR>
           <fmt:message key='billSchedule.costs'/>:${schedule.costs}<BR> 
            <ww:if test="${schedule.customerScreen.id} != null">           
              <fmt:message key='customerScreen.counterScreen'/>:<a href='${ctx}/showCustomerScreen.html?customerScreen.id=${schedule.customerScreen.id}' target='_blank'><img src="images/photo.gif" border=0></a> <BR>
             </ww:if>             
					</div>
					</div>        
        </ww:if>               
        <ww:set name="pass" value="%{getPass('${schedule.billDetail.id}','6')}"/>             
          <div id="${schedule.billDetail.id}-1"><font color="blue">Pass</font><div>
            <script>               
                  <ww:if test="${pass} == true">
                     document.getElementById('${schedule.billDetail.id}-1').style.display = 'inline';
                  </ww:if>
                  <ww:else>
                     document.getElementById('${schedule.billDetail.id}-1').style.display = 'none';                  
                  </ww:else>                    
            </script>             
    </display:column> 
    </ww:if>
    <%--設定步驟1(完成時間)--%>

    
  
   
    
    <c:set var="count" value="${count+1}" />
</display:table>
</ww:form>

       </td>  
    </tr>
  </table>
  
  <select name="stepIds" id="stepIds" multiple="true"/>  



<script>


 
 function getCheckStatus(){ 	
 	<ww:set name="groupsList" value="%{getBillAuthorityListByBill('${bill.id}')}"/> 
  var colu = new Array(${fn:length(groupsList)-1})
  <c:set var="al" value="0" />
  <ww:iterator value="groupsList">
  <c:set var="key" value="${group.groupKey}" />
  <c:set var="item" value="${fn:substring(key,2,4)}"  />
  colu [${al}] = "<fmt:formatNumber value="${item}" pattern="#"/>"   
  <c:set var="al" value="${al+1}" />
  </ww:iterator> 	
 	
   	var c=${count};
   	billForm.stepIds.options.length =   0;  //清空stepIds
		for(j=1;j<c;j++){	
			 for(i=0;i<=colu.length-1;i++){   
   		    var s = eval('billForm.step'+colu[i]+'Ids_'+j) ;  
   		    //alert('billForm.step'+colu[i]+'Ids_'+j);   		    
   		      if(s.checked == true){
   		          //alert('billForm.step'+colu[i]+'Ids_'+j+'.value = '+s.value);
   		          //新增Select Option
   		           var newOpt = document.createElement("option");
                 newOpt.text =  s.value;
                 newOpt.value = s.value;
                 billForm.stepIds.options.add(newOpt);
   		          //新增Select Option
   		       }  		     
   	     }
		}
		mySelectAll(document.billForm.stepIds);		
}


function openChild(page){ 
	 lovechild = window.open(page, "uploadStep5","height=600, width=800,resizable=yes,menubar=0,toolbar=0,location=0,directories=0,scrollbars=yes,status=0")
	 }

	 
function selectAll(id){
	var c=${count};
  var result; 
  var tall = eval('billForm.selectall'+id) ;   
     if(tall.checked==true){
  	   result=true;
     }else{
  	   result=false;
     }	   
	for(j=1;j<c;j++){	
		var s = eval('billForm.step'+id+'Ids_'+j) ; 		
		if(s.disabled==false){
		   s.checked=result;
   	}
	}
}	
 

//document.billForm.stepIds.style.display='none';
/*


 <ww:if test="${StepFlowAdmin} == true">
     document.all.StepAuthority.style.display='none';	
 </ww:if>
 <ww:else>
     document.all.StepAuthority.style.display='inline';	
 </ww:else> 
 */
 
 function showTimestamp(time,name){
 	 if(time!=""){
 	   alert(time+'\n'+name);
 	}
}

function query(){
	 openChild("queryProduct.html");
}

</script>













