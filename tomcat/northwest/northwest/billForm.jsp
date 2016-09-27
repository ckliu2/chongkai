<%@ include file="/common/taglibs.jsp"%>
<%
System.out.println("jsp 3:"+com.base.util.Tools.getCurrentTimestamp());
%>
<ww:form name="billForm" action="saveBill" method="POST" onsubmit="onSubmit()"  enctype="multipart/form-data">
  
  <ww:hidden name="bill.id" value="${bill.id}"/>
  <ww:hidden name="billFiles.id" value="${billFiles.id}"/>
  <ww:set name="setInitialBillSchedule" value="%{setInitialBillSchedule('${bill.id}')}"/>


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
  
  <%--欄位名稱--%>
  <ww:set name="step1column" value="%{getText('billSchedule.step1')}"/>
  <ww:set name="step2column" value="%{getText('billSchedule.step2')}"/> 
  <ww:set name="step3column" value="%{getText('billSchedule.step3')}"/>
  <ww:set name="step4column" value="%{getText('billSchedule.step4')}"/>  
  <ww:set name="step5column" value="%{getText('billSchedule.step5')}"/>
  <ww:set name="step6column" value="%{getText('billSchedule.step6')}"/>
  <ww:set name="step7column" value="%{getText('billSchedule.step7')}"/>
  <ww:set name="step8column" value="%{getText('billSchedule.step8')}"/> 
  <ww:set name="step9column" value="%{getText('billSchedule.step9')}"/>
  <ww:set name="step10column" value="%{getText('billSchedule.step10')}"/> 
  <ww:set name="step11column" value="%{getText('billSchedule.step11')}"/>
  <ww:set name="step12column" value="%{getText('billSchedule.step12')}"/>  
  <ww:set name="cuticlecolumn" value="%{getText('billSchedule.cuticle')}"/>

  
  <%--Page--%>
  <ww:set name="pageIndex" value="%{getPageIndex()}"/>
  <c:set var="pageIndex" value="${pageIndex+1}" />
  <ww:set name="pageIndexName" value="%{getPageIndexName()}"/>


     
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="bill.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:window.location='billList.html'" class="cButton" value="<fmt:message key="common.back"/>" >
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
          ${bill.id} &nbsp;&nbsp;&nbsp;&nbsp; (${bill.customer.id})
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
          <span class="cLabel4">${bill.remark}</span>
        </td>
    </tr>
    
    
    
    <tr><td class="cInputCaption"><fmt:message key="billFiles.doc1"/></td>
        <td class="cInputColumn">
        <ww:if test="billFiles.doc1 != null">
            <input type="checkbox" name="removeDoc1" onclick="if (this.checked == true) document.billForm.fileDoc1.style.display='inline'; else document.billForm.fileDoc1.style.display='none';" value="<ww:property value="billFiles.doc1.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="billFiles.uploadDoc.relativeUrl"/>/<ww:property value="billFiles.id"/>/<ww:property value="billFiles.doc1.fileName"/>" target="_blank"><ww:property value="billFiles.doc1.fileName" /> (<ww:property value="billFiles.doc1.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="fileDoc1" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="billFiles.doc1Id" value="${billFiles.doc1.id}"/>
            <ww:hidden name="billFiles.doc1FileName" value="${billFiles.doc1.fileName}"/>
        </ww:if>
        <ww:else>      
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="fileDoc1" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>
        </td>
    </tr>
    
    <tr><td class="cInputCaption"><fmt:message key="billFiles.doc2"/></td>
        <td class="cInputColumn">
        <ww:if test="billFiles.doc2 != null">
            <input type="checkbox" name="removeDoc2" onclick="if (this.checked == true) document.billForm.fileDoc2.style.display='inline'; else document.billForm.fileDoc2.style.display='none';" value="<ww:property value="billFiles.doc2.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="billFiles.uploadDoc.relativeUrl"/>/<ww:property value="billFiles.id"/>/<ww:property value="billFiles.doc2.fileName"/>" target="_blank"><ww:property value="billFiles.doc2.fileName" /> (<ww:property value="billFiles.doc2.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="fileDoc2" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="billFiles.doc2Id" value="${billFiles.doc2.id}"/>
            <ww:hidden name="billFiles.doc2FileName" value="${billFiles.doc2.fileName}"/>
        </ww:if>
        <ww:else>      
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="fileDoc2" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>
        </td>
    </tr>
    
    <tr><td class="cInputCaption"><fmt:message key="billFiles.doc3"/></td>
        <td class="cInputColumn">
        <ww:if test="billFiles.doc3 != null">
            <input type="checkbox" name="removeDoc3" onclick="if (this.checked == true) document.billForm.fileDoc3.style.display='inline'; else document.billForm.fileDoc3.style.display='none';" value="<ww:property value="billFiles.doc3.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="billFiles.uploadDoc.relativeUrl"/>/<ww:property value="billFiles.id"/>/<ww:property value="billFiles.doc3.fileName"/>" target="_blank"><ww:property value="billFiles.doc3.fileName" /> (<ww:property value="billFiles.doc3.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="fileDoc3" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="billFiles.doc3Id" value="${billFiles.doc3.id}"/>
            <ww:hidden name="billFiles.doc3FileName" value="${billFiles.doc3.fileName}"/>
        </ww:if>
        <ww:else>      
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="fileDoc3" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>
        </td>
    </tr>
    
    
     <tr><td class="cInputCaption"><fmt:message key="billFiles.doc4"/></td>
        <td class="cInputColumn">
        <ww:if test="billFiles.doc4 != null">
            <input type="checkbox" name="removeDoc4" onclick="if (this.checked == true) document.billForm.fileDoc4.style.display='inline'; else document.billForm.fileDoc4.style.display='none';" value="<ww:property value="billFiles.doc4.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="billFiles.uploadDoc.relativeUrl"/>/<ww:property value="billFiles.id"/>/<ww:property value="billFiles.doc4.fileName"/>" target="_blank"><ww:property value="billFiles.doc4.fileName" /> (<ww:property value="billFiles.doc4.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="fileDoc4" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="billFiles.doc4Id" value="${billFiles.doc4.id}"/>
            <ww:hidden name="billFiles.doc4FileName" value="${billFiles.doc4.fileName}"/>
        </ww:if>
        <ww:else>      
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="fileDoc4" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>
        </td>
    </tr>
    

    <tr><td class="cInputCaption"><fmt:message key="billFiles.doc5"/></td>
        <td class="cInputColumn">
        <ww:if test="billFiles.doc5 != null">
            <input type="checkbox" name="removeDoc5" onclick="if (this.checked == true) document.billForm.fileDoc5.style.display='inline'; else document.billForm.fileDoc5.style.display='none';" value="<ww:property value="billFiles.doc5.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="billFiles.uploadDoc.relativeUrl"/>/<ww:property value="billFiles.id"/>/<ww:property value="billFiles.doc5.fileName"/>" target="_blank"><ww:property value="billFiles.doc5.fileName" /> (<ww:property value="billFiles.doc5.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="fileDoc5" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="billFiles.doc5Id" value="${billFiles.doc5.id}"/>
            <ww:hidden name="billFiles.doc5FileName" value="${billFiles.doc5.fileName}"/>
        </ww:if>
        <ww:else>      
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="fileDoc5" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>
        </td>
    </tr>
    
    <tr><td class="cInputCaption"><fmt:message key="billFiles.doc6"/></td>
        <td class="cInputColumn">
        <ww:if test="billFiles.doc6 != null">
            <input type="checkbox" name="removeDoc6" onclick="if (this.checked == true) document.billForm.fileDoc6.style.display='inline'; else document.billForm.fileDoc6.style.display='none';" value="<ww:property value="billFiles.doc6.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="billFiles.uploadDoc.relativeUrl"/>/<ww:property value="billFiles.id"/>/<ww:property value="billFiles.doc6.fileName"/>" target="_blank"><ww:property value="billFiles.doc6.fileName" /> (<ww:property value="billFiles.doc6.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="fileDoc6" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="billFiles.doc6Id" value="${billFiles.doc6.id}"/>
            <ww:hidden name="billFiles.doc6FileName" value="${billFiles.doc6.fileName}"/>
        </ww:if>
        <ww:else>      
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="fileDoc6" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>
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

    <tr><td class="cInputCaption"><font color="red"><fmt:message key="billdetail.queryfromRow.msg3"/></font></td>
        <td class="cInputColumn">
          <span class="cLabel">
          <fmt:message key="billdetail.queryfromRow1"/>: <ww:textfield name="fromRow1"  cssClass="cInputTextFieldTiny" onchange="fromRowCK();"/>~
          <fmt:message key="billdetail.queryfromRow2"/>: <ww:textfield name="fromRow2"  cssClass="cInputTextFieldTiny" onchange="fromRowCK();"/>
          </sapn>
          <input type="button" onclick="javascript:queryfromRow();" class="cButton" value="<fmt:message key="billdetail.queryfromRow.msg1"/>" >
          &nbsp;&nbsp;&nbsp;&nbsp;
          <input type="button" onclick="javascript:cleanQueryFromRow();" class="cButton" value="<fmt:message key="billdetail.queryfromRow.msg4"/>" >
        </td>
    </tr>
    
    
   <tr>
<%
System.out.println("jsp 258:"+com.base.util.Tools.getCurrentTimestamp());
%>      
<ww:set name="billdetail" value="%{getBillDetailListByBillNo('${bill.id}')}"/> 
<c:set var="count" value="1" />
<c:set var="i" value="0" />
<display:table name="billdetail" class="list"  id="row" export="false" pagesize="${GLOBAL_pagesize}" requestURI="editBill.html" sort="list"  partialList="true" size="${RESULT_SIZE}">
    <ww:set name="schedule" value="%{getBillScheduleById('${row.id}')}"/>
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column titleKey="common.id" >
       ${count+(myPageIndex*myPageSize)}       
    </display:column>  
    <display:column property="detail" sortable="true" titleKey="billDetail.detail" />
    

    <display:column titleKey="billdetail.productName" sortable="true">
       <a href="javascript:openChild('productCombine.html?productId=${row.product.id}')"  >
       ${row.product.productName}
       </a>
    </display:column>
    
   
    <display:column titleKey="billdetail.fromRow" sortable="true">
       ${row.fromRow}     
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
    <display:column title="${step1column}" class="results" sortable="true">
        <ww:set name="stepEditable" value="%{getRecordEditable('${schedule.id}','6',${Permissions1})}"/>  
        <ww:checkbox name="step1Ids_${count}" id="step1Ids_${count}"  cssClass="cCheckboxField" value="${schedule.step1}"  fieldValue="${schedule.id}*1"  disabled="true" /> 
        <a href="javascript:openChild('uploadStep1.html?bill.id=${bill.id}&${pageIndexName}=${pageIndex}&billSchedule.id=${schedule.id}')"  ><img src="images/edit.gif" border="0" id="${schedule.id}-edit-1"></a>         
        <ww:if test="${schedule.step1} == true">
        <!--
        <a href="javascript:del('${bill.id}','${schedule.id}','${row.product.productName}','${pageIndexName}','${pageIndex}')"><img src="images/GridDelete.gif" border="0"></a>        
        -->
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
          <ww:set name="pass" value="%{getPass('${schedule.id}','6')}"/>          
          <div id="${schedule.id}-1"><font color="blue">Pass</font><div>
            <script>               
                  <ww:if test="${pass} == true">
                     document.getElementById('${schedule.id}-1').style.display = 'inline';
                     document.getElementById('${schedule.id}-edit-1').style.display = 'none';
                     document.getElementById('step1Ids_${count}').style.display = 'none';                     
                  </ww:if>
                  <ww:else>
                     document.getElementById('${schedule.id}-1').style.display = 'none';                  
                  </ww:else>                    
            </script>       
    </display:column> 
    </ww:if>
    <%--設定步驟1(完成時間)--%>
    
    
    <%--設定步驟2(審核)--%>
    <ww:if test="${ck2} == true">   
     
    <display:column title="${step2column} <input type='checkbox' name='selectall2' onClick='javascript:selectAll(2);' ${selectPower2} />" class="results" sortable="true">
        <ww:set name="stepEditable" value="%{getRecordEditable('${schedule.id}','7',${Permissions2})}"/>
        <ww:checkbox name="step2Ids_${count}" id="step2Ids_${count}"  cssClass="cCheckboxField" value="${schedule.step2}" fieldValue="${schedule.id}*2"  disabled="${stepEditable}" />              
        
        <ww:if test="${Permissions2} == true">
            <c:set var="isLinkEnable" value="false" />
          </ww:if>
          <ww:else>
           <c:set var="isLinkEnable" value="true" />
        </ww:else>
        <a href="javascript:openChild('uploadStep5.html?bill.id=${bill.id}&${pageIndexName}=${pageIndex}&billSchedule.id=${schedule.id}')"  onclick="return ${isLinkEnable}"><img src="images/edit.gif" border="0" id="${schedule.id}-edit-2" ></a>     
    
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
        <ww:set name="pass" value="%{getPass('${schedule.id}','7')}"/>             
            <div id="${schedule.id}-2"><font color="blue">Pass</font><div>
            <script>               
                  <ww:if test="${pass} == true">
                     document.getElementById('${schedule.id}-2').style.display = 'inline';
                     document.getElementById('step2Ids_${count}').style.display = 'none';     
                  </ww:if>
                  <ww:else>
                     document.getElementById('${schedule.id}-2').style.display = 'none';                  
                  </ww:else>                    
            </script>  
    </display:column>  
    </ww:if>
    <%--設定步驟2(審核)--%>
    
    
    <%--設定步驟3(打樣)--%>
    <ww:if test="${ck3} == true">
      
    <display:column title="${step3column} <input type='checkbox' name='selectall3' onClick='javascript:selectAll(3);' ${selectPower3} />" class="results" sortable="true">
       <ww:set name="stepEditable" value="%{getRecordEditable('${schedule.id}','8',${Permissions3})}"/>
       <ww:checkbox name="step3Ids_${count}" id="step3Ids_${count}"  cssClass="cCheckboxField" value="${schedule.step3}" fieldValue="${schedule.id}*3"  disabled="${stepEditable}"/>              
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
			  <ww:set name="pass" value="%{getPass('${schedule.id}','8')}"/>             
            <div id="${schedule.id}-3"><font color="blue">Pass</font><div>
            <script>               
                  <ww:if test="${pass} == true">
                     document.getElementById('${schedule.billDetail.id}-3').style.display = 'inline';
                     document.getElementById('step3Ids_${count}').style.display = 'none'; 
                  </ww:if>
                  <ww:else>
                     document.getElementById('${schedule.id}-3').style.display = 'none';                  
                  </ww:else>                    
            </script>  
    </display:column>
    </ww:if>
    <%--設定步驟3(打樣)--%>
    
    
    <%--設定步驟4(設計)--%>
    <ww:if test="${ck4} == true">
    
    <display:column title="${step4column} <input type='checkbox' name='selectall4' onClick='javascript:selectAll(4);' ${selectPower4} />" class="results" sortable="true">
       <ww:set name="stepEditable" value="%{getRecordEditable('${schedule.id}','9',${Permissions4})}"/>
       <ww:checkbox name="step4Ids_${count}" id="step4Ids_${count}"  cssClass="cCheckboxField" value="${schedule.step4}" fieldValue="${schedule.id}*4"  disabled="${stepEditable}"/>              
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
				 <ww:set name="pass" value="%{getPass('${schedule.id}','9')}"/>     
            <div id="${schedule.id}-4"><font color="blue">Pass</font><div>
            <script>               
                  <ww:if test="${pass} == true">
                     document.getElementById('${schedule.billDetail.id}-4').style.display = 'inline';
                     document.getElementById('step41Ids_${count}').style.display = 'none'; 
                  </ww:if>
                  <ww:else>
                     document.getElementById('${schedule.id}-4').style.display = 'none';                  
                  </ww:else>      
            </script> 
    </display:column>    
    </ww:if>
    <%--設定步驟4(設計)--%>
    
    
    <%--設定步驟5(影製時間)--%>
    <ww:if test="${ck5} == true">
       
     <display:column title="${step5column}" class="results" sortable="true">
          <ww:set name="stepEditable" value="%{getRecordEditable('${schedule.id}','10',${Permissions5})}"/>
          <ww:checkbox name="step5Ids_${count}" id="step5Ids_${count}"  cssClass="cCheckboxField" value="${schedule.step5}" fieldValue="${schedule.id}*5"  disabled="true"/>              
         <ww:if test="${Permissions5} == true">
            <c:set var="isLinkEnable" value="false" />
          </ww:if>
          <ww:else>
           <c:set var="isLinkEnable" value="true" />
           </ww:else>
       <a href="javascript:openChild('uploadStep5.html?bill.id=${bill.id}&${pageIndexName}=${pageIndex}&billSchedule.id=${schedule.id}')"  onclick="return ${isLinkEnable}"><img src="images/edit.gif" border="0" id="${schedule.id}-edit-5" ></a>     
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
        
          <ww:set name="pass" value="%{getPass('${schedule.id}','10')}"/>        
            <div id="${schedule.id}-5"><font color="blue">Pass</font><div>
            <script>               
                  <ww:if test="${pass} == true">
                     document.getElementById('${schedule.id}-5').style.display = 'inline';
                     document.getElementById('${schedule.id}-edit-5').style.display = 'none';
                     document.getElementById('step5Ids_${count}').style.display = 'none'; 
                  </ww:if>
                  <ww:else>
                     document.getElementById('${schedule.id}-5').style.display = 'none';                  
                  </ww:else>                    
            </script> 
 
    </display:column>    

    </ww:if>
    <%--設定步驟5(影製時間)--%>
    
    
    <%--設定步驟6(對搞上傳)--%>
    <ww:if test="${ck6} == true">
       
     <display:column title="${step6column}" class="results" sortable="true">
        <ww:set name="stepEditable" value="%{getRecordEditable('${schedule.id}','11',${Permissions6})}"/>       
        <ww:checkbox name="step6Ids_${count}" id="step6Ids_${count}"  cssClass="cCheckboxField" value="${schedule.step6}" fieldValue="${schedule.id}*6"  disabled="true"/>              
        <ww:if test="${Permissions6} == true">
            <c:set var="isLinkEnable" value="false" />
        </ww:if>
        <ww:else>
           <c:set var="isLinkEnable" value="true" />
        </ww:else>        
        <a href="javascript:openChild('uploadStep6.html?bill.id=${bill.id}&${pageIndexName}=${pageIndex}&billSchedule.id=${schedule.id}')"  onclick="return ${isLinkEnable}"><img src="images/edit.gif" border="0" id="${schedule.id}-edit-6" ></a>     
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
        
           <ww:set name="pass" value="%{getPass('${schedule.id}','11')}"/>             
            <div id="${schedule.id}-6"><font color="blue">Pass</font><div>
            <script>               
                  <ww:if test="${pass} == true">
                     document.getElementById('${schedule.id}-6').style.display = 'inline';
                     document.getElementById('${schedule.id}-edit-6').style.display = 'none';
                     document.getElementById('step6Ids_${count}').style.display = 'none';
                  </ww:if>
                  <ww:else>
                     document.getElementById('${schedule.id}-6').style.display = 'none';                  
                  </ww:else>                    
            </script>
    
    </display:column>    


    </ww:if>
    <%--設定步驟6(對搞上傳)--%>
    
    
    <%--設定步驟7(輸出)--%>
    <ww:if test="${ck7} == true">
      
    <display:column title="${step7column}" class="results" sortable="true">
       <ww:set name="stepEditable" value="%{getRecordEditable('${schedule.id}','12',${Permissions7})}"/>
       <ww:checkbox name="step7Ids_${count}" id="step7Ids_${count}"  cssClass="cCheckboxField" value="${schedule.step7}" fieldValue="${schedule.id}*7"  disabled="true"/>   
       <ww:if test="${Permissions7} == true">
            <c:set var="isLinkEnable" value="false" />
        </ww:if>
        <ww:else>
          <c:set var="isLinkEnable" value="true" />
        </ww:else>
       <a href="javascript:openChild('uploadStep7.html?bill.id=${bill.id}&${pageIndexName}=${pageIndex}&billSchedule.id=${schedule.id}')"  onclick="return ${isLinkEnable}"><img src="images/edit.gif" border="0" id="${schedule.id}-edit-7" ></a>         
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
        
           <ww:set name="pass" value="%{getPass('${schedule.id}','12')}"/>             
            <div id="${schedule.id}-7"><font color="blue">Pass</font><div>
            <script>               
                  <ww:if test="${pass} == true">
                     document.getElementById('${schedule.id}-7').style.display = 'inline';
                     document.getElementById('${schedule.id}-edit-7').style.display = 'none';
                     document.getElementById('step7Ids_${count}').style.display = 'none';   
                  </ww:if>
                  <ww:else>
                     document.getElementById('${schedule.id}-7').style.display = 'none';                  
                  </ww:else>                    
            </script> 
 
    </display:column>     

    </ww:if> 
   <%--設定步驟7(輸出)--%>
   
   
   
   <%--護膜--%>

    <display:column title="${cuticlecolumn}" class="results" sortable="true">
         <c:set var="i" value="${i+1}" />
         <ww:checkbox name="ss" cssClass="cCheckboxField" value="${schedule.cuticlestep}"  disabled="true"/>   
         <a id="jttrigger-${i}" href="#"><img src="images/GridView.gif" border="0"></a>
			   <div id="jttip-${i}" class="jttip" style="display:none;">
				  <div class="jttipcontent" >
					 <fmt:message key='billSchedule.cuticle'/>:${fn:substring(schedule.cuticle,0,16)}<BR>
           <fmt:message key='member.name'/>:${schedule.cuticleer}<BR>
          </div>           
    </display:column>   
      
   <%--護膜--%>
   
   
   
    
    <%--設定步驟8(後製時間)--%>
    <ww:if test="${ck8} == true">
     
    <display:column title="${step8column}" class="results" sortable="true">
       <ww:set name="stepEditable" value="%{getRecordEditable('${schedule.id}','13',${Permissions8})}"/>
       <ww:checkbox name="step8Ids_${count}" id="step8Ids_${count}"  cssClass="cCheckboxField" value="${schedule.step8}" fieldValue="${schedule.id}*8"  disabled="true"/>    
       <ww:if test="${Permissions8} == true">
            <c:set var="isLinkEnable" value="false" />
        </ww:if>
        <ww:else>
          <c:set var="isLinkEnable" value="true" />
        </ww:else>
        <a href="javascript:openChild('uploadStep8.html?bill.id=${bill.id}&${pageIndexName}=${pageIndex}&billSchedule.id=${schedule.id}')"  onclick="return ${isLinkEnable}"><img src="images/edit.gif" border="0" id="${schedule.id}-edit-8" ></a>   
        <ww:if test="${schedule.step8} == true">    
         <c:set var="i" value="${i+1}" />         
         <a id="jttrigger-${i}" href="#"><img src="images/GridView.gif" border="0"></a>
			   <div id="jttip-${i}" class="jttip" style="display:none;">
				  <div class="jttipcontent" >
					 <fmt:message key='billSchedule.step8'/>:${fn:substring(schedule.check8,0,16)}<BR>
           <fmt:message key='member.name'/>:${schedule.checker8}<BR>
           </div>  
         </ww:if>  
         
           <ww:set name="pass" value="%{getPass('${schedule.id}','13')}"/>             
            <div id="${schedule.id}-8"><font color="blue">Pass</font><div>
            <script>               
                  <ww:if test="${pass} == true">
                     document.getElementById('${schedule.id}-8').style.display = 'inline';
                     document.getElementById('${schedule.id}-edit-8').style.display = 'none';
                     document.getElementById('step8Ids_${count}').style.display = 'none'; 
                  </ww:if>
                  <ww:else>
                     document.getElementById('${schedule.id}-8').style.display = 'none';                  
                  </ww:else>                    
            </script>       
    
    </display:column>   

     </ww:if>
    <%--設定步驟8(後製時間)--%>
    

    <%--設定步驟9(後製)--%>
    <ww:if test="${ck9} == true">
      
    <display:column title="${step9column} <input type='checkbox' name='selectall9' onClick='javascript:selectAll(9);' ${selectPower9} />" class="results" sortable="true">
        
        <ww:set name="stepEditable" value="%{getRecordEditable('${schedule.id}','14',${Permissions9})}"/>
        <ww:checkbox name="step9Ids_${count}" id="step9Ids_${count}"  cssClass="cCheckboxField" value="${schedule.step9}" fieldValue="${schedule.id}*9"  disabled="${stepEditable}"/>              
        <ww:if test="${schedule.step9} == true">   
         <c:set var="i" value="${i+1}" />         
         <a id="jttrigger-${i}" href="#"><img src="images/GridView.gif" border="0"></a>
			   <div id="jttip-${i}" class="jttip" style="display:none;">
				 <div class="jttipcontent" >
					 <fmt:message key='billSchedule.step9'/>:${fn:substring(schedule.check9,0,16)}<BR>
           <fmt:message key='member.name'/>:${schedule.checker9}<BR>
         </div>                
         </ww:if>
         
            <ww:set name="pass" value="%{getPass('${schedule.id}','14')}"/>             
            <div id="${schedule.id}-9"><font color="blue">Pass</font><div>
            <script>               
                  <ww:if test="${pass} == true">
                     document.getElementById('${schedule.id}-9').style.display = 'inline';
                     document.getElementById('step9Ids_${count}').style.display = 'none';  
                  </ww:if>
                  <ww:else>
                     document.getElementById('${schedule.id}-9').style.display = 'none';                  
                  </ww:else>                    
            </script> 
 
    </display:column>    
    </ww:if>
    <%--設定步驟9(後製)--%>
    
    
    <%--設定步驟10(包裝) --%>
    <ww:if test="${ck10} == true">
      
     <display:column title="${step10column} <input type='checkbox' name='selectall10' onClick='javascript:selectAll(10);' ${selectPower10} />" class="results" sortable="true">
        <ww:set name="stepEditable" value="%{getRecordEditable('${schedule.id}','15',${Permissions10})}"/>
        <ww:checkbox name="step10Ids_${count}" id="step10Ids_${count}"  cssClass="cCheckboxField" value="${schedule.step10}" fieldValue="${schedule.id}*10"  disabled="${stepEditable}"/>
        <ww:if test="${schedule.step10} == true">         
         <c:set var="i" value="${i+1}" />         
         <a id="jttrigger-${i}" href="#"><img src="images/GridView.gif" border="0"></a>
			   <div id="jttip-${i}" class="jttip" style="display:none;">
				 <div class="jttipcontent" >
					 <fmt:message key='billSchedule.step10'/>:${fn:substring(schedule.check10,0,16)}<BR>
           <fmt:message key='member.name'/>:${schedule.checker10}<BR>
         </div>
         </ww:if>
           
           <ww:set name="pass" value="%{getPass('${schedule.id}','15')}"/>             
            <div id="${schedule.id}-10"><font color="blue">Pass</font><div>
            <script>               
                  <ww:if test="${pass} == true">
                     document.getElementById('${schedule.id}-10').style.display = 'inline';
                     document.getElementById('step10Ids_${count}').style.display = 'none';  
                  </ww:if>
                  <ww:else>
                     document.getElementById('${schedule.id}-10').style.display = 'none';                  
                  </ww:else>                    
            </script>

    </display:column>    
    </ww:if>
    <%--設定步驟10(包裝) --%>
    

    <%--設定步驟11(出件) --%>
    <ww:if test="${ck11} == true">
       
     <display:column title="${step11column}" class="results" sortable="true">
       <ww:set name="stepEditable" value="%{getRecordEditable('${schedule.id}','17',${Permissions11})}"/>
       <ww:checkbox name="step11Ids_${count}" id="step11Ids_${count}"  cssClass="cCheckboxField" value="${schedule.step11}" fieldValue="${schedule.id}*11"  disabled="true"/>              
       <ww:if test="${Permissions11} == true">
            <c:set var="isLinkEnable" value="false" />
        </ww:if>
        <ww:else>
           <c:set var="isLinkEnable" value="true" />
        </ww:else>      
        <a href="javascript:openChild('uploadStep11.html?bill.id=${bill.id}&${pageIndexName}=${pageIndex}&billSchedule.id=${schedule.id}')" onclick="return ${isLinkEnable}"><img src="images/edit.gif" border="0" id="${schedule.id}-edit-11" ></a>     
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
        
            <ww:set name="pass" value="%{getPass('${schedule.id}','17')}"/>             
            <div id="${schedule.id}-11"><font color="blue">Pass</font><div>
            <script>               
                  <ww:if test="${pass} == true">
                     document.getElementById('${schedule.id}-11').style.display = 'inline';
                     document.getElementById('step11Ids_${count}').style.display = 'none';
                     document.getElementById('${schedule.id}-edit-11').style.display = 'none';
                  </ww:if>
                  <ww:else>
                     document.getElementById('${schedule.id}-11').style.display = 'none';                  
                  </ww:else>                    
            </script>  
    </display:column>     
    </ww:if>
    <%--設定步驟11(出件) --%> 
    
    
    <%--設定步驟12(完工上傳) --%> 
    <ww:if test="${ck12} == true">    
      
    <display:column title="${step12column}" class="results" sortable="true">
      <ww:set name="stepEditable" value="%{getRecordEditable('${schedule.id}','19',${Permissions12})}"/>    
      <ww:checkbox name="step12Ids_${count}" id="step12Ids_${count}"  cssClass="cCheckboxField" value="${schedule.step12}" fieldValue="${schedule.id}*12"  disabled="true"/>      
      <ww:if test="${Permissions12} == true">
            <c:set var="isLinkEnable" value="false" />
        </ww:if>
        <ww:else>
           <c:set var="isLinkEnable" value="true" />
        </ww:else> 
      <a href="javascript:openChild('uploadStep12.html?bill.id=${row.bill.id}&billSchedule.billDetailId=${schedule.billDetail.id}&${pageIndexName}=${pageIndex}&billSchedule.id=${schedule.id}')" onclick="return ${isLinkEnable}"><img src="images/edit.gif" border="0" id="${schedule.id}-edit-12"></a>                 
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
      
           <ww:set name="pass" value="%{getPass('${schedule.id}','19')}"/>             
            <div id="${schedule.id}-12"><font color="blue">Pass</font><div>
            <script>               
                  <ww:if test="${pass} == true">
                     document.getElementById('${schedule.id}-12').style.display = 'inline';
                     document.getElementById('${schedule.id}-edit-12').style.display = 'none';
                     document.getElementById('step12Ids_${count}').style.display = 'none';  
                  </ww:if>
                  <ww:else>
                     document.getElementById('${schedule.id}-12').style.display = 'none';                  
                  </ww:else>                    
            </script>   
    </display:column>   
    
    </ww:if>    
    <%--設定步驟12(完工上傳) --%>   
    
   <%--其他 --%>   
   <display:column titleKey="billSchedule.other"> 
         <c:set var="i" value="${i+1}" />         
         <a id="jttrigger-${i}" href="#"><img src="images/GridView.gif" border="0"></a>
			   <div id="jttip-${i}" class="jttip" style="display:none;">
				 <div class="jttipcontent" >
					 <fmt:message key='report.counter'/> : <a href="reportCounter.html?bill.id=${bill.id}&billSchedule.billDetailId=${schedule.billDetail.id}" target="_blank"><img src="images/report.jpg" border=0></a> <BR>
           <fmt:message key='report.construction'/> :  <a href="reportConstruction.html?bill.id=${bill.id}&billSchedule.id=${schedule.billDetail.id}" target="_blank"><img src="images/report.jpg" border=0></a><BR>
         </div> 
   </display:column>
   
   <%--其他 --%>   
    
    <c:set var="count" value="${count+1}" />
    
</display:table>


       
    </tr>
  </table>
  
  <select name="stepIds" id="stepIds" multiple="true"/>  
</ww:form>

<%
System.out.println("jsp 807:"+com.base.util.Tools.getCurrentTimestamp());
%>  

<script>

 function onSubmit(){
 	 mySelectAll(document.billForm.billGroupAuthorityIds);
 	 getCheckStatus();
 }
 
 
 function getCheckStatus(){ 	 	
 	<ww:set name="groupsList" value="%{getObject_BillGroupAuthorityList()}"/>  
  var colu = new Array(${fn:length(groupsList)-1})
  <c:set var="al" value="0" />
  <ww:iterator value="groupsList">
  <c:set var="key" value="${groupKey}" />
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

 
function del(billid,id,productName,pageIndexName,pageIndex){
	//alert(billid+'--'+id+'---'+productName+'---'+pageIndexName+'---'+pageIndex);
	if(confirm("<fmt:message key='common.confirmDelete1'/>"+productName+"<fmt:message key='common.confirmDelete2'/>")){
		//alert("deleteStep.html?bill.id="+billid+"&id="+id+"&pageIndexName="+pageIndexName+"&pageIndex="+pageIndex);
		window.location="deleteStep.html?bill.id="+billid+"&id="+id+"&pageName="+pageIndexName+"&pageNo="+pageIndex;
	}
}
 



function openChild(page){ 
	 lovechild = window.open(page, "uploadStep5","height=768, width=1024,resizable=yes,menubar=0,toolbar=0,location=0,directories=0,scrollbars=yes,status=0")
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

function cleanQueryFromRow(){
	var murl="editBill.html?bill.id=${bill.id}";
  window.location=murl;
}

function queryfromRow(){	
	var fromRow1=document.all.fromRow1.value;
	var fromRow2=document.all.fromRow2.value;
	var ck= fromRowCK();
	if(ck==true){
	if(fromRow1==''){
   	 alert("<fmt:message key='billdetail.queryfromRow1'/> must be required"); 
     document.all.fromRow1.value="";
     document.all.fromRow1.focus(); 
     return false;
   }
   if(fromRow2==''){
   	 alert("<fmt:message key='billdetail.queryfromRow2'/> must be required"); 
     document.all.fromRow2.value="";
     document.all.fromRow2.focus(); 
     return false;
   }   
   if( eval(fromRow1) > eval(fromRow2) ){
   	 alert("<fmt:message key='billdetail.queryfromRow.msg2'/>"); 
     return false;   	
   }   
   var murl="editBill.html?bill.id=${bill.id}&fromRow1="+fromRow1+"&fromRow2="+fromRow2;
	 //alert(url);
	 window.location=murl;
 }
}

function fromRowCK(){
	var fromRow1=document.all.fromRow1.value;
	var fromRow2=document.all.fromRow2.value;
	if(isNaN(fromRow1)){ 
     alert("<fmt:message key='billdetail.queryfromRow1'/> must be numeric"); 
     document.all.fromRow1.value="";
     document.all.fromRow1.focus(); 
     return false; 
   }
   if(isNaN(fromRow2)){ 
     alert("<fmt:message key='billdetail.queryfromRow2'/> must be numeric");
     document.all.fromRow2.value="";
     document.all.fromRow2.focus(); 
     return false; 
   }   
	return true; 
}



</script>

<%
System.out.println("jsp 901:"+com.base.util.Tools.getCurrentTimestamp());
%> 











