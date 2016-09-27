<%@ include file="/common/taglibs.jsp"%>

<ww:form name="billForm" action="saveBill" method="POST" onsubmit="onSubmit()">
  <ww:hidden name="bill.id" value="${bill.id}"/>
  
  <%--群組權限--%>
  <ww:set name="ck1" value="%{isStepEnabled('${bill.id}','6')}"/> 
  <ww:set name="ck2" value="%{isStepEnabled('${bill.id}','7')}"/> 
  <ww:set name="ck3" value="%{isStepEnabled('${bill.id}','8')}"/> 
  <ww:set name="ck4" value="%{isStepEnabled('${bill.id}','9')}"/> 
  <ww:set name="ck5" value="%{isStepEnabled('${bill.id}','10')}"/> 
  <ww:set name="ck6" value="%{isStepEnabled('${bill.id}','11')}"/> 
  <ww:set name="ck7" value="%{isStepEnabled('${bill.id}','12')}"/> 
  <ww:set name="ck8" value="%{isStepEnabled('${bill.id}','13')}"/> 
  <ww:set name="ck9" value="%{isStepEnabled('${bill.id}','14')}"/> 
  <ww:set name="ck10" value="%{isStepEnabled('${bill.id}','15')}"/> 
  <ww:set name="ck11" value="%{isStepEnabled('${bill.id}','17')}"/> 
  <%--群組編輯進度權限--%>
  <ww:set name="Permissions1" value="%{isSettingPermissions('6')}"/> 
  <ww:set name="Permissions2" value="%{isSettingPermissions('7')}"/> 
  <ww:set name="Permissions3" value="%{isSettingPermissions('8')}"/> 
  <ww:set name="Permissions4" value="%{isSettingPermissions('9')}"/> 
  <ww:set name="Permissions5" value="%{isSettingPermissions('10')}"/> 
  <ww:set name="Permissions6" value="%{isSettingPermissions('11')}"/> 
  <ww:set name="Permissions7" value="%{isSettingPermissions('12')}"/> 
  <ww:set name="Permissions8" value="%{isSettingPermissions('13')}"/> 
  <ww:set name="Permissions9" value="%{isSettingPermissions('14')}"/> 
  <ww:set name="Permissions10" value="%{isSettingPermissions('15')}"/> 
  <ww:set name="Permissions11" value="%{isSettingPermissions('17')}"/>
  <ww:set name="StepFlowAdmin" value="%{isSettingPermissions('18')}"/>
  <%--全選權限--%>
  <ww:set name="selectPower1" value="%{isDisabled( ${Permissions1} )}"/> 
  <ww:set name="selectPower2" value="%{isDisabled( ${Permissions2} )}"/>
  <ww:set name="selectPower3" value="%{isDisabled( ${Permissions3} )}"/>
  <ww:set name="selectPower4" value="%{isDisabled( ${Permissions4} )}"/>
  <ww:set name="selectPower5" value="%{isDisabled( ${Permissions5} )}"/>
  <ww:set name="selectPower6" value="%{isDisabled( ${Permissions6} )}"/>
  <ww:set name="selectPower7" value="%{isDisabled( ${Permissions7} )}"/>
  <ww:set name="selectPower8" value="%{isDisabled( ${Permissions8} )}"/>
  <ww:set name="selectPower9" value="%{isDisabled( ${Permissions9} )}"/>
  <ww:set name="selectPower10" value="%{isDisabled( ${Permissions10} )}"/>
  <ww:set name="selectPower11" value="%{isDisabled( ${Permissions11} )}"/>
  <ww:set name="stepFlowEnable" value="%{isDisabled( ${StepFlowAdmin} )}"/>
  
     
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="bill.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
        </ww:else>
      </td>
    </tr>
    
    <tr><td class="cInputCaption"><fmt:message key="bill.id"/></td>
        <td class="cInputColumn">
          ${bill.id}
        </td>
    </tr>   

    
    <tr><td class="cInputCaption"><fmt:message key="customer.id"/></td>
        <td class="cInputColumn">
            ${bill.customer.id}
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="customer.name"/></td>
        <td class="cInputColumn">
            ${bill.customer.name}
        </td>
    </tr>
    
    <tr><td class="cInputCaption"><fmt:message key="bill.projectName"/></td>
        <td class="cInputColumn">
          ${bill.projectName}
        </td>
    </tr>
    
    <tr><td class="cInputCaption"><fmt:message key="bill.remark"/></td>
        <td class="cInputColumn">
          ${bill.remark}
        </td>
    </tr>
    

    
       <tr><td class="cInputCaption"><fmt:message key="bill.Authority"/></td>
        <td class="cInputColumn">
            <table>
            <tr>
                <th align="center"><span style="font-size:10pt"><fmt:message key="common.available"/><fmt:message key="bill.flow"/></style></th>
                <th>&nbsp;</th>
                <th align="center"><span style="font-size:10pt"><fmt:message key="common.selected"/><fmt:message key="bill.flow"/></style></th>
            </tr><tr>
            <td >
              
                <ww:select id="allBillGroupAuthority"
                list="billGroupAuthorityList"
                listKey="id"
                listValue="caption_"
                multiple="true"
                size="8"
                cssClass="cQueryFieldList"
                />
                
                </td><td>
                <input type="button"  ${stepFlowEnable}  value=">>" class="cSelectButton" onclick="moveAll(allBillGroupAuthority, selectedBillGroupAuthority);"  <c:out value="${modifyEditable}" />><br>
                <input type="button"  ${stepFlowEnable}  value=">"  class="cSelectButton" onclick="moveOne(allBillGroupAuthority, selectedBillGroupAuthority);"  <c:out value="${modifyEditable}" />><br>
                <input type="button"  ${stepFlowEnable}  value="<"  class="cSelectButton" onclick="moveOne(selectedBillGroupAuthority, allBillGroupAuthority);"  <c:out value="${modifyEditable}" />><br>
                <input type="button"  ${stepFlowEnable}  value="<<" class="cSelectButton" onclick="moveAll(selectedBillGroupAuthority, allBillGroupAuthority);"  <c:out value="${modifyEditable}" />><br>
            </td>
            
            <td align="center">
               
                <ww:select name="billGroupAuthorityIds" id="selectedBillGroupAuthority" 
                list="object_BillGroupAuthorityList"
                listKey="id"
                listValue="caption_"
                multiple="true"
                size="8"
                cssClass="cQueryFieldList"                
                />    
                 
            </td>
            </tr>
            
            
            </table>
        </td>
    </tr>

    
    
   <tr>
      

<ww:set name="billdetail" value="%{getBillDetailListByBillNo('${bill.id}')}"/> 
<c:set var="count" value="1" />
<display:table name="billdetail" class="list"  id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <ww:set name="schedule" value="%{getBillScheduleById('${row.id}')}"/>
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column titleKey="common.id" >
        ${count}
    </display:column>
    <display:column property="fromRow" sortable="true" titleKey="billdetail.fromRow" />   
    <display:column property="product.productClass.className" sortable="true" titleKey="productClass.className" />
    <display:column property="product.productName" sortable="true" titleKey="billdetail.productName" />
    <display:column property="price" sortable="true" titleKey="billdetail.price" />
    <display:column property="product.unit" sortable="true" titleKey="product.unit" />
    <display:column property="width" sortable="true" titleKey="billdetail.width" />
    <display:column property="heigh" sortable="true" titleKey="billdetail.heigh" />
    <display:column property="calcArea" sortable="true" titleKey="billdetail.calcArea" />
    <display:column property="visibleWidth" sortable="true" titleKey="billdetail.visiblewidth" />    
    <display:column property="visibleHeigh" sortable="true" titleKey="billdetail.visibleheight" />    
    <display:column property="area" sortable="true" titleKey="billdetail.area" style="text-align:left" />
    <display:column titleKey="billschedule.fileName" sortable="true">
       ${schedule.fileName}
    </display:column>
    <display:column property="quantity" sortable="true" titleKey="billDetail.quantity" style="text-align:left" />
    <display:column property="detail" sortable="true" titleKey="billDetail.detail" style="text-align:left" />
    <display:column property="itemRemark" sortable="true" titleKey="billDetail.itemRemark" style="text-align:left" />
    <display:column property="paperPrice" sortable="true" titleKey="billDetail.paperPrice" style="text-align:left" />
    <display:column property="amount" sortable="true" titleKey="billDetail.amount" style="text-align:left" />
    
    
    <%--設定步驟1(完成時間)--%>
    <ww:if test="${ck1} == true">            
    <ww:set name="step1column" value="%{getText('billSchedule.step1')}"/>  
    <display:column title="${step1column} <input type='checkbox' name='selectall1' onClick='javascript:selectAll(1);' ${selectPower1} />" class="results" sortable="true">
        <ww:set name="stepEditable" value="%{getRecordEditable('${schedule.billDetail.id}','6',${Permissions1})}"/>
        <ww:checkbox name="step1Ids_${count}" id="step1Ids_${count}"  cssClass="cCheckboxField" value="${schedule.step1}"  fieldValue="${schedule.billDetail.id}-1"  disabled="${stepEditable}" />              
    </display:column>    
    <display:column titleKey="billSchedule.completionTime" sortable="true">       
        ${schedule.completionTime}
        ${schedule.checker1} 
    </display:column>
    
    </ww:if>
    <%--設定步驟1(完成時間)--%>
    
    
    <%--設定步驟2(審核)--%>
    <ww:if test="${ck2} == true">   
    <ww:set name="step2column" value="%{getText('billSchedule.step2')}"/>  
    <display:column title="${step2column} <input type='checkbox' name='selectall2' onClick='javascript:selectAll(2);' ${selectPower2} />" class="results" sortable="true">
        <ww:set name="stepEditable" value="%{getRecordEditable('${schedule.billDetail.id}','7',${Permissions2})}"/>
        <ww:checkbox name="step2Ids_${count}" id="step2Ids_${count}"  cssClass="cCheckboxField" value="${schedule.step2}" fieldValue="${schedule.billDetail.id}-2"  disabled="${stepEditable}"/>              
    </display:column>    
    <display:column titleKey="billSchedule.check1" sortable="true">         
        ${schedule.check1}
        ${schedule.checker2}      
    </display:column>
    </ww:if>
    <%--設定步驟2(審核)--%>
    
    
    <%--設定步驟3(確稿--%>
    <ww:if test="${ck3} == true">
    <ww:set name="step3column" value="%{getText('billSchedule.step3')}"/>  
    <display:column title="${step3column} <input type='checkbox' name='selectall3' onClick='javascript:selectAll(3);' ${selectPower3} />" class="results" sortable="true">
       <ww:set name="stepEditable" value="%{getRecordEditable('${schedule.billDetail.id}','8',${Permissions3})}"/>
       <ww:checkbox name="step3Ids_${count}" id="step3Ids_${count}"  cssClass="cCheckboxField" value="${schedule.step3}" fieldValue="${schedule.billDetail.id}-3"  disabled="${stepEditable}"/>              
    </display:column>
    
    <display:column titleKey="billSchedule.check2" sortable="true">       
        ${schedule.check2}
        ${schedule.checker3}    
    </display:column>
    </ww:if>
    <%--設定步驟3(確稿--%>
    
    
    <%--設定步驟4(設計)--%>
    <ww:if test="${ck4} == true">
    <ww:set name="step4column" value="%{getText('billSchedule.step4')}"/>  
    <display:column title="${step4column} <input type='checkbox' name='selectall4' onClick='javascript:selectAll(4);' ${selectPower4} />" class="results" sortable="true">
       <ww:set name="stepEditable" value="%{getRecordEditable('${schedule.billDetail.id}','9',${Permissions4})}"/>
       <ww:checkbox name="step4Ids_${count}" id="step4Ids_${count}"  cssClass="cCheckboxField" value="${schedule.step4}" fieldValue="${schedule.billDetail.id}-4"  disabled="${stepEditable}"/>              
    </display:column>    
    <display:column titleKey="billSchedule.check3" sortable="true">         
        ${schedule.check3}
        ${schedule.checker4}  
    </display:column>
    </ww:if>
    <%--設定步驟4(設計)--%>
    
    
    <%--設定步驟5(對稿、對稿圖檔上傳、示意圖上傳)--%>
    <ww:if test="${ck5} == true">
     <ww:set name="step5column" value="%{getText('billSchedule.step5')}"/>  
     <display:column title="${step5column} <input type='checkbox' name='selectall5' onClick='javascript:selectAll(5);' ${selectPower5} />" class="results" sortable="true">
          <ww:set name="stepEditable" value="%{getRecordEditable('${schedule.billDetail.id}','10',${Permissions5})}"/>
          <ww:checkbox name="step5Ids_${count}" id="step5Ids_${count}"  cssClass="cCheckboxField" value="${schedule.step5}" fieldValue="${schedule.billDetail.id}-5"  disabled="${stepEditable}"/>              
        <ww:if test="${Permissions5} == true">
            <c:set var="isLinkEnable" value="false" />
        </ww:if>
        <ww:else>
           <c:set var="isLinkEnable" value="true" />
        </ww:else>        
        <a href="javascript:openChild('uploadStep5.html?bill.id=${bill.id}')" onclick="return ${isLinkEnable}"><img src="images/upload.gif" border=0></a>     
    </display:column>    
    <display:column titleKey="billSchedule.check4" sortable="true">    
        ${schedule.check4}
        ${schedule.checker5}            
    </display:column>    
    <display:column titleKey="billSchedule.check4photo1" sortable="true">   
        <ww:if test="${schedule.check4photo1.id} != null">           
            <a href="${ctx}/upload/billSchedule/${bill.id}_5/${schedule.check4photo1.fileName}" target="_blank"  ><img src="images/photo.gif" border=0></a>
        </ww:if>
    </display:column>
    <display:column titleKey="billSchedule.check4photo2" sortable="true">       
        <ww:if test="${schedule.check4photo2.id} != null">
           <a href="${ctx}/upload/billSchedule/${bill.id}_5/${schedule.check4photo2.fileName}" target="_blank"><img src="images/photo.gif" border=0></a>
        </ww:if>
    </display:column>
    </ww:if>
    <%--設定步驟5(對稿、對稿圖檔上傳、示意圖上傳)--%>
    
    
    <%--設定步驟6(輸出、輸出設備)--%>
    <ww:if test="${ck6} == true">
     <ww:set name="step6column" value="%{getText('billSchedule.step6')}"/>  
     <display:column title="${step6column} <input type='checkbox' name='selectall6' onClick='javascript:selectAll(6);' ${selectPower6} />" class="results" sortable="true">
        <ww:set name="stepEditable" value="%{getRecordEditable('${schedule.billDetail.id}','11',${Permissions6})}"/>
        <ww:checkbox name="step6Ids_${count}" id="step6Ids_${count}"  cssClass="cCheckboxField" value="${schedule.step6}" fieldValue="${schedule.billDetail.id}-6"  disabled="${stepEditable}"/>              
        <ww:if test="${Permissions6} == true">
            <c:set var="isLinkEnable" value="false" />
        </ww:if>
        <ww:else>
           <c:set var="isLinkEnable" value="true" />
        </ww:else>        
        <a href="javascript:openChild('uploadStep6.html?bill.id=${bill.id}')"  onclick="return ${isLinkEnable}"><img src="images/edit.gif" border=0></a>     
    </display:column>    
    <display:column titleKey="billSchedule.check5" sortable="true">
         ${schedule.check5}
         ${schedule.checker6}       
    </display:column>
    <display:column titleKey="billSchedule.outputDevice" sortable="true">
        <ww:if test="${schedule.outputDevice} != ''">
         ${schedule.outputDevice}
         <br>
         </ww:if>
    </display:column>
    </ww:if>
    <%--設定步驟6(輸出、輸出設備)--%>
    
    
    <%--設定步驟7(影製交件時間)--%>
    <ww:if test="${ck7} == true">
    <ww:set name="step7column" value="%{getText('billSchedule.step7')}"/>  
    <display:column title="${step7column} <input type='checkbox' name='selectall7' onClick='javascript:selectAll(7);' ${selectPower7} />" class="results" sortable="true">
       <ww:set name="stepEditable" value="%{getRecordEditable('${schedule.billDetail.id}','12',${Permissions7})}"/>
       <ww:checkbox name="step7Ids_${count}" id="step7Ids_${count}"  cssClass="cCheckboxField" value="${schedule.step7}" fieldValue="${schedule.billDetail.id}-7"  disabled="${stepEditable}"/>              
    </display:column>     
    <display:column titleKey="billSchedule.outputTime" sortable="true">
       ${schedule.outputTime}
       ${schedule.checker7}
    </display:column>
    </ww:if> 
   <%--設定步驟7(影製交件時間)--%>
    
    
    
    <%--設定步驟8(後製)--%>
    <ww:if test="${ck8} == true">
    <ww:set name="step8column" value="%{getText('billSchedule.step8')}"/>  
    <display:column title="${step8column} <input type='checkbox' name='selectall8' onClick='javascript:selectAll(8);' ${selectPower8} />" class="results" sortable="true">
       <ww:set name="stepEditable" value="%{getRecordEditable('${schedule.billDetail.id}','13',${Permissions8})}"/>
       <ww:checkbox name="step8Ids_${count}" id="step8Ids_${count}"  cssClass="cCheckboxField" value="${schedule.step8}" fieldValue="${schedule.billDetail.id}-8"  disabled="${stepEditable}"/>              
    </display:column>   
    <display:column titleKey="billSchedule.check6" sortable="true">
       ${schedule.check6}
       ${schedule.checker8}
    </display:column>
     </ww:if>
    <%--設定步驟8(後製)--%>
    

    <%--設定步驟9(包裝)--%>
    <ww:if test="${ck9} == true">
    <ww:set name="step9column" value="%{getText('billSchedule.step9')}"/>  
    <display:column title="${step9column} <input type='checkbox' name='selectall9' onClick='javascript:selectAll(9);' ${selectPower9} />" class="results" sortable="true">
        <ww:set name="stepEditable" value="%{getRecordEditable('${schedule.billDetail.id}','14',${Permissions9})}"/>
        <ww:checkbox name="step9Ids_${count}" id="step9Ids_${count}"  cssClass="cCheckboxField" value="${schedule.step9}" fieldValue="${schedule.billDetail.id}-9"  disabled="${stepEditable}"/>              
    </display:column>    
    <display:column titleKey="billSchedule.check7" sortable="true">
       ${schedule.check7}
       ${schedule.checker9}
    </display:column>
    </ww:if>
    <%--設定步驟9(包裝)--%>
    
    
    <%--設定步驟10(後製出件時間) --%>
    <ww:if test="${ck10} == true">
     <ww:set name="step10column" value="%{getText('billSchedule.step10')}"/>  
     <display:column title="${step10column} <input type='checkbox' name='selectall10' onClick='javascript:selectAll(10);' ${selectPower10} />" class="results" sortable="true">
        <ww:set name="stepEditable" value="%{getRecordEditable('${schedule.billDetail.id}','15',${Permissions10})}"/>
        <ww:checkbox name="step10Ids_${count}" id="step10Ids_${count}"  cssClass="cCheckboxField" value="${schedule.step10}" fieldValue="${schedule.billDetail.id}-10"  disabled="${stepEditable}"/>              
    </display:column>    
    <display:column titleKey="billSchedule.deliveryTime" sortable="true">
       ${schedule.deliveryTime}
       ${schedule.checker10}
    </display:column>
    </ww:if>
    <%--設定步驟10(後製出件時間) --%>
    

    <%--設定步驟11(寄送人員) --%>
    <ww:if test="${ck11} == true">
     <ww:set name="step11column" value="%{getText('billSchedule.step11')}"/>  
     <display:column title="${step11column} <input type='checkbox' name='selectall11' onClick='javascript:selectAll(11);' ${selectPower11} />" class="results" sortable="true">
       <ww:set name="stepEditable" value="%{getRecordEditable('${schedule.billDetail.id}','17',${Permissions11})}"/>
       <ww:checkbox name="step11Ids_${count}" id="step11Ids_${count}"  cssClass="cCheckboxField" value="${schedule.step11}" fieldValue="${schedule.billDetail.id}-11"  disabled="${stepEditable}"/>              
        <ww:if test="${Permissions11} == true">
            <c:set var="isLinkEnable" value="false" />
        </ww:if>
        <ww:else>
           <c:set var="isLinkEnable" value="true" />
        </ww:else>      
      <a href="javascript:openChild('uploadStep11.html?bill.id=${bill.id}')" onclick="return ${isLinkEnable}"><img src="images/edit.gif" border=0></a>     
    </display:column>    
   <display:column titleKey="billSchedule.isSendInfo" sortable="true">
       ${schedule.isSendTime}
       ${schedule.checker11}
   </display:column>  
    
    <display:column titleKey="billSchedule.location" sortable="true">
       ${schedule.customerAddress.counterNo}       
       <a href="javascript:openChild('counter.html?customerDetail.id=${schedule.customerAddress.id}')" ><img src="images/members.gif" border=0></a>
    </display:column>
    <display:column titleKey="freight.name" sortable="true">
       ${schedule.freight.name}
    </display:column>
    <display:column titleKey="freight.no" sortable="true">
       ${schedule.freightNo}
    </display:column>
        
    <display:column titleKey="billSchedule.worker" sortable="true">
       ${schedule.worker}
    </display:column>
    <display:column titleKey="billSchedule.costs" sortable="true">
       ${schedule.costs}
    </display:column>
    <display:column property="bill.customer.saleman" sortable="true" titleKey="customer.saleman" style="text-align:left" />
    <display:column titleKey="customer.customerservice" sortable="true">
       ${schedule.customerAddress.customerService}     
    </display:column>   
    </ww:if>
    <%--設定步驟11(寄送人員) --%> 
        
    
    <c:set var="count" value="${count+1}" />
</display:table>

       
    </tr>
  </table>
  
  <select name="stepIds" id="stepIds" multiple="true"/>  
</ww:form>


<script>

 function onSubmit(){
 	 mySelectAll(document.billForm.billGroupAuthorityIds);
 	 getCheckStatus();
 }
 
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
document.billForm.stepIds.style.display='none';
</script>








<%--
<display:column property="myfield" media="none" />

--%>




