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
  <ww:set name="ck12" value="%{isStepEnabled('${bill.id}','19')}"/>
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
  <ww:set name="Permissions12" value="%{isSettingPermissions('19')}"/>
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
  <ww:set name="selectPower12" value="%{isDisabled( ${Permissions12} )}"/>
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
    

    
       <tr id="StepAuthority"><td class="cInputCaption"><fmt:message key="bill.Authority"/></td>
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
<c:set var="i" value="0" />
<display:table name="billdetail" class="list"  id="row" export="false" pagesize="${GLOBAL_pagesize}" requestURI="editBill.html" sort="list">
    <ww:set name="schedule" value="%{getBillScheduleById('${row.id}')}"/>
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column titleKey="common.id" >
        ${count}
    </display:column>  
    <display:column property="product.productClass.className" sortable="false" titleKey="productClass.className" />
    <display:column titleKey="billdetail.productName">
       <a href="javascript:openChild('productCombine.html?productId=${row.product.id}')"  >
       ${row.product.productName}
       </a>
     <br><br><br>      
      <ww:if test="${i} >0 || ${count}>1">
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
        <a href="javascript:openChild('uploadStep1.html?bill.id=${bill.id}')"  ><img src="images/edit.gif" border=0></a>         
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
    
    
    <%--設定步驟2(審核)--%>
    <ww:if test="${ck2} == true">   
    <ww:set name="step2column" value="%{getText('billSchedule.step2')}"/>  
    <display:column title="${step2column} <input type='checkbox' name='selectall2' onClick='javascript:selectAll(2);' ${selectPower2} />" class="results" sortable="false">
        <ww:set name="stepEditable" value="%{getRecordEditable('${schedule.billDetail.id}','7',${Permissions2})}"/>
        <ww:checkbox name="step2Ids_${count}" id="step2Ids_${count}"  cssClass="cCheckboxField" value="${schedule.step2}" fieldValue="${schedule.billDetail.id}-2"  disabled="${stepEditable}" />              
        <br><br><br><br>
        <ww:if test="${schedule.step2} == true">  
        <c:set var="i" value="${i+1}" />
        <a id="jttrigger-${i}" href="#"><img src="images/GridView.gif" border="0"></a>
			  <div id="jttip-${i}" class="jttip" style="display:none;">
				 <div class="jttipcontent" >
					 <fmt:message key='billSchedule.step2'/>:${fn:substring(schedule.check2,0,16)}<BR>
           <fmt:message key='member.name'/>:${schedule.checker2}<BR>          
					</div>
					</div>
        </ww:if>            
            <ww:set name="pass" value="%{getPass('${schedule.billDetail.id}','7')}"/>             
            <div id="${schedule.billDetail.id}-2"><font color="blue">Pass</font><div>
            <script>               
                  <ww:if test="${pass} == true">
                     document.getElementById('${schedule.billDetail.id}-2').style.display = 'inline';
                  </ww:if>
                  <ww:else>
                     document.getElementById('${schedule.billDetail.id}-2').style.display = 'none';                  
                  </ww:else>                    
            </script>
    </display:column>  
    </ww:if>
    <%--設定步驟2(審核)--%>
    
    
    <%--設定步驟3(打樣)--%>
    <ww:if test="${ck3} == true">
    <ww:set name="step3column" value="%{getText('billSchedule.step3')}"/>  
    <display:column title="${step3column} <input type='checkbox' name='selectall3' onClick='javascript:selectAll(3);' ${selectPower3} />" class="results" sortable="false">
       <ww:set name="stepEditable" value="%{getRecordEditable('${schedule.billDetail.id}','8',${Permissions3})}"/>
       <ww:checkbox name="step3Ids_${count}" id="step3Ids_${count}"  cssClass="cCheckboxField" value="${schedule.step3}" fieldValue="${schedule.billDetail.id}-3"  disabled="${stepEditable}"/>              
       <br><br><br><br>
       <ww:if test="${schedule.step3} == true">
        <c:set var="i" value="${i+1}" /> 
        <a id="jttrigger-${i}" href="#"><img src="images/GridView.gif" border="0"></a>
			  <div id="jttip-${i}" class="jttip" style="display:none;">
				 <div class="jttipcontent" >
					 <fmt:message key='billSchedule.step3'/>:${fn:substring(schedule.check3,0,16)}<BR>
           <fmt:message key='member.name'/>:${schedule.checker3}<BR>          
					</div>
					</div>      
				</ww:if>
        
            <ww:set name="pass" value="%{getPass('${schedule.billDetail.id}','8')}"/>             
            <div id="${schedule.billDetail.id}-3"><font color="blue">Pass</font><div>
            <script>               
                  <ww:if test="${pass} == true">
                     document.getElementById('${schedule.billDetail.id}-3').style.display = 'inline';
                  </ww:if>
                  <ww:else>
                     document.getElementById('${schedule.billDetail.id}-3').style.display = 'none';                  
                  </ww:else>                    
            </script>    
    </display:column>
    </ww:if>
    <%--設定步驟3(打樣)--%>
    
    
    <%--設定步驟4(設計)--%>
    <ww:if test="${ck4} == true">
    <ww:set name="step4column" value="%{getText('billSchedule.step4')}"/>  
    <display:column title="${step4column} <input type='checkbox' name='selectall4' onClick='javascript:selectAll(4);' ${selectPower4} />" class="results" sortable="false">
       <ww:set name="stepEditable" value="%{getRecordEditable('${schedule.billDetail.id}','9',${Permissions4})}"/>
       <ww:checkbox name="step4Ids_${count}" id="step4Ids_${count}"  cssClass="cCheckboxField" value="${schedule.step4}" fieldValue="${schedule.billDetail.id}-4"  disabled="${stepEditable}"/>              
        <br><br><br><br>
        <ww:if test="${schedule.step4} == true">
        <c:set var="i" value="${i+1}" /> 
        <a id="jttrigger-${i}" href="#"><img src="images/GridView.gif" border="0"></a>
			  <div id="jttip-${i}" class="jttip" style="display:none;">
				 <div class="jttipcontent" >
					 <fmt:message key='billSchedule.step4'/>:${fn:substring(schedule.check4,0,16)}<BR>
           <fmt:message key='member.name'/>:${schedule.checker4}<BR>          
					</div>
					</div>        
				</ww:if>       
            <ww:set name="pass" value="%{getPass('${schedule.billDetail.id}','9')}"/>             
            <div id="${schedule.billDetail.id}-4"><font color="blue">Pass</font><div>
            <script>               
                  <ww:if test="${pass} == true">
                     document.getElementById('${schedule.billDetail.id}-4').style.display = 'inline';
                  </ww:if>
                  <ww:else>
                     document.getElementById('${schedule.billDetail.id}-4').style.display = 'none';                  
                  </ww:else>                    
            </script>   
    </display:column>    
    </ww:if>
    <%--設定步驟4(設計)--%>
    
    
    <%--設定步驟5(影製時間)--%>
    <ww:if test="${ck5} == true">
     <ww:set name="step5column" value="%{getText('billSchedule.step5')}"/>  
     <display:column title="${step5column} <input type='checkbox' name='selectall5' onClick='javascript:selectAll(5);' ${selectPower5} />" class="results" sortable="false">
          <ww:set name="stepEditable" value="%{getRecordEditable('${schedule.billDetail.id}','10',${Permissions5})}"/>
          <ww:checkbox name="step5Ids_${count}" id="step5Ids_${count}"  cssClass="cCheckboxField" value="${schedule.step5}" fieldValue="${schedule.billDetail.id}-5"  disabled="${stepEditable}"/>              
          <br><br>
          <ww:if test="${Permissions5} == true">
            <c:set var="isLinkEnable" value="false" />
          </ww:if>
          <ww:else>
           <c:set var="isLinkEnable" value="true" />
           </ww:else> 
                  
           <a href="javascript:openChild('uploadStep5.html?bill.id=${bill.id}')"  onclick="return ${isLinkEnable}"><img src="images/edit.gif" border=0></a>     
        <br><br>
        <ww:if test="${schedule.step5} == true">
          <c:set var="i" value="${i+1}" /> 
          <a id="jttrigger-${i}" href="#"><img src="images/GridView.gif" border="0"></a>
			    <div id="jttip-${i}" class="jttip" style="display:none;">
				   <div class="jttipcontent" >
					   <fmt:message key='billSchedule.step5'/>:${fn:substring(schedule.check5,0,16)}<BR>
             <fmt:message key='member.name'/>:${schedule.checker5}<BR>          
					 </div>
					</div>  
        </ww:if>  
    
            <ww:set name="pass" value="%{getPass('${schedule.billDetail.id}','10')}"/>             
            <div id="${schedule.billDetail.id}-5"><font color="blue">Pass</font><div>
            <script>               
                  <ww:if test="${pass} == true">
                     document.getElementById('${schedule.billDetail.id}-5').style.display = 'inline';
                  </ww:if>
                  <ww:else>
                     document.getElementById('${schedule.billDetail.id}-5').style.display = 'none';                  
                  </ww:else>                    
            </script> 
    </display:column>    

    </ww:if>
    <%--設定步驟5(影製時間)--%>
    
    
    <%--設定步驟6(對搞上傳)--%>
    <ww:if test="${ck6} == true">
     <ww:set name="step6column" value="%{getText('billSchedule.step6')}"/>  
     <display:column title="${step6column} <input type='checkbox' name='selectall6' onClick='javascript:selectAll(6);' ${selectPower6} />" class="results" sortable="false">
        <ww:set name="stepEditable" value="%{getRecordEditable('${schedule.billDetail.id}','11',${Permissions6})}"/>       
        <ww:checkbox name="step6Ids_${count}" id="step6Ids_${count}"  cssClass="cCheckboxField" value="${schedule.step6}" fieldValue="${schedule.billDetail.id}-6"  disabled="${stepEditable}"/>              
        
        <br><br>
        <ww:if test="${Permissions6} == true">
            <c:set var="isLinkEnable" value="false" />
        </ww:if>
        <ww:else>
           <c:set var="isLinkEnable" value="true" />
        </ww:else>        
        <a href="javascript:openChild('uploadStep6.html?bill.id=${bill.id}')"  onclick="return ${isLinkEnable}"><img src="images/edit.gif" border=0></a>     
       <br><br>
        <ww:if test="${schedule.step6} == true"> 
         <c:set var="i" value="${i+1}" />         
         <a id="jttrigger-${i}" href="#"><img src="images/GridView.gif" border="0"></a>
			   <div id="jttip-${i}" class="jttip" style="display:none;">
				  <div class="jttipcontent" >
					 <fmt:message key='billSchedule.step6'/>:${fn:substring(schedule.check6,0,16)}<BR>
           <fmt:message key='member.name'/>:${schedule.checker6}<BR>
            <ww:if test="${schedule.checkDiagram.id} != null">           
              <fmt:message key='billSchedule.checkDiagram'/>:<a href="${ctx}/<fmt:message key='billSchedule.uploadCheckDiagram.relativeUrl'/>/${bill.id}_CheckDiagram/${schedule.checkDiagram.fileName}" target="_blank">
                <img src="images/photo.gif" border=0>
              </a><br>
             </ww:if>      
             <ww:if test="${schedule.imageDiagram.id} != null">           
              <fmt:message key='billSchedule.imageDiagram'/>:<a href="${ctx}/<fmt:message key='billSchedule.uploadImageDiagram.relativeUrl'/>/${bill.id}_ImageDiagram/${schedule.imageDiagram.fileName}" target="_blank">
                <img src="images/photo.gif" border=0>
              </a><br>
             </ww:if>          
					</div>
        </ww:if>
        
            <ww:set name="pass" value="%{getPass('${schedule.billDetail.id}','11')}"/>             
            <div id="${schedule.billDetail.id}-6"><font color="blue">Pass</font><div>
            <script>               
                  <ww:if test="${pass} == true">
                     document.getElementById('${schedule.billDetail.id}-6').style.display = 'inline';
                  </ww:if>
                  <ww:else>
                     document.getElementById('${schedule.billDetail.id}-6').style.display = 'none';                  
                  </ww:else>                    
            </script>    
    </display:column>    


    </ww:if>
    <%--設定步驟6(對搞上傳)--%>
    
    
    <%--設定步驟7(輸出)--%>
    <ww:if test="${ck7} == true">
    <ww:set name="step7column" value="%{getText('billSchedule.step7')}"/>  
    <display:column title="${step7column} <input type='checkbox' name='selectall7' onClick='javascript:selectAll(7);' ${selectPower7} />" class="results" sortable="false">
       <ww:set name="stepEditable" value="%{getRecordEditable('${schedule.billDetail.id}','12',${Permissions7})}"/>
       <ww:checkbox name="step7Ids_${count}" id="step7Ids_${count}"  cssClass="cCheckboxField" value="${schedule.step7}" fieldValue="${schedule.billDetail.id}-7"  disabled="${stepEditable}"/>   
       <br><br>
       <ww:if test="${Permissions7} == true">
            <c:set var="isLinkEnable" value="false" />
        </ww:if>
        <ww:else>
          <c:set var="isLinkEnable" value="true" />
        </ww:else>
       <a href="javascript:openChild('uploadStep7.html?bill.id=${bill.id}')"  onclick="return ${isLinkEnable}"><img src="images/edit.gif" border=0></a>         
    
       <br><br>
       <ww:if test="${schedule.step7} == true">         
         <c:set var="i" value="${i+1}" />         
         <a id="jttrigger-${i}" href="#"><img src="images/GridView.gif" border="0"></a>
			   <div id="jttip-${i}" class="jttip" style="display:none;">
				  <div class="jttipcontent" >
					 <fmt:message key='billSchedule.step7'/>:${fn:substring(schedule.check7,0,16)}<BR>
           <fmt:message key='member.name'/>:${schedule.checker7}<BR>
           <fmt:message key='outputEquipment.name'/>:${schedule.outputEquipment.name}<BR>
           <fmt:message key='billSchedule.outputDevice'/>:${schedule.outputDevice}<BR>
           </div>
        </ww:if>
       
            <ww:set name="pass" value="%{getPass('${schedule.billDetail.id}','12')}"/>             
            <div id="${schedule.billDetail.id}-7"><font color="blue">Pass</font><div>
            <script>               
                  <ww:if test="${pass} == true">
                     document.getElementById('${schedule.billDetail.id}-7').style.display = 'inline';
                  </ww:if>
                  <ww:else>
                     document.getElementById('${schedule.billDetail.id}-7').style.display = 'none';                  
                  </ww:else>                    
            </script>  
    </display:column>     

    </ww:if> 
   <%--設定步驟7(輸出)--%>
    
    
    
    <%--設定步驟8(後製時間)--%>
    <ww:if test="${ck8} == true">
    <ww:set name="step8column" value="%{getText('billSchedule.step8')}"/>  
    <display:column title="${step8column} <input type='checkbox' name='selectall8' onClick='javascript:selectAll(8);' ${selectPower8} />" class="results" sortable="false">
       <ww:set name="stepEditable" value="%{getRecordEditable('${schedule.billDetail.id}','13',${Permissions8})}"/>
       <ww:checkbox name="step8Ids_${count}" id="step8Ids_${count}"  cssClass="cCheckboxField" value="${schedule.step8}" fieldValue="${schedule.billDetail.id}-8"  disabled="${stepEditable}"/>    
       <br><br>
       <ww:if test="${Permissions8} == true">
            <c:set var="isLinkEnable" value="false" />
        </ww:if>
        <ww:else>
          <c:set var="isLinkEnable" value="true" />
        </ww:else>
        <a href="javascript:openChild('uploadStep8.html?bill.id=${bill.id}')"  onclick="return ${isLinkEnable}"><img src="images/edit.gif" border=0></a>   
         <br><br>
         <ww:if test="${schedule.step8} == true">    
         <c:set var="i" value="${i+1}" />         
         <a id="jttrigger-${i}" href="#"><img src="images/GridView.gif" border="0"></a>
			   <div id="jttip-${i}" class="jttip" style="display:none;">
				  <div class="jttipcontent" >
					 <fmt:message key='billSchedule.step8'/>:${fn:substring(schedule.check8,0,16)}<BR>
           <fmt:message key='member.name'/>:${schedule.checker8}<BR>
           </div>  
         </ww:if>         
            <ww:set name="pass" value="%{getPass('${schedule.billDetail.id}','13')}"/>             
            <div id="${schedule.billDetail.id}-8"><font color="blue">Pass</font><div>
            <script>               
                  <ww:if test="${pass} == true">
                     document.getElementById('${schedule.billDetail.id}-8').style.display = 'inline';
                  </ww:if>
                  <ww:else>
                     document.getElementById('${schedule.billDetail.id}-8').style.display = 'none';                  
                  </ww:else>                    
            </script>    
    </display:column>   

     </ww:if>
    <%--設定步驟8(後製時間)--%>
    

    <%--設定步驟9(後製)--%>
    <ww:if test="${ck9} == true">
    <ww:set name="step9column" value="%{getText('billSchedule.step9')}"/>  
    <display:column title="${step9column} <input type='checkbox' name='selectall9' onClick='javascript:selectAll(9);' ${selectPower9} />" class="results" sortable="false">
        <ww:set name="stepEditable" value="%{getRecordEditable('${schedule.billDetail.id}','14',${Permissions9})}"/>
        <ww:checkbox name="step9Ids_${count}" id="step9Ids_${count}"  cssClass="cCheckboxField" value="${schedule.step9}" fieldValue="${schedule.billDetail.id}-9"  disabled="${stepEditable}"/>              
        <br><br><br><br>
         <ww:if test="${schedule.step9} == true">   
         <c:set var="i" value="${i+1}" />         
         <a id="jttrigger-${i}" href="#"><img src="images/GridView.gif" border="0"></a>
			   <div id="jttip-${i}" class="jttip" style="display:none;">
				 <div class="jttipcontent" >
					 <fmt:message key='billSchedule.step9'/>:${fn:substring(schedule.check9,0,16)}<BR>
           <fmt:message key='member.name'/>:${schedule.checker9}<BR>
         </div>                
         </ww:if>
            <ww:set name="pass" value="%{getPass('${schedule.billDetail.id}','14')}"/>             
            <div id="${schedule.billDetail.id}-9"><font color="blue">Pass</font><div>
            <script>               
                  <ww:if test="${pass} == true">
                     document.getElementById('${schedule.billDetail.id}-9').style.display = 'inline';
                  </ww:if>
                  <ww:else>
                     document.getElementById('${schedule.billDetail.id}-9').style.display = 'none';                  
                  </ww:else>                    
            </script>   
    </display:column>    
    </ww:if>
    <%--設定步驟9(後製)--%>
    
    
    <%--設定步驟10(包裝) --%>
    <ww:if test="${ck10} == true">
     <ww:set name="step10column" value="%{getText('billSchedule.step10')}"/>  
     <display:column title="${step10column} <input type='checkbox' name='selectall10' onClick='javascript:selectAll(10);' ${selectPower10} />" class="results" sortable="false">
        <ww:set name="stepEditable" value="%{getRecordEditable('${schedule.billDetail.id}','15',${Permissions10})}"/>
        <ww:checkbox name="step10Ids_${count}" id="step10Ids_${count}"  cssClass="cCheckboxField" value="${schedule.step10}" fieldValue="${schedule.billDetail.id}-10"  disabled="${stepEditable}"/>
        <br><br><br><br>
         <ww:if test="${schedule.step10} == true">         
         <c:set var="i" value="${i+1}" />         
         <a id="jttrigger-${i}" href="#"><img src="images/GridView.gif" border="0"></a>
			   <div id="jttip-${i}" class="jttip" style="display:none;">
				 <div class="jttipcontent" >
					 <fmt:message key='billSchedule.step10'/>:${fn:substring(schedule.check10,0,16)}<BR>
           <fmt:message key='member.name'/>:${schedule.checker10}<BR>
         </div>
         </ww:if>
        <ww:set name="pass" value="%{getPass('${schedule.billDetail.id}','15')}"/>             
            <div id="${schedule.billDetail.id}-10"><font color="blue">Pass</font><div>
            <script>               
                  <ww:if test="${pass} == true">
                     document.getElementById('${schedule.billDetail.id}-10').style.display = 'inline';
                  </ww:if>
                  <ww:else>
                     document.getElementById('${schedule.billDetail.id}-10').style.display = 'none';                  
                  </ww:else>                    
            </script>
    </display:column>    
    </ww:if>
    <%--設定步驟10(包裝) --%>
    

    <%--設定步驟11(出件) --%>
    <ww:if test="${ck11} == true">
     <ww:set name="step11column" value="%{getText('billSchedule.step11')}"/>  
     <display:column title="${step11column} <input type='checkbox' name='selectall11' onClick='javascript:selectAll(11);' ${selectPower11} />" class="results" sortable="false">
       <ww:set name="stepEditable" value="%{getRecordEditable('${schedule.billDetail.id}','17',${Permissions11})}"/>
       <ww:checkbox name="step11Ids_${count}" id="step11Ids_${count}"  cssClass="cCheckboxField" value="${schedule.step11}" fieldValue="${schedule.billDetail.id}-11"  disabled="${stepEditable}"/>              
       <br><br>
       <ww:if test="${Permissions11} == true">
            <c:set var="isLinkEnable" value="false" />
        </ww:if>
        <ww:else>
           <c:set var="isLinkEnable" value="true" />
        </ww:else>      
        <a href="javascript:openChild('uploadStep11.html?bill.id=${bill.id}')" onclick="return ${isLinkEnable}"><img src="images/edit.gif" border=0></a>     
    
        <br><br>
        <ww:if test="${schedule.step11} == true">         
         <c:set var="i" value="${i+1}" />         
         <a id="jttrigger-${i}" href="#"><img src="images/GridView.gif" border="0"></a>
			   <div id="jttip-${i}" class="jttip" style="display:none;">
				 <div class="jttipcontent" >
					 <fmt:message key='billSchedule.step11'/>:${fn:substring(schedule.check11,0,16)}<BR>
           <fmt:message key='member.name'/>:${schedule.checker11}<BR>
           <fmt:message key='billSchedule.sendMethod'/>:${schedule.isSend}<BR>
           <fmt:message key='freight.name'/>:${schedule.freight.name}<BR>
           <fmt:message key='freight.no'/>:${schedule.freightNo}<BR>
           <fmt:message key='billSchedule.arrival'/>:${schedule.arrival}<BR>
         </div> 
        </ww:if>
         
            <ww:set name="pass" value="%{getPass('${schedule.billDetail.id}','17')}"/>             
            <div id="${schedule.billDetail.id}-11"><font color="blue">Pass</font><div>
            <script>               
                  <ww:if test="${pass} == true">
                     document.getElementById('${schedule.billDetail.id}-11').style.display = 'inline';
                  </ww:if>
                  <ww:else>
                     document.getElementById('${schedule.billDetail.id}-11').style.display = 'none';                  
                  </ww:else>                    
            </script>    
    </display:column>     
    </ww:if>
    <%--設定步驟11(出件) --%> 
    
    
    <%--設定步驟12(完工上傳) --%> 
    <ww:if test="${ck12} == true">    
    <ww:set name="step12column" value="%{getText('billSchedule.step12')}"/>  
    <display:column title="${step12column} <input type='checkbox' name='selectall12' onClick='javascript:selectAll(12);' ${selectPower12} />" class="results" sortable="false">
      <ww:set name="stepEditable" value="%{getRecordEditable('${schedule.billDetail.id}','19',${Permissions12})}"/>    
      <ww:checkbox name="step12Ids_${count}" id="step12Ids_${count}"  cssClass="cCheckboxField" value="${schedule.step12}" fieldValue="${schedule.billDetail.id}-12"  disabled="${stepEditable}"/>      
      <br><br>
      <ww:if test="${Permissions12} == true">
            <c:set var="isLinkEnable" value="false" />
        </ww:if>
        <ww:else>
           <c:set var="isLinkEnable" value="true" />
        </ww:else>     
      <a href="javascript:openChild('uploadStep12.html?bill.id=${row.bill.id}&billSchedule.billDetailId=${schedule.billDetail.id}')" onclick="return ${isLinkEnable}"><img src="images/edit.gif" border=0></a>                 
      <br><br>
      <ww:if test="${schedule.step12} == true">         
        <c:set var="i" value="${i+1}" />         
         <a id="jttrigger-${i}" href="#"><img src="images/GridView.gif" border="0"></a>
			   <div id="jttip-${i}" class="jttip" style="display:none;">
				 <div class="jttipcontent" >
					 <fmt:message key='billSchedule.step12'/>:${fn:substring(schedule.check12,0,16)}<BR>
           <fmt:message key='member.name'/>:${schedule.checker12}<BR>   
           <fmt:message key='billSchedule.drawingsmemo'/>:${schedule.drawingsMemo}<BR> 
           <fmt:message key='billSchedule.drawings'/>:<a href="${ctx}/showDrawings.html?bill.id=${bill.id}&billSchedule.billDetailId=${schedule.billDetail.id}" target="_blank"  ><img src="images/photo.gif" border=0></a> <BR>
          </div> 
      </ww:if>        
            <ww:set name="pass" value="%{getPass('${schedule.billDetail.id}','19')}"/>             
            <div id="${schedule.billDetail.id}-12"><font color="blue">Pass</font><div>
            <script>               
                  <ww:if test="${pass} == true">
                     document.getElementById('${schedule.billDetail.id}-12').style.display = 'inline';
                  </ww:if>
                  <ww:else>
                     document.getElementById('${schedule.billDetail.id}-12').style.display = 'none';                  
                  </ww:else>                    
            </script>    
    </display:column>   
    
    </ww:if>    
    <%--設定步驟12(完工上傳) --%>   
    
   <%--其他 --%>   
   <display:column titleKey="billSchedule.other"> 
         <br><br><br><br>
         <c:set var="i" value="${i+1}" />         
         <a id="jttrigger-${i}" href="#"><img src="images/GridView.gif" border="0"></a>
			   <div id="jttip-${i}" class="jttip" style="display:none;">
				 <div class="jttipcontent" >
					 <fmt:message key='report.counter'/> : <a href="reportCounter.html?bill.id=${bill.id}&billSchedule.billDetailId=${schedule.billDetail.id}" target="_blank"><img src="images/report.jpg" border=0></a> <BR>
           <fmt:message key='report.construction'/> :  <a href="reportConstruction.html?bill.id=${bill.id}&billSchedule.billDetailId=${schedule.billDetail.id}" target="_blank"><img src="images/report.jpg" border=0></a><BR>
         </div> 
   </display:column>
   
   <%--其他 --%>          
   
   <display:column titleKey="common.action">
     <img src="images/Green01.jpg" border="0">
     <BR>
     <img src="images/Red01.jpg" border="0">
   </display:column>
   
    
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



 <ww:if test="${StepFlowAdmin} == true">
     document.all.StepAuthority.style.display='none';	
 </ww:if>
 <ww:else>
     document.all.StepAuthority.style.display='inline';	
 </ww:else> 
 
 
 function showTimestamp(time,name){
 	 if(time!=""){
 	   alert(time+'\n'+name);
 	}
}

</script>













