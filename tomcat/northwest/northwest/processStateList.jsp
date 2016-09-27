<%@ include file="/common/taglibs.jsp"%>

<table border="0" cellspacing="1" class="cContentTable">
      <tr>
        <td class="cContentTitle" ><fmt:message key="processState.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td>

        <form name="qform"  method="post" action="processStateList.html">  
        <!--      
        <fmt:message key="common.search"/><fmt:message key="common.condition"/>
         <ww:select name="condition" 

               list="conditionList"
               listKey="id"
               listValue="value"
               cssStyle="border:0px;"              
         />
         
         &nbsp;&nbsp;&nbsp;&nbsp;     
         -->
          
         <fmt:message key="common.search"/><fmt:message key="bill.id"/>:        
         <ww:textfield name="billNo" value="%{billNo}"  cssClass="cInputTextFieldShort" />
           
         &nbsp;&nbsp;&nbsp;&nbsp; 
         
          <fmt:message key="bill.flow"/>:
           <ww:select name="groupId" id="groupId" onchange="controlPanel();"
                headerKey=""
                headerValue="%{getText('common.pleaseSelect')}..."
                list="groupList"
                listKey="id"
                listValue="groupNameEn+':'+groupNameCh"  
                cssClass="cQueryFieldList"
           />
           
            &nbsp;&nbsp;&nbsp;&nbsp; 
             
             <fmt:message key="billSchedule.ischeck"/>:
             <ww:select name="xorx" 
               list="yesNoList"
               listKey="id"
               listValue="value"
               cssStyle="border:0px;"              
            />
            
        <span id="workerPanel">
            &nbsp;&nbsp;&nbsp;&nbsp; 
            <fmt:message key="billSchedule.worker"/>
            <ww:select name="billSchedule.workerId"  id="workerId"
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="workerList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
         </span>   
                  
          <input type="submit" value="<fmt:message key="common.search"/>" class="cButton" >
          
        </form> 

        </td>
      </tr>
      <tr>
        <td>
<c:set var="count" value="1" />
<display:table name="processStateList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column titleKey="common.id">
      ${count}
    </display:column>    
    
    
    <display:column titleKey="bill.id">
      <a href="editBill.html?bill.id=${row.bill.id}&billSchedule.workerId=${billSchedule.workerId}" target="_blank">
       ${row.bill.id}
      </a> 
    </display:column>   
    
    <display:column titleKey="customer.name">
      ${row.bill.customer.name}
    </display:column>    
    
    <display:column titleKey="customer.id">
      ${row.bill.customer.id}
    </display:column>  
    
    <display:column titleKey="bill.projectName">
      ${row.bill.projectName}
    </display:column> 
     
    <display:column property="bill.id" sortable="true" titleKey="bill.id" style="text-align:left"/>
    <display:column property="step1" sortable="true" titleKey="billSchedule.step1" style="text-align:left" />
    <display:column property="step2" sortable="true" titleKey="billSchedule.step2" style="text-align:left" />
    <display:column property="step3" sortable="true" titleKey="billSchedule.step3" style="text-align:left" />
    <display:column property="step4" sortable="true" titleKey="billSchedule.step4" style="text-align:left" />
    <display:column property="step5" sortable="true" titleKey="billSchedule.step5" style="text-align:left" />
    <display:column property="step6" sortable="true" titleKey="billSchedule.step6" style="text-align:left" />
    <display:column property="step7" sortable="true" titleKey="billSchedule.step7" style="text-align:left" />
    <display:column property="step8" sortable="true" titleKey="billSchedule.step8" style="text-align:left" />
    <display:column property="step9" sortable="true" titleKey="billSchedule.step9" style="text-align:left" />
    <display:column property="step10" sortable="true" titleKey="billSchedule.step10" style="text-align:left" />
    <display:column property="step11" sortable="true" titleKey="billSchedule.step11" style="text-align:left" />
    <display:column property="step12" sortable="true" titleKey="billSchedule.step12" style="text-align:left" />
    
    <display:column titleKey="billSchedule.worker">
     <ww:set name="myworker" value="%{worker('${row.worker}')}"/>
     ${myworker} 
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
<form name="form1" action="saveProcessState.html">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="processState.id" value="">
    <select name="selectedProcessStateIds" multiple="true" style="display:none"></select>
</form>



<script>
  function controlPanel(){  	 
  	 var group=document.getElementById('groupId').value;
  	 if(group!=6){
  	    document.getElementById('workerPanel').style.display="None";
  	 }else{
  	 	  document.getElementById('workerPanel').style.display="";
  	 }
  }
  
  controlPanel();
</script>
